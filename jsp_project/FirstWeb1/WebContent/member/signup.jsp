<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% request.setCharacterEncoding("utf-8"); %>


	<h1>User Id : <%= request.getParameter("userid") %> </h1>
	<h1>Password : <%= request.getParameter("pw") %> </h1>
	<h1>이름 : <%= request.getParameter("username") %> </h1>
	<h1>자기소개 : <%= request.getParameter("comment") %> </h1>
	<h1>성별 : <%= request.getParameter("gender") %> </h1>
	<h1>
	<%
	String[] interests = request.getParameterValues("interest");
		if(interests != null) {
			for(int i=0; i<interests.length; i++) {
				out.println("관심사 : " + interests[i] + " <br>");
			}
		} else {
			out.println("관심사 : 선택된 관심사가 없습니다. <br>");
		}
	%>
	</h1>
	<h1>태어난 해 : <%= request.getParameter("byear") %></h1>
	

</body>
</html>