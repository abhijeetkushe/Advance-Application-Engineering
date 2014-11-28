-- MySQL dump 10.13  Distrib 5.5.9, for Win32 (x86)
--
-- Host: localhost    Database: stabledb
-- ------------------------------------------------------
-- Server version	5.5.10

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
-- Current Database: `stabledb`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `stabledb` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `stabledb`;

--
-- Table structure for table `assessment`
--

DROP TABLE IF EXISTS `assessment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `assessment` (
  `assessment_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`assessment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `assessment`
--

LOCK TABLES `assessment` WRITE;
/*!40000 ALTER TABLE `assessment` DISABLE KEYS */;
INSERT INTO `assessment` VALUES (12);
/*!40000 ALTER TABLE `assessment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bed_location`
--

DROP TABLE IF EXISTS `bed_location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bed_location` (
  `bedlocation_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `location` varchar(50) COLLATE utf8_bin NOT NULL,
  `type` int(2) unsigned DEFAULT NULL,
  `status` int(2) unsigned DEFAULT NULL,
  `clinic_id` int(10) unsigned NOT NULL,
  `careteam_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`bedlocation_id`),
  UNIQUE KEY `bedlocation_id_UNIQUE` (`bedlocation_id`),
  KEY `fk_bedlocation_clinicid` (`clinic_id`),
  KEY `fk_bedlocation_teamid` (`careteam_id`),
  CONSTRAINT `fk_bedlocation_clinicid` FOREIGN KEY (`clinic_id`) REFERENCES `clinic` (`clinic_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_bedlocation_teamid` FOREIGN KEY (`careteam_id`) REFERENCES `care_team` (`careteam_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bed_location`
--

LOCK TABLES `bed_location` WRITE;
/*!40000 ALTER TABLE `bed_location` DISABLE KEYS */;
INSERT INTO `bed_location` VALUES (1,'DS-201',1,1,1,1);
/*!40000 ALTER TABLE `bed_location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `birth_details`
--

DROP TABLE IF EXISTS `birth_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `birth_details` (
  `birthdetails_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `headcircumference` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `gestationalAge` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `height` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `weight` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `resuscitationAtBirth` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `resuscitationMeds` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `otherMeds` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `birthorder` int(11) DEFAULT NULL,
  `person_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`birthdetails_id`),
  KEY `fk_person_id_birthdetails` (`person_id`),
  CONSTRAINT `fk_person_id_birthdetails` FOREIGN KEY (`person_id`) REFERENCES `person` (`person_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `birth_details`
--

