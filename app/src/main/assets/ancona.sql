BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS `tipi_servizi` (
	`codice_servizi`	VARCHAR NOT NULL,
	PRIMARY KEY(`codice_servizi`)
);
CREATE TABLE IF NOT EXISTS `tipi_punti_interesse` (
	`Codice_tipo`	VARCHAR NOT NULL,
	PRIMARY KEY(`Codice_tipo`)
);
CREATE TABLE IF NOT EXISTS `tappe_percorsi` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`cod_percorso`	int ( 11 ) NOT NULL,
	`cod_tappa`	int ( 11 ) NOT NULL,
	`posizione`	int ( 11 ) NOT NULL,
	FOREIGN KEY(`cod_percorso`) REFERENCES `percorsi`(`id`),
	FOREIGN KEY(`cod_tappa`) REFERENCES `tappe`(`id`)
);
CREATE TABLE IF NOT EXISTS `tappe` (
	`cod_tappa`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`indirizzo`	varchar ( 50 ) NOT NULL,
	`nome_tappa`	varchar ( 50 ) NOT NULL,
	`descrizione`	varchar ( 250 ) NOT NULL
);
CREATE TABLE IF NOT EXISTS `servizi` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`nome`	varchar ( 50 ) NOT NULL,
	`cod_tipo_servizi`	varchar ( 50 ) NOT NULL,
	`descrizione`	varchar ( 300 ) NOT NULL,
	`immagine`	varchar ( 50 ) NOT NULL,
	`indirizzo`	varchar ( 50 ) NOT NULL,
	`telefono`	varchar ( 10 ) NOT NULL,
	`sito_internet`	varchar ( 50 ) NOT NULL,
	`email`	varchar ( 50 ) NOT NULL,
	`immagini`	varchar ( 50 ) NOT NULL,
	FOREIGN KEY(`cod_tipo_servizi`) REFERENCES `tipi_servizi`(`codice_servizi`)
);
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
	`parcheggio`	tinyint ( 1 ) NOT NULL
);
INSERT INTO `ristorazione` VALUES (1,'pizzeria 1','via indirzzo 1','descrizione','rist2.jpg','9:00:00','19:00:00','domenica',10,10.25,'071123456','www.sito.it',0);
INSERT INTO `ristorazione` VALUES (2,'pizzeria 2','via indirzzo 2','descrizione','rist2.jpg','9:00:00','19:00:00','domenica',10,10.25,'071123456','www.sito.it',0);
INSERT INTO `ristorazione` VALUES (3,'pizzeria 3','via indirzzo 3','descrizione','rist2.jpg','9:00:00','19:00:00','domenica',10,10.25,'071123456','www.sito.it',0);
INSERT INTO `ristorazione` VALUES (4,'pizzeria 4','via indirzzo 4','descrizione','rist2.jpg','9:00:00','19:00:00','domenica',10,10.25,'071123456','www.sito.it',0);
INSERT INTO `ristorazione` VALUES (5,'pizzeria 5','via indirzzo 5','descrizione','rist2.jpg','9:00:00','19:00:00','domenica',10,10.25,'071123456','www.sito.it',0);
CREATE TABLE IF NOT EXISTS `rist_tappa` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`cod_ristorazione`	int ( 11 ) NOT NULL,
	`cod_tappa`	int ( 11 ) NOT NULL,
	FOREIGN KEY(`cod_tappa`) REFERENCES `tappe`(`id`),
	FOREIGN KEY(`cod_ristorazione`) REFERENCES `ristorazione`(`id`)
);
CREATE TABLE IF NOT EXISTS `punti_interesse` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`nome`	varchar ( 50 ) NOT NULL,
	`cod_tipo`	varchar ( 50 ) NOT NULL,
	`indirizzo`	varchar ( 50 ) NOT NULL,
	`descrizione`	varchar ( 300 ) NOT NULL,
	`immagine`	varchar ( 50 ) NOT NULL,
	FOREIGN KEY(`cod_tipo`) REFERENCES `tipi_punti_interesse`(`Codice_tipo`)
);
CREATE TABLE IF NOT EXISTS `pun_int_tappa` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`cod_pun_int`	int ( 11 ) NOT NULL,
	`cod_tappa`	int ( 11 ) NOT NULL,
	FOREIGN KEY(`cod_pun_int`) REFERENCES `punti_interesse`(`id`),
	FOREIGN KEY(`cod_tappa`) REFERENCES `tappe`(`id`)
);
CREATE TABLE IF NOT EXISTS `pernottamento` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`nome`	varchar ( 50 ) NOT NULL,
	`indirizzo`	varchar ( 50 ) NOT NULL,
	`descrizione`	varchar ( 300 ) NOT NULL,
	`immagine`	varchar ( 50 ) NOT NULL,
	`prezzo_medio`	float NOT NULL,
	`telefono`	varchar ( 10 ) NOT NULL,
	`sito_internet`	varchar ( 50 ) NOT NULL,
	`parcheggio`	tinyint ( 1 ) NOT NULL
);
CREATE TABLE IF NOT EXISTS `pern_tappa` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`cod_pern`	int ( 11 ) NOT NULL,
	`cod_tappa`	int ( 11 ) NOT NULL,
	FOREIGN KEY(`cod_pern`) REFERENCES `pernottamento`(`id`),
	FOREIGN KEY(`cod_tappa`) REFERENCES `tappe`(`id`)
);
CREATE TABLE IF NOT EXISTS `percorsi` (
	`cod_percorso`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`tipo_percorso`	varchar ( 50 ) NOT NULL,
	`descrizione`	varchar ( 300 ) NOT NULL
);
CREATE TABLE IF NOT EXISTS `negozi_tipici` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
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
CREATE TABLE IF NOT EXISTS `negoz_tappa` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`cod_negoz`	int ( 11 ) NOT NULL,
	`cod_tappa`	int ( 11 ) NOT NULL,
	FOREIGN KEY(`cod_tappa`) REFERENCES `tappe`(`id`),
	FOREIGN KEY(`cod_negoz`) REFERENCES `negozi_tipici`(`id`)
);
COMMIT;
