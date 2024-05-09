<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thong bao</title>
</head>
<body>
	<% String thongBao =  request.getAttribute("msg")+"";%>	
	<h4><%=thongBao %></h4>
				
			
		
	<script>
		setTimeout(function(){
			window.location.href = 'index.jsp';
			},5000);
	</script>
</body>
</html>