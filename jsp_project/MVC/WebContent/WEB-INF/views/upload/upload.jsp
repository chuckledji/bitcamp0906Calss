<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>파일업로드</title>
</head>
<body>
	
	<h1>파일업로드</h1>
	<hr>
	title : ${title}<br>
	userName : ${userName}<br>
	fileName : ${fileName}<br>
	contentType : ${contentType}<br>
	fileSize : ${fileSize}<br>
	
	<img src="${page.Context.request.contextPath}/mvc/uploadfile/${fileName}" width="100">
	
</body>
</html>