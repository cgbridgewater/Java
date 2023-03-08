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
   
   
   
     	<div class="navi">
	   		<h1> Coding Dojo</h1>
	   		<h1> </h1>
		
   		    <h1> New Ninja Form</h1>			    
		
   		</div>
   
   
   
    <div class="formContainer">
        <!-- FORM INPUT SECTION -->
        <form:form action="ninjas/create" method="POST" modelAttribute="newNinja">
        
        	    <form:select class="input2" path="dojo">
        			<c:forEach  var="dojo" items="${allDojos}">
			            <!--- Each option VALUE is the id of the person --->
			            <form:option class="input2" value="${dojo.id}" path="dojo">
			            <!--- This is what shows to the user as the option --->
			                <c:out value="${dojo.name}"/>
			            </form:option>
			        </c:forEach>
			    </form:select>
        
            <div class="sectionOne">
                <div class="formation">
                    <form:label path="firstName">First Name </form:label>	
                    <form:input path="firstName" type="text" class="input" />
                </div>
                <div class="errors">
                    <form:errors path="firstName" class="errors"/>
                </div>
            </div>
        
           <div class="sectionTwo">
                <div class="formation">
                    <form:label path="lastName"> Last Name  </form:label>	
                    <form:input path="lastName" type="text" class="input" />
                </div>
                <div class="errors">
                    <form:errors path="lastName" class="errors"/>
                </div>
            </div>
        
           <div class="sectionThree">
                <div class="formation">
                    <form:label path="age"> Age </form:label>	
                    <form:input path="age" type="number" step="1" class="input" />
                </div>
                <div class="errors">
                    <form:errors path="age" class="errors"/>
                </div>
            </div>
            
            
            <div class="buttonContainer">		 		
                <button class="button" type="submit">Submit</button>
            </div>
        
        </form:form>

        <!-- END FORM INPUT SECTION -->
    </div>
    
           <div class="linkContainer">
 	          <a class="btn btn-light btn-outline-primary" href="/" role="button">Cancel</a>	 		
          </div>
   
   
</body>
</html>