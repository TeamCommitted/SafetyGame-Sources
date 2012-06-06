<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//IT"
	"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="it">
<head>
	<title>index</title>
	<link rel="stylesheet" href="style/reset.css" type="text/css" media="all" />
	<link rel="stylesheet" href="style/screen.css" type="text/css" media="handheld, screen, projection" />
	
</head>

<body>

	<div id = "header">
		<h1>SafetyGame - Benvenuti</h1>
	</div>


	<div id = "content">
		<h2>Home page</h2>
        
        <% 
			if (session.getAttribute("username") != null) {
				String redirectURL = "http://localhost/examples/project/user_page.jsp";
    			response.sendRedirect(redirectURL);
			}
			else {
		%>
		
		<div id = "form_login">
			
			<p class="form_info">
				Inserisci lo username e la password negli appositi spazi, sleziona il tuo ruolo ed effettua il login. 
			</p>
			<form id="form_box" title="Form per effettuare il login" action="checkLogin.jsp" onsubmit="" method="post">
				<fieldset>
					
					<label for="account_username">Username</label>			
					<input id="account_username" title="Casella di testo per lo username" type="text" name="account_username" onfocus="" value=""/>
					<label for="account_password">Password</label>
					<input id="account_password" title="Casella di testo per la password" type="password" name="account_password" onfocus=""/>
					
					
					<li>
						<input title="Seleziona se dipendente" type='radio' name="radio" value="radioD" checked="checked" /> 
						<label class="option_label" for="radioD">Dipendente</label>
					</li>
					<li>
						<input title="Seleziona se amministratore azienda" type='radio' name="radio" value="radioAA" /> 
						<label class="option_label" for="radioAA">Amministratore azienda</label>
					</li>
					<li>
						<input title="Seleziona se amministratore sicurezza" type='radio' name="radio" value="radioAS" /> 
						<label class="option_label" for="radioAS">Amministratore sicurezza</label>
					</li>
					
					<input id="account_login" class="button" title="Pulsante per l&apos;invio dei dati inseriti" type="submit" name="account_login" value="Entra" />
					
				</fieldset>
			</form>
			
			

			<p class ="form_info">
				Password dimenticata? <a href="" tabindex="5" accesskey="p">Recupera l'accesso</a>
			</p>
			
		</div>
        <%
			}
		%>
		
	</div>


	<div id = "footer">

	</div>


</body>
</html>
