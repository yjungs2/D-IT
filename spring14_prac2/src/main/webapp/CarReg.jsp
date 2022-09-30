<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>차량 등록</title>
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
<form method="post" action="saveCar.do">
	<table border="0" cellpadding="0" cellspacing="1">
		<tr>
			<td class="Cate">차량번호</td>
			<td class="Info"><input type="text" name="num"/></td>
		</tr>
		<tr>
			<td class="Cate">모델명</td>
			<td class="Info"><input type="text" name="model"/></td>
		</tr>
		<tr>
			<td class="Cate">가격</td>
			<td class="Info"><input type="text" name="price"/> 만원</td>
		</tr>	
		<tr>
			<td class="Cate">제조사코드</td>
			<td class="Info">
				<select name="vcode" style="width:100px;">
					<option value="10">10</option>
					<option value="20">20</option>
					<option value="30">30</option>
				</select>
			</td>
		</tr>  
	</table>
	<p align="center">
		<input type="submit" value="자동차 등록" />&nbsp;
		<input type="reset" value="취소" />
	</p>
</form>

</body>

</html>