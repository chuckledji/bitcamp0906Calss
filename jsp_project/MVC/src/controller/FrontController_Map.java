package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import service.BadRequestCommandImpl;
import service.Command;
import service.DateCommandImpl;
import service.GreetingCommandImpl;

public class FrontController_Map extends HttpServlet{

	private Map<String, Command> commands = new HashMap<String, Command>();
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		System.out.println("서블릿이 생성될때 한번 실행합니다. -> 초기화처리합니다!");
		
		//설정파일에 init-param 설정된 경로 가져오기
		String configFile = config.getInitParameter("configPath");

		//시스템경로(실제경로)
		String configPath = config.getServletContext().getRealPath(configFile);
		
		//프로퍼티(Map에서 파생된 클래스)파일생성
		//파일 -> 객체
		Properties prop = new Properties();
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(configPath);
		
			//파일 -> 객체 Properties
			prop.load(fis);
			
			fis.close();	//stream을 닫아줌
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Iterator<Object> itr = prop.keySet().iterator();
		
		while(itr.hasNext()) {
			
			String command = (String)itr.next();
			String commandClassName = prop.getProperty(command);
			
			System.out.println(command +":"+ commandClassName);
			
			//commands Map에 command(key), commandClassName의 인스턴스를 저장
			
			//commandClassName 이름의 클래스로 인스턴스를 생성 -> Class클래스를 이용
			
			try {
				//클래스 이름(full name)으로 인스턴스생성
				Class commandClass = Class.forName(commandClassName);
				
				//인스턴스생성
				Command commandObj = (Command)commandClass.newInstance();
					
				//commands Map에 <요처ㅇ, 객체> 저장
				commands.put(command, commandObj);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		
		//Command 설정
		//commands.put("/date.do", new DateCommandImpl());
		//commands.put("/member/greeting.do", new GreetingCommandImpl());
		
		System.out.println("초기화된 요청 : " + commands.size());
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);	
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);	
	}
	
	
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//[URI 이용한 분석]
		//2. 사용자의 요청을 분석 
		
		String commandURI = request.getRequestURI();
		
		if(commandURI.startsWith(request.getContextPath())) {						//request.getContextPath() = /mvc
			commandURI = commandURI.substring(request.getContextPath().length());	// /simple.do를 뽑을 수 있다.
		}
		
		
		//3. 사용자 요청에 맞는 데이터 처리 : 요청에 따른 분기
		//	  결과 데이터를 생성
		
		Command command = commands.get(commandURI);
		if(command == null) {
			command = new BadRequestCommandImpl();
		}
		
		
	
		//4. 결과를 request객체의 속성에 저장한다 : view페이지에 결과 데이터를 공유(전달)한다.
	
		String viewPage = command.getPage(request, response);
		
		//5. view페이지를 지정(선택)하고 -> 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
		
	}
	
	
}
