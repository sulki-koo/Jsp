<%@ page contentType="text/html; charset=UTF-8"%>
<jsp:forward page="result.jsp">
	<jsp:param name="pj" value="<%= request.getParameter(\"pj\") %>" />
</jsp:forward>