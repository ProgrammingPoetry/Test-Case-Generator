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
    </script>      
</head>
<body>
    <!-- Header Section-->
    <header class="container-fluid text-center" >
            <h1>Misc</h1>
    </header>
    <!-- sliding form when button is clicked-->
    <div class="accordion" id="myAccordion">
        <div class="panel">
            <button type="button"  class="btn btn-primary btn-xl"   data-toggle="collapse" data-target="#FibonacciSeries" data-parent="#myAccordion">Fibonacci Series</button>
            <div  id="FibonacciSeries" class="collapse" class="container">
                <!-- Fibonacci Series Form-->
                <div class="center-block" style="width:300px; background:lightgreen;border-radius:10px;padding:10px;margin-top:45px;">
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
                    <!-- Fibonacci Series Form ends here-->
                </div>
                <button type="button"   class="btn btn-primary btn-xl"   data-toggle="collapse" data-target="#BinarySearchTree" data-parent="#myAccordion">Binary Search Tree</button>
                <div  id="BinarySearchTree" class="collapse" class="container">
                <!-- Binary Search Tree Form-->
                <div class="center-block" style="width:300px; background:lightgreen;border-radius:10px;padding:10px;margin-top:45px;">
                        <h2> Binary Search Tree</h2>
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
                    <!-- Binary Search Tree form ended-->
            </div>
            <button type="button"   class="btn btn-primary btn-xl"   data-toggle="collapse" data-target="#BalancedBST" data-parent="#myAccordion">Balanced BST</button>
            <div  id="BalancedBST" class="collapse" class="container">
                <!-- BalancedBST Form-->
                <div class="center-block" style="width:300px; background:lightgreen;border-radius:10px;padding:10px;margin-top:45px;">
                        <h2>BalancedBST</h2>
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
                    <!-- BalancedBST form ended-->
            </div>
        </div>
    </div>
</body>
</html>
	