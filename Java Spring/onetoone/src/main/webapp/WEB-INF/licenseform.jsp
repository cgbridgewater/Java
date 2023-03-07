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
   
   		
	<h1> Driver Details</h1>

    <div class="formContainer">
        <!-- FORM INPUT SECTION -->
        <form:form action="license/create" method="POST" modelAttribute="newLicense">
       	    <form:select path="person">
		        <c:forEach var="onePerson" items="${allDrivers}">
		            <!--- Each option VALUE is the id of the person --->
		            <form:option value="${onePerson.id}" path="person">
		            <!--- This is what shows to the user as the option --->
		                <c:out value="${onePerson.firstName}"/>
		                <c:out value="${onePerson.lastName}"/>
		            </form:option>
		        </c:forEach>
		    </form:select>
            <div class="sectionOne">
                <div class="formation">
                    <form:label path="number">License Number </form:label>	
                    <form:input path="number" class="input" type="text" name="number"/>
                </div>
                <div class="errors">
                    <form:errors class=""  path=""/>
                </div>
            </div>
            <div class="sectionTwo">
                <div class="formation">
                    <form:label path="expirationDate"> Expiration Date </form:label>	
                    <form:input path="expirationDate" class="input" type="text" name="expirationDate"/>
                </div>
                <div class="errors">
                    <form:errors class="errors"  path="expirationDate"/>
                </div>
            </div>
            <div class="sectionThree">
                <div class="formation">
                    <form:label path="state"> State </form:label>	
                    <form:input path="state" class="input" type="text" name="state"/>
                </div>
                <div class="errors">
                    <form:errors class="errors"  path="state"/>
                </div>
            </div>
        
            <div class="buttonContainer">		 		
                <button class="button" type="submit">Submit</button>
            </div>
        
        </form:form>

        <!-- END FORM INPUT SECTION -->
    </div>

 	<a id="home" href="/">Go Home</a>

   
</body>
</html>