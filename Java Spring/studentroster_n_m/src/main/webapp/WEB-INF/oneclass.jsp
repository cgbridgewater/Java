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
    <link rel="stylesheet" href="/CSS/style3.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/JS/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   
   	   
 		<div class="nav">			
   		    <h1> Students Taking ${oneClass.className}</h1>			    
			<h3><a href="/dorms">Dashboard</a></h3>
   		</div>
   
   
 	
   
   
   
		<!-- Table Display SECTION -->
		<div class="tableContainer">
			<table id="displayTable"  class="table .table-hover">
				<thead>
					<tr class="bg-primary">
						<th scope="col">Student Name</th>
					</tr>
				</thead>
				<tbody>
				<!-- Loop to iterate expense list -->
				<c:forEach var="c" items="${oneClass.studentsInClass}">
				
					<tr>
						<td> <a href="/students/${c.id}"><c:out value="${c.studentName}"/> </a> </td>
					</tr>

				</c:forEach>
				<!-- END Loop to iterate expense list -->
				</tbody>
			</table>
            <!-- END Table Display SECTION -->
		</div>

   
</body>
</html>