package dept.service;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.dao.DeptDao;
import dept.domain.Dept;
import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;

public class DeptRegCommandImpl implements Command{

	String view = null;
	
	if(request.getMethod().equals("GET")) {
		
	}else if(request.getMethod().equals("POST")) {
		//전송방식 확인
				System.out.println(request.getMethod());
	}
	
	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response)  {
		
		//전송방식 확인
		System.out.println(request.getMethod());
		
		//post방식에서 한글처리
		/*try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//사용자가 입력한 데이터를 받고
		String deptno = request.getParameter("deptno");
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		
		//Dept 객체를 생성
		Dept dept = new Dept(Integer.parseInt(deptno), dname, loc);
		
		//Dao insert 메소드로 입력처리
		Connection conn = null;	//이부분 설명 다시1109
		int regCnt = 0;
		
		try {
			conn= ConnectionProvider.getConnection();
			//결과 반환
			regCnt = DeptDao.getInstance().insertDept(conn, dept);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}
		
		
		//request 속성에 저장
		request.setAttribute("result", regCnt);
		request.setAttribute("dept", dept);
		
		view= "/WEB-INF/views/dept/reg.jsp";
	}
	return view;
}
