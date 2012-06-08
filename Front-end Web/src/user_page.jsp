<%@ page import= "java.sql.*"%>
<%@ page import= "java.util.*"%>
<%@ page import= "java.lang.*"%>
<%@ page import= "javax.servlet.*"%>
<%@ page import= "java.io.*"%>
<%@ page language="java" import="java.util.Date"%>

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//IT"
	"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="it">
<head>
	<title>Pannello Utente</title>
	<link rel="stylesheet" href="style/reset.css" type="text/css" media="all" />
	<link rel="stylesheet" href="style/screen.css" type="text/css" media="handheld, screen, projection" />
	
</head>

<body>

	<div id = "header">
		<h1>SafetyGame - Pannello utente</h1>
        <a href="logout.jsp" class="logout">Logout</a>
	</div>


	<div id = "content">
    	<% // Stampo le informazioni sul tipo di account %>
		<h2>Informazioni sull'account</h2>
        <% 
			// Ottengo le informazioni dai cookies
			Cookie usernameCookie = null;
			Cookie passwordCookie = null;
			Cookie ambitoCookie = null;
			Cookie cookies [] = request.getCookies();
			String cookieName = null;
			String username = null;
			String password = null;
			String ambito = null;
			
			cookieName = "username";
			if (cookies != null){
				for (int i = 0; i < cookies.length; i++){
					if (cookies [i].getName().equals(cookieName)){
						usernameCookie = cookies[i];
						break;
					}
				}
				cookieName = "password";
				for (int i = 0; i < cookies.length; i++){
					if (cookies [i].getName().equals(cookieName)){
						passwordCookie = cookies[i];
						break;
					}
				}
				cookieName = "ambito";
				for (int i = 0; i < cookies.length; i++){
					if (cookies [i].getName().equals(cookieName)){
						ambitoCookie = cookies[i];
						break;
					}
				}
				try {
					username = usernameCookie.getValue();
					password = passwordCookie.getValue();
					ambito = ambitoCookie.getValue();
				}
				catch (Exception e) { response.sendRedirect("login.jsp"); }
			}
			else response.sendRedirect("login.jsp");
			if (!(ambito.equals("Dipendente"))) response.sendRedirect("admin_page.jsp");			
			
				out.println("<p>Benvenuto ");
				out.println(username);
				out.println("</p><p>Hai effettuato il login come ");
				out.println(ambito);
				out.println("</p>");
		%>
        
        <h2>Punteggi</h2>
        <%
			// Funzione per ottenere il punteggio di un dato utente
			// getPunteggio(username);
			int punteggio = 2046;
			//
			
			out.println("Il tuo punteggio &egrave; ");
			out.println(punteggio);
		%>
        
        <h2>Trofei e Badge</h2>
        <%
			// Funzione per ottenere l'elenco dei trovei e dei badge
			// getPunteggio(session.getAttribute("username"));
			String elencoTrofei = null;
			//
			if (elencoTrofei == null) {
				out.println("Non hai guadagnato nessun trofeo.");
			}
			else {
				out.println("Segue l'elenco dei tuoi trofei:");
				// Elenco dei badge / Trofei
			}
			
		%>
		
	</div>


	<div id = "footer">

	</div>


</body>
</html>