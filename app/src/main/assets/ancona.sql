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
INSERT INTO `tipi_servizi` VALUES ('Parcheggi','android.resource://com.example.test.appancona/drawable/parcheggio');
CREATE TABLE IF NOT EXISTS `tipi_punti_interesse` (
	`_id`	VARCHAR NOT NULL,
	`immagine`	varchar ( 50 ) NOT NULL,
	PRIMARY KEY(`_id`)
);
INSERT INTO `tipi_punti_interesse` VALUES ('Monumenti Storici','android.resource://com.example.test.appancona/drawable/parthenon');
INSERT INTO `tipi_punti_interesse` VALUES ('Parchi e Natura','android.resource://com.example.test.appancona/drawable/iconaparchi');
INSERT INTO `tipi_punti_interesse` VALUES ('Monumenti Religiosi','android.resource://com.example.test.appancona/drawable/iconachiesa');
INSERT INTO `tipi_punti_interesse` VALUES ('Luoghi Culturali','android.resource://com.example.test.appancona/drawable/iconaculturali');

CREATE TABLE IF NOT EXISTS `tappe_percorsi` (
	`_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`cod_percorso`	int ( 11 ) NOT NULL,
	`cod_tappa`	int ( 11 ) NOT NULL,
	`posizione`	int ( 11 ) NOT NULL,
	FOREIGN KEY(`cod_tappa`) REFERENCES `tappe`(`_cod_tappa`),
	FOREIGN KEY(`cod_percorso`) REFERENCES `percorsi`(`_id`)
);


CREATE TABLE IF NOT EXISTS `tappe` (
	`_cod_tappa`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`indirizzo`	varchar ( 50 ) NOT NULL,
	`nome_tappa`	varchar ( 50 ) NOT NULL
);
INSERT INTO `tappe` VALUES (1,'Banchina Nazario Sauro 28','Lazzaretto di Ancona');
INSERT INTO `tappe` VALUES (2,'Piazza Santa Maria','Chiesa di Santa Maria della Piazza');
INSERT INTO `tappe` VALUES (3,'Lungomare Vanvitelli 100','Arco di Traiano');
INSERT INTO `tappe` VALUES (4,'Lungomare Vanvitelli 200','Arco Clementino');
INSERT INTO `tappe` VALUES (5,'Lanterna Rossa di Ancona','Lanterna Rossa di Ancona');
INSERT INTO `tappe` VALUES (6,'Piazza Anfiteatro','Anfiteatro Romano');
INSERT INTO `tappe` VALUES (7,'Piazzale del Duomo 9','Duomo di Ancona');
INSERT INTO `tappe` VALUES (8,'Piazza del Plebiscito','Chiesa di San Domenico');
INSERT INTO `tappe` VALUES (9,'Corso Giuseppe Mazzini','Fontana del Calamo');
INSERT INTO `tappe` VALUES (10,'Piazza Cavour','Monumento Cavour');
INSERT INTO `tappe` VALUES (11,'Piazza IV Novembre','Monumento ai Caduti');
INSERT INTO `tappe` VALUES (12,'Parco Posatora','Parco Posatora');
INSERT INTO `tappe` VALUES (13,'Parco della Cittadella','Parco della Cittadella');
INSERT INTO `tappe` VALUES (14,'Parco del Pincio','Parco del Pincio');
INSERT INTO `tappe` VALUES (15,'Parco del Cardeto','Parco del Cardeto');
INSERT INTO `tappe` VALUES (16,'Terrazza del Passetto','Terrazzo del Passetto');
INSERT INTO `tappe` VALUES (17,'Banchina Giovanni da Chio 28','Museo Tattile Statale Omero');
INSERT INTO `tappe` VALUES (18,'Piazzale della Repubblica','Teatro delle Muse');
INSERT INTO `tappe` VALUES (19,'Via Pizzecolli 9','Museo del Giocattolo');
INSERT INTO `tappe` VALUES (20,'Via Ferretti 6','Museo Archeologico delle Marche');
INSERT INTO `tappe` VALUES (21,'Via Mario Torresi 18','Zucchero a velò');
INSERT INTO `tappe` VALUES (22,'Via Benincasa 7','Pizzeria l''Arte della Pizza');
INSERT INTO `tappe` VALUES (23,'Corso Giuseppe Mazzini 96','Bontà delle marche');
INSERT INTO `tappe` VALUES (24,'Via Fabio Filzi 2','Ristorante Il Giardino');
INSERT INTO `tappe` VALUES (25,'Piazza IV Novembre','La Luna al Passetto');

CREATE TABLE IF NOT EXISTS `servizi` (
	`_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`nome`	varchar ( 50 ) NOT NULL,
	`cod_tipo_servizi`	varchar ( 50 ) NOT NULL,
	`immagine`	varchar ( 50 ) NOT NULL,
	`indirizzo`	varchar ( 50 ) NOT NULL,
	`telefono`	varchar ( 10 ) NOT NULL,
	`sito_internet`	varchar ( 50 ) NOT NULL,
	`email`	varchar ( 50 ) NOT NULL,
	FOREIGN KEY(`cod_tipo_servizi`) REFERENCES `tipi_servizi`(`_id`)
);
INSERT INTO `servizi` VALUES (1,'Ospedale Umberto I','Ospedali','android.resource://com.example.test.appancona/drawable/torrette','Via Conca 71','071 5961','ospedaliriuniti.marche.it','aou.ancona@emarche.it');
INSERT INTO `servizi` VALUES (2,'Ospedale Salesi','Ospedali','android.resource://com.example.test.appancona/drawable/salesi','Via Filippo Corridoni, 16','071 5961','ospedaliriuniti.marche.it','aou.ancona@emarche.it');
INSERT INTO `servizi` VALUES (3,'Stazione Centrale Ancona','Stazione','android.resource://com.example.test.appancona/drawable/stazcentrale','Piazza Rosselli','892 021','www.trenitalia.com','non presente');
INSERT INTO `servizi` VALUES (4,'Stazione Torrette Ancona','Stazione','android.resource://com.example.test.appancona/drawable/staztorrette','Via Flaminia 230','892 021','www.trenitalia.com','non presente');
INSERT INTO `servizi` VALUES (5,'Comando Stazione Ancona Centro','Carabinieri','android.resource://com.example.test.appancona/drawable/carabicentrale','Via Piave 24','071 200666','www.carabinieri.it','carabinieri@carabinieri.it');
INSERT INTO `servizi` VALUES (6,'Nucleo Presidio Banca d''Italia','Carabinieri','android.resource://com.example.test.appancona/drawable/carabibanca','Piazza J.F.Kennedy 9','071 22851','www.carabinieri.it','carabinieri@carabinieri.it');
INSERT INTO `servizi` VALUES (7,'Comando Stazione Ancona Principale','Carabinieri','android.resource://com.example.test.appancona/drawable/carabiprincipale','Via della Montagnola 81a','071 5031','www.carabinieri.it','stan221120@carabinieri.it');
INSERT INTO `servizi` VALUES (8,'Farmacia Ferranti G.& A.','Farmacie','android.resource://com.example.test.appancona/drawable/farmaciaferranti','Piazza Rosselli 2','071 43395','non presente','non presente');
INSERT INTO `servizi` VALUES (9,'Farmacia Valla Dr.Paolo','Farmacie','android.resource://com.example.test.appancona/drawable/farmaciavalla','Corso Giuseppe Garibaldi 116','071 2070220','www.farmaciavalla.it','ecommerce@farmaciavalla.it');
INSERT INTO `servizi` VALUES (10,'Farmacia Palmieri e Gaffuri','Farmacie','android.resource://com.example.test.appancona/drawable/farmaciapalmieri','Corso Giuseppe Garibaldi 62','071 202771','www.farmaciapalmieriegaffuri.it','info@farmaciapalmieriegaffuri.it');
INSERT INTO `servizi` VALUES (11,'Farmacia delle Grazie','Farmacie','android.resource://com.example.test.appancona/drawable/farmaciagrazie','Via Torresi 135','071 898332','www.farmaciadellegrazie.it','farmaciaciccioli@alice.it');
INSERT INTO `servizi` VALUES (12,'Farmacia del Passetto','Farmacie','android.resource://com.example.test.appancona/drawable/farmaciapassetto','Viale della Vittoria 75','071 32366','www.farmaciadelpassetto.it','info@farmaciadelpassetto.it');
INSERT INTO `servizi` VALUES (13,'Sì con Te','Supermercati','android.resource://com.example.test.appancona/drawable/siconte','Via Piave 27','071 205515','www.siconte.it','non presente');
INSERT INTO `servizi` VALUES (14,'MyAuchan','Supermercati','android.resource://com.example.test.appancona/drawable/myauchan','Via Trieste 45','071 32906 ','www.auchan.it/it-IT-it/Custom/Organa/PuntoVendita.aspx?codiceNegozio=7311','non presente');
INSERT INTO `servizi` VALUES (15,'Coal di Fiore','Supermercati','android.resource://com.example.test.appancona/drawable/coal','Via S. Martino 27','non presente ','www.coal.it','non presente');
INSERT INTO `servizi` VALUES (16,'Maxi Coal Archi','Supermercati','android.resource://com.example.test.appancona/drawable/maxicoal','Via Terenzio Mamiani 14','071 9884419 ','www.maxi-coal-supermercato.business.site/','non presente');
INSERT INTO `servizi` VALUES (17,'Conad City','Supermercati','android.resource://com.example.test.appancona/drawable/conad','Corso Carlo Alberto 2','071 44640 ','www.conad.it/ricerca-negozi/negozio.008619.html?utm_source=google&utm_medium=organic&utm_content=GMB','non presente');
INSERT INTO `servizi` VALUES (18,'Ufficio Postale P.Rosselli','Ufficio Postale','android.resource://com.example.test.appancona/drawable/poste2','Piazza Rosselli 31','071 43956','www.poste.it','servizio.clienti@posteitaliane.it');
INSERT INTO `servizi` VALUES (19,'Ufficio Postale XXIV Maggio','Ufficio Postale','android.resource://com.example.test.appancona/drawable/poste1','Largo XXIV Maggio 2','071 5012260','www.poste.it','servizio.clienti@posteitaliane.it');
INSERT INTO `servizi` VALUES (20,'Ufficio Postale Maratta','Ufficio Postale','android.resource://com.example.test.appancona/drawable/poste3','Via Carlo Maratta 39','071 3581211','www.poste.it','servizio.clienti@posteitaliane.it');
INSERT INTO `servizi` VALUES (21,'Ufficio Postale Torrette','Ufficio Postale','android.resource://com.example.test.appancona/drawable/poste4','Via Esino 60','071 880579','www.poste.it','servizio.clienti@posteitaliane.it');
INSERT INTO `servizi` VALUES (22,'Parcheggio degli Archi','Parcheggi','android.resource://com.example.test.appancona/drawable/parkarchi','Via Terenzio Mamiani 9','071 203748','www.anconaparcheggi.it','parcheggiancona@legalmail.it');
INSERT INTO `servizi` VALUES (23,'Parcheggio Traiano','Parcheggi','android.resource://com.example.test.appancona/drawable/parktraiano','Via XXIX Settembre 2','071 203834','www.anconaparcheggi.it','parcheggiancona@legalmail.it');
INSERT INTO `servizi` VALUES (24,'Parcheggio Stamira','Parcheggi','android.resource://com.example.test.appancona/drawable/parkstamira','Via Sandro Pertini 1','071 206511','www.anconaparcheggi.it','parcheggiancona@legalmail.it');
CREATE TABLE IF NOT EXISTS `serv_tappa` (
	`_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`cod_serv`	int ( 11 ) NOT NULL,
	`cod_tappa`	int ( 11 ) NOT NULL,
	FOREIGN KEY(`cod_tappa`) REFERENCES `tappe`(`_cod_tappa`),
	FOREIGN KEY(`cod_serv`) REFERENCES `servizi`(`_id`)
);
CREATE TABLE IF NOT EXISTS `ristorazione` (
	`_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`nome`	varchar ( 50 ) NOT NULL,
	`indirizzo`	varchar ( 50 ) NOT NULL,
	`descrizione`	varchar ( 50 ) NOT NULL,
	`immagine`	varchar ( 50 ) NOT NULL,
	`orari`	varchar ( 20 ) NOT NULL,
	`giorno_chiusura`	varchar ( 50 ) NOT NULL,
	`prezzo_medio`	float NOT NULL,
	`telefono`	varchar ( 10 ) NOT NULL,
	`sito_internet`	varchar ( 50 ) NOT NULL

);
INSERT INTO `ristorazione` VALUES (1,'La Luna al Passetto','Piazza IV Novembre','Ristorante specialità pesce situato sulla palafitta nella spiaggia del Passetto, in pieno centro di Ancona.','android.resource://com.example.test.appancona/drawable/ristluna','12:30-15:30 19:30-00:30','Nessuno',40,'071 34136','www.lalunaalpassetto.it');
INSERT INTO `ristorazione` VALUES (2,'Rosa Cremeria Food','Corso Giuseppe Mazzini 61','In uno degli angoli piu suggestivi del centro storico di Ancona, accanto alla fontana delle 13 Cannelle e a due passi dal porto e dal Teatro delle Muse, Rosa Cremeria & Food, il locale giusto ad ogni ora del giorno.','android.resource://com.example.test.appancona/drawable/ristrosa','07:00-00:00 ','Domenica mattina',30.0,'071 203408','www.facebook.com/rosacremeriafood/');
INSERT INTO `ristorazione` VALUES (3,'Ristorante pizzeria il Pincio','Va Circonvallazione 63','Il Ristorante Pizzeria Il Pincio è conosciuto come una deliziosa oasi di gusto e tranquillità in cui è gradevole trascorrere il tempo con la famiglia, gli amici o con la persona che ami.','android.resource://com.example.test.appancona/drawable/ristpincio','12:30-14:30 19:30-23:30','Nessuno',40,'071 56672','www.ilpincio.it');
INSERT INTO `ristorazione` VALUES (4,'Avalon','Via Sacco e Vanzetti 13','La pizzeria Avalon è conosciuta per la bontà della sua pizza.Ideale per una serata in famiglia o con gli amici.','android.resource://com.example.test.appancona/drawable/ristavalon','19:30-00:00','Lunedi',25,'071 2900672','www.facebook.com/AvalonAncona/');
INSERT INTO `ristorazione` VALUES (5,'Zucchero a velò','Via Mario Torresi 18','Zucchero a Velò nasce dalla passione di Elisabetta per il cibo e per l’american bakery e di Gabriele per le due ruote: Zucchero a Velò è il primo Bike Café di Ancona e, proprio per la sua natura,  parla di cibo, dolci e di biciclette.','android.resource://com.example.test.appancona/drawable/ristavelo','10:00-20:00','Lunedi e Martedi',15.0,'071 9692935','www.zuccheroaveloancona.it');
INSERT INTO `ristorazione` VALUES (6,'Ristorante Il Giardino',' Via Fabio Filzi, 2 ','Pizza e pietanze di pesce in un locale elegante all''interno di un palazzo del ''700 con veranda e giardino.','android.resource://com.example.test.appancona/drawable/ristgiardino','12:30-15:00 19:30-23:00','Lunedi',30.0,'071 2074660','www.ristorantegiardinoancona.it');
INSERT INTO `ristorazione` VALUES (7,'Pizzeria Sassi Neri','Via Trieste 59','Mangiare è uno dei quattro scopi della vita…quali siano gli altri tre, nessuno lo ha mai saputo. (Proverbio cinese)','android.resource://com.example.test.appancona/drawable/ristsassi','08:00-00:00','Sabato e Domenica mattina',25,'071 36887','www.facebook.com/Sassi-Neri-1557415134539404/');
INSERT INTO `ristorazione` VALUES (8,'Pizzeria Poldo''s Pizza','Via Montebello 85','Vieni a mangiare una bella e buona puccia!!!','android.resource://com.example.test.appancona/drawable/ristpoldo','18:00-23:00','Lunedi',8,'334 7352303','www.poldoancona.it');
INSERT INTO `ristorazione` VALUES (9,'Pizzeria Rosticceria Paolo','Via Giacomo Matteotti 27','Primi piatti, secondi, rosticceria, pizza al piatto e al pezzo.','android.resource://com.example.test.appancona/drawable/ristpaolo','07:30-20:30','Domenica',8.0,'071123456','www.facebook.com/pizzeriarosticceriapaolo/');
INSERT INTO `ristorazione` VALUES (10,'Pizzeria l''Arte della Pizza','Via Benincasa 7','L''Arte della pizza ad Ancona è una pizzeria aperta tutti i giorni, ed è il luogo ideale per un pranzo veloce, una cena gustosa o un aperitivo con gli amici. Il personale sempre accogliente, sarà a vostra disposizione anche per ottime pizze da asporto.','android.resource://com.example.test.appancona/drawable/ristarte','10:00-22:30','Nessuno',10.0,'071 55776','non disponibile');

