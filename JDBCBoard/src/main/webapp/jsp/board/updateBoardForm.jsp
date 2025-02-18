<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<title>게시판정보수정폼</title>
<style>h3,form {text-align: center;}</style>
</head>
<body>
<%@ include file="/jsp/include/header.jsp" %>
	<h3>게시판정보수정</h3>
	<form action="/updateBoard.do" method="post">
		<input type="hidden" name="bid" value="${board.bid}">
		게시판아이디 : ${board.bid} | 게시물수 : ${board.bacnt}<br>
		게시판명 : <input type="text" name="bname" value="${board.bname}"><br><br>
	<input type="submit" value="수정">
	<input type="button" value="목록"	onclick="location.href='/selectBoard.do';">
	</form>
</body>
</html>