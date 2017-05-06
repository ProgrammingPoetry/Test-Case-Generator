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
			$(document).ready(
	    function(){
	        $("#numericTree").css('background', '#26a655');  $("#numericTree p").css('color', 'white');
	        $("#numericTreeLink").click(function (e) {
	            e.preventDefault();
	            $("#numericTreeForm").slideDown();
				$("#characterTreeForm,#fullBinaryTreeForm,#skewTreeForm").hide();
	            $("#numericTree").css('background', '#26a655');  $("#numericTree p").css('color', 'white');
	            $("#characterTree,#fullBinaryTree,#skewTree").css('background', 'white');  $("#characterTree p,#fullBinaryTree p,#skewTree p").css('color', '#26a655');
	        });
			 $("#characterTreeLink").click(function (e) {
	            e.preventDefault();
				$("#numericTreeForm,#fullBinaryTreeForm,#skewTreeForm").hide();
			    $("#characterTreeForm").slideDown();
	            $("#characterTree").css('background', '#26a655');$("#characterTree p").css('color', 'white');
	            $("#numericTree,#fullBinaryTree,#skewTree").css('background', 'white');  $("#numericTree p,#fullBinaryTree p,#skewTree p").css('color', '#26a655');
	        });
			 $("#fullBinaryTreeLink").click(function (e) {
	             e.preventDefault();
				 $("#numericTreeForm,#characterTreeForm,#skewTreeForm").hide();
	             $("#fullBinaryTreeForm").slideDown();
	             $("#fullBinaryTree").css('background', '#26a655'); $("#fullBinaryTree p").css('color', 'white');
	             $("#numericTree,#characterTree,#skewTree").css('background', 'white');  $("#numericTree p,#characterTree p,#skewTree p").css('color', '#26a655');
	        });
	         $("#skewTreeLink").click(function (e) { 
	             e.preventDefault();
				 $("#numericTreeForm,#characterTreeForm,#fullBinaryTreeForm").hide();
	             $("#skewTreeForm").slideDown();
	             $("#skewTree").css('background', '#26a655'); $("#skewTree p").css('color', 'white');
	             $("#numericTree,#characterTree,#fullBinaryTree").css('background', 'white');  $("#numericTree p,#characterTree p,#fullBinaryTree p").css('color', '#26a655');
	        });
	    });