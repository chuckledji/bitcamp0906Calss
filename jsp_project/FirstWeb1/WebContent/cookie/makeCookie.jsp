<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 쿠키저장
	//1.쿠키객체 생성 -> 2. response.addCookie() 해서 전달
	
	Cookie cookie1 = new Cookie("engName", "Person1");
	cookie1.setMaxAge(05); //60*60*24*365 (초, 분, 시간, 일) 60*60=1시간   
	
	Cookie c = new Cookie("korName","사람1");
	
	response.addCookie(cookie1);
	response.addCookie(c);
	
	// 쿠키박스 이용
	response.addCookie(CookieBox.createCookie("uid1", "jjwID"));
	response.addCookie(CookieBox.createCookie("uid2", "lkgID", 20));
	
	
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>cookie가 저장되었습니다.</h1>
	<h3>
		<a href="viewCookie.jsp">쿠키보기</a>
	</h3>
</body>
</html>