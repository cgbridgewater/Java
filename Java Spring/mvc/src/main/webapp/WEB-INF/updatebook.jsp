<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
			<h1>Update ${book.title}</h1>
			<form:form action="/books/update/${book.id}" method="POST"   modelAttribute="book">
				<input class="input" type="hidden" name="_method" value="PUT">

				<div class="title">
					<form:label path="title">Book Title</form:label>
					<form:input path="title" class="input" type="text" name="title" value="${book.title}"/>
					<form:errors class="errors"  path="title"/>
				</div>
				<br/>

				<div class="desc">
					<form:label path="description">Description</form:label>
					<form:input  path="description" class="input"  type="text" name="description" value="${book.description}"/>
					<form:errors class="errors"  path="description"/>
				</div>
				<br/>

				<div class="lang">
					<form:label path="language">Language:</form:label>
					<form:input path="language" class="input"  type="text" name="language" value="${book.language}"/>
					<form:errors class="errors"  path="language"/>
				</div>
				<br/>

				<div class="numberOfPages">
					<form:label path="numberOfPages">Number of Pages: </form:label>
					<form:input path="numberOfPages" class="input"  type="number" step="1" min="0" name="numberOfPages" value="${book.numberOfPages}"/>		
					<form:errors class="errors"  path="numberOfPages"/>
				</div>
				<br/>

				<div class="author">
					<form:label path="author">Author: </form:label>
					<form:input path="author" class="input"  type="text" name="author" value="${book.author}"/>	
					<form:errors class="errors"  path="author"/>	
				</div>
				<br/>

			 	<div class="buttonContainer">		 		
				 	<button class="button" type="submit">Update Book!</button>
			 	</div>
			</form:form>
		</div>
		<div class="buttonbox">
			<a href="/"><button class="addBook">Cancel</button></a>
		</div>


</body>
</html>