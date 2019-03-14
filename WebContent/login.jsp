<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h1>Mario - Login Page</h1>
	<form action="LoginServlet" method="POST">
		<label for="email">Email: </label>
		<input name="email" id="n1" type="text">
		<br><br>
		<label for="pword">Password: </label>
		<input name="pword" id="n2" type="password">
		<br><br>
		<input name="submit" type="submit" value="Submit">
	</form>
</body>
</html>