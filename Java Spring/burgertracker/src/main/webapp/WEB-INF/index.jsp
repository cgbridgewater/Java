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
    <title>Whelp!</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   
   
   <div class="wrapper">
     <img src="https://live.staticflickr.com/65535/52720934959_7fce902559.jpg"
     alt="Whelp Logo"/>
     <div class="headTag">
       <h1>Whelp - Burger Reviews</h1>
     </div>
  		
  		<div class="tableContainer">
			<table class="table table-hover border- border-danger">
			  <thead>
			    <tr>
		
			      <th scope="col">Burger Name</th>
			      <th scope="col">Restaurant Name</th>
			      <th scope="col">Rating (out of 5)</th>
			      <th scope="col">Action</th>
			    </tr>
			  </thead>
			  <tbody>
				<!-- for loop to iterate list -->
				<c:forEach var="burger" items="${allBurgers}">
			    <tr>
			      <td ><a href="/burger/${burger.id}"><c:out value="${burger.burgerName}" /></a></td>
			      <td><c:out value="${burger.restName}" /></td>
			      <td><c:out value="${burger.rating}" /></td>
			      <td>
					<div class="action">
						<a href="/burger/${burger.id}/edit"><button class="edit">Edit</button></a>						
						<a href="/burger/${burger.id}/delete"><button class="delete">Delete</button></a>
					</div>
				</td>
			    </tr>
				</c:forEach>
				<!-- end for loop to iterate list -->
			  </tbody>
			</table>
   		</div>
	
		<div>
			<div class="formWrapper">
			<h2>Review A Burger!</h2>
			<form:form action="/burger/add" method="POST" modelAttribute="burger">

				<div class="burgerName">
					<div class="formation">
						<form:label path="burgerName">Burger Name:</form:label>
						<form:input path="burgerName" class="input" type="text" name="burgerName"/>
					</div>
					<form:errors class="errors"  path="burgerName"/>
				</div>
				<br/>

				<div class="restName">
					<div class="formation">
						<form:label path="restName">Restaurant Name:</form:label>
						<form:input  path="restName" class="input"  type="text" name="restName"/>
					</div>
					<form:errors class="errors"  path="restName"/>
				</div>
				<br/>

				<div class="rating">
					<div class="formation">					
						<form:label path="rating">Rating: </form:label>
						<form:input path="rating" class="input"  type="number" step="1" name="rating"/>		
					</div>
					<form:errors class="errors"  path="rating"/>
				</div>
				<br/>

				<div class="notes">
					<div class="formation">
						<form:label path="notes">Notes: </form:label>
						<form:input path="notes" class="input"  type="text" name="notes"/>	
					</div>
					<form:errors class="errors"  path="notes"/>	
				</div>
				<br/>

			 	<div class="buttonContainer">		 		
				 	<button class="button" type="submit">Add Review!</button>
			 	</div>
			</form:form>
		</div>
		
		
		</div>












   </div>
   
   
   
   
   	
   
   
</body>
</html>