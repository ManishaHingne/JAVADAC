<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Admin Panel</title>

</head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
<c:if test="${sessionScope.admin ne null}">
<a href="logout">Log out</a>
</c:if>

<c:if test="${sessionScope.admin eq null}">
<a href="signin">Sign In</a>
</c:if>

<h4>Welcome ${sessionScope.admin.name}</h4>

<h3>${msg}</h3>

<a href="admin">Pending Orders</a></span>
<a href="admin?status=Dispatched">Dispatched Orders</a></span>
<a href="admin?status=All">All Orders</a>
<table>
<tbody>
<c:forEach var="orderdetail" items="${Alldetails}">



<tr>
<td>Customer name - </td><td>${orderdetail.customer.name}</td>
</tr>

<tr>
<td>Order Date - </td><td>${orderdetail.orderTime}</td>
</tr>

<tr>
<td>Status - </td><td>${orderdetail.status}</td>
</tr>

<tr>
<td colspan="2"><a href="orderdetails?id=${orderdetail.id}">Order details</a></td>
</tr>
<tr>
<td colspan="2"><br/></td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>