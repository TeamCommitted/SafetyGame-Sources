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

<%@ include file="html/header_pre_title.html" %>
SafetyGame - Pannello utente
<%@ include file="html/header_post_title.html" %>
<%@ include file="html/menud.html" %> 
<%@ include file="html/menu_content.html" %> 
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
		%>
        <h2>Informazioni sull'account</h2>
        <%			
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
			int punt = p.getPunti();
						
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
<%@ include file="html/footer.html" %> 
