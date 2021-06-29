<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DELETE</title>
<style>
* {
	font-family: Meiryo;
	width: auto;
}

h2,p{
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

.error{
	text-align: center;
	color: red;
	font-weight: bold;
}
</style>
</head>

<body>
	<%@ include file="../jsp/header.jsp"%>		
	
	<h2>DELETE</h2>
	
	<form action = "../servlet/menu-ad" method = "post">
		<input class = "top" type = "submit" value = "TOP">
	</form>
	
	<p>削除しました。</p>
	
</body>
</html>