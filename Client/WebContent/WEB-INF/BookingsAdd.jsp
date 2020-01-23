<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Add Booking</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
	<div align="center">
		<img src="logo.jpg" alt="Logo">
		<h1>Add Booking</h1>
	</div>
	<div class="add">
		<form action="BookingsAdd" method="post">
			<label>Car:</label><select id="selectedRecord" name="carID">
				<c:forEach items="${cars}" var="car" varStatus="status">
					<option value="${car.id} ${car.make} ${car.reg} ${car.year} ${car.cost}">${car.make} $${car.cost}</option>
				</c:forEach>
			</select><br><input type=hidden id="thisField" name="customerID">
			<label>Date:</label><br><input type="date" name="sdate"> - <input type="date"name="edate"><br>
			<label>Customer:</label><select id="selectedRecord" name="custID">
				<c:forEach items="${customers}" var="customer" varStatus="status">
					<option value="${customer.id} ${customer.first} ${customer.second} ${customer.number}">${customer.first} ${customer.second} ${customer.number}</option>
				</c:forEach>
			</select><br> <input type="submit" value="Submit">
		</form>
		<a href="/Web-Client">Homepage</a>
	</div>
</body>
</html>