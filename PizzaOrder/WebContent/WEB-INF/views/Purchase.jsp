<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Purchase</title>
</head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>

<h4>Welcome ${sessionScope.customer.name}</h4>
</br>
<c:if test="${sessionScope.customer ne null}">
<a href="logout">Log out</a>
</c:if>

<c:if test="${sessionScope.customer eq null}">
<a href="signin">Sign In</a>
</c:if>

<a href="showcart">Cart(${sessionScope.cart_total})</a>
</br>
${Cmsg}
</br>
Payment of Rs. ${param.pay} /- done successfully.
Your orders will be delivered to registered address within 30min.
Have a nice day.
Enjoy your Food.

</body>
</html>