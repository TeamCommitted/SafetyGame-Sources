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
<%@ page contentType="text/xml" import="com.safetyGame.back.connection.*"  %>
<%@page import="com.safetyGame.back.condivisi.*" %>
<% 
ApplicazioniConnection appC;
String user = request.getParameter("username");
String passw = request.getParameter("password");
int id = request.getParameter("id");
int punti = request.getParameter("punti");
Punteggio p = Punteggio(p);
String risposta1 = request.getParameter("risposta1");
String risposta2 = request.getParameter("risposta2");
String risposta3 = request.getParameter("risposta3");
int corretta = request.getParameter("corretta");
int rispostaData = request.getParameter("rispostaData");
boolean response = appC.login(user, passw);
Login l = Login(user, passw)
ArrayList<String> r = new ArrayList<String>
r.add(risposta1);
r.add(risposta2);
r.add(risposta3);
Domanda d = (id, p, r, corretta, null, rispostaData, true, -1, null, -1);
boolean risposto = appC.rispondi(l, d);
%>
<response>
<%
if(response && risposto)
{ %>
	<status>OK</status>
<% }else{ %>
	<status>FAILED</status>
<% }		
</response>
