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
    <link rel="stylesheet" href="/CSS/style3.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/JS/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   
   		
	<h1> Create a Driver</h1>
    <div class="formContainer">
        <!-- FORM INPUT SECTION -->
        <form:form action="/person/create" method="POST" modelAttribute="newPerson">
        
            <div class="sectionOne">
                <div class="formation">
                    <form:label path="firstName">First Name: </form:label>	
                    <form:input path="firstName" class="input" type="text" name="firstName"/>
                </div>
                <div class="errors">
                    <form:errors class="firstName"  path="firstName"/>
                </div>
            </div>
            <div class="sectionTwo">
                <div class="formation">
                    <form:label path="lastName">Last Name: </form:label>	
                    <form:input path="lastName" class="input" type="text" name="lastName"/>
                </div>
                <div class="errors">
                    <form:errors class="lastName"  path="lastName"/>
                </div>
            </div>
        
            <div class="buttonContainer">		 		
                <button class="button" type="submit">Submit</button>
            </div>
        
        </form:form>

        <!-- END FORM INPUT SECTION -->
    </div>
	<a id="home" href="/">Go Home</a>
	
		
</body>
</html>