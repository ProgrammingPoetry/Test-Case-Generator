<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="/css/stylesheet.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="/js/misc.js"></script>
    <script>
    
    //Fibonacci Form Validation
    function validateFibonacciForm(testCases,minValue,maxValue){
    	var status="";
    	if(testCases.value=="" || testCases.value < 1 || testCases.value >  2500 ){
       		document.getElementById('errorinfo_fibonacci_testCases').innerHTML="testcases range : 1-2500";
       		status="failure";
    	}

        if(minValue.value=="" || minValue.value < 1 || minValue.value > 86 ){
       		document.getElementById('errorinfo_fibonacci_minValue').innerHTML="minvalue range : 1-86"; 
       		status="failure";
        }
         
        if(maxValue.value=="" || maxValue.value < 1 || maxValue.value > 86 ){
       		document.getElementById('errorinfo_fibonacci_maxValue').innerHTML="maxvalue range : 1-86";
       		status="failure";
        }
        
      //ajax call for character Form
   	 if(status!="failure"){
   	        $.ajax({ 
   	            type: "POST",
   	            url: "/miscellaneousService",
   	            data: { category: "fibonacci", testCases:testCases.value,minValue:minValue.value,
   	            	maxValue:maxValue.value} ,
   	            success: successFunc,
   	            error: errorFunc
   	        });
   	        function successFunc(data) {
   	        	if(data["status"]==="Success"){
   	        		download(data["testData"]);
   	        	}
   	        	document.getElementById('fibonacci_results').innerHTML=data["status"]+":"+data["description"];
   	           console.log(data);
   	        }

   	        function errorFunc() {
   	            alert('error');
   	        }
   	 }
   	 }
    </script>      
</head>
	<body>
		<!-- Header Section-->
		<header class="container-fluid text-center" >
				<h1>Miscellaneous</h1>
		</header>
		<!--  End of Header section -->
		
		<div class="container">
			<!--  buttons and their respective Forms are arranged in a row -->
			<div class="row">
				<div class="col-xs-2">
					<!-- Buttons for miscellaneous types  -->
					<a   id="fibonacciSeriesLink" href="" >
						<div id="fibonacciSeries">
							<p>Fibonacci Series</p>
						</div>
					</a>
				</div>
				
				<div class="col-xs-8" style="margin-left:100px">
					<div id="fibonacciSeriesForm"  class="center-block">
						<h2>Fibonacci Series</h2>
						<form action="" method='post'>
						
	                            <div class="form-group">
	                                <label for="number">Test cases</label>
	                                <input type="number" class="form-control"  name="testCases">
	                                <span id="errorinfo_fibonacci_testCases"></span>
	                            </div>
	                            
	                            <div class="form-group">
	                                <label for="number">min Value</label>
	                                <input type="number" class="form-control"  name="minValue">
	                                <span id="errorinfo_fibonacci_minValue"></span>
	                            </div>
	                            <div class="form-group">
	                                <label for="number">max Value</label>
	                                <input type="number" class="form-control"  name="maxValue">
	                                <span id="errorinfo_fibonacci_maxValue"></span>
	                            </div>
	                            <span id="fibonacci_results"></span><br>
	                            <button type="button" class="btn btn-primary" onclick="validateFibonacciForm(testCases,minValue,maxValue)">Submit</button>
	                        </form>
					</div>
				</div>
			</div>
		</div>
	</body>	
</html>