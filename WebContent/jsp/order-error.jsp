<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ORDER ERROR</title>
<style>
* {
	font-family: Meiryo;
	width: auto;
}

h2 {
	text-align: center;
}

.page {
	text-align: center;
}

.top {
	width: 100px;
	height: 30px;
	margin-left: 1100px;
}

.top:active {
	/*ボタンを押したとき*/
	-webkit-transform: translateY(4px);
	transform: translateY(2px);
	border-bottom: none;
}


</style>
</head>
<body>
	<%@ include file="../jsp/header.jsp"%>
	
	<h2>ORDER ERROR</h2>
	
	<div>
	<form action = "../servlet/menu" method = "post">
		<input class = "top" type ="submit" value ="TOP"></form></div>

<div class = "page">
	<p>購入手続きに失敗しました。<br>
	もう一度やり直してください。</p>

</div>

</body>
</html>