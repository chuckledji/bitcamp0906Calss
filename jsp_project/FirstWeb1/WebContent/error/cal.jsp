<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="errorpage.jsp" %>		<!-- 에러발생시 이 페이지로 이동한다. -->
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= 100/0 %>	<!-- 500에러 남. -->
</body>
</html> 