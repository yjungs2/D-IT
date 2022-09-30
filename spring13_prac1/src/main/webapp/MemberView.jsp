<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
</style>
</head>

<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<form action="update.do">
		<table>
				<tr>
					<td class="memCate"><label for="num">사원번호</label></td>
					<td class="memInfo"><input type="text" name="num" id="num" readonly="readonly" value="${member.num }"></td>
				</tr>
				<tr>
					<td class="memCate"><label for="name">사원명</label></td>
					<td class="memInfo"><input type="text" name="name" id="name" value="${member.name }"></td>
				</tr>
				<tr>
					<td class="memCate"><label for="dept">부서명</label></td>
					<td class="memInfo"><input type="text" name="dept" id="dept" value="${member.dept }"></td>
				</tr>
		</table>
		<p align="center">
			<a href="searchMember.do"> <input type="button" value="사원 목록"></a>&nbsp;
			<input type="submit" value="수정">&nbsp;
			<a href="deleteAjax.do?num=${member.num}"> <input type="button" value="삭제"></a>
		</p>
	</form>
</body>
</html>