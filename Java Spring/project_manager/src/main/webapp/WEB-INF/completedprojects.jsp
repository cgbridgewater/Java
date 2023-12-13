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
    <title>Completed Projects</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/CSS/resultTables.css"> 
    <link rel="stylesheet" href="/CSS/menuStyle.css"> 
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/JS/app.js"></script>
    <script src="https://kit.fontawesome.com/83a0001255.js"></script>
</head>
<body>
	<!-- NAVBAR -->
	<div class="nav">
  		<h3>The Project Board: <span class="blue">Completed Projects</span></h3>
  		<h3>User: <span class="blue"><c:out value="${user.userName}"/></span></h3>
      	<a href="javascript:history.back()">Go Back</a>	
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
		    <li><a class="menu__item" href="/projects/dashboard">All Projects</a></li>
		    <li><a class="menu__item" href="/projects/myprojects">My Projects</a></li>
			<li><a class="menu__item" href="/logout">Log Out</a></li>
		</ul>
    </div>
    <!-- END MENU POPOUT -->
 	<!-- TABLE TITLE -->	
	<div class="flex">
	   	<h5><a href="/projects/new">Create New Project</a></h5>
	   	<h5 class="blue2">Quick View:  <a href="/projects/dashboard">Open Projects</a> / <a href="/projects/myprojects">My Projects</a></h5>
  	</div>	
	<!-- TABLE DISPLAY SECTION -->		
 	<div class="tableContainer">
		<table id="completedProjects" class="table displayTable .table-hover">
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
						<td><a href="/projects/${p.id}">${p.title}</a></td>
						<td><p>${p.lead.userName}</p></td>
						<td><p><fmt:formatDate value="${p.date}" type="date" dateStyle="long"  /></p></td>	
					    <td>
						    <!-- FILTER USER TYPE OPTIONS (Creator or User) -->
							<c:choose>
								  <c:when test="${p.lead.id == user.id}">
									   <p><a href="/projects/incomplete/${p.id}">Mark Incomplete</a></p>
								  </c:when>
								  <c:otherwise>
		
								  </c:otherwise>
							</c:choose>
					    </td>
						<!-- END FILTER USER TYPE OPTIONS-->
						<!-- COUNTER STATS -->
						<td>
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