<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/dayjs/1.11.9/dayjs.min.js"></script>
<script defer src="../js/board.js"></script>
<style>
table { width:860px; margin: 0 auto; }
table, tr, th, td { 
            border: 1px solid rgb(179, 244, 247);; border-collapse: collapse; 
        }
h3, th, td, p { height: 30px; line-height: 30px; text-align: center;}
tr:nth-child(even) { background-color: rgb(179, 244, 247); }
</style>
</head>
<body>
<%@ include file="/jsp/include/header.jsp" %>
	<h3>회원목록</h3>
	<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>별칭</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>삭제여부</th>
				<th>수정/삭제</th>
			</tr>
		</thead>
		<c:if test="${!empty memberList}">
		<tbody>
			<c:forEach var="member" items="${memberList}">
			<tr>
				<td> <a href='getMember.do?mid=${member.mid}';">${member.mid}</a></td>			
				<td>${member.mname}</td>			
				<td>${member.malias}</td>			
				<td>${member.memail}</td>			
				<td>${member.mcp}</td>			
				<td>${member.mdelyn}</td>			
				<td>
					<input class="locationBtn" type="button" value="수정" data-mid="${member.mid}"  data-ssmid="${sessionScope.ss_mid}" data-location="/updateMemberForm.do?mid=${member.mid}">&nbsp;
					<input class="locationBtn" type="button" value="삭제" data-mid="${member.mid}"  data-ssmid="${sessionScope.ss_mid}" data-location="/deleteMember.do?mid=${member.mid}">
				</td>
			</tr>
			</c:forEach>
		</tbody>
		</c:if>
	</table>
</body>
</html>