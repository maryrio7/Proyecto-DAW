<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	session = request.getSession();
	String email="";
	if(session.getAttribute("session_user")==null 
		|| session.getAttribute("session_user")=="" 
		|| session.getAttribute("session_user").equals("")){
		response.sendRedirect("login.jsp");
	} else{
		email = session.getAttribute("session_user").toString();
	}
	
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
	<h1>Bienvenido <%= email %></h1> 
	<br><br>
	<a href="logout.jsp">Click aquí para cerrar sesión</a>
</body>
</html>