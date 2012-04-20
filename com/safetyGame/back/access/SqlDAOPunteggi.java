package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;

public class SqlDAOPunteggi implements DAOPunteggi{
   public SqlDAOPunteggi(){}
    
   public Punteggio getStat(String username){
      //prende i punteggi dipendente
      return new Punteggio();
   }
   public boolean trofei(String username, int n){
      //modifica il totale dei trofei di un dipendente
      return true;
   }
}

