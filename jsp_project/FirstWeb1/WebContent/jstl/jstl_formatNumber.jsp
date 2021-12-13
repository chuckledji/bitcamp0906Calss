<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl_formatNumber</title>
</head>
<body>
	숫자출력:<br>
	<c:set var="number" value="10000"/>
	<p>
	<fmt:formatNumber value="1000"/><br>
	<fmt:formatNumber value="${number}"/><br>
	<fmt:formatNumber value="${number}" groupingUsed="false"/><br>
	<fmt:formatNumber value="${number}" var="num"/><br>
	
	숫자 : ${num}<br>
	
	퍼센트출력:<br>
	<fmt:formatNumber value="${number/4000}" type="percent"/><br>
	통화<br>
	<fmt:formatNumber value="${number}" type="currency" currencySymbol="\\"/>
	패턴:<br>
	<fmt:formatNumber value="${number*1000}" pattern="000,000,000.00" />
	
	
	
	
	</p>
</body>
</html>