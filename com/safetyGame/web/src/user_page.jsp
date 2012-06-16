<%@ page import= "java.sql.*"%>
<%@ page import= "java.util.*"%>
<%@ page import= "java.lang.*"%>
<%@ page import= "javax.servlet.*"%>
<%@ page import= "java.io.*"%>
<%@ page language="java" import="java.util.Date"%>
<%@ page language="java" import="com.safetyGame.back.connection.*" %>
<%@ page language="java" import="com.safetyGame.back.controller.*" %>
<%@ page language="java" import="com.safetyGame.back.condivisi.*" %>
<%@ page language="java" import="com.safetyGame.back.access.*" %>
<%@ page language="java" import="com.safetyGame.back.*" %>
<%
	// WebConnection connection = new WebConnection
%>

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
        <p><a href="logout.jsp" class="logout">Logout</a></p>
        <p><a href="nuovaDomanda.jsp" class="nuovadomanda">Rispondi ad una nuova domanda</a></p>
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
			Inizializzatore i = new Inizializzatore();
			WebConnection connection = i.getWeb();
			Login l = new Login(username ,password);
			Punteggio p = connection.getPunteggio(l);
			int punt = p.getPuntiPrec();
						
			out.println("Il tuo punteggio &egrave; ");
			out.println(punt);
		%>
        
        <h2>Trofei e Badge</h2>
        <%
			// Funzione per ottenere l'elenco dei trovei e dei badge
			// getPunteggio(session.getAttribute("username"));
			ArrayList elencoTrofei = null;
			//elencoTrofei = connection.getBadge(l,10);
			//
			if (elencoTrofei == null) {
				out.println("Non hai guadagnato nessun trofeo.");
			}
			else {
				out.println("Segue l'elenco dei tuoi trofei:");
				out.println("<dl>");
				String nomebadge;
				String descrbadge;
				/*
				for (int i = elencoTrofei.size()-1; i >= 0; i--) { 
					nomebadge = elencoTrofei.get(i).getNome();
					descrbadge = elencoTrofei.get(i).getDescrizione();
					out.println("<dt>"+nomebadge+"</dt>");
					out.println("<dd>"+descrbadge+"</dd>");
				}
				*/
				out.println("</dl>");
			}
			
		%>
		
	</div>


	<div id = "footer">

	</div>


</body>
</html>