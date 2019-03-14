<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Progma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
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
<title>Signout Page</title>
</head>
<body>
	<h2>Signout Page</h2>
	<% //Se destruye la sesión y se envía al usuario al login
		if (session.getAttribute("session_user")!=null){
			session.removeAttribute("session_user");
			request.getSession(false);
			session.setAttribute("session_user", null);
			session.invalidate();
			response.sendRedirect("login.jsp");
		}
	%>
</body>
</html>