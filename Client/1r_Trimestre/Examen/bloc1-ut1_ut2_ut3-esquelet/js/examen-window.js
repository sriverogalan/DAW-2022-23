var ample = window.screen.availWidth;
        var alt = window.screen.availHeight; 
        ample = ample/2 -300;
        alt = alt/2 -300;  
        function redirecciona(){
            window.location.href = "https://www.iesmanacor.cat";
        } 
        function openGame(){ 
            var myWindow = window.open("finestra.html", "", "width=500,height=500,left="+ample+",top="+alt); 
        } 