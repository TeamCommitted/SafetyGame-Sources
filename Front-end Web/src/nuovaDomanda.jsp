<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//IT"
	"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="it">
<head>
	<title>Nuova Domanda</title>
	<link rel="stylesheet" href="style/reset.css" type="text/css" media="all" />
	<link rel="stylesheet" href="style/screen.css" type="text/css" media="handheld, screen, projection" />
	
</head>

<body>

	<div id = "header">
		<h1>SafetyGame - Nuova Domanda</h1>
	</div>


	<div id = "content">
    	<% // Stampo le informazioni sul tipo di account %>
		<h2>Informazioni sull'account</h2>
        <% 
			if (session.getAttribute("username") != null) {
				out.println("<p>Benvenuto ");
				out.println(session.getAttribute("username"));
				out.println("</p><p>Hai effettuato il login come ");
				out.println(session.getAttribute("ambito"));
				out.println("</p>");
			}
			else {
				String redirectURL = "http://localhost/examples/project/user_page.jsp";
    			response.sendRedirect(redirectURL);
			}
		%>
        
        <h2>Punteggi</h2>
        <%
			// Funzione per ottenere il punteggio di un dato utente
			// getPunteggio(session.getAttribute("username"));
			int punteggio = 2046;
			//
			
			out.println("Il tuo punteggio &egrave; ");
			out.println(punteggio);
		%>
        
        <h2>Trofei e Badge</h2>
        <%
			// Funzione per ottenere l'elenco dei trovei e dei badge
			// getPunteggio(session.getAttribute("username"));
			String elencoTrofei = null;
			//
			if (elencoTrofei == null) {
				out.println("Non hai guadagnato nessun trofeo.");
			}
			else {
				out.println("Segue l'elenco dei tuoi trofei:");
				// Elenco dei badge / Trofei
			}
		%>
		
	</div>


	<div id = "footer">

	</div>


</body>
</html>
