<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#form>table td {
	padding: 5px;
}
#form input {
	padding: 5px;
}
</style>
</head>
<body>
	
		<h3>방명록</h3>
		<hr>
		<form method="post">
		<input type="hidden" name="memberidx" value="${loginInfo.idx}">
			<table>
				
				<tr>
					<td>제목</td>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<textarea name="content"></textarea>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="등록"></td>
				</tr>		
			</table>
		</form>

</body>
</html>