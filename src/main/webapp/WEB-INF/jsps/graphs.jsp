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
    <script src="/js/graphs.js"></script>    
    <script>
    function validateCompleteGraph(testCases,minValue,maxValue,indexedFrom,weighted,minWeight,maxWeight,distinct){
    	var status="";
		   if(testCases.value=="" || testCases.value < 1 || testCases.value > 100 ){
	       		document.getElementById('errorinfo_completegraph_testCases').innerHTML="testcases range : 1-100";
	       		status="failure";
	    	}
		   if(minValue.value=="" || minValue.value < 2 || minValue.value > 50 ){
	       		document.getElementById('errorinfo_completegraph_minValue').innerHTML="min value range : 2-50";
	       		status="failure";
	    	}
		   if(maxValue.value=="" || maxValue.value < 1 || maxValue.value > 50 ){
	       		document.getElementById('errorinfo_completegraph_maxValue').innerHTML="min value range : 1-50";
	       		status="failure";
	    	}
		   
	        if(weighted.value=="true" && ( minWeight.value=="" || minWeight.value < -1000000000 || minWeight.value > 1000000000 )){
	       		document.getElementById('errorinfo_completegraph_minWeight').innerHTML="min weight range : -10^9 - 10^9"; 
	       		status="failure";
	        }
	         
	        if(weighted.value=="true" && ( maxWeight.value=="" || maxWeight.value < -1000000000  || maxWeight.value > 1000000000 )){
	       		document.getElementById('errorinfo_completegraph_maxWeight').innerHTML="max weight range : -10^9 - 10^9";
	       		status="failure";
	        }
			
	        // ajax call for Complete Graph Tree Form
	        
	        if(status!="failure"){
	        	
	        	if(weighted.value=="false"){
	        		minWeight.value=0;
	        		maxWeight.value=0;
	        		distinct.value="false";
	        	}
	            $.ajax({ 
	                type: "POST",
	                url: "/graphService",
	                data: { category: "completeGraph", testCases:testCases.value,minValue:minValue.value,maxValue:maxValue.value,
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
	            	console.log(data);
	            	document.getElementById('completegraph_results').innerHTML=data["status"]+":"+data["description"];
	               console.log(data);
	            }

	            function errorFunc() {
	                alert('error');
	            }
	            }
    }
    
    function validateBasicGraph(testCases,nodes,edges,indexedFrom,weighted,minWeight,maxWeight,distinct,directed,multipleEdges){
    	var status="";
		   if(testCases.value=="" || testCases.value < 1 || testCases.value > 50 ){
	       		document.getElementById('errorinfo_basicgraph_testCases').innerHTML="testcases range : 1-100";
	       		status="failure";
	    	}
		   if(nodes.value=="" || nodes.value < 1 || nodes.value > 50 ){
	       		document.getElementById('errorinfo_basicgraph_nodes').innerHTML="nodes value range : 1-50";
	       		status="failure";
	    	}
		   if(edges.value=="" || edges.value < 0 || edges.value > 2450 ){
	       		document.getElementById('errorinfo_basicgraph_edges').innerHTML="edges range : 0-2450";
	       		status="failure";
	    	}
	        if(weighted.value=="true" && ( minWeight.value=="" || minWeight.value < -1000000000 || minWeight.value > 1000000000 )){
	       		document.getElementById('errorinfo_basicgraph_minWeight').innerHTML="min weight range : -10^9 - 10^9"; 
	       		status="failure";
	        }
	         
	        if(weighted.value=="true" && ( maxWeight.value=="" || maxWeight.value < -1000000000  || maxWeight.value > 1000000000 )){
	       		document.getElementById('errorinfo_basicgraph_maxWeight').innerHTML="max weight range : -10^9 - 10^9";
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
	                url: "/graphService",
	                data: { category: "basicGraph", testCases:testCases.value,nodes:nodes.value,edges:edges.value,
	                	indexedFrom:indexedFrom.value,weighted:weighted.value,minWeight:minWeight.value,
	                	maxWeight:maxWeight.value,distinct:distinct.value,directed:directed.value,multipleEdges:multipleEdges.value
	                },
	                success: successFunc,
	                error: errorFunc
	            });
	            function successFunc(data) {
	            	if(data["status"]==="Success"){
	            		download(data["testData"]);
	            	}
	            	document.getElementById('completegraph_results').innerHTML=data["status"]+":"+data["description"];
	               console.log(data);
	            }

	            function errorFunc() {
	                alert('error');
	            }
	            }
		   
    }
    
    //validation for npartite graph
   function  validateNPartiteGraph(testCases,n1,n2,indexedFrom,weighted,minWeight,maxWeight,distinct){
	   
	   var status="";
	   if(testCases.value=="" || testCases.value < 1 || testCases.value > 50 ){
       		document.getElementById('errorinfo_npartitegraph_testCases').innerHTML="testcases range : 1-50";
       		status="failure";
    	}
	   
	   if(n1.value=="" || n1.value < 1 || n1.value > 50 ){
      		document.getElementById('errorinfo_npartitegraph_n1').innerHTML="n1 value range : 1-50";
      		status="failure";
   		}
	   
	   if(n2.value=="" || n2.value < 1 || n2.value > 50 ){
     		document.getElementById('errorinfo_npartitegraph_n2').innerHTML="n2 value range : 1-50";
     		status="failure";
  		}
	   if(weighted.value=="true" && ( minWeight.value=="" || minWeight.value < -1000000000 || minWeight.value > 1000000000 )){
      		document.getElementById('errorinfo_npartitegraph_minWeight').innerHTML="min weight range : -10^9 - 10^9"; 
      		status="failure";
       }
        
       if(weighted.value=="true" && ( maxWeight.value=="" || maxWeight.value < -1000000000  || maxWeight.value > 1000000000 )){
      		document.getElementById('errorinfo_npartitegraph_maxWeight').innerHTML="max weight range : -10^9 - 10^9";
      		status="failure";
       }
		
       // ajax call for NPartite Tree Form
       
       if(status!="failure"){
       	
       	if(weighted.value=="false"){
       		minWeight.value=0;
       		maxWeight.value=0;
       		distinct.value="false";
       	}
           $.ajax({ 
               type: "POST",
               url: "/graphService",
               data: { category: "nPartiteGraph", testCases:testCases.value,n1:n1.value,n2:n2.value,
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
           	document.getElementById('npartitegraph_results').innerHTML=data["status"]+":"+data["description"];
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
							<p>Basic Graph</p>
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
						<h2> Basic Graph</h2>
						<form action="" method='post'>
	                            <div class="form-group">
	                                <label for="number">Test cases</label>
	                                <input type="number" class="form-control"  name="testCases">
	                                 <span id="errorinfo_basicgraph_testCases"></span>
	                            </div>
	                            
	                            <!-- Form Fields are placed in a row-->
	                            <div class="form-group">
	                                <div class="row">
	                                    <div class="col-xs-6">
	                                        <label for="number">No Of Nodes</label>
	                                        <input type="number" class="form-control"  name="nodes" >
	                                          <span id="errorinfo_basicgraph_nodes"></span>
	                                        
	                                    </div>
	                                    <div class="col-xs-6">  
	                                    <br>
			                                <label for="number">Indexed From</label>
			                                <select name="indexedFrom">
			                                    <option value="0">0</option>
			                                    <option value="1">1</option>
			                                </select>   
	    									 <span id="errorinfo_basicgraph_indexedFrom"></span>				
	                                    </div>
	                                </div>
	                            </div>
	                            
	                            <div class="form-group">
	                                 <label for="number">No Of Edges</label>
	                                 <input type="number" class="form-control"  name="edges">
	                                  <span id="errorinfo_basicgraph_edges"></span>	
	                            </div>
	                            
	                            <!-- Form Fields are placed in a row-->
	                           <div class="form-group">
	                                <div class="row">
	                                    <div class="col-xs-4">
	                                        <label for="text">Weighted</label>
	                                        <select onchange="setDisplay(this,'SetDisplayForWeighted')" name="weighted">
	                                            <option value="true" selected>True</option>
	                                            <option value="false">False</option>
	                                        </select>
	                                    </div>
	                                    <div id="SetDisplayForWeighted">
	                                        <div class="col-xs-4">
	                                            <label for="number">Min Weight</label>
	                                            <input type="number" class="form-control"  name="minWeight">
	                                             <span id="errorinfo_basicgraph_minWeight"></span>	
	                                        </div>
	                                        <div class="col-xs-4">
	                                            <label for="number">Max Weight</label>
	                                            <input type="number" class="form-control"  name="maxWeight"> 
	                                             <span id="errorinfo_basicgraph_maxWeight"></span>	
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                           <br />
	                           
	                            <div class="form-group">
	                                 <div class="row">
	                                    <div class="col-xs-6">
	                                        <label for="boolean">Directed:</label>
	                                        <select name="directed">
	                                            <option value="true">True</option>
	                                            <option value="false">False</option>
	                                        </select>
	                                    </div>
	                                    <div class="col-xs-6">
	                                        <label for="boolean">Distinct:</label>
	                                        <select name="distinct">
	                                            <option value="true">True</option>
	                                            <option value="false">False</option>
	                                        </select>
	                                    </div>
	                                </div>
	                            </div>
	                            
	                             <div class="form-group">
	                                 <label for="boolean">Multiple Edges</label>
	                                <select name="multipleEdges">
	                                    <option value="true">True</option>
	                                    <option value="false">False</option>
	                                </select>
	                            </div>
	                             <span id="completegraph_results"></span><br>	
	                            <button type="button" class="btn btn-primary" onclick="validateBasicGraph(testCases,nodes,edges,indexedFrom,weighted,minWeight,maxWeight,distinct,directed,multipleEdges)">Submit</button>
	                      </form>
					</div>
					
					<!--  Complete Graph Form -->
					<div id="completeGraphForm" class="center-block" style="display:none;">
	                        <h2>Complete Graph</h2>
	                        <form action="" method=''>
	                            <div class="form-group">
	                                <label for="number">Test cases</label>
	                                <input type="number" class="form-control"  name="testCases">
	                                <span id="errorinfo_completegraph_testCases"></span>
	                            </div>
	                            <div class="form-group">
	                            	<div class="row">
	                            		<div class="col-xs-6">
	                                            <label for="number">Min Value</label>
	                                            <input type="number" class="form-control"  name="minValue">
	                                            <span id="errorinfo_completegraph_minValue"></span>
	                                        </div>
	                                        <div class="col-xs-6">
	                                            <label for="number">Max Value</label>
	                                            <input type="number" class="form-control"  name="maxValue">
	                                             <span id="errorinfo_completegraph_maxValue"></span>
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
	                                        <select onchange="setDisplay(this,'SetDisplayForWeighted3')" name="weighted">
	                                            <option value="true" selected>True</option>
	                                            <option value="false">False</option>
	                                        </select>
	                                    <div class="row">
	                                    <div id="SetDisplayForWeighted3">
	                                        <br />
	                                        <div class="col-xs-4">
	                                            <label for="number">Min Weight</label>
	                                            <input type="number" class="form-control"  name="minWeight">
	                                            <span id="errorinfo_completegraph_minWeight"></span>
	                                        </div>
	                                        <div class="col-xs-4">
	                                            <label for="number">Max Weight</label>
	                                            <input type="number" class="form-control"  name="maxWeight">
	                                             <span id="errorinfo_completegraph_maxWeight"></span>
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
	                          <span id="completegraph_results"></span><br>
	                            <button type="button" class="btn btn-primary" onclick="validateCompleteGraph(testCases,minValue,maxValue,indexedFrom,weighted,minWeight,maxWeight,distinct)">Submit</button>
	                        </form>
	                </div>
	                
	                <!--  NPartite Graph Form  -->	
					<div id="nPartiteGraphForm" class="center-block" style="display:none;">
                        <h2>NPartite Graph</h2>
                        <form action="" method=''>
                        
                              <!-- Form Fields are placed in a row-->
                            <div class="form-group">
                                <label for="number">Test cases</label>
                               	<input type="number" class="form-control"  name="testCases">
                               	<span id="errorinfo_npartitegraph_testCases"></span>
                            </div>
                            
                            <div class="form-group">
                            	<div class="row">
                            		<div class="col-xs-6">
                            			<label for="number">N1</label>
                                        <input type="number" class="form-control"  name="n1">
                                        	<span id="errorinfo_npartitegraph_n1"></span>
                            		</div>
                            		<div class="col-xs-6">
                            			<label for="number">N2</label>
                                        <input type="number" class="form-control"  name="n2">
                                        	<span id="errorinfo_npartitegraph_n2"></span>
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
                            
                            <!-- call script function when user changes the option-->
                            <div class="form-group">
                                <div class="row">
                                    <div class="col-xs-4">
                                        <label for="text">Weighted</label>
                                        <select onchange="setDisplay(this,'SetDisplayForWeighted1')" name="weighted">
                                            <option value="true" selected>True</option>
                                            <option value="false">False</option>
                                        </select>
                                    </div>
                                    <div id="SetDisplayForWeighted1">
                                        <div class="col-xs-4">
                                            <label for="number">Min Weight</label>
                                            <input type="number" class="form-control"  name="minWeight">
                                            <span id="errorinfo_npartitegraph_minWeight"></span>
                                        </div>
                                        <div class="col-xs-4">
                                            <label for="number">Max Weight</label>
                                            <input type="number" class="form-control"  name="maxWeight"> 
                                            <span id="errorinfo_npartitegraph_maxWeight"></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <br />
                            
                            <div class="form-group">
                                <label for="text">Distinct</label>
                                <select name="distinct">
                                    <option value="true">True</option>
                                    <option value="false">False</option>
                                </select>
                            </div>
                            <button type="button" class="btn btn-primary" onclick="validateNPartiteGraph(testCases,n1,n2,indexedFrom,weighted,minWeight,maxWeight,distinct)">Submit</button>
                        </form>   
                    </div>
				</div>
			</div>
		</div>
	</body>	
</html>