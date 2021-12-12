<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//cookiebox이용 > Id를 저장 > 다른페이지에 이동했을때 로그인유무를 판단
	//사용자 요청정보 : id, pw를 받아서 쿠키에 저장
	//id, pw값이 일치할때 저장
	
	//데이터받기
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String saveId = request.getParameter("saveId");
	
	//id,pw값이 일치할때 저장 : 로그인 처리가 되는것
	if(id.equals(pw)){
		response.addCookie(CookieBox.createCookie("LOGIN", "SUCCESS", -1, "/")); //-1은 세션이 닫힐때까지 유지한다는뜼
		//	http://localhost:8080/.....
		response.addCookie(CookieBox.createCookie("ID", id, -1, "/"));
	
	
%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>로그인 되었습니다.</h1>
	<h3><a href="/first/cookie/member/mypage.jsp">mypage</a></h3>
</body>
</html>
<%	} else {%>
<script>
	alert('로그인 실패!!');
	history.go(-1);
</script>
<%	} %>
		