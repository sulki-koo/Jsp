<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<title>게시물수정폼</title>
<style>h3, form {text-align: center;}</style>
</head>
<body>
<%@ include file="/jsp/include/header.jsp" %>
	<h3>아이디 : ${article.aid} 게시물 수정</h3><br>
	<form action="/updateArticle.do" method="post">
		<input type="hidden" name="aid" value="${article.aid}">
		제목 : <input type="text" name="asubject" value="${article.asubject}"><br>
		<p>내용</p> 
		<textarea rows="10" cols="40" name="acontent" >${article.acontent}</textarea><br><br>
	<input type="submit" value="수정">
	<input type="button" value="목록"	onclick="location.href='/selectArticle.do';">
	</form>
</body>
</html>