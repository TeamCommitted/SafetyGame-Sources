<%@ page import= "java.sql.*"%>
<%@ page import= "java.util.*"%>
<%@ page import= "java.lang.*"%>
<%@ page import= "javax.servlet.*"%>
<%@ page import= "java.io.*"%>
<%@ page language= "java" import="java.util.Date"%>

<%

	Cookie cookies [] = request.getCookies();
	String cookieName = null;
	String username = null;
	String ambito = null;
	
	if (cookies != null){
		cookieName = "username";
		for (int i = 0; i < cookies.length; i++) {
			if (cookies [i].getName().equals(cookieName)) {
				username = cookies[i].getValue();
				break;
			}
		}
		cookieName = "ambito";
		for (int i = 0; i < cookies.length; i++) {
			if (cookies [i].getName().equals(cookieName)) {
				ambito = cookies[i].getValue();
				break;
			}
		}
	}
	
	if ((username == null) || (ambito == null)) response.sendRedirect("login.jsp");
	else if (!(ambito.equals("Dipendente"))) response.sendRedirect("admin_page.jsp");
	else {
	
%>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//IT"
	"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="it">
<head>
	<title>Nuova Domanda</title>
	<link rel="stylesheet" href="style/reset.css" type="text/css" media="all" />
	<link rel="stylesheet" href="style/screen.css" type="text/css" media="handheld, screen, projection" />
	
</head>

<body>

	<div id = "header">
		<h1>SafetyGame - Nuova Domanda</h1>
	</div>


	<div id = "content">
		<h2>Stai rispondendo ad una nuova domanda</h2>
		<%
			// Qua bisogna ricavare le informazioni di una nuova domanda per l'utente.
		%>
	</div>


	<div id = "footer">

	</div>


</body>
</html>
<% } %>
