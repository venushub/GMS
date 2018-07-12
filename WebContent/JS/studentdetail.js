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

	$('#commentclick').on('click', function(event) {     	
	   $('#sendcomment').hide();
	   $('#entermessage2').show();
	});

 
    
    
    $('#openclosegrdiv').on('click', function(event) {    
    	$('#sidedetails').hide();
        $('#closecomment').show();
        
   });
   
   $('#hideclosecommentdiv').on('click', function(event) {     	
       $('#closecomment').hide();
       $('#sidedetails').show();
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
 
 
 document.getElementById("submitclosebutton").addEventListener("mouseover", changeme5);
 document.getElementById("submitclosebutton").addEventListener("mouseout", rechangeme5);

 function changeme5(){
	 document.getElementById("submitclosebutton").style.backgroundColor = "#e2b616";
	 document.getElementById("submitclosebutton").style.color = "#620000";

 }
 
 function rechangeme(){
	 document.getElementById("submitclosebutton").style.backgroundColor = "#620000";
	 document.getElementById("submitclosebutton").style.color = "white";

 }
 
 
 document.getElementById("openclosegrdiv").addEventListener("mouseover", changeme6);
 document.getElementById("openclosegrdiv").addEventListener("mouseout", rechangeme6);

 function changeme6(){
	 document.getElementById("openclosegrdiv").style.backgroundColor = "#e2b616";
	 document.getElementById("openclosegrdiv").style.color = "#620000";

 }
 
 function rechangeme6(){
	 document.getElementById("openclosegrdiv").style.backgroundColor = "#620000";
	 document.getElementById("openclosegrdiv").style.color = "white";

 }
