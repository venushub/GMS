function animdiv(){
	
	/*var i = document.getElementById('sendcomment').offsetHeight;*/
	
		
/*		document.getElementbyId("sendcomment").style.height = (document.getElementbyId("sendcomment").style.height) + 1
*/	
/*	document.getElementById("sendcomment").style.height = i + "px";
	
	while(i < 90) {
		
		document.getElementById("sendcomment").style.height = i + "px";
		i= i - 0.000000000001;
		document.getElementById("sendcomment").style.height = i + "%";
	}*/
	
	document.getElementById("sendcomment").style.height = 120 + "%";
	
}

jQuery(document).ready(function(){
    jQuery('#hideshow').on('click', function(event) {        
         jQuery('#sendcomment').toggle('show');
    });
});
