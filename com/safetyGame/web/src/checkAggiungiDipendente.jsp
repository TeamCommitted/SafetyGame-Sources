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

<%@ include file="html/header_pre_title.html" %> 
Safety Game - Pannello Amministratore
<%@ include file="html/header_post_title.html" %> 
<%@ include file="html/menuaa.html" %> 
<%@ include file="html/menu_content.html" %> 

<% 
	String nome = request.getParameter("input_nome");
	String cognome = request.getParameter("input_cognome");
	String codfis = request.getParameter("input_codfis");
	String email = request.getParameter("input_email");
	String ruolo = request.getParameter("input_ruolo");
	
	Inizializzatore i = new Inizializzatore();
	WebConnection connection = i.getWeb();
	
	Punteggio punt = new Punteggio(0);
	Dipendente dip = new Dipendente();
	boolean operazioneRiuscita = false;
	//try {
		dip.setNome(nome);
		dip.setCognome(cognome);
		dip.setCodFiscale(codfis);
		dip.setEmail(email);
		dip.setRuolo(ruolo);
		dip.setPunteggio(punt);
		
		operazioneRiuscita = connection.aggiungiDipendente(dip);
	//}
	//catch (Exception e){ out.println("<h1>Errore nella comunicazione con il Back-end<h1>"); }
	
	if (operazioneRiuscita) {
		out.println("<span class=\"successo\">Nuovo Dipendente aggiunto con successo!</span>");
		out.println("<p>Hai inserito i seguenti dati:</p>");
		out.println("<p>Nome: "+nome+"</p>");
		out.println("<p>Cognome: "+cognome+"</p>");
		out.println("<p>Codice Fiscale: "+codfis+"</p>");
		out.println("<p>Email: "+email+"</p>");
		out.println("<p>Ruolo: "+ruolo+"</p>");
	}
	else { out.println("<span calss=\"successo\">Operazione fallita!</span>Ritentare o contattare l'Amministratore di sistema"); }
%>

<%@ include file="html/footer.html" %> 