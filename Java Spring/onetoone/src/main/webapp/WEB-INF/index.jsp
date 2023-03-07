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
    <link rel="stylesheet" href="/CSS/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/JS/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   
   		
	<div class="navi">
		<h1> Springfield DMV </h1>
		<div class="createBox">
			<h3><a id="create" href="/person/new">Create Person</a></h3>
		</div>
	</div>
	<div class="tableContainer">
		<table id="displayTable"  class="table .table-hover">
		<!-- Table Display SECTION -->
			<thead>
				<tr class="bg-primary">
					<th >Name</th>
					<th >License Number</th>
					<th >State</th>
					<th >Exp Date</th>
				</tr>
			</thead>
			<tbody>
			<!-- Loop to iterate expense list -->
			<c:forEach var="person" items="${allDrivers}">
				<tr>
					<td><a id="links" href="/person/${person.id}">${person.firstName} ${person.lastName}</a></td>
					<td>${person.license.number}</td>
					<td>${person.license.state}</td>
					<td>${person.license.expirationDate}</td>	
				</tr>
			</c:forEach>
			<!-- END Loop to iterate expense list -->
			</tbody>
		</table>
        <!-- END Table Display SECTION -->
	</div>
	<a id="home" href="/license">Add License</a>
	
	
</body>
</html>