<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Bookings</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
	<div align="center">
		<img src="logo.jpg" alt="Logo">
		<h1>Booking Entries</h1>
		<table class="show">
			<tr>
				<th>ID Number</th>
				<th>Date</th>
				<th>Name</th>
				<th>Number</th>
				<th>Registration</th>
				<th>Year Of Manufacturing</th>
				<th>Make</th>
				<th>Cost</th>
				<th>Function</th>
			</tr>
			<c:forEach items="${bookings}" var="booking" varStatus="status">
				<tr>
					<td>${booking.id}</td>
					<td>${booking.dateStart} to ${booking.dateEnd}</td>
					<td>${booking.first} ${booking.second}</td>
					<td>${booking.number}</td>
					<td>${booking.reg}</td>
					<td>${booking.year}</td>
					<td>${booking.make}</td>
					<td>$${booking.cost}</td>
					<td>
					<a href="BookingsEdit?id=${booking.id}">Edit</a>
					<a href="BookingsDelete?id=${booking.id}&cusid=${booking.customerID}">Delete </a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<a href="/Web-Client">Homepage</a>
	</div>
</body>
</html>