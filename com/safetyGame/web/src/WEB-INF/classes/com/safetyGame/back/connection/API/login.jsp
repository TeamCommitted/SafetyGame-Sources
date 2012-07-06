/*
 * Name: login.jsp
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
<% 
ApplicazioniConnection appC;
String user = request.getParameter("username");
String passw = request.getParameter("password");
boolean response = appC.login(user, passw);
%>
<response>
<%
if(response)
{ %>
	<status>OK</status>
<% }else{ %>
	<status>FAILED</status>
<% }
</response>
