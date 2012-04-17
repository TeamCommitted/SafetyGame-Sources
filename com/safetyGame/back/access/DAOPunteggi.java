package access;
import condivisi.*;

public interface DAOPunteggi{
   public Punteggio getStat(String username);
   public boolean trofei(String username, int n);
}
