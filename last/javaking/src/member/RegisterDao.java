package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegisterDao {
	public static Scanner sc = new Scanner(System.in);
	
	//회원가입정보
	
	
	
	//회원정보 입력메소드
	public Users insertUser () {
		Users users = null;
		
		System.out.println("회원정보입력을 시작합니다.");
		System.out.println("이름: >");
		String name = getString();
		System.out.println();
		
		
		
		
		
		return users;
		
	}
	
	private String getString() {
		String result = null;
		while(true) {
			result = sc.nextLine();
			result = result.trim();
			if(result.length()==0) {
				System.out.println("공백없이 입력해주세요.");
			}else {
				break;
			}
		}
		return result;
	}
	
	
	
	//회원정보 DB생성메소드
	public int inputUsersDb(Connection conn, Users users) {
		PreparedStatement pstmt = null;
		int resultCnt = 0;
		
		String sql = "insert into users values(users_seq.nextval, ?, ?, ?, ?, ?, ?)";  		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, users.getUserid());
			pstmt.setString(2, users.getUsername());
			pstmt.setString(3,users.getPassword());
			pstmt.setString(4, users.getPassword());
			pstmt.setString(5, users.getPhone());
			pstmt.setString(6, users.getEmail());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
		}
		return resultCnt;
	}
	
	//방금 생성한 id를 변수에 저장하고 리턴하는 메소드
	
	
	//회원정보를 출력하는 list : 회원번호를 받아서 진행한다.
	public Users selectOneList(Connection conn, int id){
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Users users = null;
		
		String sql = "select * from users where id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			//맞는 정보를 불러온다
			if(rs.next()) {
				users = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return users;
	}
	
	
	
}
