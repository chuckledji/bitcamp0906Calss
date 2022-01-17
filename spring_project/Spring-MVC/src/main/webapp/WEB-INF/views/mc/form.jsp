<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RequestBody연습 폼</title>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

</head>
<body>
	<h1>입력폼</h1>
	<hr>
	<form method="post">
		이름<input type="text" name="uname"><br>
		나이<input type="text" name ="age"><br>
		<input type="submit">
	</form>
	<input type="button" id="btn" value="Json정송">
	
<script>
	$(document).ready(function(){
		$('#btn').click(fhunction(){	//캐스팅		//Json데이터로 전송해보기
			var obj ={
				itemId: 'product-10',
				number: 1000,
				remark: '냉동식품'
			};
			$.ajax({
				url: '/mvc/orderItem',
				type: 'post',
				data: JSON.stringify(obj),
				dataType: 'json',
				conntentType: 'application/json',
				success: function(data){
					console.log(data);
				},
				error: function(){
					console.log('통신오류');
				}
			});
			
		});
	});
</script>	
	
</body>
</html>