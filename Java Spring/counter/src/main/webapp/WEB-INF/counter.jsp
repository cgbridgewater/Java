<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<!-- YOUR own local CSS  (MAKE SURE THESE MATCH YOUR FOLDER PATHS!!)--> 
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>


	<div class="wrapper">
	 	<p class="welcome">You have visited The Home Page: <span class="counterValue"> <c:out  value="${hits}"/></span>   times  </p>
		<a href="/your_server">Home Page</a> 
		<br/>
		<a href="/your_server/plustwo">Add 2!</a>
	</div>
	<div class="wrapper">

		<button onclick="window.location.href='/your_server/reset';">RESET COUNTER</button>
	</div>


</body>
</html>