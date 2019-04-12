<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h4>Welcome ${sessionScope.customer.name}</h4>
	</br>
	<div align="right">
		<c:if test="${sessionScope.customer ne null}">
			<a href="logout">Log out</a>
		</c:if>
	</div>
	<div align="right">
		<c:if test="${sessionScope.customer eq null}">
			<a href="signin">Sign In</a>
		</c:if>
	</div>


	<a href="showcart">Cart(${sessionScope.cart_total})</a>

	</br> ${requestScope.item.name}
	</br> ${requestScope.item.type}
	</br> ${requestScope.item.category}
	</br> ${requestScope.item.description}
	</br>
	<form action="addcart" method="post">

		<c:forEach var="price" items="${requestScope.item.pricingList}">
			<div style="float: left">
				<input type="checkbox" name="ids" value="${price.id}"> </br>
				${price.sizes} </br> ${price.price}
			</div>
		</c:forEach>
		<input type="submit" value="Add to cart">
	</form>
	</br>

</body>
</html>