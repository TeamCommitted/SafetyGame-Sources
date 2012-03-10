package access.access;

public class SqlDAOFactory extends DAOFactory{
    Indirizzo serverDomande;
    Indirizzo serverAzienda;
    SqlDAOLogin login;
    SqlDAODipendenti dipendenti;
    SqlDAODomande domande;
    SqlDAOPunteggi punteggi;
    SqlDAOBadge badge;
    public SqlDAOFactory(){}
    
    public void setLogin(SqlDAOLogin dao){login=dao;}
    public void setLogin(SqlDAODipendenti dao){dipendenti=dao;}
    public void setLogin(SqlDAODomande dao){domande=dao;}
    public void setLogin(SqlDAOPunteggi dao){punteggi=dao;}
    public void setLogin(SqlDAOBadge dao){badge=dao;}
    public void setIndDomande(Indirizzo domande){serverDomande=domande;}
    public void setIndAzienda(Indirizzo azienda){serverAzienda=azienda;}
}