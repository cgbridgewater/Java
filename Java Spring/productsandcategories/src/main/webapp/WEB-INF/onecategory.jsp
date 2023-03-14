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
   			<h1><c:out value="${category.name}"/></h1>
   		</div>
   		<hr/>
   		
   		<div class="box">
	   		<h2>Products:</h2>
			   	<c:forEach var="product"  items="${allProducts}">
			  		 <p><c:out value="${product.name}"/></p>
			   </c:forEach>
   		</div>
	   
	   <br>
	   <hr/>
	   
	   <h2>Add Product:</h2>
    		
    		<!--- Transfer product Form --->
		   <div class="formContainer">
		        <!-- FORM INPUT SECTION -->
		        <form action="/category/${category.id}/add" method="POST">
		        
		    		<!--- Drop down select menu --->
				    <select name="productId" id="productId">
				        <c:forEach var="product"  items="${noProducts}">
				            <!--- Each option VALUE is the id of the person --->
				            <option value="${product.id}" >
				            <!--- This is what shows to the user as the option --->
				                <c:out value="${product.name}"/>
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