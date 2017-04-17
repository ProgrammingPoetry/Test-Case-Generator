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
    </script>      
</head>
<body>
    <!-- Header Section-->
    <header class="container-fluid text-center" >
            <h1>Arrays</h1>
    </header>
    <!-- sliding form when button is clicked-->
    <div class="accordion" id="myAccordion">
        <div class="panel">
            <button type="button"  class="btn btn-primary btn-xl"   data-toggle="collapse" data-target="#ArrayOfNumbers" data-parent="#myAccordion">Array of Numbers</button>
            <div  id="ArrayOfNumbers" class="collapse" class="container">
                <!--Array of  Numbers Form-->
                <div class="center-block" style="width:375px; background:lightgreen;border-radius:10px;padding:10px;margin-top:45px;">
                        <h2>Array of Numbers</h2>
                        <form action="" method='post'>
                            <div class="form-group" name="div1">
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
                            <div class="form-group">
                                <div class="row">
                                    <div class="col-xs-6">
                                        <label for="number">Min Size</label>
                                        <input type="number" class="form-control"  name="minSize" >
                                    </div>
                                    <div class="col-xs-6">
                                        <label for="number">Max Size</label>
                                        <input type="number" class="form-control"  name="maxSize">
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
                            <div class="form-group">
                                <div class="row">
                                    <div class="col-xs-6">
                                        <label for="text">Sorted:</label>
                                        <select>
                                            <option value="ascending">Ascending</option>
                                            <option value="descending">Descending</option>
                                            <option value="none">None</option>
                                        </select>
                                    </div>
                                    <div class="col-xs-6">
                                        <label for="text">PrintSize:</label>
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
                    <!-- Array of Numbers Form ends here-->
                </div>


                <button type="button"   class="btn btn-primary btn-xl"   data-toggle="collapse" data-target="#ArrayOfCharacters" data-parent="#myAccordion">Array of Characters</button>
                <div  id="ArrayOfCharacters" class="collapse" class="container">
                <!-- Array of Characters Form-->
                <div class="center-block" style="width:375px; background:lightgreen;border-radius:10px;padding:10px;margin-top:45px;">
                        <h2>Array of Characters</h2>
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
                            <div class="form-group">
                                <div class="row">
                                    <div class="col-xs-6">
                                        <label for="number">Min Size</label>
                                        <input type="number" class="form-control"  name="minSize" >
                                    </div>
                                    <div class="col-xs-6">
                                        <label for="number">Max Size</label>
                                        <input type="number" class="form-control"  name="maxSize">
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
                             <div class="form-group">
                                 <div class="row">
                                     <div class="col-xs-6">
                                        <label for="text">Sorted:</label>
                                        <select>
                                            <option value="ascending">Ascending</option>
                                            <option value="descending">Descending</option>
                                            <option value="none">None</option>
                                        </select>
                                     </div>
                                    <div class="col-xs-6">
                                        <label for="text">PrintSize:</label>
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
                    <!-- Array of Characters form ended-->
            </div>
            <button type="button"   class="btn btn-primary btn-xl"   data-toggle="collapse" data-target="#ArrayOfStrings" data-parent="#myAccordion">Array Of Strings</button>
            <div  id="ArrayOfStrings" class="collapse" class="container">
                <!-- Array of Strings Form-->
                <div class="center-block" style="width:375px; background:lightgreen;border-radius:10px;padding:10px;margin-top:45px;">
                        <h2>Array of Strings</h2>
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
                                        <label for="boolean">Palindrome:</label>
                                        <select>
                                            <option value="true">True</option>
                                            <option value="false">False</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                             <div class="form-group">
                                 <div class="row">
                                    <div class="col-xs-6">
                                        <label for="boolean">Print length:</label>
                                        <select>
                                            <option value="true">True</option>
                                            <option value="false">False</option>
                                        </select>
                                    </div>
                                    <div class="col-xs-6">
                                        <label for="text">Sorted:</label>
                                        <select>
                                            <option value="ascending">Ascending</option>
                                            <option value="descending">Descending</option>
                                            <option value="none">None</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </form>
                    </div>
                    <!-- Array of characters form ended-->
            </div>
        </div>
    </div>
</body>
</html>
    