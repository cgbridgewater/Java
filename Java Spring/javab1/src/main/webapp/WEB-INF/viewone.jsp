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
    <title>View One Page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/CSS/viewone.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/JS/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   
   		<div class="nav">
	   		<h1> Hello, <c:out value="${user.userName}"/> </h1>
 			<div>
		   		<h3><a href="/logout">Logout</a></h3>
		   		<h3><a href="/dashboard">Dashboard</a></h3>
	   		</div>
   		</div>
   		
		
		<h1>${} Details</h1>
		
		    <div class="viewOneContainer">
		        
		        <div class="flexControl">
		        <h3>    : </h3>
		        <h3 class="rightSide">${}</h3>
		        </div>
		        
		        
		        <div class="flexControl">
		        <h3>     : </h3>
		        <h3 class="rightSide">$<fmt:formatNumber type="number" minFractionDigits="2" value="${}"></fmt:formatNumber></h3>
		        </div>
		        
		        
		        <div class="flexControl">
		        <h3>    : </h3>
		        <h3 class="rightSide">${}</h3>
		        </div>
		        
		        
		        <div class="flexControl">
		        <h3>    : </h3>
		        <h3 class="rightSide">${}</h3>
		        </div>
		
		    </div>
		    <div class="buttonContainer">	
		        <a href="/"><button class="button" type="submit">Go Home</button></a>	 		
		    </div>
		
		
</body>
</html>