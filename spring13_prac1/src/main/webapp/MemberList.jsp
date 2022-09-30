<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
}
th{ background-color:#B0E0E6; }
td{ width:150px; }
</style>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<table>
		<tr>
			<th>사원번호</th>
			<th>사원명</th>
			<th>부서명</th>
		</tr>
		<c:forEach items="${member}" var="member">
			<tr>
				<td>${member.num}</td>
				<td><a href="detail.do?num=${member.num}">${member.name}</a></td>
				<td>${member.dept}</td>
			</tr>
		</c:forEach>
	</table>
	<h4><a href="regMember.do">추가 등록</a></h4>
</body>
</html>