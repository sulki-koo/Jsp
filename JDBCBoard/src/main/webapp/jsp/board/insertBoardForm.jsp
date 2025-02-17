<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<title>게시판등록폼</title>
<style>input {text-align: center; background-color: lime;}</style>
</head>
<body>
	<h3>게시판등록</h3>
	<form action="/insertBoard.do" method="post">
		게시판명 : <input type="text" name="bname"><br>
	<input type="submit" value="등록"><br>
	</form>
</body>
</html>