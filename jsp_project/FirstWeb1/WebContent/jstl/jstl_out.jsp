<%@page import="member.Member"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	List <Member> members = new ArrayList<Member>();
	members.add(new Member(null, 20));
	members.add(new Member("이강인", 19));
	members.add(new Member("손흥민", 30));
	members.add(new Member(null, 35));
	members.add(new Member("박지성", 40));
	
	request.setAttribute("members", members);
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:out value="${members[0].name}" escapeXml="false">
		<span style ="color:red;">입력된이름정보가없습니다.(출력값이 null일때 기본값)</span>
	</c:out><br>
	<c:out value="${members[0].name}" default="No Name"/>
	<c:out value="${members[1].name}"></c:out>
	
	<hr>
	이름 : 나이 <br>
	<!-- 회원정보리스트 출력 -->
	<c:forEach items="${members}" var="member">
	<c:out value="${member.name}" escapeXml="flase">
		<span class="no_name">NO NAME</span>
	</c:out>
	
	:
	${member.age} <br>
		
	</c:forEach>
</body>
</html>