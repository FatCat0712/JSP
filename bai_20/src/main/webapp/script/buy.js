/**
 * 
 */
function checkInvalid(){
	let quantity = document.getElementById("quantity").value;
	let number = parseInt(quantity);
	if(number < 1){
		alert("Quantity must be positive");
		return false;
	}
	else{
		return true;
	}
	
	
	
	
	
}