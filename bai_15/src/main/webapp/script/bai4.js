/**
 * 
 */
var check="hidden";
function display(){
	var status=document.getElementById("area");
	if(check == "hidden"){
		area.style.display="block";
		check = "show";
	}
	else{
		area.style.display="none";
		check = "hidden";
	}
}
