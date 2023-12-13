<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit ${project.title}</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/CSS/formStyle.css">
    <link rel="stylesheet" href="/CSS/menuStyle.css"> 
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/JS/app.js"></script>
    <script src="https://kit.fontawesome.com/83a0001255.js"></script>
</head>
<body>
	<!-- NAVBAR -->
	<div class="nav">
  		<h3>The Project Board: <span class="blue">Edit ${project.title}</span></h3>
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
            <li><a class="menu__item" href="/projects/dashboard">Open Projects</a></li>
            <li><a class="menu__item" href="/projects/myprojects">My Projects</a></li>
            <li><a class="menu__item" href="/projects/completed">Completed Projects</a></li>
            <li><a class="menu__item" href="/logout">Log Out</a></li>
    	</ul>
	</div>
    <!-- END MENU POPOUT -->  	
    <!-- FORM CONTAINER -->
    <div class="formContainer">
    	<!-- FORM SECTION -->
        <form:form action="/projects/edit/${project.id}" method="POST" modelAttribute="project">
            <input type="hidden" name="_method" value="PUT">
            <input type="hidden" name="id" value="${project.id}">
    		<!-- FORM INPUT 1 -->
            <div>
                <div class="formation">
                    <form:label path="title"> Project Title:  </form:label>	
	                <div class="errorFlex">
	                    <form:input path="title" type="text" class="input text-center" />
	                    <form:errors path="title" class="errors"/>
	                </div>
                </div>
            </div>
            <!-- END FORM INPUT 1 -->
        	<!-- FORM INPUT 2 -->
            <div>
                <div class="formation">
                    <form:label path="description"> Project Description:  </form:label>	
	                <div class="errorFlex">
	                    <form:textarea path="description" type="text" class="input text-center" />
	                    <form:errors path="description" class="errors"/>
	                </div>
                </div>
            </div>
            <!-- END FORM INPUT 2 -->
        	<!-- FORM INPUT 3 -->
            <div>
                <div class="formation">
                    <form:label path="date"> Due Date: </form:label>	
	                <div class="errorFlex">
	                    <form:input path="date" type="date" class="input date" />
	                    <form:errors path="date" class="errors"/>
	                </div>
                </div>
            </div>
            <!-- END FORM INPUT 3 -->
        	<!-- FORM BUTTONS -->
            <div class="buttonContainer">	
                <button class="button submit" type="submit">Submit</button>
            	<a class="button cancel" href="javascript:history.back()">Cancel</a> 		
            </div>
        	<!-- END FORM BUTTONS -->
        </form:form>
	    <!-- END FORM INPUT SECTION -->
	</div>
	<!-- END FORM CONTAINER -->
</body>
</html>