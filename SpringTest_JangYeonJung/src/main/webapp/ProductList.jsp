<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>
body{
	display:flex;
	flex-direction: column;
	align-items: center;
}
table, th, td{
	border:1px solid gray;
	border-collapse:collapse;
}
th, td{
	text-align:center;
	width:120px;
}
th{ background-color:#B0E0E6; }
input[type=button], input[type=submit], input[type=reset] {
	background-color:#191970;
	padding:6px;
	color:white;
	font-weight: bold;
	font-size:14px;
	border:none;
	border-radius:2px;
	cursor:pointer;
}
</style>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<table>
		<tr>
			<th>상품번호</th>
			<th>상품명</th>
			<th>상품분류</th>
			<th>이율</th>
		</tr>
		<c:forEach items="${car}" var="product">
			<tr>
				<td>${product.code}</td>
				<td><a class="products" id="${product.code}" href="detail.do?num=${product.code}">${product.model}</a></td>
				<td>${product.category}</td>
				<td>${product.rate}</td>
			</tr>
		</c:forEach>
	</table>
	<!-- <a id="memoPart" align="center">${product.memo }</a> -->
	<p align="center">
		<a href="regProduct.do"><input type="button" value="상품 등록"></a>&nbsp;
		<a href="/"> <input type="button" value="메인페이지"></a>
	</p>
</body>
</html>