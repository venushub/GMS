        document.getElementById("circ").addEventListener("mouseover", changeme);
        document.getElementById("circ").addEventListener("mouseout", rechangeme );          

        document.getElementById("tex").addEventListener("mouseover", changeme );
        document.getElementById("tex").addEventListener("mouseout", rechangeme );  

 
        
        function changeme(){
            document.getElementById("circ").setAttribute("fill" , "#9f0000");
            document.getElementById("tex").setAttribute("fill" , "white");
        }
    
        function rechangeme(){
            document.getElementById("circ").setAttribute("fill" , "white");
            document.getElementById("tex").setAttribute("fill" , "#620000");
        }
        
    /////////////////////////////////////////////////////////////////////////////////////////
        
        document.getElementById("circ1").addEventListener("mouseover", changeme1);
        document.getElementById("circ1").addEventListener("mouseout", rechangeme1 );          

        document.getElementById("tex1").addEventListener("mouseover", changeme1 );
        document.getElementById("tex1").addEventListener("mouseout", rechangeme1 );  

 
        
        function changeme1(){
            document.getElementById("circ1").setAttribute("fill" , "#9f0000");
            document.getElementById("tex1").setAttribute("fill" , "white");
        }
    
        function rechangeme1(){
            document.getElementById("circ1").setAttribute("fill" , "white");
            document.getElementById("tex1").setAttribute("fill" , "#620000");
        }
        
//////////////////////////////////////////////////////////////////////////////////////////
        
        document.getElementById("circ2").addEventListener("mouseover", changeme2);
        document.getElementById("circ2").addEventListener("mouseout", rechangeme2 );          

        document.getElementById("tex2").addEventListener("mouseover", changeme2);
        document.getElementById("tex2").addEventListener("mouseout", rechangeme2 );  

 
        
        function changeme2(){
            document.getElementById("circ2").setAttribute("fill" , "#9f0000");
            document.getElementById("tex2").setAttribute("fill" , "white");
        }
    
        function rechangeme2(){
            document.getElementById("circ2").setAttribute("fill" , "white");
            document.getElementById("tex2").setAttribute("fill" , "#620000");
        }
        
  /////////////////////////////////////////////////////////////////////////////////////////////
        
        document.getElementById("circ3").addEventListener("mouseover", changeme3);
        document.getElementById("circ3").addEventListener("mouseout", rechangeme3 );          

        document.getElementById("tex3").addEventListener("mouseover", changeme3 );
        document.getElementById("tex3").addEventListener("mouseout", rechangeme3 );  

 
        
        function changeme3(){
            document.getElementById("circ3").setAttribute("fill" , "#9f0000");
            document.getElementById("tex3").setAttribute("fill" , "white");
        }
    
        function rechangeme3(){
            document.getElementById("circ3").setAttribute("fill" , "white");
            document.getElementById("tex3").setAttribute("fill" , "#620000");
        }
        
////////////////////////////////////////////////////////////////////////////////////////////////////
        
        
        document.getElementById("backarrow").addEventListener("mouseover", changeme4);
        document.getElementById("backarrow").addEventListener("mouseout", rechangeme4 );
        
        function changeme4(){
            document.getElementById("backarrow").setAttribute("fill" , "#9f0000");
        }
    
        function rechangeme4(){
            document.getElementById("backarrow").setAttribute("fill" , "#620000");
        }