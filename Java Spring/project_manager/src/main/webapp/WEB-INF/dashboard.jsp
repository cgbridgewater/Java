<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date" import = "javax.servlet.*,java.text.*"%>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>
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
		<!-- Table Title -->
  		<div class="flex">
  			<div>
		   		<h3>All Projects</h3>
		   		<a href="/projects/new">New Project</a>
  			</div>
	   		<h5><a href="#allProjects">All Projects</a> / <a href="#myProjects">My Projects</a> / <a href="#CompletedProjects">Completed Projects</a></h5>
   		</div>
		<!-- Table Display SECTION -->
		<div class="tableContainer">
			<table id="allProjects" class="table displayTable .table-hover">
				<thead>
					<tr class="bg-primary">
						<th scope="col">Project </th>
						<th scope="col">Team Lead </th>
						<th scope="col">Due Date </th>
						<th scope="col">Actions </th>
					</tr>
				</thead>
				<tbody>
					<!-- Loop to iterate project list -->
					<c:forEach var="p" items="${unassignedProj}">
						<tr>
							<c:if test="${p.lead.id != user.id}">
							<td><a href="/projects/${p.id}">${p.title}</a> </td>
							<td><c:out value="${p.lead.userName}"/></td>
							<td><fmt:formatDate value="${p.date}" type="date" dateStyle="long"  /></td>						
							<td><a href="/projects/${p.id}/join">Join Team</a></td>
							</c:if>										
						</tr>
					</c:forEach>
					<!-- END Loop to iterate project list -->
				</tbody>
			</table>
            <!-- END Table Display SECTION -->
		</div>
   		<!-- Table Title -->	
   		<div class="flex">
			<div>
	   			<h3>My Projects</h3>
		   		<a href="/projects/new">New Project</a>
  			</div>
   		</div>
		<!-- Table Display SECTION -->
		<div class="tableContainer">
			<table id="myProjects" class="table displayTable .table-hover">
				<thead>
					<tr class="bg-primary">
						<th scope="col">Project </th>
						<th scope="col">Team Lead </th>
						<th scope="col">Due Date </th>
						<th scope="col">Actions </th>
					</tr>
				</thead>
				<tbody>
					<!-- Loop to iterate project list -->
					<c:forEach var="p" items="${assignedProj}">
						<tr>
							<td><a href="/projects/${p.id}">${p.title}</a></td>
							<td>${p.lead.userName}</td>
							<td><fmt:formatDate value="${p.date}" type="date" dateStyle="long"  /></td>	
							<c:if test="${p.lead.id == user.id}"> 
								<td><a href="/projects/edit/${p.id}">Edit</a></td>
							</c:if>
							<c:if test="${p.lead.id != user.id}"> 
								<td><a href="/projects/${p.id}/leave">Leave Team</a></td>
							</c:if>
						</tr>
					</c:forEach>
					<!-- END Loop to iterate project list -->
				</tbody>
			</table>
            <!-- END Table Display SECTION -->
		</div>   		   
</body>
</html>