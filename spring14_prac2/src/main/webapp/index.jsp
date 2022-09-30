<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
<style type="text/css">
body{
	background-color: #d8f0f3;
	display:flex;
	justify-content: center;
	}
.bodyPart{
	margin-top:30px;
	width:60%;
	min-width:400px;
	background-color:white;
	border-color:transparent;
	border-radius:5px;
	box-shadow:2px 3px 5px 2px #B0E0E6;
}
h1, h4 { text-align: center; }
</style>
</head>
<body>
<div class="bodyPart">
	<h1> 메인 페이지 </h1>
	<p/>
	<p/>
	<c:choose>
		<c:when test="${empty loginUser}">
			<h4> <a href="login.do">로그인</a></h4>
			<h4> <a href="register.do">회원가입</a></h4>
		</c:when>
		<c:when test="${!empty loginUser}">
			<h4> <a href="regCar.do">차량 등록</a> </h4>
			<h4> <a href="searchCar.do">차량 목록</a></h4>
			<h4> <a href="logout.do">로그아웃</a></h4>
		</c:when>
	</c:choose>
	<!-- <h4> <a href="rest.do">RestClient</a></h4> -->
</div>
</body>
</html>