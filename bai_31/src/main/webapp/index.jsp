<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>My Bookstore</title>
	<meta name="viewport" content="width=device-width; initial-scale=1;" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<%
		KhachHang kh = (KhachHang)session.getAttribute("vl_khachhang");
		
	%>
	<nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a href="#" class="navbar-brand"><img src="img/logo.png" height="24"></a>
            </div>


            <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#"><span class="glyphicon glyphicon-home"></span> HomePage</a></li>
                    <li>
                        <div>
                            <input type="text" placeholder="Bạn cần tìm gì" class="input-field">
                            <span class="glyphicon glyphicon-search" style="color: white"></span>
                        </div>

                    </li>
                </ul>

                <ul class="nav navbar-nav navbar-right">
                	<%
                		if(kh != null){
                	%>
                	 <li><a href="#">Welcome <%=kh.getHoTen().substring(kh.getHoTen().lastIndexOf(" ")+1) %></a></li>
                	 <li class="dropdown">
	                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
	                        <span class="caret"></span>
	                    </a>
	                    <ul class="dropdown-menu">
	                        <li><a href="#">Giỏ hàng</a></li>
	                        <li><a href="#">Thông báo</a></li>
	                        <li><a href="changeinfo.jsp">Thay đổi thông tin</a></li>
	                        <li><a href="changepass.jsp">Đổi mật khẩu</a></li>
	                        
	                        <li>
	                        	<form action="logout" method="post" style="padding: 10px 0px 10px 20px;">
									<input type="submit" value="Đăng xuất" style="font-weight: bold; font-size:15px" name="logout" >
								</form>
	                        </li>
	                    </ul>
               	 	</li>		
                	<%
                	}
                	else
                	{
                	%>
                		<li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                	<%
                	}
                	%>	
                	
                    
                </ul>

            </div>
        </div>
    </nav>

    <div class="section-banner">
        <div class="row">
            <div class="col-xs-8 col-sm-6 col-md-3 col-lg-3">
                <nav class="main-nav">
                    <h3>Danh mục sách</h3>
                    <ul class="main-nav ul">
                        <li><a href="#"> Chính trị</a></li>
                        <li><a href="#"> Khoa học</a></li>
                        <li><a href="#"> Kinh tế</a></li>
                        <li><a href="#"> Pháp luật</a></li>
                        <li><a href="#"> Thể thao</a></li>
                    </ul>
                </nav>
            </div>


            <div class="col-xs-12 col-sm-12 col-md-9 col-lg-9">
                <div id="myCarousel" class="carousel slide" data-ride="carousel">
                    <!-- Phần chỉ số -->
                    <ol class="carousel-indicators">
                        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                        <li data-target="#myCarousel" data-slide-to="1"></li>
                        <li data-target="#myCarousel" data-slide-to="2"></li>
                    </ol>

                    <!--Phần bao các slides-->
                    <div class="carousel-inner" role="listbox">
                        <div class="item active">
                            <img src="img/book1.jpg" alt="hinh1">
                            <div class="carousel-caption">
                                <h4>"To thine own self, be true."<br><span><strong>William Shakespeare</strong></span>
                                </h4>
                            </div>
                        </div>

                        <div class="item">
                            <img src="img/book2.jpg" alt="hinh2" style="filter: blur(1px);">
                            <div class="carousel-caption">
                                <h4>"United we stand, divided we fall."<br><span><strong>Aesop</strong></span></h4>
                            </div>
                        </div>

                        <div class="item">
                            <img src="img/book3.jpg" alt="hinh3">
                            <div class="carousel-caption">
                                <h4>"What doesn't kill us makes us stronger."<br><span><strong>Friedrich
                                            Nietzsche</strong></span>
                                </h4>
                            </div>
                        </div>
                    </div>

                    <!-- Control điều khiển bên trái và bên phải-->
                    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>

                    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>


                </div>


                <div class="row list-product">

                    <div class="col-sm-3 col-md-3 col-lg-3 product-item">
                        <a href="#"><img src="img/sach1.jpg"></a>
                        <h5>Hồ sơ tâm lý 1</h5>
                        <p>100$</p>
                    </div>


                    <div class="col-sm-3 col-md-3 col-lg-3 product-item">
                        <a href="#"><img src="img/sach1.jpg"></a>
                        <h5>Hồ sơ tâm lý 2</h5>
                        <p>100$</p>
                    </div>

                    <div class="col-sm-3 col-md-3 col-lg-3 product-item">
                        <a href="#"><img src="img/sach1.jpg"></a>
                        <h5>Hồ sơ tâm lý 3</h5>
                        <p>100$</p>
                    </div>
                    <div class="col-sm-3 col-md-3 col-lg-3 product-item">
                        <a href="#"><img src="img/sach1.jpg"></a>
                        <h5>Hồ sơ tâm lý 4</h5>
                        <p>100$</p>
                    </div>
                </div>

            </div>


        </div>
    </div>

	
</body>
</html>