<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<title>JDBC게시판</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/reset-css@4.0.1/reset.min.css"/>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContenxt.request.contextPath}/css/board.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/dayjs/1.11.9/dayjs.min.js"></script>
<script defer src="${pageContenxt.request.contextPath}/js/board.js"></script>
</head>
<body>
<div id="wrapper">
<header>
	<h1>JDBC게시판</h1>
	<%@ include file="/jsp/include/nav.jsp" %>
	<c:if test="${empty sessionScope.ss_mid}">
		<form id="loginArea" name="loginForm" action="/login.do" method="post">
		<div class="row g-3">
			<div class="col-sm">
			    	<input type="text" name="mid" class="form-control" placeholder="ID" aria-label="ID">
			    	</div>
			    <div class="col-sm">
			    	<input type="password" name="mpass" class="form-control" placeholder="Password" aria-label="Password">
			  	</div>
			  <div class="col-sm">
				<input type="submit" value="로그인"  class="btn btn-outline-success">&nbsp;
				<input type="button" value="회원가입" onclick="location.href='/insertMemberForm.do'" class="btn btn-outline-info">&nbsp;
			</div>
			</div>
		</form>
	</c:if>
	<c:if test="${!empty sessionScope.ss_mid}">
		<p id="loginArea">
		${sessionScope.ss_mid}님 로그인중! <input type="button" value="로그아웃" onclick="location.href='/logout.do';" class="btn btn-outline-success">
		 </p>
	</c:if>
</header>