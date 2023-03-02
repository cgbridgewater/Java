<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MVC Home Page</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<!-- YOUR own local CSS (MAKE SURE THESE MATCH YOUR FOLDER PATHS!!) -->  
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>


</head>
<body>
		
		
		<div>
			<div class="bookWrapper">
				<h1>My DB of Books</h1>
		
				<table>
					<tr>
						<!-- 	<th> Book ID </th>  -->
							<th> Author </th>
							<th> Title</th>
							<th> Description</th>
							<th> Language</th>
							<th> Actions</th>
					</tr>
				
						<c:forEach var="book" items="${allBooks}">
					<tr>
						<!-- 	<td><c:out value="${book.id}" />   -->
							<td><c:out value="${book.author}" />
							<td><a href="/onebook/${book.id}"><c:out value="${book.title}" /></a>
							<td><c:out value="${book.description}" />
							<td><c:out value="${book.language}" />
							<td> 
								<div class="action">
									<a href="/books/edit/${book.id}"><button class="edit">Edit</button></a>
									<a href="/books/${book.id}"><button class="delete">Delete</button></a>
								</div>
							
							
	
							
					</tr>
						</c:forEach>
				</table>
			</div>
			<div class="buttonbox">
				<a class="addBook" href="/add">Add Book</a>
			</div>
		</div>

</body>
</html>