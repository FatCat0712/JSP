<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change info</title>
<meta name="viewport" content="width=device-width; initial-scale=1;" />
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="../css/style.css">
 <style>
     .require {
         color: red;
     }
 </style>
</head>
<body>

<%
	KhachHang kh = (KhachHang)session.getAttribute("vl_khachhang");
	String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
	if(kh==null){
%>
<div class="container">
	<div class="text-center">
		<h4>Bạn chưa đăng nhập.<a href="index.jsp">Nhấp vào đây để quay trang chủ</a></h4>
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
            <h1>Thông tin tài khoản</h1>
        </div>
        <div>
            <form action="<%=url %>/khachhang" method="post">
            	<input type="hidden" name="action" value="changeinfo">
                <div class="row">
                    <div class="col-sm-6">
                        <h3>Thông tin khách hàng</h3>
                        <div class="mb-3">
                            <label for="hoten" class="form-label">Họ và tên <span class="require">*</span></label>
                            <input type="text" class="form-control" name="hoten" value="<%=kh.getHoTen()%>"required>
                        </div>

                        <div class="mb-3">
                            <label for="gioitinh" class="form-label">Giới tính</label>
                            <select class="form-control" name="gioitinh">
                                <option></option>
                                <option value="Male" <%=kh.getGioiTinh().equals("Male")?"selected='selected'":"" %>>Male</option>
                                <option value="Female" <%=kh.getGioiTinh().equals("Female")?"selected='selected'":"" %>>Female</option>
                                <option value="Other" <%=kh.getGioiTinh().equals("Other")?"selected='selected'":"" %>>Other</option>
                            </select>
                        </div>

                        <div class="mb-3">
                            <label for="ngaysinh" class="form-label">Ngày sinh</label>
                            <input type="date" class="form-control" name="ngaysinh" value="<%=kh.getNgaySinh()%>" />
                        </div>
                        <div class="mb-3">
                            <label for="sodienthoai" class="form-label">Số điện thoại <span
                                    class="require">*</span></label>
                            <input type="tel" class="form-control" name="sodienthoai" value="<%=kh.getSoDienThoai()%>"required>
                        </div>
                    </div>

                    <div class="col-sm-6">
                        <h3>Địa chỉ</h3>
                        <div class="mb-3">
                            <label for="diachi" class="form-label">Địa chỉ khách hàng <span
                                    class="require">*</span></label>
                            <input type="text" class="form-control" name="diachi"  value="<%=kh.getDiaChi()%>" required>
                        </div>
                        <div class="mb-3">
                            <label for="diachimuahang" class="form-label">Địa chỉ mua hàng <span
                                    class="require">*</span></label>
                            <input type="text" class="form-control" name="diachimuahang" value="<%=kh.getDiaChiMuaHang()%>" required>
                        </div>
                        <div class="mb-3">
                            <label for="diachinhanhang" class="form-label">Địa chỉ nhận hàng <span
                                    class="require">*</span></label>
                            <input type="text" class="form-control" name="diachinhanhang" value="<%=kh.getDiaChiNhanHang()%>"required>
                        </div>

                        <div class="mb-3 form-check">
                            <input type="checkbox" class="form-check-input" id="dongynhanmail" name="dongynhanmail" <%=kh.isNhanBanTin()?"checked":"" %>>
                            <label class="form-check-label" for="dongynhanmail">Đồng ý nhận mail</label>
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