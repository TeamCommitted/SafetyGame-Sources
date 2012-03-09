<?xml version="1.0" encoding="UTF-8"?>
<%@ page contentType="text/xml" %>
<% 
String user = request.getParameter("username");
String passw = request.getParameter("password");
%>
<response>
	<status>OK</status>
	<dati>
		<nome>Mario</nome>
		<cognome>Rossi</cognome>
	</dati>
</response>
