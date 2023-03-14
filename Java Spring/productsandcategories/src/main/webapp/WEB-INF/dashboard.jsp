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
    <title>Home Page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/CSS/style2.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/JS/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   
   		<div class="nav">
	   		<h1> Hello, <c:out value="${user.userName}"/> </h1>
	   		<h3><a href="/logout">Logout</a></h3>
   		</div>
   		
   		<div class="title">
   			<h1>HomePage</h1>
   		</div>
   		
 		<!-- Links to Create New -->
 		<div class="newLinks">
	   		<h2><a href="/product/new">Add Product</a></h2>
	   		<h2><a href="/category/new">Add Category</a></h2>
 		</div>
   		<!-- ... -->
   		
   		<hr/>
   		
   		<div class="displayContainer">
   		
	   		<!-- Product list display -->
	   		<div class="displayLeft">
				<h3>Products</h3>
				<ul>
					<c:forEach var="product" items="${products}">
						<li>
							<a href="/product/${product.id}"><c:out value="${product.name}" /></a>
						</li>
					</c:forEach>
				</ul>
	   		</div>
	   		<!-- ... -->

	   		<!-- Category list display -->
	   		<div class="displayRight">
				<h3>Categories</h3>
				<ul>
					<c:forEach var="category" items="${categories}">
						<li>
							<a href="/category/${category.id}"><c:out value="${category.name}" /></a>
						</li>
					</c:forEach>
				</ul>
	   		</div>
	   		<!-- ... -->
   		
   		</div>
   		   
</body>
</html>