<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Order Details</title>
</head>
<body>
	<c:set var="oid" value="0" />

	<c:if test="${sessionScope.admin ne null}">
		<a href="logout">Log out</a>
	</c:if>

	<c:if test="${sessionScope.admin eq null}">
		<a href="signin">Sign In</a>
	</c:if>

	<h4>Welcome ${sessionScope.admin.name}</h4>

	Customer-${cust.name}
	<br /> mobile-${cust.mobile}
	<br /> address-${cust.address}
	<br />
	<br />
	<br />


	<br />
	<br />
	<%-- ${custOrders} --%>
	<c:forEach var="od" items="${custOrders}">
		<br />
		<c:set var="oid" value="${od.orders.id}" />

Category-${od.pricing.items.category}
<br />
Item-${od.pricing.items.name}
<br />
Size-${od.pricing.sizes}
<br />
	</c:forEach>
	<br />
	<br />
	<c:if test="${status eq 'pending'}">
<a href="dispatch?oid=${oid}">Dispatch orders</a>
</c:if>
	<a href="admin">Orders</a>

</body>
</html>