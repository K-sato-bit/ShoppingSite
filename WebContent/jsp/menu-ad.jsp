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

.button {
	width: 100px;
	height: 30px;
	margin-left: 20px;
	margin-right: 30px;
}

.button:active {
	/*ボタンを押したとき*/
	-webkit-transform: translateY(4px);
	transform: translateY(2px);
	border-bottom: none;
}

.button2 {
	width: 80px;
	height: 30px;
	
}

.button2:active {
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

.error {
	color: red;
	font-weight: bold;
}
</style>
</head>

<body>

	<%@ include file="../jsp/header.jsp"%>

	<h2>NCT ALBUM</h2>

	<%
		String message = (String) request.getAttribute("message");
		if (message != null) {
	%>

	<div class = "error"><%=(String) request.getAttribute("message")%></div>
	
	<% } %>

	<form action = "../jsp/insert.jsp" method = "post">
		<input class = "button" type ="submit" value ="登録"></form>
</div>

<p>

	<% List<SiteBean> siteList = (List<SiteBean>) request.getAttribute("siteList"); %>

	<table>

		<tr>
			<th>NUMBER</th>
			<th>ALBUM NAME</th>
			<th>DAY</th>
			<th>PRICE</th>
			<th>IMAGE</th>
			<th></th>

		</tr>
		
		<% for (SiteBean site : siteList) { %>
			
		<tr>
			<td><%=site.getNum() %></td>
			<td><%=site.getAlbum_name() %></td>
			<td><%=site.getDay() %></td>
			<td><%=site.getPrice() %></td>
			<td><%=site.getImage() %></td>
				
			<td>
				<form action = "../servlet/edit" method = "post">
					<input type = "hidden" name = "num" value="<%=site.getNum() %>">
					<input class = "button2" type ="submit" value = "編集">
				</form>
			</td>
		</tr>
		
		<% } %>
	</table>

</body>
</html>