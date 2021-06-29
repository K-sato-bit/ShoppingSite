<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD TO CART</title>
<style>
 	* {
 		font-family: Meiryo;
 	}
 	
 	.page {
 		 text-align: center;
 	}
	.button {
		width:120px;
		height:35px;
		margin-right: 20px;
	}
	
	.button:active {
  		/*ボタンを押したとき*/
 		 -webkit-transform: translateY(4px);
  		transform: translateY(2px);
  		border-bottom: none;
	}
	
	.button2 {
		width:120px;
		height:35px;
		margin-right: 20px;
	}
	
	.button2:active {
  		/*ボタンを押したとき*/
 		 -webkit-transform: translateY(4px);
  		transform: translateY(2px);
  		border-bottom: none;
	}
</style>
</head>

<body>

	<%@ include file="../jsp/header.jsp"%>
	
<div class = "page">
	<h2>ADD TO CART</h2>
	
	<p>商品をカートに追加しました。</p>
	
<div style="display:inline-flex">
	<form action = "../servlet/menu" method = "post">
		<input class = "button" type = "submit" value = "買い物を続ける">
	</form>
	
	<form action = "../servlet/cart" method = "post">
		<input class = "button2" type = "submit" value = "購入手続き">
	</form>
</div>

</div>

</body>

</html>