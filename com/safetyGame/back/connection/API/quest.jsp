/*
 * Name: quest.java
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
<%@ page contentType="text/xml" %>
<% 
String user = request.getParameter("username");
String passw = request.getParameter("password");
%>
<response>
	<status>OK</status>
	<quest>
		<type>scan</type>
		<title>Incendio</title>
		<testo>Trova il primo estintore disponibile e scannerizza il barcode</testo>
	</quest>
</response>
