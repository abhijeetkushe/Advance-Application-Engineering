CREATE DATABASE  IF NOT EXISTS `stabledb` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `stabledbv2`;
-- MySQL dump 10.13  Distrib 5.1.34, for apple-darwin9.5.0 (i386)
--
-- Host: localhost    Database: stabledb
-- ------------------------------------------------------
-- Server version	5.1.50

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
  PRIMARY KEY (`patient_id`),
  UNIQUE KEY `patient_id_UNIQUE` (`patient_id`),
  KEY `fk_patient_clinicid` (`clinic_id`),
  KEY `fk_person_personid` (`person_id`),
  CONSTRAINT `fk_patient_clinicid` FOREIGN KEY (`clinic_id`) REFERENCES `clinic` (`clinic_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1,'A-1',1,1,1);
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
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
-- Table structure for table `birth_details`
--

DROP TABLE IF EXISTS `birth_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `birth_details` (
  `patient_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`patient_id`),
  UNIQUE KEY `patient_id_UNIQUE` (`patient_id`),
  KEY `fk_birthdetails_patientid` (`patient_id`),
  CONSTRAINT `fk_birthdetails_patientid` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `birth_details`
--

LOCK TABLES `birth_details` WRITE;
/*!40000 ALTER TABLE `birth_details` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `care_team`
--

LOCK TABLES `care_team` WRITE;
/*!40000 ALTER TABLE `care_team` DISABLE KEYS */;
INSERT INTO `care_team` VALUES (1,'CT-1',1,1);
/*!40000 ALTER TABLE `care_team` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'David',NULL,'David',NULL,NULL,NULL);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device`
--

LOCK TABLES `device` WRITE;
/*!40000 ALTER TABLE `device` DISABLE KEYS */;
INSERT INTO `device` VALUES (1,'TD-1','345','FGH-745',1,1,'BloodGasDevice',0,0);
/*!40000 ALTER TABLE `device` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `measurement`
--

LOCK TABLES `measurement` WRITE;
/*!40000 ALTER TABLE `measurement` DISABLE KEYS */;
INSERT INTO `measurement` VALUES (1,0,1,'2011-04-21 12:30:00','23',0,1,1,'BloodGas_Measurement');
/*!40000 ALTER TABLE `measurement` ENABLE KEYS */;
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-04-23 10:20:46
