package com.bitcamp.op.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.dao.MemberDao;
import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.jdbc.JdbcUtil;
import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.domain.MemberLoginRequest;

@Service
public class MemberLoginService {
	
	@Autowired
	private MemberDao dao;
	
	public String login(
				MemberLoginRequest loginRequest,
				HttpSession session,
				HttpServletResponse response
				) throws Exception {
		
		String viewName = null;
		
		Connection conn = null;
		
		Member member = null;
		
		try {
		conn = ConnectionProvider.getConnection();
		member = dao.selectByIdPw(conn, loginRequest.getUid(), loginRequest.getPw());
		if(member == null) {
			throw new Exception("아이디 또는 비밀번호가 없습니다.");
		}
		
		//로그인처리와 viewName을 정의, 쿠키 처리
		//로그인 : session속성에 데이터 저장
		session.setAttribute("loginInfo", member.getLoginInfo());
		
		//id 저장하기 체크처리 :checked상태 -> "on" ->쿠키 저장
		if(loginRequest.getSaveid()!=null && loginRequest.getSaveid().equals("on")) {
			
			Cookie c = new Cookie("saveId", loginRequest.getUid());
			response.addCookie(c);
		}
		
		if(loginRequest.getUrl().length()>0) {
			viewName = "redirect : "+loginRequest.getUrl();
		}else {
			viewName = "redirect:/"; 						//컨텍스트 경로의 인덱스가 들어감?
		}
		}finally {
			JdbcUtil.close(conn);
		}
		
		
		
		return viewName;
	}
}
