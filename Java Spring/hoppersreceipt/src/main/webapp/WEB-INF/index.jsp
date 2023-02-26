<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Breaking Hoppers Receipt</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>

		<div class="container">
			<h1>Buyers Name: <c:out value="${name}"/> </h1>
			<h3>Item: <c:out value="${item}"/> </h3>
			<h3>Price: $<c:out value="${price}"/>0 </h3>
			<h3>Description: <c:out value="${description}"/> </h3>
			<h3>Production Facility: <c:out value="${vendor}"/> </h3>
		</div>


</body>
</html>