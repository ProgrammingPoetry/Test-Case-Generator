<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Test Case Generator</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="/css/Home.css" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<style>
		.btn-xl {
			padding: 50px 20px;
			font-size: 60px;
			border-radius: 30px;
			width: 30%;
		}

		.btn-xl:hover {
			background-color: green;
		}
	</style>
	<script src="https://code.jquery.com/jquery-3.2.0.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script>
	
		function download(textToWrite) {
			console.log("Inside download!");
			var textFileAsBlob = new Blob([ textToWrite ], {
				type : 'text/plain'
			});
			var fileNameToSaveAs = "testcases.txt";

			var downloadLink = document.createElement("a");
			downloadLink.download = fileNameToSaveAs;
			downloadLink.innerHTML = "Download File";
			if (window.URL != null) {
				// Chrome allows the link to be clicked
				// without actually adding it to the DOM.
				downloadLink.href = window.URL.createObjectURL(textFileAsBlob);
			} else {
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
		function foo(min, max) {

			$.ajax({
				type : "POST",
				url : "/numbers",
				data : {
					min : min.value,
					max : max.value
				},
				success : function(data) {
							console.log("Success!");
							var result = document.getElementById("results");
							result.innerHTML = data.status + ": " + data.description;
							if (data.hasOwnProperty('testData'))
								download(data.testdata);
						  }
			});

			return false;
		}
		
	</script>
</head>

<body>
	<!-- Header Section-->
	<header class="container-fluid text-center">
	<h1>Test Case Generator</h1>
	</header>
	<!-- Buttons arranged in a row-->
	<div class="row" id="firstButtonGroup">
		<button type="button" class="btn btn-primary btn-xl"
			onclick="location.href='/datatypes'">Data Types</button>
		<button type="button" class="btn btn-primary btn-xl"
		onclick="location.href='/arrays'">Arrays</button>
		<button type="button" class="btn btn-primary btn-xl">Matrix</button>
	</div>
	<div class="row" id="secondButtonGroup">
		<button type="button" class="btn btn-primary btn-xl">Trees</button>
		<button type="button" class="btn btn-primary btn-xl">Graphs</button>
		<button type="button" class="btn btn-primary btn-xl">Misc</button>
	</div>
</body>

</html>




