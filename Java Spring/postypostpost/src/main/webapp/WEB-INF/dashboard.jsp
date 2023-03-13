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
	   		<h1> Hello, <c:out value="${user.userName}"/> </h1>
	   		<h3><a href="/logout">Logout</a></h3>
   		</div>
   		
   		
        <!-- FORM SECTION -->
		    <div class="formContainer">
		        <form:form action="/post/new" method="POST" modelAttribute="post">
		        
		        <!-- FORM INPUT SECTION -->
		            <div class="inputContainer">
		                <div class="formation">
		                    <form:label path="title"> Title:  </form:label>	
		                    <form:input path="title" class="input" />
		                </div>
		                <div class="errors">
		                    <form:errors path="title" class="errors"/>
		                </div>
		            </div>
		        	<!-- ... -->
		        	
		        	<!-- FORM TEXT AREA SECTION -->
		        	<div>
		        		<form:textarea path="text" rows="3"  class="input" />
		        	</div>
		        	<!-- ... -->
		        
		        	<!-- FORM BUTTON -->
		            <div class="buttonContainer">		 		
		                <button class="button" type="submit">Submit</button>
		            </div>
		        	<!-- ... -->
		        	
		        </form:form>
		        <!-- END FORM INPUT SECTION -->
    		</div>
    		
    		<div class="resultContainer">
    		
    			<div>
   					<h3>Your Posts:</h3>
		   				<ul>
		    				<c:forEach var="post" items="${user.posts}">
		 
		    					<li><c:out value="${post.title}"/></li>	
		 
		    				</c:forEach>
		    			</ul>
    			</div>
    		
    			
	    			<div class="allPosts">
   					<h3> All Posts:</h3>
		   				<ul>
		    				<c:forEach var="post" items="${allPosts}">
		 
		    					<li>
									<h5 class="title"><a href="/post/${post.id}">
										<c:out value="${post.title}" />
									</a></h5>  
									<c:if test="${post.createdBy.id != idInSession}">
										<h4><a class="like" href="post/${post.id}/like"> ♡like♡</a></h4>
									</c:if>
									 | 
									 <h4><c:out value="${post.likedBy.size()}"/> ♡'s</h4>
								</li>	
								
		    				</c:forEach>
		    			</ul>
    			</div>
    		
    		</div>

		
		

   		   
</body>
</html>