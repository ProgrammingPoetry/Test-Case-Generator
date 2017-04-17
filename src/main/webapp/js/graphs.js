 // script for setting display  when user changes the option in path problem 
            function setDisplay(selectObject,id){
             var value = selectObject.value;  
             if(value==="false"){
                    document.getElementById(id).style.display="none";
             }
             else{
                  document.getElementById(id).style.display="block";
             }
        }