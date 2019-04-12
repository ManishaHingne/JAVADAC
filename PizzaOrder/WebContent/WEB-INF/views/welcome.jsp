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


<c:if test="${sessionScope.customer ne null}">
<a href="logout">Log out</a>
</c:if>

<c:if test="${sessionScope.customer eq null}">
<a href="signin">Sign In</a>
</c:if>

<a href="showcart">Cart(${sessionScope.cart_total})</a>

<h5>${param.msg}</h5>
<h4>Welcome ${sessionScope.customer.name}</h4>






<ul>
<c:forEach var="type" items="${requestScope.type}">
		   <li><a href="types?type=${type}">${type}</a></li>
</c:forEach>
</ul>



<ul>
<c:forEach var="sub" items="${requestScope.subtype}">
<li>

<a href="types?type=${param.type}&category=${sub}">${sub}</a></li>
<c:if test="${sub eq param.category}">
<ul>

<c:forEach var="items" items="${category}">
<li>
		<a href="item?id=${items.id}">${items.name}</a>
		</br>${items.description}
</li>
</c:forEach>
</ul>
</c:if>
</c:forEach>
</ul>



	


</body>
</html>