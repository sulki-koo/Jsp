<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<title>게시판목록</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/dayjs/1.11.9/dayjs.min.js"></script>
<script defer src="../js/board.js"></script>
<style>
table { width:400px; margin: 0 auto; }
table, tr, th, td { 
            border: 1px solid rgb(179, 244, 247); border-collapse: collapse; 
        }
h3, th, td, p { height: 30px; line-height: 30px; text-align: center;}
tr:nth-child(even) { background-color: rgb(179, 244, 247); }
</style>
</head>
<body>
<%@ include file="/jsp/include/header.jsp" %>
	<h3>게시판목록</h3>
	<table>
		<thead>
			<tr>
				<th>게시판아이디</th>
				<th>게시판명</th>
				<th>게시물수</th>
			</tr>
		</thead>
		<c:if test="${!empty boardList}">
		<tbody>
			<c:forEach var="board" items="${boardList}">
			<tr>
				<td>${board.bid}</td>			
				<td>${board.bname}</td>			
				<td>${board.bacnt}</td>			
			</tr>
			</c:forEach>
		</tbody>
		</c:if>
	</table>
		<p>
			<input id="insertBtn" type="button" value="등록" data-mid="${sessionScope.ss_mid}" data-location= "insertBoardForm.do">
		</p>
</body>
</html>