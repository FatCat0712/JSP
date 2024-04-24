<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page 1</title>
<style>
	body{
		background-color: lightblue;
	}
</style>

</head>
<body>
	<h1>This is page 1</h1>
	<img alt="image1" src="image/2.jpg">
	
	<div style="width: 50%">
		<a href="success.jsp">Homepage</a> | <a href="page2.jsp">page 2</a>
	</div>
	
	<form action="logout" method="get" style="margin-top: 15px">
			<input type="submit" value="Logout" style="font-weight: bold; font-size:15px" name="logout" >
	</form>
</body>
</html>