<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<h1>Buyers Name: <c:out value="${name}"/> </h1>
		<h1>Item: <c:out value="${item}"/> </h1>
		<h1>Price: $<c:out value="${price}"/>0 </h1>
		<h1>Description: <c:out value="${description}"/> </h1>
		<h1>Production Facility: <c:out value="${vendor}"/> </h1>


</body>
</html>