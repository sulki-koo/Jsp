<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<title>회원정보수정폼</title>
<style>input {text-align: center; background-color: aqua;}</style>
</head>
<body>
	<h3>회원정보수정</h3>
	<form action="/updateMember.do" method="post">
		<input type="hidden" name="mid" value="${member.mid}">
		아이디 : ${member.mid}<br>
		이름 : <input type="text" name="mname" value="${member.mname}"><br>
		별칭 : <input type="text" name="malias" value="${member.malias}"><br>
		이메일 : <input type="text" name="memail" value="${member.memail}"><br>
		전화번호 : <input type="text" name="mcp" value="${member.mcp}"><br>
	<input type="submit" value="수정">
	<input type="button" value="목록"	onclick="location.href='/selectMember.do';">
	</form>
</body>
</html>