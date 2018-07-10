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
