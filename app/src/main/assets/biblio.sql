BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS `biblio` (
	`_id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`titolo`	TEXT,
	`autore`	TEXT,
	`numero_pagine`	INTEGER
);
INSERT INTO `biblio` VALUES (1,'Promessi sposi','Alessandro Manzoni',500);
INSERT INTO `biblio` VALUES (2,'Il deserto dei Tartari','Dino Buzzati',270);
INSERT INTO `biblio` VALUES (3,'Il Gattopardo','Giuseppe Tomasi di Lampedusa',300);
COMMIT;
