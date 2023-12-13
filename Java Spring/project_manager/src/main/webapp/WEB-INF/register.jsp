<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register For The Project Board</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/CSS/loginReg.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/JS/app.js"></script>
</head>
<body>
 	<!-- NAV BAR  -->
	<div class="nav">
		<div>
  				<h1>Welcome To The Project Board</h1>
		</div>
	</div>
	<!-- END NAV BAR  -->
	<!-- PAGE CONTAINER  -->
 	<div class="container">
 		<!-- FORM CONTAINER  -->
 		<div class="formContainer">
	        <!-- FORM REGISTER SECTION -->
	        <form:form action="/register" method="POST" modelAttribute="user">
	        	<h2>Registration:</h2>
	            <!-- FORM USER NAME SECTION -->
	            <div class="sectionOne">
	                <div class="formation">
	                    <form:label path="userName"> User Name:  </form:label>	
		                <div class="errorFlex">
		                    <form:input path="userName" class="input"/>
		                    <form:errors path="userName" class="errors"/>
		                </div>
	                </div>
	            </div>
	            <!-- END USER NAME SECTION  -->
	            <!-- FORM EMAIL SECTION -->
	            <div class="sectionTwo">
	                <div class="formation">
	                    <form:label path="email"> Email: </form:label>	
		                <div class="errorFlex">
		                    <form:input path="email" class="input" />
		                    <form:errors path="email" class="errors"/>
		                </div>
	                </div>
	            </div>
      			    <!-- END EMAIL SECTION -->
	            <!-- FORM PASSWORD SECTION -->
	            <div class="sectionThree">
	                <div class="formation">
	                    <form:label path="password"> Password: </form:label>	
		                <div class="errorFlex">
		                    <form:input path="password" type="password" class="input"/>
		                    <form:errors path="password" class="errors"/>
		                </div>
	                </div>
	            </div>
	            <!-- END PASSWORD SECTION -->
	            <!-- FORM CONF PW SECTION -->
	            <div class="sectionFour">
	                <div class="formation">
	                    <form:label path="confirmPass"> Confirm Password: </form:label>	
		                <div class="errorFlex">
	                    	<form:input path="confirmPass" type="password" class="input"/>
	                    	<form:errors path="confirmPass" class="errors"/>
	                	</div>
	                </div>
	            </div>
	        	 <!-- END CONF PW SECTION  -->
	        	 <!-- FORM BUTTON -->
	            <div class="buttonContainer">		 		
	                <button class="button" type="submit">Register</button>
	            </div>
	            <!-- END FORM BUTTON  -->
	        </form:form>
     		        <!-- END FORM SECTION -->
     		        <!-- SIGNIN LINK  -->
	        <div class="signIn">
	        	<p>Already Signed Up? <a href="/login">Login Here!</a></p>
	        </div>
	        <!-- END SIGN IN LINK  -->
	    </div>
        <!-- END REGISTRATION SECTION -->
	</div>
	<!-- END PAGE CONTAINER  -->
</body>
</html>