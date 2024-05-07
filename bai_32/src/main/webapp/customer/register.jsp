<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
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
		String loi = request.getAttribute("val_loi")+"";
		String hoten = request.getAttribute("val_hoten")+"";
		String tendangnhap = request.getAttribute("val_tendangnhap")+"";
		String gioiTinh = request.getAttribute("val_gioitinh")+"";
		String ngaySinh = request.getAttribute("val_ngaysinh")+"";
		String diaChiKhachHang = request.getAttribute("val_diachikhachhang")+"";
		String diaChiMuaHang = request.getAttribute("val_diachimuahang")+"";
		String diaChiNhanHang = request.getAttribute("val_diachinhanhang")+"";
		String soDienThoai = request.getAttribute("val_sodienthoai")+"";
		String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
		
	
	%>
	
	<!-- start navbar -->
	<jsp:include page="../header.jsp"></jsp:include>
	<!-- end navbar -->

	<div class="container">
        <div class="text-center">
            <h1>Đăng ký tài khoản</h1>
        </div>
        <div>
            <form action="<%=url %>/khachhang" method="post">
            	<input type="hidden" name="action" value="register">
                <div class="row">
                    <div class="col-sm-6">
                        <h3>Thông tin khách hàng</h3>
                        <div class="mb-3">
                            <label for="hoten" class="form-label">Họ và tên <span class="require">*</span> </label>
                            <input type="text" class="form-control" name="hoten" value="<%=hoten.equals("null")?"":hoten %>" required>
                        </div>
                       
                        <div class="mb-3">
                            <label for="gioitinh" class="form-label">Giới tính</label>
                            <select class="form-control" name="gioitinh">
                                <option></option>
                                <option value="Male" <%=gioiTinh.equals("Male")?"selected='selected'":"" %>>Male</option>
                                <option value="Female" <%=gioiTinh.equals("Female")?"selected='selected'":"" %>>Female</option>
                                <option value="Other" <%=gioiTinh.equals("Other")?"selected='selected'":"" %>>Other</option>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label for="ngaysinh" class="form-label">Ngày sinh</label>
                            <input type="date" class="form-control" name="ngaysinh" value="<%=ngaySinh.equals("null")?"":ngaySinh%>"/>
                        </div>
                        <div class="mb-3">
                            <label for="sodienthoai" class="form-label">Số điện thoại <span
                                    class="require">*</span></label>
                            <input type="tel" class="form-control" name="sodienthoai" value="<%=soDienThoai.equals("null")?"":soDienThoai%>" required>
                        </div>
                        
                        
                     <h3>Tài khoản</h3>	
					 <div class="mb-3">
                            <label for="hoten" class="form-label">Tên hiển thị<span class="require">*</span></label>
                            <input type="text" class="form-control" name="tendangnhap" value="<%=tendangnhap.equals("null")?"":tendangnhap%>" required>
                            <span class="require"><%=loi.equals("null")?"":loi %></span>
                        </div>
                        <div class="mb-3">
                            <label for="matkhau" class="form-label">Mật khẩu <span class="require">*</span></label>
                            <input type="password" class="form-control" name="matkhau" id="matkhau" required>
                        </div>

                        <div class="mb-3">
                            <label for="matkhau" class="form-label">Nhập Lại Mật khẩu <span
                                    class="require">*</span></label>
                            <input type="password" class="form-control" id="xacnhanmatkhau" onkeyup="checkPass()"
                                required>
                            <span class="require" id="passerror"></span>
                        </div>	
                        
                    </div>
					
					
						
						
						
						
                    <div class="col-sm-6">
                        <h3>Địa chỉ</h3>
                        <div class="mb-3">
                            <label for="diachi" class="form-label">Địa chỉ khách hàng <span
                                    class="require">*</span></label>
                            <input type="text" class="form-control" name="diachi" value="<%=diaChiKhachHang.equals("null")?"":diaChiKhachHang%>" required>
                        </div>
                        <div class="mb-3">
                            <label for="diachimuahang" class="form-label">Địa chỉ mua hàng <span
                                    class="require">*</span></label>
                            <input type="text" class="form-control" name="diachimuahang" value="<%=diaChiMuaHang.equals("null")?"":diaChiMuaHang%>" required>
                        </div>
                        <div class="mb-3">
                            <label for="diachinhanhang" class="form-label">Địa chỉ nhận hàng <span
                                    class="require">*</span></label>
                            <input type="text" class="form-control" name="diachinhanhang" value="<%=diaChiNhanHang.equals("null")?"":diaChiNhanHang%>" required>
                        </div>

                        <div class="mb-3 form-check">
                            <input type="checkbox" class="form-check-input" id="dongydieukhoan" name="dongydieukhoan"
                                onchange="handlePermission()" required>
                            <label class="form-check-label" for="dongydieukhoan">Đồng ý với điều khoản sử dụng</label>
                        </div>

                        <div class="mb-3 form-check">
                            <input type="checkbox" class="form-check-input" id="dongynhanmail" name="dongynhanmail">
                            <label class="form-check-label" for="dongynhanmail">Đồng ý nhận mail</label>
                        </div>


                        <button type="submit" class="btn btn-primary form-control" id="submit"
                            style="visibility: hidden;">Đăng
                            ký</button>
                    </div>
                </div>


            </form>
        </div>
    </div>
	
	<!-- start navbar -->
	<jsp:include page="../footer.jsp"></jsp:include>
	<!-- end navbar -->

    <script src="../js/checkValid.js"></script>
</body>
</html>