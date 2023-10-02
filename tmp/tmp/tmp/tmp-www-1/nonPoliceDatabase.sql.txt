-- MariaDB dump 10.19  Distrib 10.10.2-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: nonPoliceDatabase
-- ------------------------------------------------------
-- Server version	10.10.2-MariaDB-1:10.10.2+maria~ubu2204

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(80) DEFAULT NULL,
  `lastname` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES
(1,'jason','meiers');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `homicide`
--

DROP TABLE IF EXISTS `homicide`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `homicide` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(20) DEFAULT NULL,
  `lastname` varchar(20) DEFAULT NULL,
  `suspect` varchar(80) DEFAULT NULL,
  `bpm` varchar(200) DEFAULT NULL,
  `witness` varchar(200) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `homicide`
--

LOCK TABLES `homicide` WRITE;
/*!40000 ALTER TABLE `homicide` DISABLE KEYS */;
INSERT INTO `homicide` VALUES
(1,'Wolfgang','Lux','Dr. Dieter Zetsche, Ginni Rommeti','ibm,daimler,ibm.damiler,ibm.damiler.apple,ibm.daimlier.visa,visa,ibm.daimler.yahoo','Denise Genzer, (otto-hahn-strasse,carl-benz-strasse,rudolf-diesel-strasse), Micheala Meiers (Daimler Alle)','Assuemd Daimler Ag killed Wolfgang Lux Munzesheim and Linkehei for malprtactice in business process managment. Dagoubert Duck tranl. Schoorge','1994-01-01 00:00:00'),
(2,'Unknown','Rampf','Dr. Dieter Zetsche, Ginni Rommeti','ibm.daimler.cisco.monitoring,ibm.daimler.apple,ibm.daimler','Denise Genzer, (otto-hahn-strasse,carl-benz-strasse,rudolf-diesel-strasse), Micheala Meiers (Daimler Alle)','Assuemd Daimler Ag killed Herr Rampf Linkehei for malprtactice in business process managment.','1995-01-01 00:00:00'),
(3,'?','?','Dr. Dieter Zetsche','ibm.dmielr.pope.saint.niclouse,vggg.nonPolicePrisonBPMLogical.lingsutis(\'schulz\')','Denise Genzer, (otto-hahn-strasse,carl-benz-strasse,rudolf-diesel-strasse), Micheala Meiers (Daimler Alle)','Assuemd Daimler Ag killed \'crime does not pay\' band member ibm.dmielr.pope.saint.niklouse','1995-01-01 00:00:00'),
(4,'','','Dr. Dieter Zetsche','ibm.daimler','Denise Genzer, (otto-hahn-strasse,carl-benz-strasse,rudolf-diesel-strasse), Micheala Meiers (Daimler Alle)','malprtactice in business process managment.','1996-01-01 00:00:00'),
(5,'Wolfgang','Lux','Dr. Dieter Zetscher','ibm.daimler','Denise Genzer, (otto-hahn-strasse,carl-benz-strasse,rudolf-diesel-strasse), Micheala Meiers (Daimler Alle)','Assuemd Daimler Ag killed Wolfgang Lux Munzesheim and Linkehei for malprtactice in business process managment.','1996-01-01 00:00:00'),
(6,'Boris','?','Dr. Dieter Zetscher','ibm.daimler.unimog,ibm,daimler,ibm.damiler,ibm.damiler.apple,ibm.daimlier.visa,visa','Denise Genzer, (otto-hahn-strasse,carl-benz-strasse,rudolf-diesel-strasse), Micheala Meiers (Daimler Alle)','Assuemd Daimler Ag killed Boris ? on motocylce in Wulfschluch for malprtactice in business process managment. Schoorge Cherrytree Wolf, Gorbhacoe(patricia)','1998-01-01 00:00:00'),
(7,'Ariana','Johs','Dr. Dieter Zetscher','ibm,daimler,ibm.damiler,ibm.damiler.apple,ibm.daimlier.visa,visa,ibm.dmiler.chair.ginni.rommti,ibm.daimler.apple.davidsion','Denise Genzer, (otto-hahn-strasse,carl-benz-strasse,rudolf-diesel-strasse), Micheala Meiers (Daimler Alle)','for malpratice in bpm mayors daugher 8th and 8th Grade internalt link(IPX) to davis internmidiate school Kathy Boden','2000-01-01 00:00:00'),
(9,'Kyrstal','Fisher','Dr. Dieter Zetscher','ibm,daimler,ibm.damiler,ibm.damiler.apple,ibm.daimlier.visa,visa,ibm.damiler.chair.ginni.rommit.nonPoliceSignture','Denise Genzer, (otto-hahn-strasse,carl-benz-strasse,rudolf-diesel-strasse), Micheala Meiers (Daimler Alle)','malpractivce in business proces mangement UN Violaitons, Austiria internal links(IPX) Cherrytree(LUX,Woflgang)','1991-01-01 00:00:00'),
(10,'?','Brushini','Ginni Rommeti','ibm,daimler,ibm.damiler,ibm.damiler.apple,ibm.daimlier.visa,visa','Denise Genzer, (otto-hahn-strasse,carl-benz-strasse,rudolf-diesel-strasse), Micheala Meiers (Daimler Alle)','for malprtactice in business process managment religosut(wake) King Adolf Gustav, Eva Braun fom Gorbachov(ibm.daimler.unmog.michelbach) ','2005-01-01 00:00:00'),
(11,'?','Brushini','Ginni Rommeti','ibm,daimler,ibm.damiler,ibm.damiler.apple,ibm.daimlier.visa,visa','Denise Genzer, (otto-hahn-strasse,carl-benz-strasse,rudolf-diesel-strasse), Micheala Meiers (Daimler Alle)','for malprtactice in business process managment religosut(wake) King Adolf Gustav, Eva Braun fom Gorbachov(ibm.daimler.unmog.michelbach) ','2005-01-01 00:00:00'),
(12,'Bill','?','Dr. Dieter Zetscher, Ginni Rommeti','ibm,daimler,ibm.damiler,ibm.damiler.apple,ibm.daimlier.visa,visa','Denise Genzer, (otto-hahn-strasse,carl-benz-strasse,rudolf-diesel-strasse), Micheala Meiers (Daimler Alle)','for malprtactice in business process managment 7475 Quartz Circle, Dublin, California Babaras Husband','2013-01-01 00:00:00'),
(13,'?','?','Dr. Dieter Zetscher','ibm,daimler,ibm.damiler,ibm.damiler.apple,ibm.daimlier.visa,visa','Denise Genzer, (otto-hahn-strasse,carl-benz-strasse,rudolf-diesel-strasse), Micheala Meiers (Daimler Alle)','for malprtactice in business process managment 777 Westmiddlefied Road, Mountain View, California ~Age 20 neighbor italien-american','2010-01-01 00:00:00'),
(14,'?','?','Dr. Dieter Zetscher, Ginni Rommeti','ibm,daimler,ibm.damiler,ibm.damiler.apple,ibm.daimlier.visa,visa','Denise Genzer, (otto-hahn-strasse,carl-benz-strasse,rudolf-diesel-strasse), Micheala Meiers (Daimler Alle)','malprtactice in business process managment. tranvestite Newark, Calfirona internatil link Angela Merkla and Assisan Ingo Welleretuer ( Gay )','2005-01-01 00:00:00'),
(15,'Welsly','?','Dr. Dieter Zetscher, Ginni Rommti','ibm,daimler,ibm.damiler,ibm.damiler.apple,ibm.daimlier.visa,visa','Denise Genzer, (otto-hahn-strasse,carl-benz-strasse,rudolf-diesel-strasse), Micheala Meiers (Daimler Alle)','malprtactice in business process managment. depostory trust and clearing corporation(IBM Client) westly deis of brain tomour','2006-01-01 00:00:00'),
(16,'?','?','Dr. Dieter Zetscher, Ginni Rommti, Tim Cook & Dr. Dre, Jerry Yang','ibm,daimler,ibm.damiler,ibm.damiler.apple,ibm.daimlier.visa,visa','Denise Genzer, (otto-hahn-strasse,carl-benz-strasse,rudolf-diesel-strasse), Micheala Meiers (Daimler Alle)','malprtactice in business process managment nazi pow in russia, opi grandfahter ','2016-01-01 00:00:00'),
(17,'Mrs.','Bruckscher Sr.','Dr. Dieter Zetscher','ibm,daimler,ibm.damiler,ibm.damiler.apple,ibm.daimlier.visa,visa','Denise Genzer, (otto-hahn-strasse,carl-benz-strasse,rudolf-diesel-strasse), Micheala Meiers (Daimler Alle)','for malprtactice in business process managment marries american woman drive E-Class/S-Class into apparment. Asusem Schoge big car in germay','2000-01-01 00:00:00'),
(18,'?','?','Dr. Dieter Zetscher, Asylum Seeker Freiburg/ Iran','ibm.dmielr.biometircs,ibm,daimler,ibm.damiler,ibm.damiler.apple,ibm.daimlier.visa,visa,ibm.dmierl.chari.ginni.rommeti.nonPocieSignature','Denise Genzer, (otto-hahn-strasse,carl-benz-strasse,rudolf-diesel-strasse), Micheala Meiers (Daimler Alle)','malprtactice in business process managment halfwayhouse baby. Baby thrwon off roomfrom asylum seeker','1996-01-01 00:00:00'),
(19,'Alfonz','?','Dr. Dieter Zetsche','ibm,daimler,ibm.damiler,ibm.damiler.apple,ibm.daimlier.visa,visa','Denise Genzer, (otto-hahn-strasse,carl-benz-strasse,rudolf-diesel-strasse), Micheala Meiers (Daimler Alle)','malprtactice in business process managment Dr. Zetsche Identity Theft worker (Thoams Wieland) work-friend Alfonz or druck worker Alfonz for US Camera','2013-01-01 00:00:00'),
(20,'Joerg','?','Dr. Dieter Zetsche, Gini Rommti','ibm,daimler,ibm.damiler,ibm.damiler.apple,ibm.daimlier.visa,visa,ibm.dmiler.footlocek,ibmdiler.subway,ibm.damierler.deere','Denise Genzer, (otto-hahn-strasse,carl-benz-strasse,rudolf-diesel-strasse), Micheala Meiers (Daimler Alle)','malpractice in business process managment Joerg dies age 24 during internshipt J2EE/Java Programmer Bacheolwor Information Systems at John Deere EMEA ','2004-01-01 00:00:00'),
(21,'Pete','','Dr.Dieter Zesche','ibm.dmiler.pope.saint.peter,ibm.daimler,ibm.dmier.vis,   gobachov.cherrytree(ibm.damiler.pope.saint.peter)','Denise Genzer, (otto-hahn-strasse,carl-benz-strasse,rudolf-diesel-strasse), Micheala Meiers (Daimler Alle)','malpratice in business process managment of religious crimes (murder), testing GOLDEN/BLUE ibm.dmaielrl.visa humans in rmote town','2014-01-01 00:00:00'),
(22,'Philip','Johnson','Dr. Dieter Zetscher','ibm,daimler,ibm.damiler,ibm.damiler.apple,ibm.daimlier.visa,visa','Denise Genzer, (otto-hahn-strasse,carl-benz-strasse,rudolf-diesel-strasse), Micheala Meiers (Daimler Alle)','aamssuemd alprtactice in business process managment, heart attack on route','1992-01-01 00:00:00'),
(23,'?','Lux','Dr. Dieter Zetscher','ibm,daimler,ibm.damiler,ibm.damiler.apple,ibm.daimlier.visa,visa','Denise Genzer, (otto-hahn-strasse,carl-benz-strasse,rudolf-diesel-strasse), Micheala Meiers (Daimler Alle)','mal practice in business process managment baby fetus II for Angel Merkl Legislation, Cherrytree/Wolf Lux first bab ides','1980-01-01 00:00:00'),
(24,'Mr.','fishan','Dr. Dieter Zetscher','ibm,daimler,ibm.damiler,ibm.damiler.apple,ibm.daimlier.visa,visa,ibm.daimler.pope.saint.peter','Denise Genzer, (otto-hahn-strasse,carl-benz-strasse,rudolf-diesel-strasse), Micheala Meiers (Daimler Alle)','uninvestigated - for malprtactice in business process managment. dr. fishan father','2000-01-01 00:00:00'),
(25,'Mrs.','Fisahn','Dr. Dieter Zetscher','ibm,daimler,ibm.damiler,ibm.damiler.apple,ibm.daimlier.visa,visa,ibm.daimler.pope.saint.peter','Denise Genzer, (otto-hahn-strasse,carl-benz-strasse,rudolf-diesel-strasse), Micheala Meiers (Daimler Alle)','uninvestigaet - for malprtactice in business process managment. dr. fishan mother','2009-01-01 00:00:00'),
(26,'Mikhail','Gorgacheo','Dr. Dieter Zetscher, Ginni Rommeti','ibm,daimler,king','Denise Genzer, (otto-hahn-strasse,carl-benz-strasse,rudolf-diesel-strasse), Micheala Meiers (Daimler Alle)','Far Assuemd for malprtactice in business process managment','2022-01-01 00:00:00'),
(27,'?','?','Dr. Dieter Zetscher','ibm,daimler,ibm.damiler,ibm.damiler.apple,ibm.daimlier.visa,visa','Denise Genzer, (otto-hahn-strasse,carl-benz-strasse,rudolf-diesel-strasse), Micheala Meiers (Daimler Alle)','for malprtactice in business process managment hannes parent gorbhaco(ibm.daimelr.unmog.michelbach)','1996-01-01 00:00:00'),
(28,'Mr.','Fesenbeck','Dr. Dieter Zetscher','ibm,daimler,ibm.damiler,ibm.damiler.apple,ibm.daimlier.visa,visa,ibm.dmielr.karstadt,ibm.daimerl.karstadt.hertie','Denise Genzer, (otto-hahn-strasse,carl-benz-strasse,rudolf-diesel-strasse), Micheala Meiers (Daimler Alle)','for malpractice in business process management civil code red hair links (6) Boris ?, Left-Wing links Daimler Ag Dr. Zestche assuem RAF red army fraction','1997-01-01 00:00:00'),
(29,'Wolfgang','Lux','Dr. Dieter Zetsche, Ginni Rommeti','ibm,daimler,ibm.damiler,ibm.damiler.apple,ibm.daimlier.visa,visa,ibm.daimler.yahoo','Denise Genzer, (otto-hahn-strasse,carl-benz-strasse,rudolf-diesel-strasse), Micheala Meiers (Daimler Alle)','Assuemd Daimler Ag killed Wolfgang Lux Munzesheim and Linkehei for malprtactice in business process managment. Dagoubert Duck tranl. Schoorge','1994-01-01 00:00:00'),
(30,'Unknown','Rampf','Dr. Dieter Zetsche, Ginni Rommeti','ibm.daimler.cisco.monitoring,ibm.daimler.apple,ibm.daimler','Denise Genzer, (otto-hahn-strasse,carl-benz-strasse,rudolf-diesel-strasse), Micheala Meiers (Daimler Alle)','Assuemd Daimler Ag killed Herr Rampf Linkehei for malprtactice in business process managment.','1995-01-01 00:00:00'),
(31,'?','?','Dr. Dieter Zetscher','ibm,daimler,ibm.damiler,ibm.damiler.apple,ibm.daimlier.visa,visa','Denise Genzer, (otto-hahn-strasse,carl-benz-strasse,rudolf-diesel-strasse), Micheala Meiers (Daimler Alle)',' good year(yellow blue( philipsburg factory(atomice factory) worker wife gorbhacei(m. seitz parent): says: person killed his wife owrks next to me at factory','1995-01-01 00:00:00');
/*!40000 ALTER TABLE `homicide` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-09 20:16:53
