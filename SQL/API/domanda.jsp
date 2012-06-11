<?xml version="1.0" encoding="UTF-8"?>
<%@ page contentType="text/xml" %>
<% 
String user = request.getParameter("username");
String passw = request.getParameter("password");
%>
<response>
	<status>OK</status>
	<domanda>
		<% int x = (int)(2*Math.random());
        	if(x==1)
		{ %>
			<type>sino</type>
			<title>Incendio</title>
			<testo>In caso di incendio nella sala server la prima cosa da fare è staccare la corrente?</testo>
		<% }else{ %>
			<type>rispostamultipla</type>
			<title>Videoterminali</title>
			<testo>La distanza degli occhi corretta cui porre lo schermo del proprio terminale è:</testo>
			<risposte num="3">
				<risposta id="1">30cm</risposta>
				<risposta id="2">60cm</risposta>
				<risposta id="3">90cm</risposta>
			</risposte>
		<% } %>
	</domanda>		
</response>
