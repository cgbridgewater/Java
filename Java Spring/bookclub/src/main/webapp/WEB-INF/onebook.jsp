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
		<div class="navLeft">
	 		<h1><c:out value="${oneBook.title}"/> </h1>
			
		</div>
		<div class="navRight">
	 		<h3><a href="/logout">Logout</a></h3>
	 		<h3><a href="/dashboard">back to the shelves</a></h3>
		</div>
	</div>
   		
 	<div class="content">
		
					<c:if test="${user.id == oneBook.user.id}"> 
						<td>
        					<h3> You read ${oneBook.title} by ${oneBook.author}</h3>
						       <h5 class="rightSide">Here's your thoughts:</h5>
						</td>
						</c:if>
						<c:if test="${user.id != oneBook.user.id}"> 
						<td>
        					<h3> ${oneBook.user.userName} read  ${oneBook.title} by ${oneBook.author}</h3>
			       			<h5 class="rightSide">Here's ${oneBook.user.userName} thoughts:</h5>
						</td>
						</c:if>
		
		
		
 
		<hr/>    
        <p> ${oneBook.thoughts}</p>
		<hr/>    
		
			<c:if test="${user.id == oneBook.user.id}"> 
				<div class="flexControl">
	     			<h3><a href="/books/${oneBook.id}/update">Update</a></h3>   
	     			<h3><a href="/books/${oneBook.id}/delete">Delete</a></h3>
				</div>
         	</c:if>
        </div>
   		
   
   
</body>
</html>