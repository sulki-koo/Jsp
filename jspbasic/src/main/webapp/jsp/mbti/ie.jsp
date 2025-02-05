<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<title>I/E</title>
</head>
<body>
	<form action="ieprop.jsp" method="post">
	<p>
		<input type="radio" name="ie" value="I" onchange="submitFrom()">I (내향)
		<input type="radio" name="ie" value="E" onchange="submitFrom()">E (외향)
	</p>
	<input type="submit" value="다음">
</body>
</html>

