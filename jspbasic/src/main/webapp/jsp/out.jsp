<%--
	out : javax.servlet.jsp.JspWriter
	- 출력
	- print() : 줄바꿈 없이 출려
	- println() : 줄바꿈 문자와 함께 출력
	- newLine() : 줄바꿈 문자 출력
--%>


<%@ page contentType="text/html; charset=UTF-8"%>

<%
	out.print("hello");
	out.println("hello");
	out.print("jsp");
	out.newLine();
	out.print("jsp");
%>

