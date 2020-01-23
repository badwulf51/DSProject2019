<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Booking Edit</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
	<div align="center">
		<img src="logo.jpg" alt="Logo">
		<h1>Edit Booking</h1>
	</div>
	<div class="add">
		<c:forEach items="${bookings}" var="booking">
			<form action="BookingsEdit" method="post">
				<input type=hidden id="thisField" name="id" value="${booking.id}">
				<input type=hidden id="thisField" name="carID" value="${booking.carID}"> <input type=hidden id="thisField" name="customerID" value="${booking.customerID}"> 
				<label>Date:</label><br><input type="date" name="sdate" value="${booking.dateStart}"> - <input type="date" name="edate" value="${booking.dateEnd}"><br>
				<label>First name:</label><input type="text" name="fname" value="${booking.first}"><br>
				<label>Last name:</label><input type="text" name="lname" value="${booking.second}"><br>
				<label>Phone Number:</label><br><input type="number" name="num" value="${booking.number}"><br> 
				<label>Registration:</label><input type="text" name="reg" value="${booking.reg}"><br>
				<label>Year:</label><br><input type="number" name="year" value="${booking.year}"><br>
				<label>Make:</label><input type="text" name="make" value="${booking.make}"><br>
				<label>Cost:</label><input type="text" name="cost" value="${booking.cost}"><br>
				<input type="submit" value="Submit">
			</form>
		</c:forEach>
		<a href="/Web-Client">Homepage</a>
	</div>
</body>
</html>