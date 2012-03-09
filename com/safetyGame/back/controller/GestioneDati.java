package controller;

public class GestioneDati{
    GestioneLog log;
    GestioneRecupero recupero;
    GestioneLogin login;
    GestioneDomandeD domandeD;
    GestioneDomandeAS domandeAS;
    GestioneDipendentiD dipendentiD;
    GestioneDipendentiAA dipendentiAA;
    GestioneBadgeD badgeD;
    GestioneBadgeAS badgeAS;
    GestionePunteggiD punteggiD;
    GestionePunteggiAA punteggiAA;
    
    public GestioneDati(){}
    
    
    public void setLog(GestioneLog l){log=l;}
    public void setRecupero(GestioneRecupero r){recupero=r;}
    public void setLogin(GestioneLogin l){login=l;}
    public void setDomandeD(GestioneDomandeD d){domandeD=d;}
    public void setDomandeAS(GestioneDomandeAS d){domandeAS=d;}
    public void setDipendentiD(GestioneDipendentiD d){dipendentiD=d;}
    public void setDipendentiAA(GestioneDipendentiAA d){dipendentiAA=d;}
    public void setBadgeD(GestioneBadgeD b){badgeD=b;}
    public void setBadgeAS(GestioneBadgeAS b){badgeAS=b;}
    public void setPunteggiAA(GestionePunteggiAA p){punteggiAA=p;}
}