package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GreetingCommandImpl implements Command{

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response){
		
		System.out.println("Greeting");
		
		//사용자요청처리
		//JDBC, 데이터분석, 다른서버의 API처리
		String str =" 안녕하세요";
		
		//결과데이터를 request속성에 저장
		request.setAttribute("result", str);
		
		//view지정
		String viewPage = "/WEB-INF/views/greeting.jsp";
		
		return viewPage; //viewPage경로를반환
	}
	
}
