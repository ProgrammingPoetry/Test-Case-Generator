<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test Case Generator</title>
<script src="https://code.jquery.com/jquery-3.2.0.min.js"></script>
<script>

function foo(username) {
	
	$.ajax({
        type: "POST",
        url: "/numbers",
        data: {name: username.value},
        success: function(data) {
            console.log("Success");
        }
    });
	
	return false;
}

</script>
</head>
<body>
	<h1>Hello World!</h1>
	<form onsubmit="return foo(username)">
		Name: <input type="text" name="username"/><br/>
		<input type="submit" value = "Submit" />
	</form>
</body>
</html>