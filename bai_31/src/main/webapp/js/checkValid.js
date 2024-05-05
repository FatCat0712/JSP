function checkPass() {
    matkhau = document.getElementById("matkhau").value;
    xacnhanmatkhau = document.getElementById("xacnhanmatkhau").value;

    if (matkhau != xacnhanmatkhau) {
        document.getElementById("passerror").innerHTML = "Mật khẩu không khớp !";
        return false;
    }
    else {
        document.getElementById("passerror").innerHTML = "";
        return true;
    }
}


function handlePermission() {
    dongydieukhoan = document.getElementById("dongydieukhoan");
    if (dongydieukhoan.checked == true && checkPass()==true) {
        document.getElementById("submit").style.visibility = "visible";
    }
    else {
        document.getElementById("submit").style.visibility = "hidden";
    }
}