<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Confirmation</title>
<style>
	td{
		font-size: 15px;
		text-align: center;
		border: 1px solid black;
		border-collapse: collapse;
	}
</style>
</head>
<body>
	<%
		double totalPrice = 0;
		
		String processor = request.getParameter("processor");
		double processorPrice = 0;
		String processName = "";
		if(processor != null){
			if(processor.equals("corei9")){
				processName += "Intel Core i9";
				processorPrice += 10000000;
			}
			else if(processor.equals("corei7")){
				processName += "Intel Core i7";
				processorPrice += 8000000;
			}
			else if(processor.equals("corei5")){
				processName += "Intel Core i5";
				processorPrice += 6000000;
			}
			else if(processor.equals("corei3")){
				processName += "Intel Core i3";
				processorPrice += 5000000;
			}
			else if(processor.equals("dualcore")){
				processName += "Dual Core";
				processorPrice += 3000000;
			}
			else if(processor.equals("pentium")){
				processName += "Pentium";
				processorPrice += 500000;
			}
		}
		totalPrice += processorPrice;
		
		
		String memoryName = request.getParameter("memory");
		double memoryPrice = 0;
		
		if(memoryName != null){
			if(memoryName.equals("Ram 4GB")){
				memoryPrice += 300000;
			}
			else if(memoryName.equals("Ram 8GB")){
				memoryPrice += 500000;
			}
			else if(memoryName.equals("Ram 16GB")){
				memoryPrice += 800000;
			}
			else if(memoryName.equals("Ram 32GB")){
				memoryPrice += 1000000;
			}
		}
		totalPrice += memoryPrice;
		
		
		String monitor = request.getParameter("monitor");
		double monitorPrice = 0;
		if(monitor != null){
			monitorPrice += 3000000;
		}
		
		String[] accessories = request.getParameterValues("accessories");
		if(accessories != null){
			for(String a: accessories){
				if(a.equals("printer")){
					totalPrice += 2000000;
				}
				else if(a.equals("scanner")){
					totalPrice += 2500000;
				}
				else if(a.equals("speaker")){
					totalPrice += 1500000;
				}
				else if(a.equals("camera")){
					totalPrice += 900000;
				}
			}
		}
	%>
	
	
	<table style="width: 100%" >
		<thead>
			<tr>
				<th style="width: 50%; font-size: 20px; text-align: center;">Product Name</th>
				<th style="width: 50%; font-size: 20px; text-align: center;">Price</th>
			</tr>
		</thead>
		<tr>
			<%if(processName != null) 
			{
			%>
				<td><%= processName %></td>
				<td><%= Math.round(processorPrice) %></td>
			<%} %>
		</tr>
		<tr>
			<%if(memoryName != null) 
			{
			%>
				<td><%= memoryName %></td>
				<td><%= memoryPrice %></td>
			<%} %>
		</tr>
		
		<tr>
			<%if(monitor != null) 
			{
			%>
				<td>Monitor</td>
				<td><%= monitorPrice %></td>
			<%} %>	
		</tr>
		
		
			<%if(accessories != null){
				String choice = "";
				double price = 0;
				for(String a : accessories){
					if(a.equals("printer")){
						choice = "Printer";
						price = 2000000;
					}
					else if(a.equals("scanner")){
						choice = "Scanner";
						price = 2500000;
					}
					else if(a.equals("speaker")){
						choice = "Speaker";
						price = 1500000;
					}
					else if(a.equals("camera")){
						choice = "Camera";
						price = 900000;
					}%>
					<tr>
						<td><%=choice %></td>
						<td><%=price %></td>
					</tr>
				<%}%>
				
			<%} %>
		
		
		<tr>
			<td><h3>Total Price</h3></td>
			<td><h3><%= Math.round(totalPrice) %></h3></td>
		</tr>
	</table>
</body>
</html>