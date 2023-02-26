<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Fruit Stand</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>

	<div class="fruitSalad">
		<table class="table">
			<tbody>
				<tr>
					<th> FRUIT </th>
					<th> PRICE </th>
				</tr>
				
					<c:forEach var="fruit" items="${fruitSalad}">
				<tr>
						<td>${fruit.name}</td>
						<td>$ ${fruit.price}</td>
						
				</tr>
				   </c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>