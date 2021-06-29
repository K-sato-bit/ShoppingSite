<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
<style>
* {
	font-family: Meiryo;
	text-align: center;
}

.page {
	padding: 30px 15px 15px;
	margin: 20px 400px;
	color: #5d627b;
	background: white;
	border-top: solid 5px #9BF9CC;
	box-shadow: 0 3px 3px silver;
}

.login {
	margin-top: 15px;
	height: 30px;
	width: 150px;
	color: gray;
	font-weight: bold;
	background: white;
	border: solid 1.5px silver;
}

.login:active {
	/*ボタンを押したとき*/
	-webkit-transform: translateY(4px);
	transform: translateY(4px);
	border-bottom: none;
}

.error {
	color: red;
	font-weight: bold;
}
</style>
</head>

<body>

	<h2>LOGIN</h2>
	
	<%
		String message = (String) request.getAttribute("message");
		if (message != null) {
	%>

	<div class = "error"><%=(String) request.getAttribute("message")%></div>
	
	<% } %>
	
	<div class = "page">
	<form action = "../servlet/login" method = "post">
		
		USERNAME　　
		<input type = "text" name = "username"><p>
		
		PASSWORD　　
		<input type = "password" name = "password"><br>
		
		<input class = "login" type = "submit" value = "LOGIN">
		
	</form>
	</div>

</body>
</html>