package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//jdbc연결 테스트
public class jdbcTestStatementDML {
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			//1. 드라이버 로드 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
			//2. 연결 : Connection객체 얻기
			//String jdbcUrl1="jdbc:oracle:thie:@[주소]:[포트]:[데이터베이스]"//sql디벨롭퍼에 접속누르면 접속정보 볼 수 있음
			String jdbcUrl1="jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String pw = "tiger";
			
			conn = DriverManager.getConnection(jdbcUrl1, user, pw);
			
			System.out.println("데이터베이스 연결 성공!");
			
			
			//3. 작업 : CRUD -> Statement객체 생성
			//statement구하기 -> select문과 DML사용할 수 있게된다
			stmt = conn.createStatement();	
			
			//sql : insert
			String sql = "insert into dept (deptno, dname, loc)values(50, 'test', 'Seoul')";
			
			int cnt = stmt.executeUpdate(sql);
			
			if(cnt >0) {
				//실행횟수가 0보다크다면
				System.out.println("입력되었습니다.");
			}else {
				System.out.println("입력실패!");
			}
			
			//4. 연결종료 : close()
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버클래스를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("데이터베이스에 연결할 수 없습니다. 연결실패!");
			e.printStackTrace();
		} finally {
			
			if( stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	
	}
	

	
}
