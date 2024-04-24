<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<form action="LoginHandler.jsp" method="post">
		<table>
			<tr>
				<td style="background-color: pink" colspan="2">
					<h2 style="text-align: center">Login</h2>
				</td>
			</tr>
			
			<tr>
				<td>Username</td>
				<td>
					<input type="text" name="username" /> 
				</td>
			</tr>
			
			<tr>
				<td>Password</td>
				<td>
					<input type="password" name="password" /> 
				</td>
			</tr>
			
		</table>
		<input type="submit" value="Submit" style="font-weight: bold; font-size: 13px; margin-top: 10px" >	
	</form>
</body>
</html>