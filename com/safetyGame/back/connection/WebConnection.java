package connection;
import controller.*;
import access.condivisi.*;

public class WebConnection{
    GestioneDati dati;
    public WebConnection(GestioneDati d){dati=d;}
    
    public boolean login(String username, String password){return true;}
    
    public Dipendente getDati(String username){return new Dipendente();}
    
    public Punteggio getStat(String username){return new Punteggio();}
    
    public void modPass(String pass, String username){}
    
    public void modMail(String mail, String username){}
    
    public void resetPass(String username, String codfis, String mail){}
    
    public Domanda mostraDomanda(String username){return new Domanda();}
    
    public void posticipa(String username){}
    
    public boolean rispondi(String risposta){return true;}
    
    public void logout(String username){}
    
    public Domanda[] getElencoDomande(boolean interne){Domanda[] d=new Domanda[1]; return d;} 
    
    public void aggiungiDomanda(int id){}
    
    public void cancellaDomanda(int id){}
    
    public Dipendente[] getElencoDipendenti(){Dipendente[] d=new Dipendente[1]; return d;}
    
    public void setTrofei(int n){}
    
    public boolean aggiungiDipendente(String nome, String cognome, String codfis, String mail, String impiego){return true;}
    
    public boolean cancellaDipendente(String username){return true;}
    
    public void modNome(String nome){}
    
    public void modCognome(String cognome){}
    
    public void modCodFis(String codfis){}
    
    public void modUsername(String username){}
    
    public void modImpiego(String impiego){}
}