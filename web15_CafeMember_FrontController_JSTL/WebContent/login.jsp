<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>LOGIN PAGE</h2>
<form action="front.do" method="post">
	<input type="hidden" name="command" value="login">
	
	ID <input type="text" name="id" required="required"><br><br>
	PASSWORD <input type="password" name="password" required="required"><br><br>
	<br><br>
	<input type="submit" value="LOGIN">
</form>
</body>
</html>