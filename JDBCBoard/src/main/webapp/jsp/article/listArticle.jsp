<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<style>
table { width:860px; margin: 0 auto; }
table, th, td { 
            border: 1px solid #333; border-collapse: collapse; 
        }
        th, td { height: 30px; line-height: 30px; text-align: center;}
</style>
<table>
<c:forEach  var="article" items="${articleList}">
	<tr>
		<td>${article.aid}</td>
		<td>${article.asubject}</td>
		<td>${article.acontent}</td>
		<td>${article.avcnt}</td>
		<td>${article.aregdate}</td>
		<td>${article.adelyn}</td>
		<td>${article.aafcnt}</td>
		<td>${article.arcnt}</td>
		<td>${article.bid}</td>
		<td>${article.mid}</td>
	</tr>
</c:forEach>
</table>
