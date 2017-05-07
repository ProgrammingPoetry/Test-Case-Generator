$(document).ready(
    function(){
        $("#fibonacciSeries").css('background', '#26a655');  $("#fibonacciSeries p").css('color', 'white');
        $("#fibonacciSeriesLink").click(function (e) {
            e.preventDefault();
            $("#fibonacciSeriesForm").slideDown();
			$("#fibonacciSeries").css('background', '#26a655');  $("#fibonacciSeries p").css('color', 'white');
            
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

		 