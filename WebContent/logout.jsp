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
<title>Logout Page</title>
</head>
<body>
	<h2>¿Estás seguro que quieres cerrar sesión?</h2>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Progma", "no-cache");
		response.setDateHeader("Expires", 0);
	%>
	<a href="signout.jsp">
		<button type="submit">Logout</button></a>
</body>
</html>