insert into Ruolo values ('Pompiere'),('Magazziniere'),('Dirigente'),('Segretaria'),('Operaio'),('Macchinista'),('Corriere'),('Autista'),('Mulettista');
insert into Dipendente(ID,nome,cognome,codice_fiscale,email,nickname,password,ruolo)values (1,'Alberto','Boi','sxrYDTCfvg','teamcommitted@gmail.com','nick','pass','Pompiere'),
(2,'Andrea','Marton','ndrmrt88l73f','marco.begolo@gmail.com','andrea.marton','pass','Magazziniere'),
(3,'Giacomo','Muriotto','mrtgcm88o88l','marco.begolo@gmail.com','giacomo.muriotto','pass','Operaio'),
(4,'Francesco','Zingarlini','zngfr98o88l','marco.begolo@gmail.com','francesco.zingarlini','pass','Dirigente'),
(5,'Giacomo','Zilio','zlgcm88o67t','marco.begolo@gmail.com','giacomo.zilio','pass','Operaio');
insert into Amministratore values (1,'teamcommitted@gmail.com','amministratoreAz','pass',null,'2012/06/11 12:23:32','esrdftgy',true),
(2,'marco.begolo@gmail.com','amministratoreSic','pass',null,'2012/06/11 23:23:32','esrdftgy',false);
insert into Badge values (1,'Re dei pompieri', 'Pompiere',100),
(2,'Re dei segretari', 'Segretaria',180),
(3,'Re dei dirigenti', 'Dirigente',250),
(4,'Re degli operai', 'Operaio',50),
(5,'Re delle risposte','TotaleRisposte',5),
(6,'Re delle risposte','TotalePunti',150);

insert into Assegnato values (1,1,'2012/06/14 12:13:45'),
(2,4,'2011/12/20 11:11:11'),
(3,4,'2012/08/28 21:31:11'),
(4,3,'2012/02/10 13:15:51');
insert into Domanda values (1),(2),(3),(4),(5),(6);
insert into Storico values (1,1,1,1,15),(2,1,3,1,30),(1,3,3,3,10);
