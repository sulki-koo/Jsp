<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<title>update form</title>
</head>
<body>
	<form action="/update.do" method="post">
		<input type="hidden" name="sid" value="${dto.sid}">
		${dto.sid}번 수정 <br>
		제목 : <input type="text" name="title" value="${dto.title}"><br>
		내용 : <textarea cols="40" rows="5" name="content">${dto.content}</textarea><br>
		<input type="submit" value="확인">
		<a href="/select.do">목록</a>
	</form>
</body>
</html>