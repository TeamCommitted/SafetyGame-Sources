INSERT INTO Tipologia VALUES 
('Pompiere'),
('Magazziniere'),
('Dirigente'),
('Segretaria');

INSERT INTO Domanda
(ID,testo_domanda,tipologia,linkV,linkF,punteggio,tempo,ambito)
 VALUES 
(1,'Sei in fiamme?','Pompiere','nolinkV','nolinkF',50,5,'Pompiere'),
(2,'Sei a 90?','Segretaria','nolinkV','nolinkF',20,10,'Segretaria');

INSERT INTO Risposta VALUES
(1,'si'), (2,'no');

INSERT INTO Domanda_Risposta VALUES
(1,1,TRUE),(1,2,FALSE),(2,1,FALSE),(2,2,TRUE);