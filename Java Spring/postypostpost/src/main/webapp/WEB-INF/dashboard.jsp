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
    		
    			
    			
    			
		<!-- Table Display SECTION -->
		<div class="tableContainer">
    				<h1> Your Posts </h1>
			<table id="displayTable"  class="table .table-hover">
				<thead>
					<tr class="">
						<th scope="col"> </th>
					</tr>
				</thead>
				<tbody>
				<!-- Loop to iterate expense list -->
				<c:forEach var="post" items="${user.posts}">
		    				
					<tr>
						<td>
		    					<h3><c:out value="${post.title}"/></h3>	
						</td>
					</tr>
		    			
				</c:forEach>
				<!-- END Loop to iterate expense list -->
				</tbody>
			</table>
            <!-- END Table Display SECTION -->
		</div>
    			
    			
    			
    			
    			
    			
    			
    			
    			
    			
    			
    		
    			

					<!-- Table Display SECTION -->
					<div class="tableContainer">
    				<h1> All Posts </h1>
						<table id="displayTable"  class="table .table-hover">
							<thead>
								<tr class="">
									<th ></th>
									<th >Give Likes </th>
									<th >Likes</th>
								</tr>
							</thead>
							<tbody>
							<!-- Loop to iterate expense list -->
							<c:forEach var="post" items="${allPosts}">
								<tr>
									<td>
										<h3><a href="/post/${post.id}">
											<c:out value="${post.title}" />
										</a></h3>
									</td>
									<td>
										<c:if test="${post.createdBy.id != idInSession}">
											<h4><a class="like" href="post/${post.id}/like"> ♡like♡</a></h4>
										</c:if>
									</td>
									<td><h4><c:out value="${post.likedBy.size()}"/> ♡'s</h4></td>
								</tr>
							</c:forEach>
							<!-- END Loop to iterate expense list -->
							</tbody>
						</table>
			            <!-- END Table Display SECTION -->
					</div>
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		</div>

		
		

   		   
</body>
</html>