<%@ page contentType="text/html; charset=UTF-8"%>
<%="입력한 이름 : " + request.getAttribute("name")%>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<title>survey2.jsp</title>
</head>
<body>
	<form action="survey2proc.jsp" method="post">
	<input type="hidden" name="name" value='<%=request.getAttribute("name")%>'>
	
	<p>취미를 선택하세요!</p>
	<p>
		<input type="checkbox" name="hobby" value="game"> 게임&nbsp;
		<input type="checkbox" name="hobby" value="youtube"> 유튜브시청&nbsp;
		<input type="checkbox" name="hobby" value="sleeping"> 잠자기
	</p>
	<p><input type="submit" value="다음"></p>
	</form>
</body>
</html>
<button onclick="javascript:location.href='survey1.jsp'">이전</button>