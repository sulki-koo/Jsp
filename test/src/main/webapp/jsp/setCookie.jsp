<%@ page contentType="text/html; charset=UTF-8"%>
<%
	Cookie userCookie = new Cookie("username", "홍길동");
	userCookie.setMaxAge(60*60*24); // 1일 유지
	response.addCookie(userCookie);
%>
<h2>쿠키 저장 완료</h2>
<a href="index.jsp">메인으로</a>
