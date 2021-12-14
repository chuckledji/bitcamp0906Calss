package service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateCommandImpl implements Command{

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response){
		
		System.out.println("Date");
		
		//사용자요청처리
		//JDBC, 데이터분석, 다른서버의 API처리
		Date now = new Date();
		
		//결과데이터를 request속성에 저장
		request.setAttribute("result", now);
		
		//view지정
		String viewPage = "/WEB-INF/views/date.jsp";
		
		return viewPage; //viewPage경로를반환
	}
	
}
