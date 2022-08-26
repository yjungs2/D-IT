<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>장바구니</title>
<style type="text/css">
	header {
		text-align: center;
		padding: 30px 10px 0 10px;
	}
	#continue{
		text-align:right;
	}
	table{
		width:100%;
		text-align:center;
		padding:2px 2px;
	}
	table tr, td, th{
		border:1px solid black;
	}
	table th{
		background-color:#dddddd;
	}
	#tablebt{
		background-color:#dddddd;
		text-align:right;
		padding: 0 20px;
	}
</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script>
$(function() {
	refreshPage();
	
	$('#cartdelete').click(function () {
		var checkArr = $('#checkdelete:checked');
		$(checkArr).each(function(index, item){
			//alert($(this).val());
			localStorage.removeItem($(this).val());
		});
		refreshPage();
	});
	$('#tablecontent').on('click', '[name=countup]', function() {
		// db 업데이트
		// setItem
		let keynow = $(this).parent().parent().find("td[class=key]").text();
		var data = localStorage.getItem(keynow).split(", ");
		var countch = eval(data[3])+1;
		localStorage.setItem(keynow, data[0]+", "+data[1]+", "+data[2]+", "+countch);
		refreshPage();
	});
	$('#tablecontent').on('click', '[name=countdown]', function() {
		let keynow = $(this).parent().parent().find("td[class=key]").text();
		var data = localStorage.getItem(keynow).split(", ");
		if(eval(data[3])>1) {
			var countch = eval(data[3])-1;
			localStorage.setItem(keynow, data[0]+", "+data[1]+", "+data[2]+", "+countch);
			refreshPage();
		}
	});
});

function refreshPage(){
	var html='';
	var finalhtml='';
	var totalPrice = 0;
	//var eachcount = 1;
	for(var key in localStorage) {
		if(key=='length') break;
		//var data2 = localStorage.getItem(key) + ", 1";
		// alert(data2);
		var data = localStorage.getItem(key).split(", ");
		html += '<tr><td class="key">'+key+'</td><td><img src='+data[0]+' width="auto" height="100"></td><td>'
				+data[1]+'</td><td>'+data[2]+'</td><td>'
				+'<img src=img/up.jpg width="10" height="10" name="countup" value="'+localStorage.getItem(key)+'"><br>'
				+'<a name="countnow">'+data[3]+'</a>'
				+'<br><img src=img/down.jpg width="10" height="10" name="countdown" value="'+localStorage.getItem(key)+'">'
				+'</td><td><input type="checkbox" id="checkdelete" value="'+key+'"></td></tr>';
		totalPrice += parseInt(data[2]*data[3]);
	} // for
	$('#tablecontent').html(html);
	finalhtml += '<tr id="tablebt"><td colspan="6">총 결제금액 : '+totalPrice+'</td></tr>';
	$('#tablecontent').append(finalhtml);
}
</script>
</head>
<body>
<div class="container">
	<header>
		<h1>장바구니</h1>
	</header>
	<p id="continue"><a text-align="right" href="itemList.do">쇼핑 계속하기</a></p>
	<table>
		<tr>
			<th>번호</th>
			<th>상품이미지</th>
			<th>상품명</th>
			<th>상품가격</th>
			<th>수량</th>
			<th><input type="button" value="삭제" id="cartdelete"></th>
		</tr>
		<tbody id="tablecontent"></tbody>
	</table>
</div>
</body>
</html>