<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>remove</title>
</head>
<body>
	<div align="center">
		<h3>&lt;c:remove&gt;</h3>
		<c:set value="Hello World" var="msg" />
		before remove: ${msg}<BR>

		<c:remove var="msg" />
		after remove: ${msg}
	</div>
</body>
</html>