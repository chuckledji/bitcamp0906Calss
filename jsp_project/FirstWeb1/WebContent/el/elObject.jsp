<%@page import="member.Member"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//내장객체의 속성은 데이터의 공유를 위해 사용한다. > 모듈화할수있다.

	request.setAttribute("name", "보라돌이");		//request > session > application순으로 찾는다.
	session.setAttribute("name", "나나");
	application.setAttribute("name", "뚜비");
	
	String[] arr= {"A", "B", "C"};
	request.setAttribute("arr", arr);	//배열저장
	
	List<String>list = new ArrayList<String>();
	list.add("HTML5");
	list.add("CSS3");
	list.add("JAVA");
	list.add("JSP");
	request.setAttribute("list", list);
	
	Map<String, String> map = new HashMap<String, String>();
	map.put("name", "손흥민");
	map.put("team", "토트넘");
	map.put("no", String.valueOf(7));
	request.setAttribute("player", map);
	
	Member member = new Member("이강인", 20);
	request.setAttribute("member", member);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<hr>
	사칙연산 : 만 나이 = ${member.age-1} <br>
	비교연산 : 성인여부판단 = ${member.age-1 > 18} / ${member.age gt 19} / ${member.name eq '이강인'}<br>
						 
	논리연산 :			${member.name == '손흥민' && member.age > 20} / ${member.age-1>19 ? '성인' : '미성년'}<br>
	empty연산 :		${not empty list}
						 
	
	<hr>
	
	배열요소출력   : ${arr[0]} / ${arr[1]} / ${arr[2]}<br>
	List요소출력 : ${list[0]} / ${list[1]} / ${list[2]} / ${list[3]} / ${list[4]} / <br>
	Map요소출력   : ${player.name} / ${player.team} / ${player.no} / ${player.age} <br>
	일반객체인 경우 메소드 호출 : <br> 
	<%= ((Member)request.getAttribute("member")).getName() %>/<br>
	<%= ((Member)request.getAttribute("member")).getHello() %>/<br>
	${member.name}<br>
	${member.hello}<br>
	
	
	<hr> 
	
	논리값 : ${true} / ${false} <br>
	숫자(정수/실수) : ${100} / ${3.14} <br>
	숫자(사칙연산) : ${100+10} / ${3.14*100} <br>
	문자열 : ${'보라돌이'} /${"나나"} <br>
	null : ${null} <br>
	null : ${param.name == null} <br>
	
	
	<hr>
	
	param  : ${param.type} / <%= request.getParameter("type") %><br>	
	cookie : ${cookie.JSESSIONID.value}<br>	
	header : ${header.host}<br>	
		
	<hr>
	
	<%= request.getContextPath() %> <br>
	<%= ((HttpServletRequest)pageContext.getRequest()).getContextPath() %> <br><!-- 이해안가1048 -->
	${pageContext.request.contextPath}  <br>
	${pageContext.request.requestURL}	<br>
	${pageContext.request.requestURI}	<br>
	
	<hr>

	<h3>
		request영역의 name: <%= request.getAttribute("name") %> /
		${requestScope.name} / 
		${name} <br>
		
		session영역의 name: <%= session.getAttribute("name") %> /
		${sessionScope.name}  / 
		${name}<br>
		
		application영역의 name: <%= application.getAttribute("name") %> /
		${applicationScope.name} /
		${name}	<!-- 속성은 생략이 가능하다./고유한 이름으로 만들면 유용 -->
	</h3>
</body>
</html>