<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<!-- YOUR own local CSS (MAKE SURE THESE MATCH YOUR FOLDER PATHS!!) -->  
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>

</head>
<body>
	<div class="wrapper">
		<h3>Please Login</h3>
		<form action="/login" method="POST">
			<div class="firstName">
				<label>First Name:</label>
				<input class="input" type="text" name="firstName">
			</div>
			<br/>
			<div class="lastName">
				<label>Last Name:</label>
				<input class="input"  type="text" name="lastName">
			</div>
			<br/>
			<div class="email">
				<label>Email:</label>
				<input class="input"  type="text" name="email">
			</div>
			<br/>
			<div class="password">
				<label>Password: </label>
				<input class="input"  type="password" name="password">		
			</div>
		 	<br/>
		 	<div class="buttonContainer">
			 	<button class="button" type="submit">Submit</button>
		 	</div>
		</form>
	</div>

</body>
</html>