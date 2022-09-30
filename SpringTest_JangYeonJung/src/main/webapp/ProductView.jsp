<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 조회</title>
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
.memCate{
	width:150px;
	background-color:#B0E0E6;
	text-align:center;
	font-weight: bold;
}
.memInfo{
	width:250px;
	text-align:center;
	padding:4px 0 4px 5px;
}
form>label {
	display: inline-block;
	width: 100px;
}
form>:input {
	display: inline-block;
	width: 100px;
}
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
	<form accept-charset="utf-8">
		<table>
			<tr>
				<td class="memCate" colspan="2">상품 정보</td>
			</tr>
			<tr>
				<td class="memCate"><label for="title">상품명</label></td>
				<td class="memInfo"><a id="title">${product.num }</a></td>
			</tr>
			<tr>
				<td class="memCate"><label for="code">상품번호</label></td>
				<td class="memInfo"><a id="title">${product.code }</a></td>
			</tr>
			<tr>
				<td class="memCate"><label for="category">상품분류</label></td>
				<td class="memInfo"><a id="title">${product.category }</a></td>
			</tr>
			<tr>
				<td class="memCate"><label for="rate">이율</label></td>
				<td class="memInfo"><a id="title">${product.rate }</a></td>
			</tr>
			<tr>
				<td class="memCate"><label for="memo">상품설명</label></td>
				<td class="memInfo"><a id="title">${product.memo }</a></td>
			</tr>
		</table>
		<p align="center">
			<a href="searchProduct.do"> <input type="button" value="상품 목록으로 돌아가기"></a>&nbsp;
			<a href="deleteAjax.do?num=${product.code}"><input type="button" value="상품 삭제"></a>
		</p>
	</form>
</body>
<script>
</script>
</html>