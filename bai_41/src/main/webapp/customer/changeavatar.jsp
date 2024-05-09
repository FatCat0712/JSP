<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đổi ảnh đại diện</title>
<meta name="viewport" content="width=device-width; initial-scale=1;" />
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 <%String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath(); %>
 <link rel="stylesheet" href="<%=url %>/css/style.css">
  <style>
     .require {
         color: red;
     }
 </style>
</head>
<body>
<%
	KhachHang kh = (KhachHang)session.getAttribute("vl_khachhang");
	
	if(kh==null){
%>
<div class="container">
	<div class="text-center">
		<h4>Bạn chưa đăng nhập.<a href="<%=url %>/index.jsp">Nhấp vào đây để quay trang chủ</a></h4>
		<img alt="deny" src="../img/403.png">
	</div>
</div>
<%}else{ 
%>

<!-- navbar -->
<!-- include action(web động ) -->
<jsp:include page="../header.jsp" />
<!-- end navbar -->

<div class="container" style="margin-top: 50px">
		<div class="text-center">
            <h1>Thay đổi ảnh đại diện</h1>
            <h3><%=url %></h3>
        </div>
        <div>
        	<!-- Khai báo kiểu mã hóa để có thể upload file -->
            <form class="form" action="<%=url %>/changeimage" method="post" enctype="multipart/form-data">
            	<input type="hidden" name="action" value="changeavatar" >
                <div class="row"> 
                	<div class="col-sm-6">
                		
                        <img src="<%=url %>/avatar/<%=kh.getHinhAnh() %>" width="400" height="500" alt="avatar">
                    </div>
                    <div class="col-sm-6">
                        <div class="mb-3">
                            <label for="hinhanh" class="form-label">Ảnh đại diện <span class="require">*</span></label>
                            <input type="file" class="form-control" name="hinhanh" required>
                        </div>

                       

                        <button type="submit" class="btn btn-primary form-control">Lưu</button>
                    </div>
                </div>


            </form>
        </div>
        
   </div>
 <%} %>
 <br>
 <br>
 <jsp:include page="../footer.jsp" />
</body>
</html>