CREATE TABLE IF NOT EXISTS `rist_tappa` (
	`_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`cod_ristorazione`	int ( 11 ) NOT NULL,
	`cod_tappa`	int ( 11 ) NOT NULL,
	FOREIGN KEY(`cod_ristorazione`) REFERENCES `ristorazione`(`_id`),
	FOREIGN KEY(`cod_tappa`) REFERENCES `tappe`(`_cod_tappa`)
);

INSERT INTO `rist_tappa` VALUES (1,5,21);
INSERT INTO `rist_tappa` VALUES (2,10,22);
INSERT INTO `rist_tappa` VALUES (3,6,24);
INSERT INTO `rist_tappa` VALUES (4,1,25);

CREATE TABLE IF NOT EXISTS `punti_interesse` (
	`_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`nome`	varchar ( 50 ) NOT NULL,
	`cod_tipo`	varchar ( 50 ) NOT NULL,
	`indirizzo`	varchar ( 50 ) NOT NULL,
	`descrizione`	varchar ( 600 ) NOT NULL,
	`immagine`	varchar ( 50 ) NOT NULL,
	FOREIGN KEY(`cod_tipo`) REFERENCES `tipi_punti_interesse`(`_id`)
);
INSERT INTO `punti_interesse` VALUES (1,'Monumento Cavour','Monumenti Storici','Piazza Cavour','Opera di Aristodemo Costoli, noto scultore risorgimentale. Sul basamento della statua, due bassorilievi rappresentano rispettivamente il Congresso di Parigi e la Proclamazione del Regno d''Italia ossia due momenti fondamentali dell''azione politica di Cavour.','android.resource://com.example.test.appancona/drawable/statuacavour');
INSERT INTO `punti_interesse` VALUES (2,'Lazzaretto di Ancona','Monumenti Storici','Banchina Nazario Sauro 28','Il Lazzaretto di Ancona, detto anche Mole Vanvitelliana, è un edificio progettato dall''architetto Luigi Vanvitelli.L''edificio sorge su di un''isola artificiale pentagonale situata all''interno del porto,è collegato alla terraferma da tre ponti.Nella parte interna dell''edificio si trovano i locali del Lazzaretto, che erano destinati alla quarantena, mentre le stanze nella parte esterna erano usate come deposito della merce. Verso il mare aperto il lazzaretto è fornito di un rivellino, progettato per la difesa militare del porto. Dunque fin dalla sua origine l''opera fu progettata come una struttura polifunzionale: magazzino portuale, luogo di quarantena, fortificazione.','android.resource://com.example.test.appancona/drawable/lazzaretto');
INSERT INTO `punti_interesse` VALUES (3,'Monumento ai caduti ','Monumenti Storici','Piazza IV Novembre','Il Monumento ai Caduti della prima guerra mondiale di Ancona si trova in piazza IV Novembre, nel rione del Passetto. È posto al termine del lungo viale della Vittoria ed è collegato alla sottostante spiaggia del Passetto attraverso un''ampia scalinata.Fu progettato negli anni venti, assieme alla Scalinata del Passetto, dall''architetto anconetano Guido Cirilli in forma di un tempio circolare.La costruzione ha otto colonne scanalate, è posta al di sopra di una scalinata circolare concentrica ed è realizzata interamente in pietra d''Istria. Il basamento è decorato con elmi e spade, simboli rispettivamente di difesa e di attacco. Al centro si trova un piccolo altare.Il Monumento fu inaugurato nel 1930, in piena epoca fascista.','android.resource://com.example.test.appancona/drawable/passetto');
INSERT INTO `punti_interesse` VALUES (4,'Fontana del Calamo','Monumenti Storici','Corso Giuseppe Mazzini','La fontana del Càlamo, chiamata anche fontana delle Tredici Cannelle è una fontana rinascimentale di Ancona.Sul luogo sorgeva già anticamente una fontana in epoca greca, che venne inglobata nelle mura cittadine durante il Medioevo. La sua denominazione sembra derivare dalla parola latina Càlamus, "Canna", a testimonianza che si era dominati da un ambiente di tipo palustre.Si presenta come una lunga serie di tredici riquadri separati da volute, incentrati su altrettanti mascheroni gettanti acqua, da cui deriva la comune denominazione di Fontana delle Tredici Cannelle. I mascheroni, di cui 12 bronzei ed il centrale in pietra, raffigurano satiri e fauni. Quello centrale è sormontato dal bassorilievo del Cavaliere all''assalto, emblema della città di Ancona.Oggi la fontana riceve le acque dell''acquedotto cittadino, ma, anticamente, attingeva l''acqua da una grande cisterna posta sotto il muro alle sue spalle. La cisterna riceveva le acque dall''acquedotto proveniente da Monte Conero. Essa, oggi, è vuota, ma visitabile tramite un passaggio che si apre alla destra della fontana.Secondo un''antica tradizione, il viaggiatore che volesse tornare in città dovrebbe bere l''acqua che sgorga dalla fontana.','android.resource://com.example.test.appancona/drawable/fontanadelcalamo');
INSERT INTO `punti_interesse` VALUES (5,'Arco di Traiano','Monumenti Storici','Lungomare Vanvitelli 100','L''arco di Traiano di Ancona rappresenta una delle testimonianze monumentali più preziose dell''architettura romana, anche per il suo ottimo stato di conservazione. Le sue proporzioni, particolarmente eleganti perché più slanciate rispetto agli altri archi romani, sono la sua caratteristica più saliente, insieme allo stretto rapporto con il mare, sorgendo sul molo del porto di Ancona fatto costruire nel I° secolo dall''imperatore Traiano. Ha un singolo fornice affiancato da due coppie di colonne corinzie scanalate. Le iscrizioni poste sull''attico sono ancora perfettamente leggibili.Venne eretto, in marmo proconnesio, dal Senato e dal popolo di Roma probabilmente ad opera dell''architetto siriano Apollodoro di Damasco per onorare l''imperatore che aveva donato ai naviganti un più sicuro accesso all''Italia, avendo fatto ampliare, a proprie spese, il porto della città.','android.resource://com.example.test.appancona/drawable/arcotraiano');
INSERT INTO `punti_interesse` VALUES (6,'Anfiteatro romano','Monumenti Storici','Piazza Anfiteatro','L''anfiteatro romano di Ancona, situato tra i colli Guasco e dei Cappuccini, costituisce, dopo l''arco di Traiano, l''opera architettonica di epoca romana più importante della città. Lo scavo è pressoché completato nel settore meridionale, dove è visibile un lungo tratto del muro di cinta, l''ingresso principale e alcuni ingressi per gli spettatori.Vi erano due ingressi all''arena, situati ai due estremi dell''asse maggiore dell''ellisse: la porta pompae, destinato all''ingresso della processione gladiatoria, e la porta libitinensis, consacrata alla dea che presiedeva il passaggio all''aldilà, da cui uscivano i gladiatori moribondi e morti durante i combattimenti. Esistevano inoltre diversi ingressi utilizzati dagli spettatori, che conducevano ai vari settori della cavea.A volte questi ingressi non erano dotati di scale, ma arrivavano direttamente nel settore, sfruttando la pendenza naturale del terreno.','android.resource://com.example.test.appancona/drawable/anfiteatro');
INSERT INTO `punti_interesse` VALUES (7,'Parco del Cardeto','Parchi e Natura','Parco del Cardeto','Il Parco del Cardeto è il più vasto parco urbano di Ancona. A picco sul mare, occupa le sommità dei colli Cappuccini e Cardeto e si estende in un''area di circa 35 ettari, tutti a ridosso del centro.','android.resource://com.example.test.appancona/drawable/parcocardeto');
INSERT INTO `punti_interesse` VALUES (8,'Parco del Pincio','Parchi e Natura','Piazzale Loreto','Il Parco del Pincio, piccolo, ma di grande importanza storica dato che è il più antico della città, essendo sorto dopo la presa di Roma del 1870. Il nome ricorda infatti il famoso Pincio della capitale, nel quale Mazzini fece porre le statue degli Italiani più celebri. Per rievocare il suo omonimo romano, il Pincio di Ancona è ricco di sempreverdi, ha un impianto geometrico dei sentieri ed ha un belvedere da cui si gode di un''ampia vista sulla città.','android.resource://com.example.test.appancona/drawable/pincio');
INSERT INTO `punti_interesse` VALUES (9,'Parco della Cittadella','Parchi e Natura','Parco della Cittadella','Ad Ancona, sulla sommità del colle Astagno ed all''interno dell''antico campo trincerato si trova il Parco della Cittadella, che prende il nome dall''adiacente Cittadella, cinquecentesca, sovrastante la città ed il porto di Ancona.Il parco venne aperto negli anni Settanta ed inizialmente era collegato alla Cittadella vera e propria con una scala.','android.resource://com.example.test.appancona/drawable/cittadella');
INSERT INTO `punti_interesse` VALUES (10,'Parco Posatora','Parchi e Natura','Parco Posatora','Il parco Belvedere è compreso nel rione di Posatora ed offre un''ottima vista sul mare, sul porto e su tutto il nucleo del centro storico della città. Una leggenda narra che proprio qui gli angeli avrebbero posato la Santa Casa, in viaggio verso Loreto, per riposarsi (da questo fatto prende il nome il rione posa et ora).','android.resource://com.example.test.appancona/drawable/posatora');
INSERT INTO `punti_interesse` VALUES (11,'Lanterna Rossa di Ancona','Parchi e Natura','Lanterna Rossa di Ancona','La lanterna rossa è uno dei simboli del porto di Ancona.Accanto alla lanterna è stata collocata una panchina per tutti gli innamorati del mare da cui godere della bellezza dell''Adriatico. La lanterna, con Ancona nelle vesti del porto di Brighton, è stata protagonista del film ''La ragazza con la pistola'' di Mario Monicelli.','android.resource://com.example.test.appancona/drawable/lanterna');
INSERT INTO `punti_interesse` VALUES (12,'Terrazza del Passetto','Parchi e Natura','Terrazza del Passetto','Una bellissima terrazza che si affaccia sul mare collegata alla scalinata più famosa e maestosa di Ancona che dal monumento dei Caduti conduce alla spiaggia cittadina del Passetto, dove trovate le suggestive grotte dei pescatori dalle porticine in legno colorate e la Seggiola del Papa.Vista dal mare la scalinata prende la forma di un’aquila dove il Monumento ai Caduti ne rappresenta la corona.','android.resource://com.example.test.appancona/drawable/terrazza');
INSERT INTO `punti_interesse` VALUES (13,'Duomo di Ancona','Monumenti Religiosi','Piazzale del Duomo 9','Il duomo di Ancona è dedicato a san Ciriaco ed è la cattedrale metropolitana dell''arcidiocesi di Ancona-Osimo. È una chiesa medioevale in cui lo stile romanico si fonde con quello bizantino, evidente nella pianta e in molte decorazioni. Sorge in scenografica posizione alla sommità del colle Guasco, già occupata dall''Acropoli della città greco-dorica, da dove domina tutta la città di Ancona e il suo golfo. Nel maggio del 1926 papa Pio XI l''ha elevata alla dignità di basilica minore.','android.resource://com.example.test.appancona/drawable/duomo');
INSERT INTO `punti_interesse` VALUES (14,'Chiesa di San Domenico','Monumenti Religiosi','Piazza del Plebiscito','L''attuale chiesa fu progettata da Carlo Marchionni nel 1763. La prima pietra fu posta nel 1771. Con l''occupazione francese la chiesa venne nel 1778 adibita a caserma, la parte superiore del prospetto principale rimase perciò incompiuta. Fu riaperta al culto nel 1816, con la Restaurazione.In seguito al terremoto del 1930, la parte superiore della facciata venne alterata per riparare ai danni. Durante i bombardamenti della Seconda guerra mondiale la chiesa venne nuovamente danneggiata e fu riaperta al culto nel 1948. ','android.resource://com.example.test.appancona/drawable/sandomenico');
INSERT INTO `punti_interesse` VALUES (15,'Chiesa di Santa Maria della Piazza','Monumenti Religiosi','Piazza Santa Maria','La chiesa di Santa Maria della Piazza si trova ad Ancona in piazza Santa Maria, nell''antico rione Porto.Eretta tra il XI e XII secolo, è un notevole esempio di stile romanico. Essa fu costruita su una chiesa paleocristiana del IV secolo restaurata nel VI. Una parte del pavimento della chiesa attuale è in vetro per permettere la visione dei mosaici paleocristiani sottostanti.','android.resource://com.example.test.appancona/drawable/santamaria');
INSERT INTO `punti_interesse` VALUES (16,'Teatro delle Muse','Luoghi Culturali','Piazzale della Republica','Il Teatro delle Muse di Ancona è, tra i teatri in cui attualmente si tengono stagioni liriche, il 13º in Italia per capienza, è inoltre il più grande teatro delle Marche.L''edificio, in stile neoclassico, è stato inaugurato nel 1827 ed è opera dell''architetto Pietro Ghinelli. Sul timpano è presente un bassorilievo allegorico che ne spiega il nome, opera dello scultore neoclassico Giacomo De Maria. Vi sono raffigurate le nove Muse, dalle quali il teatro prende il nome, e tra esse è rappresentato anche Apollo, dio delle arti, e Palemone, dio dei porti. ','android.resource://com.example.test.appancona/drawable/teatromuse');
INSERT INTO `punti_interesse` VALUES (17,'Teatro Sperimentale','Luoghi Culturali',' Via Redipuglia 59','Edificio moderno costruito nel 1962 eristrutturato a cavallo tra gli anni ’70 e ’80,ospita regolarmente stagioni di prosa, teatroper l’infanzia, serate musicali, convegni e conferenze.Accoglie allo stesso tempo attività amatoriali di associazioni Onlus, compagnie locali,scuole di danza ecc.La sala costituita di un’unica plateadegradante, conta 427 posti a sedere, più 5posti per disabili accessibili con ascensoreriservato.L’acustica perfetta e l’ottima visibilità dellascena da tutti i punti della platea, incontrano l’approvazione del pubblico edegli artisti.','android.resource://com.example.test.appancona/drawable/teatrosperimentale');
INSERT INTO `punti_interesse` VALUES (18,'Museo Archeologico delle Marche','Luoghi Culturali','Via Ferretti 6','Il Museo archeologico nazionale delle Marche si trova ad Ancona, all''interno del cinquecentesco palazzo Ferretti. Documenta in modo pressoché completo la preistoria e la protostoria del territorio marchigiano, comprende ricche collezioni relative alla civiltà greca, romana e a quella dei Galli Senoni. I reperti relativi alla civiltà picena formano la più completa raccolta esistente, per la ricchezza delle sue collezioni il museo è uno dei più importanti musei archeologici d''Italia. ','android.resource://com.example.test.appancona/drawable/archeologico');
INSERT INTO `punti_interesse` VALUES (19,'Museo Tattile Statale Omero','Luoghi Culturali','Banchina Giovanni da Chio 28','Il Museo tattile statale Omero di Ancona è uno dei pochi musei tattili al mondo dove conoscere l''arte attraverso la sorprendente prospettiva delle mani. Nato per promuovere l''integrazione delle persone con disabilità visiva è uno spazio innovativo e piacevole per tutti. L''ingresso è gratuito. ','android.resource://com.example.test.appancona/drawable/tattile');
INSERT INTO `punti_interesse` VALUES (20,'Museo del Giocattolo','Luoghi Culturali','Via Pizzecolli 9','Il Museo dell''Infanzia, ideato e creato da Gabriele Schiavoni nel 1994, dopo varie sedi ed esposizioni itineranti, ha ora la sua sede nel centro storico di Ancona.Il museo ripercorre la storia del giocattolo e la storia dell''infanzia, dall''antichità all''Ottocento romantico e pre-industriale, fino ad arrivare agli anni del boom economico. Bambole in biscuit, antichi orsi, automobiline di latta, soldatini in pasta, ricami, abiti, fotografie e tanti altri oggetti d''epoca potranno essere ammirati durante la visita.Tra gli oggetti più importanti un''opera giovanile dello scultore Medardo Rosso raffigurante una testa di bambino in cera.Di ultima creazione la Libreria Storica dell''Automobile con un catalogo di 2000 libri  concernenti le più prestigiose marche automobilistiche italiane e straniere che hanno fatto la storia, alcuni dei quali firmati da personalità di spicco del settore e in edizione limitata. ','android.resource://com.example.test.appancona/drawable/giocattolo');
INSERT INTO `punti_interesse` VALUES (21,'Arco Clementino','Monumenti Storici','Lungomare Vanvitelli 200','Fu eretto, su proposta del Vanvitelli, in onore di papa Clemente XII, per volontà del Senato anconetano, riconoscente nei confronti del pontefice che, vero e proprio mecenate di Ancona, concesse alla città il porto franco, dando nuovo impulso ai secolari traffici navali, ed incaricò il famoso architetto di ridisegnarne il porto. Fu così che sorsero il Lazzaretto e il Molo nuovo.L''arco Clementino è la porta di ingresso in città dal mare. Sorge nel punto in cui il Molo nuovo si innesta nell''antico molo romano, sul quale già si ergeva dal I secolo d.C. l''arco di Traiano. Nelle intenzioni dei promotori del progetto, l''Arco Clementino avrebbe dovuto oscurare la vista del pagano Arco di Traiano, sul suo attico avrebbe dovuto essere collocata la statua benedicente di Clemente XII e il conio di una medaglia onorifica fatta realizzare dagli anconetani e donata al pontefice, rappresentando così, assieme al Duomo in alto sul colle Guasco, la prima immagine che si sarebbe proposta ai naviganti al momento dell''ingresso nel porto dorico','android.resource://com.example.test.appancona/drawable/clementino');
CREATE TABLE IF NOT EXISTS `pun_int_tappa` (
	`_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`cod_pun_int`	int ( 11 ) NOT NULL,
	`cod_tappa`	int ( 11 ) NOT NULL,
	FOREIGN KEY(`cod_pun_int`) REFERENCES `punti_interesse`(`_id`),
	FOREIGN KEY(`cod_tappa`) REFERENCES `tappe`(`_cod_tappa`)
);

INSERT INTO `pun_int_tappa` VALUES (1,2,1);
INSERT INTO `pun_int_tappa` VALUES (2,15,2);
INSERT INTO `pun_int_tappa` VALUES (3,5,3);
INSERT INTO `pun_int_tappa` VALUES (4,21,4);
INSERT INTO `pun_int_tappa` VALUES (5,11,5);

INSERT INTO `pun_int_tappa` VALUES (6,6,6);
INSERT INTO `pun_int_tappa` VALUES (7,13,7);
INSERT INTO `pun_int_tappa` VALUES (8,14,8);
INSERT INTO `pun_int_tappa` VALUES (10,4,9);
INSERT INTO `pun_int_tappa` VALUES (11,1,10);
INSERT INTO `pun_int_tappa` VALUES (12,3,11);

INSERT INTO `pun_int_tappa` VALUES (13,10,12);
INSERT INTO `pun_int_tappa` VALUES (14,9,13);
INSERT INTO `pun_int_tappa` VALUES (15,8,14);
INSERT INTO `pun_int_tappa` VALUES (16,7,15);
INSERT INTO `pun_int_tappa` VALUES (17,12,16);

INSERT INTO `pun_int_tappa` VALUES (18,19,17);
INSERT INTO `pun_int_tappa` VALUES (19,16,18);
INSERT INTO `pun_int_tappa` VALUES (20,20,19);
INSERT INTO `pun_int_tappa` VALUES (21,18,20);
INSERT INTO `pun_int_tappa` VALUES (22,13,7);

CREATE TABLE IF NOT EXISTS `pernottamento` (
	`_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`nome`	varchar ( 50 ) NOT NULL,
	`indirizzo`	varchar ( 50 ) NOT NULL,
	`descrizione`	varchar ( 300 ) NOT NULL,
	`immagine`	varchar ( 50 ) NOT NULL,
	`prezzo_medio`	float NOT NULL,
	`telefono`	varchar ( 10 ) NOT NULL,
	`sito_internet`	varchar ( 50 ) NOT NULL,
	`parcheggio`	varchar ( 50 ) NOT NULL
);
INSERT INTO `pernottamento` VALUES (1,'Grand Hotel Passetto','Via Thaon de Revel 1','Situato sulla costa adriatica, questo elegante hotel del centro dista 1 minuto a piedi dal Monumento dedicato ai Caduti della Prima Guerra Mondiale, nel quartiere del Passetto, e 2,6 km dal Duomo di Ancona.','android.resource://com.example.test.appancona/drawable/hotelpassetto',71.0,'071 31307','www.grandhotelpassetto.it','si');
INSERT INTO `pernottamento` VALUES (2,'Grand Hotel Palace','Lungomare Luigi Vanvitelli 24','Affacciato sul porto e sull''Adriatico, questo hotel raffinato occupa un palazzo del XIX secolo dai soffitti affrescati, a 2 minuti a piedi dalla Loggia dei Mercanti e 13 minuti a piedi dal Duomo di Ancona.','android.resource://com.example.test.appancona/drawable/hotelpalace',103.0,'071 201813','www.grandhotelpalaceancona.com','no');
INSERT INTO `pernottamento` VALUES (3,'Hotel NH Ancona','Via Rupi di Via XXIX Settembre 14','Situato a 7 minuti a piedi dal Teatro delle Muse, che ospita spettacoli dal vivo, questo moderno hotel dista 8 minuti a piedi dalla Loggia dei Mercanti.','android.resource://com.example.test.appancona/drawable/hotelnh',92.0,'071 201171','www.nh-hotels.com','si');
INSERT INTO `pernottamento` VALUES (4,'Hotel della Vittoria','Via Fabio Filzi 2','Situato a 2,1 km dall''Arco di Traiano, questo confortevole hotel dista 10 minuti a piedi dal Monumento dedicato ai Caduti della Prima Guerra Mondiale, nel quartiere del Passetto.','android.resource://com.example.test.appancona/drawable/hotelvittoria',58.0,'071 55764','www.hoteldellavittoria.com','no');
INSERT INTO `pernottamento` VALUES (5,'Ego Hotel Ancona','Via Flaminia 220','Ubicato sulla costa adriatica, questo moderno hotel di lusso dista 3 minuti a piedi dalla stazione ferroviaria di Ancona Torrette e 7 km dal Museo Archeologico Nazionale delle Marche.','android.resource://com.example.test.appancona/drawable/hotelego',107.0,'071 2181262','www.egohotelancona.it','si');
INSERT INTO `pernottamento` VALUES (6,'Hotel Fortuna','Piazza Rosselli 15','Ubicato di fronte alla stazione ferroviaria di Ancona, questo hotel confortevole si trova nel centro città, a 1,8 km dal Teatro delle Muse e a 2,6 km dal Duomo.','android.resource://com.example.test.appancona/drawable/hotelfortuna',74.0,'071 42663','www.hotelfortuna.it','si');
INSERT INTO `pernottamento` VALUES (7,'Albergo Gino','Via Flaminia 4','Situato in una strada con negozi e ristoranti di fronte alla stazione ferroviaria di Ancona, questo hotel sobrio a conduzione familiare dista 3 km sia dall''Arco di Traiano sia dalla Cattedrale di San Ciriaco, in stile romanico-bizantino e gotico','android.resource://com.example.test.appancona/drawable/hotelgino',61.0,'071 42996','www.albergogino.it','si');
INSERT INTO `pernottamento` VALUES (8,'Hotel Europa','Via Sentino 3','Questo moderno hotel dista 5 minuti a piedi dalla stazione ferroviaria di Ancona Torrette e 7 km dalla storica Loggia dei Mercanti e dall''Arco di Traiano, preziosa testimonianza dell''architettura romana','android.resource://com.example.test.appancona/drawable/hoteleuropa',66.0,'071 888096','www.hoteleuropa-ancona.com','si');
INSERT INTO `pernottamento` VALUES (9,'Agriturismo Fiori del Conero','Via della Ferrovia 28a','Situato sulla costa adriatica, questo hotel rurale in mattoni rossi dista 2,3 km dal Monumento dedicato ai Caduti della Prima Guerra Mondiale, nel quartiere del Passetto vicino al mare, 4,7 km dal Duomo di Ancona, in stile romanico-gotico, e 5 km dall''Arco di Traiano.','android.resource://com.example.test.appancona/drawable/hotelfiori',72.0,'388 4985967','www.fioridelconero.it','si');
INSERT INTO `pernottamento` VALUES (10,'Conero Boat&Breakfast','Via Mascino','Passate la vostra notte speciale a bordo di un mini-yacht godendovi al meglio il vostro soggiorno nella splendida cornice di Marina Dorica','android.resource://com.example.test.appancona/drawable/hotelboat',45.0,'328 2540741','www.coneroboat.it','si');
CREATE TABLE IF NOT EXISTS `pern_tappa` (
	`_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`cod_pern`	int ( 11 ) NOT NULL,
	`cod_tappa`	int ( 11 ) NOT NULL,
	FOREIGN KEY(`cod_pern`) REFERENCES `pernottamento`(`_id`),
	FOREIGN KEY(`cod_tappa`) REFERENCES `tappe`(`_cod_tappa`)
);
CREATE TABLE IF NOT EXISTS `percorsi` (
	`_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`tipo_percorso`	varchar ( 50 ) NOT NULL,
	`descrizione`	varchar ( 300 ) NOT NULL,
	`immagine`	varchar ( 50 ) NOT NULL
);
INSERT INTO `percorsi` VALUES (1,'Percorso del Porto Antico','Questo percorso parte dal Lazzaretto e percorre la costa fino ad immergersi nella suggestiva cornice del Porto Antico di Ancona','android.resource://com.example.test.appancona/drawable/ancora');
INSERT INTO `percorsi` VALUES (2,'Percorso del Centro Cittadino','Questo percorso parte dall''Anfiteatro romano e percorre il centro di Ancona racchiudendo,al suo interno, alcuni dei luoghi più caratteristici della città, fino ad arrivare al monumento dei caduti del Passetto.','android.resource://com.example.test.appancona/drawable/centrocitta');
INSERT INTO `percorsi` VALUES (3,'Percorso Naturale','Questo percorso è stato creato per tutte quelle persone che amano immergersi nella natura. Si inizia con un giro dei vari parchi che caratterizzano Ancona e si termina con il panorama mozzafiato della terrazza del Passetto. ','android.resource://com.example.test.appancona/drawable/iconaparchi');
INSERT INTO `percorsi` VALUES (4,'Percorso Culturale','Questo percorso è l''ideale di ogni amante dell''arte e della cultura. Con una scelta varia di teatri e musei e finendo poi con la maestosità del Duomo di Ancona. ','android.resource://com.example.test.appancona/drawable/libri');
INSERT INTO `percorsi` VALUES (5,'Percorso Gastronomico','Un viaggio attraverso i sapori della città, tra locali dove gustare buon cibo e negozi di prodotti tipici','android.resource://com.example.test.appancona/drawable/gastronomico');
CREATE TABLE IF NOT EXISTS `negozi_tipici` (
	`_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`nome`	varchar ( 50 ) NOT NULL,
	`indirizzo`	varchar ( 50 ) NOT NULL,
	`descrizione`	varchar ( 300 ) NOT NULL,
	`orari`	varchar ( 20 ) NOT NULL,
	`giorno_chiusura`	varchar ( 50 ) NOT NULL,
	`telefono`	varchar ( 10 ) NOT NULL,
	`sito_internet`	varchar ( 50 ) NOT NULL,
	`immagine`	varchar ( 50 ) NOT NULL
);
INSERT INTO `negozi_tipici` VALUES (1,'Bottega Monastica','Corso Stamira 13','Negozio di prodotti tipici legati ai monasteri.Più di 40 Monasteri produttori sparsi per l’Italia, la Francia, il Belgio e l’Olanda. Alcuni sono già conosciuti e affermati, altri stanno emergendo con produzioni particolari e ricercate (anche con certificazione biologica).','09:30-12:30 16:00-19:00','Domenica','329 9662526','www.bottegamonastica.com','android.resource://com.example.test.appancona/drawable/monastica');
INSERT INTO `negozi_tipici` VALUES (2,'Bottega Re Formaggio','Piazza J.F.Kennedy 10','Negozio di specialità alimentari.','08:30-12:30 16:30-19:30','Domenica pomeriggio','071 201771','www.facebook.com/bottegareformaggio/','android.resource://com.example.test.appancona/drawable/reformaggio');
INSERT INTO `negozi_tipici` VALUES (3,'La Congrega','Via degli Orefici 5','Progettiamo e realizziamo manufatti tessili d''arredo: tende,tovaglie,arazzi,cuscini e copriletti.I tessuti di base sono in fibra naturale: lino,cotone,canapa','10:30-12:30 16:00-19:30','Domenica e Lunedi','333 8288659','www.lacongrega.net','android.resource://com.example.test.appancona/drawable/congrega');
INSERT INTO `negozi_tipici` VALUES (4,'Bontà delle marche','Corso Giuseppe Mazzini 96','Solo le eccellenze della tradizione enogastronomica marchigianae italiana, prodotti di qualità superiore, selezionati con cura.Piaceri per il palato e per l’anima. Vini D.O.C e D.O.C.G.,una ricca selezione di distillati, una selezione incredibile di pietanze d’asporto per tutti i gusti.','09:00-20:00','Domenica pomeriggio','071 53985','www.bontadellemarche.it','android.resource://com.example.test.appancona/drawable/bontamarche');
CREATE TABLE IF NOT EXISTS `negoz_tappa` (
	`_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`cod_negoz`	int ( 11 ) NOT NULL,
	`cod_tappa`	int ( 11 ) NOT NULL,
	FOREIGN KEY(`cod_negoz`) REFERENCES `negozi_tipici`(`_id`),
	FOREIGN KEY(`cod_tappa`) REFERENCES `tappe`(`_cod_tappa`)
);
INSERT INTO `negoz_tappa` VALUES (1,4,23);

