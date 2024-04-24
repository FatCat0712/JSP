<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Purchase confirm</h1>
	<%
		String customerName = request.getParameter("name");
	
		String email = request.getParameter("email");
		
		String productName = request.getParameter("productName");
		
		String quantity = request.getParameter("quantity");
		
		int quant = 0;
		try{
			quant = Integer.parseInt(quantity);
			
		}catch(NumberFormatException ex)
		{
			
		}
		if(quant > 1){
			productName += "s";
		}
		
		
		
		
	%>
	<p>
		Thanks <b><%= customerName %></b> for booking <b><%= quant %></b> <b><%= productName %></b> </br>
		Your total is <b><%= quant * 5 %></b>.</br>
		Please pay through you email <b><%=email %></b>
	</p>
</body>
</html>