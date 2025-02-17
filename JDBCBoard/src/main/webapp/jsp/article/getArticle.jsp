<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>

<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<title>게시물목록</title>
<style>
table {
	width: 860px;
	margin: 0 auto;
}

table, tr, th, td {
	border: 1px solid #333;
	border-collapse: collapse;
}

h3, h4, th, td, p, form {
	height: 30px;
	line-height: 30px;
	text-align: center;
}
</style>
</head>
<body>
	<h3>게시물목록</h3>
	<table>
		<tbody>
			<tr>
				<td>게시물아이디</td>
				<td>${article.aid}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${article.asubject}</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${article.acontent}</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${article.avcnt}</td>
			</tr>
			<tr>
				<td>등록일시</td>
				<td>${article.aregdate}</td>
			</tr>
			<tr>
				<td>삭제여부</td>
				<td>${article.adelyn}</td>
			</tr>
			<tr>
				<td>첨부파일수</td>
				<td>${article.aafcnt}</td>
			</tr>
			<tr>
				<td>댓글수</td>
				<td>${article.arcnt}</td>
			</tr>
			<tr>
				<td>게시판아이디</td>
				<td>${article.bid}</td>
			</tr>
			<tr>
				<td>회원아이디</td>
				<td>${article.mid}</td>
			</tr>
		</tbody>
	</table>

	<table>
		<tr>
			<th>댓글아이디</th>
			<th>내용</th>
			<th>작성날짜</th>
			<th>아이디</th>
			<th>게시물아이디</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="reply" items="${replyList}">
			<c:if test="${article.aid==reply.aid}">
				<tr>
					<td>${reply.rid}</td>
					<td>${reply.rcontent}</td>
					<td>${reply.rregdate}</td>
					<td>${reply.mid}</td>
					<td>${reply.aid}</td>
					<td>
						<input type="button" value="삭제" onclick="location.href='/deleteReply.do?rid=${reply.rid}';">
					</td>
				</tr>
			</c:if>
		</c:forEach>
	</table>
	<p>
		<input type="button" value="목록"
			onclick="location.href='/selectArticle.do';">
	</p>
	<h4>댓글등록</h4>
	<form action="/insertReply.do" method="post">
		내용 : <input type="text" name="rcontent"> 
		회원아이디 : <input type="text" name="mid"> 
		<input type="hidden" name="aid" value="${article.aid}">
		<input type="submit" value="댓글등록">
	</form>
</body>
</html>