<%@ page contentType="text/html; charset=UTF-8"%>
<%
	request.setAttribute("username", "홍길동");	
	session.setAttribute("userRole", "관리자");	
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset='utf-8'>
	<title>EL 예제</title>
</head>
<body>
	<h2>EL로 데이터 출력</h2>
	<p>이름 (requestScope): ${username}</p>
	<p>사용자 역할 (requestScope): ${sessionScope.userRole}</p>
	<p>간단한 연산: ${10+5}</p>
	<p>조건문: ${10 > 5 ? '참' : '거짓'}</p>
	<a href="index.jsp">메인으로</a>
</body>
</html>
