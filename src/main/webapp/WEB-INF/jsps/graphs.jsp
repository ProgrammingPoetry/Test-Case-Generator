<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/styles.css">
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
    </script>      
</head>
<body>
    <!-- Header Section-->
    <header class="container-fluid text-center" >
            <h1>Graphs</h1>
    </header>
    <!-- sliding form when button is clicked-->
    <div class="accordion" id="myAccordion">
        <div class="panel">
            <button type="button"  class="btn btn-primary btn-xl"   data-toggle="collapse" data-target="#NumericGraph" data-parent="#myAccordion">Numeric Graph</button>
            <div  id="NumericGraph" class="collapse" class="container">
                <!--Numeric Graph Form-->
                <div class="center-block" style="width:385px; background:lightgreen;border-radius:10px;padding:10px;margin-top:45px;">
                        <h2> Numeric Graph </h2>
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
                    <!-- Numeric Graph Form ends here-->
                </div>


                <button type="button"   class="btn btn-primary btn-xl"   data-toggle="collapse" data-target="#CompleteGraph" data-parent="#myAccordion">Complete Graph</button>
                <div  id="CompleteGraph" class="collapse" class="container">
                <!-- Complete Graph Form-->
                <div class="center-block" style="width:375px; background:lightgreen;border-radius:10px;padding:10px;margin-top:45px;">
                        <h2>Complete Graph</h2>
                        <form action="" method='post'>
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
                    <!-- Complete Graph form ended-->
            </div>
            <button type="button"   class="btn btn-primary btn-xl"   data-toggle="collapse" data-target="#NPartiteGraph" data-parent="#myAccordion">NPartite Graph</button>
            <div  id="NPartiteGraph" class="collapse" class="container">
                <!-- NPartite Graph Form-->
                <div class="center-block" style="width:375px; background:lightgreen;border-radius:10px;padding:10px;margin-top:45px;">
                        <h2>NPartite Graph</h2>
                        <form action="" method='post'>
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
                            <!--    -->
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
                    <!-- NPartite Graph form ended-->
            </div>
        </div>
    </div>
</body>
</html>
	