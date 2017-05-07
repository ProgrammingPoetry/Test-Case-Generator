<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
        <title>Test Case Generator</title>
        <link rel="icon" href="/Images/home-icon.ico" type="image/x-icon">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="/css/home.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script>
        </script>
    </head>
    <body>
    
    	<!--  Header page with menu buttons  -->
    	
        <header class = "container-fluid text-center"> 
            <div class="container">
                <div class="row">
                    <div class="col-xs-3" id="home" >
                        <a href="#homePage"><span class="glyphicon glyphicon-home"> </span> HOME</a>
                    </div>
                    <div class="col-xs-3" id="about">
                        <a  href="#aboutData"><span class="glyphicon glyphicon-user"> </span> ABOUT</a>
                    </div>
                    <div class="col-xs-3" id="team">
                        <a href="#contributorList"><span class="glyphicon glyphicon-user"> </span> CONTRIBUTORS</a>
                    </div>
                    <div class="col-xs-3" id="testcasegen">
                        <a href="/testcasegenerator"><span class="glyphicon glyphicon-wrench"></span> TEST CASE GENERATOR</a>
                     </div>
                </div>  
            </div>
        </header>
        
        <!--  End of Header  -->
        
        <!--  carousal or Image slider with some delay -->
        
         <div id="homePage">
            <div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="3000">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                    <li data-target="#myCarousel" data-slide-to="2"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner">
                    <div class="item active">
                        <img src="/Images/carousal1.png" alt="testcaseimage" style="width:100%;height:600px">
                        <div class="carousel-caption">
                            <h3>Test Case Generator</h3>
                            <p>Generate Test cases with ease</p>
                        </div>
                    </div>

                    <div class="item">
                        <img src="/Images/carousal2.jpg" alt="testcaseimage" style="width:100%;height:600px">
                        <div class="carousel-caption">
                            <h3>Test Case Generator</h3>
                            <p>Generate Test cases with ease</p>
                        </div>
                    </div>
    
                    <div class="item">
                        <img src="/Images/carousal3.jpg" alt="testcaseimage" style="width:100%;height:600px">
                        <div class="carousel-caption">
                            <h3>Test Case Generator</h3>
                            <p>Generate Test cases with ease</p>
                        </div>
                    </div>
                </div>

                <!-- Left and right controls -->
                <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
                <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#myCarousel" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
                <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
        
        <!--  End of carousal or Image slider -->


        <br><br>

		<!--  About page (when user clicks "about"  button in menu bar it is shown) -->
		
        <div id="aboutData">
            <br><br>
            <h1>ABOUT</h1><br><br>
            <div class="border"></div><br><br>
            <h2>Welcome to Test Case Generator</h2><br><br>
            <p>Test Case Generator is a tool which helps in generating test cases for several competitive programming problems. 
               Nowadays the data-set for test cases are being generated manually by the problem setters. 
               This project attempts to automate the generation of test cases and thereby saving time for the problem setter.

            <p>Our tool attempts to cater to the multi-disciplinary nature of programming problems spanning several domains such as Arrays, Trees, Graphs, etc.
                What are you waiting for? Start generating test data for your problems <a href="/testcasegenerator">here</a>! </p>
        </div>

		<!--  End of about Section -->
            <br><br><br><br><br><br><br><br>

		<!--  List of contributors are shown here  -->
		
        <div class="container" id="contributorList">
            <br><br>
                <h1>CONTRIBUTORS</h1><br><br>
                <div class="border"></div><br><br>

                <div   id="contributorDetails1">
                    <div class="row" style="padding: 5px">
                        <div  class="col-md-6" >
                                <img id="img1" class="img-circle" src="/Images/tejakiran.jpg">
                        </div>
                        <div  class="col-md-6" >
                            <br>
                                <p style="font-size:24px;color:green">Teja Kiran Reddy Sirivella </p><br>
                                <p style="font-size:16 px">Final-year Computer Science undergraduate student at Jawaharlal Nehru Technological University Hyderabad.
                                Currently interning at Aurora e-Labs. Passionate about Spring and other frameworks.</p>
                                <br><br>
                                <a type="button" style="font-size:40px;color:#3b5998 " href="https://www.facebook.com/tejakiran.reddysirivella" class="fa fa-facebook-official"></a>
                                <a type="button" style="font-size:40px;color:#24292e; margin-left:40px;" href="https://github.com/tejakiran123" class="fa fa-github"></a>
                                <a type="button" style="font-size:40px;color:#0177b5; margin-left:40px;" href="https://www.linkedin.com/in/tejakiran-reddy-78196210b/" class="fa fa-linkedin-square"></a>
                        </div>
                    </div>
                </div>
                <br><br>

                <div    id="contributorDetails2">
                    <div class="row" style="padding: 5px">
                        <div  class="col-md-6" >
                                <img class="img-circle" src="/Images/rakesh.jpg">
                        </div>
                        <div  class="col-md-6" >
                            <br>
                                <p style="font-size:24px;color:green">Rakesh Nukapeyyi </p><br>

                                <p style="font-size:16 px">A B.Tech student[2013-17] of Computer Science & Engg at Jawaharlal Nehru Technological University Hyderabad.
                                Passionate about data structures and algorithms.</p>

                                <br><br>
                                <a type="button" style="font-size:40px;color:#3b5998" href="https://www.facebook.com/Rakesh882" class="fa fa-facebook-official"></a>
                                <a type="button" style="font-size:40px;color:#24292e; margin-left:40px;" href="https://github.com/Rakesh882" class="fa fa-github"></a>
                                <a type="button" style="font-size:40px;color:#0177b5; margin-left:40px;" href="https://www.linkedin.com/in/rakesh882/" class="fa fa-linkedin-square"></a>
                        </div>
                    </div>
                </div>
                
                <div    id="contributorDetails3">
                    <div class="row" style="padding: 5px">
                        <div  class="col-md-6" >
                                <img class="img-circle" src="/Images/aditya.jpg">
                        </div>
                        <div  class="col-md-6" >
                            <br>
                                <p style="font-size:24px;color:green">Aditya Ch </p><br>
                                <p style="font-size:16 px">Final-year Computer Science Undergraduate student at Jawaharlal Nehru Technological University Hyderabad.
                                Currently interning at VMware. Strong areas include Data Structures and Algorithms.</p>
                                <br><br>
                                <a type="button" style="font-size:40px;color:#3b5998 " href="https://www.facebook.com/adi96coder" class="fa fa-facebook-official"></a>
                                <a type="button" style="font-size:40px;color:#24292e; margin-left:40px;" href="https://github.com/aditya-code-blooded" class="fa fa-github"></a>
                                <a type="button" style="font-size:40px;color:#0177b5; margin-left:40px;" href="https://www.linkedin.com/in/adi96coder" class="fa fa-linkedin-square"></a>
                        </div>
                    </div>
                </div>

                <br><br><br><br><br>
        </div>
        
        <!--  End of contributor list -->
        
        <!--  Back to top button to scroll to Top -->
        
        <div class="backtotop">
             <a  href="/home">Back to top</a><br><br>
        </div>
        
        <!--  End of button  -->
         <br><br><br><br><br>
    </body>
</html>




