<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/css/styles.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
    // script for setting display  when user changes the option in path start and path end fields
        function setDisplay(selectObject,id){
             var value = selectObject.value;  
             if(value==="random"){
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
            <h1>Matrix</h1>
    </header>
    <!-- sliding form when button is clicked-->
    <div class="accordion" id="myAccordion">
        <div class="panel">
            <button type="button"  class="btn btn-primary btn-xl"   data-toggle="collapse" data-target="#MatrixOfNumbers" data-parent="#myAccordion">Matrix of Numbers</button>
            <div  id="MatrixOfNumbers" class="collapse" class="container">
                <!--Matrix of  Numbers Form-->
                <div class="center-block" style="width:375px; background:lightgreen;border-radius:10px;padding:10px;margin-top:45px;">
                        <h2>Matrix of Numbers</h2>
                        <form action="" method='post'>
                            <div class="form-group" name="div1">
                                <label for="number">Test cases</label>
                                <input type="number" class="form-control"  name="noOfTestcases">
                            </div>
                            <!-- Form Fields are placed in a row-->
                            <div class="form-group">
                                <div class="row">
                                    <div class="col-xs-6">
                                        <label for="number">Rows</label>
                                        <input type="number" class="form-control"  name="rows" >
                                    </div>
                                    <div class="col-xs-6">
                                        <label for="number">Columns</label>
                                        <input type="number" class="form-control"  name="columns">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="row">
                                    <div class="col-xs-6">
                                        <label for="number">Min Value</label>
                                        <input type="number" class="form-control"  name="minValue" >
                                    </div>
                                    <div class="col-xs-6">
                                        <label for="number">Max Value</label>
                                        <input type="number" class="form-control"  name="maxValue">
                                    </div>
                                </div>
                            </div>
                            <!-- div ends here-->
                            <div class="form-group">
                                <label for="number">Multipleof</label>
                                <input type="number" class="form-control"  name="multipleOf">
                            </div>
                            <div class="form-group">
                                 <div class="row">
                                    <div class="col-xs-6">
                                        <label for="boolean">Prime:</label>
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
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </form>
                    </div>
                    <!-- Matrix of Numbers Form ends here-->
                </div>


                <button type="button"   class="btn btn-primary btn-xl"   data-toggle="collapse" data-target="#MatrixOfCharacters" data-parent="#myAccordion">Matrix of Characters</button>
                <div  id="MatrixOfCharacters" class="collapse" class="container">
                <!-- Matrix of Characters Form-->
                <div class="center-block" style="width:375px; background:lightgreen;border-radius:10px;padding:10px;margin-top:45px;">
                        <h2>Matrix of Characters</h2>
                        <form action="" method="post">
                            <div class="form-group">
                                <label for="number">Test cases</label>
                                <input type="number" class="form-control"  name="noOfTestcases">
                            </div>
                             <!-- Form Fields are placed in a row-->
                             <div class="form-group">
                                <div class="row">
                                    <div class="col-xs-6">
                                        <label for="number">Rows</label>
                                        <input type="number" class="form-control"  name="rows" >
                                    </div>
                                    <div class="col-xs-6">
                                        <label for="number">Columns</label>
                                        <input type="number" class="form-control"  name="Columns">
                                    </div>
                                </div>
                            </div>
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
                                <div class="row">
                                    <div class="col-xs-6">
                                        <label for="text">Case:</label>
                                        <select>
                                            <option value="upper">upper</option>
                                            <option value="lower">lower</option>
                                            <option value="mixed">mixed</option>
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
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </form>
                    </div>
                    <!-- Matrix of Characters form ended-->
            </div>
            <button type="button"   class="btn btn-primary btn-xl"   data-toggle="collapse" data-target="#PathMatrix" data-parent="#myAccordion">Path Matrix</button>
            <div  id="PathMatrix" class="collapse" class="container">
                <!-- Path Matrix  Form-->
                <div class="center-block" style="width:375px; background:lightgreen;border-radius:10px;padding:10px;margin-top:45px;">
                        <h2>Path Matrix</h2>
                        <form action="" method='post'>
                            <div class="form-group">
                                <label for="number">Test cases</label>
                                <input type="number" class="form-control"  name="noOfTestcases">
                            </div>
                             <!-- Form Fields are placed in a row-->
                             <div class="form-group">
                                <div class="row">
                                    <div class="col-xs-6">
                                        <label for="number">Rows</label>
                                        <input type="number" class="form-control"  name="rows" >
                                    </div>
                                    <div class="col-xs-6">
                                        <label for="number">Columns</label>
                                        <input type="number" class="form-control"  name="Columns">
                                    </div>
                                </div>
                            </div>

                           
                            <!-- Form Fields are placed in a row-->
                            
                            <div class="form-group">
                                <label for="text">Characters to indicate blocked cell</label>
                                <input type="text" class="form-control"  name="blockedCell">
                            </div>
                            <div class="form-group">
                                <label for="text">Characters to indicate open cell</label>
                                <input type="text" class="form-control"  name="openCell">
                            </div>
                             <!-- call script function when user changes the option-->
                            <div class="form-group">
                                <div class="row">
                                    <div class="col-xs-4">
                                        <label for="text">Path Start</label>
                                        <select onchange="setDisplay(this,'displayInvisiblePathStart')">
                                            <option value="random">Random</option>
                                            <option value="specify" selected>Specify</option>
                                        </select>
                                    </div>
                                    <div id="displayInvisiblePathStart">
                                        <div class="col-xs-4">
                                            <label for="number">Rows</label>
                                            <input type="number" class="form-control"  name="rows">
                                        </div>
                                        <div class="col-xs-4">
                                            <label for="number">Columns</label>
                                            <input type="number" class="form-control"  name="Columns"> 
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <br>
                            <!-- call script function when user changes the option-->
                            <div class="form-group">
                                <div class="row">
                                    <div class="col-xs-4">
                                        <label for="text">Path End</label>
                                        <select onchange="setDisplay(this,'displayInvisiblePathEnd')">
                                            <option value="random">Random</option>
                                            <option value="specify" selected>Specify</option>
                                        </select>
                                    </div>
                                    <div id="displayInvisiblePathEnd">
                                        <div class="col-xs-4">
                                            <label for="number">Rows</label>
                                            <input type="number" class="form-control"  name="rows">
                                        </div>
                                        <div class="col-xs-4">
                                            <label for="number">Columns</label>
                                            <input type="number" class="form-control"  name="Columns"> 
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="text">Path Exists</label>
                                <select>
                                    <option value="true">True</option>
                                    <option value="false">False</option>
                                    <option value="mixed">Mixed</option>
                                </select>
                            </div>
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </form>
                    </div>
                    <!-- Path Matrix form ended-->
            </div>
        </div>
    </div>
</body>
</html>
	