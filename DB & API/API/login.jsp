<?xml version="1.0" encoding="UTF-8"?>
<%@ page contentType="text/xml" %>
<% 
String user = request.getParameter("username");
String passw = request.getParameter("password");
%>
<response>
<%
if(user.equals("ciao") && passw.equals("lol"))
{ %>
	<status>OK</status>
<% }else{ %>
	<status>FAILED</status>
<% } %>
</response>
