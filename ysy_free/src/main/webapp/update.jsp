<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="domain.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<style>
.form-container {
	width: 300px;
	margin: 0 auto;
}

.input-field {
	width: 100%;
	padding: 10px;
	margin: 10px 0;
}

.btn {
	width: 100%;
	padding: 10px;
	background-color: #007BFF;
	color: white;
	border: none;
	cursor: pointer;
}

.btn:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<h1>회원 정보 수정</h1>
	<div class="form-container">
		<form action="MemberServlet?cmd=update" method="post">
			<input type="text" name="id" value="${member.id}" class="input-field"
				readonly> <input type="password" name="passwd"
				value="${member.passwd}" class="input-field" required> <input
				type="text" name="username" value="${member.username}"
				class="input-field" required> <input type="number"
				name="age" value="${member.age}" class="input-field" required>
			<select name="sex" class="input-field" required>
				<option value="남" ${member.sex == '남' ? 'selected' : ''}>남</option>
				<option value="여" ${member.sex == '여' ? 'selected' : ''}>여</option>
			</select> <input type="tel" name="phone" value="${member.phone}"
				class="input-field" required> <input type="hidden"
				name="cmd" value="update">
			<button type="submit" class="btn">수정하기</button>
		</form>
	</div>
</body>
</html>
