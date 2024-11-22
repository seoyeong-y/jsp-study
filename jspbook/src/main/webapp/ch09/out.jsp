<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c:out</title>
</head>
<body>
	<div align="center">
		<h3>&lt;c:out&gt;</h3>
		<table border="1" cellpadding=5 cellspacing=0>
			<c:forEach var="member" items="${members}">
				<tr>
					<td><c:out value="${member.name}" /></td>
					<td><c:out value="${member.email}" escapeXml="false">
							<font color=red>email 없음</font>
						</c:out></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>