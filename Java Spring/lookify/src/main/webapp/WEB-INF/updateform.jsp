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
    <link rel="stylesheet" href="/CSS/style4.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/JS/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   
   		
    <div class="formContainer">
		<h1>Update ${oneItem.title } </h1>
        <!-- FORM INPUT SECTION -->
        <form:form action="/songs/${item.id}/update" method="POST" modelAttribute="item">
                <input class="input" type="hidden" name="_method" value="PUT">
            <!-- section ONE -->
            <div class="sectionOne">
                <div class="formation">
                    <form:label path="title">Title:</form:label>
                    <form:input path="title" class="input" type="text" name="title"/>
                </div>
                <div class="errors">
                    <form:errors class="errors" path="title"/>
                </div>
            </div>
        
                <!-- section TWO -->
            <div class="sectionTwo">
                <div class="formation">
                    <form:label path="artist">Artist:</form:label>	
                    <form:input path="artist" class="input" type="text" name="artist"/>
                </div>
                <div class="errors">
                    <form:errors class="errors"  path="artist"/>
                </div>
            </div>

                <!-- section THREE -->
            <div class="sectionThree">
                <div class="formation">
                    <form:label path="rating">Rating:</form:label>	
                    <form:input path="rating" class="input" type="number" step="0.01" name="rating"/>
                </div>
                <div class="errors">
                    <form:errors class="errors"  path="rating"/>
                </div>
            </div>


        
        <div class="buttonContainer">		 		
            <button class="button" type="submit">Submit</button>
        </div>
        
        </form:form>
    </div>
     	
     	<div class="buttonContainer">
	     	<h4><a href="/dashboard">dashboard</a></h4>
     	</div>
     	
     	
     	
     	
</body>
</html>