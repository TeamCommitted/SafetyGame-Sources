package com.safetyGame.back.controller;
import com.safetyGame.back.access.*;
import com.safetyGame.back.condivisi.*;
import java.util.Random;


/*import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;*/

public class GestioneRecupero{ 
   private DAODipendenti accessDip;
   
   public GestioneRecupero(DAODipendenti accessDip){
       this.accessDip = accessDip;
   }
   
   /**
    * Metodo che consente ad un dipendente di resettare la propria password
    * @param dip dipendente che chiede il resete della password
    * @return true se l'operazione è andata a buon fine, false altrimenti
    */
   public boolean recuperoD(Recupero dip){
      String pass = generaPassCasuale();
      // send mail
      return accessDip.resetD(dip, pass);
   }
   
   /**
    * Metodo che consente ad un amministratore di resettare la propria password
    * @param amm amministratore che chiede il resete della password
    * @return true se l'operazione è andata a buon fine, false altrimenti
    */
   public boolean recuperoA(Recupero amm){
      String pass = generaPassCasuale();
      // send mail
      return accessDip.resetA(amm, pass);
   }
   
   /**
   * Metodo che genera in modo casuale una password
   * 
   * @return stringa che contiene la nuova password generata casualmente
   * 
   */   
   private String generaPassCasuale(){
    String lettere[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"}; //toLowerCase
    String numeri[] = {"1","2","3","4","5","6","7","8","9","0"};
    String caratteri[] = {"@","#","*","+","?","^","%","&","/","$","!","+","-"};
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
