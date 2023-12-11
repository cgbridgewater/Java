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
<!-- jstl functions -->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/CSS/dashboard.css"> 
    <link rel="stylesheet" href="/CSS/menu.css"> 
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/JS/app.js"></script>
    <script src="https://kit.fontawesome.com/83a0001255.js"></script>
</head>
<body>
  		<div class="nav">
   		<h3> Welcome To The Project Board: <br> <c:out value="${user.userName}"/> </h3>
  		</div>
  		
  		<div>
   		<button class="menuTrigger" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasExample" aria-controls="offcanvasExample">
		   		  <i class="fa-solid fa-square-caret-down"></i> &nbsp; MENU
		</button>
  		</div>
  		
		<!-- MENU POPOUT -->
		<div class="offcanvas  offcanvas-end" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
           <a class="menu_close" data-bs-dismiss="offcanvas" aria-label="Close"><i class="fa-solid fa-square-xmark fa-2xl"></i></a>
           <ul class="menu__box">
               <li><a class="menu__item" href="/projects/new">Create A New Project</a></li>
               <li><a class="menu__item" href="/#">All Projects</a></li>
               <li><a class="menu__item" href="/#">My Projects</a></li>
               <li><a class="menu__item" href="/#">Completed Projects</a></li>
           </ul>
       </div>
       <!-- END MENU POPOUT -->
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
					<th scope="col">Tasks </th>
					<th scope="col">Team</th>
				</tr>
			</thead>
			<tbody>
				<!-- Loop to iterate project list -->
				<c:forEach var="p" items="${assignedProj}">
					<c:if test="${p.completed == false}"> 															
						<tr>
							<td><a href="/projects/${p.id}">${p.title}</a></td>
							<td><p>${p.lead.userName}</p></td>
							<td><p><fmt:formatDate value="${p.date}" type="date" dateStyle="long"  /></p></td>	
							<c:if test="${p.lead.id == user.id}"> 
								<p><td><a href="/projects/edit/${p.id}">Edit</a> <br> <a href="/projects/completed/${p.id}">Mark As <br> Complete</a></td>
							</c:if>
							<c:if test="${p.lead.id != user.id}"> 
								<td><p><a href="/projects/${p.id}/leave">Leave Team</a></p></td>
							</c:if>
							<td>
								<p>${fn:length(p.tasks)}</p>
							</td>
							<td>
								<p>${fn:length(p.users)}</p>
							</td>	
						</tr>
					</c:if>
				</c:forEach>
				<!-- END Loop to iterate project list -->
			</tbody>
		</table>
           <!-- END Table Display SECTION -->
	</div>  
</body>
</html>