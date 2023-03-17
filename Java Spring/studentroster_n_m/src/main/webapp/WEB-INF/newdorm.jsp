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
    <link rel="stylesheet" href="/CSS/style2.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/JS/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   
    <div class="nav">
	 	<h1>New Dorm</h1>
	   	<h3><a href="/dorms">Dashboard</a></h3>
   </div>
    <div class="formContainer">
        <!-- FORM INPUT SECTION -->
        <form:form action="/dorms/create" method="POST" modelAttribute="newDorm">
        
            <div class="sectionOne">
                <div class="formation">
                    <form:label path="dormName"> Dorm Name:  </form:label>	
                    <form:input path="dormName" type="" class="input" />
                </div>
                <div class="errors">
                    <form:errors path="dormName" class="errors"/>
                </div>
            </div>
        
            <div class="buttonContainer">		 		
                <button class="button" type="submit">Add</button>
            </div>
        
        </form:form>

        <!-- END FORM INPUT SECTION -->
    </div>

   
</body>
</html>