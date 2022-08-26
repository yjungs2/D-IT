<%@page import="servlet.model.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Book vo = (Book)session.getAttribute("vo");
%>
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
	<br><h2>결과 페이지</h2><br>
	<a><span style="color:orange"><%= vo.getTitle() %></span> 정상적으로 저장 되었습니다</a><br><br>
	<a href="book/Book.html">추가 등록</a>&nbsp;&nbsp;
	<a href="book/booklist.jsp">도서 목록</a>
</div>
</body>
</html>