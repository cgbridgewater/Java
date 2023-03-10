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
    <link rel="stylesheet" href="/CSS/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/JS/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   
   		 	<!-- NAV BAR -->
			<div class="nav"  >
   				<h1> Welcome to the Login!</h1>
			</div>   
 			<!-- NAV BAR -->
		
	   		<div class="container">

			        <!-- FORM REGISTER SECTION -->
   			    <div class="formContainer">
			        <form:form action="/register" method="POST" modelAttribute="user">
			        	<h2>Register Here:</h2>

			            <!-- FORM USER Name SECTION -->
			            <div class="sectionOne">
			                <div class="formation">
			                    <form:label path="userName"> User Name:  </form:label>	
			                    <form:input path="userName" class="input" />
			                </div>
			                <div class="errors">
			                    <form:errors path="userName" class="errors"/>
			                </div>
			            </div>
			            <div class="sectionTwo">
			            <!-- ...  -->

			            <!-- FORM EMAIL SECTION -->
			                <div class="formation">
			                    <form:label path="email"> Email: </form:label>	
			                    <form:input path="email" class="input" />
			                </div>
			                <div class="errors">
			                    <form:errors path="email" class="errors"/>
			                </div>
			            </div>
			            <div class="sectionThree">
        			    <!-- ...  -->

			            <!-- FORM PASSWORD SECTION -->
			                <div class="formation">
			                    <form:label path="password"> Password: </form:label>	
			                    <form:input path="password" type="password" class="input" />
			                </div>
			                <div class="errors">
			                    <form:errors path="password" class="errors"/>
			                </div>
			            </div>
			            <!-- ...  -->

			            <!-- FORM CONF PW SECTION -->
			            <div class="sectionFour">
			                <div class="formation">
			                    <form:label path="confirmPass"> Confirm Password: </form:label>	
			                    <form:input path="confirmPass" type="password" class="input" />
			                </div>
			                <div class="errors">
			                    <form:errors path="confirmPass" class="errors"/>
			                </div>
			            </div>
			        	 <!-- ...  -->
			        
			        	 <!-- FORM BUTTON -->
			            <div class="buttonContainer">		 		
			                <button class="button" type="submit">Register</button>
			            </div>
			        	<!-- ... -->
			        </form:form>
			        <!-- END FORM INPUT SECTION -->
			
			    </div>
   				
   				
   				
			        <!-- FORM LOGIN SECTION -->
   			    <div class="formContainer">
			        <form:form action="/login" method="POST" modelAttribute="loginUser">
			        	<h2>Login Here:</h2>
			        	
			        	 <!-- FORM EMAIL SECTION -->
			            <div class="sectionOne">
			                <div class="formation">
			                    <form:label path="email"> Email: </form:label>	
			                    <form:input path="email" class="input" />
			                </div>
			                <div class="errors">
			                    <form:errors path="email" class="errors"/>
			                </div>
			            </div>
						 <!-- ...  -->
						 
						 <!-- FORM PASSWORD SECTION -->
			            <div class="sectionTwo">
			                <div class="formation">
			                    <form:label path="password"> Password: </form:label>	
			                    <form:input path="password" type="password" class="input" />
			                </div>
			                <div class="errors">
			                    <form:errors path="password" class="errors"/>
			                </div>
			            </div>
			        	 <!-- ... -->
			        
			        	 <!-- FORM BUTTON -->
			            <div class="buttonContainer">		 		
			                <button class="button" type="submit">Login</button>
			            </div>
			        	<!-- ... -->
			        </form:form>			
			    </div>
			        <!-- END FORM LOGIN SECTION -->
   			
   	
   			</div>
   
   
</body>
</html>