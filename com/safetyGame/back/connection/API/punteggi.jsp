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
<%@ page contentType="text/xml" import="com.safetygame.back.connection.*"  %>
<%@page import="com.safetygame.back.condivisi.*" %>
<%@page import="com.safetygame.back.*" %>
<%@page import="java.util.ArrayList" %>
<% 
Inizializzatore i = new Inizializzatore();
ApplicazioniConnection appC = i.getApp();
String user = request.getParameter("username");
String passw = request.getParameter("password");
boolean risposta = appC.login(user, passw);
Login l = new Login(user, passw);
Punteggio p = appC.getStat(l);
ArrayList<Badge> b = appC.getBadge(l, 2);
%>
<response>
<%
if(risposta)
{ %>
	<status>OK</status>
	<punteggi>
		<rispostedate><%=p.getnDomRisp()%></rispostedate>
		<rispostecorrette><%=p.getnRispCorr()%></rispostecorrette>
		<risposteerrate><%=p.getnDomRisp()-p.getnRispCorr()%></risposteerrate>
		<punti><%=p.getPunti()%></punti>
	</punteggi>
	<badges num="<%=b.size()%>">
	<% for(int z=0;z<b.size();z++)
	{  %>
		<badge id="<%=z%>">
			<img></img>
			<testo><%=b.get(z).getDescrizione()%></testo>
		</badge>
	<% } %>	
	</badges>
<% }else{ %>
	<status>FAILED</status>
<% } %>
</response>
