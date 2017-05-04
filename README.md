# TestCaseGenerator
Test Case Generator is a tool which helps in generating test cases for several competitive programming problems. Nowadays the data-set for test cases are being generated manually by the problem setters. This project attempts to automate the generation of test cases and thereby saving time for the problem setter. This is our Final-Year Major-Project.

<h2>Features</h2>
<ul>
  <li>Generate test data for basic data types</li>
  <li>Generate test data for arrays</li>
  <li>Generate test data for matrices</li>
  <li>Generate test data for trees</li>
  <li>Generate test data for graphs</li>
</ul>

<h2>Running the Project</h2>
You can run this project in Spring STS or any other IDE of your choice. This procedure gives a detailed step-by-step guide to start running the project in Spring STS. You can download Spring STS <a href="https://spring.io/tools/sts/all">here</a>.
<ul>
  <li>Open Spring STS and clone this project to your local machine</li>
  <li>Navigate to <i>File > Import > Maven > Existing Maven Project</i>. Now browse to the directory in which you have cloned this repo and select it.</li>
  <li>This application is configured to run on port 5010. Make sure you do not have any application running on port 5010 on your local machine.</li>
  <li>If you would like to change the port on which this application runs, then navigate to the file <i>src/main/resources/application.properties</i> and change the <i>server.port</i> property to the port of your choice.</li>
  <li>In order to run the application, go the file <i>src/main/java/com/jntu/TestCaseGeneratorApplication.java</i> and <i>Right Click > Run As > Java Application</i></li>
  <li>You can access your application at <a href="http://localhost:5010/home">localhost:5010/home</a> (Note: If you have changed the port on which the application runs, then change it here too!)</li>
  <li>Explore the application (Most of it is self explanatory) and start generating the test data for your problems.</li>
If you find any problem deploying the project in your machine, please do let me know.

<h2>Development</h2>
<ul>
  <li>Spring STS has been used to code the entire application</li>
  <li>The back-end is written entirely in Java (Spring-Boot Microservices)</li>
  <li>The front-end is written in basic HTML/CSS and JS too. jQuery and Bootstrap frameworks have also been used</li>
  <li>Almost every file is descriptive in nature. Comments provide in-depth explanation about what's going on</li>
  <li>Good, if not best, coding standards have been followed in developing the project. For instance, constants used in the project have been all accumulated in a single file.</li>
</ul>

<h2>Screenshots</h2>

<h4>Screenshot heading</h4>
<!--<img src="screenshots/login_page.png" />-->

<br/><br/>
Use this, report bugs, raise issues and Have fun. Do whatever you want! I would love to hear your feedback :)

~ Happy Coding
