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
    <script type="text/javascript" src="/JS/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   
   
   		<!-- NAV BAR -->
   		<div class="nav">
	   		<div class="navLeft">
		   		<h1> Hello, <c:out value="${user.userName}"/> </h1>
				<h3>Book's from everyones shelves:</h3>
	   		</div>
	   		<div class="navRight">
		   		<h3><a href="/logout">Logout</a></h3>
		   		<h3><a href="/books/new">Add a book to the shelf</a></h3>
	   		</div>
   		</div>
  		<!-- NAV BAR -->
   		
   		
		<!-- Table Display SECTION -->
		<div class="tableContainer">
			<table id="displayTable"  class="table .table-hover">
				<thead>
					<tr class="bg-primary">
						<th scope="col">ID</th>
						<th scope="col">Title</th>
						<th scope="col">Author Name</th>
						<th scope="col">Posted By</th>
					</tr>
				</thead>
				<tbody>
				<!-- Loop to iterate book list -->
				<c:forEach var="book" items="${allBooks}">
					<tr>
						<td>${book.id} </td>
						<td><a href="/books/${book.id}/view">${book.title }</a> </td>
						<td>${book.author}</td>
						<td>${book.user.userName}</td>
					</tr>
				</c:forEach>
				<!-- END Loop to iterate Book list -->
				</tbody>
			</table>
		</div>
            <!-- END Table Display SECTION -->
   		
   		   
</body>
</html>