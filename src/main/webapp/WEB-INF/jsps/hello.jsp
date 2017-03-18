<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Case Generator</title>
<script src="https://code.jquery.com/jquery-3.2.0.min.js"></script>
<script>

function download() {
	console.log("Inside download!");
    var textToWrite = document.getElementById("testdata").value;
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
function foo(min,max) {
	
	$.ajax({
        type: "POST",
        url: "/numbers",
        data: {min: min.value, max: max.value},
        success: function(data) {
            console.log("Success!");
            var result = document.getElementById("results");
            result.innerHTML = data.status + ": " + data.description;
            var testdata = document.getElementById("testdata");
            testdata.value = data.testdata;
        }
    });
	
	return false;
}

</script>
</head>
<body>
	<form onsubmit="return foo(min,max)">
		Min: <input type="text" name="min"/><br/>
		Max: <input type="text" name="max"/><br/>
		<input type="submit" value = "Submit" /><br/>
	</form><br/>
	<span id="results"></span><br/>
	<textarea id="testdata" rows="10"></textarea><br/>
	<input type="submit" value="Download" onclick="return download()" />
</body>
</html>