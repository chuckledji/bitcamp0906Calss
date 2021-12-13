package loginTest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginTest extends HttpServlet{
	
	//데이터처리를 하고 view페이지로 포워딩을 해준다.
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Object result = null;
		String viewPage = "WEB-INF/loginTest1/loginView.jsp";
		
		//사용자의 입력 데이터를 받는다.
		String uid = request.getParameter("id");
		String upw = request.getParameter("pw");
		
		if(uid.equals(upw)) {
			//로그인성공?
			String login = "로그인성공\n아이디 : "+uid+" / 비밀번호 : "+upw; 
			request.setAttribute("result", login);
			viewPage = "WEB-INF/loginTest1/mypage.jsp";
		}else if(!(uid.equals(upw))){
			result = "일치하는 정보가 없습니다. 다시 입력해주세요.";
			viewPage = "WEB-INF/loginTest1/misInfo.jsp";
		}else {
			result = "Invalid Request";
			
		}
		
		//request 객체 속성에 저장
		request.setAttribute("result", result);
		
		//view페이지 지정 > 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
	
	
}
