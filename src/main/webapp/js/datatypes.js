$(document).ready(
    function(){
        $("#number").css('background', '#26a655');  $("#number p").css('color', 'white');
        $("#numberLink").click(function (e) {
            e.preventDefault();
            $("#numberForm").slideDown();
			$("#characterForm,#stringForm").hide();
            $("#number").css('background', '#26a655');  $("#number p").css('color', 'white');
            $("#character,#string").css('background', 'white');  $("#character p,#string p").css('color', '#26a655');
        });
		 $("#characterLink").click(function (e) {
            e.preventDefault();
			$("#numberForm,#stringForm").hide();
		    $("#characterForm").slideDown();
            $("#character").css('background', '#26a655');$("#character p").css('color', 'white');
            $("#number,#string").css('background', 'white');  $("#number p,#string p").css('color', '#26a655');
        });
		 $("#stringLink").click(function (e) {
             e.preventDefault();
			 $("#numberForm,#characterForm").hide();
             $("#stringForm").slideDown();
             $("#string").css('background', '#26a655'); $("#string p").css('color', 'white');
             $("#number,#character").css('background', 'white');  $("#number p,#character p").css('color', '#26a655');
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
