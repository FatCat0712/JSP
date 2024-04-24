<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page 2</title>
<style>
	body{
		background-color: lightyellow;
	}
</style>
</head>
<body>
	<h1>This is page 2</h1>
	<img alt="image2" src="image/3.jpg">
	
	<div style="width: 50%">
		<a href="success.jsp">Homepage</a> | <a href="page1.jsp">Page 1</a>
	</div>
	
	<form action="logout" method="get" style="margin-top: 15px">
			<input type="submit" value="Logout" style="font-weight: bold; font-size:15px" name="logout" >
	</form>	
</body>
</html>