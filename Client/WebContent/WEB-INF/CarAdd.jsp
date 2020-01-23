<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Add Car</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
	<div align="center">
		<img src="logo.jpg" alt="Logo">
		<h1>Add Car</h1>
	</div>
	<div class="add">
		<form action="CarAdd" method="post">
			<input type=hidden id="thisField" name="id"> 
			<label>Registration:</label><input type="text" name="reg"><br> 
			<label>Year:</label><br><input type="number" name="year"><br> 
			<label>Make:</label><input type="text" name="make"><br>
			<label>Cost:</label><br><input type="number" name="cost" step="0.01"><br>
			<input type="submit" value="Submit">
		</form>
		<a href="/Web-Client">Homepage</a>
	</div>
</body>
</html>