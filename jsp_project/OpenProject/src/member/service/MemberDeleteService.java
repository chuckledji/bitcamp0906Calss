package member.service;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;
import member.dao.MemberDao;
import member.domain.Member;
import member.exception.MemberNotFoundException;

public class MemberDeleteService {
	
	private MemberDeleteService() {}
	private static MemberDeleteService service = new MemberDeleteService();
	public static MemberDeleteService getInstance() {
		return service;
	}
	
	//사용자의 요청 idx를 받아서 삭제 결과 반환
	public int deleteMember(HttpServletRequest request, HttpServletResponse response) throws SQLException, MemberNotFoundException {
		
		int resultCnt = 0;
		
		//1. idx로 회원 존재유무 확인, 파일이름을 삭제시 사용
		//	 ->존재X일 경우, MemberNotFoundException
		//   ->존재O일 경우, 행을 삭제하는 sql로 행 삭제, 파일 확인 후 삭제
		
		String idx = request.getParameter("idx");
		
		Member member = null;
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			member = MemberDao.getInstance().selectByIdx(conn, Integer.parseInt(idx));
			
			//회원정보가 존재하지 않으면 예외 발생
			if(member == null) {
				throw new MemberNotFoundException(idx);
			}
			
			//여기까지 문제가 없다면 삭제하고자 하는 회원이 존재하는 것 : delete, remove
			
			resultCnt = MemberDao.getInstance().deleteMemberByIdx(conn, Integer.parseInt(idx));
			
			//회원의 프로필사진을 삭제
			//시스템경로
			String uploadURI = "/uploadfile";
			String saveDir = request.getSession().getServletContext().getRealPath(uploadURI);
			//File 객체 생성(파일이 있는지 확인을 하려고)
			if(member != null && member.getPhoto().contentEquals("doh1.png")) {
				File delFile = new File(saveDir, member.getPhoto());
				//저장공간에 파일이 존재하는지 확인
				if(delFile.exists()) {
					delFile.delete();	//존재하면 파일 삭제
				}
			}
			
			
		}finally {
			JdbcUtil.close(conn);
		}
		
		return resultCnt;
	}
}
