package service;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.LoginInfo;

public class LoginCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		//로그인처리
		//id==pw > 로그인성공으로 간주 -> 결과를 boolean loginChk속성으로 저장
		//사용자입력데이터받기
		
		//post요청시 한글처리 필요
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String uid = request.getParameter("uid");
		String pw = request.getParameter("pw");
		
		boolean loginChk = false;
		
		//Dao의 회원정보를 select ->회원데이터를 얻을수있다.
		
		if(uid.equals(pw)) {
			//로그인성공으로 간주
			loginChk = true;
			
			//로그인정보를 저장 : session
			LoginInfo info = new LoginInfo(uid, "임의사용자이름", "임의사용자닉네임", "임의사용자이메일");
			HttpSession session = request.getSession();
			session.setAttribute("loginInfo", info);
			
		}else {
			//로그인실패
		}
		
		//속성에 두가지 결과를 저장한다
		//1.결과페이지에 보여지는 값
		request.setAttribute("loginChk", loginChk);
		
		//2.로그인정보를 저장
		
		return "/WEB-INF/views/member/login.jsp";
	}

}
