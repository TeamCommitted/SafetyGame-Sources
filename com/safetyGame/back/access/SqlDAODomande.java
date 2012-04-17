package access;
import condivisi.*;

public class SqlDAODomande implements DAODomande{
   public SqlDAODomande(){}
    
   public Domanda getDomanda(String username){
      //ritorna una domanda
      return new Domanda();
   }
   public void posticipa(String username){
      //posticipa il timer e salva la domanda
   }
   public void rispondi(String username, String risposta){
      //imposta la risposta data
   }
   public Domanda[] domandeA(boolean interne){
      //mostra le domande all'AS
      Domanda[] d=new Domanda[1];
      return d;
   }
   public void addDomanda(int id){
      //aggiunge una domanda
   }
   public void remDomanda(int id){
      //rimuove una domanda
   }
}