package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//jdbc연결 테스트
public class jdbcPreparedStatementDML {
	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
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
			
			
			//3. 작업 : CRUD -> PreparedStatement객체 생성, 먼저SQL생성후 사용
			String sql = "insert into dept values (?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 60);
			pstmt.setString(2, "DEV");
			pstmt.setString(3, "BUSAN");
			
			//DML 실행
			int resultCnt = pstmt.executeUpdate();
			
			if(resultCnt > 0) {
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
			
			if( pstmt != null) {
				try {
					pstmt.close();
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
