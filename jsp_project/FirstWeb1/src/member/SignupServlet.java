package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/SignupServlet","/SignupServlet"})
public class SignupServlet extends HttpServlet {
		

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uid = request.getParameter("userid");
		String pw = request.getParameter("pw");
		String pw2 = request.getParameter("pw2");
		String uname = request.getParameter("userName");
		
		PrintWriter out = response.getWriter();
		
		System.out.println("<html>");
		System.out.println("<h1>");
		
		System.out.println("User ID: " + uid );
		System.out.println("<br>");
		System.out.println("PW: " + pw );
		System.out.println("<br>");
		System.out.println("Name: "+ uname);
		
		System.out.println("</h1>");
		System.out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
