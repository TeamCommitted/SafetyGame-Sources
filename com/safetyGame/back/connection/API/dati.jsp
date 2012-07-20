/*
 * Name: dati.java
 * Package: com.safetygame.back.connection.API
 * Author: Lorenzo Braghetto
 * Date: {Data di approvazione del file}
 * Version: 0.1
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120611 | Lorenzo Braghetto   | 
 * +----------+---------------------+----------------------
 * 
 */
<?xml version="1.0" encoding="UTF-8"?>
<%@ page contentType="text/xml" import="com.safetygame.back.connection.*"  %>
<%@page import="com.safetygame.back.condivisi.*" %>
<%@page import="com.safetygame.back.*" %>
<% 
ApplicazioniConnection appC = Inizializzatore.getApp();
String user = request.getParameter("username");
String passw = request.getParameter("password");
boolean risposta = appC.login(user, passw);
Login l = new Login(user, passw);
Dipendente d = appC.getDati(l);
%>
<response>
<%
if(risposta)
{ %>
	<status>OK</status>
	<dati>
		<nome><%=d.getNome()%></nome>
		<cognome><%=d.getCognome()%></cognome>
	</dati>
<% }else{ %>
	<status>FAILED</status>
<% } %>
</response>
