<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">A Servlet Instance Initialization...Using ServletConfig</h2>
<h3><%= request.getParameter("userName") %>, <!--  출력 -->
<b><%= request.getParameter("message") %></b>
</h3>
</body>
</html>