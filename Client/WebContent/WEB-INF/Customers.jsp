<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Customers</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
	<div align="center">
		<img src="logo.jpg" alt="Logo">
		<h1>Customer Entries</h1>
		<table class="show">
			<tr>
				<th>ID Number</th>
				<th>First Name</th>
				<th>Second Name</th>
				<th>Phone Number</th>
				<th>Function</th>
			</tr>
			<c:forEach items="${customers}" var="customer">
				<tr>
					<td>${customer.id}</td>
					<td>${customer.first}</td>
					<td>${customer.second}</td>
					<td>${customer.number}</td>
					<td><a href="CustomersEdit?id=${customer.id}"> Edit </a> <a
						href="CustomersDelete?id=${customer.id}"> Delete </a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="/Web-Client"> Homepage </a>
	</div>
	

</body>
</html>