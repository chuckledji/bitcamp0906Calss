package dept.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.dao.DeptDao;
import dept.domain.Dept;
import jdbc.ConnectionProvider;
import jdbc.util.JdbcUtil;

public class DeptListCommandImpl implements Command{

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		//화면에 출력할 LIST를 구해서 view로 전달한다 : List<Dept>
		List<Dept> list = null;						//예외처리를 위해 변수로 만든다.
		//DeptDao dao = null;
		Connection conn = null;
		 
		try {
			
			//Connection 객체 생성
			conn = ConnectionProvider.getConnection();
			
			//DAO객체
			//dao = DeptDao.getInstance();
			
			list = DeptDao.getInstance().selectAll(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}
		
		//결과를 request 속성에 저장
		request.setAttribute("deptList", list);
		System.out.println(list);
		 
		return "/WEB-INF/views/dept/list.jsp";	//뷰로 전달!
	}

}
