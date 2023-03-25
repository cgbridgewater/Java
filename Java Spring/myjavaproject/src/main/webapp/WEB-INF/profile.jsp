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
    <link rel="stylesheet" href="/CSS/oneview.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/JS/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   
   		<div class="navbar">
	   		<h1> Hello, <c:out value="${user.userName}"/> </h1>
	   		
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
				  <li class="item"> <a class="link" href="/logout">Logout</a> </li>
		   <!--    <li  class="item"> <a class="link"> Link 4 </a> </li>
			      <li class="item"> <a class="link"> Link 5 </a> </li> -->
			    </ul>
			  </nav>

	   		
   		</div>
   		
   		
	  

	    <div class="viewOneContainer">
			<div class="boxtitle">
				<h1>Your Account Details</h1>
			  	<a class="updatelink" href="/user/${user.id}/update">Update My Info</a>
			</div>	
	
	        <br>
	        
	        <div class="flexControl">
	        <h3>   Name : </h3>
	        <h3 class="rightSide">${user.userName}</h3>
	        </div>
	        
	        <br>
	        
	        <div class="flexControl">
	        <h3>    Email : </h3>
	        <h3 class="rightSide">${user.email}</h3>
	        </div>
	    </div>
	 
	 	<div class="links">
		 	<a href="/timer/new" class="updatelink">Add New Timer</a>	
	 	</div>
	     
		<!-- Table Display SECTION -->
		<div class="tableContainer">
			<table id="displayTable"  class="table .table-hover">
				<thead>
					<tr class="bg-primary">
						<th scope="col">Timer Name </th>
						<th scope="col">Timer Type </th>
						<th scope="col">Total Time </th>
						<th scope="col">Actions </th>
					</tr>
				</thead>
				<tbody>
				<!-- Loop to iterate expense list -->
				<%// <c:forEach var="users" items="${allUsers}">%>
					<tr>
						
						<td> spacer </td>
						<td> spacer</td>
						<td> spacer </td>
						<td> spacer</td>
						
					</tr>
				<%// </c:forEach>%>
				<!-- END Loop to iterate expense list -->
				</tbody>
			</table>
            <!-- END Table Display SECTION -->
		</div>
   		
	 	
	 
	 
   
</body>
</html>