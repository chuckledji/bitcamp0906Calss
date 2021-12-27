<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>ajax</title>
<script src="http://code.jquery.com/jquery.12.4.min.js"></script>
<script>

	//서버의 리소스를 요청해서 현재 페이지의 엘리먼트에 추가
	$(document).ready(function(){
		//$ajax(url, {});
		$ajax('data.html',{
			success : function(data){
				$('body').append(data);
			},
			error : function(){
				
			}
		});
	});
	

</script>

</head>
<body>

</body>
</html>