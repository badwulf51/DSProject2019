<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Add Customer</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
	<div align="center">
		<img src="logo.jpg" alt="Logo">
		<h1>Add Car</h1>
	</div>
	<div class="add">
		<form action="CustomerAdd" method="post">
			<label>First name:</label><input type="text" name="fname"><br> 
			<label>Last name:</label><input type="text" name="lname"><br> 
			<label>Phone Number:</label><br><input type="number" name="num"><br>
			<input type="submit" value="Submit">
		</form>
		<a href="/Web-Client"> Homepage </a>
	</div>
	

</body>
</html>