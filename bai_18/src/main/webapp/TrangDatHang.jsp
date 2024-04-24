<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Page</title>
</head>
<body>
	<% 
		String productName = request.getParameter("product");
		String amount = request.getParameter("number");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
	%>
	
	<h2>Order confirm</h2>
	<p> Xin cảm ơn <b>bạn <%= name %></b> đã đặt <strong><%= amount %> <%= productName %></strong> </p>
	<p> Vui lòng kiểm tra hóa đơn tại <%= email %> </p>
</body>
</html>