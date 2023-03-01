<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add A Book</title>
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
			<h1>Lets add a book!</h1>
			<form action="/update/{id}" method="POST">

				<div class="title">
					<label>Book Title</label>
					<input class="input" type="text" name="title">
				</div>
				<br/>

				<div class="desc">
					<label>Description</label>
					<input class="input"  type="text" name="desc">
				</div>
				<br/>

				<div class="name">
					<label>Language:</label>
					<input class="input"  type="text" name="lang">
				</div>
				<br/>

				<div class="pages">
					<label>Number of Pages: </label>
					<input class="input"  type="number" step="1" min="0" name="pages">		
				</div>
				<br/>

				<div class="author">
					<label>Author: </label>
					<input class="input"  type="text" name="author">		
				</div>
				<br/>

			 	<div class="buttonContainer">		 		
				 	<button class="button" type="submit">Add Book!</button>
			 	</div>
			</form>
		</div>



</body>
</html>