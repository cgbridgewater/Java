<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Project: ${project.title}</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/CSS/oneProject.css"> 
    <link rel="stylesheet" href="/CSS/menuStyle.css">
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/JS/app.js"></script>
    <script src="https://kit.fontawesome.com/83a0001255.js"></script>
</head>
<body>
	<!-- NAV BAR -->
 	<div class="nav">
  		<h3>The Project Board: <span class="blue">View Project</span></h3>
  		<h3>User: <span class="blue"><c:out value="${user.userName}"/></span></h3>
      	<a href="javascript:history.back()">Go Back</a>	
 	</div>
	<!-- END NAV BAR -->
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
 	       <li><a class="menu__item" href="/projects/dashboard">All Projects</a></li>
           <li><a class="menu__item" href="/projects/myprojects">My Projects</a></li>
           <li><a class="menu__item" href="/projects/completed">Completed Projects</a></li>
           <li><a class="menu__item" href="/logout">Log Out</a></li>
     	</ul>
     </div>
     <!-- END MENU POPOUT -->
	<!-- FILTER FOR COMPLETED ONLY) -->
	<c:if test="${project.completed == true}">	
		<h1 class="completeTitle">PROJECT COMPLETED</h1>
	</c:if>	
	<!-- PROJECT CONTAINER -->
    <div class="viewOneContainer">
        <div class="flexControl">
	        <h3>Project Name: </h3>
	        <h4 class="rightSide">${project.title}</h4>
        </div>
        <hr>
        <div class="flexControl">
	        <h3>Project Lead: </h3>
	        <h4 class="rightSide">${project.lead.userName}</h4>
        </div>
        <hr>
        <div class="flexControl">
	        <h3>  Due Date: </h3>
	        <h4 class="rightSide"><fmt:formatDate value="${project.date}" type="date" dateStyle="long"  /></h4>
        </div>
        <hr>
        <div class="flexControl">
	        <h3>Description: </h3>
	        <h4 class="rightSide">${project.description}</h4>
        </div>
        <!-- FILTER FOR INCOMPLETE FOR APPROPRIATE BUTTONS -->
    	<c:if test="${user.id == project.lead.id and project.completed == false }">
		    <div class="buttonContainer">	
		   	    <a class="link" href="/projects/edit/${project.id}"><button class="button edit">Edit Task</button></a>
		   	    <a class="link" href="/projects/completed/${project.id}"><button class="button complete">Mark Completed</button></a>
				<a class="link" href="/projects/${project.id}/delete"><button class="button delete">Delete!</button></a>
		    </div>
        </c:if>
      	<!-- FILTER FOR COMPLETE FOR APPROPRIATE BUTTONS -->	
        <c:if test="${project.completed == true}">	
      	    <div class="returnContainer">
   		  	 	<h5>Completed Projects <span class="completeWord">MUST</span> be returned to incomplete before editing!</h5>
        		<a href="/projects/incomplete/${project.id}">Mark As Incomplete</a>
     		</div>
        </c:if>
		<!-- END FILTERs FOR INCOMPLETE/COMPLETE FOR APPROPRIATE BUTTONS -->	
	</div>
	<!-- END PROJECT CONTAINER -->
	<!-- LOWER CONTAINER (split L/R) -->
	<div class="viewTwoContainer">	
		<!-- TEAM MEMBER CONTAINER -->
		<div class="teamMembers">
			<div class="flexControl">
				<h3>Team Members:</h3>
				<c:if test="${user.id != project.lead.id and project.users.contains(user)}">
					<a class="link" href="/projects/${project.id}/leaveone"><button class="button edit">Leave</button></a>
				</c:if>
				<c:if test="${user.id != project.lead.id and !project.users.contains(user)}">
					<a class="link" href="/projects/${project.id}/joinone"><button class="button join">Join</button></a>				
				</c:if>
			</div>
			<c:forEach var="m" items="${project.users}">
				<p class="rightSide blue"> ${m.userName}  </p>
			</c:forEach>
		</div>	
	   	<!-- END TEAM MEMBER CONTAINER -->
		<!-- TASK CONTAINER -->
		<div class="tasks">
			<h3>Project Tasks:</h3>
			<!-- FILTER FOR INCOMPLETE FOR APPROPRIATE BUTTONS -->	
			<c:if test="${project.completed == false}">
			    <h5 class="small">Add a task ticket:</h5>
		        <!-- FORM INPUT SECTION -->
			    <div>
			        <form:form action="/projects/${project.id}/tasks" method="POST" modelAttribute="task">
	                <input type="hidden" name="creator" value="${user.userName}">
			            <div class="sectionOne">
			                <div id="addTask" class="ticketFlex">
			                    <form:label path="text">  </form:label>	
			                    <form:textarea path="text" rows="1" cols="40" class="input"/>
				                <button class="button submit" type="submit">Submit</button>
			                </div>
			                <div class="errors">
			                    <form:errors path="text" class="errors"/>
			                </div>
			            </div>
			        </form:form>
			    </div>			
		        <!-- END FORM INPUT SECTION -->
	        </c:if>
       		<!-- FILTER FOR COMPLETE FOR APPROPRIATE BUTTONS -->	
  			<c:if test="${project.completed == true}">
	        <h5 class="completed">Project is marked <span class="completeWord">COMPLETE</span> <br> Addition of new tasks is disabled</h5>
	        </c:if>
			<!-- END FILTER FOR INCOMPLETE/COMPLETE FOR APPROPRIATE BUTTONS -->	
	        <!-- ITERATE THROUGH TASKS LIST -->
			<c:forEach var="t" items="${project.tasks}">
				<hr>
				<div class="flexControl">
					<!--  FILTER FOR TASK CREATOR -->	
					<c:if test="${t.creator == user.userName}">
						<a href="/projects/${project.id}/tasks/${t.id}/delete">Delete</a>
					</c:if>
					<!--  FILTER FOR NOT TASK CREATOR -->
					<c:if test="${t.creator != user.userName}">
						&nbsp;
					</c:if>
					<!--  FILTER FOR TASK CREATOR -->
					<!--  TASK TEXT AND STIME STAMP -->
					<div class="rightSide">
						<p class="taskText"><b> ${t.text} </b> </p>
						<p class="smaller">Added by ${t.creator} <br>on <fmt:formatDate value="${t.createdAt}" type="both" dateStyle="long"  /></p>
					</div>
					<!--  TASK TEXT AND STIME STAMP -->
				</div>
			</c:forEach>
	        <!-- END ITERATE THROUGH TASKS LIST -->
    	</div>
		<!-- END TASK CONTAINER -->
	</div>
	<!-- END LOWER CONTAINER -->
</body>
</html>