<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h2, h3, h4, a {
	text-align: center;
}
h2{
	color:#DC143C;
}
</style>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<h3>${message }</h3>
	<h4> <a href="./index.jsp">메인페이지</a></h4>
</body>
</html>