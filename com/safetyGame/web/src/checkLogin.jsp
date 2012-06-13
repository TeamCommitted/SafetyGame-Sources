<%@ page import= "java.sql.*"%>
<%@ page import= "java.util.*"%>
<%@ page import= "java.lang.*"%>
<%@ page import= "javax.servlet.*"%>
<%@ page import= "java.io.*"%>
<%@ page language="java" import="java.util.Date"%>
<% 
	String username = request.getParameter("account_username"); // Ottengo lo username dal post
	String password = request.getParameter("account_password"); // Ottengo la psw dal post
	// Ottengo il valore del radio button
	String ambito = null;
	if (request.getParameter("radio").equals("radioD")) {
		ambito = "Dipendente";}
	if (request.getParameter("radio").equals("radioAA")) {
		ambito = "Amministratore Azienda";}
	if (request.getParameter("radio").equals("radioAS")) {
		ambito = "Amministratore Sicurezza";}
	
	
	// Qua va richiamata la funzione per controllare che i dati inseriti siano coerenti nel database
	boolean logged = true;
	// 
	
	
	// Imposto i cookie salvando username, password e ambito utente
	// Purtroppo bisogna impostare un cookie per ogni dato
	if (logged) {
		Cookie usernameCookie = new Cookie ("username",username);
		Cookie passwordCookie = new Cookie ("password",password);
		Cookie ambitoCookie = new Cookie ("ambito",ambito);
		usernameCookie.setMaxAge(24 * 60 * 60); // 24h di validità
		passwordCookie.setMaxAge(24 * 60 * 60);
		ambitoCookie.setMaxAge(24 * 60 * 60);
		response.addCookie(usernameCookie);
		response.addCookie(passwordCookie);
		response.addCookie(ambitoCookie);
	}
	else out.println("<h1>Errore</h1>I dati che hai inserito non corrispondono. Controlla che i dati inseriti siano corretti");
	
	/*
	// Ricavo i dati dai cookies
	String cookieName = "username";
	Cookie cookies [] = request.getCookies();
	Cookie myUsernameCookie = null;
	if (cookies != null){
		for (int i = 0; i < cookies.length; i++){
			if (cookies [i].getName().equals(cookieName)){
				myUsernameCookie = cookies[i];
				break;
			}
		}
	}
	cookieName = "ambito";
	Cookie myAmbitoCookie = null;
	if (cookies != null){
		for (int i = 0; i < cookies.length; i++){
			if (cookies [i].getName().equals(cookieName)){
				myAmbitoCookie = cookies[i];
				break;
			}
		}
	}
	cookieName = "password";
	Cookie myPasswordCookie = null;
	if (cookies != null){
		for (int i = 0; i < cookies.length; i++){
			if (cookies [i].getName().equals(cookieName)){
				myPasswordCookie = cookies[i];
				break;
			}
		}
	}
	
	// Mostro a video i dati ricavati dai cookies
	// I cookie vengono effettivamente salvati sul client solo quando la pagina finisce di essere eseguita. 
	// Di conseguenza, per vedere effettivamente i valori di questi cookie bisogna ricaricare la pagina
	if (myUsernameCookie == null) { out.println("Il cookie username è inesistente"); }
	else out.println(myUsernameCookie.getValue());
	
	if (myPasswordCookie == null) { out.println("Il cookie password è inesistente"); }
	else out.println(myPasswordCookie.getValue());
	
	if (myAmbitoCookie == null) { out.println("Il cookie ambito è inesistente"); }
	else out.println(myAmbitoCookie.getValue());
	
	*/
%>
    
<%  // Redirect alla pagina successiva
	String redirectURL = "";
	// Se il login è di tipo Dipendente
    if (ambito.equals("Dipendente")) redirectURL = "http://localhost/examples/user_page.jsp";
	// Altrimenti, se è di tipo amministratore:
	else redirectURL = "http://localhost/examples/admin_page.jsp";
    response.sendRedirect(redirectURL);
%>