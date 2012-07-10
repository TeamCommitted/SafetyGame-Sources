<%@ page import= "java.sql.*"%>
<%@ page import= "java.util.*"%>
<%@ page import= "java.lang.*"%>
<%@ page import= "javax.servlet.*"%>
<%@ page import= "java.io.*"%>
<%@ page language="java" import="java.util.Date"%>

<%@ include file="html/header_pre_title.html" %> 
Pannello Amministratore
<%@ include file="html/header_post_title.html" %> 

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
	if (ambito.equals("Amministratore Azienda")) { %>
    <%@ include file="html/menuaa.html" %> 
    <% } else { %>
    <%@ include file="html/menuas.html" %> 
    <% } %>


<%@ include file="html/menu_content.html" %> 
 
    <h2>Informazioni sull'account</h2>
    <%
        out.println("<p>Benvenuto ");
        out.println(username);
        out.println("</p><p>Hai effettuato il login come ");
        out.println(ambito);
        out.println("</p>");
    %>
        
<%@ include file="html/footer.html" %>
