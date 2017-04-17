// script for setting display  when user changes the option in path start and path end fields
        function setDisplay(selectObject,id){
             var value = selectObject.value;  
             if(value==="random"){
                    document.getElementById(id).style.display="none";
             }
             else{
                  document.getElementById(id).style.display="block";
             }
        }