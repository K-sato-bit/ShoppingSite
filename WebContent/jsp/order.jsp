<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "java.util.List,jp.co.aforce.Bean.SiteBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ORDER</title>
<style>
* {
	font-family: Meiryo;
	width: auto;
}

h2,p {
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

table {
	margin-left: auto;
	margin-right: auto;
	border-collapse:  collapse; /* セルの線を重ねる */
}
th,td {
    border: solid 1px sliver;  /* 枠線指定 */
    padding: 10px;      /* 余白指定 */
}

.button {
	width: 110px;
	height: 35px;
}

.button:active {
	/*ボタンを押したとき*/
	-webkit-transform: translateY(4px);
	transform: translateY(2px);
	border-bottom: none;
}

.page {
	text-align: center;
	padding: 30px 15px 15px;
	margin: 20px 200px;
	color: #5d627b;
	background: white;
	border-top: solid 5px #4DF9B9;
	box-shadow: 0 3px 3px silver;
}

.page2 {
	text-align: center;
}

.text {
	display: inline-block;
    text-align: left;
 }
 
 .text2 {
    text-align: center;
 }

</style>
</head>

<body>

	<%@ include file="../jsp/header.jsp"%>
	
	<h2>ORDER</h2>
	
	<div>
	<form action = "../servlet/menu" method = "post">
		<input class = "top" type ="submit" value ="TOP"></form></div>
	
	<% List<SiteBean> cart = (List<SiteBean>) session.getAttribute("cart"); %>
	
<div class = "page">
	<p>商品：<%=cart.size() %>点</p>
	
	<% for (SiteBean s : cart) { %>
	
	<div class = "text">
		<table>
		<tr>
			<td>
				<img src = "<%=s.getImage() %>" width = "100" height = "100" alt = "アルバム写真" align = "top">
			</td>
	</div>	
			<td>【<%=s.getAlbum_name()%>】</td>
			
			<td><%=s.getPrice()%>円</td>
			
			<td><%=s.getAlbum_count()%>枚</td>
			
			<td><%=s.getSub_total() %>円</td>
		</tr>
	</table>
	
	
	<% } %>
	
	<% SiteBean userinfo = (SiteBean)session.getAttribute("userinfo"); %>

<div class = "text2">
	合計：<%=userinfo.getTotal() %>円<br>
	
	購入者：<%=session.getAttribute("username") %>
</div>

</div>

<p>

<div class = "page2">
	<form action = "../servlet/order2" method = "post">
		<input class = "button" type = "submit" value = "購入"></form>
</div>
	
</body>
</html>