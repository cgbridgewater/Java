<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

	
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>


<!-- YOUR own local CSS -->
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>

	<div class="wrapper">
		<h1>Welcome Page</h1>
		<p>Hello, <c:out value="${firstName}"/> <c:out value="${lastName}"/></p>
		<p>Contact Email: <c:out value="${email}"/></p>
		
	</div>





</body>
</html>