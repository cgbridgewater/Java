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
	   		<h1> Create New Hall</h1>
	   		<div>
		   		<h3><a href="/logout">Logout</a></h3>
		   		<h3><a href="/dashboard">Dashboard</a></h3>
	   		</div>
   		</div>
   		
   		
	    <div class="formContainer">
        <!-- FORM INPUT SECTION -->
        <form:form action="/hall/new" method="POST" modelAttribute="hall">
         <form:input path="userHall" type="hidden" class="input" value="${user}" />

        
        
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
                    <form:label path="floors">Floors:</form:label>	
                    <form:input path="floors" type="number" step="1" min="1" class="input" />
                </div>
                <div class="errors">
                    <form:errors path="floors" class="errors"/>
                </div>
            </div>
        
            <div class="section">
                <div class="formation">
                    <form:label path="residential">Is residential: </form:label>	
                    <form:select path="residential">
			   			<form:option value="No">No</form:option>
			   			<form:option value="Yes">Yes</form:option>
			   		</form:select>
                </div>
                <div class="errors">
                    <form:errors path="residential" class="errors"/>
                </div>
            </div>
        
            <div class="section">
                <div class="formation">
                    <form:label path="lecture"> Has Lecture Rooms? </form:label>	
                    <form:select path="lecture">
			   			<form:option value="No">No</form:option>
			   			<form:option value="Yes">Yes</form:option>
			   		</form:select>
                </div>
                <div class="errors">
                    <form:errors path="residential" class="errors"/>
                </div>
            </div>
        
            <div class="section">
                <div class="formation">
                    <label for="school"> University: </label>	
                    <select name="school">
				        <c:forEach var="s" items="${allSchools}" >
				            <!--- Each option VALUE is the id of the person --->
				            <option value="${s.id}" name="school">
				            <!--- This is what shows to the user as the option --->
				                <c:out value="${s.name}"/>

				            </option>
				        </c:forEach>
			   		</select>
                </div>
                <div class="errors">
                    <form:errors path="school" class="errors"/>
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