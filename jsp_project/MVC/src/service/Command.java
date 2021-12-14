package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

	//추상메소드 : public abstract
	//반환하는 데이터는 viewPage의 경로
	//내부처리 : 사용자가 요청하는 데이터처리 -> 결과 data를 request(로 전달받음)의 속성에 데이터저장
	String getPage(HttpServletRequest request, HttpServletResponse response);
}
