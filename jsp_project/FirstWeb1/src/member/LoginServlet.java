package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//오노테이션 : 자바문법아니고, 주석도아니다. 추가적인 처리를 해주는 약속 
//http:// localhost:8080/First/login
//http:// localhost:8080/First/Login
@WebServlet({ "/Login", "/login" })

public class LoginServlet extends HttpServlet {
       
    //사용자가 요청할 때 Get방식을 요청했을때 처리되는 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//request  : 사용자의 요청 데이터 처리
		//response : 사용자에게 응답할 데이터 처리
		
		//사용자가 입력한 userid, pw를 받아서 응답 메세지에 포함해서 처리(name="userid"부분)
		String uid = request.getParameter("userid");
		String pw = request.getParameter("pw");
		System.out.println("userid : " + uid);
		System.out.println("password : " + pw);

		
		//문자열을 출력, 요청한 쪽으로 응답
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>파라미터 데이터 받기</title></head>");
		out.println("	<body>");
		out.println("		<h1>");
		out.println("			userid : " + uid + "<br>");
		out.println("			password : " + pw + "<br>");
		out.println("		</h1>");
		out.println("	</body>");
		out.println("</html>");

		
	}

	//사용자가 요청할때 Post방식으로 요청했을 때 처리되는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
