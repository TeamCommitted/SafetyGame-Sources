<%@ page import= "java.sql.*"%>
<%@ page import= "java.util.*"%>
<%@ page import= "java.lang.Integer"%>
<%@ page import= "javax.servlet.*"%>
<%@ page import= "javax.servlet.http.*"%>
<%@ page import= "java.io.*"%>
<% 
	String username = request.getParameter("account_username"); // Ottengo lo username dal post
	String password = request.getParameter("account_password"); // Ottengo la psw dal post
	// Ottengo il valore del radio button
	String ambito = "fail";
	if (request.getParameter("radio").equals("radioD")) {
		ambito = "Dipendente";}
	if (request.getParameter("radio").equals("radioAA")) {
		ambito = "Amministratore Azienda";}
	if (request.getParameter("radio").equals("radioAS")) {
		ambito = "Amministratore Sicurezza";}
	
	
	// Qua va richiamata la funzione per controllare che i dati inseriti siano coerenti nel database
	boolean logged = true;
	// 
	
	
	// Imposto la sessione salvando username e password
	if (logged) {
		session.setAttribute("username", username);
		session.setAttribute("password", password);
	}
%>
	<%=username%><br /><%=password%><br /><%=ambito%><br />
    
<%  // Redirect a index.jsp
    String redirectURL = "http://localhost/examples/project/index.jsp";
    response.sendRedirect(redirectURL);
%>