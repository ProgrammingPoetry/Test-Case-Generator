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
    <script src="/js/misc.js"></script>      
</head>
	<body>
		<!-- Header Section-->
		<header class="container-fluid text-center" >
				<h1>Miscellaneous</h1>
		</header>
		<!--  End of Header section -->
		
		<div class="container">
			<!--  buttons and their respective Forms are arranged in a row -->
			<div class="row">
				<div class="col-xs-2">
					<!-- Buttons for miscellaneous types  -->
					<a   id="fibonacciSeriesLink" href="" >
						<div id="fibonacciSeries">
							<p>Fibonacci Series</p>
						</div>
					</a>
					
					<a id="binarySearchTreeLink" href="" >
						<div id="binarySearchTree">
							<p>Binary Search Tree</p>
						</div>
					</a>
					
					<a id="balancedBSTLink" href=""	>
						<div id="balancedBST">
							<p>Balanced BST</p>
						</div>
					</a>
				</div>
				
				<div class="col-xs-8" style="margin-left:100px">
					<div id="fibonacciSeriesForm"  class="center-block">
						<h2>Fibonacci Series</h2>
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
					
					<!--  Binary search Tree Form -->
					<div id="binarySearchTreeForm" class="center-block" style="display:none;">
	                        <h2>Binary Search Tree</h2>
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
                    <!--  Balanced binary search tree -->
					<div id="balancedBSTForm" class="center-block" style="display:none;">
                        <h2>Balanced BST</h2>
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
				</div>
			</div>
		</div>
	</body>	
</html>