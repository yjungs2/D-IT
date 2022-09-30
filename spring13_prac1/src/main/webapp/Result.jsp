<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h2, h4, a {
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<h2>${member.num}${message}</h2>
	<h4><a href="./index.jsp">메인페이지</a></h4>
</body>
</html>