<%@ page contentType="text/html; charset=UTF-8"%>
<%
	Cookie deleteCookie = new Cookie("username", "");
	deleteCookie.setMaxAge(0);
	response.addCookie(deleteCookie);
%>
<h2>쿠키 삭제 완료</h2>
<a href="index.jsp">메인으로</a>
