package com.safetyGame.back.condivisi;

/**
 * Classe che rappresenta un trofeo assegnato nel sistema
 * 
 * @author acornagl
 * @version v0.1
 * 
 */
public class TrofeoAssegnato extends Trofeo{
  private DataOra dataora;
  
  /**
   * Costruttore con parametri della classe TrofeoAssegnato
   * 
   * @param nome nome del trofeo
   * @param dataOra data e ora dell'assegnazione
   */
  public TrofeoAssegnato(String nome, DataOra dataOra) {
    super(nome);
    this.dataora = dataOra;
  }
  
  /**
   * Costruttore senza parametri della classe TrofeoAssegnato
   */
  public TrofeoAssegnato() {
    super(); // costruttore della classe Trofeo senza parametri
    this.dataora = null;
  }

  /**
   * metodo che consente di recuperare la data e l'ora di assegnazione
   * del trofeo
   * 
   * @return la data e l'ora di assegnazione del trofeo
   */
  public DataOra getDataora() {
    return dataora;
  }

  /**
   * metodo che consente di impostare la data e l'ora di assegnazione 
   * del trofeo
   * 
   * @param dataora data e ora da impostare
   */
  public void setDataora(DataOra dataora) {
    this.dataora = dataora;
  }
    
}
