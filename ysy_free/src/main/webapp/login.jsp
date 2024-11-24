<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="resources/style.css">
</head>
<body>
	<div class="form-container">
		<h1>로그인</h1>
		<form action="MemberServlet" method="post">
			<input type="text" name="id" placeholder="아이디" class="input-field"
				required> <input type="password" name="passwd"
				placeholder="비밀번호" class="input-field" required> <input
				type="hidden" name="cmd" value="login"> <br>
			<button type="submit" class="btn">로그인</button>
		</form>
		<a href="http://localhost:8080/ysy_free/MemberServlet?cmd=join">회원가입</a>
	</div>
</body>
</html>
