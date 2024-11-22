<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- CalcBean 클래스를 calc라는 이름으로 인스턴스 생성 --%>
<jsp:useBean id="calc" class="jspbook.ch02.CalcBean"/>

<%-- calc 객체의 setter 메서드 호출로 HTML 폼 데이터 전달 --%>
<jsp:setProperty name="calc" property="*"/>

<%-- 계산 메서드 호출 --%>
<% calc.calculate(); %>

<html>
<head>
<meta charset="UTF-8">
<title> 계산기 </title>
</head>
<body>
	<div align = "center">
	<H3>계산기: 빈 사용</H3>
	<HR>
	<form name=form1 action="calculate2.jsp" method="post">
		<INPUT type="text" NAME="num1" width=200 size="5">
		<SELECT NAME="operator">
			<option selected>+</option>
			<option>-</option>
			<option>*</option>
			<option>/</option>
		</SELECT>
	
		<INPUT TYPE="text" NAME="num2" width=200 size="5">
		<input type="submit" value="계산" name="B1">
		<input type="reset" value="다시입력" name="B2">
	</form>
	<HR>
	계산결과: <jsp:getProperty name="calc" property="result"/>
	</div>
</body>
</html>