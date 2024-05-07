<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath(); %>    
<nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a href="#" class="navbar-brand"><img src="../img/logo.png" height="24"></a>
            </div>


            <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="<%=url %>/index.jsp"><span class="glyphicon glyphicon-home"></span> HomePage</a></li>
                    <li>
                        <div>
                            <input type="text" placeholder="Bạn cần tìm gì" class="input-field">
                            <span class="glyphicon glyphicon-search" style="color: white"></span>
                        </div>

                    </li>
                </ul>

                <ul class="nav navbar-nav navbar-right">
                	 <li class="dropdown">
	                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
	                        <span class="caret"></span>
	                    </a>
	                    <ul class="dropdown-menu">
	                        <li><a href="#">Giỏ hàng</a></li>
	                        <li><a href="#">Thông báo</a></li>
	                        <li><a href="changeinfo.jsp">Thay đổi thông tin</a></li>
	                        <li><a href="changepass.jsp">Đổi mật khẩu</a></li>
	                        <li><hr class="dropdown-divider"></li>
		                    <li><a href="<%=url %>/khachhang?action=logout">Đăng xuất</a></li>
	                      
	                    </ul>
               	 	</li>		
 
                </ul>

            </div>
        </div>
</nav>