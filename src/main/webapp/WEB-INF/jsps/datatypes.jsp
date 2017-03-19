<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Test Case Generator</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://code.jquery.com/jquery-3.2.0.min.js"></script>
    <link rel="stylesheet" href="/css/datatypes.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
</head>
<body>
    <!-- Header Section-->
    <header class="container-fluid text-center" >
            <h1>Data Types</h1>
    </header>
    <!-- sliding form when button is clicked-->
    <div class="accordion" id="myAccordion">
        <div class="panel">
            <button type="button"  class="btn btn-primary btn-xl"   data-toggle="collapse" data-target="#number" data-parent="#myAccordion">Numbers</button>
            <div  id="number" class="collapse" class="container">
                <!-- Number Form-->
                <div class="center-block" style="width:300px; background:lightgreen;border-radius:10px;padding:10px;margin-top:45px;">
                        <h2>Number</h2>
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
                                <label for="number">Multipleof</label>
                                <input type="number" class="form-control"  name="multipleOf">
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
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </form>
                    </div>
                    <!-- Number Form ends here-->
                </div>
                <button type="button"   class="btn btn-primary btn-xl"   data-toggle="collapse" data-target="#character" data-parent="#myAccordion">Characters</button>
                <div  id="character" class="collapse" class="container">
                <!-- Characters Form-->
                <div class="center-block" style="width:300px; background:lightgreen;border-radius:10px;padding:10px;margin-top:45px;">
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
                    <!-- character form ended-->
            </div>
            <button type="button"   class="btn btn-primary btn-xl"   data-toggle="collapse" data-target="#string" data-parent="#myAccordion">Strings</button>
            <div  id="string" class="collapse" class="container">
                <!-- Strings Form-->
                <div class="center-block" style="width:300px; background:lightgreen;border-radius:10px;padding:10px;margin-top:45px;">
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
                                        <label for="number">MinChar Value</label>
                                        <input type="number" class="form-control"  name="minCharValue">
                                    </div>
                                    <div class="col-xs-6"> 
                                        <label for="number">MaxChar Value</label>
                                        <input type="number" class="form-control"  name="maxCharValue">
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
                    <!-- character form ended-->
            </div>
        </div>
    </div>
</body>
</html>