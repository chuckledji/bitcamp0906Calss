package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFormCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		//결과데이터 필요없다
		//request속성에 저장도 안함
		return "/WEB-INF/views/member/loginform.jsp";
	}

}
