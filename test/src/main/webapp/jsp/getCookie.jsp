<%@ page contentType="text/html; charset=UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
	String username = "쿠키 없음";
	if(cookies != null) {
		for(Cookie cookie : cookies){
			if("username".equals(cookie.getName())){
				username = cookie.getValue();
			}
		}
	}
%>
<h2>저장된 쿠키 값: <%= username %></h2>
<a href="index.jsp">메인으로</a>