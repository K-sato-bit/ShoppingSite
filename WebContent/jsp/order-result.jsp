<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "jp.co.aforce.Bean.SiteBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ORDER COMPLETED</title>
<style>
* {
	font-family: Meiryo;
	width: auto;
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

	<%@ include file="../jsp/header.jsp"%>

<div class = "page">
	<h2>ORDER COMPLETED</h2>
	
	<div>
	<form action = "../servlet/menu" method = "post">
		<input class = "top" type ="submit" value ="TOP"></form></div>
		
	<p>ご注文ありがとうございました。</p>
	
	<% SiteBean userinfo = (SiteBean)session.getAttribute("userinfo"); %>
	
	注文番号：
	<%=userinfo.getCart_no() %>

</div>

</body>
</html>