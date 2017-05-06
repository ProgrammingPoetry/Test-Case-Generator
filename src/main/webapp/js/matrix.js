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
        				$("#characterMatrixForm,#pathMatrixForm").hide();
        	            $("#numberMatrix").css('background', '#26a655');  $("#numberMatrix p").css('color', 'white');
        	            $("#characterMatrix,#pathMatrix").css('background', 'white');  $("#characterMatrix p,#pathMatrix p").css('color', '#26a655');
        	        });
        			 $("#characterMatrixLink").click(function (e) {
        	            e.preventDefault();
        				$("#numberMatrixForm,#pathMatrixForm").hide();
        			    $("#characterMatrixForm").slideDown();
        	            $("#characterMatrix").css('background', '#26a655');$("#characterMatrix p").css('color', 'white');
        	            $("#numberMatrix,#pathMatrix").css('background', 'white');  $("#numberMatrix p,#pathMatrix p").css('color', '#26a655');
        	        });
        			 $("#pathMatrixLink").click(function (e) {
        	             e.preventDefault();
        				 $("#numberMatrixForm,#characterMatrixForm").hide();
        	             $("#pathMatrixForm").slideDown();
        	             $("#pathMatrix").css('background', '#26a655'); $("#pathMatrix p").css('color', 'white');
        	             $("#numberMatrix,#characterMatrix").css('background', 'white');  $("#numberMatrix p,#characterMatrix p").css('color', '#26a655');
        	        });
        	    });