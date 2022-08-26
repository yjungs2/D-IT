<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2><b>상품이 저장되었습니다.</b></h2>
<b>상품 번호    </b><%= request.getParameter("seq") %><br>
<b>상 품 명    </b><%= request.getParameter("name") %><br>
<b>상품 가격    </b><%= request.getParameter("price") %><br>
<b>상품 설명    </b><%= request.getParameter("expl") %><br><br>
<a href="list.jsp">상품 목록</a>
</body>
</html>