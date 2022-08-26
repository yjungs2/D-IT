<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- html 주석입니다...보입니다. -->
<%-- jsp 주석입니다...안 보입니다.
	로그인 되어져 있다면... 세션을 invalidate 시킵니다. --%>
<%
	MemberVO vo = (MemberVO)session.getAttribute("vo");
	if(vo==null) { // 로그인 안 되어있다면
%>
	<h2><a href="login.jsp">로그인 하기</a></h2>
<%
	} else { // 로그인 된 상태라면..
		session.invalidate(); // 세션을 죽인다 = 세션을 unbind 시킴
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function logout() {
	}
</script>
</head>
<body onload="return logout()">
<b>로그아웃 되었습니다...</b><br>
<a href="index.html">INDEX</a>
</body>
</html>