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
    <script>
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
						<form  action="" method='post'>
							<div class="form-group" name="div1">
								<label for="number">Test cases</label>
								<input type="number" class="form-control"  name="noOfTestcases">
								<span id="TestcasesOfNumber"></span>
							</div>
							
							<!-- Form Fields are placed in a row-->
							<div class="form-group">
								<div class="row">
									<div class="col-xs-6">
										<label for="number">Min Value</label>
										<input type="number" class="form-control"  name="minVal" >
										<span id="minValOfNumber"></span>
									</div>
									<div class="col-xs-6">
										<label for="number">Max Value</label>
										<input type="number" class="form-control"  name="maxVal">
										<span  id="maxValOfNumber"></span>
									</div>
								</div>
						   </div>
							<!-- div ends here-->
							
							<div class="form-group">
								<label for="number">Multiple Of</label>
								<input type="number" class="form-control"  name="multipleOf">
								<span  id="multipleOfNumber"></span>
							</div>
							
							<div class="form-group">
								<label for="boolean">Prime:</label>
								<select>
									<option value="true">True</option>
									<option value="false">False</option>
								</select>
							</div>
							
							<div class="form-group">
								<label for="boolean">Distinct:</label>
								<select>
									<option value="true">True</option>
									<option value="false">False</option>
								</select>
							</div>
							
							<button type="button" class="btn btn-primary">Submit</button>
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
	                            
	                            <button type="submit" class="btn btn-primary">Submit</button>
	                        </form>
	                    </div>
					</div>
				</div>
			</div>
	</body>	
</html>