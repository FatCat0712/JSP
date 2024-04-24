/**
 * 
 */

 function changeDistrict(){
	var city = document.getElementById("cities").value;	
	var group = document.getElementsByTagName("optgroup");
	
	if(city=="TPHCM"){
		for(let i = 0; i < group.length; i++){
			if(group[i].getAttribute('label') == 'HCMdist'){
				group[i].hidden = false;
				
			}
			else{
				group[i].hidden = true;
			}
		}
	}
	else if(city=="HN"){
		for(let i = 0; i < group.length; i++){
			if(group[i].getAttribute('label') == 'HNdist'){
				group[i].hidden = false;
			}
			else{
				group[i].hidden = true;
			}
		}
	}
	else if(city=="DN"){
		for(let i = 0; i < group.length; i++){
			if(group[i].getAttribute('label') == 'DNdist'){
				group[i].hidden = false;
				
			}
			else{
				group[i].hidden = true;
			}
		}
	}
 }