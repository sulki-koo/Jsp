<%@ page import="java.util.*" %>
<%@ page contentType="text/html; charset=UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%
	List<String> names = Arrays.asList("홍길동", "강감찬", "이순신");
	request.setAttribute("nameList", names);
%>

<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<title>JSTL 예제</title>
</head>
<body>
	<h2>JSTL 반복문</h2>
	<ul>
	<c:forEach var="name" items="${nameList}">
		<li>${name}</li>
	</c:forEach>
	</ul>
	<h2>JSTL 조건문</h2>
	<c:if test="${10 > 5}">
		<p>10은 5보다 큽니다</p>
	</c:if>
	<a href="index.jsp">메인으로</a>
</body>
</html>