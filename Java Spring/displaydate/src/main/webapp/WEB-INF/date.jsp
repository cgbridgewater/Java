<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date" import = "javax.servlet.*,java.text.*"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

	<div class="wrapper">
      <%
         Date dNow = new Date( );
         SimpleDateFormat ft = new SimpleDateFormat ("EEEE, MMM d, yyyy");
         out.print( "<h2 align=\"center\">" + ft.format(dNow) + "</h2>");
      %>
	</div>

	<div class="homeLink">
		<a href="/">Home</a>
	</div>	
	
	<div class="wrapper">
		<h3>dojo method</h3>
		<h1><c:out value="${date}"/></h1>
	</div>


</body>
</html>