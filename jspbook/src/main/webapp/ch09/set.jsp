<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c:set</title>
</head>
<body>
	<div align="center">
		<h3>&lt;c:set&gt;</h3>

		<c:set value="Hello World" var="msg" />
		msg: ${msg} <BR> 
		msg: <%=pageContext.getAttribute("msg")%><BR>

		<c:set target="${member}" property="email" value="change@tukorea.ac.kr" />
		Member name: ${member.name} <BR> 
		Member email: ${member.email}
	</div>
</body>
</html>