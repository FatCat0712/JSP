/**
 * 
 */
function validatePass(){
	newPassword = document.getElementById("newpassword").value;
	confirmPassword = document.getElementById("confirmpassword").value;
	
	if(newPassword != confirmPassword){
		document.getElementById("error").innerHTML = "Mật khẩu không khớp!";
		return false;
	}
	else{
		document.getElementById("error").innerHTML = "";
		return true;
	}
	
}