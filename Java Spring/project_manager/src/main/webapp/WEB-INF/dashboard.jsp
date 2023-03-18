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
   
   		<div class="nav">
	   		<h1> Hello, <c:out value="${user.userName}"/> </h1>
	   		<h3><a href="/logout">Logout</a></h3>
   		</div>
   		
   		<div class="flex">
   		<h3>All Projects</h3>
   		<h3><a href="/projects/new">New Project</a></h3>
   		
   		</div>
   		
   		
   		
   		
   		
   		
   		
		<!-- Table Display SECTION -->
		<div class="tableContainer">
			<table id="displayTable"  class="table .table-hover">
				<thead>
					<tr class="bg-primary">
						<th scope="col">Project </th>
						<th scope="col">Team Lead </th>
						<th scope="col">Due Date </th>
						<th scope="col">Actions </th>
					</tr>
				</thead>
				<tbody>
				<!-- Loop to iterate expense list -->
				<c:forEach var="p" items="${allProjects}">
				
						<c:if test="${user.id != p.manager}">
					<tr>
						<td><a href="/projects/${p.id}">${p.title}</a> </td>
						<td>${p.creator}</td>
						<td>${p.date}</td>
			
							<td>
							   			<!--- Join Form --->
							   <div>
							        <!-- FORM INPUT SECTION -->
						       	  <form action="/projects/${p.id}/join" method="POST">
						                <input type="hidden" name="_method" value="PUT">
									    <input type="hidden" name="users_id" value="${user.id}"/>   
									<!--- ... --->
						           <div class="buttonContainer">		 		
						                <button class="button" type="submit">Join Team</button>
						            </div>
						        
						        </form>
					   		</div>
					   			<!--- ...  --->
						
						</td>
					
					</tr>
						</c:if>					
				</c:forEach>
				<!-- END Loop to iterate expense list -->
				</tbody>
			</table>
            <!-- END Table Display SECTION -->
		</div>
   		
   		
		<!-- Table Display SECTION -->
		<div class="tableContainer">
			<table id="displayTable"  class="table .table-hover">
				<thead>
					<tr class="bg-primary">
						<th scope="col">Project </th>
						<th scope="col">Team Lead </th>
						<th scope="col">Due Date </th>
						<th scope="col">Actions </th>
					</tr>
				</thead>
				<tbody>
				<!-- Loop to iterate expense list -->
				<c:forEach var="p" items="${allProjects}">

				<c:if test="${user.id == p.manager}">
					<tr>
						<td><a href="/projects/${p.id}">${p.title}</a></td>
						<td>${p.creator}</td>
						<td>${p.date}</td>
						<c:if test="${user.id == p.manager}"> 
						<td>
						<a href="/projects/edit/${p.id}">Edit</a> ||
						<a href="/projects/${p.id}/delete">Delete</a> 
						</td>
						</c:if>
						<c:if test="${user.id != p.manager}"> 
						<td>Leave Team</td>
						</c:if>
					</tr>
				</c:if>
				</c:forEach>

				<!-- END Loop to iterate expense list -->
				</tbody>
			</table>
            <!-- END Table Display SECTION -->
		</div>
   		
   		   
</body>
</html>