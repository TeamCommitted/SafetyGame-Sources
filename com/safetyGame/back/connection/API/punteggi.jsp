/*
 * Name: punteggi.java
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
Punteggio p = appC.getStat(user);
ArrayList<Badge> b = appC.getBadge(user, 2);
%>
<response>
<%
if(response)
{ %>
	<status>OK</status>
	<punteggi>
		<rispostedate><%p.getnDomRisp()%></rispostedate>
		<rispostecorrette><%p.getnRispCorr()%></rispostecorrette>
		<punti><%p.getPunti()%></punti>
	</punteggi>
	<badges num="<%b.size();%>">
	<% for(int i=0;i<b.size();i++)
	{  %>
		<badge id="<%i%>">
			<img></img>
			<testo><%b.get(i).getDescrizione()%></testo>
		</badge>
	<% } %>	
	</badges>
<% }else{ %>
	<status>FAILED</status>
<% }
</response>
