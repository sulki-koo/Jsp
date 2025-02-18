<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>

<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
<style>
table, tr, th, td {
	width: 400px;
	margin: 0 auto;
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
<%@ include file="/jsp/include/header.jsp" %>
	<h3>회원목록</h3>
	<table>
		<tbody>
			<tr>
				<td>아이디</td>
				<td>${member.mid}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${member.mname}</td>
			</tr>
			<tr>
				<td>별칭</td>
				<td>${member.malias}</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${member.memail}</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td>${member.mcp}</td>
			</tr>
			<tr>
				<td>삭제여부</td>
				<td>${member.mdelyn}</td>
			</tr>
		</tbody>
	</table>
	<p>
		<input type="button" value="목록"	onclick="location.href='/selectMember.do';">
	</p>
</body>
</html>