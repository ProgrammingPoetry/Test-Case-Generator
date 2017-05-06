<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <title>Test case Generator </title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/css/TestcaseGenerator.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script>
        </script>
    </head>
    <body>
    	<!--  Header Tag with Test case Generator logo  -->
    	
        <header class = "container-fluid text-center" >
            <img src="/Images/TestcaseGeneratorLogo.png" style="height:120%" alt="TG">
            <h1>Test Case Generator</h1>
        </header>
        
        <!--  End of Header  -->
        <br><br>
        
        <!--  list of Test case Generator functionalities -->
        
         <div class="container" id="list">
            <br><br>
                <table>
                    <tr>
                        <td>
                        
                        <!--  Data types functionality link wrapped in anchor tag -->
			                <div   id="list1">
			                    <a style="display:block" href="/testcasegenerator/datatypes">
				                    <div class="row">
				                        <div  class="col-md-6" >    
				                                <img class="img-circle" src="/Images/datatype.png">
				                        </div>
				                        <div  class="col-md-6" >
				                            <br>
				                               <p style="font-size:24px;color:green;margin-top:45px;">Data Types </p><br>
				                        </div>
				                    </div>
			                    </a>
			                </div>
                        </td>
                        
                        <td>
                          <!--  Arrays functionality link wrapped in anchor tag -->
			                <div   id="list2">
			                    <a style="display:block" href="">
				                    <div class="row">
				                        <div  class="col-md-6" >
				                                <span class="glyphicon glyphicon-th" style="font-size:70px;color:#26a655;margin-top:40px;margin-left:48px;"> </span>
				                        </div>
				                        <div  class="col-md-6" >
				                            <br>
				                                <p style="font-size:24px;color:green;margin-top:45px;margin-left:18px;">Arrays </p><br>
				                        </div>
				                    </div>
			                    </a>
			                </div>
               		  	</td>
                
		                <td>
		                  <!--  Matrix functionality link wrapped in anchor tag -->
			                <div   id="list3">
			                    <a style="display:block" href="/testcasegenerator/matrix">
				                    <div class="row">
				                        <div  class="col-md-6" >
				                               <span class="glyphicon glyphicon-th" style="font-size:70px;color:#26a655;margin-top:40px;margin-left:48px;"> </span>
				                        </div>
				                        <div  class="col-md-6" >
				                            <br>
				                                <p style="font-size:24px;color:green;margin-top:45px;margin-left:18px;">Matrix </p><br>
				                        </div>
				                    </div>
			                    </a>
			                </div>
		                </td>
                    </tr>
                    <tr>
                        <td>
                          <!--  Trees functionality link wrapped in anchor tag -->
			                <br><br>
			                <div   id="list4">
			                    <a style="display:block" href="/testcasegenerator/trees">
				                    <div class="row">
				                        <div  class="col-md-6" >
				                               <span class="glyphicon glyphicon-tree-deciduous" style="font-size:70px;color:#26a655;margin-top:40px;margin-left:48px;"> </span>
				                        </div>
				                        <div  class="col-md-6" >
				                            <br>
				                                <p style="font-size:24px;color:green;margin-top:42px;margin-left:18px;">Trees </p><br>
				                        </div>
				                    </div>
			                    </a>
			                </div>
                		</td>
		                <td>
		                  <!--  Graphs functionality link wrapped in anchor tag -->
		                    <br><br>
			                <div   id="list5">
			                    <a style="display:block" href="/testcasegenerator/graphs">
				                    <div class="row">
				                        <div  class="col-md-6" >
				                             <span class="glyphicon glyphicon-asterisk" style="font-size:70px;color:#26a655;margin-top:40px;margin-left:48px;"> </span>   
				                        </div>
				                        <div  class="col-md-6" >
				                            <br>
				                                <p style="font-size:24px;color:green;margin-top:42px;margin-left:18px;">Graphs</p><br>
				                        </div>
				                    </div>
			                    </a>
			                </div>
		                </td>
		                <td>
		                  <!--  Miscellaneous functionality link wrapped in anchor tag -->
			                <br><br>
			                <div   id="list6">
			                    <a style="display:block" href="/testcasegenerator/miscellaneous">
				                    <div class="row">
				                        <div  class="col-md-6" >
				                                <img class="img-circle" src="/Images/misc.jpg">
				                        </div>
				                        <div  class="col-md-6" >
				                            <br>
				                                <p style="font-size:24px;color:green;margin-top:45px;margin-left:18px;">Misc </p><br>
				                        </div>
				                    </div>
			                    </a>
			                </div>
		                </td>
                </tr>
                </table>
        </div>
        <!--  End of container  -->
    </body>
</html>