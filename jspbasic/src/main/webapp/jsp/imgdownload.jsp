<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	//실습2 : 이미지 다운로드 구현
	InputStream is = application.getResourceAsStream("/img/bubble.jpg");
	response.setHeader("Content-Disposition", "attachmentl; filename=\"bubble.jpg\"");
	
	OutputStream os = response.getOutputStream();
	byte[] buffer = new byte[1024];
	int readByte = 0;
	while((readByte = is.read(buffer)) > -1) {
		os.write(buffer, 0, readByte);
	}
	os.flush();
%>

