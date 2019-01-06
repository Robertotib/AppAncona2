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
INSERT INTO `tipi_punti_interesse` VALUES ('Parchi e Aree Verdi','android.resource://com.example.test.appancona/drawable/iconaparchi');
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
INSERT INTO `servizi` VALUES (1,'Ospedale 1','Ospedali','descrizione','android.resource://com.example.test.appancona/drawable/pernottamento','Via Piave 5','0714345621','www.sito.it','email@email.it');
INSERT INTO `servizi` VALUES (2,'Stazione 1','Stazione','descrizione','android.resource://com.example.test.appancona/drawable/puntiinteresse','Via Torresi 15','0714345621','www.sito.it','email@email.it');
INSERT INTO `servizi` VALUES (3,'Centrale 1','Carabinieri','descrizione','android.resource://com.example.test.appancona/drawable/pernottamento','Via Oddo di Biagio 25','0714345621','www.sito.it','email@email.it');
INSERT INTO `servizi` VALUES (4,'Farmacia 1','Farmacie','descrizione','android.resource://com.example.test.appancona/drawable/puntiinteresse','Via Goito 30','0714345621','www.sito.it','email@email.it');
INSERT INTO `servizi` VALUES (5,'Supermercato 1','Supermercati','descrizione','android.resource://com.example.test.appancona/drawable/pernottamento','Corso Giuseppe Mazzini 18','0714345621','www.sito.it','email@email.it');
INSERT INTO `servizi` VALUES (6,'Ufficio Postale 1','Ufficio Postale','descrizione','android.resource://com.example.test.appancona/drawable/puntiinteresse','Via Lazzaro Bernabei 1','0714345621','www.sito.it','email@email.it');
INSERT INTO `servizi` VALUES (7,'Parcheggio 1','Parcheggi','descrizione','android.resource://com.example.test.appancona/drawable/puntiinteresse','Via Volturno 3','0714345621','www.sito.it','email@email.it');
CREATE TABLE IF NOT EXISTS `serv_tappa` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`cod_serv`	int ( 11 ) NOT NULL,
	`cod_tappa`	int ( 11 ) NOT NULL,
	FOREIGN KEY(`cod_tappa`) REFERENCES `tappe`(`id`),
	FOREIGN KEY(`cod_serv`) REFERENCES `servizi`(`id`)
);
CREATE TABLE IF NOT EXISTS `ristorazione` (
	`_id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`nome`	varchar ( 50 ) NOT NULL,
	`indirizzo`	varchar ( 50 ) NOT NULL,
	`descrizione`	varchar ( 50 ) NOT NULL,
	`immagine`	varchar ( 50 ) NOT NULL,
	`orari`	varchar ( 20 ) NOT NULL,
	`giorno_chiusura`	varchar ( 50 ) NOT NULL,
	`numero_coperti`	int ( 3 ) NOT NULL,
	`prezzo_medio`	float NOT NULL,
	`telefono`	varchar ( 10 ) NOT NULL,
	`sito_internet`	varchar ( 50 ) NOT NULL,
	`parcheggio`	varchar ( 10 ) NOT NULL
);
INSERT INTO `ristorazione` VALUES (1,'pizzeria 1','Via Piave 5','descrizione','android.resource://com.example.test.appancona/drawable/rist2','08:00-13:00 16:00-20:00','domenica',10,10.25,'071123456','www.sito.it','si');
INSERT INTO `ristorazione` VALUES (2,'pizzeria 2','Via Breccie Bianche 13','descrizione','android.resource://com.example.test.appancona/drawable/lacitta','08:00-13:00 16:00-20:00','domenica',10,30.0,'071123456','www.sito.it','no');
INSERT INTO `ristorazione` VALUES (3,'pizzeria 3','Via Francesco Petrarca 30','descrizione','android.resource://com.example.test.appancona/drawable/puntiinteresse','08:00-13:00 16:00-20:00','domenica',10,200.0,'071123456','www.sito.it','si');
INSERT INTO `ristorazione` VALUES (4,'pizzeria 4','Via Cingoli 2','descrizione','android.resource://com.example.test.appancona/drawable/rist2','08:00-13:00 16:00-20:00','domenica',10,10.25,'071123456','www.sito.it','si');
INSERT INTO `ristorazione` VALUES (5,'pizzeria 5','Via Valle Miano 23','descrizione','android.resource://com.example.test.appancona/drawable/pernottamento','08:00-13:00 16:00-20:00','domenica',10,120.0,'071123456','www.sito.it','no');
INSERT INTO `ristorazione` VALUES (6,'pizzeria 6','Via Guglielmo Marconi 171','descrizione','android.resource://com.example.test.appancona/drawable/rist2','08:00-13:00 16:00-20:00','domenica',10,60.0,'071123456','www.sito.it','no');
INSERT INTO `ristorazione` VALUES (7,'pizzeria 7','Pizza del Plebiscito','descrizione','android.resource://com.example.test.appancona/drawable/lacitta','08:00-13:00 16:00-20:00','domenica',10,70.0,'071123456','www.sito.it','si');
INSERT INTO `ristorazione` VALUES (8,'pizzeria 8','Via Astagno 70','descrizione','android.resource://com.example.test.appancona/drawable/puntiinteresse','08:00-13:00 16:00-20:00','domenica',10,153.0,'071123456','www.sito.it','si');
INSERT INTO `ristorazione` VALUES (9,'pizzeria 9','Via Marsala 20','descrizione','android.resource://com.example.test.appancona/drawable/rist2','08:00-13:00 16:00-20:00','domenica',10,27.0,'071123456','www.sito.it','si');
INSERT INTO `ristorazione` VALUES (10,'pizzeria 10','Piazza Cavour','descrizione','android.resource://com.example.test.appancona/drawable/pernottamento','08:00-13:00 16:00-20:00','domenica',10,94.0,'071123456','www.sito.it','si');
CREATE TABLE IF NOT EXISTS `rist_tappa` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`cod_ristorazione`	int ( 11 ) NOT NULL,
	`cod_tappa`	int ( 11 ) NOT NULL,
	FOREIGN KEY(`cod_ristorazione`) REFERENCES `ristorazione`(`id`),
	FOREIGN KEY(`cod_tappa`) REFERENCES `tappe`(`id`)
);
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
INSERT INTO `punti_interesse` VALUES (5,'Arco di Traiano','Monumenti Storici','Lungomare Vanvitelliano','L''arco di Traiano di Ancona rappresenta una delle testimonianze monumentali più preziose dell''architettura romana, anche per il suo ottimo stato di conservazione. Le sue proporzioni, particolarmente eleganti perché più slanciate rispetto agli altri archi romani, sono la sua caratteristica più saliente, insieme allo stretto rapporto con il mare, sorgendo sul molo del porto di Ancona fatto costruire nel I° secolo dall''imperatore Traiano. Ha un singolo fornice affiancato da due coppie di colonne corinzie scanalate. Le iscrizioni poste sull''attico sono ancora perfettamente leggibili.Venne eretto, in marmo proconnesio, dal Senato e dal popolo di Roma probabilmente ad opera dell''architetto siriano Apollodoro di Damasco per onorare l''imperatore che aveva donato ai naviganti un più sicuro accesso all''Italia, avendo fatto ampliare, a proprie spese, il porto della città.','android.resource://com.example.test.appancona/drawable/arcotraiano');
INSERT INTO `punti_interesse` VALUES (6,'Anfiteatro romano','Monumenti Storici','Piazza Anfiteatro','L''anfiteatro romano di Ancona, situato tra i colli Guasco e dei Cappuccini, costituisce, dopo l''arco di Traiano, l''opera architettonica di epoca romana più importante della città. Lo scavo è pressoché completato nel settore meridionale, dove è visibile un lungo tratto del muro di cinta, l''ingresso principale e alcuni ingressi per gli spettatori.Vi erano due ingressi all''arena, situati ai due estremi dell''asse maggiore dell''ellisse: la porta pompae, destinato all''ingresso della processione gladiatoria, e la porta libitinensis, consacrata alla dea che presiedeva il passaggio all''aldilà, da cui uscivano i gladiatori moribondi e morti durante i combattimenti. Esistevano inoltre diversi ingressi utilizzati dagli spettatori, che conducevano ai vari settori della cavea.A volte questi ingressi non erano dotati di scale, ma arrivavano direttamente nel settore, sfruttando la pendenza naturale del terreno.','android.resource://com.example.test.appancona/drawable/anfiteatro');
INSERT INTO `punti_interesse` VALUES (7,'Parco del Cardeto','Parchi e Aree Verdi','Parco del Cardeto','Il Parco del Cardeto è il più vasto parco urbano di Ancona. A picco sul mare, occupa le sommità dei colli Cappuccini e Cardeto e si estende in un''area di circa 35 ettari, tutti a ridosso del centro.','android.resource://com.example.test.appancona/drawable/parcocardeto');
INSERT INTO `punti_interesse` VALUES (8,'Parco del Pincio','Parchi e Aree Verdi','Piazzale Loreto','il Pincio, piccolo, ma di grande importanza storica dato che è il più antico della città, essendo sorto dopo la presa di Roma del 1870. Il nome ricorda infatti il famoso Pincio della capitale, nel quale Mazzini fece porre le statue degli Italiani più celebri. Per rievocare il suo omonimo romano, il Pincio di Ancona è ricco di sempreverdi, ha un impianto geometrico dei sentieri ed ha un belvedere da cui si gode di un''ampia vista sulla città.','android.resource://com.example.test.appancona/drawable/rist2');
INSERT INTO `punti_interesse` VALUES (9,'Parco della Cittadella','Parchi e Aree Verdi','Parco della Cittadella','Ad Ancona, sulla sommità del colle Astagno ed all''interno dell''antico campo trincerato si trova il Parco della Cittadella, che prende il nome dall''adiacente Cittadella, cinquecentesca, sovrastante la città ed il porto di Ancona.Il parco venne aperto negli anni Settanta ed inizialmente era collegato alla Cittadella vera e propria con una scala.','android.resource://com.example.test.appancona/drawable/cittadella');
INSERT INTO `punti_interesse` VALUES (10,'Parco Posatora','Parchi e Aree Verdi','Parco Posatora','Opera di Aristodemo Costoli, noto scultore risorgimentale. Sul basamento della statua, due bassorilievi rappresentano rispettivamente il Congresso di Parigi e la Proclamazione del Regno d''Italia ossia due momenti fondamentali dell''azione politica di Cavour.','android.resource://com.example.test.appancona/drawable/cittadella');
INSERT INTO `punti_interesse` VALUES (11,'Lanterna Rossa di Ancona','Parchi e Aree Verdi','Lanterna Rossa di Ancona','Una lanterna ma è rossa a causa edel sangue dei nemici di Diego Milito','android.resource://com.example.test.appancona/drawable/lanterna');
INSERT INTO `punti_interesse` VALUES (12,'Terrazza del Passetto','Parchi e Aree Verdi','Terrazza del Passetto','terrazza che da sul mare','android.resource://com.example.test.appancona/drawable/terrazza');
INSERT INTO `punti_interesse` VALUES (13,'Duomo','Monumenti Religiosi','Piazzale del Duomo 9','Il duomo di Ancona è dedicato a san Ciriaco ed è la cattedrale metropolitana dell''arcidiocesi di Ancona-Osimo. È una chiesa medioevale in cui lo stile romanico si fonde con quello bizantino, evidente nella pianta e in molte decorazioni. Sorge in scenografica posizione alla sommità del colle Guasco, già occupata dall''Acropoli della città greco-dorica, da dove domina tutta la città di Ancona e il suo golfo. Nel maggio del 1926 papa Pio XI l''ha elevata alla dignità di basilica minore.','android.resource://com.example.test.appancona/drawable/duomo');
INSERT INTO `punti_interesse` VALUES (14,'Chiesa di San Domenico','Monumenti Religiosi','Piazza del Plebiscito','L''attuale chiesa fu progettata da Carlo Marchionni nel 1763. La prima pietra fu posta nel 1771. Con l''occupazione francese la chiesa venne nel 1778 adibita a caserma, la parte superiore del prospetto principale rimase perciò incompiuta. Fu riaperta al culto nel 1816, con la Restaurazione.In seguito al terremoto del 1930, la parte superiore della facciata venne alterata per riparare ai danni. Durante i bombardamenti della Seconda guerra mondiale la chiesa venne nuovamente danneggiata e fu riaperta al culto nel 1948. ','android.resource://com.example.test.appancona/drawable/sandomenico');
INSERT INTO `punti_interesse` VALUES (15,'Chiesa di Santa Maria della Piazza','Monumenti Religiosi','Piazza Santa Maria','La chiesa di Santa Maria della Piazza si trova ad Ancona in piazza Santa Maria, nell''antico rione Porto.Eretta tra il XI e XII secolo, è un notevole esempio di stile romanico. Essa fu costruita su una chiesa paleocristiana del IV secolo restaurata nel VI. Una parte del pavimento della chiesa attuale è in vetro per permettere la visione dei mosaici paleocristiani sottostanti.','android.resource://com.example.test.appancona/drawable/santamaria');
INSERT INTO `punti_interesse` VALUES (16,'Teatro delle Muse','Luoghi Culturali','Piazzale della Republica','Il Teatro delle Muse di Ancona è, tra i teatri in cui attualmente si tengono stagioni liriche, il 13º in Italia per capienza, è inoltre il più grande teatro delle Marche.L''edificio, in stile neoclassico, è stato inaugurato nel 1827 ed è opera dell''architetto Pietro Ghinelli. Sul timpano è presente un bassorilievo allegorico che ne spiega il nome, opera dello scultore neoclassico Giacomo De Maria. Vi sono raffigurate le nove Muse, dalle quali il teatro prende il nome, e tra esse è rappresentato anche Apollo, dio delle arti, e Palemone, dio dei porti. ','android.resource://com.example.test.appancona/drawable/teatromuse');
INSERT INTO `punti_interesse` VALUES (17,'Teatro Sperimentale','Luoghi Culturali',' Via Redipuglia 59','Edificio moderno costruito nel 1962 eristrutturato a cavallo tra gli anni ’70 e ’80,ospita regolarmente stagioni di prosa, teatroper l’infanzia, serate musicali, convegni e conferenze.Accoglie allo stesso tempo attività amatoriali di associazioni Onlus, compagnie locali,scuole di danza ecc.La sala costituita di un’unica plateadegradante, conta 427 posti a sedere, più 5posti per disabili accessibili con ascensoreriservato.L’acustica perfetta e l’ottima visibilità dellascena da tutti i punti della platea, incontrano l’approvazione del pubblico edegli artisti.','android.resource://com.example.test.appancona/drawable/teatrosperimentale');
INSERT INTO `punti_interesse` VALUES (18,'Museo Archeologico delle Marche','Luoghi Culturali','Via Ferretti 6','Il Museo archeologico nazionale delle Marche si trova ad Ancona, all''interno del cinquecentesco palazzo Ferretti. Documenta in modo pressoché completo la preistoria e la protostoria del territorio marchigiano, comprende ricche collezioni relative alla civiltà greca, romana e a quella dei Galli Senoni. I reperti relativi alla civiltà picena formano la più completa raccolta esistente, per la ricchezza delle sue collezioni il museo è uno dei più importanti musei archeologici d''Italia. ','android.resource://com.example.test.appancona/drawable/statuacavour');
INSERT INTO `punti_interesse` VALUES (19,'Museo Tattile Statale Omero','Luoghi Culturali','Banchina Giovanni da Chio 28','Il Museo tattile statale Omero di Ancona è uno dei pochi musei tattili al mondo dove conoscere l''arte attraverso la sorprendente prospettiva delle mani. Nato per promuovere l''integrazione delle persone con disabilità visiva è uno spazio innovativo e piacevole per tutti. L''ingresso è gratuito. ','android.resource://com.example.test.appancona/drawable/statuacavour');
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
	`parcheggio`	varchar ( 50 ) NOT NULL
);
INSERT INTO `pernottamento` VALUES (1,'hotel 1','Via Marconi 22','descrizione','android.resource://com.example.test.appancona/drawable/pernottamento',20.0,'0723123456','www.sito.it','si');
INSERT INTO `pernottamento` VALUES (2,'hotel 2','Via Tavernelle 2','descrizione','android.resource://com.example.test.appancona/drawable/lacitta',40.0,'0723123456','www.sito.it','no');
INSERT INTO `pernottamento` VALUES (3,'hotel 3','Via Piave 5','descrizione','android.resource://com.example.test.appancona/drawable/servizi',200.0,'0723123456','www.sito.it','no');
INSERT INTO `pernottamento` VALUES (4,'hotel 4','Piazza Roma','descrizione','android.resource://com.example.test.appancona/drawable/pernottamento',130.0,'0723123456','www.sito.it','si');
INSERT INTO `pernottamento` VALUES (5,'hotel 5','Via Kennedy','descrizione','android.resource://com.example.test.appancona/drawable/lacitta',70.0,'0723123456','www.sito.it','no');
INSERT INTO `pernottamento` VALUES (6,'hotel 6','Via del Faro 6','descrizione','android.resource://com.example.test.appancona/drawable/servizi',160.0,'0723123456','www.sito.it','si');
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
INSERT INTO `percorsi` VALUES (1,'Percorso 1','1','android.resource://com.example.test.appancona/drawable/iconaparchi');
INSERT INTO `percorsi` VALUES (2,'Percorso 2','2','android.resource://com.example.test.appancona/drawable/iconaculturali');
INSERT INTO `percorsi` VALUES (3,'Percorso 3','3','android.resource://com.example.test.appancona/drawable/parthenon');
INSERT INTO `percorsi` VALUES (4,'Percorso 4','4','android.resource://com.example.test.appancona/drawable/farmacia');
INSERT INTO `percorsi` VALUES (5,'Percorso 5','5','android.resource://com.example.test.appancona/drawable/stazione');
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
INSERT INTO `negozi_tipici` VALUES (1,'negozio 1','Piazza Kennedy','descrizione','08:00-13:00 16:00-20:00','domenica','071123456','www.sito.it','android.resource://com.example.test.appancona/drawable/rist2');
INSERT INTO `negozi_tipici` VALUES (2,'negozio 2','Piazza Roma','descrizione','08:00-13:00 16:00-20:00','domenica','071123456','www.sito.it','android.resource://com.example.test.appancona/drawable/lacitta');
CREATE TABLE IF NOT EXISTS `negoz_tappa` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`cod_negoz`	int ( 11 ) NOT NULL,
	`cod_tappa`	int ( 11 ) NOT NULL,
	FOREIGN KEY(`cod_negoz`) REFERENCES `negozi_tipici`(`_id`),
	FOREIGN KEY(`cod_tappa`) REFERENCES `tappe`(`id`)
);
COMMIT;
