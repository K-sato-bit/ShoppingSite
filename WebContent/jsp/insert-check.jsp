<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="jp.co.aforce.Bean.SiteBean,java.util.List,java.util.ArrayList" %>
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

h2 {
	text-align: center;
}

p {
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
	height: 30px;
	margin-right: 20px;
}

.button:active {
	/*ボタンを押したとき*/
	-webkit-transform: translateY(4px);
	transform: translateY(2px);
	border-bottom: none;
}

.button2 {
	width: 100px;
	height: 30px;
}

.button2:active {
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
	
	<p>以下の内容を登録しますか？</p>
	
	<% String message = (String) request.getAttribute("message");
		if (message != null) { %>

	<div class="error"><%=(String) request.getAttribute("message")%></div>
	
	<% } %>
	
	<% SiteBean site = (SiteBean) session.getAttribute("site"); %>

	<form action = "../servlet/menu-ad" method = "post">
		<input class = "top" type ="submit" value ="TOP"></form>
	
<div class = "page">
<div class = "text">
	<table><tr>
		<td>
			<img src = "<%=site.getImage() %>" width = "130" height = "130" alt = "アルバム写真" align = "left">
		</td>
	
		<td>
			商品番号：<%=site.getNum()%><br>
			アルバム名：<%=site.getAlbum_name()%><br>
			発売日：<%=site.getDay()%><br>
			価格：<%=site.getPrice()%><br>
		</td>
	</tr></table>
	
	</div>
	
	<br clear="left">
	
<div style="display:inline-flex">
	<form action="../servlet/insert-end" method="post">
		<input class="button" type="submit" value="はい">
	</form>
	
	<form action="../jsp/insert.jsp" method="post">
		<input class="button2" type="submit" value="いいえ">
	</form>
</div>

</div>

</body>
</html>