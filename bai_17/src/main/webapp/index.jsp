<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.lang.Math" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP1</title>
</head>
<body>
		<%
			int a = 5;
			int b = 3;
			int sum = a + b;
			
			double canbachai = Math.sqrt(sum);
		%>
		
		<h3>Năm cộng ba = <%= sum %></h3>
		<h3>Căn bậc hai của <%= sum %> = <%= canbachai %></h3>
		 
</body>
</html>