package examEmp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmpMain {
public static void main(String[] args) {
	EmpDao empDao = new EmpDao();
	DeptDao deptDao = new DeptDao();
	
	Connection conn;
	
	List<Emp>elist = null;
	List<Dept>dlist = null;
	
	try {
		conn = ConnectionProvider.getConnection();
				
		//리스트출력
		elist = empDao.selectAllList(conn);
		
		System.out.println("부서리스트");
		System.out.println("----------------------------------");
		for(Emp emp : elist) {
			System.out.println(emp);
		}
		System.out.println("----------------------------------");
		
		//정보입력
//		Emp newEmp = new Emp(9000,"CHARSE","CLERK",1995-04-24,3000,500,10);
//		
//		int insertCnt = empDao.insertEmp(conn, newEmp);
//		if(insertCnt>0) {
//			System.out.println("사원정보가 입력되었습니다.");
//			
//		}else {
//			System.out.println("입력실패");
//		}
//		System.out.println("입력 결과 : "+empDao.selectByEname(conn, "CHARSE"));
//		
//		System.out.println("----------------------------------");
//		
		//정보 수정
		
		
		
		//정보 검색
		Emp emp = empDao.selectByEname(conn, "SCOTT");
		System.out.println("SCOTT사원의 정보 : " +emp);
		
		
		//5. 리스트출력)모든 사원정보를 출력하되 부서정보를 함께 출력하는 프로그램을 작성해보자
		elist = empDao.selectAllList(conn);
		dlist = deptDao.selectAllList(conn);
		
		System.out.println("총 정보");
		System.out.println("----------------------------------");
		for(Emp emp1 : elist) {
			for(Dept dept : dlist) {
				if(emp1.getDeptno() == dept.getDeptno()) {
					
					System.out.println(emp1+" "+dept.getDname() +" "+ dept.getLoc());
				}
			}
		}
		System.out.println("----------------------------------");
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
}
