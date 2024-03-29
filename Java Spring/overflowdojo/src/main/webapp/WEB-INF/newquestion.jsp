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
   
   		
       <!--  nav bar  -->
       <!--  nav bar  -->
   		<div class="navbar">
	   			<div>
					<h1>What Is Your Question?</h1> 
	   			</div>

	   		
	   		  <!-- hamburger -->
			  <input type="checkbox" id="navi-toggle" class="checkbox" />
			  <label for="navi-toggle" class="button">
			    <span class="icon">&nbsp;</span>
			  </label>
			  <div class="background">&nbsp;</div>
	   		
	   		
	   		  <!-- burger nav -->
			  <nav class="nav">
			    <ul class="list">
			      <li class="item"> <a class="link"  href="/dashboard">Home</a> </li>
				  <li class="item"> <a class="link" href="/dashboard/${users.id}/edit">Edit Profile</a> </li>
				  <li class="item"> <a class="link" href="/logout">Logout</a> </li>
		   <!--    <li  class="item"> <a class="link"> Link 4 </a> </li>
			      <li class="item"> <a class="link"> Link 5 </a> </li> -->
			    </ul>
			  </nav>	   		
   		</div>
   		  <!-- END nav -->
   		  <!-- END nav -->
   
   
   			<!-- FORM HERE!! -->
   
		       <div class="formContainer">
		        <!-- FORM INPUT SECTION -->
			        <form:form action="/question/new" method="POST" modelAttribute="question">
			        
			            <div class="sectionOne">
			                <div class="formation">
			                    <form:label path="text"> Question: </form:label>	
			                    <form:input path="text" class="input" />
			                </div>
			                <div class="errors">
			                    <form:errors path="text" class="errors"/>
			                </div>
			            </div>
			        
			            <div class="sectionTwo">
			                <div class="formation">
			                    <label for="tag"> Tags: </label>	
			                    <input id="tag" name="tag" type="text" class="input" />
			                </div>
			                <div class="errors">
			                    <form:errors for="tag" class="errors"/>
			                </div>
			            </div>
			        
			            <div class="buttonContainer">		 		
			                <button class="submitButton" type="submit">Submit</button>
			            </div>
			        
			        </form:form>
			
			        <!-- END FORM INPUT SECTION -->
			    </div>
   
   
   
   
   
   
</body>
</html>