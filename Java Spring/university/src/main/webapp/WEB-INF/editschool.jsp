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
   


   		<div class="nav">
	   		<h1> Create new school</h1>
	   		<div>
		   		<h3><a href="/logout">Logout</a></h3>
		   		<h3><a href="/dashboard">Dashboard</a></h3>
	   		</div>
   		</div>
   		
   		
	    <div class="formContainer">
        <!-- FORM INPUT SECTION -->
        <form:form action="/school/edit" method="POST" modelAttribute="school">
           <input type="hidden" name="_method" value="PUT">
         <form:input path="userSchool" type="hidden" class="input" value="${user}" />
         <form:input path="id" type="hidden" class="input" value="${updateschool.id}" />
        
        
            <div class="section">
                <div class="formation">
                    <form:label path="city"> City: </form:label>	
                    <form:input path="city" class="input" />
                </div>
                <div class="errors">
                    <form:errors path="city" class="errors"/>
                </div>
            </div>
        
            <div class="section">
                <div class="formation">
                    <form:label path="name"> Name: </form:label>	
                    <form:input path="name" type="" class="input" />
                </div>
                <div class="errors">
                    <form:errors path="name" class="errors"/>
                </div>
            </div>
        
            <div class="section">
                <div class="formation">
                    <form:label path="enrolled">Enrolled:</form:label>	
                    <form:input path="enrolled" type="number" step="1" min="1" class="input" />
                </div>
                <div class="errors">
                    <form:errors path="enrolled" class="errors"/>
                </div>
            </div>
        
            <div class="section">
                <div class="formation">
                    <form:label path="online"> Online Classes: </form:label>	
                    <form:select path="online">
			   			<form:option value="No">No</form:option>
			   			<form:option value="Yes">Yes</form:option>
			   		</form:select>
                </div>
                <div class="errors">
                    <form:errors path="online" class="errors"/>
                </div>
            </div>
        
            <div class="section">
                <div class="formation">
                    <form:label path="inperson"> In Person Classes </form:label>	
                    <form:select path="inperson">
			   			<form:option value="No">No</form:option>
			   			<form:option value="Yes">Yes</form:option>
			   		</form:select>
                </div>
                <div class="errors">
                    <form:errors path="inperson" class="errors"/>
                </div>
            </div>
        
            <div class="section">
                <div class="formation">
                    <form:label path="founded"> Year Founded: </form:label>	
                    <form:input path="founded" type="number" step="1" min="1" class="input" />
                </div>
                <div class="errors">
                    <form:errors path="founded" class="errors"/>
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