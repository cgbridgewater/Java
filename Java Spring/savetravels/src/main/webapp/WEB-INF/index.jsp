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
    <link rel="stylesheet" href="/CSS/style.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/JS/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   
   <h1>Save Travels</h1>
 		<!-- Table Display SECTION -->
  		<div class="tableContainer">
		   <table class="table .table-hover">
			  <thead>
			    <tr>
			      <th scope="col">Expense</th>
			      <th scope="col">Vendor</th>
			      <th scope="col">Amount</th>
			    </tr>
			  </thead>
			  <tbody>
			  <!-- Loop to iterate expense list -->
			  <c:forEach var="expense" items="${allExpenses}">
			    <tr>
			      <td><a href="/expense/${expense.id}"><c:out value="${expense.expense}" /></a> </td>
			      <td><c:out value="${expense.vendor}" /> </td>
			      <td><c:out value="${expense.amount}" /> </td>
			    </tr>
			 </c:forEach>

			  </tbody>
			</table>
 		</div>
   
   		<h1>Add an Expense</h1>
   		<div class="formContainer">
   			<!-- FORM INPUT SECTION -->
   			<form:form action="/expense/new" method="POST" modelAttribute="expense">
   				
   				<!-- section ONE -->
   				<div class="sectionOne">
   					<div class="formation">
   						<form:label path="amount">  </form:label>	
   						<form:input path="amount" class="input" type="text" name="amount"/>
   					</div>
   					<div class="errors">
	   					<form:errors class="errors"  path="amount"/>
   					</div>
   				</div>
   			
   					<!-- section TWO -->
   				<div class="sectionTwo">
   					<div class="formation">
   						<form:label path="description">  </form:label>	
   						<form:input path="description" class="input" type="text" name="description"/>
   					</div>
   					<div class="errors">
	   					<form:errors class="errors"  path="description"/>
   					</div>
   				</div>
   			
   					<!-- section THREE -->
   				<div class="sectionThree">
   					<div class="formation">
   						<form:label path="expense">  </form:label>	
   						<form:input path="expense" class="input" type="number" step=".01" name="expense"/>
   					</div>
   					<div class="errors">
	   					<form:errors class="errors"  path="expense"/>
   					</div>
   				</div>
   			
   					<!-- section Four -->
   				<div class="sectionFour">
   					<div class="formation">
   						<form:label path="vendor">  </form:label>	
   						<form:input path="vendor" class="input" type="text" name="vendor"/>
   					</div>
   					<div class="errors">
	   					<form:errors class="errors"  path="vendor"/>
   					</div>
   				</div>
   			
			 	<div class="buttonContainer">		 		
				 	<button class="button" type="submit">Add Review!</button>
			 	</div>
   			
   			</form:form>
   		
   		
   		</div>
   
   
   
   
   
   	
   
</body>
</html>