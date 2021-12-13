package first;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Helloservlet")
public class Helloservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("Get 요청 처리!!!");
		
		response.getWriter().println("<html>");
		response.getWriter().println("<head>");
		response.getWriter().println("<title>Servlet</title>");
		
		Date now = new Date();
		
		response.getWriter().println("</head>");
		response.getWriter().println("<body>");
		response.getWriter().println("<h1>Get Request !!!"+now+"</h1>");
		response.getWriter().println("</body>");
		response.getWriter().println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
