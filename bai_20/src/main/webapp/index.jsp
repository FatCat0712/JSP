<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	align-self: center;
}
</style>

</head>
<body>
	<form action="trangDatHang.jsp" method="get" onsubmit="return checkInvalid(this)">
		<table style="margin-left: auto; margin-right: auto">
			<tr>
				<td colspan="2"
					style="background-color: lightblue; text-align: center">
					<h2 style="margin-bottom: 15px">Purchase Order</h2>
				</td>
			</tr>
			<tr>
				<td><label>Customer Name : </label></td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td><label>Email: </label></td>
				<td><input type="email" name="email" /></td>
			</tr>
			<tr>
				<td><label>Product Name: </label></td>
				<td><input type="text" name="productName" /></td>
			</tr>
			<tr>
				<td><label>Quantity: </label></td>
				<td><input type="text" name="quantity" id="quantity"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"
					style="margin-top: 10px; font-weight: bold; width: 100px"/></td>
			</tr>
		</table>
	</form>
	<script src="script/buy.js"></script>
</body>
</html>