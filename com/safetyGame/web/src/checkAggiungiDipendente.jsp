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
		out.println("<h1>Nuovo Dipendente aggiunto con successo!</h1>");
		out.println("Hai inserito i seguenti dati:<br>");
		out.println("Nome: "+nome+"<br>");
		out.println("Cognome: "+cognome+"<br>");
		out.println("Codice Fiscale: "+codfis+"<br>");
		out.println("Email: "+email+"<br>");
		out.println("Ruolo: "+ruolo+"<br>");
	}
	else { out.println("<h1>Operazione fallita!</h1>Ritentare o contattare l'Amministratore di sistema"); }
%>