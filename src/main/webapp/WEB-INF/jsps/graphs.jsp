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
    <script>
    
        // script for setting display  when user changes the option in path problem 
            function setDisplay(selectObject,id){
             var value = selectObject.value;  
             if(value==="false"){
                    document.getElementById(id).style.display="none";
             }
             else{
                  document.getElementById(id).style.display="block";
             }
        }
		$(document).ready(
    function(){
        $("#numericGraph").css('background', '#26a655');  $("#numericGraph p").css('color', 'white');
        $("#numericGraphLink").click(function (e) {
            e.preventDefault();
            $("#numericGraphForm").slideDown();
			$("#completeGraphForm,#nPartiteGraphForm").hide();
            $("#numericGraph").css('background', '#26a655');  $("#numericGraph p").css('color', 'white');
            $("#completeGraph,#nPartiteGraph").css('background', 'white');  $("#completeGraph p,#nPartiteGraph p").css('color', '#26a655');
        });
		 $("#completeGraphLink").click(function (e) {
            e.preventDefault();
			$("#numericGraphForm,#nPartiteGraphForm").hide();
		    $("#completeGraphForm").slideDown();
            $("#completeGraph").css('background', '#26a655');$("#completeGraph p").css('color', 'white');
            $("#numericGraph,#nPartiteGraph").css('background', 'white');  $("#numericGraph p,#nPartiteGraph p").css('color', '#26a655');
        });
		 $("#nPartiteGraphLink").click(function (e) {
             e.preventDefault();
			 $("#numericGraphForm,#completeGraphForm").hide();
             $("#nPartiteGraphForm").slideDown();
             $("#nPartiteGraph").css('background', '#26a655'); $("#nPartiteGraph p").css('color', 'white');
             $("#numericGraph,#completeGraph").css('background', 'white');  $("#numericGraph p,#completeGraph p").css('color', '#26a655');
        });
    });
    </script>      
