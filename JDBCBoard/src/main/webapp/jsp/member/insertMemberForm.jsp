<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<title>회원가입폼</title>
<style>h3, form {text-align: center; }</style>
</head>
<body>
	<%@ include file="/jsp/include/header.jsp" %>
	<h3>회원가입</h3>
	<form action="/insertMember.do" method="post">
		아 이 디 : <input type="text" name="mid"><br>
		이 &nbsp;&nbsp;&nbsp; 름 : <input type="text" name="mname"><br>
		별 &nbsp;&nbsp;&nbsp; 칭 : <input type="text" name="malias"><br>
		비밀번호 : <input type="password" name="mpass"><br>
		이 메 일 : <input type="text" name="memail"><br>
		연 락 처 : <input type="text" name="mcp"><br>
	<input type="submit" value="등록">
	<input type="button" value="취소" onclick="location.href='/selectMember.do';">
	</form>
</body>
</html>