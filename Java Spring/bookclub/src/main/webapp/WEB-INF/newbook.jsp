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
   
   
   		<div class="nav">
	   		<div class="navLeft">
				<h3>Add a book to your shelf</h3>
	   		</div>
	   		<div class="navRight">
		   		<h3><a href="/logout">Logout</a></h3>
		   		<h3><a href="/dashboard">back to the shelves</a></h3>
	   		</div>
   		</div>
   		
   
   
    <div class="formContainer">
        <!-- FORM INPUT SECTION -->
        <form:form action="/books/new" method="POST" modelAttribute="newBook">
        	<form:input type="hidden" path="user" value="${user.id}" />
            <div class="sectionOne">
                <div class="formation">
                    <form:label path="title"> Title: </form:label>	
                    <form:input path="title" type="text" class="input" />
                </div>
                <div class="errors">
                    <form:errors path="title" class="errors"/>
                </div>
            </div>
        
            <div class="sectiontwo">
                <div class="formation">
                    <form:label path="author"> Author Name: </form:label>	
                    <form:input path="author" type="text" class="input" />
                </div>
                <div class="errors">
                    <form:errors path="author" class="errors"/>
                </div>
            </div>
        
            <div class="sectionThree">
                <div class="formation">
                    <form:label path="thoughts"> My Thoughts: </form:label>	
                    <form:textarea path="thoughts" type="text" class="input" rows="3" />
                </div>
                <div class="errors">
                    <form:errors path="thoughts" class="errors"/>
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