<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login To The Project Board!</title>
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
	    <!-- LOGIN CONTAINER -->
	    <div class="formContainer">
	        <!-- LOGIN FORM SECTION -->
	        <form:form action="/login" method="POST" modelAttribute="loginUser">
	       		<h2>Login Here:</h2>
	        	 <!-- FORM EMAIL SECTION -->
	            <div class="sectionOne">
	                <div class="formation">
	                    <form:label path="email"> Email: </form:label>				                    
		                <div class="errorFlex">
		                    <form:input path="email" class="input" autofocus="true"/>
		                    <form:errors path="email" class="errors"/>			                   	 	
		                </div>
	                </div>
	            </div>
				 <!-- END FORM EMAIL SECTION  -->
				 <!-- FORM PASSWORD SECTION -->
	            <div class="sectionTwo">
	                <div class="formation">
	                    <form:label path="password"> Password: </form:label>	
		                <div class="errorFlex">
		                    <form:input path="password" type="password" class="input"/>
	                	</div>
	                </div>
	            </div>
	        	 <!-- END FORM PASSWORD SECTION -->
	        	 <!-- FORM BUTTON -->
	            <div class="buttonContainer">		 		
	                <button class="button" type="submit">Login</button>
	            </div>
	            <!-- END FORM BUTTON -->
	        </form:form>
	        <!-- END FORM LOGIN SECTION -->
	        <!-- SIGNUP LINK -->
 		    <div class="signIn">
	        	<p>Need To Sign Up? <a href="/register">Register Here!</a></p>
	        </div>
	        <!-- END SIGNUP LINK -->
	    </div>
    	<!-- END LOGIN CONTAINER  -->
	</div>
	<!-- END PAGE CONTAINER  -->	
</body>
</html>