<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<title>게시판목록</title>
<style>
table { width:400px; margin: 0 auto; }
table, tr, th, td { 
            border: 1px solid #333; border-collapse: collapse; 
        }
        h3, th, td, p { height: 30px; line-height: 30px; text-align: center;}
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
			<input type="button" value="등록" onclick="location.href='/insertBoardForm.do';">
		</p>
</body>
</html>