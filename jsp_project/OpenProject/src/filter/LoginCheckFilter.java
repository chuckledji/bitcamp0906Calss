package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {

	@Override
	public void destroy() {
			
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//요청일 때 처리
		//로그인 체크하고,
		//->비로그인상태이면 로그인폼페이지로이동
		//->로그인상태이면 정상적으로 요청을 처리
		
		//로그인 상태 체크
		//: HttpSession객체의 속성에 loginInfo 이름의 속성이 존재하는지 체크
		
		HttpSession session = ((HttpServletRequest)request).getSession();
		
		if(session != null && session.getAttribute("loginInfo")!= null) {
			//로그인상태이다! -> 정상처리
			chain.doFilter(request, response);	
		}else {
			//비로그인 상태이므로  -> 로그인페이지로 이동시킴
			String uri = ((HttpServletRequest)request).getContextPath()+"/member/login.do";
			((HttpServletResponse)response).sendRedirect(uri);
		}
		
	
		
		//사용자 요청을 처리하고 응답하기 전에 처리
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
			//초기화목적
		
	}

}
