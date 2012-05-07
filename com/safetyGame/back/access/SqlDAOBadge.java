package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;
import java.sql.ResultSet;

public class SqlDAOBadge implements DAOBadge{
  public SqlDAOBadge(){}
   
  public Badge[] badgeD(String username, Indirizzo serverAzienda){
    ResultSet rs = serverAzienda.selezione("IDBadge, data","Assegnati","IDutente="+username);
    Badge [] b=new Badge[rs.length];
    int i=0;
    while(rs.next()){
      String nomeB = rs.getString("IDbadge");
      String data = rs.getString("data");
      //b[i]=Badge(nomeB,data);
      i++;
    }
    return b;
  }
}
