<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>LOGIN INFORMATION</h2>
ID ${vo.id}<br>
NAME ${vo.name}<br>
ADDRESS ${vo.address}<br>
<p></p><hr><p></p>
<a href="logout.jsp">LOGOUT</a>&nbsp;&nbsp;&nbsp;&nbsp; <!-- &nbsp; 공백 -->
<a href="index.jsp">INDEX</a>
</body>
</html>