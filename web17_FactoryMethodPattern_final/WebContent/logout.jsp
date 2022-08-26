<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- html 주석입니다...보입니다. -->
<%-- jsp 주석입니다...안 보입니다.
	로그인 되어져 있다면... 세션을 invalidate 시킵니다. --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	alert("로그아웃~~");
	// 자바스크립트에서 페이지 연결...
	location.href="index.jsp";
</script>
</head>
<body onload="return logout()">
<b>로그아웃 되었습니다...</b><br>
<a href="index.jsp">INDEX</a>
</body>
</html>