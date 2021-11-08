package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//jdbc연결 테스트
public class jdbcTestStatementSelect {
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;		//행단위로 데이터가져오는 객체
		
		//Dept저장을 위한 List<Dept>
		List<Dept> list = new ArrayList<Dept>();
		
		try {
			//1. 드라이버 로드 : 프로그램에서 한번만 실행하면 된다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
			//2. 연결 : Connection객체 얻기
			//String jdbcUrl1="jdbc:oracle:thie:@[주소]:[포트]:[데이터베이스]"//sql디벨롭퍼에 접속누르면 접속정보 볼 수 있음
			String jdbcUrl1="jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String pw = "tiger";
			
			conn = DriverManager.getConnection(jdbcUrl1, user, pw);
			
			System.out.println("데이터베이스 연결 성공!");
			
			
			//3. 작업 : CRUD -> Statement객체 생성
			stmt = conn.createStatement();			//statement구하기 -> select문과 DML사용할 수 있게된다
			
			//Sql : select
			String sql = "select * from dept order by deptno";
			
			//Sql 실행
			rs = stmt.executeQuery(sql);
			
			//반복을 통해 행단위 데이터 검색을 해온다.
			while(rs.next()) {						//다음행이 존재하는지 여부
				int deptno = rs.getInt("deptno");   //deptno컬럼을 가져온다
				String dname = rs.getString(2);
				String loc = rs.getString("loc");
				//System.out.print(deptno+"\t"+dname+"\t"+loc+"\n");
				Dept dept = new Dept(deptno, dname, loc);
				list.add(dept);
			}
			
			
			//4. 연결종료 : close()
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버클래스를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("데이터베이스에 연결할 수 없습니다. 연결실패!");
			e.printStackTrace();
		} finally {
			//예외에 상관없이 반드시 실행하는 블럭
			//실행 역순(rs>stmt>conn)으로 종료해준다.
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			
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
		System.out.println("부서리스트");
		System.out.println("부서이름 \t 부서이름 \t 위치");
		for(Dept dept : list) {
			System.out.println(dept);
			
		}
	}
	

	
}
