BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS `promocje` (
	`idpromocji`	int ( 11 ) NOT NULL,
	`idmiejsca`	int ( 11 ) NOT NULL,
	`obnizka`	text NOT NULL,
	`uwagi`	text NOT NULL
);
INSERT INTO `promocje` VALUES (1,1,'-30%','Na obuwie i torebki');
INSERT INTO `promocje` VALUES (2,2,'-20%','na kolekcję wiosna-lato 2018');
INSERT INTO `promocje` VALUES (3,3,'-50%','Na kolekcję damską');
INSERT INTO `promocje` VALUES (4,4,'-50zł','na obuwie marki Salomon');
INSERT INTO `promocje` VALUES (5,5,'-70%','na wybrane produkty');
CREATE TABLE IF NOT EXISTS `miejsca` (
	`idmiejsca`	int ( 11 ) NOT NULL,
	`nazwa`	text NOT NULL,
	`szerokosc`	float NOT NULL,
	`dlugosc`	float NOT NULL,
	`kategoria`	text NOT NULL
);
INSERT INTO `miejsca` VALUES (1,'Badura',50.0532,19.9559,'obuwie');
INSERT INTO `miejsca` VALUES (2,'Clarks',50.0668,19.9456,'akcesoria');
INSERT INTO `miejsca` VALUES (3,'Adidas',50.0639,19.9999,'odzież, obuwie');
INSERT INTO `miejsca` VALUES (4,'Martes Sport',50.0279,19.9506,'obuwie');
INSERT INTO `miejsca` VALUES (5,'Empik',50.0631,19.9399,'papiernicze');
COMMIT;
