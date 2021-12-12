<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <%= request.getContextPath() %> --%>
   
		<form action="<%= request.getContextPath() %>/cookie/member/login.jsp" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="checkBox" name="saveId" value="saveID">아이디 저장하기
				</td>
			</tr>
		</table>
		</form>
</body>
</html>