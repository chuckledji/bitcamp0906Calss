<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
	
	//2021.12.09
	CookieBox cookieBox= new CookieBox(request);//??이해안가1104
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Cookies List</h1>
	<hr>
	<h3>
	<%
		if(cookies != null){
			for(int i=0; i<cookies.length; i++){
				out.println(cookies[i].getName()+" : "+cookies[i].getValue()+"<br>");
				//콘솔에서확인
				System.out.println(cookies[i].getName()+" : "+cookies[i].getValue()+"<br>");	
			}
		}
		//쿠키 검색
		if(cookies != null){
			for(int i=0; i<cookies.length; i++){
				if(cookies[i].getName().equals("korName")){
					out.println(cookies[i].getName()+" : "+cookies[i].getValue()+"<br>");
					break; //쿠키는 이름이 중복된게 없기때문에 하나 찾으면 나가주는 것이 좋다.
				}
			}
		}
	%>
	<hr>
		<h3><!-- 쿠키박스 이용 -->
			<%=  cookieBox.exists("uid")%> / <%=cookieBox.exists("uid3") %>
		</h3>
		<h3>
			<%
				if(cookieBox.exists("uid")){
					Cookie c = cookieBox.getCookie("uid");
					out.println(c.getName()+" : "+ cookieBox.getValue(c.getName()));
				}
			%>
		</h3>
	<hr>
	
	<a href ="editCookie.jsp">쿠키값 수정</a>
	<a href = "deleteCookie.jsp">쿠키값 삭제</a>
	</h3>
</body>
</html>