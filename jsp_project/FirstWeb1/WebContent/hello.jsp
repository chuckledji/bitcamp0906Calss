<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		// java 코드를 작성 : 스크립트인
		
		//java.util.Date now1 = new java.util.Date();
		Date now1 = new Date();
	
	
	%>
	<h1><%=now1	%></h1>
	<%= LocalDateTime.now() %>
	<h1>처음작성한 jsp파일</h1>
</body>
</html>