<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
	CookieBox cookieBox = new CookieBox(request);
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Cookies Delete</h1>
	<hr>
	<h3>
	<%
		//쿠키 검색 후 -> 쿠키 수정 (같은 이름의 쿠키를 저장한다)
		if(cookies != null){
			for(int i=0; i<cookies.length; i++){
				if(cookies[i].getName().equals("korName")){
					//변경하고자 하는 값을 가지는 쿠키 객체를 생성
					Cookie c = new Cookie("korName","사람2");	//덮어씌우는 것
					//쿠키의 유효시간을 0으로 설정 = 삭제
					c.setMaxAge(0);
					response.addCookie(c);
					break; 
				}
			}
		}
		
		//쿠키박스 이용
		//존재유무확인 > 처리
		if(cookieBox.exists("uid")){
			response.addCookie(CookieBox.createCookie("uid", "", 0));
		}
	%>
	<a href ="viewCookie.jsp">쿠키값  보기</a>
	</h3>
</body>
</html>