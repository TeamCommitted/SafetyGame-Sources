package access;


public interface DAOLogin{
   public boolean loginLimitato(String username, String password);
   public boolean login(String username, String password);
   public void logout (String username);
}
