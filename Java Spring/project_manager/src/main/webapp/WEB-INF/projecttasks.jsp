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
    <link rel="stylesheet" href="/CSS/style4.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/JS/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   
   		 		<div class="buttonContainer">
   		 		<div>
		   			<h1>${project.title} Details</h1>
					<h4>Project Lead: ${project.lead.userName}</h4>   		 		
   		 		</div>
   			<h4><a href="/dashboard">Back To Dashboard!</a></h4>
		</div>
		
		
		
		
		    <div class="formContainer">
		    <h5>Add a task ticket for this team</h5>
		        <!-- FORM INPUT SECTION -->
		    
			    <div>
			        <form:form action="/projects/${project.id}/tasks" method="POST" modelAttribute="task">
	                <input type="hidden" name="creator" value="${user.userName}">
	            
			            <div class="sectionOne">
			                <div class="formation">
			                    <form:label path="text">  </form:label>	
			                    <form:textarea path="text" rows="4" cols="20" class="input" />
			                </div>
			                <div class="errors">
			                    <form:errors path="text" class="errors"/>
			                </div>
			            </div>
			        
			            <div class="buttonContainer">		 		
			                <button class="subbutton" type="submit">Submit</button>
			            </div>
			        
			        </form:form>
			    </div>
			
		        <!-- END FORM INPUT SECTION -->
		    </div>

			
			<div class="tasks">
				<c:forEach var="t" items="${project.tasks}">
				<fmt:formatDate value="${t.createdAt}" var="formattedDate"
					type="date" pattern="hh:mm dd MMM yyyy" />
					<p>Added by ${t.creator} at ${formattedDate}  </p>
					<p> ${t.text}  </p>
				</c:forEach>
			</div>


</body>
</html>