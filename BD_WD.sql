
DROP TABLE IF EXISTS `autre`;
CREATE TABLE IF NOT EXISTS `autre` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  `ido` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_Generalisation_2` (`ido`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



DROP TABLE IF EXISTS `cartecin`;
CREATE TABLE IF NOT EXISTS `cartecin` (
  `NUMCIN` varchar(255) NOT NULL,
  `ADRESSE` varchar(255) DEFAULT NULL,
  `DATENESS` datetime DEFAULT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  `PRENOM` varchar(255) DEFAULT NULL,
  `ido` int(11) DEFAULT NULL,
  PRIMARY KEY (`NUMCIN`),
  KEY `FK_Generalisation_3` (`ido`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `center`;
CREATE TABLE IF NOT EXISTS `center` (
  `IDCENTER` int(11) NOT NULL AUTO_INCREMENT,
  `mot_de_passe` varchar(200) DEFAULT NULL,
  `NONCENTER` varchar(255) DEFAULT NULL,
  `VILLE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IDCENTER`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;


INSERT INTO `center` (`IDCENTER`, `mot_de_passe`, `NONCENTER`, `VILLE`) VALUES
(6, '0000', 'admin', 'tunis'),
(7, '0000', 'dar chabenne', 'nabeul'),
(8, 'a', 'a', 'a');



DROP TABLE IF EXISTS `object`;
CREATE TABLE IF NOT EXISTS `object` (
  `IDO` int(11) NOT NULL AUTO_INCREMENT,
  `TYPEOBJECT` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IDO`)
) ENGINE=InnoDB AUTO_INCREMENT=3001 DEFAULT CHARSET=latin1;



DROP TABLE IF EXISTS `passeport`;
CREATE TABLE IF NOT EXISTS `passeport` (
  `CIN` varchar(255) NOT NULL,
  `CODEDUPAYS` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `DATEDENAISSANCE` datetime DEFAULT NULL,
  `NUMERODUPASSEPORT` varchar(255) DEFAULT NULL,
  `SEXE` varchar(255) DEFAULT NULL,
  `TYPEDEPASSEPORT` varchar(255) DEFAULT NULL,
  `ido` int(11) DEFAULT NULL,
  PRIMARY KEY (`CIN`),
  KEY `FK_Generalisation_1` (`ido`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
  `CIN` varchar(255) NOT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  `PRENOM` varchar(255) DEFAULT NULL,
  `TELE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CIN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `reclamation`;
CREATE TABLE IF NOT EXISTS `reclamation` (
  `IDRECLAMATION` int(11) NOT NULL AUTO_INCREMENT,
  `DATERECLAMATION` datetime DEFAULT NULL,
  `TYPERECLAMATION` varchar(255) DEFAULT NULL,
  `idCenter` int(11) DEFAULT NULL,
  `ido` int(11) DEFAULT NULL,
  `cin` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IDRECLAMATION`),
  KEY `FK_association1` (`cin`),
  KEY `FK_association3` (`ido`),
  KEY `FK_association4` (`idCenter`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


ALTER TABLE `autre`
  ADD CONSTRAINT `FK_Generalisation_2` FOREIGN KEY (`ido`) REFERENCES `object` (`IDO`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `cartecin`
  ADD CONSTRAINT `FK_Generalisation_3` FOREIGN KEY (`ido`) REFERENCES `object` (`IDO`) ON DELETE CASCADE ON UPDATE CASCADE;


ALTER TABLE `passeport`
  ADD CONSTRAINT `FK_Generalisation_1` FOREIGN KEY (`ido`) REFERENCES `object` (`IDO`) ON DELETE CASCADE ON UPDATE CASCADE;


ALTER TABLE `reclamation`
  ADD CONSTRAINT `FK_association1` FOREIGN KEY (`cin`) REFERENCES `personne` (`CIN`),
  ADD CONSTRAINT `FK_association3` FOREIGN KEY (`ido`) REFERENCES `object` (`IDO`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_association4` FOREIGN KEY (`idCenter`) REFERENCES `center` (`IDCENTER`);
COMMIT;

