package com.bitcamp.op.member.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.op.member.domain.MemberLoginRequest;
import com.bitcamp.op.member.service.MemberLoginService;

@Controller
@RequestMapping("/member/login")
public class MemberLoginController {

	@Autowired
	private MemberLoginService loginService;
	
	@GetMapping
	public String getLoginForm() {
		return "member/loginform";
	}
	
	public String login(
				MemberLoginRequest loginRequest,
				HttpSession session,
				HttpServletResponse response
				) throws Exception {
		//System.out.println(loginRequest);
		
		
		//service의 메소드는 view의 정보를 반환한다.
		//실패했을 때 view
		//성공했을 때 view : redirect
		
		return  loginService.login(loginRequest, session, response);
	}
	
	@ExceptionHandler(LoginInvalidException.class)
		public String loginFail(LoginInvalidException e) {
			return"error/loginFail";
		}
	
}
