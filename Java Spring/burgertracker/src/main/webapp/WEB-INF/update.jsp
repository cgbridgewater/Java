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
    <link rel="stylesheet" href="/CSS/style3.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>

		<div class="wrapper">
		   	<div class="imgBox">
			     <img src="https://live.staticflickr.com/65535/52720934959_7fce902559.jpg"
			     alt="Whelp Logo"/>
    		</div>
		
			<div class="formWrapper">
			<h2>Update ${oneBurger.burgerName} Review</h2>
			<form:form action="/burger/${oneBurger.id}/update" method="POST" modelAttribute="oneBurger">
				<input class="input" type="hidden" name="_method" value="PUT">
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

			 	<div class="btnBox">		 		
				 	<button class="button" type="submit">Update Review!</button>
			 	</div>
			</form:form>
		</div>
 				<div class="homeBtnBox">
					<a href="/burger"><button class="home">Home</button></a>
				</div>
		
		</div>

</body>
</html>