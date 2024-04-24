<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<% String status = request.getAttribute("status")+""; 
		String username = (String)session.getAttribute("username");%>
		
	<% if(username != null) { %>	
		<jsp:forward page="success.jsp"></jsp:forward>
	<%} %>

	<form action="login" method="get">
		<table style="margin-left: auto; margin-right: auto">
			<tr>
				<td colspan="2" style="text-align: center; background-color: pink;">
					<h2 >LOGIN</h2>
				</td>
			</tr>
			
			<tr>
				<td>Username: </td>
				<td>
					<input type="text" name="username" required/>
				</td>
			</tr>
			
			<tr>
				<td>Password: </td>
				<td>
					<input type="password" name="password" required/>
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<div style="color: red"><%=status.equals("null")?"":status %></div>
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="submit" value="Login" style="font-weight: bold; font-size: 15px; margin-top: 15px"/>
				</td>
			</tr>
		</table>
	</form>
	
</body>
</html>