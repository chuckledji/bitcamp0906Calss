<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	//application 객체의 속성값을 가져온다.(getAttribute)
	String strcnt = (String)application.getAttribute("cnt"); //attribute는 object를반환

	int cnt = (strcnt == null) ? 0: Integer.parseInt(strcnt);
	
	
	/* 
	int cnt = 3;
	
	int num=0;
	if(strcnt == null){
		num = 0;
	} else {
		num = Integer.parseInt(strcnt);
	} 
	*/
	
	
	
	//application 객체의 속성값을 저장한다.
	application.setAttribute("cnt", String.valueOf(++cnt));
	
	
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>방문자 수 <%=cnt %></h1>
</body>
</html>