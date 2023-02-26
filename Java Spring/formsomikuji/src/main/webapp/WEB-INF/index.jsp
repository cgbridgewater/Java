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

	<div class="container">
		<h3>Send an Omikuji</h3>
			<div class="wrapper">
			<form action="/omikuji/formdata" method="POST">
				<div class="number">
					<label>Pick any number between 5 to 25:</label>
					<input class="input" type="number" step="1" min="5" max="25" name="number">
				</div>
				<br/>
				<div class="city">
					<label>Enter the name of a city:</label>
					<input class="input"  type="text" name="city">
				</div>
				<br/>
				<div class="name">
					<label>Enter the name of a person:</label>
					<input class="input"  type="text" name="name">
				</div>
				<br/>
				<div class="hobby">
					<label>Enter professional endeavor or hobby: </label>
					<input class="input"  type="text" name="hobby">		
				</div>
				<br/>
				<div class="thing">
					<label>Enter any type of living thing: </label>
					<input class="input"  type="text" name="thing">		
				</div>
				<br/>
				<div class="hobby">
					<label>Say something nice to someone: </label>
					<input class="input"  type="text" name="phrase">		
				</div>
			 	<br/>
			 	<div class="buttonContainer">
					<label>Send and show a friend </label>	
					 		
				 	<button class="button" type="submit">Send!</button>
			 	</div>
			</form>
		</div>
	</div>
</body>
</html>