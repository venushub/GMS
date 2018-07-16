/*const gral = document.getElementById('gral');
console.log(gral);
gral.style.backgroundColor = "#9f0000";
gral.style.color = "white";
*/

function func1(grng) {
	grng.style.backgroundColor = "#9f0000";
	grng.style.color = "white";
}

function func2(grng) {
	grng.style.backgroundColor = "white";
	grng.style.color = "#620000";
}










/*document.getElementById("agbscontainer").style.height = 95 + "vh";*/




/*function bordersolid(grng) {	
	grng.style.borderStyle = "solid";
	grng.style.borderColor = "#620000"
}

function bordernormal(grng) {
	grng.style.borderStyle = "none";
	grng.style.borderColor = "white"

}*/
/*
function resize()
{
    var heights = window.innerHeight;
    document.getElementById("agbscontainer").style.height = heights + "px";
}
resize();
window.onresize = function() {
    resize();
};*/


$(document).ready(function(){
	$('#addagenttocatbutton').on('click', function(event) {     	
	    $('#addmapc2a').show();
	});   
	
	$('#hidecloseaddmapc2adiv').on('click', function(event) {     	
	    $('#addmapc2a').hide();
	});   
	
	
	
	
});


document.getElementById("backarrow").addEventListener("mouseover", changeme4);
document.getElementById("backarrow").addEventListener("mouseout", rechangeme4 );

function changeme4(){
    document.getElementById("backarrow").setAttribute("fill" , "#9f0000");
}

function rechangeme4(){
    document.getElementById("backarrow").setAttribute("fill" , "#620000");
}

 document.getElementById("submitbutton").addEventListener("mouseover", changeme);
 document.getElementById("submitbutton").addEventListener("mouseout", rechangeme);

 function changeme(){
	 document.getElementById("submitbutton").style.backgroundColor = "#9f0000";
 }
 
 function rechangeme(){
	 document.getElementById("submitbutton").style.backgroundColor = "#620000";
 }