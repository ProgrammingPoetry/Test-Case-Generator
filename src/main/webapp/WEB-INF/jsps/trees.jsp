<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	    <meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="/css/stylesheet.css">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	    <script>
	         function setDisplay(selectObject,id){
	             var value = selectObject.value;  
	             if(value==="random"|| value==="false"){
	                    document.getElementById(id).style.display="none";
	             }
	             else if(value==="specify" || value==="true"){
	                  document.getElementById(id).style.display="block";
	             }
	        }
			$(document).ready(
	    function(){
	        $("#numericTree").css('background', '#26a655');  $("#numericTree p").css('color', 'white');
	        $("#numericTreeLink").click(function (e) {
	            e.preventDefault();
	            $("#numericTreeForm").slideDown();
				$("#characterTreeForm,#fullBinaryTreeForm,#skewTreeForm").hide();
	            $("#numericTree").css('background', '#26a655');  $("#numericTree p").css('color', 'white');
	            $("#characterTree,#fullBinaryTree,#skewTree").css('background', 'white');  $("#characterTree p,#fullBinaryTree p,#skewTree p").css('color', '#26a655');
	        });
			 $("#characterTreeLink").click(function (e) {
	            e.preventDefault();
				$("#numericTreeForm,#fullBinaryTreeForm,#skewTreeForm").hide();
			    $("#characterTreeForm").slideDown();
	            $("#characterTree").css('background', '#26a655');$("#characterTree p").css('color', 'white');
	            $("#numericTree,#fullBinaryTree,#skewTree").css('background', 'white');  $("#numericTree p,#fullBinaryTree p,#skewTree p").css('color', '#26a655');
	        });
			 $("#fullBinaryTreeLink").click(function (e) {
	             e.preventDefault();
				 $("#numericTreeForm,#characterTreeForm,#skewTreeForm").hide();
	             $("#fullBinaryTreeForm").slideDown();
	             $("#fullBinaryTree").css('background', '#26a655'); $("#fullBinaryTree p").css('color', 'white');
	             $("#numericTree,#characterTree,#skewTree").css('background', 'white');  $("#numericTree p,#characterTree p,#skewTree p").css('color', '#26a655');
	        });
	         $("#skewTreeLink").click(function (e) { 
	             e.preventDefault();
				 $("#numericTreeForm,#characterTreeForm,#fullBinaryTreeForm").hide();
	             $("#skewTreeForm").slideDown();
	             $("#skewTree").css('background', '#26a655'); $("#skewTree p").css('color', 'white');
	             $("#numericTree,#characterTree,#fullBinaryTree").css('background', 'white');  $("#numericTree p,#characterTree p,#fullBinaryTree p").css('color', '#26a655');
	        });
	    });
	    </script>      
	</head>
	<body>
		<!-- Header Section-->
		<header class="container-fluid text-center" >
				<h1>Trees</h1>
		</header>
		<!--  End of Header section -->
		
		<div class="container">
			<!--  buttons and their respective Forms are arranged in a row -->
			<div class="row">
				<div class="col-xs-2">
				<!-- Buttons for different types of Trees  -->
				
					<a   id="numericTreeLink" href="" >
						<div id="numericTree">
							<p>Numeric Tree</p>
						</div>
					</a>
					
					<a id="characterTreeLink" href="" >
						<div id="characterTree">
							<p>Character Tree</p>
						</div>
					</a>
					
					<a id="fullBinaryTreeLink" href=""	>
						<div id="fullBinaryTree">
							<p>Full Binary Tree</p>
						</div>
					</a>
					
                    <a id="skewTreeLink" href=""	>
						<div id="skewTree">
							<p>Skew Tree</p>
						</div>
					</a>
					<br><br>
				</div>
				<!--  Buttons ended  -->
				
				<!--  Forms for Different types of Trees -->
				<div class="col-xs-8" style="margin-left:100px">
					<!--  Numeric Tree Form -->
					<div id="numericTreeForm"  class="center-block">
						<h2>  Numeric Tree </h2>
	                        <form action="" method='post'>
	                        
	                            <div class="form-group">
	                                <div class="row">
	                                    <div class="col-xs-6">
	                                        <label for="number">Test cases</label>
	                                        <input type="number" class="form-control"  name="noOfTestcases">
	                                    </div>
	                                    <div class="col-xs-6">
	                                        <label for="number">No Of Nodes</label>
	                                        <input type="number" class="form-control"  name="noOfNodes">
	                                    </div>
	                                </div>
	                            </div>
	                            
	                            <div class="form-group">
	                                <label for="number">Indexed From</label>
	                                <select>
	                                    <option value="0">0</option>
	                                    <option value="1">1</option>
	                                </select>   
	                            </div>
	                            
	                            <!-- Form Fields are placed in a row call script function when user changes option-->
	                           <div class="form-group">
	                                        <label for="text">Weighted</label>
	                                        <select onchange="setDisplay(this,'SetDisplayForWeighted')">
	                                            <option value="true" selected>True</option>
	                                            <option value="false">False</option>
	                                        </select>
	                                    <div class="row">
	                                    <div id="SetDisplayForWeighted">
	                                        <br />
	                                        <div class="col-xs-4">
	                                            <label for="number">Min Weight</label>
	                                            <input type="number" class="form-control"  name="minWeight">
	                                        </div>
	                                        <div class="col-xs-4">
	                                            <label for="number">Max Weight</label>
	                                            <input type="number" class="form-control"  name="maxWeight"> 
	                                        </div>
	                                        <div class="col-xs-4">
	                                             <label for="boolean">Distinct:</label>
	                                            <select>
	                                                <option value="true">True</option>
	                                                <option value="false">False</option>
	                                            </select>
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                            
	                             <div class="form-group">
	                                <div class="row">
	                                    <div class="col-xs-4">
	                                        <label for="text">No Of Children</label>
	                                        <select onchange="setDisplay(this,'SetDisplayForChildren')">
	                                            <option value="random">random</option>
	                                            <option value="specify" selected>specify</option>
	                                        </select>
	                                    </div>
	                                    <div id="SetDisplayForChildren">
	                                        <div class="col-xs-4">
	                                            <br />
	                                            <input type="number" class="form-control"  name="noOfChildren">
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                            
	                            <div class="form-group">
	                                <label for="text">Directed</label>
	                                <select>
	                                    <option value="true">True</option>
	                                    <option value="false">False</option>
	                                </select>
	                            </div>
	                            
	                            <button type="submit" class="btn btn-primary">Submit</button>
	                        </form>
						</div>
						<!--  Numeric Tree Form Ended -->
						
						<!--  Character Tree Form  -->
						<div id="characterTreeForm" class="center-block" style="display:none;">
		                        <h2>Character Tree </h2>
		                        <form action="" method=''>
		                        
		                            <div class="form-group">
		                                <div class="row">
		                                    <div class="col-xs-6">
		                                        <label for="number">Test cases</label>
		                                        <input type="number" class="form-control"  name="noOfTestcases">
		                                    </div>
		                                    <div class="col-xs-6">
		                                        <label for="number">No Of Nodes</label>
		                                        <input type="number" class="form-control"  name="noOfNodes">
		                                    </div>
		                                </div>
		                            </div>
		                            
		                            <div class="form-group">
		                                <label for="number">Min Node Char value</label>
		                                <input type="number" class="form-control"  name="minNodeCharValue">
		                            </div>
		                            
		                             <div class="form-group">
		                                <label for="number">Max Node Char value</label>
		                                <input type="number" class="form-control"  name="maxNodeCharValue">
		                            </div>
		                            
		                            <div class="form-group">
                                        <label for="text">Weighted</label>
                                        <select onchange="setDisplay(this,'SetDisplayForWeighted1')">
                                            <option value="true" selected>True</option>
                                            <option value="false">False</option>
                                        </select>
	                                    <div class="row">
	                                    <div id="SetDisplayForWeighted1">
	                                        <br />
	                                        <div class="col-xs-4">
	                                            <label for="number">Min Weight</label>
	                                            <input type="number" class="form-control"  name="minWeight">
	                                        </div>
	                                        <div class="col-xs-4">
	                                            <label for="number">Max Weight</label>
	                                            <input type="number" class="form-control"  name="maxWeight"> 
	                                        </div>
	                                        <div class="col-xs-4">
	                                             <label for="boolean">Distinct:</label>
	                                            <select>
	                                                <option value="true">True</option>
	                                                <option value="false">False</option>
	                                            </select>
	                                        </div>
	                                    </div>
	                                </div>
		                            </div>
		                            
		                            <div class="form-group">
		                                <div class="row">
		                                    <div class="col-xs-5">
		                                        <label for="text">No Of Children</label>
		                                        <select onchange="setDisplay(this,'SetDisplayForChildren1')">
		                                            <option value="random">random</option>
		                                            <option value="specify" selected>specify</option>
		                                        </select>
		                                    </div>
		                                    <div id="SetDisplayForChildren1">
		                                        <div class="col-xs-5">
		                                            <br />
		                                            <input type="number" class="form-control"  name="noOfChildren">
		                                        </div>
		                                    </div>
		                                </div>
		                            </div>
		                            
		                            <div class="form-group">
		                                <label for="text">Directed</label>
		                                <select>
		                                    <option value="true">True</option>
		                                    <option value="false">False</option>
		                                </select>
		                            </div>
		                            
		                            <button type="submit" class="btn btn-primary">Submit</button>
		                        </form>
		                    </div>
		                    
		                    <!--  Full Binary Tree Form -->
							<div id="fullBinaryTreeForm" class="center-block" style="display:none;">
		                        <h2> FullBinary Tree</h2>
		                        <form action="" method=''>
		                        
		                              <!-- Form Fields are placed in a row-->
		                             <div class="form-group">
		                                <div class="row">
		                                    <div class="col-xs-6">
		                                        <label for="number">Test cases</label>
		                                        <input type="number" class="form-control"  name="noOfTestcases">
		                                    </div>
		                                    <div class="col-xs-6">
		                                        <label for="number">No Of Levels</label>
		                                        <input type="number" class="form-control"  name="noOfLevels">
		                                    </div>
		                                </div>
		                            </div>
		                            
		                            <div class="form-group">
		                                <label for="number">Indexed From</label>
		                                <select>
		                                    <option value="0">0</option>
		                                    <option value="1">1</option>
		                                </select>   
		                            </div>
		                            
		                            <!-- Form Fields are placed in a row call script function when user changes option-->
		                           <div class="form-group">
		                                        <label for="text">Weighted</label>
		                                        <select onchange="setDisplay(this,'SetDisplayForWeighted2')">
		                                            <option value="true" selected>True</option>
		                                            <option value="false">False</option>
		                                        </select>
		                                    <div class="row">
		                                    <div id="SetDisplayForWeighted2">
		                                        <br />
		                                        <div class="col-xs-4">
		                                            <label for="number">Min Weight</label>
		                                            <input type="number" class="form-control"  name="minWeight">
		                                        </div>
		                                        <div class="col-xs-4">
		                                            <label for="number">Max Weight</label>
		                                            <input type="number" class="form-control"  name="maxWeight"> 
		                                        </div>
		                                        <div class="col-xs-4">
		                                             <label for="boolean">Distinct:</label><br />
		                                            <select>
		                                                <option value="true">True</option>
		                                                <option value="false">False</option>
		                                            </select>
		                                        </div>
		                                    </div>
		                                </div>
		                            </div>
		                            <button type="submit" class="btn btn-primary">Submit</button>
		                        </form>
		                    </div>
		                    
		                    <div class="col-xs-8" style="margin-left:100px">
		                    	<!--  Skew Tree Form -->
						        <div id="skewTreeForm"  class="center-block" style="display:none">
		                            <h2> Skew Tree</h2>
		                        <form action="" method=''>
		                        
		                              <!-- Form Fields are placed in a row-->
		                             <div class="form-group">
		                                <div class="row">
		                                    <div class="col-xs-6">
		                                        <label for="number">Test cases</label>
		                                        <input type="number" class="form-control"  name="noOfTestcases">
		                                    </div>
		                                    <div class="col-xs-6">
		                                        <label for="number">No Of Levels</label>
		                                        <input type="number" class="form-control"  name="noOfLevels">
		                                    </div>
		                                </div>
		                            </div>
		                            
		                            <div class="form-group">
		                                <label for="number">Indexed From</label>
		                                <select>
		                                    <option value="0">0</option>
		                                    <option value="1">1</option>
		                                </select>   
		                            </div>
		                            
		                            <!-- Form Fields are placed in a row call script function when user changes option-->
		                           <div class="form-group">
		                                        <label for="text">Weighted</label>
		                                        <select onchange="setDisplay(this,'SetDisplayForWeighted3')">
		                                            <option value="true" selected>True</option>
		                                            <option value="false">False</option>
		                                        </select>
		                                    <div class="row">
		                                    <div id="SetDisplayForWeighted3">
		                                        <br />
		                                        <div class="col-xs-4">
		                                            <label for="number">Min Weight</label>
		                                            <input type="number" class="form-control"  name="minWeight">
		                                        </div>
		                                        <div class="col-xs-4">
		                                            <label for="number">Max Weight</label>
		                                            <input type="number" class="form-control"  name="maxWeight"> 
		                                        </div>
		                                        <div class="col-xs-4">
		                                             <label for="boolean">Distinct:</label><br />
		                                            <select>
		                                                <option value="true">True</option>
		                                                <option value="false">False</option>
		                                            </select>
		                                        </div>
		                                    </div>
		                                </div>
		                            </div>
		                            <button type="submit" class="btn btn-primary">Submit</button>
		                        </form>
					        </div>
                   		</div>
					</div>
				</div>
			</div>
	</body>	
</html>	