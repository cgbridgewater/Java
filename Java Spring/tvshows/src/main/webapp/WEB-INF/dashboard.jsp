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
    <link rel="stylesheet" href="/CSS/dash.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/JS/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   
   		<div class="nav">
	   		<h1> Hello, <c:out value="${user.userName}"/> </h1>
	   		<h3><a href="/logout">Logout</a></h3>
   		</div>
   		   		
   		
   		<div class="link">
	   		<h3><a href="/shows/network/new">Add a network</a></h3>   		
	   		<h3><a href="/shows/new">Add a show</a></h3>   		
   		</div>
   		
		<div class="header">
   			<h1>All TV Shows</h1>
   		</div>
   		
		<!-- Table Display SECTION -->
		<div class="tableContainer">
			<table id="displayTable"  class="table .table-hover">
				<thead>
					<tr class="bg-primary">
						<th scope="col">Show </th>
						<th scope="col">Network </th>
						<th scope="col">Rating </th>
						<th scope="col">Added By </th>
						<th scope="col">Actions </th>
					</tr>
				</thead>
				<tbody>
				<!-- Loop to iterate expense list -->
				<c:forEach var="s" items="${allShows}">
					<tr>
						<td><a href="/shows/${s.id}">${s.title}</a>  </td>
						<td>${s.network.name}</td>
						<td>${s.rating}</td>
						<td>${s.showCreator.userName}</td>
					
 						<c:if test="${s.showCreator.id != user.id}">
							<td>
								<a href="/shows/${s.id}/like">Like</a> || 
								<a href="/shows/${s.id}/watch">Watch</a> 
							</td>
 						</c:if>
					
 						<c:if test="${s.showCreator.id == user.id}">
							<td>
								<a href="/shows/${s.id}/edit">Edit</a> || 
								<a href="/shows/${s.id}/delete">Delete</a> 
							</td>
 						</c:if>
			
					</tr>
				</c:forEach>
				<!-- END Loop to iterate expense list -->
				</tbody>
			</table>
            <!-- END Table Display SECTION -->
		</div>
   	
</body>
</html>