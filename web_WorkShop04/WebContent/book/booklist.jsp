<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<STYLE TYPE="text/css"> table {font-size: 9pt;} </STYLE>
</head>
<body>
<h2 align="center">전체 도서 List 보기</h2><br>
<table border="2" width="750" bgcolor="yellow" align="center">
	<c:forEach var="vo2" items="${list}">
		<tr>
			<td>${vo2.isbn}</td>
			<td>${vo2.title}</td>
			<td>${vo2.catalogue}</td>
			<td>${vo2.nation}</td>
			<td>${vo2.publish_date}</td>
			<td>${vo2.publisher}</td>
			<td>${vo2.author}</td>
			<td>${vo2.price}</td>
			<td>${vo2.description}</td>
		</tr>
	</c:forEach>
</table>

<h3 align="center"><a href="book/Book.html">등록 화면으로</a></h3>
<h3 align="center"><a href="login.jsp">로그인 화면으로</a></h3>
</body>
</html>