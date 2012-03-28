package access.access;
import access.condivisi.*;

public interface DAOPunteggi{
   public Punteggio getStat(String username);
   public boolean trofei(String username, int n);
}
