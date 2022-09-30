<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>차량 목록</title>
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
			<th>차량번호</th>
			<th>모델 이름</th>
			<th>가격</th>
			<th>제조사명</th>
			<th>삭제</th>
		</tr>
		<c:forEach items="${car}" var="car">
			<tr>
				<td><a href="detail.do?num=${car.num}">${car.num}</a></td>
				<td>${car.model}</td>
				<td>${car.price}</td>
				<td>${car.company.vendor}</td>
				<td><input type="checkbox" data-num="${car.num}"></td>
			</tr>
		</c:forEach>
	</table>
	<p align="center">
		<a href="/"> <input type="button" value="메인페이지로"></a>&nbsp;
		<a href="regCar.do"><input type="button" value="추가 등록"></a>&nbsp;
		<a href="redirect:searchCar.do" id="selectedDel"><input type="button" value="선택항목 삭제"></a>
	</p>
</body>
<script type="text/javascript">
$('#selectedDel').click(function() {
	var param="";
	
	$(":checkbox:checked").each(function(index, item) {
		param = param + "&num=" + $(item).attr("data-num");
	});//each
	
	$.ajax({
		type:'post',
		url:'deleteAjax.do',
		data:param,
		
		success:function(result) {
			location.reload();
		}
	});
});
</script>
</html>