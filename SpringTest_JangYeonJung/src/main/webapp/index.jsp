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
.Cate{
	width:100px;
	background-color:#B0E0E6;
	text-align:center;
	font-weight: bold;
}
.Info{
	width:200px;
	padding:4px 0 4px 5px;
}
input[type=button], input[type=submit], input[type=reset] {
	background-color:#191970;
	padding:6px;
	color:white;
	font-weight: bold;
	font-size:14px;
	border:none;
	border-radius:2px;
	cursor:pointer;
}
</style>
<script>
function Login(){
	if(document.FrmLogin.user.value == "") {
		alert("ID를 입력하세요")
		document.FrmLogin.user.focus();
	}
	else if (document.FrmLogin.pass.value == "" ) {
		alert("비밀번호를 입력하세요")
		document.FrmLogin.pass.focus();
	}
	else {
		document.FrmLogin.submit() ;
	}
}
</script>
</head>
<body>
<div class="bodyPart">
	<h1> 메인 페이지 </h1>
	<p/>
	<p/>
	<c:choose>
		<c:when test="${empty loginUser}">
			<a>${error}</a>
			<h2 align="center">로그인하여 주세요</h2>
			<form method = "post" name = "FrmLogin" action="login.do">
				<table align="center">
					<tr>
						<td class="Cate">아이디</td>
						<td Class="Info" align="center">
							<input TYPE= "text" name="id"  class="input"  tabindex=1 onKeyPress="if (event.keyCode == 13) Login();" style='width:120;height:20;'>
						</td>
					</tr>
					<tr>
						<td class="Cate">비밀번호</td>
						<td Class="Info" align="center">
							<input TYPE="password" name="pw"  class="input"  tabindex=2 onKeyPress="if (event.keyCode == 13) Login();" style='width:120;height:20;'>
						</td>
					</tr>
				</table>
				<p align="center">
					<input type="submit" value="LOGIN">
				</p>
			</form>
		</c:when>
		<c:when test="${!empty loginUser}">
			<h4>${loginUser.id} 님, 로그인 되었습니다. </h4>
			<h4> <a href="regProduct.do">상품 등록</a> </h4>
			<h4> <a href="searchProduct.do">상품 목록</a></h4>
			<h4> <a href="logout.do">로그아웃</a></h4>
		</c:when>
	</c:choose>
</div>
</body>
</html>