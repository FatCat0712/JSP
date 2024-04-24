<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
<style>
	a{
		padding-left: 50px;
	}
	body {
	 background-color: pink;
	}
</style>
</head>
<body>
		<% String username = (String)session.getAttribute("username"); %>
		
		<h1>Hi, <%=username %></h1>
		
		<h2>This is homepage</h2>
		
		
		<img alt="image1" src="image/1.jpg" height="500px">
		
		<div style="width: 50%">
			<a href="page1.jsp">Page 1</a> | <a href="page2.jsp">Page 2</a>
		</div>
		
		
		<form action="logout" method="get" style="margin-top: 15px">
			<input type="submit" value="Logout" style="font-weight: bold; font-size:15px" name="logout" >
		</form>
			
		
		
</body>
</html>