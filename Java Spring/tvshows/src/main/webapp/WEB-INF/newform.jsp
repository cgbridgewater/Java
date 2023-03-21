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
    <link rel="stylesheet" href="/CSS/form.css"> <!-- change to match your file/naming structure -->
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
   		
   

   
       <div class="formContainer">
        <!-- FORM INPUT SECTION -->
       <h1>Add a Show</h1>
       <form:form action="/shows/new" method="POST" modelAttribute="show">
			 <form:input path="showCreator" type="hidden" class="input" value="${user.id}"/>
			  <form:errors path="showCreator" class="errors"/>
        
            <div>
                <div class="formation">
                    <form:label path="title"> Show Title </form:label>	
                    <form:input path="title" class="input" />
                </div>
                <div class="errors">
                    <form:errors path="title" class="errors"/>
                </div>
            </div>
        
        
            <div>
                <div class="formation">
                    <form:label path="rating"> Rating (1-5) </form:label>	
                    <form:input path="rating" type="number" step="1" min="1" class="input" />
                </div>
                <div class="errors">
                    <form:errors path="rating" class="errors"/>
                </div>
            </div>
        
        
            <div>
                <div class="formation">
                    <form:label path="description"> Description </form:label>	
                    <form:input path="description" class="input" />
                </div>
                <div class="errors">
                    <form:errors path="description" class="errors"/>
                </div>
            </div>

                    <!--- Drop down select menu --->
			    <label for="nets"> Network </label>	
			    <form:select path="network">
			        <c:forEach var="n" items="${networks}">
			            <!--- Each option VALUE is the id of the person --->
			            <option value="${n.id}" >
			            <!--- This is what shows to the user as the option --->
			                <c:out value="${n.name}"/>

			            </option>
			        </c:forEach>
			    </form:select>
			<!--- ... --->
         <form:errors path="network" class="errors"/>
   
        
            <div class="buttonContainer">		 		
                <button class="button" type="submit">Add Show</button>
            </div>
        
        </form:form>
        <!-- END FORM INPUT SECTION -->
    </div>

   		   
</body>
</html>