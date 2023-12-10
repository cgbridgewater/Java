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
    <link rel="stylesheet" href="/CSS/styleFORM.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/JS/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   
   	<div class="nav">
    	<h1>Create a project</h1>
   	</div>
  	
    
    <div class="formContainer">
        <!-- FORM INPUT SECTION -->
        <form:form action="/projects/new" method="POST" modelAttribute="project">
			<form:input type="hidden" path="lead" value="${user}"/>
			<form:errors path="lead" class="errors"/>
            <!-- FORM INPUT -->
            <div>
                <div class="formation">
                    <form:label path="title"> Project Title:  </form:label>	
                    <form:input path="title" type="text" class="input" />
                </div>
                <div class="errors">
                    <form:errors path="title" class="errors"/>
                </div>
            </div>
            <!-- FORM INPUT -->        
            <div>
                <div class="formation">
                    <form:label path="description"> Project Description:  </form:label>	
                    <form:textarea path="description" type="text" class="input" />
                </div>
                <div class="errors">
                    <form:errors path="description" class="errors"/>
                </div>
            </div>
            <!-- FORM INPUT -->        
            <div>
                <div class="formation">
                    <form:label path="date"> Due Date: </form:label>	
                    <form:input path="date" type="date" class="input" />
                </div>
                <div class="errors">
                    <form:errors path="date" class="errors"/>
                </div>
            </div>
            <!-- FORM BUTTONS -->
            <div class="buttonContainer">	
            	<h5><a  href="/projects/dashboard">Cancel</a></h5> 		
                <button class="button" type="submit">Submit</button>
            </div>
        	<!-- END FORM INPUT SECTION -->
        </form:form>
        <!-- END FORM SECTION -->
    </div>


   
</body>
</html>