<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "java.util.List, jp.co.aforce.Bean.SiteBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TOP</title>
<style>
* {
	font-family: Meiryo;
	width: auto;
}

h2 {
	text-align: center;
}

.here {
	width: 100px;
	height: 30px;
	margin-left: 20px;
	font-weight: bold;
}

.here:active {
	/*ボタンを押したとき*/
	-webkit-transform: translateY(4px);
	transform: translateY(2px);
	border-bottom: none;
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

.button2 {
	width: 100px;
	height: 30px;
	margin-left: 530px;
}

.button2:active {
	/*ボタンを押したとき*/
	-webkit-transform: translateY(4px);
	transform: translateY(2px);
	border-bottom: none;
}

table {
	margin-left: 20px;
}

.button3 {
	width: 80px;
	height: 30px;
}

.button3:active {
	/*ボタンを押したとき*/
	-webkit-transform: translateY(4px);
	transform: translateY(2px);
	border-bottom: none;
}
</style>
</head>
	
<body>

	<%@ include file="../jsp/header.jsp"%>

	<h2>NCT ALBUM</h2>

	<p>

<div style="display:inline-flex">

	<form action = "../servlet/menu-sort" method = "post">
		<input class = "here" type ="submit" value ="価格が安い順" name = "c">

		<input class = "button" type ="submit" value ="価格が高い順" name = "ex">

		<input class = "button" type ="submit" value ="商品名A~Z" name = "a">
	
		<input class = "button" type ="submit" value ="商品名Z~A" name = "z"></form>
		
	<form action = "../jsp/menu.jsp" method = "post">
		<input class = "button" type ="submit" value ="発売日"></form>
			
	<form action = "../jsp/cart.jsp" method = "post">
		<input class = "button2" type ="submit" value ="カート"></form>
		
</div>

<p>

	<% List<SiteBean> cheapList = (List<SiteBean>) session.getAttribute("cheapList"); %>

	<% if (cheapList.size()!=0) { %>

	<table>
	
	<% for (SiteBean s : cheapList) { %>

	<tr>

	<td>
		<img src = "<%=s.getImage() %>" width = "130" height = "130" alt = "アルバム写真" align = "top">
	</td>
	
	<td>	
		<%=s.getAlbum_name()%>　　<br>
		<%=s.getDay()%><br>
		\<%=s.getPrice()%><br>
	</td>
	
	<td>
		<form action = "../servlet/cart1" method = "post">
			<input type="hidden" name="num" value="<%=s.getNum()%>">
			<input class = "button3" type = "submit" value = "購入"></form>
	</td>
	
	<p>
	
	</tr>


	<% } %>
	</table>

	<% } else { %>
		<p>SOLD OUT<br>
		商品入荷までお待ちください。

	<% } %>

</body>
</html>