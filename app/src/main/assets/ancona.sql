BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS `tipi_servizi` (
	`_id`	VARCHAR NOT NULL,
	`immagine`	varchar ( 50 ) NOT NULL,
	PRIMARY KEY(`_id`)
);
INSERT INTO `tipi_servizi` VALUES ('Ospedali','android.resource://com.example.test.appancona/drawable/ospedale');
INSERT INTO `tipi_servizi` VALUES ('Stazione','android.resource://com.example.test.appancona/drawable/stazione');
INSERT INTO `tipi_servizi` VALUES ('Carabinieri','android.resource://com.example.test.appancona/drawable/carabinieri');
INSERT INTO `tipi_servizi` VALUES ('Farmacie','android.resource://com.example.test.appancona/drawable/farmacia');
INSERT INTO `tipi_servizi` VALUES ('Supermercati','android.resource://com.example.test.appancona/drawable/supermercato');
INSERT INTO `tipi_servizi` VALUES ('Ufficio Postale','android.resource://com.example.test.appancona/drawable/ufficio_postale');
CREATE TABLE IF NOT EXISTS `tipi_punti_interesse` (
	`_id`	VARCHAR NOT NULL,
	`immagine`	varchar ( 50 ) NOT NULL,
	PRIMARY KEY(`_id`)
);
INSERT INTO `tipi_punti_interesse` VALUES ('Monumenti Storici','android.resource://com.example.test.appancona/drawable/parthenon');
INSERT INTO `tipi_punti_interesse` VALUES ('Parchi e Aree Verdi','android.resource://com.example.test.appancona/drawable/iconaparchi');
INSERT INTO `tipi_punti_interesse` VALUES ('Monumenti Religiosi','android.resource://com.example.test.appancona/drawable/iconachiesa');
INSERT INTO `tipi_punti_interesse` VALUES ('Luoghi Culturali','android.resource://com.example.test.appancona/drawable/iconaculturali');
CREATE TABLE IF NOT EXISTS `tappe_percorsi` (
	`_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`cod_percorso`	int ( 11 ) NOT NULL,
	`cod_tappa`	int ( 11 ) NOT NULL,
	`posizione`	int ( 11 ) NOT NULL,
	FOREIGN KEY(`cod_percorso`) REFERENCES `percorsi`(`_id`),
	FOREIGN KEY(`cod_tappa`) REFERENCES `tappe`(`_cod_tappa`)
);
CREATE TABLE IF NOT EXISTS `tappe` (
	`_cod_tappa`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`indirizzo`	varchar ( 50 ) NOT NULL,
	`nome_tappa`	varchar ( 50 ) NOT NULL,
	`descrizione`	varchar ( 250 ) NOT NULL
);
CREATE TABLE IF NOT EXISTS `servizi` (
	`_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`nome`	varchar ( 50 ) NOT NULL,
	`cod_tipo_servizi`	varchar ( 50 ) NOT NULL,
	`descrizione`	varchar ( 300 ) NOT NULL,
	`immagine`	varchar ( 50 ) NOT NULL,
	`indirizzo`	varchar ( 50 ) NOT NULL,
	`telefono`	varchar ( 10 ) NOT NULL,
	`sito_internet`	varchar ( 50 ) NOT NULL,
	`email`	varchar ( 50 ) NOT NULL,
	FOREIGN KEY(`cod_tipo_servizi`) REFERENCES `tipi_servizi`(`_id`)
);
INSERT INTO `servizi` VALUES (1,'Ospedale 1','Ospedali','descrizione','android.resource://com.example.test.appancona/drawable/pernottamento','via indirizzo 1','0714345621','www.sito.it','email@email.it');
INSERT INTO `servizi` VALUES (2,'Stazione 1','Stazione','descrizione','android.resource://com.example.test.appancona/drawable/puntiinteresse','via indirizzo 1','0714345621','www.sito.it','email@email.it');
INSERT INTO `servizi` VALUES (3,'Centrale 1','Carabinieri','descrizione','android.resource://com.example.test.appancona/drawable/pernottamento','via indirizzo 1','0714345621','www.sito.it','email@email.it');
INSERT INTO `servizi` VALUES (4,'Farmacia 1','Farmacie','descrizione','android.resource://com.example.test.appancona/drawable/puntiinteresse','via indirizzo 1','0714345621','www.sito.it','email@email.it');
INSERT INTO `servizi` VALUES (5,'Supermercato 1','Supermercati','descrizione','android.resource://com.example.test.appancona/drawable/pernottamento','via indirizzo 1','0714345621','www.sito.it','email@email.it');
INSERT INTO `servizi` VALUES (6,'Ufficio Postale 1','Ufficio Postale','descrizione','android.resource://com.example.test.appancona/drawable/puntiinteresse','via indirizzo 1','0714345621','www.sito.it','email@email.it');
CREATE TABLE IF NOT EXISTS `serv_tappa` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`cod_serv`	int ( 11 ) NOT NULL,
	`cod_tappa`	int ( 11 ) NOT NULL,
	FOREIGN KEY(`cod_serv`) REFERENCES `servizi`(`id`),
	FOREIGN KEY(`cod_tappa`) REFERENCES `tappe`(`id`)
);
CREATE TABLE IF NOT EXISTS `ristorazione` (
	`_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`nome`	varchar ( 50 ) NOT NULL,
	`indirizzo`	varchar ( 50 ) NOT NULL,
	`descrizione`	varchar ( 50 ) NOT NULL,
	`immagine`	varchar ( 50 ) NOT NULL,
	`orario_apertura`	datetime  NOT NULL,
	`orario_chiusura`	datetime  NOT NULL,
	`giorno_chiusura`	varchar ( 50 ) NOT NULL,
	`numero_coperti`	int ( 3 ) NOT NULL,
	`prezzo_medio`	float NOT NULL,
	`telefono`	varchar ( 10 ) NOT NULL,
	`sito_internet`	varchar ( 50 ) NOT NULL,
	`parcheggio`	varchar ( 10 ) NOT NULL
);
INSERT INTO `ristorazione` VALUES (1,'pizzeria 1','via indirizzo 1','descrizione','android.resource://com.example.test.appancona/drawable/rist2','9:00:00','19:00:00','domenica',10,10.25,'071123456','www.sito.it','si');
INSERT INTO `ristorazione` VALUES (2,'pizzeria 2','via indirizzo 2','descrizione','android.resource://com.example.test.appancona/drawable/lacitta','9:00:00','19:00:00','domenica',10,10.25,'071123456','www.sito.it','no');
INSERT INTO `ristorazione` VALUES (3,'pizzeria 3','via indirizzo 3','descrizione','android.resource://com.example.test.appancona/drawable/puntiinteresse','9:00:00','19:00:00','domenica',10,10.25,'071123456','www.sito.it','si');
INSERT INTO `ristorazione` VALUES (4,'pizzeria 4','via indirizzo 4','descrizione','android.resource://com.example.test.appancona/drawable/rist2','9:00:00','19:00:00','domenica',10,10.25,'071123456','www.sito.it','si');
INSERT INTO `ristorazione` VALUES (5,'pizzeria 5','via indirizzo 5','descrizione','android.resource://com.example.test.appancona/drawable/pernottamento','9:00:00','19:00:00','domenica',10,10.25,'071123456','www.sito.it','no');
INSERT INTO `ristorazione` VALUES (6,'pizzeria 6','via indirizzo 6','descrizione','android.resource://com.example.test.appancona/drawable/rist2','9:00:00','19:00:00','domenica',10,10.25,'071123456','www.sito.it','no');
INSERT INTO `ristorazione` VALUES (7,'pizzeria 7','via indirizzo 7','descrizione','android.resource://com.example.test.appancona/drawable/lacitta','9:00:00','19:00:00','domenica',10,10.25,'071123456','www.sito.it','si');
INSERT INTO `ristorazione` VALUES (8,'pizzeria 8','via indirizzo 8','descrizione','android.resource://com.example.test.appancona/drawable/puntiinteresse','9:00:00','19:00:00','domenica',10,10.25,'071123456','www.sito.it','si');
INSERT INTO `ristorazione` VALUES (9,'pizzeria 9','via indirizzo 9','descrizione','android.resource://com.example.test.appancona/drawable/rist2','9:00:00','19:00:00','domenica',10,10.25,'071123456','www.sito.it','si');
INSERT INTO `ristorazione` VALUES (10,'pizzeria 10','via indirizzo 10','descrizione','android.resource://com.example.test.appancona/drawable/pernottamento','9:00:00','19:00:00','domenica',10,10.25,'071123456','www.sito.it','si');

CREATE TABLE IF NOT EXISTS `rist_tappa` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`cod_ristorazione`	int ( 11 ) NOT NULL,
	`cod_tappa`	int ( 11 ) NOT NULL,
	FOREIGN KEY(`cod_tappa`) REFERENCES `tappe`(`id`),
	FOREIGN KEY(`cod_ristorazione`) REFERENCES `ristorazione`(`id`)
);
CREATE TABLE IF NOT EXISTS `punti_interesse` (
	`_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`nome`	varchar ( 50 ) NOT NULL,
	`cod_tipo`	varchar ( 50 ) NOT NULL,
	`indirizzo`	varchar ( 50 ) NOT NULL,
	`descrizione`	varchar ( 300 ) NOT NULL,
	`immagine`	varchar ( 50 ) NOT NULL,
	FOREIGN KEY(`cod_tipo`) REFERENCES `tipi_punti_interesse`(`_id`)
);
INSERT INTO `punti_interesse` VALUES (1,'Monumento 1','Monumenti Storici','via indirizzo 1','descrizione','android.resource://com.example.test.appancona/drawable/pernottamento');
INSERT INTO `punti_interesse` VALUES (2,'Monumento 2','Monumenti Storici','via indirizzo 2','descrizione','android.resource://com.example.test.appancona/drawable/lacitta');
INSERT INTO `punti_interesse` VALUES (3,'Monumento 3','Monumenti Religiosi','via indirizzo 3','descrizione','android.resource://com.example.test.appancona/drawable/servizi');
INSERT INTO `punti_interesse` VALUES (4,'Monumento 4','Monumenti Religiosi','via indirizzo 3','descrizione','android.resource://com.example.test.appancona/drawable/puntiinteresse');
INSERT INTO `punti_interesse` VALUES (5,'Monumento 5','Parchi e Aree Verdi','via indirizzo 3','descrizione','android.resource://com.example.test.appancona/drawable/servizi');
INSERT INTO `punti_interesse` VALUES (6,'Monumento 6','Parchi e Aree Verdi','via indirizzo 3','descrizione','android.resource://com.example.test.appancona/drawable/puntiinteresse');
INSERT INTO `punti_interesse` VALUES (7,'Monumento 7','Luoghi Culturali','via indirizzo 3','descrizione','android.resource://com.example.test.appancona/drawable/percorsi');
INSERT INTO `punti_interesse` VALUES (8,'Monumento 8','Luoghi Culturali','via indirizzo 3','descrizione','android.resource://com.example.test.appancona/drawable/rist2');
CREATE TABLE IF NOT EXISTS `pun_int_tappa` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`cod_pun_int`	int ( 11 ) NOT NULL,
	`cod_tappa`	int ( 11 ) NOT NULL,
	FOREIGN KEY(`cod_pun_int`) REFERENCES `punti_interesse`(`_id`),
	FOREIGN KEY(`cod_tappa`) REFERENCES `tappe`(`id`)
);
CREATE TABLE IF NOT EXISTS `pernottamento` (
	`_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`nome`	varchar ( 50 ) NOT NULL,
	`indirizzo`	varchar ( 50 ) NOT NULL,
	`descrizione`	varchar ( 300 ) NOT NULL,
	`immagine`	varchar ( 50 ) NOT NULL,
	`prezzo_medio`	float NOT NULL,
	`telefono`	varchar ( 10 ) NOT NULL,
	`sito_internet`	varchar ( 50 ) NOT NULL,
	`parcheggio`	tinyint ( 1 ) NOT NULL
);
INSERT INTO `pernottamento` VALUES (1,'hotel 1','via indirizzo 1','descrizione','android.resource://com.example.test.appancona/drawable/pernottamento',20,'0723123456','www.sito.it',0);
INSERT INTO `pernottamento` VALUES (2,'hotel 2','via indirizzo 2','descrizione','android.resource://com.example.test.appancona/drawable/lacitta',20,'0723123456','www.sito.it',0);
INSERT INTO `pernottamento` VALUES (3,'hotel 3','via indirizzo 3','descrizione','android.resource://com.example.test.appancona/drawable/servizi',20,'0723123456','www.sito.it',0);
INSERT INTO `pernottamento` VALUES (4,'hotel 4','via indirizzo 4','descrizione','android.resource://com.example.test.appancona/drawable/pernottamento',20,'0723123456','www.sito.it',0);
INSERT INTO `pernottamento` VALUES (5,'hotel 5','via indirizzo 5','descrizione','android.resource://com.example.test.appancona/drawable/lacitta',20,'0723123456','www.sito.it',0);
INSERT INTO `pernottamento` VALUES (6,'hotel 6','via indirizzo 6','descrizione','android.resource://com.example.test.appancona/drawable/servizi',20,'0723123456','www.sito.it',0);
CREATE TABLE IF NOT EXISTS `pern_tappa` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`cod_pern`	int ( 11 ) NOT NULL,
	`cod_tappa`	int ( 11 ) NOT NULL,
	FOREIGN KEY(`cod_pern`) REFERENCES `pernottamento`(`id`),
	FOREIGN KEY(`cod_tappa`) REFERENCES `tappe`(`id`)
);
CREATE TABLE IF NOT EXISTS `percorsi` (
	`_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`tipo_percorso`	varchar ( 50 ) NOT NULL,
	`descrizione`	varchar ( 300 ) NOT NULL,
	`immagine`	varchar ( 50 ) NOT NULL
);
INSERT INTO `percorsi` VALUES (1,'Percorso 1',1,'android.resource://com.example.test.appancona/drawable/iconaparchi');
INSERT INTO `percorsi` VALUES (2,'Percorso 2',2,'android.resource://com.example.test.appancona/drawable/iconaculturali');
INSERT INTO `percorsi` VALUES (3,'Percorso 3',3,'android.resource://com.example.test.appancona/drawable/parthenon');
INSERT INTO `percorsi` VALUES (4,'Percorso 4',4,'android.resource://com.example.test.appancona/drawable/farmacia');
INSERT INTO `percorsi` VALUES (5,'Percorso 5',5,'android.resource://com.example.test.appancona/drawable/stazione');
CREATE TABLE IF NOT EXISTS `negozi_tipici` (
	`_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`nome`	varchar ( 50 ) NOT NULL,
	`indirizzo`	varchar ( 50 ) NOT NULL,
	`descrizione`	varchar ( 300 ) NOT NULL,
	`orario_apertura`	datetime   NOT NULL,
	`orario_chiusura`	datetime NOT NULL,
	`giorno_chiusura`	varchar ( 50 ) NOT NULL,
	`telefono`	varchar ( 10 ) NOT NULL,
	`sito_internet`	varchar ( 50 ) NOT NULL,
	`immagine`	varchar ( 50 ) NOT NULL
);
INSERT INTO `negozi_tipici` VALUES (1,'negozio 1','via indirizzo 1','descrizione','9:00:00','19:00:00','domenica','071123456','www.sito.it','android.resource://com.example.test.appancona/drawable/rist2');
INSERT INTO `negozi_tipici` VALUES (2,'negozio 2','via indirizzo 2','descrizione','9:00:00','19:00:00','domenica','071123456','www.sito.it','android.resource://com.example.test.appancona/drawable/lacitta');
CREATE TABLE IF NOT EXISTS `negoz_tappa` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`cod_negoz`	int ( 11 ) NOT NULL,
	`cod_tappa`	int ( 11 ) NOT NULL,
	FOREIGN KEY(`cod_tappa`) REFERENCES `tappe`(`id`),
	FOREIGN KEY(`cod_negoz`) REFERENCES `negozi_tipici`(`_id`)
);
COMMIT;
