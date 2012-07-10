<%@page language="java" import="com.safetyGame.back.connection.*" %>
<%@page language="java" import="com.safetyGame.back.controller.*" %>
<%@page language="java" import="com.safetyGame.back.condivisi.*" %>
<%@page language="java" import="com.safetyGame.back.access.*" %>
<%@page language="java" import="com.safetyGame.back.*" %>
<%
	out.println("ASDFGHJ");
	Inizializzatore i = new Inizializzatore();
	WebConnection connection = i.getWeb();
	Login l = new Login("nick","pass");
	Punteggio p = connection.getPunteggio(l);
	int punt = p.getPuntiPrec();
	out.println(punt);
	
%>