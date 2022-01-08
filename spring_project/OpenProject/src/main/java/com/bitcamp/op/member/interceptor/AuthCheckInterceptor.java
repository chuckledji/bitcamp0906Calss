package com.bitcamp.op.member.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthCheckInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession(false);
		
		//세션확인하고 -> 속성에 loginInfo가 존재하면 true반환
		if(session != null && session.getAttribute("loginInfo")!=null) {
			return true;
		}
		
		//세션확인하고 -> 속성에 loginInfo가 존재하지않으면 false반환
		//로그인 페이지로 이동 :referer 파라미터에 요청했던 URL 전달
		String url = request.getRequestURL().toString();
		
		response.sendRedirect(request.getContextPath()+"/member/login?referer="+request.getRequestURL().toString());
		
		return false;
	}
}
