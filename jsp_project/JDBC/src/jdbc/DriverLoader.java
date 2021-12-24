package jdbc;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(
		//초기화가 목적
		loadOnStartup = 1,
		initParams = { 
				@WebInitParam(name = "driver", value = "com.mysql.cj.jdbc.Driver")
		})
public class DriverLoader extends HttpServlet {
	   
	public void init(ServletConfig config) throws ServletException {
		
		String driver = config.getInitParameter("driver");
		
		// DB드라이버 로드
		try {
			Class.forName("driver");
			System.out.println("mysql드라이버 로드성공");
		} catch (ClassNotFoundException e) {
			System.out.println("mysql드라이버 로드실패");
			e.printStackTrace();
		}
	}

}
