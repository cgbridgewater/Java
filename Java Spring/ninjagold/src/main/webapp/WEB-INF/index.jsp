<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Schrute Bucks</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<!-- YOUR own local CSS (MAKE SURE THESE MATCH YOUR FOLDER PATHS!!) -->  
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>


</head>
<body>


		<div class="mainFrame">
			<!-- gold counter row -->
			<div class="counterWrap"> 
				<div class="counter">
					<h3>Your Schrute Bucks: </h3>
					<h3 class="counterBox"><c:out value="${counter}"/>  </h3>
				</div>
				<img class="fit-picture"
     src="https://preview.redd.it/n6pcf1qcxpoz.jpg?width=640&crop=smart&auto=webp&s=efd58d1e3bf5cbbdbca1a653ffef1ca4bd49e99d"
     alt="schruteBuck">
			</div>
			<!-- row of gold mining boxes -->
			<!-- farm -->
			<div class="cardHolder">
			
				<div class="earnCard">
					<h3 class="task">Clean Desk</h3>
					<p class="task">earns 10-20 Schute Bucks </p>
					<form action="/earn" method="POST">
						<input class="input"  type="hidden" name="input" value="desk">
						<div class="buttonbox">
							<button class="button" type="submit">Earn Bucks!</button>	
						</div>
					</form>
				</div>
				
				<div class="earnCard">
					<h3 class="task">Catch Bat</h3>
					<p class="task">earns 5-10 Schute Bucks </p>
					<form action="/earn" method="POST">
						<input class="input"  type="hidden" name="input" value="bat">
						<div class="buttonbox">
							<button class="button" type="submit">Earn Bucks!</button>	
						</div>
					</form>	
				</div>
				
				<div class="earnCard">
					<h3 class="task">Grow Beets</h3>
					<p class="task">earns 10-20 Schute Bucks </p>
					<form action="/earn" method="POST">
						<input class="input"  type="hidden" name="input" value="beets">
						<div class="buttonbox">
							<button class="button" type="submit">Earn Bucks!</button>	
						</div>
					</form>		
				</div>
				
				<div class="earnCard">
					<h3 class="task">Make Sale</h3>
					<p class="task">earns 0-50 Schute Bucks </p>
					<form action="/earn" method="POST">
						<input class="input"  type="hidden" name="input" value="sale">
						<div class="buttonbox">
							<button class="button" type="submit">Earn Bucks!</button>	
						</div>
					</form>		
				</div>
			</div>
			
			<div class="activities">Activies:</div>
			<div class="activityBox">
				
			</div>
			
			
		</div>
		
		
		<div></div>
			

















</body>
</html>