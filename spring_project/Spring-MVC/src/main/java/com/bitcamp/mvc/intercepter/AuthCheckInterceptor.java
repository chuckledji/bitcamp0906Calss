package com.bitcamp.mvc.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthCheckInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("AuthCheckInterceptor : preHandle()");
		
		HttpSession session = request.getSession(false);	//객체 없을시 null
		
		String url = request.getHeader("referer");			// http://localhost:8080/mvc/
		System.out.println(url);							
		
		String url1 = new String(request.getRequestURL());	// http://localhost:8080/mvc/mypage/help/intro
		System.out.println(url1);
		
		//로그인 상태 체크
		if(session != null && session.getAttribute("loginInfo") != null) {
			//로그인상태임을 의미
			return true;
		}
		
		response.sendRedirect(request.getContextPath()+"/member/login?url="+url1);
		//response에 있는 sendRedirect는 serverRoot로 (콘텍스트보다 앞선 서버루트로)
		//컨트롤러에 응답하는 뷰 네임에서 리다이렉트를 쓸 때에는 콘텍스트 경로 제외하고 그 뒤쪽에 오는 경로를 기준으로 잡았다.
		
		return false;
	}



	
	
}
