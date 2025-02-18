<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<title>게시판등록폼</title>
<style>h3, form {text-align: center; }</style>
</head>
<body>
<%@ include file="/jsp/include/header.jsp" %>
	<h3>게시판등록</h3>
	<form action="/insertBoard.do" method="post">
		게시판명 : <input type="text" name="bname"><br><br>
	<input type="submit" value="등록">
	<input type="button" value="취소" onclick="location.href='/selectBoard.do';">
	</form>
</body>
</html>