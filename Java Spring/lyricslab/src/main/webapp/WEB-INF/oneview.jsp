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
    <title>View ${oneSong.title}</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/CSS/oneview.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/JS/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   
   		<div class="nav">
	   		<h1><c:out value="${oneSong.title}"/> </h1>
 			<div>
		   		<h3><a href="/logout">Logout</a></h3>
		   		<h3><a href="/dashboard">Dashboard</a></h3>
	   		</div>
   		</div>
   		
   		
    <div class="viewOneContainer">
        
        <div class="flexControl">
        <h3> Started By: </h3>
        <h3 class="rightSide">${oneSong.user.userName}</h3>
        </div>
        
        

        
        <div class="flexControl">
        <h3> Lyrics : </h3>
        <p class="rightSide">${oneSong.lyric}</p>
        </div>
        
        
        <div class="flexControl">
        <h3> Collaborators: </h3>
        </div>
        <c:forEach var="s" items="${oneSong.contributors}">
        <h3 > ${s.userName }</h3>
        </c:forEach>

    </div>
  

    <div class="linkLeft">	
        <h3><a href="/songs/${oneSong.id}/edit">Contribute to: ${oneSong.title}</a></h3>	 		
    </div>

	

   		
   		   
</body>
</html>