<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/CSS/loginReg.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/JS/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   			<!-- Nav Bar  -->
			<div class="nav">
				<div>
	   				<h1>Welcome To The Project Board</h1>
				</div>
			</div>   
			<!-- Page Container  -->
	   		<div class="container">
	   			<!-- Form Container  -->
   			    <div class="formContainer">
			        <!-- FORM REGISTER SECTION -->
			        <form:form action="/register" method="POST" modelAttribute="user">
			        	<h2>Registration:</h2>
			            <!-- FORM USER Name SECTION -->
			            <div class="sectionOne">
			                <div class="formation">
			                    <form:label path="userName"> User Name:  </form:label>	
				                <div class="errorFlex">
				                    <form:input path="userName" class="input"/>
				                    <form:errors path="userName" class="errors"/>
				                </div>
			                </div>
			            </div>
			            <div class="sectionTwo">
			            <!-- ...  -->
			            <!-- FORM EMAIL SECTION -->
			                <div class="formation">
			                    <form:label path="email"> Email: </form:label>	
				                <div class="errorFlex">
				                    <form:input path="email" class="input" />
				                    <form:errors path="email" class="errors"/>
				                </div>
			                </div>
			            </div>
			            <div class="sectionThree">
        			    <!-- ...  -->
			            <!-- FORM PASSWORD SECTION -->
			                <div class="formation">
			                    <form:label path="password"> Password: </form:label>	
				                <div class="errorFlex">
				                    <form:input path="password" type="password" class="input" />
				                    <form:errors path="password" class="errors"/>
				                </div>
			                </div>
			            </div>
			            <!-- ...  -->
			            <!-- FORM CONF PW SECTION -->
			            <div class="sectionFour">
			                <div class="formation">
			                    <form:label path="confirmPass"> Confirm Password: </form:label>	
				                <div class="errorFlex">
			                    	<form:input path="confirmPass" type="password" class="input" />
			                    	<form:errors path="confirmPass" class="errors"/>
			                	</div>
			                </div>
			            </div>
			        	 <!-- ...  -->
			        
			        	 <!-- FORM BUTTON -->
			            <div class="buttonContainer">		 		
			                <button class="button" type="submit">Register</button>
			            </div>
			        </form:form>
       		        <!-- END FORM SECTION -->
			        <div class="signIn">
			        	<p>Already Signed Up? <a href="/login">Login Here!</a></p>
			        </div>
			    </div>
		        <!-- END REGISTRATION SECTION -->
 			</div>
</body>
</html>