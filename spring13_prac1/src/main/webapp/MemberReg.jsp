<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사원 관리</title>
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
	width:450px;
	padding:4px 0 4px 5px;
}
</style>
</head>
<body bgcolor=#FFFFFF>
<jsp:include page="/header.jsp"></jsp:include>
<!-- write Form  -->
<form method="post" action="saveMember.do">
	<table border="0" cellpadding="0" cellspacing="1">
		<tr>
			<td class="memCate">사원번호</td>
			<td class="memInfo"><input type="text" name="num"/> (사원번호 입력 형식 : 1403101)</td>
		</tr>
		<tr>
			<td class="memCate">사원명</td>
			<td class="memInfo"><input type="text" name="name"/></td>
		</tr>
		<tr>
			<td class="memCate">부서명</td>
			<td class="memInfo"><input type="text" name="dept"/></td>
		</tr>	  
	</table>
	<p align="center">
		<input type="submit" value="사원 등록" />&nbsp;
		<input type="reset" value="취소" />
	</p>
</form>

</body>

</html>