<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table,td{
		border: 1px solid black;
		border-collapse: collapse;
	}
</style>
</head>
<body>
	<form action="donHang.jsp" method="get">
		<table style="margin-left: auto; margin-right: auto">
			<tr>
				<td colspan="2" style="background-color: lightblue; align-content: center; text-align: center;">
					<p style="font-size: 30px; font-weight: bold;">Computer Model</p>
				</td>
			</tr>
			<tr>
				<td>Processor: </td>
				<td align="right">
					<select name="processor">
						<option value="corei9">Intel Core i9</option>
						<option value="corei7">Intel Core i7</option>
						<option value="corei5">Intel Core i5</option>
						<option value="corei3">Intel Core i3</option>
						<option value="dualcore">Intel Dual Core</option>
						<option value="pentium">Intel Pentium</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Memory: </td>
				<td>
					
						<input type="radio" id="m1" name="memory" value="Ram 4GB">
						<label for="m1">4GB</label>
						
						<input type="radio" id="m2" name="memory" value="Ram 8GB">
						<label for="m2">8GB</label>
						
						<input type="radio" id="m3" name="memory" value="Ram 16GB">
						<label for="m3">16GB</label>
						
						<input type="radio" id="m4" name="memory" value="Ram 32GB">
						<label for="m4">32GB</label>
					
					
				</td>
			</tr>
			
			<tr>
				<td>Monitor: </td>
				<td>
					<input type="checkbox" name="monitor" id="monitor"/>
					<label for="monitor">Monitor</label>
				</td>
			</tr>
			
			<tr>
				<td>
					Accessories: 
				</td>
				<td>
					<select name="accessories" multiple="multiple">
						<option value="printer">Printer</option>
						<option value="scanner">Scanner</option>
						<option value="speaker">Speaker</option>
						<option value="camera">Camera</option>
					</select>
				</td>
				
			</tr>
			
			
			<tr>
			
				<td colspan="2" style="border: 0">
					<input type="submit" value="Submit" style="font-weight: bold; font-size: 15px;"/>
				</td>
					
				
			</tr>
		</table>
		
	</form>
</body>
</html>