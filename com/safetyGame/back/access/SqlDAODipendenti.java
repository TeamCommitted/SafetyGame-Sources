package com.safetyGame.back.access;
import com.safetyGame.back.condivisi.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SqlDAODipendenti implements DAODipendenti{
  private Indirizzo serverAzienda;

  public SqlDAODipendenti(Indirizzo azienda){
    serverAzienda=azienda;
  }
  
  public Dipendente getInfoD(Login l){
    String username = l.getUsername();
    String password = l.getPassword();
    ResultSet rs = serverAzienda.selezione("Dipendente as dip INNER JOIN Ruolo as r ON dip.ruolo=r.ruolo ","*", "nickname="+username); 
    String nome,cognome,codfis,email,ruolo,passmod;
    int ID,trofeo;
    try{
      ID = rs.getInt("ID");
      nome = rs.getString("nome");
      cognome = rs.getString("cognome");
      codfis = rs.getString("codfis");
      passmod = rs.getString("passmod");
      email = rs.getString("email");
      ruolo = rs.getString("ruolo");
      trofeo = rs.getInt("trofeo");
    }
    catch (SQLException e){return null;} 
    return new Dipendente(ID,codfis, nome,cognome,email,username,password,ruolo,trofeo,passmod);
  }
  
  public Dipendente getInfoA(Login l){
    String username = l.getUsername();
    String password = l.getPassword();
    ResultSet rs = serverAzienda.selezione("Amministratore","*", "nickname="+username); 
    int ID;
    String email,codfis,data;
    boolean amm;
    try{
      ID = rs.getInt("ID");
      email = rs.getString("email");
      data = rs.getString("datapass");
      codfis = rs.getString("codice fiscale");
      amm=rs.getBoolean("tipo amministratore");
    }
    catch (SQLException e){return null;}
    return new Dipendente();
  }
  
  public boolean resetPassD(Dipendente d){
    return serverAzienda.modificaRiga("Dipendente", "passmod=''","ID="+d.getId());
  }
  
  public boolean resetPassA(Dipendente d){
    return serverAzienda.modificaRiga("Amministratore", "passmod=''","ID="+d.getId());
  }
  
  public boolean passD(Dipendente d, String pass){
    return serverAzienda.modificaRiga("Dipendente", "password="+pass,"ID="+d.getId());
  }
  
  public boolean passA(Dipendente d, String pass){
    DataOra data=new DataOra();
    boolean b = serverAzienda.modificaRiga("Amministratore", "password="+pass,"ID="+d.getId());
    if (b){
      b=false;
      while (!b){
        b=serverAzienda.modificaRiga("Amministratore", "datapass="+data.toString(),"ID="+d.getId());
      }
    }
    return b;
  }
  
  public boolean mailD(Dipendente d, String mail){
    return serverAzienda.modificaRiga("Dipendente", "email="+mail,"ID="+d.getId());
  }
  
  public ArrayList<Dipendente> elencoDipendenti(){
    ResultSet rs=serverAzienda.selezione("Dipendenti","*","");
    ArrayList<Dipendente> d = new ArrayList<Dipendente>();
    boolean trovato = false;
    String nome,cognome,codfis,email,ruolo,username,password,passmod;
    int ID,trofeo;
    while(!trovato){
      try{
        ID = rs.getInt("ID");
        nome = rs.getString("nome");
        cognome = rs.getString("cognome");
        codfis = rs.getString("codfis");
        email = rs.getString("email");
        username = rs.getString("nickname");
        password = rs.getString("password");
        passmod = rs.getString("passmod");
        ruolo = rs.getString("ruolo");
        trofeo = rs.getInt("trofeo");
        Dipendente temp=new Dipendente(ID,codfis, nome,cognome,email,username,password,ruolo,trofeo,passmod);
        d.add(temp);      
        rs.next();
      }
      catch(SQLException e){trovato=true;}  
    }
    if (d.size()==0){d=null;}
    return d;
  }
  
  public boolean aggiungiDipendente(Dipendente d){
    //String nome, String cognome, String codfis, String mail, String impiego
    String param[]=new String[8];
    param[1]=d.getNome();
    param[2]=d.getCognome();
    param[3]=d.getCodFiscale();
    param[4]=d.getEmail();
    param[5]=d.getNickname();
    param[6]=d.getPassword();
    param[7]=d.getRuolo();
    param[8]=""+d.getPunteggio().getPunti();
    return serverAzienda.inserisciRiga("Dipendente","nome, cognome, codice fiscale, email, nickname, password, trofei",param);
  }
  
  public boolean cancellaDipendente(Dipendente d){
    return serverAzienda.cancellaRiga("Dipendente","ID="+d.getId()+" AND username="+d.getNickname()+" AND password ="+d.getPassword());
  }
  
  public boolean modNome(Dipendente d, String nome){
    return serverAzienda.modificaRiga("Dipendente","nome="+nome,"ID="+d.getId());
  }
  
  public boolean modCognome(Dipendente d, String cognome){
    return serverAzienda.modificaRiga("Dipendente","cognome="+cognome,"ID="+d.getId());
  }
  
  public boolean modCodFis(Dipendente d, String codfis){
    return serverAzienda.modificaRiga("Dipendente","codice fiscale="+codfis,"ID="+d.getId());
  }

  public boolean modUsername(Dipendente d, String username){
    return serverAzienda.modificaRiga("Dipendente","nickname="+username,"ID="+d.getId());
  }
  
  public boolean modImpiego(Dipendente d, String impiego){
    return serverAzienda.modificaRiga("Dipendente","ruolo="+impiego,"ID="+d.getId());
  }
  
  public boolean setTrofei(Dipendente d, int n){
    return serverAzienda.modificaRiga("Dipendente","trofei="+n,"ID="+d.getId());
  }
  
  public boolean resetD(Recupero r){
    return serverAzienda.modificaRiga("Dipendente","passmod="+generaPassCasuale(),"email="+r.getEmail()+" AND codice fiscale= "+r.getCodFiscale());
  }
  
  public boolean resetA(Recupero r){
    return serverAzienda.modificaRiga("Amministratore","passmod="+generaPassCasuale(),"email="+r.getEmail()+" AND codice fiscale= "+r.getCodFiscale());
  }
  
  private String generaPassCasuale(){
    String lettere[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"}; //toLowerCase
    String numeri[] = {"1","2","3","4","5","6","7","8","9","0"};
    String caratteri[] = {"@","#","°","*","+","?","^","£","%","&","/","$","!","+","-","§"};
    String pass="";
    Random rand= new Random();
    while (pass.length()<17){
      int scelta = rand.nextInt(3);
      if (scelta==0){
        int maiusc=rand.nextInt(2);
        int lettera=rand.nextInt(lettere.length);
        if (maiusc==0)
          pass+=lettere[lettera].toLowerCase();
        else
          pass+=lettere[lettera];
      }
      else{
        if (scelta==1){
          int numero=rand.nextInt(numeri.length);
          pass+=numeri[numero];
        }
        else{ //scelta == 2
          int carattere=rand.nextInt(caratteri.length);
          pass+=caratteri[carattere];
        }
      }
    }
    return pass;
  }
}
