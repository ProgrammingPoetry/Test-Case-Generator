$(document).ready(
    function(){
        $("#numberArray").css('background', '#26a655');  $("#numberArray p").css('color', 'white');
        $("#numberArrayLink").click(function (e) {
            e.preventDefault();
            $("#numberArrayForm").slideDown();
			$("#characterArrayForm,#stringArrayForm").hide();
            $("#numberArray").css('background', '#26a655');  $("#numberArray p").css('color', 'white');
            $("#characterArray,#stringArray").css('background', 'white');  $("#characterArray p,#stringArray p").css('color', '#26a655');
        });
		 $("#characterArrayLink").click(function (e) {
            e.preventDefault();
			$("#numberArrayForm,#stringArrayForm").hide();
		    $("#characterArrayForm").slideDown();
            $("#characterArray").css('background', '#26a655');$("#characterArray p").css('color', 'white');
            $("#numberArray,#stringArray").css('background', 'white');  $("#numberArray p,#stringArray p").css('color', '#26a655');
        });
		 $("#stringArrayLink").click(function (e) {
             e.preventDefault();
			 $("#numberArrayForm,#characterArrayForm").hide();
             $("#stringArrayForm").slideDown();
             $("#stringArray").css('background', '#26a655'); $("#stringArray p").css('color', 'white');
             $("#numberArray,#characterArray").css('background', 'white');  $("#numberArray p,#characterArray p").css('color', '#26a655');
        });
    });