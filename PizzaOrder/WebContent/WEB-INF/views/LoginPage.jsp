<?xml version="1.0" encoding="UTF-8" ?>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Login</title>

</STYLE>
</head>

<body>
	<h3 align="center">${requestScope.msg}</h3>
	<h3 align="center">${param.msg}</h3>
	<form modelAttribute="Customer" method="post">
		<table align="center"padding: 15px;">
			<tr>
				<br />
			</tr>
			<tr>
				<td>Email</td>
				<td><input path="email" name="email" /></td>

			</tr>
			<tr>
				<br />
			</tr>
			<tr>
				<td>Password</td>
				<td><input path="password" name="password" type="password"/></td>
			</tr>
			<tr>
				<br />
			</tr>
			<tr>

				<td align="center"><input type="submit" value="Login" /></td>
				
			</tr>
			
		</table>
		
	</form>
	<td> <BUTTON  onclick="location.href='registerpro';">Register</BUTTON></td>

</body>
</html>