<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="news">
	<%
		//String title = "News";	//에러발생예상!(변수이름이 같으므로)
		String title1 = "News";
	%>
	<h3><%= title1 %></h3>
	<hr>
	<ul>
	<%
	for (int i=0; i<5; i++){
		out.println("<li>"+i+"</li>");
	}
	%>
	</ul>
</div>