LOCK TABLES `birth_details` WRITE;
/*!40000 ALTER TABLE `birth_details` DISABLE KEYS */;
INSERT INTO `birth_details` VALUES (9,'30','31-6/7','173','100','abc','def','ghi',1,69),(10,'30','31-6/7','173','100','abc','def','ghi',1,70),(11,'30','31-6/7','173','100','abc','def','ghi',1,72);
/*!40000 ALTER TABLE `birth_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `care_team`
--

DROP TABLE IF EXISTS `care_team`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `care_team` (
  `careteam_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `team_name` varchar(70) COLLATE utf8_bin DEFAULT NULL,
  `leader_id` int(10) unsigned DEFAULT NULL,
  `clinic_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`careteam_id`),
  UNIQUE KEY `care_team_id_UNIQUE` (`careteam_id`),
  KEY `fk_leaderid_employeeid` (`leader_id`),
  KEY `fk_careteam_clinicid` (`clinic_id`),
  CONSTRAINT `fk_careteam_clinicid` FOREIGN KEY (`clinic_id`) REFERENCES `clinic` (`clinic_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_careteam_leaderid` FOREIGN KEY (`leader_id`) REFERENCES `employee` (`employee_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `care_team`
--

LOCK TABLES `care_team` WRITE;
/*!40000 ALTER TABLE `care_team` DISABLE KEYS */;
INSERT INTO `care_team` VALUES (1,'CT-1',1,1),(2,'BlueTeam',1,1);
/*!40000 ALTER TABLE `care_team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `careteam_employee`
--

DROP TABLE IF EXISTS `careteam_employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `careteam_employee` (
  `employee_id` int(10) unsigned NOT NULL,
  `careteam_id` int(10) unsigned NOT NULL,
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_teamemployee_careteamid` (`careteam_id`),
  KEY `fk_teamemployee_employeeid` (`employee_id`),
  CONSTRAINT `fk_teamemployee_careteamid` FOREIGN KEY (`careteam_id`) REFERENCES `care_team` (`careteam_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_teamemployee_employeeid` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `careteam_employee`
--

LOCK TABLES `careteam_employee` WRITE;
/*!40000 ALTER TABLE `careteam_employee` DISABLE KEYS */;
INSERT INTO `careteam_employee` VALUES (1,1,1),(2,1,2);
/*!40000 ALTER TABLE `careteam_employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cbc`
--

DROP TABLE IF EXISTS `cbc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cbc` (
  `lab_id` int(11) NOT NULL,
  `wbc` int(11) DEFAULT NULL,
  `hgb` int(11) DEFAULT NULL,
  `hct` int(11) DEFAULT NULL,
  PRIMARY KEY (`lab_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cbc`
--

LOCK TABLES `cbc` WRITE;
/*!40000 ALTER TABLE `cbc` DISABLE KEYS */;
INSERT INTO `cbc` VALUES (33,2,123456,122334);
/*!40000 ALTER TABLE `cbc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clinic`
--

DROP TABLE IF EXISTS `clinic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clinic` (
  `clinic_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'Primary key for the clinic table',
  `name` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT 'N/A' COMMENT 'Name of the clinic',
  PRIMARY KEY (`clinic_id`),
  UNIQUE KEY `clinic_id_UNIQUE` (`clinic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clinic`
--

LOCK TABLES `clinic` WRITE;
/*!40000 ALTER TABLE `clinic` DISABLE KEYS */;
INSERT INTO `clinic` VALUES (1,'Beth Israel');
/*!40000 ALTER TABLE `clinic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `device`
--

DROP TABLE IF EXISTS `device`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `device` (
  `device_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_bin NOT NULL,
  `model_no` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `inventory_no` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `status` int(2) unsigned DEFAULT NULL,
  `clinic_id` int(10) unsigned NOT NULL,
  `discriminator` varchar(70) COLLATE utf8_bin DEFAULT NULL,
  `type` int(2) DEFAULT NULL,
  `measurement_type` int(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`device_id`),
  UNIQUE KEY `device_id_UNIQUE` (`device_id`),
  KEY `fk_device_clinicid` (`clinic_id`),
  CONSTRAINT `fk_device_clinicid` FOREIGN KEY (`clinic_id`) REFERENCES `clinic` (`clinic_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device`
--

LOCK TABLES `device` WRITE;
/*!40000 ALTER TABLE `device` DISABLE KEYS */;
INSERT INTO `device` VALUES (1,'TD-1','345','FGH-745',1,1,'BloodGasDevice',0,0),(2,'Hgb','--','abc',0,1,'HgbDevice',0,0),(3,'BLOOD_GROUP','--','def',0,1,'BloodGasDevice',0,0),(4,'HCO3','--','ghi',0,1,'HCO3Device',0,0),(5,'Hgb','--','abc',0,1,'HgbDevice',0,0),(6,'Hgb','--','abc',0,1,'HgbDevice',0,0),(7,'BLOOD_GROUP','--','def',0,1,'BloodGasDevice',0,0),(8,'BLOOD_GROUP','--','def',0,1,'BloodGasDevice',0,0),(9,'HCO3','--','ghi',0,1,'HCO3Device',0,0),(10,'HCO3','--','ghi',0,1,'HCO3Device',0,0),(11,'Hgb','--','abc',0,1,'HgbDevice',0,0),(12,'BLOOD_GROUP','--','def',0,1,'BloodGasDevice',0,0),(13,'HCO3','--','ghi',0,1,'HCO3Device',0,0),(14,'Hgb','--','abc',0,1,'HgbDevice',0,0),(15,'BLOOD_GROUP','--','def',0,1,'BloodGasDevice',0,0),(16,'HCO3','--','ghi',0,1,'HCO3Device',0,0),(17,'Hgb','--','abc',0,1,'HgbDevice',0,0),(18,'BLOOD_GROUP','--','def',0,1,'BloodGasDevice',0,0),(19,'HCO3','--','ghi',0,1,'HCO3Device',0,0),(20,'Hgb','--','abc',0,1,'HgbDevice',0,0),(21,'BLOOD_GROUP','--','def',0,1,'BloodGasDevice',0,0),(22,'HCO3','--','ghi',0,1,'HCO3Device',0,0),(23,'Hgb','--','abc',0,1,'HgbDevice',0,0),(24,'BLOOD_GROUP','--','def',0,1,'BloodGasDevice',0,0),(25,'HCO3','--','ghi',0,1,'HCO3Device',0,0),(26,'Hgb','--','abc',0,1,'HgbDevice',0,0),(27,'BLOOD_GROUP','--','def',0,1,'BloodGasDevice',0,0),(28,'HCO3','--','ghi',0,1,'HCO3Device',0,0),(29,'Hgb','--','abc',0,1,'HgbDevice',0,0),(30,'BLOOD_GROUP','--','def',0,1,'BloodGasDevice',0,0),(31,'HCO3','--','ghi',0,1,'HCO3Device',0,0),(32,'Hgb','--','abc',0,1,'HgbDevice',0,0),(33,'BLOOD_GROUP','--','def',0,1,'BloodGasDevice',0,0),(34,'HCO3','--','ghi',0,1,'HCO3Device',0,0),(35,'Hgb','--','abc',0,1,'HgbDevice',0,0),(36,'BLOOD_GROUP','--','def',0,1,'BloodGasDevice',0,0),(37,'HCO3','--','ghi',0,1,'HCO3Device',0,0),(38,'Hgb','--','abc',0,1,'HgbDevice',0,0),(39,'BLOOD_GROUP','--','def',0,1,'BloodGasDevice',0,0),(40,'HCO3','--','ghi',0,1,'HCO3Device',0,0),(41,'WBC','--','abc',0,1,'WBCDevice',0,0),(42,'BLOOD_GAS','--','def',0,1,'BloodGasDevice',0,0),(43,'FiO2','--','ghi',0,1,'FiO2Device',0,0),(44,'WBC','--','abc',0,1,'WBCDevice',0,0),(45,'BLOOD_GAS','--','def',0,1,'BloodGasDevice',0,0),(46,'FiO2','--','ghi',0,1,'FiO2Device',0,0),(47,'WBC','--','abc',0,1,'WBCDevice',0,0),(48,'BLOOD_GAS','--','def',0,1,'BloodGasDevice',0,0),(49,'FiO2','--','ghi',0,1,'FiO2Device',0,0),(50,'WBC','--','abc',0,1,'WBCDevice',0,0),(51,'BLOOD_GAS','--','def',0,1,'BloodGasDevice',0,0),(52,'FiO2','--','ghi',0,1,'FiO2Device',0,0),(53,'WBC','--','abc',0,1,'WBCDevice',0,0),(54,'BLOOD_GAS','--','def',0,1,'BloodGasDevice',0,0),(55,'FiO2','--','ghi',0,1,'FiO2Device',0,0),(56,'WBC','--','abc',0,1,'WBCDevice',0,0),(57,'BLOOD_GAS','--','def',0,1,'BloodGasDevice',0,0),(58,'FiO2','--','ghi',0,1,'FiO2Device',0,0),(59,'WBC','--','abc',0,1,'WBCDevice',0,0),(60,'BLOOD_GAS','--','def',0,1,'BloodGasDevice',0,0),(61,'FiO2','--','ghi',0,1,'FiO2Device',0,0),(62,'WBC','--','abc',0,1,'WBCDevice',0,0),(63,'BLOOD_GAS','--','def',0,1,'BloodGasDevice',0,0),(64,'FiO2','--','ghi',0,1,'FiO2Device',0,0),(65,'WBC','--','abc',0,1,'WBCDevice',0,0),(66,'BLOOD_GAS','--','def',0,1,'BloodGasDevice',0,0),(67,'FiO2','--','ghi',0,1,'FiO2Device',0,0),(68,'WBC','--','abc',0,1,'WBCDevice',0,0),(69,'BLOOD_GAS','--','def',0,1,'BloodGasDevice',0,0),(70,'FiO2','--','ghi',0,1,'FiO2Device',0,0),(71,'WBC','--','abc',0,1,'WBCDevice',0,0),(72,'BLOOD_GAS','--','def',0,1,'BloodGasDevice',0,0),(73,'FiO2','--','ghi',0,1,'FiO2Device',0,0),(74,'WBC','--','abc',0,1,'WBCDevice',0,0),(75,'BLOOD_GAS','--','def',0,1,'BloodGasDevice',0,0),(76,'FiO2','--','ghi',0,1,'FiO2Device',0,0),(77,'WBC','--','abc',0,1,'WBCDevice',0,0),(78,'BLOOD_GAS','--','def',0,1,'BloodGasDevice',0,0),(79,'FiO2','--','ghi',0,1,'FiO2Device',0,0),(80,'WBC','--','abc',0,1,'WBCDevice',0,0),(81,'BLOOD_GAS','--','def',0,1,'BloodGasDevice',0,0),(82,'FiO2','--','ghi',0,1,'FiO2Device',0,0),(83,'WBC','--','abc',0,1,'WBCDevice',0,0),(84,'BLOOD_GAS','--','def',0,1,'BloodGasDevice',0,0),(85,'FiO2','--','ghi',0,1,'FiO2Device',0,0),(86,'WBC','--','abc',0,1,'WBCDevice',0,0),(87,'BLOOD_GAS','--','def',0,1,'BloodGasDevice',0,0),(88,'FiO2','--','ghi',0,1,'FiO2Device',0,0),(89,'WBC','--','abc',0,1,'WBCDevice',0,0),(90,'BLOOD_GAS','--','def',0,1,'BloodGasDevice',0,0),(91,'FiO2','--','ghi',0,1,'FiO2Device',0,0),(92,'WBC','--','abc',0,1,'WBCDevice',0,0),(93,'BLOOD_GAS','--','def',0,1,'BloodGasDevice',0,0),(94,'FiO2','--','ghi',0,1,'FiO2Device',0,0),(95,'WBC','--','abc',0,1,'WBCDevice',0,0),(96,'BLOOD_GAS','--','def',0,1,'BloodGasDevice',0,0),(97,'FiO2','--','ghi',0,1,'FiO2Device',0,0),(98,'WBC','--','abc',0,1,'WBCDevice',0,0),(99,'BLOOD_GAS','--','def',0,1,'BloodGasDevice',0,0),(100,'FiO2','--','ghi',0,1,'FiO2Device',0,0),(101,'WBC','--','abc',0,1,'WBCDevice',0,0),(102,'BLOOD_GAS','--','def',0,1,'BloodGasDevice',0,0),(103,'FiO2','--','ghi',0,1,'FiO2Device',0,0),(104,'WBC','--','abc',0,1,'WBCDevice',0,0),(105,'BLOOD_GAS','--','def',0,1,'BloodGasDevice',0,0),(106,'FiO2','--','ghi',0,1,'FiO2Device',0,0),(107,'WBC','--','abc',0,1,'WBCDevice',0,0),(108,'BLOOD_GAS','--','def',0,1,'BloodGasDevice',0,0),(109,'FiO2','--','ghi',0,1,'FiO2Device',0,0),(110,'WBC','--','abc',0,1,'WBCDevice',0,0),(111,'BLOOD_GAS','--','def',0,1,'BloodGasDevice',0,0),(112,'FiO2','--','ghi',0,1,'FiO2Device',0,0),(113,'WBC','--','abc',0,1,'WBCDevice',0,0),(114,'BLOOD_GAS','--','def',0,1,'BloodGasDevice',0,0),(115,'FiO2','--','ghi',0,1,'FiO2Device',0,0),(116,'WBC','--','abc',0,1,'WBCDevice',0,0),(117,'BLOOD_GAS','--','def',0,1,'BloodGasDevice',0,0),(118,'FiO2','--','ghi',0,1,'FiO2Device',0,0),(119,'WBC','--','abc',0,1,'WBCDevice',0,0),(120,'BLOOD_GAS','--','def',0,1,'BloodGasDevice',0,0),(121,'FiO2','--','ghi',0,1,'FiO2Device',0,0);
/*!40000 ALTER TABLE `device` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `device_bl`
--

DROP TABLE IF EXISTS `device_bl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `device_bl` (
  `device_id` int(10) unsigned NOT NULL,
  `bedlocation_id` int(10) unsigned NOT NULL,
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_devicebl_bedlocationid` (`bedlocation_id`),
  KEY `fk_devicebl_deviceid` (`device_id`),
  CONSTRAINT `fk_devicebl_bedlocationid` FOREIGN KEY (`bedlocation_id`) REFERENCES `bed_location` (`bedlocation_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_devicebl_deviceid` FOREIGN KEY (`device_id`) REFERENCES `device` (`device_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device_bl`
--

LOCK TABLES `device_bl` WRITE;
/*!40000 ALTER TABLE `device_bl` DISABLE KEYS */;
INSERT INTO `device_bl` VALUES (1,1,1);
/*!40000 ALTER TABLE `device_bl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `device_pbl`
--

DROP TABLE IF EXISTS `device_pbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `device_pbl` (
  `device_id` int(10) unsigned NOT NULL,
  `patientbedlocation_id` int(10) unsigned NOT NULL,
  `id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_devicepbl_deviceid` (`device_id`),
  KEY `fk_devicepbl_pblid` (`patientbedlocation_id`),
  CONSTRAINT `fk_devicepbl_deviceid` FOREIGN KEY (`device_id`) REFERENCES `device` (`device_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_devicepbl_pblid` FOREIGN KEY (`patientbedlocation_id`) REFERENCES `patient_bedlocation` (`patient_bedlocation_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device_pbl`
--

LOCK TABLES `device_pbl` WRITE;
/*!40000 ALTER TABLE `device_pbl` DISABLE KEYS */;
INSERT INTO `device_pbl` VALUES (1,1,0);
/*!40000 ALTER TABLE `device_pbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `employee_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `last_name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `middle_name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `preferred_name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `gender` int(1) unsigned DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `role` int(3) unsigned NOT NULL,
  `clinic_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`employee_id`),
  UNIQUE KEY `employee_id_UNIQUE` (`employee_id`),
  KEY `fk_employee_clinicid` (`clinic_id`),
  CONSTRAINT `fk_employee_clinicid` FOREIGN KEY (`clinic_id`) REFERENCES `clinic` (`clinic_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Matt','John',NULL,'Matt',1,'',1,1),(2,'Mike','Andrew',NULL,'Mike',1,'',1,1);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_pbl`
--

DROP TABLE IF EXISTS `employee_pbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_pbl` (
  `employee_id` int(10) unsigned NOT NULL,
  `patient_bedlocation_id` int(10) unsigned NOT NULL,
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_employeepbl_employeeid` (`employee_id`),
  KEY `fk_employeepbl_pblid` (`patient_bedlocation_id`),
  CONSTRAINT `fk_employeepbl_employeeid` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_employeepbl_pblid` FOREIGN KEY (`patient_bedlocation_id`) REFERENCES `patient_bedlocation` (`patient_bedlocation_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_pbl`
--

LOCK TABLES `employee_pbl` WRITE;
/*!40000 ALTER TABLE `employee_pbl` DISABLE KEYS */;
INSERT INTO `employee_pbl` VALUES (1,1,1),(2,2,2);
/*!40000 ALTER TABLE `employee_pbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `encounter`
--

DROP TABLE IF EXISTS `encounter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `encounter` (
  `encounter_id` int(10) NOT NULL AUTO_INCREMENT,
  `encounterdate` double unsigned DEFAULT NULL,
  `patient_id` int(10) unsigned NOT NULL,
  `followup_id` int(10) DEFAULT NULL,
  `treatment_id` int(10) DEFAULT NULL,
  `assesment_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`encounter_id`),
  KEY `FK_encounter_patientid` (`patient_id`),
  CONSTRAINT `FK_encounter_patientid` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `encounter`
--

LOCK TABLES `encounter` WRITE;
/*!40000 ALTER TABLE `encounter` DISABLE KEYS */;
INSERT INTO `encounter` VALUES (1,5,1,NULL,NULL,12),(2,10,2,NULL,NULL,12);
/*!40000 ALTER TABLE `encounter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `measurement`
--

DROP TABLE IF EXISTS `measurement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `measurement` (
  `measurement_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `methodtype_id` int(3) unsigned DEFAULT NULL,
  `unit_id` int(3) unsigned DEFAULT NULL,
  `datetime` datetime DEFAULT NULL,
  `value` varchar(30) COLLATE utf8_bin NOT NULL,
  `measurementype_id` int(3) unsigned DEFAULT NULL,
  `patient_id` int(10) unsigned NOT NULL,
  `device_id` int(10) unsigned DEFAULT NULL,
  `discriminator` varchar(70) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`measurement_id`),
  UNIQUE KEY `measurement_id_UNIQUE` (`measurement_id`),
  KEY `fk_measurement_deviceid` (`device_id`),
  KEY `fk_measurement_patientid` (`patient_id`),
  CONSTRAINT `fk_measurement_deviceid` FOREIGN KEY (`device_id`) REFERENCES `device` (`device_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_measurement_patientid` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `measurement`
--

LOCK TABLES `measurement` WRITE;
/*!40000 ALTER TABLE `measurement` DISABLE KEYS */;
INSERT INTO `measurement` VALUES (1,0,1,'2011-04-21 12:30:00','23',0,1,1,'BloodGas_Measurement'),(2,0,1,'2011-04-30 12:30:00','23',0,1,1,'WBC_Measurement'),(3,0,1,'2011-05-04 01:39:22','245',0,1,1,'BloodGas_Measurement'),(4,0,1,'2011-05-04 01:39:25','245',0,1,1,'BloodGas_Measurement'),(5,0,1,'2011-05-04 03:13:30','245',0,1,1,'BloodGas_Measurement'),(6,0,1,'2011-05-04 07:09:16','245',0,1,1,'BloodGas_Measurement'),(7,0,1,'2011-05-04 07:18:50','245',0,1,1,'BloodGas_Measurement'),(8,0,1,'2011-05-04 07:23:19','245',0,1,1,'BloodGas_Measurement'),(9,0,1,'2011-05-04 07:34:23','245',0,1,1,'BloodGas_Measurement'),(10,0,1,'2011-05-04 07:52:01','245',0,1,1,'BloodGas_Measurement'),(11,0,1,'2011-05-04 07:56:30','245',0,1,1,'BloodGas_Measurement'),(12,0,1,'2011-05-04 07:58:31','245',0,1,1,'BloodGas_Measurement'),(13,0,1,'2011-05-04 08:00:35','245',0,1,1,'BloodGas_Measurement'),(14,0,1,'2011-05-04 08:07:20','245',0,1,1,'BloodGas_Measurement'),(15,0,1,'2011-05-04 09:09:18','245',0,1,1,'BloodGas_Measurement'),(16,0,1,'2011-05-04 16:16:25','245',0,1,1,'BloodGas_Measurement'),(17,0,1,'2011-05-04 16:16:27','245',0,1,1,'BloodGas_Measurement'),(18,0,1,'2011-05-04 16:27:06','245',0,1,1,'BloodGas_Measurement'),(19,0,1,'2011-05-04 16:27:26','245',0,1,1,'BloodGas_Measurement'),(20,0,1,'2011-05-04 16:30:16','245',0,1,1,'BloodGas_Measurement'),(21,0,1,'2011-05-04 16:32:09','245',0,1,1,'BloodGas_Measurement'),(22,0,1,'2011-05-04 16:33:44','245',0,1,1,'BloodGas_Measurement'),(23,0,1,'2011-05-04 16:35:49','245',0,1,1,'BloodGas_Measurement'),(24,0,1,'2011-05-04 16:45:11','245',0,1,1,'BloodGas_Measurement'),(25,0,1,'2011-05-04 16:47:14','245',0,1,1,'BloodGas_Measurement'),(26,0,1,'2011-05-04 16:48:52','245',0,1,1,'BloodGas_Measurement'),(27,0,1,'2011-05-04 16:48:56','245',0,1,1,'BloodGas_Measurement'),(28,0,1,'2011-05-04 16:50:49','245',0,1,1,'BloodGas_Measurement'),(29,0,1,'2011-05-04 17:36:38','245',0,1,1,'BloodGas_Measurement'),(30,0,1,'2011-05-04 17:39:26','245',0,1,1,'BloodGas_Measurement'),(31,0,1,'2011-05-04 17:54:42','245',0,1,1,'BloodGas_Measurement'),(32,0,1,'2011-05-04 17:59:12','245',0,1,1,'BloodGas_Measurement'),(33,0,1,'2011-05-04 18:07:19','245',0,1,1,'BloodGas_Measurement'),(34,0,1,'2011-05-04 18:09:38','245',0,1,1,'BloodGas_Measurement'),(35,0,1,'2011-05-04 18:11:49','245',0,1,1,'BloodGas_Measurement'),(36,0,1,'2011-05-04 18:15:56','245',0,1,1,'BloodGas_Measurement'),(37,0,1,'2011-05-04 18:15:57','245',0,1,1,'BloodGas_Measurement'),(38,0,1,'2011-05-04 18:17:34','245',0,1,1,'BloodGas_Measurement');
/*!40000 ALTER TABLE `measurement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderqueue`
--

DROP TABLE IF EXISTS `orderqueue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderqueue` (
  `order_id` int(45) unsigned NOT NULL,
  `OrderType` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `orderedon` double unsigned DEFAULT NULL,
  `assessment_id` int(11) DEFAULT NULL,
  `treatment_id` int(11) DEFAULT NULL,
  `medicalrecord` int(10) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderqueue`
--

LOCK TABLES `orderqueue` WRITE;
/*!40000 ALTER TABLE `orderqueue` DISABLE KEYS */;
INSERT INTO `orderqueue` VALUES (33,NULL,1304438248602,12,NULL,NULL);
/*!40000 ALTER TABLE `orderqueue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient` (
  `patient_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `patient_tag` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `status` int(1) unsigned NOT NULL,
  `clinic_id` int(10) unsigned NOT NULL,
  `person_id` int(10) unsigned DEFAULT NULL,
  `medicalrecord` int(11) DEFAULT NULL,
  `location` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`patient_id`),
  UNIQUE KEY `patient_id_UNIQUE` (`patient_id`),
  KEY `fk_patient_clinicid` (`clinic_id`),
  KEY `fk_person_personid` (`person_id`),
  CONSTRAINT `fk_patient_clinicid` FOREIGN KEY (`clinic_id`) REFERENCES `clinic` (`clinic_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1,'A-1',1,1,1,1,NULL),(2,'JS-1',1,1,2,2,NULL),(3,'',1,1,NULL,3,NULL),(4,'',1,1,29,123,'Boston'),(5,'',1,1,41,123,'Boston'),(6,'',1,1,NULL,123,'Boston'),(7,'',1,1,NULL,123,'Boston'),(8,'',1,1,48,123,'Boston'),(9,'',1,1,50,123,'Boston'),(10,'',1,1,52,123,'Boston'),(11,'',1,1,54,123,'Boston'),(12,'',1,1,56,123,'Boston'),(13,'',1,1,58,123,'Boston'),(14,'',1,1,60,123,'Boston'),(15,'',1,1,NULL,123,'Boston'),(16,'',1,1,NULL,123,'Boston'),(17,'',1,1,NULL,123,'Boston'),(18,'',1,1,69,123,'Boston'),(19,'',1,1,70,123,'Boston'),(20,'',1,1,72,123,'Boston');
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_bedlocation`
--

DROP TABLE IF EXISTS `patient_bedlocation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `patient_bedlocation` (
  `patient_bedlocation_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `status` int(2) unsigned DEFAULT NULL,
  `admitted_on` datetime NOT NULL,
  `discharged_on` datetime DEFAULT NULL,
  `patient_id` int(10) unsigned NOT NULL,
  `bedlocation_id` int(10) unsigned NOT NULL,
  `careteam_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`patient_bedlocation_id`),
  UNIQUE KEY `patient_bedlocation_id_UNIQUE` (`patient_bedlocation_id`),
  KEY `fk_patientbed_bedlocationid` (`bedlocation_id`),
  KEY `fk_patientbed_patientid` (`patient_id`),
  KEY `fk_patientbed_careteamid` (`careteam_id`),
  CONSTRAINT `fk_patientbed_bedlocationid` FOREIGN KEY (`bedlocation_id`) REFERENCES `bed_location` (`bedlocation_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_patientbed_careteamid` FOREIGN KEY (`careteam_id`) REFERENCES `care_team` (`careteam_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_patientbed_patientid` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_bedlocation`
--

LOCK TABLES `patient_bedlocation` WRITE;
/*!40000 ALTER TABLE `patient_bedlocation` DISABLE KEYS */;
INSERT INTO `patient_bedlocation` VALUES (1,1,'2011-04-20 03:55:40',NULL,1,1,1),(2,2,'2011-04-20 04:55:40',NULL,1,1,1);
/*!40000 ALTER TABLE `patient_bedlocation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `person_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `last_name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `preferred_name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `mother_id` int(10) unsigned DEFAULT NULL,
  `father_id` int(10) unsigned DEFAULT NULL,
  `is_mother` bit(1) DEFAULT NULL,
  PRIMARY KEY (`person_id`),
  UNIQUE KEY `person_id_UNIQUE` (`person_id`),
  KEY `fk_person_motherid` (`mother_id`),
  KEY `fk_person_fatherid` (`father_id`),
  CONSTRAINT `fk_person_fatherid` FOREIGN KEY (`father_id`) REFERENCES `person` (`person_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_person_motherid` FOREIGN KEY (`mother_id`) REFERENCES `person` (`person_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'David',NULL,'David',NULL,NULL,''),(2,'Jane','Smith','JSmith',NULL,NULL,''),(3,'Donald','Trump','',NULL,NULL,'\0'),(4,'Donald','Trump','',NULL,NULL,'\0'),(5,'Donald','Trump','',NULL,NULL,'\0'),(6,'Donald','Trump','',NULL,NULL,'\0'),(7,'Donald','Trump','',NULL,NULL,'\0'),(8,'Donald','Trump','',NULL,NULL,'\0'),(9,'Donald','Trump','',NULL,NULL,'\0'),(10,'Donald','Trump','',NULL,NULL,'\0'),(11,'Donald','Trump','',NULL,NULL,'\0'),(12,'Donald','Trump','',NULL,NULL,'\0'),(13,'Donald','Trump','',NULL,NULL,'\0'),(14,'Donald','Trump','',NULL,NULL,'\0'),(15,'Donald','Trump','',NULL,NULL,'\0'),(16,'Donald','Trump','',NULL,NULL,'\0'),(17,'Donald','Trump','',NULL,NULL,'\0'),(18,'Donald','Trump','',NULL,NULL,'\0'),(19,'Donald','Trump','',NULL,NULL,'\0'),(20,'Donald','Trump','',NULL,NULL,'\0'),(21,'Donald','Trump','',NULL,NULL,'\0'),(22,'Donald','Trump','',NULL,NULL,'\0'),(23,'Donald','Trump','',NULL,NULL,'\0'),(24,'Donald','Trump','',NULL,NULL,'\0'),(25,'Donald','Trump','',NULL,NULL,'\0'),(26,'Donald','Trump','',NULL,NULL,'\0'),(27,'Ashwin','Dsousa','',NULL,NULL,'\0'),(28,'Donald','Trump','',NULL,NULL,'\0'),(29,'Ashwin','Dsousa','',NULL,NULL,'\0'),(30,'Donald','Trump','',NULL,NULL,'\0'),(31,'Ashwin','Dsousa','',NULL,NULL,'\0'),(32,'Donald','Trump','',NULL,NULL,'\0'),(33,'Ashwin','Dsousa','',NULL,NULL,'\0'),(34,'Donald','Trump','',NULL,NULL,'\0'),(35,'Ashwin','Dsousa','',NULL,NULL,'\0'),(36,'Donald','Trump','',NULL,NULL,'\0'),(37,'Donald','Trump','',NULL,NULL,'\0'),(38,'Donald','Trump','',NULL,NULL,'\0'),(39,'Donald','Trump','',NULL,NULL,'\0'),(40,'Donald','Trump','',NULL,NULL,'\0'),(41,'Ashwin','Dsousa','',NULL,NULL,'\0'),(42,'Donald','Trump','',NULL,NULL,'\0'),(43,'Ashwin','Dsousa','',NULL,NULL,'\0'),(44,'Donald','Trump','',NULL,NULL,'\0'),(45,'Donald','Trump','',NULL,NULL,'\0'),(46,'Ashwin','Dsousa','',NULL,NULL,'\0'),(47,'Donald','Trump','',NULL,NULL,'\0'),(48,'Ashwin','Dsousa','',NULL,NULL,'\0'),(49,'Donald','Trump','',NULL,NULL,'\0'),(50,'Ashwin','Dsousa','',NULL,NULL,'\0'),(51,'Donald','Trump','',NULL,NULL,'\0'),(52,'Ashwin','Dsousa','',NULL,NULL,'\0'),(53,'Donald','Trump','',NULL,NULL,'\0'),(54,'Ashwin','Dsousa','',NULL,NULL,'\0'),(55,'Donald','Trump','',NULL,NULL,'\0'),(56,'Ashwin','Dsousa','',NULL,NULL,'\0'),(57,'Donald','Trump','',NULL,NULL,'\0'),(58,'Ashwin','Dsousa','',NULL,NULL,'\0'),(59,'Donald','Trump','',NULL,NULL,'\0'),(60,'Ashwin','Dsousa','',NULL,NULL,'\0'),(61,'Donald','Trump','',NULL,NULL,'\0'),(62,'Ashwin','Dsousa','',NULL,NULL,'\0'),(63,'Donald','Trump','',NULL,NULL,'\0'),(64,'Ashwin','Dsousa','',NULL,NULL,'\0'),(65,'Donald','Trump','',NULL,NULL,'\0'),(66,'Ashwin','Dsousa','',NULL,NULL,'\0'),(67,'Donald','Trump','',NULL,NULL,'\0'),(68,'Donald','Trump','',NULL,NULL,'\0'),(69,'Ashwin','Dsousa','',NULL,NULL,'\0'),(70,'Ashwin','Dsousa','',NULL,NULL,'\0'),(71,'Donald','Trump','',NULL,NULL,'\0'),(72,'Ashwin','Dsousa','',NULL,NULL,'\0');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `treatment`
--

DROP TABLE IF EXISTS `treatment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `treatment` (
  `treatment_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`treatment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treatment`
--

LOCK TABLES `treatment` WRITE;
/*!40000 ALTER TABLE `treatment` DISABLE KEYS */;
INSERT INTO `treatment` VALUES (16);
/*!40000 ALTER TABLE `treatment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `useraccount`
--

DROP TABLE IF EXISTS `useraccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `useraccount` (
  `useraccount_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(70) COLLATE utf8_bin NOT NULL,
  `password` tinytext COLLATE utf8_bin NOT NULL,
  `status` int(1) unsigned NOT NULL,
  `employee_id` int(10) unsigned NOT NULL,
  `created_on` datetime NOT NULL,
  `created_by` int(10) unsigned DEFAULT NULL,
  `expire_on` datetime DEFAULT NULL,
  `clinic_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`useraccount_id`),
  UNIQUE KEY `useraccount_id_UNIQUE` (`useraccount_id`),
  UNIQUE KEY `username_UNIQUE` (`username`) USING BTREE,
  KEY `fk_employeeid_employeeid` (`employee_id`),
  KEY `fk_useraccount_createdby` (`created_by`),
  KEY `fk_useraccount_clinicid` (`clinic_id`),
  CONSTRAINT `fk_useraccount_clinicid` FOREIGN KEY (`clinic_id`) REFERENCES `clinic` (`clinic_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_useraccount_createdby` FOREIGN KEY (`created_by`) REFERENCES `employee` (`employee_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_useraccount_employeeid` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `useraccount`
--

LOCK TABLES `useraccount` WRITE;
/*!40000 ALTER TABLE `useraccount` DISABLE KEYS */;
INSERT INTO `useraccount` VALUES (1,'mike','mike',1,1,'2011-04-20 03:45:40',NULL,NULL,1),(2,'matt','matt',1,2,'2011-04-20 03:47:40',NULL,NULL,1);
/*!40000 ALTER TABLE `useraccount` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-05-04 19:49:02
