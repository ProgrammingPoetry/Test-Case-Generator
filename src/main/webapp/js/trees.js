// script for setting display  when user changes the option in path problem 
            function setDisplay(selectObject,id){
             var value = selectObject.value;  
             if(value==="random"|| value==="false"){
                    document.getElementById(id).style.display="none";
             }
             else if(value==="specify" || value==="true"){
                  document.getElementById(id).style.display="block";
             }
        }