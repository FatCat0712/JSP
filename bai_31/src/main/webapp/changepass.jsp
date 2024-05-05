<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Pass</title>
<meta charset="utf-8" />
    <meta name="viewport" content="width=device-width; initial-scale=1;" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/changepass.css">
</head>
<body>

<%
	KhachHang kh = (KhachHang)session.getAttribute("vl_khachhang");
%>

<%
	if(kh == null){
%>
<div class="container">
	<div class="text-center">
		<h3>Bạn chưa đăng nhập.<a href="index.jsp">Nhấp vào đây để quay trang chủ</a></h3>
		<img alt="deny" src="img/403.png">
	</div>
</div>

<%} else{
	
	String loikhongdung = request.getAttribute("loikhongdung")+"";
	String loitrung = request.getAttribute("loitrung")+"";
%>

<div class="login-form">
        <form action="resetpass" method="post">
            <h2 class="text-center">Reset Password</h2>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="Current Password" required="required" name="currentpassword">
                <span class="note"><%=loikhongdung.equals("null")?"":loikhongdung %></span>

            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="New Password" required="required" id="newpassword" name="newpassword">
                <span class="note"><%=loitrung.equals("null")?"":loitrung %></span>
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="Confirm Password" required="required" id="confirmpassword" onkeyup="validatePass()">
                <span class="note" id="error"></span>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block">Submit</button>
            </div>
        </form>

</div>
<%} %>
</body>
<script src="js/changePass.js"></script>
</html>