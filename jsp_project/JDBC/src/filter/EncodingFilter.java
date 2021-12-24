package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {

	private String encoding;				//필터와 인터셉터의 차이점, 프레임워크의 실행구조 잘 알아두기
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		//reuqest에 대한필터처리
		request.setCharacterEncoding(encoding);

		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {	//초기화
		
		this.encoding = filterConfig.getInitParameter("encoding");
		
		if(encoding == null) {
			this.encoding = "utf-8";
		}
		
	}

}
