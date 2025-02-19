<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<title>게시물목록</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script defer src="../js/board.js"></script>
<style>
table {
	width: 800px;
	margin: 0 auto;
}

table, tr, th, td {
	border: 1px solid rgb(179, 244, 247);
	border-collapse: collapse;
}

h3, th, td, p {
	height: 30px;
	line-height: 30px;
	text-align: center;
}

tr:nth-child(even) { background-color: rgb(179, 244, 247); }
</style>
</head>
<body>
	<%@ include file="/jsp/include/header.jsp" %>
	<h3>게시물목록</h3>
	<p>
	<input id="insertBtn" type="button" value="등록" data-mid="${sessionScope.ss_mid}" data-location="/insertArticleForm.do">
	</p>
		<form action="/selectArticle.do" method="post">
		<select name="searchBoard">
			<option value="" <c:if test="${empty searchBoard}">selected</c:if>>전체</option>
		</select>&nbsp;
		<select name="searchClass">
			<option <c:if test="${empty searchClass}">selected</c:if>>전체</option>
			<option value="asubject" <c:if test="${searchClass=='asubject'}">selected</c:if>>제목</option>
			<option value="acontent" <c:if test="${searchClass=='acontent'}">selected</c:if>>내용</option>
			<option value="mid" <c:if test="${searchClass=='mid'}">selected</c:if>>작성자아이디</option>
		</select>&nbsp;
		<input type="text" name="searchVal" value="${searchVal}">&nbsp;
		<input type="submit" value="검색">
		</form>
	<table>
		<tr>
			<th>게시물아이디</th>
			<th>게시판</th>
			<th>제목</th>
			<th>조회수</th>
			<th>작성자</th>
			<th>등록일시</th>
			<th>댓글수</th>
			<th>첨부파일수</th>
		</tr>
		<c:forEach var="article" items="${articleList}">
			<tr>
				<td>${article.aid}</td>
				<td>${article.bname}</td>
				<td><a href='getArticle.do?aid=${article.aid}';">${article.asubject}</a></td>
				<td>${article.avcnt}</td>
				<td>${article.mid}</td>
				<td><fmt:formatDate value="${article.aregdate}" pattern="YY.MM.dd  HH:mm"/></td>
				<td>${article.arcnt}</td>
				<td>${article.aafcnt}</td>
			</tr>
		</c:forEach>
	</table>
<script>
	window.onload = function() {
    board.getBoardList();
	};
</script>
</body>
</html>
