$(document).ready(
    function(){
        $("#number").css('background', '#26a655');  $("#number p").css('color', 'white');
        $("#numberLink").click(function (e) {
            e.preventDefault();
            $("#numberForm").slideDown();
			$("#characterForm,#stringForm").hide();
            $("#number").css('background', '#26a655');  $("#number p").css('color', 'white');
            $("#character,#string").css('background', 'white');  $("#character p,#string p").css('color', '#26a655');
        });
		 $("#characterLink").click(function (e) {
            e.preventDefault();
			$("#numberForm,#stringForm").hide();
		    $("#characterForm").slideDown();
            $("#character").css('background', '#26a655');$("#character p").css('color', 'white');
            $("#number,#string").css('background', 'white');  $("#number p,#string p").css('color', '#26a655');
        });
		 $("#stringLink").click(function (e) {
             e.preventDefault();
			 $("#numberForm,#characterForm").hide();
             $("#stringForm").slideDown();
             $("#string").css('background', '#26a655'); $("#string p").css('color', 'white');
             $("#number,#character").css('background', 'white');  $("#number p,#character p").css('color', '#26a655');
        });
    });
