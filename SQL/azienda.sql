SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS Amministratore;
DROP TABLE IF EXISTS Storico;
DROP TABLE IF EXISTS Dipendente;
DROP TABLE IF EXISTS Domanda;
DROP TABLE IF EXISTS Ruolo;
DROP TABLE IF EXISTS Badge;
DROP TABLE IF EXISTS Assegnato;
DROP TABLE IF EXISTS Tipologia;

CREATE TABLE Amministratore(
	ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	email VARCHAR(255) NOT NULL,
	nickname VARCHAR(25) NOT NULL,
	password CHAR(32) NOT NULL,
	passmod CHAR(32),
	datapass VARCHAR(19),
	codice_fiscale INT(11) NOT NULL,
	tipo_amministratore BOOL DEFAULT FALSE
)ENGINE=InnoDB;

CREATE TABLE Dipendente(
	ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	nome VARCHAR(255) NOT NULL,
	cognome VARCHAR(255) NOT NULL,
	codice_fiscale CHAR(16) NOT NULL,
	email VARCHAR(255) NOT NULL,
	nickname VARCHAR(25) UNIQUE NOT NULL,
	password CHAR(32) NOT NULL,
	passmod CHAR(32),
	ruolo VARCHAR(255),
	trofeo INT DEFAULT '0',
	
	FOREIGN KEY(ruolo) REFERENCES Ruolo(ruolo)
						ON UPDATE CASCADE
					
)ENGINE=InnoDB;

CREATE TABLE Storico(
	IDdomanda INT NOT NULL,
	IDdipendente INT NOT NULL,
	risposta BOOL DEFAULT FALSE,
	corretta BOOL DEFAULT FALSE,
	punteggio INT NOT NULL,
	
	PRIMARY KEY(IDdomanda, IDdipendente),
	FOREIGN KEY(IDdomanda) REFERENCES Domanda(ID)
							ON UPDATE CASCADE
							ON DELETE CASCADE,
	FOREIGN KEY(IDdipendente) REFERENCES Dipendente(ID)
							ON UPDATE CASCADE
							ON DELETE CASCADE
)ENGINE=InnoDB;

CREATE TABLE Domanda(
	ID INT PRIMARY KEY NOT NULL
)ENGINE=InnoDB;

CREATE TABLE Ruolo(
	ruolo VARCHAR(255) PRIMARY KEY NOT NULL
)ENGINE=InnoDB;


CREATE TABLE Assegnato(
	IDDipendente INT NOT NULL,
	IDBadge INT NOT NULL,
	il VARCHAR(19) NOT NULL,
	
	PRIMARY KEY (IDDipendente, IDBadge),
	
	FOREIGN KEY(IDDipendente) REFERENCES Dipendente(ID)
								ON UPDATE CASCADE
								ON DELETE CASCADE,
	FOREIGN KEY(IDBadge) REFERENCES Badge(ID)
							ON UPDATE CASCADE
							ON DELETE CASCADE
	
)ENGINE=InnoDB;

CREATE TABLE Badge(
	ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	nome VARCHAR(255) NOT NULL,
	descrizione VARCHAR(255) NOT NULL,
	soglia INT NOT NULL DEFAULT '10'
)ENGINE=InnoDB;

SET FOREIGN_KEY_CHECKS=1;
