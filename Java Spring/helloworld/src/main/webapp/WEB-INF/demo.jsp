<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Hello World</title>
</head>
<body>
		
			<span class="border border-danger">
		<h1>WORDS</h1>
			</span>
		
		

			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">First Name</th>
			      <th scope="col">Last Name</th>
			      <th scope="col">Email</th>
			      <th scope="col">Age</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr>
			      <th scope="row">1</th>
			      <td> <c:out value="${first}"/> </td>
			      <td> <c:out value="${last}"/> </td>
			      <td> <c:out value="${email}"/> </td>
			      <td> <c:out value="${age}"/> </td>
			    </tr>
			  </tbody>
			</table>








</body>
</html>