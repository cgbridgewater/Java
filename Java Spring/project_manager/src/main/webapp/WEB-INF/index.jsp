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
   			<!-- Nav Bar  -->
			<div class="nav">
				<div>
	   				<h1>Welcome To The Project Board</h1>
				</div>
			</div>   
			<!-- Page Container  -->
	   		<div class="container">
	   			<h1>A task board created to keep <br> development on track!</h1>
	   			<div>
	   				<h3>Save a meeting, post it, track it, get it done!</h3>
	   				<h4>Now, Let's get to work!</h4>
	   				<div class="flex">
		   				<h6>Click Here to <a href="/login">Login!</a></h6>
		   				<h6>Click Here to <a href="/register">Register!</a></h6>
	   				</div>
	   			</div>
 			</div>
</body>
</html>