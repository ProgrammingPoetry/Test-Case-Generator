$(document).ready(
    function(){
        $("#fibonacciSeries").css('background', '#26a655');  $("#fibonacciSeries p").css('color', 'white');
        $("#fibonacciSeriesLink").click(function (e) {
            e.preventDefault();
            $("#fibonacciSeriesForm").slideDown();
			$("#binarySearchTreeForm,#balancedBSTForm").hide();
            $("#fibonacciSeries").css('background', '#26a655');  $("#fibonacciSeries p").css('color', 'white');
            $("#binarySearchTree,#string").css('background', 'white');  $("#binarySearchTree p,#string p").css('color', '#26a655');
        });
		 $("#binarySearchTreeLink").click(function (e) {
            e.preventDefault();
			$("#fibonacciSeriesForm,#balancedBSTForm").hide();
		    $("#binarySearchTreeForm").slideDown();
            $("#binarySearchTree").css('background', '#26a655');$("#binarySearchTree p").css('color', 'white');
            $("#fibonacciSeries,#balancedBST").css('background', 'white');  $("#fibonacciSeries p,#balancedBST p").css('color', '#26a655');
        });
		 $("#balancedBSTLink").click(function (e) {
             e.preventDefault();
			 $("#fibonacciSeriesForm,#binarySearchTreeForm").hide();
             $("#balancedBSTForm").slideDown();
             $("#balancedBST").css('background', '#26a655'); $("#balancedBST p").css('color', 'white');
             $("#fibonacciSeries,#binarySearchTree").css('background', 'white');  $("#fibonacciSeries p,#binarySearchTree p").css('color', '#26a655');
        });
    });