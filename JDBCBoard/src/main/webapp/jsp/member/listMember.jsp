<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<title>회원목록</title>
<style>
table { width:860px; margin: 0 auto; }
table, tr, th, td { 
            border: 1px solid #333; border-collapse: collapse; 
        }
        h3, th, td, p { height: 30px; line-height: 30px; text-align: center;}
</style>
</head>
<body>
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
					<input type="button" value="수정" onclick="location.href='/updateMemberForm.do?mid=${member.mid}';">&nbsp;
					<input type="button" value="삭제" onclick="location.href='/deleteMember.do?mid=${member.mid}';">
				</td>
			</tr>
			</c:forEach>
		</tbody>
		</c:if>
	</table>
		<p><input type="button" value="등록" onclick="location.href='/insertMemberForm.do';"></p>
</body>
</html>