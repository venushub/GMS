/*function animdiv(){
	
	var i = document.getElementById('sendcomment').offsetHeight;
	
		
		document.getElementbyId("sendcomment").style.height = (document.getElementbyId("sendcomment").style.height) + 1
	
	document.getElementById("sendcomment").style.height = i + "px";
	
	while(i < 90) {
		
		document.getElementById("sendcomment").style.height = i + "px";
		i= i - 0.000000000001;
		document.getElementById("sendcomment").style.height = i + "%";
	}
	
	document.getElementById("sendcomment").style.height = 120 + "%";
	
}*/

$(document).ready(function(){
    $('#entermessage2').on('click', function(event) {     	
         $('#sendcomment').show();
         $('#entermessage2').hide();
    });
    
    $('#hidecommentdiv').on('click', function(event) {     	
        $('#sendcomment').hide();
        $('#entermessage2').show();
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
