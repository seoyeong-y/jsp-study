<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="domain.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Update</title>
<link rel="stylesheet" href="resources/student.css" type="text/css"></link>
</head>
<body>
	<header>Member Update</header>
	<nav>개인정보를 수정하세요.</nav>
	<form class=form_one
		action="http://localhost:8080/ysy_mvcdb/StudentServlet?cmd=update"
		method="post">
		<%
		StudentVO student = (StudentVO) request.getAttribute("student");
		%>
		<ul>
			<li>계정 <input type="text" name="id" value=<%=student.getId()%>
				readonly></li>
			<li>비밀번호 <input type="password" name="passwd"
				value=<%=student.getPasswd()%> autofocus></li>
			<li>이름 <input type="text" name="username"
				value=<%=student.getUsername()%>></li>
			<li>학번 <input type="text" name="snum"
				value=<%=student.getSnum()%>></li>
			<li>학과 <input type="text" name="depart"
				value=<%=student.getDepart()%>></li>
			<li>모바일 <input type="text" name="mobile"
				value=<%=student.getMobile()%>></li>
			<li>이메일 <input type="text" name="email"
				value=<%=student.getEmail()%>></li>
			<li class=form_one><input type="submit" name="submit"
				value="최종 수정">
		</ul>
	</form>
</body>
</html>