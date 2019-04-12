<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Cart</title>

</head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<h4>Welcome ${sessionScope.customer.name}</h4>
	</br>
	<c:if test="${sessionScope.customer ne null}">
		<a href="logout">Log out</a>
	</c:if>

	<c:if test="${sessionScope.customer eq null}">
		<a href="signin">Sign In</a>
	</c:if>
	<table border="1">
		<thead>
		</thead>
		<tbody>
			<c:forEach var="items" items="${sessionScope.cart_items}">
				<tr>
					<td colspan="2">
						<h4 align="center">Pizza Details</h4>
						<tr>
							<td>Type</td>
							<td>${items.items.type}</td>
						</tr>
						<tr>
							<td>Name</td>
							<td>${items.items.name}</td>
						</tr>
						<tr>
							<td>Category</td>
							<td>${items.items.category}</td>
						</tr>
						<tr>
							<td>Size</td>
							<td>${items.sizes}</td>
						</tr>
						<tr>
							<td>Price</td>
							<td>${items.price}</td>
						</tr> </br>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<a href="types">Pizza Menu</a>
	<c:if test="${sessionScope.total_ammount ne null}">
		<h4>Total Payble Amount - Rs.${sessionScope.total_ammount}/-</h4>
		<c:if test="${sessionScope.customer ne null}">
			<a href="buy?pay=${sessionScope.total_ammount}">Purchase</a>
		</c:if>
		<c:if test="${sessionScope.customer eq null}">
			<a href="signin">Purchase</a>
		</c:if>
	</c:if>
	<c:if test="${sessionScope.total_ammount eq null}">
Please buy something to proceed further...
</c:if>
</body>
</html>