<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Registration</title>


</head>
<h2 align="center"><b>Reg form</b></h2>
<body>
			<h3 align="center">${requestScope.msg}</h3>
	<form action="registerpro" modelAttribute="Customer" method="post">
		<table align="center">

			<tr>
				<td>Name</td>
				<td><input path="name" name="name"/></td>
				
			</tr>
			<tr><br/></tr>
					<tr>
				<td>EmailId</td>
				<td><input path="email" name="email"/></td>
				
			</tr>
			<tr><br/></tr>
			<tr>
				<td>Address</td>
				<td><input path="address" name="address"/></td>
			</tr>
			<tr><br/></tr>
		<tr>
				<td>Mobile Number</td>
				<td><input path="mobile" name="mobile"/></td>
				
			</tr>
			<tr><br/></tr>
				<tr>
				<td>Password</td>
				<td><input path="password" name="password" /></td>
			</tr>
			<tr><br/></tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Register" /></td>
			</tr>
	</table>
	

</body>
</html>