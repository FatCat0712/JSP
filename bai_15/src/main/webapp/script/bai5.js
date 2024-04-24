/**
 * 
 */

 function displayContent(){
	var content = document.getElementsByTagName("a");
	var area = document.getElementById("area");
	var result = "";
	for(let i = 0; i < content.length; i++){
		//result += content[i].getAttribute('href')+"<br>";
		result += content[i].innerText+"<br>";
	}
	area.innerHTML = result;
 }