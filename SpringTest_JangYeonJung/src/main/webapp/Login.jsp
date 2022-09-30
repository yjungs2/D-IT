<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body{
	background-color: #d8f0f3;
	display:flex;
	justify-content: center;
	}
.bodyPart{
	margin-top:30px;
	width:500px;
	background-color:white;
	border-color:transparent;
	border-radius:5px;
	box-shadow:2px 3px 5px 2px #B0E0E6;
}
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
<script type="text/javascript">
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
<div class="bodyPart" align="center">
	<h2 align="center">로그인하여 주세요</h2>
	<form method = "post" name = "FrmLogin" action="login.do">
		<table>
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
</div>
</body>
</html>