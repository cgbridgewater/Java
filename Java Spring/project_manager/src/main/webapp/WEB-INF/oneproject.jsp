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
 		<div class="buttonContainer">
   			<h1>${project.title} Details</h1>
   			<h4><a href="/dashboard">Back To Dashboard!</a></h4>
		</div>



    <div class="viewOneContainer">
        
        <div class="flexControl">
        <h3>Project Name: </h3>
        <h3 class="rightSide">${project.title}</h3>
        </div>
        
        
        <div class="flexControl">
        <h3>Description: </h3>
        <h3 class="rightSide">${project.description}</h3>
        </div>
        
        
        <div class="flexControl">
        <h3>  Due Date: </h3>
        <h3 class="rightSide">${project.date}</h3>
        </div>
        

    </div>
    <div class="buttonContainer">	
    	<h4><a href="/projects/${project.id}/tasks">See Tasks!</a></h4>
    	<c:if test="${user.id == project.lead.id}">
        <a href="/projects/${project.id}/delete"><button class="button" type="submit">Delete!</button></a>	
        </c:if> 		
    </div>


   
</body>
</html>