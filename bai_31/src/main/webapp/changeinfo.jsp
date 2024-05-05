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
		<h3>Bạn chưa đăng nhập.<a href="index.jsp">Nhấp vào đây để quay trang chủ</a></h3>
		<img alt="deny" src="img/403.png">
	</div>
</div>
<%}else{ 
%>

<div class="container">
        <div class="text-center">
            <h1>Thông tin tài khoản</h1>
        </div>
        <div>
            <form action="changeinfo" method="post">
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
                                <option value="Nam" <%=kh.getGioiTinh().equals("Nam")?"selected='selected'":"" %>>Nam</option>
                                <option value="Nữ" <%=kh.getGioiTinh().equals("Nữ")?"selected='selected'":"" %>>Nữ</option>
                                <option value="Khác" <%=kh.getGioiTinh().equals("Khác")?"selected='selected'":"" %>>Khác</option>
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
                            <input type="checkbox" class="form-check-input" id="dongynhanmail" name="dongynhanmail" checked="<%=kh.isNhanBanTin()==true?true:false%>">
                            <label class="form-check-label" for="dongynhanmail">Đồng ý nhận mail</label>
                        </div>


                        <button type="submit" class="btn btn-primary form-control">Lưu</button>
                    </div>
                </div>


            </form>
        </div>
    </div>
 <%} %>
</body>
</html>