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
    <link rel="stylesheet" href="/CSS/viewone.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/JS/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   
   
   
   <h1>"${oneShow.title}" Details</h1>

    <div class="viewOneContainer">
        
        <div class="flexControl">
        <h3>    Title: </h3>
        <h3 class="rightSide">${oneShow.title}</h3>
        </div>
        
        
        <div class="flexControl">
        <h3>    Description : </h3>
        <h3 class="rightSide">${oneShow.description}</h3>
        </div>
        
        
        <div class="flexControl">
        <h3>   Rating (1 out of 5) : </h3>
        <h3 class="rightSide">${oneShow.rating}</h3>
        </div>
        
        

    </div>
    <div class="buttonContainer">	
        <a href="/dashboard"><button class="button" type="submit">Go Home</button></a>	 		
        <a href="/shows/${oneShow.id}/comment"><button class="button" type="submit">Comment on show</button></a>	 			
    </div>
   
   
   
   		   
</body>
</html>