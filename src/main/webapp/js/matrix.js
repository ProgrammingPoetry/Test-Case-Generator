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
        
       // J query for sliding form  for respective button
        $(document).ready(
        	    function(){
        	        $("#numberMatrix").css('background', '#26a655');  $("#numberMatrix p").css('color', 'white');
        	        $("#numberMatrixLink").click(function (e) {
        	            e.preventDefault();
        	            $("#numberMatrixForm").slideDown();
        				$("#characterMatrixForm").hide();
        	            $("#numberMatrix").css('background', '#26a655');  $("#numberMatrix p").css('color', 'white');
        	            $("#characterMatrix").css('background', 'white');  $("#characterMatrix p").css('color', '#26a655');
        	        });
        			 $("#characterMatrixLink").click(function (e) {
        	            e.preventDefault();
        				$("#numberMatrixForm").hide();
        			    $("#characterMatrixForm").slideDown();
        	            $("#characterMatrix").css('background', '#26a655');$("#characterMatrix p").css('color', 'white');
        	            $("#numberMatrix").css('background', 'white');  $("#numberMatrix p").css('color', '#26a655');
        	        });
        	    });