<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<title>게시물등록폼</title>
<style>input {text-align: center; background-color: lime;}</style>
</head>
<body>
	<h3>게시물등록</h3>
	<form action="/insertArticle.do" method="post">
		제목 : <input type="text" name="asubject"><br>
		내용 : <input type="text" name="acontent"><br>
		게시판아이디 : <input type="text" name="bid"><br>
		회원아이디 : <input type="text" name="mid"><br>
	<input type="submit" value="등록"><br>
	</form>
</body>
</html>