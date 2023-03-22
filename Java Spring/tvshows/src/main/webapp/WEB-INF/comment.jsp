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
    <link rel="stylesheet" href="/CSS/comment.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/JS/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   
   		<div class="nav">
   			<div>
		   		<h1> Hello, <c:out value="${loggedUser.userName}"/></h1>
			    <h3>Comment on ${show.title}</h3>
   			</div>
 			<div>
		   		<h3><a href="/logout">Logout</a></h3>
		   		<h3><a href="/dashboard">Dashboard</a></h3>
	   		</div>
   		</div>
   		
   
    <div class="formContainer">
        <!-- FORM INPUT SECTION -->
        <form:form action="/shows/${show.id}/comment" method="POST" modelAttribute="comment">

			 <form:input path="creator" type="hidden" class="input" value="${loggedUser.userName}"/>
			  <form:errors path="creator" class="errors"/>
        
            <div class="sectionOne">
                <div class="formation">
                    <form:label path="text"> Comment: </form:label>	
                    <form:input path="text" type="" class="input" />
                </div>
                <div class="errors">
                    <form:errors path="text" class="errors"/>
                </div>
            </div>
        
            <div class="buttonContainer">		 		
                <button class="button" type="submit">Submit</button>
            </div>
        
        </form:form>

        <!-- END FORM INPUT SECTION -->
    </div>
   
  			<div class="comment">
		   		<h2>Comments:</h2>
				<c:forEach var="c" items="${show.comment}">
				<fmt:formatDate value="${c.createdAt}" var="formattedDate"
					type="date" pattern="hh:mm dd MMM yyyy" />
					<h4> ${c.text}  </h4>
					<p class="by" >Added by ${c.creator} at ${formattedDate}  </p>
				</c:forEach>
			</div>
   
   		   
</body>
</html>