<%@page import="servlet.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.main {
		text-align:center;
		    }
</style>
</head>
<body>
<div class="main">
	<br><h3>${vo.name} 님이 로그인 되었습니다!!!</h3><br><br>
	<a href="book/Book.html">도서 등록</a><br><br>
	<a href="front.do?command=logout">로그아웃</a>
</div>
</body>
</html>