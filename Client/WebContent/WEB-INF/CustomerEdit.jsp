<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Edit Customer</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
	<div align="center">
		<img src="logo.jpg" alt="Logo">
		<h1>Edit Customer</h1>
	</div>
	<div class="add">
		<c:forEach items="${customers}" var="customer">
			<form action="CustomersEdit" method="post">
				<input type=hidden id="thisField" name="id" value="${customer.id}">
				<label>First name:</label><input type="text" name="fname"value="${customer.first}"><br> 
				<label>Last name:</label><input type="text" name="lname" value="${customer.second}"><br>
				<label>Phone Number:</label><br><input type="number" name="num" value="${customer.number}"><br> <input type="submit" value="Submit">
			</form>
		</c:forEach>

		<a href="/Web-Client">Homepage</a>
	</div>
</body>
</html>