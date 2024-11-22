<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="tukorea.web.club.domain.*, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
</head>
<link rel="stylesheet" href="resources/student.css" type="text/css"></link>
<body>
	<header> Member List </header>
	<nav>
		<a href="http://localhost:8080/ysy_mvcdb/welcome.html" target="_self">메인
			페이지 이동</a>
	</nav>
	<table>
		<tr>
			<th>계정</th>
			<th>이름</th>
			<th>학번</th>
			<th>학과</th>
			<th>모바일</th>
			<th>이메일</th>
			<th>관리</th>
		</tr>

		<%
		List<StudentVO> studentList = (List<StudentVO>) request.getAttribute("studentList");
		for (StudentVO vo : studentList) {
		%>
		<tr>
			<td><%=vo.getId()%></td>
			<td><%=vo.getUsername()%></td>
			<td><%=vo.getSnum()%></td>
			<td><%=vo.getDepart()%></td>
			<td><%=vo.getMobile()%></td>
			<td><%=vo.getEmail()%></td>
			<td><a href="http://localhost:8080/ysy_mvcdb/StudentServlet?cmd=update&id=<%=vo.getId() %>"
				target="_self">수정</a>
				<a href="http://localhost:8080/ysy_mvcdb/StudentServlet?cmd=delete&id=<%=vo.getId() %>"
				target="_self">삭제</a>
				</td>
		</tr>
		<%
}
%>
	</table>
</body>
</html>