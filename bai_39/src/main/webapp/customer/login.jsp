<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width; initial-scale=1;" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../css/login.css">

<title>Login</title>
</head>
<body>
	<%
		String error = request.getAttribute("error")+"";
	
		KhachHang kh = (KhachHang)session.getAttribute("vl_khachhang");
		String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		
		if(kh != null){
	%>
			<jsp:forward page="index.jsp"></jsp:forward>
	<%
		}
	%>	
	<div class="login-form">

        <form action="<%=url%>/khachhang" method="post">
        	<input type="hidden" name="action" value="login">
            <h2 class="text-center">Log in</h2>
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Username" name="username" required="required">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="Password" name="password" required="required">
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">Log in</button>
            </div>
            
            <div class="form-group">
            	<p style="color: red"><%=error.equals("null")?"":error%></p>
            </div>
           	
        
            <div class="clearfix">
                <label class="float-left form-check-label"><input type="checkbox"> Remember me</label>
                <a href="#" class="float-right">Forgot Password?</a>
            </div>
        </form>
        <p class="text-center"><a href="register.jsp">Create an Account</a></p>
    </div>
    <%@ include file="../footer.jsp" %>
</body>
</html>