</head>
	<body>
		<!-- Header Section-->
		<header class="container-fluid text-center" >
				<h1>Graphs</h1>
		</header>
		<!-- End of Header Section -->
		
		<div class="container">
			<!--  buttons and their respective Forms are arranged in a row -->
			<div class="row">
				<!-- Buttons for different Data types  -->
				<div class="col-xs-2">
					<a   id="numericGraphLink" href="" >
						<div id="numericGraph">
							<p>Numeric Graph</p>
						</div>
					</a>
					<a id="completeGraphLink" href="" >
						<div id="completeGraph">
							<p>Complete Graph</p>
						</div>
					</a>
					<a id="nPartiteGraphLink" href=""	>
						<div id="nPartiteGraph">
							<p>NPartite Graph</p>
						</div>
					</a>
				</div>
				
				
				<div class="col-xs-8" style="margin-left:100px;">
					<!--  Number Graph form  -->
					<div id="numericGraphForm"  class="center-block">
						<h2>Numeric Graph</h2>
						<form action="" method='post'>
	                            <div class="form-group">
	                                <label for="number">Test cases</label>
	                                <input type="number" class="form-control"  name="noOfTestcases">
	                            </div>
	                            
	                            <!-- Form Fields are placed in a row-->
	                            <div class="form-group">
	                                <div class="row">
	                                    <div class="col-xs-6">
	                                        <label for="number">No Of Nodes</label>
	                                        <input type="number" class="form-control"  name="noOfNodes" >
	                                    </div>
	                                    <div class="col-xs-6">
	                                        <label for="number">Indexed From</label>
	                                        <input type="number" class="form-control"  name="indexedFrom">
	                                    </div>
	                                </div>
	                            </div>
	                            
	                            <div class="form-group">
	                                 <label for="number">No Of Edges</label>
	                                 <input type="number" class="form-control"  name="noOfEdges">
	                            </div>
	                            
	                            <!-- Form Fields are placed in a row-->
	                           <div class="form-group">
	                                <div class="row">
	                                    <div class="col-xs-4">
	                                        <label for="text">Weighted</label>
	                                        <select onchange="setDisplay(this,'SetDisplayForWeighted')">
	                                            <option value="true" selected>True</option>
	                                            <option value="false">False</option>
	                                        </select>
	                                    </div>
	                                    <div id="SetDisplayForWeighted">
	                                        <div class="col-xs-4">
	                                            <label for="number">Min Weight</label>
	                                            <input type="number" class="form-control"  name="minWeight">
	                                        </div>
	                                        <div class="col-xs-4">
	                                            <label for="number">Max Weight</label>
	                                            <input type="number" class="form-control"  name="maxWeight"> 
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                           <br />
	                           
	                            <div class="form-group">
	                                 <div class="row">
	                                    <div class="col-xs-6">
	                                        <label for="boolean">Directed:</label>
	                                        <select>
	                                            <option value="true">True</option>
	                                            <option value="false">False</option>
	                                        </select>
	                                    </div>
	                                    <div class="col-xs-6">
	                                        <label for="boolean">Distinct:</label>
	                                        <select>
	                                            <option value="true">True</option>
	                                            <option value="false">False</option>
	                                        </select>
	                                    </div>
	                                </div>
	                            </div>
	                            
	                             <div class="form-group">
	                                 <label for="boolean">Multiple Edges</label>
	                                <select>
	                                    <option value="true">True</option>
	                                    <option value="false">False</option>
	                                </select>
	                            </div>
	                            
	                            <div class="form-group">
	                                <div class="row">
	                                    <div class="col-xs-4">
	                                        <label for="text">Path Problem</label>
	                                        <select onchange="setDisplay(this,'SetDisplayForPathProblem')">
	                                            <option value="true" selected>True</option>
	                                            <option value="false">False</option>
	                                        </select>
	                                    </div>
	                                    <div id="SetDisplayForPathProblem">
	                                        <div class="col-xs-4">
	                                            <label for="number">Source Node </label>
	                                            <input type="number" class="form-control"  name="sourceNode">
	                                        </div>
	                                        <div class="col-xs-4">
	                                            <label for="number">Dest Node</label>
	                                            <input type="number" class="form-control"  name="destNode"> 
	                                        </div>
	                                        <div class="col-xs-4">
	                                            <label for="number">Path Present</label>
	                                            <select>
	                                            <option value="true">True</option>
	                                            <option value="false">False</option>
	                                            <option value="random">random</option>
	                                        </select>
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                            
	                            <button type="submit" class="btn btn-primary">Submit</button>
	                      </form>
					</div>
					
					<!--  Complete Graph Form -->
					<div id="completeGraphForm" class="center-block" style="display:none;">
	                        <h2>Complete Graph</h2>
	                        <form action="" method=''>
	                            <div class="form-group">
	                                <label for="number">Test cases</label>
	                                <input type="number" class="form-control"  name="noOfTestcases">
	                            </div>
	                            <div class="form-group">
	                                <label for="number">N</label>
	                                <input type="number" class="form-control"  name="n">
	                            </div>
	                            <button type="submit" class="btn btn-primary">Submit</button>
	                        </form>
	                </div>
	                
	                <!--  NPartite Graph Form  -->	
					<div id="nPartiteGraphForm" class="center-block" style="display:none;">
                        <h2>NPartite Graph</h2>
                        <form action="" method=''>
                        
                              <!-- Form Fields are placed in a row-->
                            <div class="form-group">
                                <div class="row">
                                    <div class="col-xs-6">
                                        <label for="number">Test cases</label>
                                        <input type="number" class="form-control"  name="noOfTestcases">
                                    </div>
                                    <div class="col-xs-6">
                                        <label for="number">N</label>
                                        <input type="number" class="form-control"  name="n">
                                    </div>
                                </div>
                            </div>
                            
                             <div class="form-group">
                                <label for="number">No Of Nodes in group1</label>
                                <input type="number" class="form-control"  name="group1Nodes">
                            </div>
                            
                             <div class="form-group">
                                <label for="number">No Of Nodes in group2</label>
                                <input type="number" class="form-control"  name="group2Nodes">
                            </div>
                            
                            <div class="form-group">
                                <label for="number">Indexed From</label>
                                <input type="number" class="form-control"  name="indexedFrom">
                            </div>
                            
                            <!-- call script function when user changes the option-->
                            <div class="form-group">
                                <div class="row">
                                    <div class="col-xs-4">
                                        <label for="text">Weighted</label>
                                        <select onchange="setDisplay(this,'SetDisplayForWeighted1')">
                                            <option value="true" selected>True</option>
                                            <option value="false">False</option>
                                        </select>
                                    </div>
                                    <div id="SetDisplayForWeighted1">
                                        <div class="col-xs-4">
                                            <label for="number">Min Weight</label>
                                            <input type="number" class="form-control"  name="minWeight">
                                        </div>
                                        <div class="col-xs-4">
                                            <label for="number">Max Weight</label>
                                            <input type="number" class="form-control"  name="maxWeight"> 
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <br />
                            
                            <div class="form-group">
                                <label for="text">Distinct</label>
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