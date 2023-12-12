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
						 <!-- ...  -->
						 <!-- FORM PASSWORD SECTION -->
			            <div class="sectionTwo">
			                <div class="formation">
			                    <form:label path="password"> Password: </form:label>	
				                <div class="errorFlex">
				                    <form:input path="password" type="password" class="input"/>
			                	</div>
			                </div>
			            </div>
			        	 <!-- ... -->
			        	 <!-- FORM BUTTON -->
			            <div class="buttonContainer">		 		
			                <button class="button" type="submit">Login</button>
			            </div>
			        </form:form>
			        <!-- END FORM LOGIN SECTION -->
      		        <div class="signIn">
			        	<p>Need To Sign Up? <a href="/register">Register Here!</a></p>
			        </div>
			    </div>
 			</div>
</body>
</html>