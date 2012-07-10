<%@ page import= "java.sql.*"%>
<%@ page import= "java.util.*"%>
<%@ page import= "java.lang.*"%>
<%@ page import= "javax.servlet.*"%>
<%@ page import= "java.io.*"%>
<%@ page language="java" import="java.util.Date"%>

<%@ include file="html/header_pre_title.html" %> 
SafetyGame - Aggiungi Dipendente
<%@ include file="html/header_post_title.html" %> 
<%@ include file="html/menuaa.html" %> 
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
			if (!(ambito.equals("Amministratore Azienda"))) response.sendRedirect("user_page.jsp");			
		%>
        <h2>Aggiungi Dipendente</h2>
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
                <input class="button" type="submit" value="Aggiungi Dipendente" />
            </fieldset>
        </form>
        
<%@ include file="html/footer.html" %> 
