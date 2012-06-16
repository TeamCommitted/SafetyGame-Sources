INSERT INTO Tipologia VALUES 
('Multipla');

INSERT INTO Domanda
(ID,testo_domanda,tipologia,linkV,linkF,punteggio,tempo,ambito,mobile)
 VALUES 
(1,'Quanti estintori ci vogliono in 10 m-quadri?','Multipla','','',15,30,'Pompiere',0),
(2,'Quanti dipendenti devono saper fare il massaggio cardiaco ogni 10?','Multipla','','',30,10,'Dirigente',0),
(3,'Bisogna usare il tornio con la grata abbassata?','Multipla','','',5,20,'Operaio',0);

INSERT INTO Risposta VALUES
(1,'si'), (2,'no'),(3,'1'),(4,'5'),(5,'3');

INSERT INTO Domanda_Risposta VALUES
(1,3,FALSE),(1,4,FALSE),(1,5,TRUE),(2,3,FALSE),(2,4,TRUE),(2,5,FALSE),(3,1,TRUE),(3,2,FALSE);
