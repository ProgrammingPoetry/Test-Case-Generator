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
    
    //validation for Number Form
    function validateNumberForm(testCases,minValue,maxValue,multipleOf,distinct,prime){
    	var status="";
    	if(testCases.value=="" || testCases.value < 1 || testCases.value > 100000 ){
       		document.getElementById('errorinfo_number_testCases').innerHTML="testcases range : 1-100000";
       		status="failure";
    	}

        if(minValue.value=="" || minValue.value < -1000000000 || minValue.value > 1000000000 ){
       		document.getElementById('errorinfo_number_minValue').innerHTML="minvalue range : -10^9 - 10^9"; 
       		status="failure";
        }
         
        if(maxValue.value=="" || maxValue.value < -1000000000  || maxValue.value > 1000000000 ){
       		document.getElementById('errorinfo_number_maxValue').innerHTML="minvalue range : -10^9 - 10^9";
       		status="failure";
        }

       		
        if(multipleOf.value!="" &&(multipleOf.value < 1 || multipleOf.value > 1000)){
            document.getElementById('errorinfo_number_multipleOf').innerHTML="multipleof range : 1-1000";
            status="failure";
        }
		console.log(minValue.value - maxValue.value);
        if((minValue.value - maxValue.value)>0){
       		document.getElementById('errorinfo_number_minValue').innerHTML="min should be less than max "; 
       		document.getElementById('errorinfo_number_maxValue').innerHTML="min should be less than max "; 
       		status="failure";
           }
        
        
        // ajax call for Number Form
        if(status!="failure"){
        $.ajax({ 
            type: "POST",
            url: "/datatypeService",
            data: { category: "numbers", testCases:testCases.value,minValue:minValue.value,
            	maxValue:maxValue.value,multipleOf:multipleOf.value,distinct:distinct.value,
            	prime:prime.value} ,
            success: successFunc,
            error: errorFunc
        });
        function successFunc(data) {
        	if(data["status"]==="Success"){
        		download(data["testData"]);
        	}
        	document.getElementById('number_results').innerHTML=data["status"]+":"+data["description"];
           console.log(data);
        }

        function errorFunc() {
            alert('error');
        }
        }
    }
    
    // character Form validation
    function validateCharacterForm(testCases,minValue,maxValue,caseValue,distinct){
    	
    	var status="";
    	if(testCases.value=="" || testCases.value < 1 || testCases.value > 100000 ){
       		document.getElementById('errorinfo_character_testCases').innerHTML="testcases range : 1-100000";
       		status="failure";
    	}
    	
    	if(minValue.value.length!=1){
    		console.log(minValue.value.length);
    		document.getElementById('errorinfo_character_minValue').innerHTML="only one character is allowed";
       		status="failure";
    	}
    	if(caseValue.value==="lower" && (minValue.value <'a' || minValue.value > 'z')){
    		document.getElementById('errorinfo_character_minValue').innerHTML="minvalue range : a-z";
       		status="failure";
    	}
    	if(caseValue.value==="upper" && (minValue.value <'A' || minValue.value > 'Z')){
    		document.getElementById('errorinfo_character_minValue').innerHTML="minvalue range : A-Z";
       		status="failure";
    	}
    	
    	if(maxValue.value.length!=1){
    		console.log(maxValue.value.length);
    		document.getElementById('errorinfo_character_maxValue').innerHTML="only one character is allowed";
       		status="failure";
    	}
    	
    	if(caseValue.value==="lower" && (maxValue.value <'a' || maxValue.value > 'z')){
    		document.getElementById('errorinfo_character_maxValue').innerHTML="maxvalue range : a-z";
       		status="failure";
    	}
    	if(caseValue.value==="upper" && (maxValue.value <'A' || maxValue.value > 'Z')){
    		document.getElementById('errorinfo_character_maxValue').innerHTML="maxvalue range : A-Z";
       		status="failure";
    	}
    	
    	
    	//ajax call for character Form
    	 if(status!="failure"){
    	        $.ajax({ 
    	            type: "POST",
    	            url: "/datatypeService",
    	            data: { category: "characters", testCases:testCases.value,minValue:minValue.value,
    	            	maxValue:maxValue.value,case:caseValue.value,
    	            	distinct:distinct.value} ,
    	            success: successFunc,
    	            error: errorFunc
    	        });
    	        function successFunc(data) {
    	        	if(data["status"]==="Success"){
    	        		download(data["testData"]);
    	        	}
    	        	document.getElementById('character_results').innerHTML=data["status"]+":"+data["description"];
    	           console.log(data);
    	        }

    	        function errorFunc() {
    	            alert('error');
    	        }
    }
    }
    
    //string Form Validation
    
   function validationStringForm(testCases,minValue,maxValue,caseValue,minStringLength,maxStringLength,printLength,isPalindrome,sorted){
    	
	var status="";
   	if(testCases.value=="" || testCases.value < 1 || testCases.value > 100000 ){
      		document.getElementById('errorinfo_string_testCases').innerHTML="testcases range : 1-100000";
      		status="failure";
   	}
   	
   	if(minValue.value.length!=1){
		console.log(minValue.value.length);
		document.getElementById('errorinfo_string_minValue').innerHTML="only one character is allowed";
   		status="failure";
	}
	if(caseValue.value==="lower" && (minValue.value <'a' || minValue.value > 'z')){
		document.getElementById('errorinfo_string_minValue').innerHTML="min value range : a-z";
   		status="failure";
	}
	if(caseValue.value==="upper" && (minValue.value <'A' || minValue.value > 'Z')){
		document.getElementById('errorinfo_string_minValue').innerHTML="min value range : A-Z";
   		status="failure";
	}
	
	if(maxValue.value.length!=1){
		console.log(maxValue.value.length);
		document.getElementById('errorinfo_string_maxValue').innerHTML="only one character is allowed";
   		status="failure";
	}
	
	if(caseValue.value==="lower" && (maxValue.value <'a' || maxValue.value > 'z')){
		document.getElementById('errorinfo_string_maxValue').innerHTML="max value range : a-z";
   		status="failure";
	}
	if(caseValue.value==="upper" && (maxValue.value <'A' || maxValue.value > 'Z')){
		document.getElementById('errorinfo_string_maxValue').innerHTML="max value range : A-Z";
   		status="failure";
	}
	
	if(minStringLength.value < 1 || minStringLength.value > 1000){
		document.getElementById('errorinfo_string_minStringLength').innerHTML="min string length range : 1-1000";
		status="failure";
    }
   if(maxStringLength.value < 1 || maxStringLength.value > 1000){
		document.getElementById('errorinfo_string_maxStringLength').innerHTML="max string length range : 1-1000";
		status="failure";
   }
   
   
   // ajax call for String Form
   if(status!="failure"){
	   
	   $.ajax({ 
           type: "POST",
           url: "/datatypeService",
           data: { category: "strings", testCases:testCases.value,minValue:minValue.value,
           	maxValue:maxValue.value,case:caseValue.value,minStringLength:minStringLength.value,
           	maxStringLength:maxStringLength.value,printLength:printLength.value,whiteSpaceCharacter:"",
           	isPalindrome:isPalindrome.value,sorted:sorted.value
           	} ,
           success: successFunc,
           error: errorFunc
       });
       function successFunc(data) {
       	if(data["status"]==="Success"){
       		download(data["testData"]);
       	}
       	document.getElementById('string_results').innerHTML=data["status"]+":"+data["description"];
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
								<span id="errorinfo_number_testCases"></span>
							</div>
							
							<!-- Form Fields are placed in a row-->
							<div class="form-group">
								<div class="row">
									<div class="col-xs-6">
										<label for="number">Min Value</label>
										<input type="number" class="form-control"  name="minValue" >
										<span id="errorinfo_number_minValue"></span>
									</div>
									<div class="col-xs-6">
										<label for="number">Max Value</label>
										<input type="number" class="form-control"  name="maxValue">
										<span  id="errorinfo_number_maxValue"></span>
									</div>
								</div>
						   </div>
							<!-- div ends here-->
							
							<div class="form-group">
								<label for="number">Multiple Of</label>
								<input type="number" class="form-control"  name="multipleOf">
								<span  id="errorinfo_number_multipleOf"></span>
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
							<span id="number_results"></span>	<br>				
							<button type="button" class="btn btn-primary" onclick="validateNumberForm(testCases,minValue,maxValue,multipleOf,distinct,prime)">Submit</button>
						</form>
					</div>
					<div id="characterForm" class="center-block" style="display:none;">
	                        <h2>Characters</h2>
	                        
	                        <form action="" method=''>
	                            <div class="form-group">
	                                <label for="number">Test cases</label>
	                                <input type="number" class="form-control"  name="testCases">
	                                <span  id="errorinfo_character_testCases"></span>
	                            </div>
	                            
	                             <!-- Form Fields are placed in a row-->
	                            <div class="form-group">
	                                <div class="row">
	                                    <div class="col-xs-6">   
	                                        <label for="text">Min Value</label>
	                                        <input type="text" class="form-control"  name="minValue" >
	                                        <span  id="errorinfo_character_minValue"></span>
	                                    </div>
	                                    <div class="col-xs-6">  
	                                        <label for="text">Max Value</label>
	                                        <input type="text" class="form-control"  name="maxValue">
	                                        <span  id="errorinfo_character_maxValue"></span>
	                                    </div>
	                                </div>
	                            </div>
	                            <!-- div ends here-->
	                            
	                            <div class="form-group">
	                                <label for="text">Case:</label>
	                                <select name="caseValue">
	                                    <option value="upper">upper</option>
	                                    <option value="lower">lower</option>
	                                    <option value="mixed">mixed</option>
	                                </select>
	                            </div>
	                            
	                             <div class="form-group">
	                                <label for="boolean">Distinct:</label>
	                                <select name="distinct">
	                                    <option value="true">True</option>
	                                    <option value="false">False</option>
	                                </select>
	                            </div>
	                            <span id="character_results"></span><br>
	                            
	                            <button type="button" class="btn btn-primary" onclick="validateCharacterForm(testCases,minValue,maxValue,caseValue,distinct)">Submit</button>
	                        </form>
	                    </div>
						<div id="stringForm" class="center-block" style="display:none;">
	                        <h2>Strings</h2>
	                        
	                        <form action="" method=''>
	                            <div class="form-group">
	                                <label for="number">Test cases</label>
	                                <input type="number" class="form-control"  name="testCases">
	                                 <span  id="errorinfo_string_testCases"></span>
	                            </div>
	                            
	                             <!-- Form Fields are placed in a row-->
	                            <div class="form-group">
	                                <div class="row">
	                                    <div class="col-xs-6">
	                                        <label for="number">Min length</label>
	                                        <input type="number" class="form-control"  name="minStringLength" >
	                                         <span  id="errorinfo_string_minStringLength"></span>
	                                    </div>
	                                    <div class="col-xs-6">
	                                        <label for="number">Max length</label>
	                                        <input type="number" class="form-control"  name="maxStringLength">
	                                          <span  id="errorinfo_string_maxStringLength"></span>
	                                    </div>
	                                </div>
	                            </div>
	                            
	                            <!-- Form Fields are placed in a row-->
	                            <div class="form-group">
	                                <div class="row">
	                                    <div class="col-xs-6">
	                                        <label for="text">MinChar Value</label>
	                                        <input type="text" class="form-control"  name="minValue">
	                                          <span  id="errorinfo_string_minValue"></span>
	                                    </div>
	                                    <div class="col-xs-6"> 
	                                        <label for="text">MaxChar Value</label>
	                                        <input type="text" class="form-control"  name="maxValue">
	                                          <span  id="errorinfo_string_maxValue"></span>
	                                    </div>
	                                </div>
	                            </div>
	                            <!-- div ends here-->
	                            
	                            <div class="form-group">
	                                <label for="text">Case:</label>
	                                <select name="caseValue">
	                                    <option value="upper">upper</option>
	                                    <option value="lower">lower</option>
	                                    <option value="mixed">mixed</option>
	                                </select>
	                            </div>
	                            
	                            <div class="form-group">
	                                <label for="boolean">Palindrome:</label>
	                                <select name="isPalindrome">
	                                    <option value="true">True</option>
	                                    <option value="false">False</option>
	                                </select>
	                            </div>
	                            
	                            <div class="form-group">
	                                <label for="boolean">Print length:</label>
	                                <select name="printLength">
	                                    <option value="true">True</option>
	                                    <option value="false">False</option>
	                                </select>
	                            </div>
	                            
	                             <div class="form-group">
	                                <label for="boolean">Sorted:</label>
	                                <select name="sorted">
	                                    <option value="true">True</option>
	                                    <option value="false">False</option>
	                                </select>
	                            </div>
	                            
	                            <span id="string_results"></span><br>
	                            <button type="button" class="btn btn-primary" onclick="validationStringForm(
	                            		testCases,minValue,maxValue,caseValue,minStringLength,maxStringLength,printLength,isPalindrome,sorted)">Submit</button>
	                        </form>
	                    </div>
					</div>
				</div>
			</div>
	</body>	
</html>