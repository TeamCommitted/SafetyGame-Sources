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
	
	Inizializzatore i = new Inizializzatore();
	WebConnection connection = i.getWeb();
	Login l = new Login(username,password);	
	
	try {
		int risposta = Integer.parseInt(request.getParameter("group1")); 
		Domanda domanda = (Domanda) session.getAttribute("oggetto_domanda");
		domanda.setRispostaData(risposta);
		boolean rispostoConSuccesso = connection.setRisposta(l, domanda);
		out.println("<h1>La tua risposta è stata inviata con successo!</h1>");
	}
	catch(Exception e) {
		out.println("Errore - Impossibile recuperare la risposta dalla pagina precedente. Torna indietro e riprova");
	}
	
%>