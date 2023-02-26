<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji Form</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- YOUR own local CSS (MAKE SURE THESE MATCH YOUR FOLDER PATHS!!) -->  
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>

	<div>
			<h1>Here's Your Omikuji!!</h1>
		<div class="wrapper">
	
			<p>
			 	In <c:out value="${number}"/> years, you will live in 
				<c:out value="${city}"/> with 
				<c:out value="${name}"/> as your roomate, selling
				<c:out value="${hobby}"/> for a living. The next time you see a 
				<c:out value="${thing}"/>, you will have good luck. Also,
				<c:out value="${phrase}"/>
			</p>	
		</div>
		<div class="buttonbox">
			<a class="goHome" href="/omikuji">Go Back</a>
		</div>
		
		
	</div>
	
	
	
	
</body>
</html>