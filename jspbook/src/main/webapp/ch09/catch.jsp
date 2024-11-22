<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>catch</title>
</head>
<body>
	<div align="center">
		<h3>&lt;c:catch&gt;</h3>
		<c:catch var="errMsg">
		<%= 9/0 %>
		</c:catch>
		
		error message: ${errMsg}
	</div>
</body>
</html>