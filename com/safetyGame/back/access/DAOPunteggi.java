package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;

public interface DAOPunteggi{
   public Punteggio getStat(String username);
   public boolean trofei(String username, int n);
}
