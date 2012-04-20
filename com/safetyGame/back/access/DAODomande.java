package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;

public interface DAODomande{
   public Domanda getDomanda(String username);
   public void posticipa(String username);
   public void rispondi(String username, String risposta);
   public Domanda[] domandeA(boolean interne);
   public void addDomanda(int id);
   public void remDomanda(int id);
}
