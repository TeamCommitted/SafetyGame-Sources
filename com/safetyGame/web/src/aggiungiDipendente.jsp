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
	<title>Aggiungi Dipendente</title>
	<link rel="stylesheet" href="style/reset.css" type="text/css" media="all" />
	<link rel="stylesheet" href="style/screen.css" type="text/css" media="handheld, screen, projection" />
	
</head>

<body>

	<div id = "header">
		<h1>SafetyGame - Aggiungi Dipendente</h1>
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
        <form id="aggiungiDipendente" title="Form per l'aggiunta di un nuovo Dipendente" action="checkAggiungiDipendente.jsp" method="post">
        	<fieldset>
            	<ul>
                    <li><span class="etichetta">Nome:</span><input type="text" name="input_nome" /></li>
                    <li><span class="etichetta">Cognome:</span><input type="text" name="input_cognome" /></li>
                    <li><span class="etichetta">Codice fiscale:</span><input type="text" name="input_codfis" /></li>
                    <li><span class="etichetta">Email:</span><input type="text" name="input_email" /></li>
                    <li><span class="etichetta">Ruolo:</span><input type="text" name="input_ruolo" />
                    	<span id="attenzione">Attenzione! Inserire un ruolo gi&agrave; esistente!</span></li>
                </ul>
                <input type="submit" value="Aggiungi Dipendente" />
            </fieldset>
        </form>
        
		
	</div>


	<div id = "footer">

	</div>


</body>
</html>
