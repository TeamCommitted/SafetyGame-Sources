/*
 * Name: Login.java
 * Package: com.safetygame.desktop.view
 * Author: Gabriele Facchin
 * Date: 2012/06/16
 * Version: 1.0
 * Copyright: see COPYRIGHT
 * 
 * Changes:
 * +----------+---------------------+---------------------
 * |   Date   | Programmer          | Changes
 * +----------+---------------------+---------------------
 * | 20120610 | Gabriele Facchin    | + Login
 * |          |                     | + actionPerformed
 * |          |                     | + isVisible
 * +----------+---------------------|---------------------
 *
 */

package com.safetyGame.desktop.view;
import com.safetyGame.desktop.logic.ControlLogin;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Classe che gestisce la grafica per il login
 * 
 * @author gfacchin
 * @version 1.0
 */
public class Login implements ActionListener{
  
  private JFrame frame;
  private JButton ok;
  private JButton annulla;
  private JButton passdim;
  private Label userl;
  private Label passl;
  private Label errore;
  private TextField username;
  private TextField password;
  private ControlLogin controller;
  
  /**
   * Costruttore della classe Login
   * 
   */
  public Login(ControlLogin controllore){
    controller=controllore;
    frame=new JFrame("Login");
    frame.setSize(1300,200);
    frame.setLayout(new GridLayout(4,3));
    userl= new Label();
    userl.setText("Nickname:");
    frame.add(userl);
    username = new TextField();
    frame.add(username);
    Label vuoto=new Label();
    vuoto.setText("");
    frame.add(vuoto);
    passl = new Label();
    passl.setText("Password:");
    frame.add(passl);
    password = new TextField();
    frame.add(password);
    Label vuoto1=new Label();
    vuoto1.setText("");
    frame.add(vuoto1);
    ok = new JButton("OK");
    frame.add(ok);
    ok.addActionListener(this);
    annulla = new JButton("Annulla");
    frame.add(annulla);
    annulla.addActionListener(this);
    passdim = new JButton("Password dimenticata");
    passdim.addActionListener(this);
    frame.add(passdim);
    errore=new Label();
    errore.setText("");
    frame.add(errore);
    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    frame.setVisible(true);
  }

  /**
   * metodo che gestisce le azioni che i pulsanti devono intraprendere
   * 
   * @param ActionEvent e l'evento scatenato dal click su un pulsante
   */
  public void actionPerformed(ActionEvent e){
    if (e.getSource()==ok){
      if (!username.getText().trim().equals("") && !password.getText().trim().equals("")){
        boolean login=controller.tryLogin(username.getText().trim(), password.getText().trim());
        if (login){
          frame.setVisible(false);
          errore.setText("");
        }
        else 
          errore.setText("I dati inseriti non sono corretti!");
      }
      else
        errore.setText("Occorre inserire username e password per accedere al sistema");
    }
    else
     if (e.getSource()==annulla)
       frame.setVisible(false);
     else //password dimenticata
       if (!username.getText().trim().equals("")){
         boolean rigenera=controller.recupera(username.getText().trim());
         if (rigenera)
           errore.setText("Nuova password generata, si prega di controllare l'email");
         else
           errore.setText("Nuova password non generata, ricontrollare i dati inseriti");              
       }
       else
         errore.setText("occorre inserire il Nickname per richiedere una nuova password al sistema");
  }
  
  /**
   * Metodo che ritorna la visibilità del frame
   * 
   * @return boolean che indica se il frame è visibile (true) o non visibile (false)
   */  
  public boolean isVisible(){
    return frame.isVisible();
  }
}
