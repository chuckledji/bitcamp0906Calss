package examEmp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpDao {

//	empno 	num
//	ename 	String
//	job	String
//	mgr	num
//	hiredate 	date
//	sal	num
//	comm	num
//	deptno	num
	
	
	//	1. 입력)EMP 테이블에 새로운 사원 정보를 입력하는 프로그램을 작성해보자. 
	public int insertEmp(Connection conn, Emp emp) {
		
		PreparedStatement pstmt = null;
		
		int resultCnt=0;				//입력이 됐는지 안됐는지 체크하는 변수
		
		String sql = "insert into emp values(?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getEname());
			pstmt.setString(3, emp.getJob());
			pstmt.setInt(4, emp.getMgr());
			pstmt.setDate(5, emp.getHiredate());
			pstmt.setInt(6, emp.getSal());
			pstmt.setInt(7, emp.getComm());
			pstmt.setInt(8, emp.getDeptno());
			
			resultCnt = pstmt.executeUpdate();
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
		}
		return resultCnt;
	}
	
//	2. 출력)EMP 테이블의 모든 데이터를 출력하는 프로그램을 작성해보자.
	public List<Emp> selectAllList(Connection conn){
		Statement stmt = null;
		ResultSet rs = null;
		List<Emp> result = new ArrayList<Emp>();
		
		try {
			stmt = conn.createStatement();
			
			String sql = "select * from emp";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				result.add(new Emp(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4),  
						rs.getDate(5), rs.getInt(6), rs.getInt(7), rs.getInt(8)));
			}
		} catch (SQLException e) {
			System.out.println("예외");
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		
		return result;
	}
	
//	3. 수정)EMP 테이블에 서 “SCOTT” 사원의 급여(sal) 정보를 1000으로 바꾸는 프로그램을 작성해보자.
	public int editSalOfEname(Connection conn, Emp emp) {
		PreparedStatement pstmt = null;
		
		int resultCnt = 0;
		
		String sql = "Update emp set sal=? where ename=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, emp.getSal());
			pstmt.setString(2, emp.getEname());
			
			resultCnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt);
		}
		return resultCnt;
	}
	
//	4. 검색)EMP 테이블에서 “SCOTT” 이름으로 검색한 결과를 출력하는 프로그램을 작성해보자.
	public Emp selectByEname(Connection conn, String ename) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Emp emp = null;
		
		String sql = "select * from emp where ename =?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ename);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				emp = new Emp(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4), 
						rs.getDate(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return emp;
	}
	
//
//	5. 조인?)모든 사원정보를 출력하되 부서정보를 함께 출력하는 프로그램을 작성해보자
}
