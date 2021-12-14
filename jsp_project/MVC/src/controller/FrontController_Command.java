package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BadRequestCommandImpl;
import service.Command;
import service.DateCommandImpl;
import service.GreetingCommandImpl;

public class FrontController_Command extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 사용자 요청받기
		doProcess(request, response);	
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 사용자 요청받기
		doProcess(request, response);	
	}
	
	
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//[URI 이용한 분석]
		
		//2. 사용자의 요청을 분석 
		
		String commandURI = request.getRequestURI();
		//http://localhost:8080/mvc/simple => commandURI => /mvc/simple.do
		//http://localhost:8080/mvc/greeting => commandURI => /mvc/greeting.do
		
		
		if(commandURI.startsWith(request.getContextPath())) {						//request.getContextPath() = /mvc
			commandURI = commandURI.substring(request.getContextPath().length());	// /simple.do를 뽑을 수 있다.
		}
		//http://localhost:8080/mvc/simple => commandURI => /simple.do
		//http://localhost:8080/mvc/greeting => commandURI => /greeting.do
		
		
		
		//3. 사용자 요청에 맞는 데이터 처리 : 요청에 따른 분기
		//	  결과 데이터를 생성
		
		Command command = null;
		
		//String viewPage = "/WEB-INF/views/simpleview.jsp";
		
		if(commandURI.equals("/member/greeting.do")) {
			//result = "안녕하세요"; 
			//viewPage = "/WEB-INF/views/greeting.jsp";
			command = new GreetingCommandImpl();
			
		} else if(commandURI.equals("/date.do")) {
			//result = new Date();  
			//viewPage = "/WEB-INF/views/date.jsp";
			command = new DateCommandImpl();
			
		} else { 							// /*.do
			//result = "Invalid Request";
			command = new BadRequestCommandImpl();
		}
		
		//4. 결과를 request객체의 속성에 저장한다 : view페이지에 결과 데이터를 공유(전달)한다.
		//request.setAttribute("result", result);
		
		String viewPage = command.getPage(request, response);
		
		//5. view페이지를 지정(선택)하고 -> 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);	//절대경로와는 다른것! 다시듣기
		dispatcher.forward(request, response);		
		
		
	}
	
	
}
