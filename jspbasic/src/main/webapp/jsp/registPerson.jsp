<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<title>Person등록</title>
<style>
	h3, form, input {background-color: aqua; text-align: center;}
</style>
</head>
<body>
	<h3>Person 등록</h3>
	<form action="registPeronProc.jsp" method="post">
		이름 : <input type="text" name="name"><br> 
		나이 : <input type="text" name="age"><br> 
		<input type="submit" value="등록">
	</form>
</body>
</html>