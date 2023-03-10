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
    <title>INDEX</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/CSS/style2.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/JS/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   
   <h1>${oneExpense.expenseName} Details</h1>
   
   <div class="viewOneContainer">
	   
	   <div class="flexControl">
	   <h3>Expense Name: </h3>
	   <h3 class="rightSide">${oneExpense.expenseName}</h3>
	   </div>
	   
	   
	   <div class="flexControl">
	   <h3>Amount Spent: </h3>
	   <h3 class="rightSide">$<fmt:formatNumber type="number" minFractionDigits="2" value="${oneExpense.amount}"></fmt:formatNumber></h3>
	   </div>
	   
	   
	   <div class="flexControl">
	   <h3>Vendor:</h3>
	   <h3 class="rightSide">${oneExpense.vendor}</h3>
	   </div>
	   
	   
	   <div>
	   <h3>Expense Description:</h3>
	   <h4>${oneExpense.description}</h4>
	   </div>
	 
   </div>
		<div class="buttonContainer">	
			<a href="/"><button class="button" type="submit">Go Home</button></a>	 		
	 	</div>
   
   
</body>
</html>