<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View <c:out value="${oneBook.title}"/></title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<!-- YOUR own local CSS (MAKE SURE THESE MATCH YOUR FOLDER PATHS!!) -->  
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
	

</head>
<body>


						<div class="bookWrapper">
					<!--  		<p>Book ID:<c:out value="${oneBook.id}" /></p> -->
							<p>Author: <c:out value="${oneBook.author}" /></p>
							<p>Title: <c:out value="${oneBook.title}" /></p>
							<p>Description: <c:out value="${oneBook.description}" /></p>
							<p>Language: <c:out value="${oneBook.language}" /></p>
						</div>
						<div class="buttonbox">
							<a href="/"><button class="addBook">Cancel</button></a>
						</div>



</body>
</html>