<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	   		<h1> Coding Dojo</h1>
	   		<h1>All Locations</h1>
			<div>
			    <div class="formContainer">
			        <!-- FORM INPUT SECTION -->
			        <form:form action="/dojos/create" method="POST" modelAttribute="newDojo">
			        
			            <div class="sectionOne">
			                <div class="formation">
					            <div class="buttonContainer">		 		
					                <button class="button" type="submit">Submit</button>
					            </div>
			                    <form:input path="name" type="text" class="input" placeholder="Add New Dojo" />
			                </div>
			                <div class="errors">
			                    <form:errors path="name" class="errors"/>
			                </div>
			            </div>
			        
			        </form:form>
			
			        <!-- END FORM INPUT SECTION -->
			    </div>
			</div>
   		</div>
   			        <!-- END NavBar SECTION -->
   		

		<!-- Table Display SECTION -->
		<div class="tableContainer">
			<table id="displayTable"  class="table .table-hover">
				<thead>
					<tr class="bg-primary">
						<th >Location</th>
						<th >Actions</th>
					</tr>
				</thead>
				<tbody>
				<!-- Loop to iterate expense list -->
				<c:forEach var="dojo" items="${allDojos}">
					<tr>
						<td><a href="/dojos/${dojo.id}">${dojo.name}</a> </td>
						<td>
						 <a class="btn btn-secondary btn-outline-light" href="/dojos/${dojo.id}/edit" role="button">Edit</a>
						  <a class="btn btn-danger btn-outline-dark" href="/dojos/${dojo.id}/delete" role="button">Delete</a>
						 </td>
					</tr>
				</c:forEach>
				<!-- END Loop to iterate expense list -->
				</tbody>
			</table>
            <!-- END Table Display SECTION -->
		</div>
  
          <div class="linkContainer">		 		
             <a class="btn btn-light btn-outline-primary" href="/ninjas" role="button">Add New Ninja</a>	 		
          </div>
   
   
   
   
</body>
</html>