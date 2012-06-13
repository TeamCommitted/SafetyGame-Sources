package com.safetyGame.desktop.view;
import com.safetyGame.desktop.logic.ControlMenu;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu{
  private boolean loggato=false;
  private ControlMenu control;

  public Menu(){
    //inizializza tutti gli oggetti per il menu' grafico
  }
 
  public boolean creaIcon(){
    //metodo per creare la System Tray (ovvero creazione dell'oggetto ControlMenu)
    return true;
  }
  
  private void creaMenu(){
    //crea le varie voci del menu' (sia da loggato che da non loggato) e le connette alle corrette funzioni nella classe ControlMenu
  }
  
  public void chiediLogin(){
    //istanzia l'oggetto grafico della login e chiede di effettuare il login. 
  }
  
  public void creaNotifica(){
    //istanzia l'oggetto grafico per la notifica (dopo che e` stata generata l'eccezione di termine tempo
  }
  
  public void actionPerformed(ActionEvent e){
    //si occupa di gestire gli eventi del click
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
