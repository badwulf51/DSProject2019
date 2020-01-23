<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Cars</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
	<div align="center">
		<img src="logo.jpg" alt="Logo">
		<h1>Car Entries</h1>
		<table class="show">
			<tr>
				<th>ID Number</th>
				<th>Registration</th>
				<th>Year Of Manufacturing</th>
				<th>Make</th>
				<th>Cost</th>
				<th>Function</th>
			</tr>
			<c:forEach items="${cars}" var="car">
				<tr>
					<td>${car.id}</td>
					<td>${car.reg}</td>
					<td>${car.year}</td>
					<td>${car.make}</td>
					<td>$${car.cost}</td>
					<td><a href="CarEdit?id=${car.id}"> Edit </a> <a
						href="CarDelete?id=${car.id}"> Delete </a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="/Web-Client">Homepage</a>
	</div>

</body>
</html>