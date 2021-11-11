package dept;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DeptMain {
public static void main(String[] args) {
		
	//DeptDao deptDao = new DeptDao();
	DeptDao deptDao = DeptDao.getInstance(); //싱글톤처리
	
	Calendar c = Calendar.getInstance();	 //이것과 같은 원리
	
	//DeptDao deptDao = new DeptDao();
	Connection conn;
	
	List<Dept>list = null;
	//Connection conn = ConnectionProvider.getConnection();// try catch문으로 감싸줘야한다.
	try {
		conn = ConnectionProvider.getConnection();
		
		//트랜젝션 일의 단위
		conn.setAutoCommit(false);			//트랜젝션의 컨트롤하겠다는 뜻
		
		
		//부서 리스트를 확인
		list = deptDao.selectAllList(conn);
		
		System.out.println("부서리스트");
		System.out.println("-----------------------");
		for(Dept dept : list) {
		System.out.println(dept);	
		}
		
		System.out.println("-----------------------");
		
		
		
		//부서 정보검색 : 부서번호로 검색
		Dept dept = deptDao.selectByDeptno(conn, 10);
		System.out.println("10번부서 : " + dept);

		System.out.println("-----------------------");
		
		
		
		//부서 정보입력 
		Dept newDept = new Dept(50, "DEV", "Seoul");		
		
		int insertCnt = deptDao.insertDept(conn, newDept);
		if(insertCnt>0) {
			System.out.println("부서정보가 입력되었습니다.");
		}else {
			System.out.println("입력실패");
		}
		
		
		conn.commit();  // 완료
		
		
		System.out.println("입력 결과 : "+ deptDao.selectByDeptno(conn, 50));
		System.out.println("-----------------------");
		
		
		
		//부서 정보수정
		Dept editDept = new Dept(50, "Design", "BUSAN");
		int editCnt = deptDao.editDept(conn, editDept);
		if(editCnt >0) {
			System.out.println("정보가 수정되었습니다.");
		}else {
			System.out.println("수정실패/ 조건에 맞는 데이터가 존재하지 않습니다.");
		}
		System.out.println("수정 결과 : "+ deptDao.selectByDeptno(conn, 50));
		System.out.println("-----------------------");
		
		
		
		//부서 정보삭제 : deptno(PK)기준 삭제
		int delCnt = deptDao.deleteDept(conn, 50);
		System.out.println("삭제 결과 : "+ deptDao.selectByDeptno(conn, 50)); //데이터가없으면 null이 나올 것
		
		
		
	} catch (SQLException e) {
		
		
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

}
}
