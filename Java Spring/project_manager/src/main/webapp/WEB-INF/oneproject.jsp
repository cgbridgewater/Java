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
    <title>Project: ${project.title}</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/CSS/oneProject.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/JS/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>

	<!-- NAV BAR -->
   	<div class="nav">
   		<div>
   			<h1>Project: ${project.title}</h1>
   			<h5>Project Lead: ${project.lead.userName} </h5>
   		</div>
   			<h4><a href="/projects/dashboard">Back To Dashboard!</a></h4>
   	</div>
	<!-- END NAV BAR -->
	<c:if test="${project.completed == true}">	
		<h1 class="completeTitle">PROJECT COMPLETED</h1>
	</c:if>	
	<!-- PROJECT CONTAINER -->
    <div class="viewOneContainer">
        <div class="flexControl">
	        <h3>Project Name: </h3>
	        <h4 class="rightSide">${project.title}</h4>
        </div>
        <div class="flexControl">
	        <h3>  Due Date: </h3>
	        <h4 class="rightSide"><fmt:formatDate value="${project.date}" type="date" dateStyle="long"  /></h4>
        </div>
        <div class="flexControl">
	        <h3>Description: </h3>
	        <h4 class="rightSide">${project.description}</h4>
        </div>
    	<c:if test="${user.id == project.lead.id and project.completed == false }">
		    <div class="buttonContainer">	
			   	   <a href="/projects/edit/${project.id}"><button class="button edit">Edit Task</button></a>
			   	   <a href="/projects/completed/${project.id}"><button class="button complete">Mark Completed</button></a>
			       <a href="/projects/${project.id}/delete"><button class="button delete">Delete!</button></a>
		    </div>
        </c:if>
        <c:if test="${project.completed == true}">	
       		    <div class="returnContainer">
	   		     	<h5>Completed Projects <span class="completeWord">MUST</span> be returned to incomplete before editing!</h5>
	        		<a href="/projects/incomplete/${project.id}">Mark As Incomplete</a>
       		    </div>
	        </c:if>
	</div>
	<!-- END PROJECT CONTAINER -->
	<!-- LOWER CONTAINER -->
	<div class="viewTwoContainer">	
		<!-- TEAM MEMBER CONTAINER -->
		<div class="teamMembers">
			<h3>Team Members:</h3>
			<c:forEach var="m" items="${project.users}">
				<p class="right"> ${m.userName}  </p>
			</c:forEach>
		</div>	
	   	<!-- END TEAM MEMBER CONTAINER -->
		<!-- TASK CONTAINER -->
		<div class="tasks">
			<h3>Project Tasks:</h3>
			<c:if test="${project.completed == false}">
			    <h5 class="small">Add a task ticket:</h5>
		        <!-- FORM INPUT SECTION -->
			    <div>
			        <form:form action="/projects/${project.id}/tasks" method="POST" modelAttribute="task">
	                <input type="hidden" name="creator" value="${user.userName}">
	            
			            <div class="sectionOne">
			                <div class="ticketFlex">
			                    <form:label path="text">  </form:label>	
			                    <form:textarea path="text" rows="2" cols="40" class="input"/>
				                <button class="button submit" type="submit">Submit</button>
			                </div>
			                <div class="errors">
			                    <form:errors path="text" class="errors"/>
			                </div>
			            </div>
			        
			            <div class="buttonContainer">		 		
			            </div>
			        
			        </form:form>
			    </div>			
		        <!-- END FORM INPUT SECTION -->
	        </c:if>
  			<c:if test="${project.completed == true}">
	        <h5 class="completed">Project is marked <span class="completeWord">COMPLETE</span> <br> Addition of new tasks is disabled</h5>
	        </c:if>
			<c:forEach var="t" items="${project.tasks}">
				<div class="flexControl">
					<a href="/projects/${project.id}/tasks/${t.id}/delete">Delete</a>
					<div class="right">
						<p class="taskText"><b> ${t.text} </b> </p>
						<p class="smaller">Added by ${t.creator} <br>on <fmt:formatDate value="${t.createdAt}" type="both" dateStyle="long"  /></p>
					</div>
				</div>
			</c:forEach>
    	</div>
		<!-- END TASK CONTAINER -->
	</div>
	<!-- LOWER CONTAINER -->
</body>
</html>