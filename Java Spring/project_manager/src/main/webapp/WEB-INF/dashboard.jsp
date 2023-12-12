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
	<!-- NAVBAR -->
 	<div class="nav">
  		<h3> Welcome To The Project Board: <br> <c:out value="${user.userName}"/> </h3>
 	</div>
	<!-- NAVBAR -->
	<!-- MENU POPOUT BUTTON -->	
 	<div>
   		<button class="menuTrigger" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasExample" aria-controls="offcanvasExample">
		   		  <i class="fa-solid fa-square-caret-down"></i> &nbsp; MENU
		</button>
  	</div>
	<!-- END MENU POPOUT BUTTON -->		
	<!-- MENU POPOUT -->
	<div class="offcanvas  offcanvas-end" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
        <a class="menu_close" data-bs-dismiss="offcanvas" aria-label="Close"><i class="fa-solid fa-square-xmark fa-2xl"></i></a>
        <ul class="menu__box">
        	<li><a class="menu__item" href="/projects/new">Create A New Project</a></li>
            <li><a class="menu__item" href="/projects/myprojects">My Projects</a></li>
            <li><a class="menu__item" href="/projects/completed">Completed Projects</a></li>
            <li><a class="menu__item" href="/logout">Log Out</a></li>
    	</ul>
	</div>
    <!-- END MENU POPOUT -->  	
	<!-- TABLE TITLE -->
	<div class="flex">
 		<div>
	   		<h3>Open Projects</h3>
	   		<a href="/projects/new">New Project</a>
 		</div>
   		<h5 class="blue">Quick View:  <a href="/projects/myprojects">My Projects</a> / <a href="/projects/completed">Completed Projects</a></h5>
  	</div>
	<!-- TABLE DISPLAY SECTION -->
	<div class="tableContainer">
		<table id="allProjects" class="table displayTable .table-hover">
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
				<!-- LOOP TO ITERATE PROJECT LIST -->
				<c:forEach var="p" items="${allProj}">
						<tr>
							<!-- FILTER USER TYPE OPTIONS (Creator or User) -->
							<!-- C:If Joined Or Not Joined -->					
		                	<c:choose>
								<c:when test="${p.lead.id == user.id}">
									<td><a href="/projects/${p.id}">${p.title}</a> </td>
									<td><p><c:out value="${p.lead.userName}"/></p></td>
									<td><p><fmt:formatDate value="${p.date}" type="date" dateStyle="long"/></p></td>
									<td><a href="/projects/edit/${p.id}">Edit</a> <hr> <a href="/projects/completed/${p.id}">Mark Completed</a></td>
								</c:when>								

		                      	<c:otherwise>
									<td><a href="/projects/${p.id}">${p.title}</a> </td>
									<td><p><c:out value="${p.lead.userName}"/></p></td>
									<td><p><fmt:formatDate value="${p.date}" type="date" dateStyle="long"/></p></td>	
	
									<td>
										<c:if test="${p.users.contains(user)}">
											<a href="/projects/${p.id}/leave">Leave Team</a>
										</c:if>
										<c:if test="${!p.users.contains(user)}">
											<a href="/projects/${p.id}/join">Join Team</a>
										</c:if>				
					        		</td>
		                      	</c:otherwise>
		              		</c:choose>
							<td>
							<!-- END FILTER USER TYPE OPTIONS-->
							<!-- COUNTER STATS -->
								<p>${fn:length(p.tasks)}</p>
							</td>
							<td>
								<p>${fn:length(p.users)}</p>
							</td>				
							<!-- END COUNTER STATS -->					
						</tr>
				</c:forEach>
				<!-- END LOOP TO ITERATE PROJECT LIST -->
			</tbody>
		</table>
	</div>
    <!-- END TABLE DISPLAY SECTION -->
</body>
</html>