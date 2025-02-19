<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<title>게시물등록폼</title>
<style>h3, form {text-align: center;}</style>
</head>
<body>
<%@ include file="/jsp/include/header.jsp" %>
	<h3>${sessionScope.ss_mid}님 게시물등록</h3>
	<form action="/insertArticle.do" method="post">
		<input type="hidden" name="mid" value="${sessionScope.ss_mid}">
		게시판 아이디 : <input type="text" name="bid"><br>
		제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목 : <input type="text" name="asubject"><br>
		<p>내 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 용<p>
		<textarea rows="10" cols="40" name="acontent"></textarea><br>
		<input type="file" name="acontent"><br><br>
	<input type="submit" value="등록">
	<input type="button" value="취소" onclick="location.href='/selectArticle.do';">
	</form>
</body>
</html>