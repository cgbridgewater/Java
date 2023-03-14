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
   
   			<div class="nav">
	   		<h1> Hello, <c:out value="${user.userName}"/> </h1>
		   		<div class="flex">
			   		<h3><a href="/logout">Logout</a></h3>
			   		<h3><a href="/dashboard">Home</a></h3>
		   		</div>
   			</div>
   		
	   		<div class="title">
	   			<h1><c:out value="${product.name}"/></h1>
   			</div>
   			<hr/>
   		
   		
   		  <h2>Categories:</h2>
   		  <div class="box">
			   	<c:forEach var="cat"  items="${allCategories}">
			  
			  		<p> <c:out value="${cat.name}"/></p>
	   		
			   </c:forEach>
   	  	  </div>
	 	  
		   <h2>Add Category:</h2> 
	 	  	   	   			<!--- Transfer category Form --->
		   <div class="formContainer">
		        <!-- FORM INPUT SECTION -->
		        <form action="/product/${product.id}/add" method="POST">
	  	              
		    		<!--- Drop down select menu --->
				    <select name="categoryId" id="categoryId">
				        <c:forEach var="cat"  items="${noCategories}">
				            <!--- Each option VALUE is the id of the person --->
				            <option value="${cat.id}" >
				            <!--- This is what shows to the user as the option --->
				                <c:out value="${cat.name}"/>
				            </option>
				        </c:forEach>
				    </select>
						<!--- ... --->
		           	<div class="buttonContainer">		 		
		                <button class="button" type="submit">Add</button>
		            </div>
		        </form>
  			</div>
   			<!--- ...  --->
	   
</body>
</html>