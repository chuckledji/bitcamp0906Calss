package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.User;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.domain.Member;
import member.domain.RegRequest;

public class MemberRegServiceOld {
	
	//Service클래스도 메소드만 있는 클래스다! -> 싱글톤처리하자
	private MemberRegServiceOld() {
		
	}
	private static MemberRegServiceOld regService = new MemberRegServiceOld();
	public static MemberRegServiceOld getInstance() {
		return regService;
	}
	//사용자가 전달한 요청 데이터를 받아서 Dao insert로 전달
	//입력 결과 데이터 반환하는 메소드, 사용자 요청처리, 응답처리
	
	public int insertMember(HttpServletRequest request, HttpServletResponse response) {
		
		//결과생성
		//Connection객체 생성 -> Dao.insertMember(conn, Member)
		
		//데이터받기
		String userid = request.getParameter("userid");
		String pw = request.getParameter("pw");
		String username = request.getParameter("username");
		
		//RegRequest regRequest = new RegRequest(userid, pw, username);	//(파일업로드편변경으로인해 주석)
 		
		Member member = null;
		//member = regRequest.getMemeber();		//(파일업로드편변경으로인해 주석)
		//Dao호출

		Connection conn = null;
		int resultCnt =0;
		try {
			conn = ConnectionProvider.getConnection();
			//resultCnt = MemberDao.getInstance().insertMember(conn, member);	//(파일업로드편변경으로인해 주석)
			//resultCnt = MemberDao.getInstance().insertMember(conn, regRequest.getMemeber());
		} catch (SQLException e){
			resultCnt = -1;
		 e.printStackTrace();
		}
		return resultCnt;
	}
}
