/*
 * Name: domanda.java
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
<%@ page contentType="text/xml" import="com.safetyGame.back.connection.*"  %>
<%@page import="com.safetyGame.back.condivisi.*" %>
<% 
ApplicazioniConnection appC;
String user = request.getParameter("username");
String passw = request.getParameter("password");
boolean response = appC.login(user, passw);
Login l = Login(user, passw)
Domanda d = appC.mostraDomanda(l);
%>
<response>
<%
if(response)
{ %>
	<status>OK</status>
	<domanda>
		<% String tipo = d.getTipologia();
		{ %>
			<id><%d.getId()%></id>
			<type>tipo</type>
			<testo><%d.getTesto()%></testo>
			<punteggio><%d.getPunteggio().getPunti()%></punteggio>
			<corretta><%d.getCorretta()%></corretta>
		<% if(!tipo.equals("sino"))
		   {
			ArrayList<String> risposte = d.getRsiposte(); 
		%>
		<risposte num="<%i%>">
		<%	for(int i=0;i<risposte.size();i++)
			{	
		%>
				<risposta id="<%i%>"><%risposte.get(i)%></risposta>
			<% } %>
			</risposte>
		<% } %>
	</domanda>
<% }else{ %>
	<status>FAILED</status>
<% }		
</response>
