<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD</title>
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
	width:400px;
	height:30px;
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
	margin-left: auto;
	margin-right: auto;
}

.button:active {
	/*ボタンを押したとき*/
	-webkit-transform: translateY(4px);
	transform: translateY(2px);
	border-bottom: none;
}

.error{
	text-align: center;
	color: red;
	font-weight: bold;
}
</style>
</head>

<body>

	<%@ include file="../jsp/header.jsp"%>

	<h2>ADD</h2>
	
	<% String message = (String) request.getAttribute("message");
		if (message != null) { %>

	<div class="error"><%=(String) request.getAttribute("message")%></div>
	
	<% } %>
	
	<form action = "../servlet/menu-ad" method = "post">
		<input class = "top" type ="submit" value ="TOP"></form>

<div class = "page">
	<form action="../servlet/insert-check" method="post">
		
		商品番号　　　　　　　　
		<input class = "text" type="text" size="50" name="num"><p>
		
		画像（*URL）　　　　　
		<input class = "text" type="text" size="50" name="image"><p>
		
		アルバム名　　　　　　　
		<input class = "text" type="text" size="50" name="album_name"><p>
		
		発売日（*YYYY.MM.DD）
		<input class = "text" type="text" size="50" name="day"><p>
		
		価格（*数字）　　　　　
		<input class = "text" type="text" size="50" name="price"><p>
		
		<input class = "button" type="submit" value="登録">

	</form>
	
</div>

</body>
</html>