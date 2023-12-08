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

	<!-- NAV BAR -->
   	<div class="nav">
   		<div>
   			<h1>Project: ${project.title} Details</h1>
   			<h5>Project Lead: ${project.lead.userName} </h5>
   		</div>
   			<h4><a href="/dashboard">Back To Dashboard!</a></h4>
   	</div>
	<!-- END NAV BAR -->
	<!-- PROJECT CONTAINER -->
    <div class="viewOneContainer">
        <div class="flexControl">
	        <h3>Project Name: </h3>
	        <h3 class="rightSide">${project.title}</h3>
        </div>
        <div class="flexControl">
	        <h3>  Due Date: </h3>
	        <h3 class="rightSide"><fmt:formatDate value="${project.date}" type="date" dateStyle="long"  /></h3>
        </div>
        <div class="flexControl">
	        <h3>Description: </h3>
	        <h3 class="rightSide">${project.description}</h3>
        </div>
	    <div class="buttonContainer">	
	    	<c:if test="${user.id == project.lead.id}">
		   	   <h5><a href="/projects/edit/${project.id}"><button class="button">Edit Task</button></a></h5>
		       <h5><a href="/projects/${project.id}/delete"><button class="button">Delete!</button></a></h5>
	        </c:if>
	    </div>
	</div>
	<!-- END PROJECT CONTAINER -->
	<!-- TEAM MEMBER CONTAINER -->
	<div class="viewOneContainer">
		<h3>Team Members:</h3>
		<c:forEach var="m" items="${project.users}">
			<p> ${m.userName}  </p>
		</c:forEach>
	</div>	
   	<!-- END TEAM MEMBER CONTAINER -->
	<!-- TASK CONTAINER -->
	<div class="viewOneContainer">
		<h3>Project Tasks:</h3>
		<c:forEach var="t" items="${project.tasks}">
			<p><b> ${t.text} </b> </p>
			<p>Added by ${t.creator} <br>on <fmt:formatDate value="${t.createdAt}" type="both" dateStyle="long"  /></p>
		</c:forEach>
	</div>
	<!-- END TASK CONTAINER -->
</body>
</html>