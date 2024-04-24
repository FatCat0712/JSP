
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	%>
	
	<%
		if(!username.equals("sonhai"))
		{
	%>
		<h2>Sai tên đăng nhập</h2>
	<%
		}
		else if(!password.equals("123456"))
		{
	%>
		<h2>Sai mật khẩu</h2>
	<%
		}
		else
		{
	%>
		<h2><%=username %> đã login thành công</h2>
	<%
		}
	%>		
		
	
		
	 
		
</body>
</html>