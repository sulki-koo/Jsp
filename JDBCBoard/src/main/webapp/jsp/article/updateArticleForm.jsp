<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<title>게시물수정폼</title>
<style>input {text-align: center; background-color: aqua;}</style>
</head>
<body>
	<h3>게시물수정</h3>
	<form action="/updateArticle.do" method="post">
		<input type="hidden" name="aid" value="${article.aid}">
		게시물아이디 : ${article.aid}<br>
		제목 : <input type="text" name="asubject" value="${article.asubject}"><br>
		내용 : <input type="text" name="acontent" value="${article.acontent}"><br>
	<input type="submit" value="수정">
	<input type="button" value="목록"	onclick="location.href='/selectArticle.do';">
	</form>
</body>
</html>