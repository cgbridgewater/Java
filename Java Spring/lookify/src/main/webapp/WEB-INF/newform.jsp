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
   
   		
   		
    <div class="formContainer">
   		    <h1>Add A New Song</h1>
        <!-- FORM INPUT SECTION -->
        <form:form action="/songs/add" method="POST" modelAttribute="newItem">
        
            <div class="sectionOne">
                <div class="formation">
                    <form:label path="artist">Artist  </form:label>	
                    <form:input path="artist" class="artist" type="text" name="artist"/>
                </div>
                <div class="errors">
                    <form:errors class="error"  path="artist"/>
                </div>
            </div>
        
            <div class="sectionTwo">
                <div class="formation">
                    <form:label path="rating">Rating  </form:label>	
                    <form:input path="rating" class="rating" type="number" step=".1" name="rating"/>
                </div>
                <div class="errors">
                    <form:errors class="error"  path="rating"/>
                </div>
            </div>
        
            <div class="sectionThree">
                <div class="formation">
                    <form:label path="title">Song Title  </form:label>	
                    <form:input path="title" class="title" type="title" name="title"/>
                </div>
                <div class="errors">
                    <form:errors class="error"  path="title"/>
                </div>
            </div>
        
            <div class="buttonContainer">		 		
                <button class="button" type="submit">Submit</button>
            </div>
        
        </form:form>

        <!-- END FORM INPUT SECTION -->
    </div>
   		
   		
   		
   		
   		
   		
   		
        <div class="buttonContainer">
			<h4><a href="/dashboard">dashboard</a></h4>
		</div>
		
		
		
</body>
</html>