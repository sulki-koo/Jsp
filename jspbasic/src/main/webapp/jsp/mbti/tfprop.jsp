<%@ page contentType="text/html; charset=UTF-8"%>
<jsp:forward page="pj.jsp">
	<jsp:param name="tf" value="<%= request.getParameter(\"tf\") %>" />
</jsp:forward>