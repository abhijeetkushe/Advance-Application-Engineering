-- MySQL dump 10.13  Distrib 5.1.50, for apple-darwin10.3.0 (i386)
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
-- Dumping data for table `bed_location`
--

LOCK TABLES `bed_location` WRITE;
/*!40000 ALTER TABLE `bed_location` DISABLE KEYS */;
INSERT INTO `bed_location` VALUES (1,'DS-201',1,1,1,1);
/*!40000 ALTER TABLE `bed_location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `birth_details`
--

LOCK TABLES `birth_details` WRITE;
/*!40000 ALTER TABLE `birth_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `birth_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `care_team`
--

LOCK TABLES `care_team` WRITE;
/*!40000 ALTER TABLE `care_team` DISABLE KEYS */;
INSERT INTO `care_team` VALUES (1,'CT-1',1,1);
/*!40000 ALTER TABLE `care_team` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `careteam_employee`
--

LOCK TABLES `careteam_employee` WRITE;
/*!40000 ALTER TABLE `careteam_employee` DISABLE KEYS */;
INSERT INTO `careteam_employee` VALUES (1,1,1),(2,1,2);
/*!40000 ALTER TABLE `careteam_employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `clinic`
--

LOCK TABLES `clinic` WRITE;
/*!40000 ALTER TABLE `clinic` DISABLE KEYS */;
INSERT INTO `clinic` VALUES (1,'Beth Israel');
/*!40000 ALTER TABLE `clinic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `device`
--

LOCK TABLES `device` WRITE;
/*!40000 ALTER TABLE `device` DISABLE KEYS */;
INSERT INTO `device` VALUES (1,'TD-1','345','FGH-745',1,1,'BloodGasDevice',0,0);
/*!40000 ALTER TABLE `device` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `device_bl`
--

LOCK TABLES `device_bl` WRITE;
/*!40000 ALTER TABLE `device_bl` DISABLE KEYS */;
INSERT INTO `device_bl` VALUES (1,1,1);
/*!40000 ALTER TABLE `device_bl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `device_pbl`
--

LOCK TABLES `device_pbl` WRITE;
/*!40000 ALTER TABLE `device_pbl` DISABLE KEYS */;
INSERT INTO `device_pbl` VALUES (1,1,0);
/*!40000 ALTER TABLE `device_pbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Matt','John',NULL,'Matt',1,'',1,1),(2,'Mike','Andrew',NULL,'Mike',1,'',1,1);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `employee_pbl`
--

LOCK TABLES `employee_pbl` WRITE;
/*!40000 ALTER TABLE `employee_pbl` DISABLE KEYS */;
INSERT INTO `employee_pbl` VALUES (1,1,1),(2,2,2);
/*!40000 ALTER TABLE `employee_pbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `measurement`
--

LOCK TABLES `measurement` WRITE;
/*!40000 ALTER TABLE `measurement` DISABLE KEYS */;
INSERT INTO `measurement` VALUES (1,0,1,'2011-04-21 12:30:00','23',0,1,1,'BloodGas_Measurement');
/*!40000 ALTER TABLE `measurement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES (1,'A-1',1,1,1);
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `patient_bedlocation`
--

LOCK TABLES `patient_bedlocation` WRITE;
/*!40000 ALTER TABLE `patient_bedlocation` DISABLE KEYS */;
INSERT INTO `patient_bedlocation` VALUES (1,1,'2011-04-20 03:55:40',NULL,1,1,1),(2,2,'2011-04-20 04:55:40',NULL,1,1,1);
/*!40000 ALTER TABLE `patient_bedlocation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'David',NULL,'David',NULL,NULL,NULL);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

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

-- Dump completed on 2011-04-28  2:40:19
