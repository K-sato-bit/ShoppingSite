<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
	.user {
		text-align: left;
	}
	
	.logout {
		text-align: right;
	}
</style>
</head>

<body>

	<div class = "user">
	
	USERNAME:<%=(String)session.getAttribute("username") %>
	
	</div>
	
	<div class = "logout">
	<form action= "../servlet/logout" method="post">
		<input type="submit" value="LOGOUT"></form><hr>
	</div>

</body>
</html>