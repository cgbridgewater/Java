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
    <title>New Category</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/CSS/style3.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/JS/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   
		 <div class="nav">
	   		<h1> Hello, <c:out value="${user.userName}"/> </h1>
  		   	<div class="flex">
		   		<h3><a href="/logout">Logout</a></h3>
		   		<h3><a href="/dashboard">Home</a></h3>
	   		</div>
   		</div>
   		
   		<div class="title">
   			<h1>New Category</h1>
   		</div>
   		
   		    
    <div class="formContainer">
        <!-- FORM INPUT SECTION -->
        <form:form action="/category/new" method="POST" modelAttribute="category">
        
            <div class="sectionOne">
                <div class="formation">
                    <form:label path="name"> Name: </form:label>	
                    <form:input path="name" class="input" />
                </div>
                <div class="errors">
                    <form:errors path="name" class="errors"/>
                </div>
            </div>
        
            <div class="buttonContainer">		 		
                <button class="button" type="submit">Submit</button>
            </div>
        
        </form:form>

        <!-- END FORM INPUT SECTION -->
    </div>
   		
   		
   
</body>
</html>