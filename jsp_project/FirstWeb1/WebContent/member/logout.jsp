<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//로그아웃 : session객체를 소멸! -> 속성값도 함께 소멸된다.
	session.invalidate();
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그아웃되었습니다.</h1>
	<h3> <a href="mypage.jsp">mypage</a> 이동</h3>
	
	<h3>request 객체속성값 : <%= request.getAttribute("num1") %></h3>
	<h3>session 객체속성값 : <%= session.getAttribute("id") %></h3>
	<h3>application 객체속성값 : <%= application.getAttribute("num2") %></h3>

	
</body>
</html>