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
    <title>DASHBOARD</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/CSS/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/JS/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   
   	<div class="navbar">
   		<h1><a href="/songs/new">Add New Song</a></h1>
   		<h1><a href="/songs/top10">Top Songs</a></h1>
		<div>
	        <!-- FORM INPUT SECTION -->
	        <form action="search" method="POST">
	        	<input class="searchArtist" name="artist" placeholder="Search Artist"/>
	        	<button class="searchbutton" type="submit">Search</button>
	        </form>
	        
	        
	        

	
	        <!-- END FORM INPUT SECTION -->
    	</div>
   	</div>
   		

		<!-- Table Display SECTION -->
		<div class="tableContainer">
			<table id="displayTable"  class="table .table-hover">
				<thead>
					<tr class="bg-primary">
						<th scope="col">Song Name</th>
						<th scope="col">Rating (1-10)</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody>
				<!-- Loop to iterate expense list -->
				<c:forEach var="item" items="${allItems}">
					<tr>
						<td><a href="/songs/${item.id}">${item.title}</a> </td>
						<td>${item.rating}</td>
						<td>
				      		<a href="/songs/${item.id}/update">Edit</a>
				      		|| 
				      		<a href="/songs/${item.id}/delete">Delete</a>
						</td>
					</tr>
				</c:forEach>
				<!-- END Loop to iterate expense list -->
				</tbody>
			</table>
            <!-- END Table Display SECTION -->
		</div>
   
</body>
</html>