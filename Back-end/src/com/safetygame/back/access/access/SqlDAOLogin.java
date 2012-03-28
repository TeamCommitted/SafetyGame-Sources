package access.access;


public class SqlDAOLogin implements DAOLogin{
   public SqlDAOLogin(){}
    
   public boolean loginLimitato(String username, String password){
      //prende le credenziali dipendente e le controlla
      return true;
   }
   public boolean login(String username, String password){
      //prende le credenziali utente e le controlla
      return true;
   }
   public void logout (String username){}
}
