<%@ page contentType="text/html; charset=UTF-8"%>
<%
	String user = (String)session.getAttribute("user");
	if(user==null) user = "세션 없음"; 
%>
<h2>세션 값 : <%= user %></h2>
<a href="index.jsp">메인으로</a>