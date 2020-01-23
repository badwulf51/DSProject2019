<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Edit Car</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
	<div align="center">
		<img src="logo.jpg" alt="Logo">
		
	</div>
	<div class="add">
		<c:forEach items="${cars}" var="car">
			<form action="CarEdit" method="post">
				<input type=hidden id="thisField" name="id" value="${car.id}">
				<label>Registration:</label><input type="text" name="reg" value="${car.reg}"><br>
				<label>Year:</label><br><input type="number" name="year" value="${car.year}"><br>
				<label>Make:</label><input type="text" name="make" value="${car.make}"><br>
				<label>Cost:</label><br><input type="number" name="cost" value="${car.cost}" step="0.01"><br> <input type="submit" value="Submit">
			</form>
		</c:forEach>
		<a href="/Web-Client">Homepage</a>
	</div>
	

</body>
</html>