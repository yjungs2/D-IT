<%@page import="servlet.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	User vo = (User)session.getAttribute("vo");
	if(vo!=null) { // 로그인 된 상태라면
		session.invalidate(); // 세션을 죽인다.
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function logout() {
		alert("로그아웃~~");
	}
</script>
<style>
	.main {
		text-align:center;
		    }
</style>
</head>
<body onload="return logout()">
<div class="main">
	<br><h3>로그아웃 되었습니다.</h3><br>
	<a href="login.html">로그인 화면으로 이동</a>
</div>
</body>
</html>