<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="/css/stylesheet.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="/js/datatypes.js"></script>   
    <script src="/js/validationconstants_datatypes.js"></script>  
    <script>
    function validateNumberForm(testCases,minValue,maxValue,multipleOf,distinct,prime){
    /*	if(testCases.value < 1 || testCases.value >1000 )
       		document.getElementById('errorinfo_testCases').innerHTML="range is "+number_min_testCases+"-"+number_max_testCases;

        if(minValue.value < 1 || minValue.value > 1000 )
       		document.getElementById('errorinfo_minValue').innerHTML="range is "+number_min_minValue+"-"+number_max_minValue; 
         
        if(maxValue.value < 1  || maxValue.value > 1000 )
       		document.getElementById('errorinfo_maxValue').innerHTML="range is "+number_min_maxValue+"-"+number_max_maxValue;  

        if(multipleOf.value < 1 || multipleOf.value > 1000 )
            document.getElementById('errorinfo_multipleOf').innerHTML="range is "+number_min_multipleOf+"-"+number_max_multipleOf; 
    	
       
        if((minValue.value - maxValue.value)>0){
       		document.getElementById('errorinfo_minValue').innerHTML="min should be less than max "; 
       		document.getElementById('errorinfo_maxValue').innerHTML="min should be less than max "; 
           }
        */
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
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: successFunc,
            error: errorFunc
        });

        function successFunc(data, status) {
           console.log(data);
        }

        function errorFunc() {
            alert('error');
        }
    }
    function validateCharacterForm(testCases,minValue,maxValue,multipleOf,distinct,prime){
    	
    	if(minValue.value > maxValue.value){  
       		document.getElementById('errorinfo_minValue').innerHTML="min should be less than max "; 
       		document.getElementById('errorinfo_maxValue').innerHTML="min should be less than max "; 
       	}
    	
    	if(testCases.value==""||minValue.value=="" || maxValue.value==""|| multipleOf.value=="")
    		document.getElementById('errorinfo_empty').innerHTML="Fields should not be empty";

        	if(testCases.value < number_min_testCases || testcases.value > number_max_testCases)
           		document.getElementById('errorinfo_testCases').innerHTML="range is "+number_min_testCases+"-"+number_max_testCases;
         	if(minValue.value < number_min_minValue || minValue.value > number_max_minValue )
           		document.getElementById('errorinfo_minValue').innerHTML="range is "+number_min_minValue+"-"+number_max_minValue; 
            if(maxValue.value < number_min_maxValue  || maxValue.value > number_max_maxValue )
           		document.getElementById('errorinfo_maxValue').innerHTML="range is "+number_min_maxValue+"-"+number_max_maxValue;  
           	if(multipleOf.value < number_min_multipleOf || multipleOf.value > number_max_multipleOf )
           		document.getElementById('errorinfo_multipleOf').innerHTML="range is "+number_min_multipleOf+"-"+number_max_multipleOf;  
    }
    </script> 
