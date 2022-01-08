package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자 요청 받기
		doProcess(request, response);	//호출
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자 요청 받기
		doProcess(request, response);	//호출
	}
	
	
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//[파라미터값을 이용한 분석]
		
		//2. 사용자의 요청을 분석 : 파라미터값을 이용해서 분석한다
		String type = request.getParameter("type");
		
		//http://localhost:8080/mvc/simple
		//http://localhost:8080/mvc/simple?type=date
		
		
		//3. 사용자 요청에 맞는 데이터 처리 : 요청에 따른 분기
		//	  결과 데이터를 생성
		
		//응답결과객체
		Object result = null;								//view페이지에서 toString()으로 출력
		//view페이지 경로
		String viewPage = "/WEB-INF/views/simpleView.jsp";	//WEB-INF 는 외부에서 보이지 않는 폴더이다.(사용자가 직접 호출할 수 없다.)
		
		if(type==null || type.equals("greeting")) {
			result = "안녕하세요";								//object타입의 참조변수에 <- String타입의 객체를 저장
			viewPage = "/WEB-INF/views/greeting.jsp";
			
		}else if(type.equals("date")) {
			result = new Date();							//object <- Date
			viewPage = "WEB-INF/views/date.jsp";
			
		}else {
			result = "Invalid Request";
		}
		
		
		//4. 결과를 request객체의 속성에 저장한다 : view페이지에 결과 데이터를 공유(전달)한다.
		request.setAttribute("result", result);
		
		
		//5. view페이지를 지정(선택)하고 -> 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);	
		dispatcher.forward(request, response);		
		
		
	}
	
	
}
