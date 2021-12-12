package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/SignupServlet","/SignUpServlet"})
public class SignupServlet extends HttpServlet {
		

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//post방식으로 데이터를 받을 때 한글 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		//데이터받기
		String uid = request.getParameter("userid");
		String pw = request.getParameter("pw");
		String pw2 = request.getParameter("pw2");
		String uname = request.getParameter("userName");
		String comment = request.getParameter("comment");
		String gender = request.getParameter("gender");
		String[] interests = request.getParameterValues("interest");
		String byear = request.getParameter("byear");
		
		//응답하는 데이터의 타입
		response.setContentType("text/html; charset=utf-8");
		//response.setContentType("application/doc; charset=utf-8"); 브라우저에서 응답할 수 없는 타입이라 그냥 다운로드 받아버림
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<h1>");
		out.println("		User ID: " + uid + "<br>");
		out.println("		PW: " + pw + "<br>");
		out.println("		Name: "+ uname + "<br>");
		out.println("		Comment: "+ comment + "<br>");
		out.println("		Gender: "+ gender + "<br>");
		
		if(interests != null) {
		for(int i=0; i<interests.length; i++) {
			out.println("		Interest: "+ interests[i] + "<br>");
			}
			out.println("	</h1>");
			out.println("</html>");
		}else {
		out.println("선택한 관심사가 없습니다."+"<br>");
		}
		
		out.println("		B-year: "+ byear + "<br>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
