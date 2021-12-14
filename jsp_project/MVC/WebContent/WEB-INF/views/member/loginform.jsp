<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/default.css">
</head>
<body>

	<h1>로그인</h1>
	<hr>
	<!-- 현재경로    : http://localhost:8080/mvc/member.loginform.do -->
	<!-- 보내는경로 : http://localhost:8080/mvc/member.login.do -->
	<form action="login.do" method="post"><!-- 상대경로login.do를 써도되고 절대경로/mvc/member/login.do를 써도 된다. -->
	
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="uid" placeholder="아이디를 입력하세요"></td>
		</tr>
		<tr>
			<td>패스워드</td>
			<td><input type="password" name="pw" placeholder="비밀번호를 입력하세요"></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="로그인"></td>
		</tr>
	</table>
	
	</form>

</body>
</html>