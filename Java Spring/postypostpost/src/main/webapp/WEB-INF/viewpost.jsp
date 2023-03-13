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
   
    	<div class="nav">
	   		<h1> Hello, <c:out value="${user.userName}"/> </h1>
	   		<div>
		   		<h3><a href="/logout">Logout</a></h3>
		   		<h3><a href="/dashboard">Home</a></h3>
	   		</div>
   		</div>
   		
   
   		<div class="content">
   			<h1> View Post: <c:out value="${post.title}"/> by <c:out value="${post.createdBy.userName}"/></h1>

			<p><c:out value="${post.text}"/></p>
			<p>
				<c:if test="${post.createdBy.id != idInSession}">
					<a href="/post/${post.id}/like">Like!  | </a>
				</c:if>
				
				<c:out value="${post.likedBy.size()}"/> Likes so far!
			</p>
			
		    <div class="formContainer">
       	 			<!-- FORM INPUT SECTION -->
			        <form:form action="/post/${post.id}/addcomment" method="POST" modelAttribute="comment">
			        
			            <div class="sectionOne">
			                <div class="formation">
			                    <form:label path="text"> Add Comment </form:label>	
			                    <br/>
			                    <form:textarea path="text" type="text" class="input" />
			                </div>
			            </div>
			        
			            <div class="buttonContainer">		 		
			                <button class="button" type="submit">Submit</button>
			            </div>
			        
			        </form:form>
			        <!-- END FORM INPUT SECTION -->
	    	</div>
			<ul>
				<c:forEach var="oneComment" items="${post.comments}">
					<li><c:out value="${oneComment.text}"/> - <c:out value="${oneComment.user.userName}"/></li>
				</c:forEach>			
			</ul>
			
			
   		
   		</div>




   
</body>
</html>