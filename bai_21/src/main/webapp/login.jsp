<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<form action="DangNhap" method="post">
		<table style="margin-left: auto; margin-right: auto">
		<tr>
			<td colspan="2" style="text-align: center; background-color: yellow;">
				<h2>LOGIN</h2>
			</td>
		</tr>
		<tr>
			<td>Username: </td>
			<td>
				<input type="text" name="username"/>
			</td>
		</tr>
		<tr>
			<td>Password: </td>
			<td>
				<input type="password" name="password"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="Submit" style="font-weight: bold; font-size: 15px; margin-top: 15px"/>
			</td>
		</tr>
	</table>
	</form>
	
</body>
</html>