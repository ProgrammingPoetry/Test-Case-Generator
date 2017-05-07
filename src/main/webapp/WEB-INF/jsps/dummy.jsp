<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<script>
			function foo() {
				$.ajax({
			        type: "POST",
			        url: "/datatypeService",
			        data: {
			        	category: "numbers",
			        	testCases: "5",
			        	minValue: 1,
			        	maxValue: 10,
			        	multipleOf: "",
			        	distinct: "false",
			        	prime: "false"
			        },
			        success: function(data) {
			            console.log(data);
			            if(data["status"] === "Success")
			            	document.getElementById("area").value = data["testData"];
			        }
			    });
				return false;
			}
		</script>
	</head>
	<body>
		<button type="submit" onclick="return foo()">AJAX</button><br/>
		<textarea id="area" rows="10">hello</textarea>
	</body>
</html>