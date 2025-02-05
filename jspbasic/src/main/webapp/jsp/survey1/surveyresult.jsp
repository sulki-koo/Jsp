<%@page import="java.util.Enumeration"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%
	out.print("설문조사 결과<br>");

	out.print("이름: " + request.getAttribute("name") + "<br>");
	
	String[] hobbies = (String[])request.getAttribute("hobby");
	String strHobbies = "";
	for(String hobby : hobbies) {
		switch(hobby) {
			case "game": hobby="게임"; break;
			case "youtube": hobby="유튜브"; break;
			case "sleeping": hobby="잠자기"; 
		}
		strHobbies += hobby + " ";
	}
	out.print("취미: " + strHobbies);
%>

<br>
<button onclick="javascript:location.href='surveyStart.jsp'">처음으로</button>