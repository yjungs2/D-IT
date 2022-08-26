<%@page import="servlet.model.ProductDAOImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="servlet.model.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">OPTI-FREE Product Register<br><br>
전체 상품 리스트 보기</h2><br>
<table border="2" width="450" bgcolor="yellow" align="center">
	<%
		ProductDAOImpl dao = ProductDAOImpl.getInstance();
		ArrayList<ProductVO> list = dao.showAllProduct();
		for(ProductVO vo : list) {
	%>
	<tr>
		<td><%=vo.getName()%></td>
		<td><%=vo.getPrice()%></td>
		<td><%=vo.getExpl()%></td>
	</tr>
	<%
		}
	%>
</table>
<br>
<h2 align="center"><a href="register.html">상품 등록</a></h2>
</body>
</html>