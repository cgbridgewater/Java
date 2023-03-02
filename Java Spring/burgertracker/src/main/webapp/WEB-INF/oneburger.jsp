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
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   
   
   <div class="wrapper">
   		<div class="imgBox">
		     <img src="https://live.staticflickr.com/65535/52720934959_7fce902559.jpg"
		     alt="Whelp Logo"/>
   		</div>
  	   <div class="oneWrapper">
   
   			<h1><c:out value="${oneBurger.burgerName}"/> Review</h1>
			<br/>
			<h3>Restaurant Name: <c:out value="${oneBurger.restName}"/></h3>
			<h3>Rating (Out of 5):
				<c:forEach var = "i" begin = "1" end = "${oneBurger.rating}">  
					<c:out value="⭐"/>
			     </c:forEach>
			</h3>
			<h3>Notes: </h3>
			<div class="notes">
				<p><c:out value="${oneBurger.notes}"/></p>
			</div>
  
  		

   	
   	
	   </div>
   					<div class="homeBtnBox">
						<a href="/burger"><button class="home">Home</button></a>
					</div>
   </div>
   
</body>
</html>