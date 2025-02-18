<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<title>회원정보수정폼</title>
<style>h3, form {text-align: center; }</style>
</head>
<body>
	<%@ include file="/jsp/include/header.jsp" %>
	<h3>아이디 : ${member.mid}님의 회원정보수정</h3><br>
	<form action="/updateMember.do" method="post">
		<input type="hidden" name="mid" value="${member.mid}">
		이 &nbsp; 름 : <input type="text" name="mname" value="${member.mname}"><br>
		별 &nbsp; 칭 : <input type="text" name="malias" value="${member.malias}"><br>
		이메일 : <input type="text" name="memail" value="${member.memail}"><br>
		연락처 : <input type="text" name="mcp" value="${member.mcp}"><br><br>
	<input type="submit" value="수정">
	<input type="button" value="목록"	onclick="location.href='/selectMember.do';">
	</form>
</body>
</html>