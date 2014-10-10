CREATE DATABASE  IF NOT EXISTS `aguantedb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `aguantedb`;
-- MySQL dump 10.13  Distrib 5.1.40, for Win32 (ia32)
--
-- Host: localhost    Database: aguantedb
-- ------------------------------------------------------
-- Server version	5.5.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evento` (
  `codEvento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `premio` varchar(50) DEFAULT NULL,
  `limiteCantidad` int(11) DEFAULT NULL,
  `plazoInscripcion` date DEFAULT NULL,
  `Local_codLoc` int(11) NOT NULL,
  PRIMARY KEY (`codEvento`),
  KEY `fk_Evento_Local1` (`Local_codLoc`),
  CONSTRAINT `fk_Evento_Local1` FOREIGN KEY (`Local_codLoc`) REFERENCES `local` (`codLoc`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` VALUES (1,'Copa interempresas','Copa interempresas',4,'2012-04-11',2),(2,'Campeonato Nextel','Copa Nextel',6,'2012-04-17',5);
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alquiler`
--

DROP TABLE IF EXISTS `alquiler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alquiler` (
  `codAlquiler` int(11) NOT NULL AUTO_INCREMENT,
  `fecAlquiler` date NOT NULL,
  `Persona_codPer` int(11) NOT NULL,
  PRIMARY KEY (`codAlquiler`),
  KEY `fk_Alquiler_Persona1` (`Persona_codPer`),
  CONSTRAINT `fk_Alquiler_Persona1` FOREIGN KEY (`Persona_codPer`) REFERENCES `persona` (`codPer`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alquiler`
--

LOCK TABLES `alquiler` WRITE;
/*!40000 ALTER TABLE `alquiler` DISABLE KEYS */;
/*!40000 ALTER TABLE `alquiler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cancha`
--

DROP TABLE IF EXISTS `cancha`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cancha` (
  `numCancha` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `caracteristicas` varchar(250) NOT NULL,
  `diasAtencion` varchar(250) NOT NULL,
  `horasAtencion` varchar(250) NOT NULL,
  `tarifaDiurna` double NOT NULL,
  `tarifaNocturna` double NOT NULL,
  `promo` varchar(50) DEFAULT NULL,
  `foto` varchar(50) NOT NULL,
  `Local_codLoc` int(11) NOT NULL,
  PRIMARY KEY (`numCancha`),
  KEY `fk_Cancha_Local1` (`Local_codLoc`),
  CONSTRAINT `fk_Cancha_Local1` FOREIGN KEY (`Local_codLoc`) REFERENCES `local` (`codLoc`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cancha`
--

LOCK TABLES `cancha` WRITE;
/*!40000 ALTER TABLE `cancha` DISABLE KEYS */;
INSERT INTO `cancha` VALUES (1,'El chorri','Futbol 7, sintética','LUN','Seleccionar',90,130,'Foto final','/imagenes/cancha3.jpg',4),(2,'Messi','Futbol6, sintética','LUN,MAR,MIE,JUE,VIE,SAB','06000700,07000800,08000900,09001000,10001100,11001200,12001300,13001400,14001500,15001600,16001700,17001800,18001900,19002000,20002100,21002200',70,120,'Foto instantánea','/imagenes/messi.jpg',4),(3,'Messi','Futbol 7','LUN,MAR,MIE,JUE,VIE','06000700,07000800,08000900,09001000,10001100,11001200,12001300,13001400,14001500,15001600,16001700,17001800,18001900,19002000,20002100',70,120,'Foto instantánea','/imagenes/messi.jpg',7),(4,'Cancha Estelar','Futbol 7, grass natural','LUN,MAR,MIE,JUE,VIE,SAB','06000700,07000800,08000900,09001000,10001100,11001200,12001300,13001400,14001500,15001600,16001700,17001800,18001900,19002000,20002100,21002200',80,120,'Foto instantánea','/imagenes/estelar.jpg',5),(5,'Cancha Pele','Futbol 7','LUN,MAR,MIE,JUE,VIE,SAB','06000700,07000800,08000900,09001000,10001100,11001200,12001300,13001400,14001500,15001600,16001700,17001800,18001900,19002000,20002100,21002200',60,90,'Instantanea','imagen.jpg',4),(6,'Palacios','Futbol 11, grass natural','LUN,MAR,MIE,JUE,VIE','06000700,07000800,08000900,09001000,10001100,11001200,12001300,13001400,14001500,15001600,16001700,17001800,18001900,19002000,20002100,21002200',90,150,'Foto instantánea','image.jpg',4),(7,'Cholo Sotil','Futbol 7, sintética','LUN,MAR,MIE,JUE,VIE','06000700,07000800,08000900,09001000,10001100,11001200,12001300,13001400,14001500,15001600,16001700,17001800,18001900,19002000,20002100',60,90,'Foto','imagen.jpg',5),(8,'sdsd','Futbol 7, sd','LUN,MAR,MIE,JUE,VIE','06000700,07000800,08000900,09001000,10001100,11001200,12001300,13001400,14001500,15001600,16001700,17001800,18001900,19002000,20002100',60,90,'Foto','imagen.jpg',4),(9,'Messi','Futbol 7','LUN,MAR,MIE,JUE,VIE,SAB','06000700,07000800,08000900,09001000,10001100,11001200,12001300,13001400,14001500,15001600,16001700,17001800,18001900,19002000,20002100,21002200',60,120,'Foto instantánea','image1.jpg',8);
/*!40000 ALTER TABLE `cancha` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publicidad`
--

DROP TABLE IF EXISTS `publicidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `publicidad` (
  `codPublicidad` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(50) NOT NULL,
  `contenido` varchar(50) NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFin` date NOT NULL,
  `tarifa` double NOT NULL,
  `clicks` int(11) NOT NULL,
  `seccion` varchar(50) NOT NULL,
  `Persona_codPer` int(11) NOT NULL,
  PRIMARY KEY (`codPublicidad`),
  KEY `fk_Publicidad_Persona` (`Persona_codPer`),
  CONSTRAINT `fk_Publicidad_Persona` FOREIGN KEY (`Persona_codPer`) REFERENCES `persona` (`codPer`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publicidad`
--

LOCK TABLES `publicidad` WRITE;
/*!40000 ALTER TABLE `publicidad` DISABLE KEYS */;
INSERT INTO `publicidad` VALUES (1,'Nike','Just do it!','2012-04-11','2012-05-11',3,100,'principal',1),(2,'Adidas','Impossible is nothing!','2012-04-11','2012-05-10',3,100,'cliente',1),(3,'Nike','Todo se puede','2011-01-03','2012-02-12',3,25,'principal',1);
/*!40000 ALTER TABLE `publicidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horario`
--

DROP TABLE IF EXISTS `horario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `horario` (
  `codHorario` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `horaInicio` varchar(50) NOT NULL,
  `horaFin` varchar(50) NOT NULL,
  `estado` varchar(1) NOT NULL,
  `Cancha_numCancha` int(11) NOT NULL,
  `Alquiler_codAlquiler` int(11) NOT NULL,
  PRIMARY KEY (`codHorario`),
  KEY `fk_Horario_Cancha1` (`Cancha_numCancha`),
  KEY `fk_Horario_Alquiler1` (`Alquiler_codAlquiler`),
  CONSTRAINT `fk_Horario_Alquiler1` FOREIGN KEY (`Alquiler_codAlquiler`) REFERENCES `alquiler` (`codAlquiler`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Horario_Cancha1` FOREIGN KEY (`Cancha_numCancha`) REFERENCES `cancha` (`numCancha`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horario`
--

LOCK TABLES `horario` WRITE;
/*!40000 ALTER TABLE `horario` DISABLE KEYS */;
/*!40000 ALTER TABLE `horario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `codPer` int(11) NOT NULL AUTO_INCREMENT,
  `tipoPer` varchar(10) NOT NULL,
  `nombres` varchar(50) NOT NULL,
  `paterno` varchar(50) NOT NULL,
  `materno` varchar(50) NOT NULL,
  `sexo` char(1) NOT NULL,
  `tipoDoc` varchar(10) NOT NULL,
  `numDoc` varchar(45) NOT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `password` varchar(10) NOT NULL,
  `fecNac` date NOT NULL,
  `celular` int(11) DEFAULT NULL,
  PRIMARY KEY (`codPer`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'admin','user9','Dante','Fernandez','M','DNI','186374545','jesus@site.com','1234','1995-05-21',45),(2,'cliente','Isaac Elías','Abensur','Vargas','m','dni','43440498','isaacabensur@gmail.com','aufbau','1985-12-16',999631259),(3,'dueno','Isaac Elías','Abensur','Vargas','m','dni','40414243','isaacabensur@hotmail.com','aufbau','1985-12-16',999631259),(4,'dueno','Carlos','Pera','Palotes','m','dni','40203016','isaacabensur@yahoo.es','aufbau','1985-12-16',912345678),(5,'dueno','David','Perez','Garcia','m','dni','40402525','correo@site.com','1234','1985-01-01',99963325);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servadicional`
--

DROP TABLE IF EXISTS `servadicional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servadicional` (
  `codServ` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(50) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `tarifa` double NOT NULL,
  `Local_codLoc` int(11) NOT NULL,
  PRIMARY KEY (`codServ`),
  KEY `fk_servAdicional_Local1` (`Local_codLoc`),
  CONSTRAINT `fk_servAdicional_Local1` FOREIGN KEY (`Local_codLoc`) REFERENCES `local` (`codLoc`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servadicional`
--

LOCK TABLES `servadicional` WRITE;
/*!40000 ALTER TABLE `servadicional` DISABLE KEYS */;
INSERT INTO `servadicional` VALUES (1,'Camisetas','12 camisetas',25,2),(2,'Camisetas','20 camisetas',25,3),(3,'Árbitros','Un solo árbitro.',60,4);
/*!40000 ALTER TABLE `servadicional` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `local`
--

DROP TABLE IF EXISTS `local`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `local` (
  `codLoc` int(11) NOT NULL AUTO_INCREMENT,
  `desLoc` varchar(50) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `distrito` varchar(50) NOT NULL,
  `dicGoogle` varchar(100) DEFAULT NULL,
  `telefonoFijo` int(11) NOT NULL,
  `Persona_codPer` int(11) NOT NULL,
  PRIMARY KEY (`codLoc`),
  KEY `fk_Local_Persona1` (`Persona_codPer`),
  CONSTRAINT `fk_Local_Persona1` FOREIGN KEY (`Persona_codPer`) REFERENCES `persona` (`codPer`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `local`
--

LOCK TABLES `local` WRITE;
/*!40000 ALTER TABLE `local` DISABLE KEYS */;
INSERT INTO `local` VALUES (1,'Leyendas peruanas','Av. San Luis 397 ','San Borja','0120102255.3',2602020,1),(2,'Futbol Star','Av. La Marina 5256','San Miguel','123456',2612552,2),(3,'Chalaquita','Av. Bellavista 261','Callao','1234567',2315265,2),(4,'Tiro Libre','Av. Saenz Peña 621','Callao','123456789',2612525,3),(5,'Tiro al palo','Av. Independencia 261','Carabayllo','123456',2612828,3),(6,'La diez','Av. El Corregidor 261','LMO','123456',2612800,3),(7,'Miguel Grau','Av. Miguel Grau ','CLI','123456',2612800,3),(8,'Supercampeones','Av. Javier Prado 2050','LMO','1244556',2612800,4),(9,'Local test','av. test ','ATE','12345656',1233456,3);
/*!40000 ALTER TABLE `local` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comentario`
--

DROP TABLE IF EXISTS `comentario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comentario` (
  `idComent` int(11) NOT NULL AUTO_INCREMENT,
  `texto` varchar(50) NOT NULL,
  `calificacion` int(11) DEFAULT NULL,
  `nivel` int(11) NOT NULL,
  `Comentario_idComent` int(11) DEFAULT NULL,
  `Persona_codPer` int(11) NOT NULL,
  `Cancha_numCancha` int(11) NOT NULL,
  PRIMARY KEY (`idComent`),
  KEY `fk_Comentario_Comentario1` (`Comentario_idComent`),
  KEY `fk_Comentario_Persona1` (`Persona_codPer`),
  KEY `fk_Comentario_Cancha1` (`Cancha_numCancha`),
  CONSTRAINT `fk_Comentario_Cancha1` FOREIGN KEY (`Cancha_numCancha`) REFERENCES `cancha` (`numCancha`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Comentario_Comentario1` FOREIGN KEY (`Comentario_idComent`) REFERENCES `comentario` (`idComent`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Comentario_Persona1` FOREIGN KEY (`Persona_codPer`) REFERENCES `persona` (`codPer`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentario`
--

LOCK TABLES `comentario` WRITE;
/*!40000 ALTER TABLE `comentario` DISABLE KEYS */;
/*!40000 ALTER TABLE `comentario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-04-14 19:50:16
