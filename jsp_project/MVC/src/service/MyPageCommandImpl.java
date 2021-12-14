package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyPageCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {
		
		//사용자페이지 MyPage는 로그인상태에서만 데이터처리를 해준다
		//세션체크 : session속성에 loginInfo가 존재하는지 확인
		
		boolean loginChk = request.getSession().getAttribute("loginInfo") != null;
		
		if(loginChk) {
			//결과데이터를 생성
			String msg = "마이페이지에는 사용자 정보를 출력합니다";	//DB에 갔다왔다고 가정
			//request속성에 결과데이터 저장
			request.setAttribute("msg", msg);	
		}
		request.setAttribute("loginChk", loginChk);
		
		return "/WEB-INF/views/member/mypage.jsp";
	}

}
