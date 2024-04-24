/**
 * 
 */

 function submit(){
	var userName = document.getElementById("idUserName");
	var password = document.getElementById("idPassWord");
	
	var userName = userName.value;
	var password = password.value;
	
	if(userName.length == 0){
		window.alert("Bạn chưa điền tên đăng nhập !");
	}
	else if(password.length == 0){
		window.alert("Bạn chưa điền mật khẩu !");
	}
	else if(password.length < 8){
		window.alert("Mật khẩu phải có ít nhất 8 ký tự");
	}
	else{
		window.alert("Đăng nhập thành công !");
	}
	
 }