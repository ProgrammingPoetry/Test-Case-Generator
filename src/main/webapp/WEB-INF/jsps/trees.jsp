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
	    <script src="/js/trees.js"> </script>  
	    <script>
	    
	    //validation of Numeric Tree
	   function validateNumericTree(testCases,nodes,indexedFrom,weighted,minWeight,maxWeight,distinct){
	    	var status="";
		   if(testCases.value=="" || testCases.value < 1 || testCases.value > 100 ){
	       		document.getElementById('errorinfo_numerictree_testCases').innerHTML="Enter valid value";
	       		status="failure";
	    	}
		   if(nodes.value=="" || nodes.value < 1 || nodes.value > 1000 ){
	       		document.getElementById('errorinfo_numerictree_nodes').innerHTML="Enter valid value";
	       		status="failure";
	    	}
	        if(weighted.value=="true" && ( minWeight.value=="" || minWeight.value < -100000 || minWeight.value > 100000 )){
	       		document.getElementById('errorinfo_numerictree_minWeight').innerHTML="enter valid value"; 
	       		status="failure";
	        }
	         
	        if(weighted.value=="true" && ( maxWeight.value=="" || maxWeight.value < -100000  || maxWeight.value > 100000 )){
	       		document.getElementById('errorinfo_numerictree_maxWeight').innerHTML="enter valid value";
	       		status="failure";
	        }
			
	        // ajax call for Numeric Tree Form
	        
	        if(status!="failure"){
	        	
	        	if(weighted.value=="false"){
	        		minWeight.value=0;
	        		maxWeight.value=0;
	        		distinct.value="false";
	        	}
	            $.ajax({ 
	                type: "POST",
	                url: "/treeService",
	                data: { category: "numericTree", testCases:testCases.value,nodes:nodes.value,
	                	indexedFrom:indexedFrom.value,weighted:weighted.value,minWeight:minWeight.value,
	                	maxWeight:maxWeight.value,distinct:distinct.value
	                },
	                success: successFunc,
	                error: errorFunc
	            });
	            function successFunc(data) {
	            	if(data["status"]==="Success"){
	            		download(data["testData"]);
	            	}
	            	document.getElementById('numerictree_results').innerHTML=data["status"]+":"+data["description"];
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
		<header class="container-fluid text-center">
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
	                        <form action="" method="post">
	                        
	                            <div class="form-group">
	                                <div class="row">
	                                    <div class="col-xs-6">
	                                        <label for="number">Test cases</label>
	                                        <input type="number" class="form-control"  name="testCases">
	                                        <span id="errorinfo_numerictree_testCases"></span>
	                                    </div>
	                                    <div class="col-xs-6">
	                                        <label for="number">No Of Nodes</label>
	                                        <input type="number" class="form-control"  name="nodes">
	                                        <span id="errorinfo_numerictree_nodes"></span>
	                                    </div>
	                                </div>
	                            </div>
	                            
	                            <div class="form-group">
	                                <label for="number">Indexed From</label>
	                                <select name="indexedFrom">
	                                    <option value="0">0</option>
	                                    <option value="1">1</option>
	                                </select>   
	                            </div>
	                            
	                            <!-- Form Fields are placed in a row call script function when user changes option-->
	                           <div class="form-group">
	                                        <label for="text">Weighted</label>
	                                        <select onchange="setDisplay(this,'SetDisplayForWeighted')" name="weighted">
	                                            <option value="true" selected>True</option>
	                                            <option value="false">False</option>
	                                        </select>
	                                    <div class="row">
	                                    <div id="SetDisplayForWeighted">
	                                        <br />
	                                        <div class="col-xs-4">
	                                            <label for="number">Min Weight</label>
	                                            <input type="number" class="form-control"  name="minWeight">
	                                            <span id="errorinfo_numerictree_minWeight"></span>
	                                        </div>
	                                        <div class="col-xs-4">
	                                            <label for="number">Max Weight</label>
	                                            <input type="number" class="form-control"  name="maxWeight">
	                                             <span id="errorinfo_numerictree_maxWeight"></span>
	                                        </div>
	                                        <div class="col-xs-4">
	                                             <label for="boolean">Distinct:</label>
	                                            <select name="distinct">
	                                                <option value="true">True</option>
	                                                <option value="false">False</option>
	                                            </select>
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                          
	                            <span id="numerictree_results"></span><br>
	                            <button type="button" class="btn btn-primary" onclick="validateNumericTree(testCases,nodes,indexedFrom,weighted,minWeight,maxWeight,distinct)">Submit</button>
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