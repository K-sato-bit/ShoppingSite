<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UPDATE</title>
<style>
* {
	font-family: Meiryo;
	width: auto;
}

h2{
	text-align: center;
}

.page {
	text-align: center;
	padding: 30px 15px 15px;
	margin: 20px 200px;
	color: #5d627b;
	background: white;
	border-top: solid 5px silver;
	box-shadow: 0 3px 3px silver;
}

.text {
	display: inline-block;
    text-align: left;
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

.button {
	width: 100px;
	height: 35px;
	margin-right: 30px;
}

.button:active {
	/*ボタンを押したとき*/
	-webkit-transform: translateY(4px);
	transform: translateY(2px);
	border-bottom: none;
}

.button2 {
	width: 100px;
	height: 35px;
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
	
	<h2>UPDATE</h2>

	<jsp:useBean id="site" scope="session" class="jp.co.aforce.Bean.SiteBean"/>

<div class = "page">
	<form action = "../jsp/update-check.jsp" method = "post">
	
	<div class = "text">
		
		商品番号：　<jsp:getProperty property="num" name="site"/><br>
		
		アルバム名 　　　　　 　<input type = "text" size = "30" name = "album_name" value = "<jsp:getProperty property="album_name" name="site"/>"><p>
		
		発売日(*YYYY.MM.DD)　<input type = "text" size = "30" name = "day" value = "<jsp:getProperty property="day" name="site"/>"><p>

		価格(*数字)　　　　　 　<input type = "text" size = "30" name = "price" value = "<jsp:getProperty property="price" name="site"/>"><p>
		
		画像(*URL)　　　　　 　<input type = "text" size = "30" name = "image" value = "<jsp:getProperty property="image" name="site"/>"><p>
	
	</div>
	
	<p>
	
	<div style="display:inline-flex">
		<input class = "button" type = "submit" value = "変更">
		
	</form>
	
	<form action = "../servlet/edit" method = "post">
		<input type = "hidden" name = "num" value = "<%=site.getNum() %>">
		<input class = "button2" type = "submit" value = "戻る">
	</form>
	</div>

</div>
	
</body>
</html>