<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
<style>
	table {
		border: 1px solid black;
		border-collapse: collapse;
		width: 50%;
	}
	th,td{
		border: 1px solid black;
	}
</style>
</head>
<body>
	
	<%
		String value_productId = request.getAttribute("value_productId")+"";
		String value_productName = request.getAttribute("value_productName")+"";
		String value_sellingPrice = request.getAttribute("value_sellingPrice")+"";
		String value_purchasePrice = request.getAttribute("value_purchasePrice")+"";
		String value_expireDate = request.getAttribute("value_expireDate")+"";
		String value_vat = request.getAttribute("value_vat")+"";
		String value_description = request.getAttribute("value_description")+"";
	 %>


	<h1>Save successfully</h1>
	<table>
		<tr>
			<td colspan="7" style="text-align: center; background-color: lightblue"><h2>Product Details</h2></td>
		</tr>
			
		<tr>
			<th>ProductId</th>
			<th>Product Name</th>
			<th>Purchase Price</th>
			<th>Selling Price</th>
			<th>ExpireDate</th>
			<th>VAT</th>
			<th>Description</th>
		</tr>
		
		<tr>
			<td>
				<%=value_productId %>
			</td>
			
			<td>
				<%=value_productName %>
			</td>
			
			<td>
				<%=value_purchasePrice %>
			</td>
			
			
			<td>
				<%=value_sellingPrice %>
			</td>
			
			<td>
				<%=value_expireDate.equals("null")?"":value_expireDate %>
			</td>
			
			<td>
				<%=value_vat.equals("null")?"":value_vat %>
			</td>
			
			<td>
				<%=value_description.equals("null")?"":value_description %>
			</td>
			
			
			
			
		</tr>
	</table>
</body>
</html>