<%@ page contentType="text/html; charset=UTF-8"%>
<jsp:forward page="sn.jsp">
	<jsp:param name="ie" value="<%= request.getParameter(\"ie\") %>" />
</jsp:forward>