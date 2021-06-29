<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="jp.co.aforce.Bean.SiteBean,java.util.List,java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EDIT</title>
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

table {
	margin-left: auto;
	margin-right: auto;
	border-collapse:  collapse; /* セルの線を重ねる */
}
td {
    border: solid 1px sliver;  /* 枠線指定 */
    padding: 10px;      /* 余白指定 */
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
	
	<% request.setCharacterEncoding("UTF-8"); %>
	
	<h2>UPDATE</h2>
	<p>以下の内容を変更しますか。</p>
	

<div>
	<form action = "../servlet/menu-ad" method = "post">
		<input class = "top" type ="submit" value ="TOP"></form>
</div>
	
<div class = "page">
	<jsp:useBean id="site" scope="session" class="jp.co.aforce.Bean.SiteBean"/>
	
	<table><tr>
		<td>
			<img src = "<jsp:getProperty property="image" name="site"/>" width = "100" height = "100" alt = "アルバム写真" align = "left"><br>
		</td>
		
		<td>
			<jsp:setProperty property="num" name ="site" param="num"/>
			<jsp:setProperty property="album_name" name ="site" param="album_name"/>
			<jsp:setProperty property="day" name ="site" param="day"/>
			<jsp:setProperty property="price" name ="site" param="price"/>
			<jsp:setProperty property="image" name ="site" param="image"/>
		
			<div class = "text">
				商品番号：<jsp:getProperty property="num" name ="site"/><br>
				アルバム名 ：<jsp:getProperty property="album_name" name ="site"/><br>
				発売日：<jsp:getProperty property="day" name ="site"/><br>
				価格：<jsp:getProperty property="price" name ="site"/><br>
				画像：<jsp:getProperty property="image" name ="site"/><br>
			</div>
		</td>
	</tr></table>
	
	<p>
	
<div style="display:inline-flex">
	<form action = "../servlet/update-check" method = "post">
		<input class = "button" type = "submit" value = "はい">
	</form>
	
	<form action = "../jsp/update.jsp" method = "post">
		<input class = "button2" type = "submit" value = "いいえ">
	</form>
	
</div>

</div>

</body>
</html>