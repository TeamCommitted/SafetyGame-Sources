package com.safetyGame.back.controller;
import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;
import java.util.Random;


import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Message.*;
import java.util.Properties;
/**
 * Classe che consente il recupero della password degli utenti, inviandogliela 
 * attraverso posta elettronica
 * 
 * @author acornagl
 * @author mdallapi
 * @version 0.2
 *
 */
public class GestioneRecupero{ 
   private DAODipendenti accessDip;
   private String porta;
   
   public GestioneRecupero(DAODipendenti accessDip){
       this.accessDip = accessDip;
       this.porta = "587"; //eventuale 465
   }
   
   /**
    * Metodo che consente ad un dipendente di resettare la propria password
    * @param dip dipendente che chiede il resete della password
    * @return true se l'operazione è andata a buon fine, false altrimenti
    */
   public boolean recuperoD(Recupero dip){
      String pass = generaPassCasuale();
      // send mail
      boolean esito = accessDip.resetD(dip, pass);
      if (esito) {
    	this.sendMail(dip.getEmail(), pass);
      }
      return esito;
   }
   
   /**
    * Metodo che consente ad un amministratore di resettare la propria password
    * @param amm amministratore che chiede il resete della password
    * @return true se l'operazione è andata a buon fine, false altrimenti
    */
   public boolean recuperoA(Recupero amm){
      String pass = generaPassCasuale();
      boolean esito = accessDip.resetA(amm, pass);
      if (esito) {
    	this.sendMail(amm.getEmail(), pass);
      }

      return esito;
   }
   
   /**
    * Metodo che si occupa di inviare una mail all'utente che ha richiesto il ripristino della password
    * @param destinatario indirizzo email del dipendente che ha richiesto il recupero
    * @param nuovaPass nuova password
    */
   public void sendMail(String destinatario, String nuovaPass){
     final String username = "teamcommitted@gmail.com";
	 final String password = "Pr0jectse";
          
	 Properties props = new Properties();
	 props.put("mail.smtp.auth", "true");
	 props.put("mail.smtp.starttls.enable", "true");
	 props.put("mail.smtp.host", "smtp.gmail.com");
	 props.put("mail.smtp.port", porta);//"587");

	 Session session = Session.getInstance(props,
	 new javax.mail.Authenticator() {
	   protected PasswordAuthentication getPasswordAuthentication() {
	     return new PasswordAuthentication(username, password);
	   }
	 });

	 try {
       Message message = new MimeMessage(session);
	   message.setFrom(new InternetAddress(username));
	   message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(destinatario));
	   message.setSubject("Recupero password");
	   message.setText("Ecco la sua nuova password per l'accesso al sistema:"
				+ "\n\n "+ nuovaPass);

	   Transport.send(message);
       System.out.println("Done");

	 } 
	 catch (MessagingException e) {
	  throw new RuntimeException(e);
	 }
   }
   
   /**
   * Metodo che genera in modo casuale una password
   * 
   * @return stringa che contiene la nuova password generata casualmente
   * 
   */   
   protected String generaPassCasuale(){
    String lettere[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"}; //toLowerCase
    String numeri[] = {"1","2","3","4","5","6","7","8","9","0"};
    String caratteri[] = {"@","#","*","+","?","^","%","&","/","$","!","+","-"};
    String pass="";
    Random rand= new Random();
    while (pass.length()<17){
        int scelta = rand.nextInt(3);
        if (scelta==0){
            int maiusc=rand.nextInt(2);
            int lettera=rand.nextInt(lettere.length);
            if (maiusc==0)
                pass+=lettere[lettera].toLowerCase();
            else
                pass+=lettere[lettera];
        }
        else{
            if (scelta==1){
                int numero=rand.nextInt(numeri.length);
                pass+=numeri[numero];
            }
            else{ //scelta == 2
                int carattere=rand.nextInt(caratteri.length);
                pass+=caratteri[carattere];
            }
        }
    }
    return pass;
   }
}
