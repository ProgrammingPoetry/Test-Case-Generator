<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/css/styles.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/matrix.js"></script>
</head>
<body>
	<!-- Header Section-->
	<header class="container-fluid text-center">
		<h1>Matrix</h1>
	</header>
	<!-- sliding form when button is clicked-->
	<div class="accordion" id="myAccordion">
		<div class="panel">
			<button type="button" class="btn btn-primary btn-xl"
				data-toggle="collapse" data-target="#MatrixOfNumbers"
				data-parent="#myAccordion">Matrix of Numbers</button>
			<div id="MatrixOfNumbers" class="collapse" class="container">
				<!--Matrix of  Numbers Form-->
				<div class="center-block"
					style="width: 375px; background: lightgreen; border-radius: 10px; padding: 10px; margin-top: 45px;">
					<h2>Matrix of Numbers</h2>
					<form:form modelAttribute="matrixOfNumbersForm"
						id="matrixOfNumbersForm">
						<div class="form-group" name="div1">
							<form:label path="" for="number">Test cases</form:label>
							<form:input path="noOfTestCases" type="number"
								class="form-control" name="noOfTestCases" />
							<form:errors path="noOfTestCases"></form:errors>
						</div>
						<!-- Form Fields are placed in a row-->
						<div class="form-group">
							<div class="row">
								<div class="col-xs-6">
									<form:label path="" for="number">Rows</form:label>
									<form:input path="rows" type="number" class="form-control"
										name="rows" />
									<form:errors path="rows"></form:errors>
								</div>
								<div class="col-xs-6">
									<form:label path="" for="number">Columns</form:label>
									<form:input path="columns" type="number" class="form-control"
										name="columns" />
									<form:errors path="columns"></form:errors>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-xs-6">
									<form:label path="" for="number">Min Value</form:label>
									<form:input path="minValue" type="number" class="form-control"
										name="minValue" />
									<form:errors path="minValue"></form:errors>
								</div>
								<div class="col-xs-6">
									<form:label path="" for="number">Max Value</form:label>
									<form:input path="maxValue" type="number" class="form-control"
										name="maxValue" />
									<form:errors path="maxValue"></form:errors>
								</div>
							</div>
						</div>
						<!-- div ends here-->
						<div class="form-group">
							<form:label path="" for="number">Multipleof</form:label>
							<form:input path="multipleOf" type="number" class="form-control"
								name="multipleOf" />
							<form:errors path="multipleOf"></form:errors>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-xs-6">
									<form:label path="" for="boolean">Prime:</form:label>
									<form:checkbox path="isPrime" />
									<form:errors path="isPrime" />
								</div>
								<div class="col-xs-6">
									<form:label path="" for="boolean">Distinct:</form:label>
									<form:checkbox path="isDistinct" />
									<form:errors path="isDistinct" />
								</div>
							</div>
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>
					</form:form>
				</div>
				<!-- Matrix of Numbers Form ends here-->
			</div>


			<button type="button" class="btn btn-primary btn-xl"
				data-toggle="collapse" data-target="#MatrixOfCharacters"
				data-parent="#myAccordion">Matrix of Characters</button>
			<div id="MatrixOfCharacters" class="collapse" class="container">
				<!-- Matrix of Characters Form-->
				<div class="center-block"
					style="width: 375px; background: lightgreen; border-radius: 10px; padding: 10px; margin-top: 45px;">
					<h2>Matrix of Characters</h2>
					<form:form modelAttribute="matrixOfCharactersForm"
						id="matrixOfCharactersForm">
						<div class="form-group">
							<form:label path="" for="number">Test cases</form:label>
							<form:input path="noOfTestCases" type="number"
								class="form-control" name="noOfTestCases" />
							<form:errors path="noOfTestCases"></form:errors>
						</div>
						<!-- Form Fields are placed in a row-->
						<div class="form-group">
							<div class="row">
								<div class="col-xs-6">
									<form:label path="" for="number">Rows</form:label>
									<form:input path="rows" type="number" class="form-control"
										name="rows" />
									<form:errors path="rows"></form:errors>
								</div>
								<div class="col-xs-6">
									<form:label path="" for="number">Columns</form:label>
									<form:input path="columns" type="number" class="form-control"
										name="columns" />
									<form:errors path="columns"></form:errors>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-xs-6">
									<form:label path="" for="number">Min Value</form:label>
									<form:input path="minValue" type="character"
										class="form-control" name="minValue" />
									<form:errors path="minValue"></form:errors>
								</div>
								<div class="col-xs-6">
									<form:label path="" for="number">Max Value</form:label>
									<form:input path="maxValue" type="character"
										class="form-control" name="maxValue" />
									<form:errors path="maxValue"></form:errors>
								</div>
							</div>
						</div>
						<!-- div ends here-->

						<div class="form-group">
							<div class="row">
								<div class="col-xs-6">
									<form:label path="" for="text">Case:</form:label>
									<form:select path="charCase">
										<option selected="selected" value="upper">upper</option>
										<option value="lower">lower</option>
										<option value="mixed">mixed</option>
									</form:select>
									<form:errors path="charCase" />
								</div>
								<div class="col-xs-6">
									<form:label path="" for="boolean">Distinct:</form:label>
									<form:checkbox path="isDistinct" />
									<form:errors path="isDistinct" />
								</div>
							</div>
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>
					</form:form>
				</div>
				<!-- Matrix of Characters form ended-->
			</div>
			<!--  
			<button type="button" class="btn btn-primary btn-xl"
				data-toggle="collapse" data-target="#PathMatrix"
				data-parent="#myAccordion">Path Matrix</button>
			<div id="PathMatrix" class="collapse" class="container">
				
				<div class="center-block"
					style="width: 375px; background: lightgreen; border-radius: 10px; padding: 10px; margin-top: 45px;">
					<h2>Path Matrix</h2>
					<form:form id="pathMatrixForm" modelAttribute="pathMatrixForm">
						<div class="form-group">
							<form:label path="" for="number">Test cases</form:label>
							<form:input path="" type="number" class="form-control"
								name="noOfTestcases"/>
						</div>
						
						<div class="form-group">
							<div class="row">
								<div class="col-xs-6">
									<form:label path="" for="number">Rows</form:label>
									<form:input path="" type="number" class="form-control"
										name="rows"/>
								</div>
								<div class="col-xs-6">
									<form:label path="" for="number">Columns</form:label>
									<form:input path="" type="number" class="form-control"
										name="Columns"/>
								</div>
							</div>
						</div>


						

						<div class="form-group">
							<form:label path="" for="text">Characters to indicate blocked cell</form:label>
							<form:input path="" type="text" class="form-control"
								name="blockedCell"/>
						</div>
						<div class="form-group">
							<form:label path="" for="text">Characters to indicate open cell</form:label>
							<form:input path="" type="text" class="form-control"
								name="openCell"/>
						</div>
						
						<div class="form-group">
							<div class="row">
								<div class="col-xs-4">
									<form:label path="" for="text">Path Start</form:label>
									<select onchange="setDisplay(this,'displayInvisiblePathStart')">
										<option value="random">Random</option>
										<option value="specify" selected>Specify</option>
									</select>
								</div>
								<div id="displayInvisiblePathStart">
									<div class="col-xs-4">
										<form:label path="" for="number">Rows</form:label>
										<form:input path="" type="number" class="form-control"
											name="rows"/>
									</div>
									<div class="col-xs-4">
										<form:label path="" for="number">Columns</form:label>
										<form:input path="" type="number" class="form-control"
											name="Columns"/>
									</div>
								</div>
							</div>
						</div>
						<br>
						
						<div class="form-group">
							<div class="row">
								<div class="col-xs-4">
									<form:label path="" for="text">Path End</form:label>
									<select onchange="setDisplay(this,'displayInvisiblePathEnd')">
										<option value="random">Random</option>
										<option value="specify" selected>Specify</option>
									</select>
								</div>
								<div id="displayInvisiblePathEnd">
									<div class="col-xs-4">
										<form:label path="" for="number">Rows</form:label>
										<form:input path="" type="number" class="form-control"
											name="rows"/>
									</div>
									<div class="col-xs-4">
										<form:label path="" for="number">Columns</form:label>
										<form:input path="" type="number" class="form-control"
											name="Columns"/>
									</div>
								</div>
							</div>
						</div>
						<div class="form-group">
							<form:label path="" for="text">Path Exists</form:label>
							<select>
								<option value="true">True</option>
								<option value="false">False</option>
								<option value="mixed">Mixed</option>
							</select>
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>
					</form:form>
				</div> 
				-->
			<!-- Path Matrix form ended-->
		</div>
	</div>
	<script type="text/javascript">
		var content;
		function download(filename, text) {
			var pom = document.createElement('a');
			pom.setAttribute('href', 'data:text/plain;charset=utf-8,'
					+ encodeURIComponent(text));
			pom.setAttribute('download', filename);

			if (document.createEvent) {
				var event = document.createEvent('MouseEvents');
				event.initEvent('click', true, true);
				pom.dispatchEvent(event);
			} else {
				pom.click();
			}
		}
		$(document).ready(function() {
			$("#matrixOfNumbersForm").submit(function(event) {
				var str = $("#matrixOfNumbersForm").serialize();
				event.preventDefault();
				$.ajax({
					type : 'POST',
					data : str,
					url : "matrix/numbers",
					async : false,
					dataType : 'json',
					success : function(data) {
						content = data;
						console.log(data);
						if (data.status == "Success") {
							var fileData = JSON.stringify(
									data.data).split(",[")
									.join("\r\n").split("[")
									.join("").split("]").join(
											"").split(",")
									.join(" ").split("\"")
									.join("");
							console.log(fileData);
							download('input.txt', fileData);
							alert("success");
						} else {
							alert(data.errors);
						}
					},
					error : function(data) {
						console.log(data);
						console.log(JSON.stringify(data));
					}
				});
			});
			$("#matrixOfCharactersForm").submit(function(event) {
				var str = $("#matrixOfCharactersForm").serialize();
				event.preventDefault();
				$.ajax({
					type : 'POST',
					data : str,
					url : "matrix/characters",
					async : false,
					dataType : 'json',
					success : function(data) {
						content = data;
						console.log(data);
						if (data.status == "Success") {
							var fileData = JSON.stringify(
									data.data).split(",[")
									.join("\r\n").split("[")
									.join("").split("]").join(
											"").split(",")
									.join(" ").split("\"")
									.join("");
							console.log(fileData);
							download('input.txt', fileData);
							alert("success");
						} else {
							alert(data.errors);
						}
					},
					error : function(data) {
						console.log(data);
						console.log(JSON.stringify(data));
					}
				});
			});
		});
	</script>
</body>
</html>
