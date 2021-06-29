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

h2,p{
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

.button {
	width: 100px;
	height: 30px;
	margin-left: 20px;
}

.button:active {
	/*ボタンを押したとき*/
	-webkit-transform: translateY(4px);
	transform: translateY(2px);
	border-bottom: none;
}

.top {
	width: 100px;
	height: 30px;
	margin-left: 1020px
}

.top:active {
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
	
	<h2>INSERT</h2>
	
	
<div style="display:inline-flex">
	<form action = "../jsp/insert.jsp" method = "post">
		<input class = "button" type ="submit" value ="登録" ></form>
		
	<form action = "../servlet/menu-ad" method = "post">
		<input class = "top" type ="submit" value ="TOP"></form>	
</div>

	<% int count = (Integer) request.getAttribute("count");
		if (count > 0) { %>
		
	<p>登録しました。</p>
	
	<% } else { %>
	
	<div class = "error">
		<p>*エラー　もう一度やり直してください。</p>
	</div>
	
	<% } %>
	
</body>
</html>