<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<style>
	h1, h3, form, p {text-align: center;}
</style>
<header>
	<p>
	<c:if test="${empty sessionScope.ss_mid}">
		<form name="loginForm" action="/login.do" method="post">
			ID : <input type="text" name="mid">&nbsp;
			PASS : <input type="password" name="mpass">&nbsp;
			<input type="submit" value="로그인">&nbsp;
			<input type="button" value="회원가입" onclick="location.href='/insertMemberForm.do'">&nbsp;
		</form>
	</c:if>
	<c:if test="${!empty sessionScope.ss_mid}">
		<p>
		${sessionScope.ss_mid}님 로그인중! <input type="button" value="로그아웃" onclick="location.href='/logout.do';">
		<a href='/selectMember.do'>회원관리</a>
		<a href='/selectBoard.do'>게시판관리</a>
		<a href='/selectArticle.do'>게시물관리</a>
		 </p>
	</c:if>
	</p>
	</header>	