<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
<style>
	.note{
		color: red;
	}
	label {
		font-size: 20px;
	}
	td{
		padding-top: 10px;
		text-align: right;
		padding-left: 5px;
	}

</style>
</head>
<body>
<%
	String e_productId = request.getAttribute("e_productId")+"";
	String e_sellingPrice = request.getAttribute("e_sellingPrice")+"";
	
	String value_productId = request.getAttribute("value_productId")+"";
	String value_productName = request.getAttribute("value_productName")+"";
	String value_sellingPrice = request.getAttribute("value_sellingPrice")+"";
	String value_purchasePrice = request.getAttribute("value_purchasePrice")+"";
	String value_expireDate = request.getAttribute("value_expireDate")+"";
	String value_vat = request.getAttribute("value_vat")+"";
	String value_description = request.getAttribute("value_description")+"";
	
 %>


<form action="saveproduct" method="get" id="saveform">
	<table style="margin-left: auto; margin-right: auto">
			<tr style="background-color: lightblue">
				<th style="text-align: center; align-content: center;" colspan="2"><h1>Product</h1></th>
			</tr>
			<tr>
				<td>
				 	<label for="productid">Product ID<span class="note">*</span> :</label>
				 	<input type="text" name="productid" id="productid" value="<%=value_productId.equals("null")?"":value_productId%>" required/>
				 	<div id="error_productid"></div>
				 	<div class="note"><%= e_productId.equals("null")?"":e_productId %></div> 
				</td>
				
				<td>
					<label for="productname">Product Name<span class="note">*</span> :</label>
					<input type="text" name="productname" id="productname" value="<%=value_productName.equals("null")?"":value_productName %>" required/>
					<div id="error_productname"></div>
				</td>
				
			</tr>
			
			<tr>
				<td>
					<label for="purchaseprice">Purchase Price<span class="note">*</span>: </label>
					<input type="number" step="0.01" id="purchaseprice" name="purchaseprice" value="<%=value_purchasePrice.equals("null")?"":value_purchasePrice %>" required/>
					<div id="error_purchaseprice"></div>
				</td>
				
				<td>
					<label for="sellingprice">Selling Price<span class="note">*</span>: </label>
					<input type="number" step="0.01" id="sellingprice" name="sellingprice" value="<%=value_sellingPrice.equals("null")?"":value_sellingPrice %>" required/>
					<div id="error_sellingprice" class="note"><%=e_sellingPrice.equals("null")?"":e_sellingPrice %></div>
				</td>
			</tr>
			
			<tr>
				<td style="padding-left: 50px">
					<label>Expire date: </label>
					<input type="date" id="expiredate" name="expiredate" value="<%=value_expireDate.equals("null")?"":value_expireDate %>"/>
				</td>
				
				<td>
					<label>VAT: </label>
					<input type="number" id="vat" name="vat" value="<%=value_vat.equals("null")?"":value_vat %>"/>
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<div style="text-align: left">
						<label>Description</label>
					</div>
					<textarea rows="10" cols="100" name="description"><%=value_description.equals("null")?"": value_description %></textarea>
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="button" value="Save" style="font-weight: bold; font-size: 18px; width: 100%" onclick="checkValid()"/>
				</td>
				
			</tr>
			
			
	</table>
</form>
<script src="script/checkValidation.js"></script>	
</body>
</html>