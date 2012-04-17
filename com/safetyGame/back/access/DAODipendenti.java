package access;
import condivisi.*;

public interface DAODipendenti{
   public Dipendente getInfo(String username);
   public void passD(String pass, String username);
   public void passA(String pass, String username);
   public void mailD(String mail, String username);
   public Punteggio getStat(String username);
   public Dipendente[] elencoDipendenti();
   public boolean aggiungiDipendente(String nome, String cognome, String codfis, String mail, String impiego);
   public boolean cancellaDipendente(String username);
   public void modNome(String username, String nome);
   public void modCognome(String username, String cognome);
   public void modCodFis(String username, String codfis);
   public void modUsername(String usernameOld, String username);
   public void modImpiego(String username, String impiego);
   public void trofei(String username, int n);
   public void reset(String username, String codfis, String mail);
}
