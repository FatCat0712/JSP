/**
 * 
 */

 function checkValid(){
	
	let productId = document.getElementById("productid").value;
	let productName = document.getElementById("productname").value;
	let sellingPrice = document.getElementById("sellingprice").value;
	let purchasePrice = document.getElementById("purchaseprice").value;
	
	
	
	
	//check if product id is valid
	if(productId.length == 0){
		let error_productid = document.getElementById("error_productid");
		error_productid.innerHTML = "<span class='note'>Please enter the product id</span>"
	}
	
	// check if selling price is valid
	if(sellingPrice <= 0){
		let error_sellingprice = document.getElementById("error_sellingprice");
		error_sellingprice.innerHTML = "<span class='note'>Please enter a selling price</span>";
	}
	
	// check if purhcase price is valid
	if(purchasePrice <= 0){
		let error_purchaseprice = document.getElementById("error_purchaseprice");
		error_purchaseprice.innerHTML = "<span class='note'>Please enter a purchase price</span>";
	}
	
	// check if product name is valid
	if(productName.length == 0){
		let error_productname = document.getElementById("error_productname");
		error_productname.innerHTML = "<span class='note'>Please enter product name</span>"
	}
	
	
	else{
		//Submit form
		let saveform = document.getElementById("saveform");
		saveform.submit();
	}
	
 }