INSERT INTO `tappe_percorsi` VALUES (1,1,1,1);
INSERT INTO `tappe_percorsi` VALUES (2,1,2,2);
INSERT INTO `tappe_percorsi` VALUES (3,1,3,3);
INSERT INTO `tappe_percorsi` VALUES (4,1,4,4);
INSERT INTO `tappe_percorsi` VALUES (5,1,5,5);

INSERT INTO `tappe_percorsi` VALUES (6,2,6,1);
INSERT INTO `tappe_percorsi` VALUES (7,2,7,2);
INSERT INTO `tappe_percorsi` VALUES (8,2,8,3);
INSERT INTO `tappe_percorsi` VALUES (9,2,9,4);
INSERT INTO `tappe_percorsi` VALUES (10,2,10,5);
INSERT INTO `tappe_percorsi` VALUES (11,2,11,6);

INSERT INTO `tappe_percorsi` VALUES (12,3,12,1);
INSERT INTO `tappe_percorsi` VALUES (13,3,13,2);
INSERT INTO `tappe_percorsi` VALUES (14,3,14,3);
INSERT INTO `tappe_percorsi` VALUES (15,3,15,4);
INSERT INTO `tappe_percorsi` VALUES (16,3,16,5);

INSERT INTO `tappe_percorsi` VALUES (17,4,17,1);
INSERT INTO `tappe_percorsi` VALUES (18,4,18,2);
INSERT INTO `tappe_percorsi` VALUES (19,4,19,3);
INSERT INTO `tappe_percorsi` VALUES (20,4,20,4);
INSERT INTO `tappe_percorsi` VALUES (21,4,7,5);

INSERT INTO `tappe_percorsi` VALUES (22,5,21,1);
INSERT INTO `tappe_percorsi` VALUES (23,5,22,2);
INSERT INTO `tappe_percorsi` VALUES (24,5,23,3);
INSERT INTO `tappe_percorsi` VALUES (25,5,24,4);
INSERT INTO `tappe_percorsi` VALUES (26,5,25,5);

COMMIT;
