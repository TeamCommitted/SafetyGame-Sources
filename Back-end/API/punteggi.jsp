<?xml version="1.0" encoding="UTF-8"?>
<%@ page contentType="text/xml" %>
<% 
String user = request.getParameter("username");
String passw = request.getParameter("password");
%>
<response>
	<status>OK</status>
	<punteggi>
		<rispostedate>30</rispostedate>
		<rispostecorrette>25</rispostecorrette>
		<risposteerrate>5</risposteerrate>
		<punti>250</punti>
	</punteggi>
	<badges>
		<badge id="1">
			<img></img>
			<testo>Sei un super-pro degli incendi</testo>
		</badge>
		<badge id="2">
			<img></img>
			<testo>Sei un super-pro del primo soccorso</testo>
		</badge>
	</badges>
</response>
