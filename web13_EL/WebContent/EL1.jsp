<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>이것은 원래 서블릿입니다.</h2>
<h2>Attribute에 바인딩된 값 EL로 받아오기</h2>
<%
	int sum = 0;
	for(int cnt=0; cnt<=50; cnt++) sum+= cnt; // 1275
	
	// 반환값이 있으면 무조건 바인딩 -> 바인딩 3종류
	// 내장 객체
	request.setAttribute("RESULT", sum); // 클라이언트가 요청할 때 생성
	session.setAttribute("RESULT", "session"); // 클라이언트가 요청할 때 생성
	application.setAttribute("NAME", "BNK"); // servletContext
	
	// forwarding 방법으로 이동
	request.getRequestDispatcher("EL1_View.jsp").forward(request, response);
%>
</body>
</html>