<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>

<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<title>게시판목록</title>
<style>
table {
	width: 860px;
	margin: 0 auto;
}

table, tr, th, td {
	border: 1px solid #333;
	border-collapse: collapse;
}

h3, th, td, p {
	height: 30px;
	line-height: 30px;
	text-align: center;
}
</style>
</head>
<body>
	<h3>게시판목록</h3>
	<table>
		<tbody>
			<tr>
				<td>게시판아이디</td>
				<td>${board.bid}</td>
			</tr>
			<tr>
				<td>게시판명</td>
				<td>${board.bname}</td>
			</tr>
			<tr>
				<td>게시물수</td>
				<td>${board.bacnt}</td>
			</tr>
		</tbody>
	</table>
	<p>
		<input type="button" value="목록"	onclick="location.href='/selectBoard.do';">
	</p>
</body>
</html>