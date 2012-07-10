/*
 * Name: rispondi.java
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
int id = Integer.parseInt(request.getParameter("id"));
int punti = Integer.parseInt(request.getParameter("punti"));
Punteggio p = new Punteggio(punti);
String risposta1 = request.getParameter("risposta1");
String risposta2 = request.getParameter("risposta2");
String risposta3 = request.getParameter("risposta3");
int corretta = Integer.parseInt(request.getParameter("corretta"));
int rispostaData = Integer.parseInt(request.getParameter("rispostaData"));
boolean risposta = appC.login(user, passw);
Login l = new Login(user, passw);
ArrayList<String> r = new ArrayList<String>();
r.add(risposta1);
r.add(risposta2);
r.add(risposta3);
Domanda d = new Domanda(id, p, "Multipla", r, corretta, null, rispostaData, true, -1, null, false);

boolean risposto = appC.rispondi(l, d);
%>
<response>
<%
if(risposta && risposto)
{ %>
	<status>OK</status>
<% }else{ %>
	<status>FAILED</status>
<% }	%>	
</response>