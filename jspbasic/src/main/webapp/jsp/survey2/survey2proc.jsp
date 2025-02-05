<%@ page contentType="text/html; charset=UTF-8"%>

<% 
	String[] hobbies = request.getParameterValues("hobby"); 
	String strHobbies = String.join(", ", hobbies);
%>

<jsp:forward page="surveyresult.jsp">
	<jsp:param name="name" value="<%=request.getParameter(\"name\")%>"/>
	<jsp:param name="hobby" value="<%= strHobbies %>"/>
</jsp:forward>
