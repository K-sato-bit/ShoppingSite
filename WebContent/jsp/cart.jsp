<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     import = "java.util.List,java.util.ArrayList, jp.co.aforce.Bean.SiteBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CART</title>
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

.button {
	width: 100px;
	height: 35px;
	
}

.button:active {
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

.button2 {
	width: 100px;
	height: 35px;
	margin-right: 20px;
	font-weight: bold;
}

.button2:active {
	/*ボタンを押したとき*/
	-webkit-transform: translateY(4px);
	transform: translateY(2px);
	border-bottom: none;
}

.button3 {
	width: 110px;
	height: 35px;
}

.button3:active {
	/*ボタンを押したとき*/
	-webkit-transform: translateY(4px);
	transform: translateY(2px);
	border-bottom: none;
}

.page {
	text-align: center;
}
</style>
</head>

<body>

	<%@ include file="../jsp/header.jsp"%>
	
	<h2>CART</h2>
	
	<div>
	<form action = "../servlet/menu" method = "post">
		<input class = "top" type ="submit" value ="TOP"></form></div>
	
	<% List<SiteBean> cart = (List<SiteBean>) session.getAttribute("cart"); %>
	
	<% if(cart == null) {
			cart = new ArrayList<SiteBean>();
			session.setAttribute("cart", cart); } %>
		
	<% if(cart.size() == 0) { %>
			
		<p>カートに商品がありません。</p>

	<%  } else { %>
	
	<p>商品：<%=cart.size() %>点</p>
	
	<table>
	
		<tr>
			<th></th>
			<th>ALBUM NAME</th>
			<th>PRICE</th>
			<th>SET</th>
			<th></th>
			<th></th>
		</tr>
		
		<% for (SiteBean s : cart) { %>

		<tr>
			<td>
				<img src = "<%=s.getImage() %>" width = "100" height = "100" alt = "アルバム写真" align = "top">
			</td>
			
			<td><%=s.getAlbum_name()%></td>
			
			<td><%=s.getPrice()%>円</td>
			
			<td><%=s.getAlbum_count()%>枚</td>
			
			<td>
				<form action = "../servlet/cart-delete" method = "post">
					<input type="hidden" name="num" value="<%=s.getNum()%>">
					<input class = "button" type = "submit" value = "削除"></form>
			</td>

			<td><form action = "../servlet/order1" method = "post">
					<input type="hidden" name="album_name" value="<%=s.getAlbum_name()%>">
					<input class = "button2" type = "submit" value = "購入手続き"></form>
			</td>
		</tr>
	
		<% } %>		
	</table>

<p>

<div class = "page">
	<form action = "../servlet/menu" method = "post">
		<input class = "button3" type = "submit" value = "買い物を続ける"></form>
</div>

<% } %>	

</body>
</html>