<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 등록</title>
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
.Cate{
	width:150px;
	background-color:#B0E0E6;
	text-align:center;
	font-weight: bold;
}
.Info{
	width:450px;
	padding:4px 0 4px 5px;
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
<body bgcolor=#FFFFFF>
<jsp:include page="/header.jsp"></jsp:include>
<!-- write Form  -->
<form method="post" action="saveProduct.do">
	<table border="0" cellpadding="0" cellspacing="1">
		<tr>
			<td class="Cate">상품번호</td>
			<td class="Info"><input type="text" name="code" size="10"/><a style="font-size:11px; color:red"> 필수 입력 항목</a></td>
		</tr>
		<tr>
			<td class="Cate">상품제목</td>
			<td class="Info"><input type="text" name="title" size="40"/><a style="font-size:11px; color:red"> 필수 입력 항목</a></td>
		</tr>	
		<tr>
			<td class="Cate">상품종류</td>
			<td class="Info">
				<select name="category" style="width:100px;">
					<option value="목돈마련">목돈마련</option>
					<option value="주택마련">주택마련</option>
					<option value="학자금">학자금</option>
				</select>
				<a style="font-size:11px; color:red"> 필수 입력 항목</a>
			</td>
		</tr>
		<tr>
			<td class="Cate">이율</td>
			<td class="Info"><input type="text" name="rate"/></td>
		</tr>
		<tr>
			<td class="Cate">상품설명</td>
			<td class="Info"><textarea name="memo" rows="3" value="" cols="40"></textarea></td>
		</tr>	
	</table>
	<p align="center">
		<input type="submit" value="상품 저장" />&nbsp;
		<input type="reset" value="취소" />
	</p>
</form>

</body>

</html>