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
	Cookie cookies [] = request.getCookies();
	String cookieName = null;
	String username = null;
	String password = null;
	String ambito = null;
	boolean altreDomande = true;
	
	// Ottengo i dati dai cookies
	if (cookies != null){
		cookieName = "username";
		for (int i = 0; i < cookies.length; i++) {
			if (cookies [i].getName().equals(cookieName)) {
				username = cookies[i].getValue();
				break;
			}
		}
		cookieName = "password";
		for (int i = 0; i < cookies.length; i++) {
			if (cookies [i].getName().equals(cookieName)) {
				password = cookies[i].getValue();
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
		
		if ((username == null) || (ambito == null)) response.sendRedirect("login.jsp");
		else if (!(ambito.equals("Dipendente"))) response.sendRedirect("admin_page.jsp");
		else { // I cookie ritornano correttamente username, psw e ambito
			out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?><!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//IT\"\"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\"><html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"it\"><head><title>Nuova Domanda</title><link rel=\"stylesheet\" href=\"style/reset.css\" type=\"text/css\" media=\"all\" /><link rel=\"stylesheet\" href=\"style/screen.css\" type=\"text/css\" media=\"handheld, screen, projection\" /></head><body><div id = \"header\"><h1>SafetyGame - Nuova Domanda</h1></div>");
			out.println("<div id = \"content\">");
			Inizializzatore i = new Inizializzatore();
			WebConnection connection = i.getWeb();
			Login l = new Login(username,password);
			try {
                Domanda nuovadomanda = connection.mostraDomanda(l);
                String testo = nuovadomanda.getTesto();
                out.println(testo);
				out.println("<h2>Stai rispondendo ad una nuova domanda</h2>");
				out.println("<form id=\"form_domanda\" title=\"Form per rispondere a una domanda\" action=\"checkRisposta.jsp\" method=\"post\"><fieldset><ul>");
				ArrayList risposte = nuovadomanda.getRisposte();
				session.setAttribute("oggetto_domanda", nuovadomanda);
				String risposta;
				for (int j=0; j<risposte.size(); j++) {
					risposta = risposte.get(j).toString();
					out.println("<li><input type=\"radio\" name=\"group1\" value=\"" +(j+1)+ "\" />" +risposta+ "</li>");
				}
				out.println("</ul><input type=\"submit\" name=\"rispondi_domanda\" value=\"Invia la risposta\" /></fieldset></form>");
			}
			catch(Exception e) { out.println("<h2>Complimenti! Hai risposto a tutte le domande.</h2>"); }
			out.println("</div><div id = \"footer\"></div></body></html>");
		}
	}
	else { response.sendRedirect("login.jsp"); }	
%>
