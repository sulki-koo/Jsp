<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>

<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<title>게시물조회</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/dayjs/1.11.9/dayjs.min.js"></script>
	<script defer src="../js/board.js"></script>
<style>
#article { width: 400px; margin: 0 auto;}
#replyList, #content {width: 700px; margin: 0 auto;}

table, tr, th, td {
	border: 1px solid #333;
	border-collapse: collapse;
}

h3, th, td, p, form {
	height: 30px;
	line-height: 30px;
	text-align: center;
}

ul, li{list-style-type: none;}
ul li:nth-child(even) { background-color: silver; }
</style>
</head>
<body>
<%@ include file="/jsp/include/header.jsp" %>
	<h3>제목 : ${article.asubject}</h3>
	<table id="article">
		<tbody>
			<tr>
				<td>게시물아이디</td>
				<td>${article.aid}</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${article.avcnt}</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${article.mid}</td>
			</tr>
			<tr>
				<td>등록일시</td>
				<td><fmt:formatDate value="${article.aregdate}" pattern="M월 dd일 HH:mm"/></td>
			</tr>
			<tr>
				<td>첨부파일수</td>
				<td>${article.aafcnt}</td>
			</tr>
		</tbody>
	</table>
	<p>
		<input type="button" value="수정" onclick="location.href='/updateArticleForm.do?aid=${article.aid}';">&nbsp;
		<input type="button" value="삭제" onclick="location.href='/deleteArticle.do?aid=${article.aid}';">&nbsp;
		<input type="button" value="목록" onclick="location.href='/selectArticle.do';">
	</p>
		<table id="content">
			<tr>
				<td>내용</td>
			</tr>
			<tr>
				<td>${article.acontent}</td>
			</tr>
		</table>
	<br><br>
	<form action="/insertReply.do" method="post">
		[${sessionScope.ss_mid}님 댓글등록] 내용 : <input type="text" name="rcontent"> 
		<input type="hidden" name="mid" value="${sessionScope.ss_mid}"> 
		<input type="hidden" name="aid" value="${article.aid}">
		<input type="submit" value="등록">
	</form><br>
	<ul id="replyList" >
		<li></li>
	</ul>
	<script>
		$(function() {
			board.getReplyList('${article.aid}');
		});
	</script>
</body>
</html>