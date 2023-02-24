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
		

			<h1>Fruit of the day</h1>
			<h2> <c:out value="${first}"/> </h2>
			<h2> <c:out value="${last}"/> </h2>
			<h2> <c:out value="${email}"/> </h2>
			<h2> <c:out value="${age}"/> </h2>
			


</body>
</html>