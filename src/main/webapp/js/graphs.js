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
        
            $(document).ready(
            	    function(){
            	        $("#numericGraph").css('background', '#26a655');  $("#numericGraph p").css('color', 'white');
            	        $("#numericGraphLink").click(function (e) {
            	            e.preventDefault();
            	            $("#numericGraphForm").slideDown();
            				$("#completeGraphForm,#nPartiteGraphForm").hide();
            	            $("#numericGraph").css('background', '#26a655');  $("#numericGraph p").css('color', 'white');
            	            $("#completeGraph,#nPartiteGraph").css('background', 'white');  $("#completeGraph p,#nPartiteGraph p").css('color', '#26a655');
            	        });
            			 $("#completeGraphLink").click(function (e) {
            	            e.preventDefault();
            				$("#numericGraphForm,#nPartiteGraphForm").hide();
            			    $("#completeGraphForm").slideDown();
            	            $("#completeGraph").css('background', '#26a655');$("#completeGraph p").css('color', 'white');
            	            $("#numericGraph,#nPartiteGraph").css('background', 'white');  $("#numericGraph p,#nPartiteGraph p").css('color', '#26a655');
            	        });
            			 $("#nPartiteGraphLink").click(function (e) {
            	             e.preventDefault();
            				 $("#numericGraphForm,#completeGraphForm").hide();
            	             $("#nPartiteGraphForm").slideDown();
            	             $("#nPartiteGraph").css('background', '#26a655'); $("#nPartiteGraph p").css('color', 'white');
            	             $("#numericGraph,#completeGraph").css('background', 'white');  $("#numericGraph p,#completeGraph p").css('color', '#26a655');
            	        });
            	    });