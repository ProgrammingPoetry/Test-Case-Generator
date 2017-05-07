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
				$("#binarysearchTreeForm,#fullBinaryTreeForm,#skewTreeForm").hide();
	            $("#numericTree").css('background', '#26a655');  $("#numericTree p").css('color', 'white');
	            $("#binarysearchTree,#fullBinaryTree,#skewTree").css('background', 'white');  $("#binarysearchTree p,#fullBinaryTree p,#skewTree p").css('color', '#26a655');
	        });
			 $("#binarysearchTreeLink").click(function (e) {
	            e.preventDefault();
				$("#numericTreeForm,#fullBinaryTreeForm,#skewTreeForm").hide();
			    $("#binarysearchTreeForm").slideDown();
	            $("#binarysearchTree").css('background', '#26a655');$("#binarysearchTree p").css('color', 'white');
	            $("#numericTree,#fullBinaryTree,#skewTree").css('background', 'white');  $("#numericTree p,#fullBinaryTree p,#skewTree p").css('color', '#26a655');
	        });
			 $("#fullBinaryTreeLink").click(function (e) {
	             e.preventDefault();
				 $("#numericTreeForm,#binarysearchTreeForm,#skewTreeForm").hide();
	             $("#fullBinaryTreeForm").slideDown();
	             $("#fullBinaryTree").css('background', '#26a655'); $("#fullBinaryTree p").css('color', 'white');
	             $("#numericTree,#binarysearchTree,#skewTree").css('background', 'white');  $("#numericTree p,#binarysearchTree p,#skewTree p").css('color', '#26a655');
	        });
	         $("#skewTreeLink").click(function (e) { 
	             e.preventDefault();
				 $("#numericTreeForm,#binarysearchrTreeForm,#fullBinaryTreeForm").hide();
	             $("#skewTreeForm").slideDown();
	             $("#skewTree").css('background', '#26a655'); $("#skewTree p").css('color', 'white');
	             $("#numericTree,#binarysearchTree,#fullBinaryTree").css('background', 'white');  $("#numericTree p,#binarysearchTree p,#fullBinaryTree p").css('color', '#26a655');
	        });
	    });
			
			function download(textToWrite) {
				console.log("Inside download!");
				var textFileAsBlob = new Blob([textToWrite], {type:'text/plain'});
				var fileNameToSaveAs = "testcases.txt";
				var downloadLink = document.createElement("a");
			   	downloadLink.download = fileNameToSaveAs;
			    downloadLink.innerHTML = "Download File";
			    if (window.URL != null) {
			    	// Chrome allows the link to be clicked
			    	// without actually adding it to the DOM.
			        downloadLink.href = window.URL.createObjectURL(textFileAsBlob);
				}
			    else {
			    	// Firefox requires the link to be added to the DOM
			    	// before it can be clicked.
			        downloadLink.href = window.URL.createObjectURL(textFileAsBlob);
			        downloadLink.onclick = destroyClickedElement;
			        downloadLink.style.display = "none";
			        document.body.appendChild(downloadLink);
			    }
				downloadLink.click();
				return true;
			}

