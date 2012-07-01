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

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//IT"
	"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="it">
<head>
	<title>Rimuovi Domande</title>
	<link rel="stylesheet" href="style/reset.css" type="text/css" media="all" />
	<link rel="stylesheet" href="style/screen.css" type="text/css" media="handheld, screen, projection" />
	
</head>

<body>

	<div id = "header">
		<h1>SafetyGame - Pannello Amministratore</h1>
        <a href="logout.jsp" class="logout">Logout</a>
	</div>


	<div id = "content">
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
			if ((ambito.equals("Dipendente"))) response.sendRedirect("user_page.jsp");			
		%>
        
        <% //Recupero le domande dal database ingDom
			Inizializzatore i = new Inizializzatore();
			WebConnection connection = i.getWeb();
			ArrayList elencoDomande = null;
			elencoDomande = connection.getElencoDomande();
			if (elencoDomande == null) out.println("<h2>Non sono disponibili altre domande da inserire</h2>");
			else {
		%>
        
        <h2>Aggiungi Domande</h2>
        <form id="rimuoviDomande" action="checkAggiungiDomande.jsp">
        	<fieldset>
            	<table>
                	<th>Selezione</th>
                    <th>Id</th>
                    <th>Anteprima</th>
                    <th>Tipologia</th>
                    <th>Ambito</th>
                    <% 
						int idDom;
						String antDom;
						String tipDom;
						String ambitoDom;
						Domanda domanda;
						for (int j = elencoDomande.size()-1; j >= 0; j--) { 
							domanda = (Domanda) elencoDomande.get(j);
							if (domanda.isInternaAzienda()) {
								out.println("<tr>");
								idDom = domanda.getId();
								antDom = domanda.getTesto();
								tipDom = domanda.getTipologia();
								ambitoDom = domanda.getAmbito();
								out.println("<td><input type=\"checkbox\" name=\"check"+j+"\" value=\""+idDom+"\" /></td>");
								out.println("<td>"+idDom+"</td>");
								out.println("<td>"+antDom+"</td>");
								out.println("<td>"+tipDom+"</td>");
								out.println("<td>"+ambitoDom+"</td>");
								out.println("</tr>");
							}
						}
					%>
                </table>
            	<%
					out.println("<input type=\"hidden\" name=\"numDomande\" value=\""+elencoDomande.size()+"\" />");
				%>
                <input type="submit" value="Rimuovi le domande selezionate" />
            </fieldset>
        </form>
        <%
			}
		%>
        
        
		
	</div>


	<div id = "footer">

	</div>


</body>
</html>