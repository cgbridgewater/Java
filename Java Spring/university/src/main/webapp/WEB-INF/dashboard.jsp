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
	   		<div>
		   		<h3><a href="/logout">Logout</a></h3>
		   		<h3><a href="/school/new">Add a School</a></h3>   		
		   		<h3><a href="/hall/dashboard">View Halls</a></h3>   		
	   		</div>
   		</div>
   		   		
   		
   		
		<div class="header">
   			<h1>All Universities</h1>
   		</div>
   		
		<!-- Table Display SECTION -->
		<div class="tableContainer">
			<table id="displayTable"  class="table .table-hover">
				<thead>
					<tr class="bg-primary">
						<th scope="col">ID</th>
						<th scope="col">Name</th>
						<th scope="col">City</th>
						<th scope="col">Added By</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody>
				<!-- Loop to iterate expense list -->
				<c:forEach var="s" items="${allSchools}">
					<tr>
						<td>${s.id} </td>
						<td><a href="/school/${s.id}/view"> ${s.name}</a> </td>
						<td>${s.city}</td>
						<td>${s.userSchool.userName}</td>
						<td><a href="/school/${s.id}/view">View</a> 
							<c:if test="${user.id == s.userSchool.id}"> 
								<a href="/school/${s.id}/edit">|| Edit</a> ||
								<a href="/school/${s.id}/delete">Delete!</a>
							</c:if>
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