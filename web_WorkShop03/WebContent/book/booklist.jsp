<%@page import="servlet.model.BookDAOImpl"%>
<%@page import="servlet.model.Book"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Book> list = BookDAOImpl.getInstance().showAllBook();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">전체 도서 목록 보기</h2>
<table border="2" width="700" bgcolor="yellow" align="center">
<%
	for(Book vo : list) {
%>
	<tr>
		<td><%= vo.getIsbn() %></td>
		<td><%= vo.getTitle() %></td>
		<td><%= vo.getCatalogue() %></td>
		<td><%= vo.getNation() %></td>
		<td><%= vo.getPublish_date() %></td>
		<td><%= vo.getPublisher() %></td>
		<td><%= vo.getAuthor() %></td>
		<td><%= vo.getPrice() %></td>
	</tr>
<%
	}
%>
</table>
</body>
</html>