<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP2</title>
</head>
<body>
	<form action="TrangDatHang.jsp" method="get">
			<table >
					<tr>
						<td colspan="2" style="background-color: lightblue; text-align: center; height: 80px">
							<h2 style="margin-bottom: 5px">Purchase Order</h2>
						</td>
					</tr>
					<tr>
						<td align="right">Sản phẩm</td>
						<td>
							<input type="text" name="product"/>
						</td>
					</tr>
					<tr>
						<td>Số lượng đặt hàng</td>
						<td>
							<input type="number" name="number"/>
						</td>
					</tr>
					
					<tr>
						<td align="right">Họ và tên</td>
						<td>
							<input type="text" name="name"/>
						</td>
					</tr>
					
					<tr>
						<td align="right">Email</td>
						<td>
							<input type="email" name="email"/>
						</td>
					</tr>
			</table>
			<input type="submit" value="Submit" id="submitButton" style="font-weight: bold; font-size: 15px; margin-top: 10px"/>
	</form>
	
	
</body>
</html>