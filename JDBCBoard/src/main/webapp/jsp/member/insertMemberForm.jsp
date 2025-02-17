<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<title>회원가입폼</title>
<style>input {text-align: center; background-color: lime;}</style>
</head>
<body>
	<h3>회원가입</h3>
	<form action="/insertMember.do" method="post">
		아이디 : <input type="text" name="mid"><br>
		이름 : <input type="text" name="mname"><br>
		별칭 : <input type="text" name="malias"><br>
		비밀번호 : <input type="password" name="mpass"><br>
		이메일 : <input type="text" name="memail"><br>
		전화번호 : <input type="text" name="mcp"><br>
	<input type="submit" value="등록"><br>
	</form>
</body>
</html>