package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;

public class SqlDAOFactory extends DAOFactory{
   Indirizzo serverDomande;
   Indirizzo serverAzienda;
   SqlDAOLogin login;
   SqlDAODipendenti dipendenti;
   SqlDAODomande domande;
   SqlDAOPunteggi punteggi;
   SqlDAOBadge badge;
   public SqlDAOFactory(){}
   /*
    * while(rs.next())
            {
                System.out.println("id: " + rs.getString("id"));
                System.out.println("firstname: " + rs.getString("firstname"));
                System.out.println("lastname: " + rs.getString("lastname"));
                System.out.println("--------------------------------------");
            }
    */
   public boolean loginLimitato(String username, String password){
      //prende le credenziali dipendente e le controlla
      return login.loginLimitato(username,password);
   }
   public boolean login(String username, String password){
      //prende le credenziali utente e le controlla
      return login.login(username,password);
   }
   public Dipendente getInfo(String username){
      //preleva dal database tutte le info del dipendente
      return dipendenti.getInfo(username);
   }
   public Domanda getDomanda(String username){
      //ritorna una domanda
      return domande.getDomanda(username);
   }
   public void posticipa(String username){
      //posticipa il timer e salva la domanda
      domande.posticipa(username);
   }
   public void rispondi(String username, String risposta){
      //imposta la risposta data
      domande.rispondi(username, risposta);
   }
   public void passD(String pass, String username){
      //cambia la password dipendente
      dipendenti.passD(pass, username);
   }
   public void passA(String pass, String username){
      //cambia la password amministratore
      dipendenti.passA(pass, username);
   }
   public void mailD(String mail, String username){
      //cambia la mail dipendente
      dipendenti.mailD(mail, username);
   }
   public Punteggio getStat(String username){
      //prende i punteggi dipendente
      return punteggi.getStat(username);
   }
   public Dipendente[] elencoDipendenti(){
      //prende i vari dipendenti e li ritorna
      return dipendenti.elencoDipendenti();
   }
   public boolean aggiungiDipendente(String nome, String cognome, String codfis, String mail, String impiego){
      //aggiunge un dipendente
     return  dipendenti.aggiungiDipendente(nome, cognome, codfis, mail, impiego);
   }
   public boolean cancellaDipendente(String username){
      //cancella un dipendente
      return dipendenti.cancellaDipendente(username);
   }
   public void modNome(String username, String nome){
      //modifica il nome di un dipendente
      dipendenti.modNome(username, nome);
   }
   public void modCognome(String username, String cognome){
      //modifica il cognome di un dipendente    
      dipendenti.modCognome(username, cognome);
   }
   public void modCodFis(String username, String codfis){
      //modifica il codfis di un dipendente
      dipendenti.modCodFis(username, codfis);
   }
   public void modUsername(String usernameOld, String username){
      //modifica il l'username di un dipendente
      dipendenti.modUsername(usernameOld, username);
   }
   public void modImpiego(String username, String impiego){
      //modifica il l'impiego di un dipendente
      dipendenti.modImpiego(username, impiego);
   }
   public boolean trofei(String username, int n){
      //modifica il totale dei trofei di un dipendente
      return punteggi.trofei(username, n);
   }
   public void reset(String username, String codfis, String mail){
      //modifica la password generandola randomicamente
      dipendenti.reset(username, codfis, mail);
   }
   public Badge[] badgeD(String username){
      //mostra le badge le badge
      return badge.badgeD(username);
   }
   public Domanda[] domandeA(boolean interne){
      //mostra le domande all'AS
      return domande.domandeA(interne);
   }
   public void addDomanda(int id){
      //aggiunge una domanda
      domande.addDomanda(id);
   }
   public void remDomanda(int id){
      //rimuove una domanda
      domande.remDomanda(id);
   }
   public void logout(String username){
      //slogga l'utente
      login.logout(username);
   }
   
   public void setLogin(SqlDAOLogin dao){login=dao;}
   public void setLogin(SqlDAODipendenti dao){dipendenti=dao;}
   public void setLogin(SqlDAODomande dao){domande=dao;}
   public void setLogin(SqlDAOPunteggi dao){punteggi=dao;}
   public void setLogin(SqlDAOBadge dao){badge=dao;}
   public void setIndDomande(Indirizzo domande){serverDomande=domande;}
   public void setIndAzienda(Indirizzo azienda){serverAzienda=azienda;}
}