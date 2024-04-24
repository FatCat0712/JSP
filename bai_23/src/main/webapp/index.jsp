<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Regular Expression</title>
<style>
	.error{
		color:red;
	}
</style>
</head>
<body>
	<%
		String value_quantity = request.getAttribute("value_quantity")+"";
		String value_phoneNumber = request.getAttribute("value_phoneNumber")+"";
		String value_email = request.getAttribute("value_email")+"";
		
	
		String e_quantity = request.getAttribute("e_quantity")+"";
		String e_phoneNumber = request.getAttribute("e_phoneNumber")+"";
		String e_email = request.getAttribute("e_email")+"";
		
		String status = request.getAttribute("success")+"";
	%>
	<form action="regex" method="get">
		<table style="margin-left: auto; margin-right: auto">
			<tr>
				<td colspan="3" style="background-color: lightblue; text-align: center">
					<h2>Regex</h2>
				</td>
			</tr>
			
			<tr>
				<td>Quantity: </td>
				<td>
					<input type="text" name="quantity"  value="<%=value_quantity.equals("null")?"":value_quantity%>" required="required"/>
				</td>
				
			</tr>
			
			<tr>
				<td colspan="2">
					<div class="error">
						<%=e_quantity.equals("null")?"":e_quantity %>
					</div>
				</td>	
			</tr>
			
			<tr>
				<td>Phone Number: </td>
				<td>
					<input type="text" name="phonenumber" value="<%=value_phoneNumber.equals("null")?"":value_phoneNumber%>" required="required"/>
				</td>				
			</tr>
			
			<tr>
				<td  colspan="2">
					<div class="error">
						<%=e_phoneNumber.equals("null")?"":e_phoneNumber %>
					</div>
				</td>
			</tr>
			
			<tr>
				<td>Email: </td>
				<td>
					<input type="text" name="email" value="<%=value_email.equals("null")?"":value_email%>" required="required"/>
				</td>
				
			</tr>
			
			<tr>
				<td colspan="2">
					<div class="error">
						<%=e_email.equals("null")?"":e_email %>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="Check" style="font-weight: bold; font-size: 15px; margin-top: 15px"/>
				</td>
			</tr>
			
			<tr>
				<td>
					<div style="color: green"><%=status.equals("null")?"":status %></div>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>