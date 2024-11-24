<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>마이 페이지</title>
    <link rel="stylesheet" href="resources/style.css">
</head>
<body>
	<div class="container">
        <h1>마이 페이지</h1>
        <div class="info">
            <p><strong>이름:</strong> ${member.username}</p>
            <p><strong>아이디:</strong> ${member.id}</p>
            <p><strong>나이:</strong> ${member.age}</p>
            <p><strong>성별:</strong> ${member.sex}</p>
            <p><strong>전화번호:</strong> ${member.phone}</p>
        </div>
        <a href="MemberServlet?cmd=update" class="btn">회원 정보 수정</a>
        <a href="MemberServlet?cmd=logout" class="btn">로그아웃</a>
    </div>
</body>
</html>
