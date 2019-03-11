<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
</head>
<body>
	<h1>Sign-Up Page</h1>
	<form action="RegisterServlet" method="POST">
		<label for="fname">First Name: </label>
		<input name="fname" id="n1" type="text">
		<br><br>
		<label for="lname">Last Name: </label>
		<input name="lname" id="n2" type="text">
		<br><br>
		<label for="email">Email: </label>
		<input name="email" id="n3" type="text">
		<br><br>
		<label for="pword">Password: </label>
		<input name="pword" id="n4" type="password">
		<br><br>
		<input name="submit" type="submit" value="Submit">
	</form>
</body>
</html>