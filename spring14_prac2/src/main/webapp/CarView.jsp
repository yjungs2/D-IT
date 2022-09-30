<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>차량 조회</title>
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
	<form action="update.do" accept-charset="utf-8">
		<table>
				<tr>
					<td class="memCate"><label for="num">차량번호</label></td>
					<td class="memInfo"><input type="text" name="num" id="num" readonly="readonly" value="${car.num }"><a style="font-size:11px; color:red"> 수정 불가</a></td>
				</tr>
				<tr>
					<td class="memCate"><label for="name">모델명</label></td>
					<td class="memInfo"><input type="text" name="model" id="model" value="${car.model}"></td>
				</tr>
				<tr>
					<td class="memCate"><label for="price">가격</label></td>
					<td class="memInfo"><input type="text" name="price" id="price" value="${car.price}"> 만원</td>
				</tr>
				<tr>
					<td class="memCate"><label for="vendor">제조사</label></td>
					<td class="memInfo"><input type="text" name="vendor" id="vendor" value="${car.company.vendor}"></td>
				</tr>
		</table>
		<p align="center">
			<a href="searchCar.do"> <input type="button" value="자동차 목록"></a>&nbsp;
			<input type="submit" value="수정">
		</p>
	</form>
</body>
<script>
</script>
</html>