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
    <title>INDEX</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/CSS/style3.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/JS/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   
   <h1>Update an Expense</h1>
   		<div class="formContainer">
   			<!-- FORM INPUT SECTION -->
   			<form:form action="/expense/${oneExpense.id}/update" method="POST" modelAttribute="oneExpense">
   					<input class="input" type="hidden" name="_method" value="PUT">
   				<!-- section ONE -->
   				<div class="sectionOne">
   					<div class="formation">
   						<form:label path="expenseName">expense</form:label>
   						<form:input path="expenseName" class="input" type="text" name="expenseName"/>
   					</div>
   					<div class="errors">
   						<form:errors class="errors" path="expenseName"/>
   					</div>
   				</div>
   			
   					<!-- section TWO -->
   				<div class="sectionTwo">
   					<div class="formation">
   						<form:label path="amount">Amount:</form:label>	
   						<form:input path="amount" class="input" type="number" step="0.01" name="amount"/>
   					</div>
   					<div class="errors">
	   					<form:errors class="errors"  path="amount"/>
   					</div>
   				</div>
   			  				
   					<!-- section THREE -->
   				<div class="sectionThree">
   					<div class="formation">
   						<form:label path="vendor">Vendor:</form:label>	
   						<form:input path="vendor" class="input" type="text" name="vendor"/>
   					</div>
   					<div class="errors">
	   					<form:errors class="errors"  path="vendor"/>
   					</div>
   				</div>

   					<!-- section Four -->
   				<div class="sectionFour">
   					<div class="formation">
   						<form:label path="description">Description:</form:label>	
   						<form:textarea path="description" rows="2" class="input" type="text" name="description"/>
   					</div>
   					<div class="errors">
	   					<form:errors class="errors"  path="description"/>
   					</div>
   				</div>
   				
   			
			 	<div class="buttonContainer">		 		
				 	<button class="button" type="submit">Submit</button>
			 	</div>
   			
   			</form:form>
   		</div>
		<div class="buttonContainer">	
			<a href="/"><button class="button" type="submit">Go Home</button></a>	 		
	 	</div>
</body>
</html>