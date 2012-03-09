package connection;
import controller.*;
import access.condivisi.*;

public class ApplicazioniConnection{
    GestioneDati dati;
    Parser parser;
    public ApplicazioniConnection(){}
    
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
}