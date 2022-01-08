package com.bitcamp.op.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.dao.MemberDao;
import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.member.domain.MemberRegRequest;
import com.bitcamp.op.service.CommonsData;

@Service
public class MemberRegService {
	
	@Autowired
	private MemberDao dao;												//싱글톤코드를 생략했기때문에 의존 주입해야한다.
	
	
	public int insertMember(MemberRegRequest regRequest, HttpServletRequest request) throws IllegalStateException, IOException, SQLException {
		
		int resultCnt = 0;
		
		//기본이미지 설정
		regRequest.setFileName("homer.png");	
		
		//DB관련 예외 발생시 삭제 처리를 위한 file객체 변수 선언 
		File newFile = null;
		
		//파일이 있다면 -> 파일 저장 
		if(!regRequest.getPhoto().isEmpty() && regRequest.getPhoto().getSize()>0) {
			//시스템 경로
			String savePath =request.getSession().getServletContext().getRealPath(CommonsData.SAVE_URI);
			
			//사진 파일이름 만들기
			String[] files = regRequest.getPhoto().getOriginalFilename().split("\\.");
			String exet = files[files.length-1];
			String newFileName = System.nanoTime()+ exet;
			
			newFile = new File(savePath, newFileName);
			
			regRequest.getPhoto().transferTo(newFile);					//저장 안됐을 시 declaration으로 넘어갑니다.
			
			regRequest.setFileName(newFileName);
		}
		
		//DAO를 이용해서 데이터 베이스 처리
		Connection conn = null;
		
		try {															//trycatch하는 이유 : 불필요한 데이터가 쌓이므로 여기서 커넥션을 닫아야해서? 다시듣기
			conn = ConnectionProvider.getConnection();							
			resultCnt = dao.insertMember(conn, regRequest);
			
		} catch (SQLException e) {
			
			// 파일이 저장된 후 DB관련 예외가 발생했을 때 : 저장했던 파일을 삭제
			if(newFile != null && newFile.exists()) {
				newFile.delete();
			}
			e.printStackTrace();
			throw e;													//예외는 컨트롤러에서 처리할 수 있도록 던져준다.
		}
		
		return resultCnt;
	}
}
