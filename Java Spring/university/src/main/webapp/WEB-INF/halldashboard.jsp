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
  			<div class="link">
		   		<h3><a href="/logout">Logout</a></h3>
		   		<h3><a href="/dashboard">Dashboard</a></h3>   		
		   		<h3><a href="/hall/new">Add a Hall</a></h3>   				
	   		</div>
   		</div>
   		   		
   		
		<div class="header">
   			<h1>All Halls</h1>
   		</div>
   		
		<!-- Table Display SECTION -->
		<div class="tableContainer">
			<table id="displayTable"  class="table .table-hover">
				<thead>
					<tr class="bg-primary">
						<th scope="col">ID</th>
						<th scope="col">Name</th>
						<th scope="col">University</th>
						<th scope="col">Added By</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody>
				<!-- Loop to iterate expense list -->
				<c:forEach var="h" items="${allHalls}">
					<tr>
						<td>${h.id} </td>
						<td><a href="/hall/${h.id}/view"> ${h.name}</a> </td>
						<td>${h.school.name}</td>
						<td>${h.userHall.userName}</td>
						<td><a href="/hall/${h.id}/view">View</a> 
							<c:if test="${user.id == h.userHall.id}"> 
								<a href="/hall/${h.id}/edit">|| Edit</a> ||
								<a href="/hall/${h.id}/delete">Delete!</a>
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