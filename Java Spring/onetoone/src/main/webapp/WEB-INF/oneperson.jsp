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
   
   		
	<h1> Driver Details</h1>
		<!-- Table Display SECTION -->
		<div class="tableContainer">
			<table id="displayTable"  class="table .table-hover">
				<thead>
					<tr class="bg-primary">
						<th >Name </th>
						<th >License Number </th>
						<th > State</th>
						<th >Exp Date</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${onePerson.firstName} ${onePerson.lastName}</td>
						<td> ${onePerson.license.number}</td>
						<td>${onePerson.license.state}</td>
						<td>${onePerson.license.expirationDate}</td>
					</tr>
				</tbody>
			</table>
            <!-- END Table Display SECTION -->
		</div>
   		<a id="home" href="/">Go Home</a>

   		
</body>
</html>