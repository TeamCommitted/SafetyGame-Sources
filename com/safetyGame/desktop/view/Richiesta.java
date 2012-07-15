/*
 * Name: Richiesta.java
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
 * | 20120714 | Gabriele Facchin    | + Richiesta
 * |          |                     | + errore
 * |          |                     | + actionPerformed
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.desktop.view;
import com.safetyGame.desktop.logic.ConnBack;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Classe che gestisce la richiesta di un nuovo server
 * 
 * @author gfacchin
 * @version 0.1
 */
public class Richiesta implements ActionListener{

  private JFrame frame;
  private JFrame frameerr;
  private JButton ok;
  private JButton ok2;
  private Label testo;
  private TextField server;
  
  /**
   * Costruttore della classe Richiesta
   * 
   */
  public Richiesta(){
    frame=new JFrame("Nuovo Server");
    frame.setSize(675,100);
    frame.setLayout(new GridLayout(2,2));
    testo= new Label();
    testo.setText("Inserire l'indirizzo del server SafetyGame dell' Azienda: ");
    frame.add(testo);
    server=new TextField();
    frame.add(server);
    ok = new JButton("Ok");
    frame.add(ok);
    ok.addActionListener(this);
    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    frame.setVisible(true);
  }
  
  /**
   * metodo che crea una finestra di errore (alert)
   * 
   * @param err la stringa d'errore mostrata a video
   */  
  private void errore(String err){
    frameerr=new JFrame("Errore");  
    frameerr.setLayout(new GridLayout(2,1));
    frameerr.setSize(150,70);
    Label errore=new Label();
    errore.setText(err);
    frameerr.add(errore);
    ok2=new JButton("Ok");
    frameerr.add(ok2);
    ok2.addActionListener(this);
    frameerr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    frameerr.setVisible(true);
  }

  /**
   * metodo che gestisce le azioni che i pulsanti devono intraprendere
   * 
   * @param ActionEvent e l'evento scatenato dal click su un pulsante
   */
  public void actionPerformed(ActionEvent e){
    if (e.getSource()==ok){
      if(server.getText().trim().equals("")){
        errore("Inserire un Server");
      }
      else{
        boolean salva=ConnBack.getInstance().continua(server.getText().trim());
        if (!salva){
          errore("Server non valido o errore nei files");
        }
        frame.setVisible(false);
        frame=null;
      }
    }
    else{ //ok2
        frameerr.setVisible(false);
        frameerr=null;
    }
  }
}
