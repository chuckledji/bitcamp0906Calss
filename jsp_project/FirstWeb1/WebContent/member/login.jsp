<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"	
    	 pageEncoding="UTF-8"%>
<%
	Date now = new Date();
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	String nowDate = format.format(now);	//오늘 날짜를 문자열로 받음(2021-12-08)
	
	if(nowDate.endsWith("08")){				//날짜가 오늘이라면
		//다른페이지로 이동
		response.sendRedirect("underCheck.jsp");
		//return;
	}
	
	
	
	
	//로그인처리
	//사용자 입력데이터 id/pw를 확인, 체크
	//성공 - session에 사용자 정보를 저장
	//이번테스트의 로그인 성공 - id와 pw가 같을 때 성공으로.
	//실패 - 다시 로그이인페이지로 이동 
	
	//사용자데이터받기
	request.setCharacterEncoding("utf-8");
	
	//스크립트릿영역 : java문법 작성
	//request : 내장객체 (별도의 변수선언과 객체생성이 없다.) 이유 : 서블릿으로 변환되어 실행되기때문에(서블렛안에 선언되어있다)
	String uid = request.getParameter("userid");
	String pw = request.getParameter("pw");
	
	//로그인성공시
	if(uid.equals(pw)){
		//로그인 성공
		//session 객체 속성에 로그인 정보 저장 : id만저장
		session.setAttribute("id", uid);
		
		request.setAttribute("num1", 1);
		application.setAttribute("num2", 2);
		
		//mypage.jsp로 이동한다
		response.sendRedirect("mypage.jsp");
		
		return;
		
	}else{
		//로그인 실패 : loginForm.html -> lgin.jsp
		%>
		<script>
			alert('로그인실패! 로그인페이지로 이동합니다.');
			//location.href='';
			history.go(-1);
		</script>
		<%
		//return;	//하면 밑에html이 진행되지 않는다.
	}
	%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Login Form Data</h1>
	
	아이디 : <%= uid %> 							<!-- uid.toString()으로 나옴  -->
	<br>
	비밀번호 : 
	<%= request.getParameter("pw") %>
	
	<br>
	<%= new Date() %>	<!-- 자바코드가 내부적으로 서블릿으로 변환 -->
	<br>
	<%= nowDate %>
	<br>
	View COUNT : 
	<%= application.getAttribute("cnt") %>
</body>
</html>