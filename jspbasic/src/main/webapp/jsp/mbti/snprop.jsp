<%@ page contentType="text/html; charset=UTF-8"%>
<jsp:forward page="tf.jsp">
	<jsp:param name="sn" value="<%= request.getParameter(\"sn\") %>" />
</jsp:forward>