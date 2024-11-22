<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web Service Programming Homework</title>
<link rel="stylesheet" href="resources/register.css" type="text/css"></link>
</head>
<body>
	<header>
		TUKOREA 2024<br>Web Service Programming Community
	</header>
	<nav>
		커뮤니티 가입을 축하합니다.<br> <a href="welcome.html" target="_self">메인 페이지 이동</a>
	</nav>
	<section>
		<table>
			<tr>
				<th>계정</th>
				<td><%=request.getParameter("id")%></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><%=request.getParameter("username")%></td>
			</tr>
			<tr>
				<th>학번</th>
				<td><%=request.getParameter("snum")%></td>
			</tr>
			<tr>
				<th>전공</th>
				<td><%=request.getParameter("depart")%></td>
			</tr>
			<tr>
				<th>폰번호</th>
				<td><%=request.getParameter("mobile")%></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><%=request.getParameter("email")%></td>
			</tr>
		</table>
	</section>
</body>
</html>