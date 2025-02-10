<%@ page contentType="text/html; charset=UTF-8"%>

<%
	request.setAttribute("name", request.getParameter("name"));

	String[] hobbies = request.getParameterValues("hobby");
	request.setAttribute("hobby", hobbies);
	
	request.getRequestDispatcher("surveyresult.jsp").forward(request, response);
%>