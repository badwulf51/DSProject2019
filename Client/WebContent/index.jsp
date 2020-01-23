<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Booking Service</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
<div align="center">
	<img src="logo.jpg" alt="Logo">
	<h1>Car Hire Booking Service</h1>
	<table>
		<tr>
			<td>
				<form action="Customers" method="get">
					<input type="submit" value="Get all Customers" />
				</form>
			</td>
			<td>
				<form action="Cars" method="get">
					<input type="submit" value="Get all Cars" />
				</form>
			</td>
			<td>
				<form action="Bookings" method="get">
					<input type="submit" value="Get all Bookings" />
				</form>
			</td>
		</tr>
		<tr>
			<td>
				<form action="CustomerAdd" method="get">
					<input type="submit" value="Add a Customer" />
				</form>
			</td>
			<td>
				<form action="CarAdd" method="get">
					<input type="submit" value="Add a Car" />
				</form>
			</td>
			<td>
				<form action="BookingsAdd" method="get">
					<input type="submit" value="Add a Booking" />
				</form>
			</td>
		</tr>
	</table>
</div>
</body>
</html>