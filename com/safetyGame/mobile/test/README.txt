Repository del codice sorgente del front-end mobile.
Si prega di fare riferimento alle Norme di Progetto V3.0 per il suo utilizzo.

L'amministratore


-----

Libreria necessaria per compilare presente nella cartella lib

Classe
View/DashboardActivity.java
	onCreate(Bundle): creo grafica e gestisco elementi Button

View/DashboardLayout.java
	Classe (copyright Google) per la visualizzazione Dashboard a griglia con gestione dello spazio

View/DatiActivity.java
	onCreate(Bundle): creo grafica
	onOptionsItemSelected(MenuItem item): gestisco click sull'actionbar per tornare alla dashboard
	DatiTask: classe che estende AsynkTask, scarico i dati e popolo il layout

View/DomandaActivity.java
	onCreate(Bundle): creo grafica a seconda che l'Extra "Domanda" sia true o false (Quest) e gestisco elementi Button
	onOptionsItemSelected(MenuItem item): gestisco click sull'actionbar per tornare alla dashboard
	DomandaTask: classe che estende AsynkTask, scarico i dati relativi ad una domanda e popolo il layout
	QuestTask: classe che estende AsynkTask, scarico i dati relativi ad una quest e popolo il layout
	onActivityResult: gestisco risultati del barcode scanner

View/LoginActivity.java
	onCreate(Bundle): creo grafica e gestisco elementi Button
	LoginTask: classe che estende AsynkTask, invio i dati relativi login e se corretti avvio DashboardActivity

View/PunteggiActivity.java
	onCreate(Bundle): creo grafica
	onOptionsItemSelected(MenuItem item): gestisco click sull'actionbar per tornare alla dashboard
	PunteggiTask: classe che estende AsynkTask, scarico i dati e popolo il layout

View/TimerNotifica.java
	onStartCommand: viene chiamato all'avvio del servizio
	mUpdateTimeTask: runnable che avvia la notifica

Utils/BootReceiver
	onReceive: chiamato all'avvio del dispostivo

Utils/ConnectionUtils
	HttpCreateClient: Effettua la connessione, effettua il parsing dei dati e crea il relativo oggetto nel package Condivisi
	rootXML: restituisco la root dell'xml
	parseXML: effettua il parsing di un singolo dato

Utils/IntentIntegrator e IntentResult
	Classi che gestiscono il barcode scanner

Condivisi/Dati
Condivisi/Domanda
Condivisi/Punteggi
Condivisi/Quest

