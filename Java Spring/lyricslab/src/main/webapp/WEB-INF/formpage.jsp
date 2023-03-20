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
    <link rel="stylesheet" href="/CSS/form.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/JS/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   
   		<div class="nav">
	   		<h1> Hello, <c:out value="${user.userName}"/> </h1>
 			<div>
		   		<h3><a href="/logout">Logout</a></h3>
		   		<h3><a href="/dashboard">Dashboard</a></h3>
	   		</div>
   		</div>
   		
   		    <div class="formContainer">
        <!-- FORM INPUT SECTION -->
        <form:form action="/songs/new" method="POST" modelAttribute="song">
                <form:input path="user" type="hidden" class="input" value="${user.id}" />
        		<form:errors path="user" class="errors"/>
        		
        
            <div class="sectionOne">
                <div class="formation">
                    <form:label path="title"> Song Title: </form:label>	
                    <form:input path="title" type="" class="input" />
                </div>
                <div class="errors">
                    <form:errors path="title" class="errors"/>
                </div>
            </div>
        
        
            <div class="sectionOne">
                <div class="formation">
                    <form:label path="genre"> Genre: </form:label>	
                    <form:input path="genre"  class="input" />
                </div>
                <div class="errors">
                    <form:errors path="genre" class="errors"/>
                </div>
            </div>
        
        
            <div class="sectionOne">
                <div class="formation">
                    <form:label path="lyric"> Add your lyrics </form:label>	
                    <form:textarea path="lyric" type="text" class="input" />
                </div>
                <div class="errors">
                    <form:errors path="lyric" class="errors"/>
                </div>
            </div>
        
            <div class="buttonContainer">		 		
                <button class="button" type="submit">Submit</button>
            </div>
        
        </form:form>
        

        <!-- END FORM INPUT SECTION -->
    </div>
   		
        
        <div class="linkLeft">
   			<h3><a href="/dashboard">Cancel</a></h3>
   		</div>
	
   		   
</body>
</html>