</head>
	<body>
		<!-- Header Section-->
		<header class="container-fluid text-center" >
				<h1>Data Types</h1>
		</header>
		
		<!-- Container  -->
		<div class="container">
		
		<!--  buttons and their respective Forms are arranged in a row -->
			<div class="row">
			
				<!-- Buttons for different Data types  -->
				<div class="col-xs-2">
					<a   id="numberLink" href="" >
						<div id="number">
							<p>Number</p>
						</div>
					</a>
					<a id="characterLink" href="" >
						<div id="character">
							<p>Character</p>
						</div>
					</a>
					<a id="stringLink" href=""	>
						<div id="string">
							<p>String</p>
						</div>
					</a>
				</div>
				
				<div class="col-xs-8" style="margin-left:100px">
					<div id="numberForm"  class="center-block">
						<h2>Number</h2>
						<span align="centered" id="errorinfo_empty"></span>
						<form  action="" method='post'>
							<div class="form-group" name="div1">
								<label for="number">Test cases</label>
								<input type="number" class="form-control"  name="testCases">
								<span id="errorinfo_testCases"></span>
							</div>
							
							<!-- Form Fields are placed in a row-->
							<div class="form-group">
								<div class="row">
									<div class="col-xs-6">
										<label for="number">Min Value</label>
										<input type="number" class="form-control"  name="minValue" >
										<span id="errorinfo_minValue"></span>
									</div>
									<div class="col-xs-6">
										<label for="number">Max Value</label>
										<input type="number" class="form-control"  name="maxValue">
										<span  id="errorinfo_maxValue"></span>
									</div>
								</div>
						   </div>
							<!-- div ends here-->
							
							<div class="form-group">
								<label for="number">Multiple Of</label>
								<input type="number" class="form-control"  name="multipleOf">
								<span  id="errorinfo_multipleOf"></span>
							</div>
							
							<div class="form-group">
								<label for="boolean">Prime:</label>
								<select id="prime">
									<option value="true">True</option>
									<option value="false">False</option>
								</select>
							</div>
							
							<div class="form-group">
								<label for="boolean">Distinct:</label>
								<select id="distinct">
									<option value="true">True</option>
									<option value="false">False</option>
								</select>
							</div>							
							<button type="button" class="btn btn-primary" onclick="validateNumberForm(testCases,minValue,maxValue,multipleOf,distinct,prime)">Submit</button>
						</form>
					</div>
					<div id="characterForm" class="center-block" style="display:none;">
	                        <h2>Characters</h2>
	                        
	                        <form action="" method=''>
	                            <div class="form-group">
	                                <label for="number">Test cases</label>
	                                <input type="number" class="form-control"  name="noOfTestcases">
	                            </div>
	                            
	                             <!-- Form Fields are placed in a row-->
	                            <div class="form-group">
	                                <div class="row">
	                                    <div class="col-xs-6">   
	                                        <label for="number">Min Value</label>
	                                        <input type="number" class="form-control"  name="minVal" >
	                                    </div>
	                                    <div class="col-xs-6">  
	                                        <label for="number">Max Value</label>
	                                        <input type="number" class="form-control"  name="maxVal">
	                                    </div>
	                                </div>
	                            </div>
	                            <!-- div ends here-->
	                            
	                            <div class="form-group">
	                                <label for="text">Case:</label>
	                                <select>
	                                    <option value="upper">upper</option>
	                                    <option value="lower">lower</option>
	                                    <option value="mixed">mixed</option>
	                                </select>
	                            </div>
	                            
	                             <div class="form-group">
	                                <label for="boolean">Dsitinct:</label>
	                                <select>
	                                    <option value="true">True</option>
	                                    <option value="false">False</option>
	                                </select>
	                            </div>
	                            
	                            <button type="submit" class="btn btn-primary">Submit</button>
	                        </form>
	                    </div>
						<div id="stringForm" class="center-block" style="display:none;">
	                        <h2>Strings</h2>
	                        
	                        <form action="" method=''>
	                            <div class="form-group">
	                                <label for="number">Test cases</label>
	                                <input type="number" class="form-control"  name="noOfTestcases">
	                            </div>
	                            
	                             <!-- Form Fields are placed in a row-->
	                            <div class="form-group">
	                                <div class="row">
	                                    <div class="col-xs-6">
	                                        <label for="number">Min length</label>
	                                        <input type="number" class="form-control"  name="minLen" >
	                                    </div>
	                                    <div class="col-xs-6">
	                                        <label for="number">Max length</label>
	                                        <input type="number" class="form-control"  name="maxLen">
	                                    </div>
	                                </div>
	                            </div>
	                            
	                            <!-- Form Fields are placed in a row-->
	                            <div class="form-group">
	                                <div class="row">
	                                    <div class="col-xs-6">
	                                        <label for="text">MinChar Value</label>
	                                        <input type="text" class="form-control"  name="minCharValue">
	                                    </div>
	                                    <div class="col-xs-6"> 
	                                        <label for="text">MaxChar Value</label>
	                                        <input type="text" class="form-control"  name="maxCharValue">
	                                    </div>
	                                </div>
	                            </div>
	                            <!-- div ends here-->
	                            
	                            <div class="form-group">
	                                <label for="text">Case:</label>
	                                <select>
	                                    <option value="upper">upper</option>
	                                    <option value="lower">lower</option>
	                                    <option value="mixed">mixed</option>
	                                </select>
	                            </div>
	                            
	                            <div class="form-group">
	                                <label for="boolean">Palindrome:</label>
	                                <select>
	                                    <option value="true">True</option>
	                                    <option value="false">False</option>
	                                </select>
	                            </div>
	                            
	                            <div class="form-group">
	                                <label for="boolean">Print length:</label>
	                                <select>
	                                    <option value="true">True</option>
	                                    <option value="false">False</option>
	                                </select>
	                            </div>
	                            
	                             <div class="form-group">
	                                <label for="boolean">Sorted:</label>
	                                <select>
	                                    <option value="true">True</option>
	                                    <option value="false">False</option>
	                                </select>
	                            </div>
	                            
	                            <button type="submit" class="btn btn-primary">Submit</button>
	                        </form>
	                    </div>
					</div>
				</div>
			</div>
	</body>	
</html>