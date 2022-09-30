<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과 페이지</title>
<style type="text/css">
h2, h4, a {
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<h2>정상적으로 ${message} 되었습니다.</h2>
	<p align="center">
		<a href="regProduct.do">추가 등록</a>&nbsp;
		<a href="searchProduct.do">상품 목록</a>
	</p>
</body>
</html>