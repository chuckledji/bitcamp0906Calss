<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//이 파일에서는 데이터처리를 하고 view페이지로 포워딩
	
	//사용자 입력 데이터 받기
	String id = request.getParameter("uid");
	String pw = request.getParameter("pw");
	
	//결과데이터 생성
	String msg = id + " : " + pw;
	
	//view페이지로 데이터를 공유하기 위해 결과데이터를 속성에 저장
	request.setAttribute("result", msg);
	
	//결과페이지를 만들 jsp페이지로 포워딩
	pageContext.forward("login_view.jsp");
%>