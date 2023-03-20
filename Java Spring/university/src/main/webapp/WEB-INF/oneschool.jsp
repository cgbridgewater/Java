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
   
   		<div class="nav">
	   		<h1> About <c:out value="${oneSchool.name}"/> </h1>
	   		<div>
		   		<h3><a href="/logout">Logout</a></h3>
		   		<h3><a href="/dashboard">Dashboard</a></h3>
	   		</div>
   		</div>
   		
   		    <div class="viewOneContainer">
        
        <div class="flexControl">
	        <h3>   City : </h3>
	        <h3 class="rightSide">${oneSchool.city}</h3>
        </div>
        
        
        <div class="flexControl">
	        <h3>   AddedBy : </h3>
	        <h3 class="rightSide">${oneSchool.userSchool.userName }</h3>
        </div>
        
        
        <div class="flexControl">
	        <h3>   Offers Online Courses : </h3>
	        <h3 class="rightSide">${oneSchool.online}</h3>
        </div>
        
        
        <div class="flexControl">
	        <h3>  Offers In-Person Courses : </h3>
	        <h3 class="rightSide">${oneSchool.inperson}</h3>
        </div>
        
        <div class="flexControl">
	        <h3>  Students Enrolled : </h3>
	        <h3 class="rightSide">${oneSchool.enrolled}</h3>
        </div>
        
        <div class="flexControl">
	        <h3>  Year Established : </h3>
	        <h3 class="rightSide">${oneSchool.founded}</h3>
        </div>
        
        <div class="">
      	  <h3>  List Of Halls On Campus : </h3>
        <ul>
        	<c:forEach var="s" items="${oneSchool.schoolHalls}">
     
        		<li><a href="/hall/${s.id}/view">${s.name}</a></li>

		    </c:forEach>
        
        </ul>
       
        </div>
        
        
   		   
</body>
</html>