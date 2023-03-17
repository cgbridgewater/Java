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
   		    <h1>${oneStudent.studentName}'s Classes </h1>			    
			<h3><a href="/dorms">Dashboard</a></h3>
   		</div>
   
   
   			<!--- Transfer Student Form --->
		<div class="formContainer">
			<!-- FORM INPUT SECTION -->
			<form action="/students/${oneStudent.id}/update" method="POST">
                <input type="hidden" name="_method" value="PUT">

			   <!--- Drop down select menu --->
			 <div class="formation">
				<label for="student"> Add a Class:  </label>	
				<select class="input" name="classId" id="classId">
					<c:forEach var="c" items="${allClasses}">
						<c:if test="${!oneStudent.classesWithStudents.contains(c)}"> 	
							<!--- Each option VALUE is the id of the person --->
							<option value="${c.id}">
							<!--- This is what shows to the user as the option --->
								<c:out value="${c.className}"/>
					   
							</option>
						</c:if>
					</c:forEach>
				</select>
			</div>
			<!--- ... --->
		   <div class="buttonContainer">		 		
				<button class="button" type="submit">Add</button>
			</div>
		
		</form>
	   </div>
		   <!--- ...  --->
   
   
		<!-- Table Display SECTION -->
		<div class="tableContainer">
			<table id="displayTable"  class="table .table-hover">
				<thead>
					<tr class="bg-primary">
						<th scope="col">Student </th>
						<th scope="col">Action </th>
					</tr>
				</thead>
				<tbody>
				<!-- Loop to iterate expense list -->
				<c:forEach var="s" items="${oneStudent.classesWithStudents}">

					<tr>
						<td>${s.className}</td>
					    <td>
					    	<form action="/classes/${oneStudent.id}/update" method="POST">
							<input type="hidden" name="classId" value="${s.id}"/>					    	
					    	<button>Drop</button>
					    	</form>
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