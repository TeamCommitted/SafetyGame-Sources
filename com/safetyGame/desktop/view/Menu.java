/*
 * Name: Menu.java
 * Package: com.safetygame.desktop.view
 * Author: Gabriele Facchin
 * Date: 
 * Version: 0.1
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120609 | Gabriele Facchin    | + Menu
 * |          |                     | + creaMenu
 * |          |                     | + finalize
 * |          |                     | + actionPerformed
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.desktop.view;
import com.safetyGame.desktop.logic.ControlMenu;
import com.safetyGame.desktop.logic.ControlLogin;
import com.safetyGame.desktop.logic.ControlNotifica;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.SystemTray.*;
import java.awt.TrayIcon.*;

/**
 * Classe che gestisce la grafica dell'icona e le interazioni tra le altre componenti grafiche. 
 * 
 * @author gfacchin
 * @version 0.1
 */
public class Menu implements ActionListener{
  private boolean loggato=false;
  private ControlMenu control;
  private SystemTray tray;
  private TrayIcon icon;
  private JPopupMenu menu;
  private JMenuItem login;
  private JMenuItem richiedi_domanda;
  private JMenuItem visualizza_punteggio;
  private JMenuItem visualizza_dati;
  private JMenuItem modifica_dati;
  private JMenuItem logout;
  private JMenuItem nascondi;
  private MouseEvent old;

  /**
   * Costruttore della classe Menu
   * 
   */
  public Menu(){//ControlMenu controllo){
    control=new ControlMenu();//controllo;
    try{
      tray=SystemTray.getSystemTray();
      Image img=Toolkit.getDefaultToolkit().getImage("com/safetyGame/desktop/view/icona.jpg");
      icon=new TrayIcon(img);
      tray.add(icon);
      icon.addMouseListener(new MouseAdapter()
      {
        public void mouseClicked(MouseEvent e){
          menu=creaMenu();
          menu.addFocusListener(new FocusAdapter()
          {
            public void focusLost(FocusEvent e){}
          });
          if (e.getButton()==3){
              menu.show(e.getComponent(), e.getX(), e.getY());
          }
        }
      });
    }
    catch(UnsupportedOperationException e){System.out.println("Le funzionalità minime, non sono disponibili. L'applicazione verra' chiusa"); System.exit(1);}
    catch(AWTException e){System.out.println("Le funzionalità minime, non sono disponibili. L'applicazione verra' chiusa"); System.exit(1);}
  }
 
  /**
   * metodo che istanza correttamente il menu, a seconda che il dipendente sia o meno loggato
   * 
   * @return JPopupMenu correttamente istanziato in base allo stato di login del dipendente
   */
  private JPopupMenu creaMenu(){
    JPopupMenu m= new JPopupMenu();
    if (!control.isLogged()){
      login = new JMenuItem("Login");
      login.addActionListener(this);
      m.add(login);
    }
    else{
      richiedi_domanda= new JMenuItem("Chiedi Domanda");
      visualizza_punteggio= new JMenuItem("Visualizza il tuo punteggio");
      visualizza_dati= new JMenuItem("Visualizza i tuoi dati");
      modifica_dati= new JMenuItem("Modifica i tuoi dati");
      logout= new JMenuItem("Logout");
      richiedi_domanda.addActionListener(this);
      visualizza_punteggio.addActionListener(this);
      visualizza_dati.addActionListener(this);
      modifica_dati.addActionListener(this);
      logout.addActionListener(this);
      m.add(richiedi_domanda);
      m.add(visualizza_punteggio);
      m.add(visualizza_dati);
      m.add(modifica_dati);
      m.add(logout);
    }
    nascondi= new JMenuItem("nascondi");
    nascondi.addActionListener(this);
    m.add(nascondi);
    return m;
  }
  
  /**
   * metodo che dealloca la SystemTray e chiude l'applicazione in modo corretto
   * 
   */
  public void finalize(){
    tray.getSystemTray().remove(icon);
    System.exit(0);
  }
  
  /**
   * metodo che gestisce le azioni che i menu devono intraprendere
   * 
   * @param ActionEvent e l'evento scatenato dal click su un pulsante
   */
  public void actionPerformed(ActionEvent e){
    if (e.getSource()==login){
      Login l = new Login(new ControlLogin());
      menu.setVisible(false);
    }
    else
      if (e.getSource()==nascondi){
        //System.exit(0);
        menu.setVisible(false);
      }
      else 
        if(e.getSource()==richiedi_domanda){
          control.richiediDomanda();
          menu.setVisible(false);
        }
        else
          if(e.getSource()==visualizza_punteggio){
            control.visualizzaPunteggio();
            menu.setVisible(false);
          }
          else 
            if(e.getSource()==visualizza_dati){
              control.visualizzaDati();
              menu.setVisible(false);
            }
            else
             if(e.getSource()==modifica_dati){
               control.modificaDati();
               menu.setVisible(false);
             }
             else{ //logout
               control.logout();
               menu.setVisible(false);
             }
  }
  
  public void main (String args []){
    //crea un oggetto menu
    //recupera i dati dal file txt, se non esiste chiede all'utente di inserirli
    //istanzia la connessione al back end
    //istanzia la sistem tray
    //chiede il login
    //fa partire il timer
    //quando il timer e` attivo:
    //se timer = 0 chiedi domanda con una notifica
    //invia posticipa al back-end oppure apri il browser con la domanda
  }
}
