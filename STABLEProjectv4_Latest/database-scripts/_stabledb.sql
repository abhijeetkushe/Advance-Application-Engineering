/*
SQLyog Ultimate v8.32 
MySQL - 5.5.8 : Database - stabledb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`stabledb` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `stabledb`;

/*Table structure for table `assesment` */

DROP TABLE IF EXISTS `assesment`;

CREATE TABLE `assesment` (
  `assessment_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`assessment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `assesment` */

/*Table structure for table `bed_location` */

DROP TABLE IF EXISTS `bed_location`;

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

/*Data for the table `bed_location` */

insert  into `bed_location`(`bedlocation_id`,`location`,`type`,`status`,`clinic_id`,`careteam_id`) values (1,'DS-201',1,1,1,1);

/*Table structure for table `birth_details` */

DROP TABLE IF EXISTS `birth_details`;

CREATE TABLE `birth_details` (
  `patient_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`patient_id`),
  UNIQUE KEY `patient_id_UNIQUE` (`patient_id`),
  KEY `fk_birthdetails_patientid` (`patient_id`),
  CONSTRAINT `fk_birthdetails_patientid` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `birth_details` */

/*Table structure for table `care_team` */

DROP TABLE IF EXISTS `care_team`;

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

/*Data for the table `care_team` */

insert  into `care_team`(`careteam_id`,`team_name`,`leader_id`,`clinic_id`) values (1,'CT-1',1,1),(2,'BlueTeam',1,1);

/*Table structure for table `careteam_employee` */

DROP TABLE IF EXISTS `careteam_employee`;

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

/*Data for the table `careteam_employee` */

insert  into `careteam_employee`(`employee_id`,`careteam_id`,`id`) values (1,1,1),(2,1,2);

/*Table structure for table `clinic` */

DROP TABLE IF EXISTS `clinic`;

CREATE TABLE `clinic` (
  `clinic_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'Primary key for the clinic table',
  `name` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT 'N/A' COMMENT 'Name of the clinic',
  PRIMARY KEY (`clinic_id`),
  UNIQUE KEY `clinic_id_UNIQUE` (`clinic_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `clinic` */

insert  into `clinic`(`clinic_id`,`name`) values (1,'Beth Israel');

/*Table structure for table `device` */

DROP TABLE IF EXISTS `device`;

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

/*Data for the table `device` */

insert  into `device`(`device_id`,`name`,`model_no`,`inventory_no`,`status`,`clinic_id`,`discriminator`,`type`,`measurement_type`) values (1,'TD-1','345','FGH-745',1,1,'BloodGasDevice',0,0);

/*Table structure for table `device_bl` */

DROP TABLE IF EXISTS `device_bl`;

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

/*Data for the table `device_bl` */

insert  into `device_bl`(`device_id`,`bedlocation_id`,`id`) values (1,1,1);

/*Table structure for table `device_pbl` */

DROP TABLE IF EXISTS `device_pbl`;

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

/*Data for the table `device_pbl` */

insert  into `device_pbl`(`device_id`,`patientbedlocation_id`,`id`) values (1,1,0);

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

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

/*Data for the table `employee` */

insert  into `employee`(`employee_id`,`first_name`,`last_name`,`middle_name`,`preferred_name`,`gender`,`is_active`,`role`,`clinic_id`) values (1,'Matt','John',NULL,'Matt',1,'',1,1),(2,'Mike','Andrew',NULL,'Mike',1,'',1,1);

/*Table structure for table `employee_pbl` */

DROP TABLE IF EXISTS `employee_pbl`;

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

/*Data for the table `employee_pbl` */

insert  into `employee_pbl`(`employee_id`,`patient_bedlocation_id`,`id`) values (1,1,1),(2,2,2);

/*Table structure for table `encounter` */

DROP TABLE IF EXISTS `encounter`;

CREATE TABLE `encounter` (
  `encounter_id` int(10) NOT NULL AUTO_INCREMENT,
  `encounterdate` date DEFAULT NULL,
  `patient_id` int(10) unsigned NOT NULL,
  `followup_id` int(10) DEFAULT NULL,
  `treatment_id` int(10) DEFAULT NULL,
  `assesment_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`encounter_id`),
  KEY `FK_encounter_patientid` (`patient_id`),
  CONSTRAINT `FK_encounter_patientid` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`patient_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `encounter` */

insert  into `encounter`(`encounter_id`,`encounterdate`,`patient_id`,`followup_id`,`treatment_id`,`assesment_id`) values (1,'2011-05-01',1,NULL,NULL,NULL),(2,'2011-05-01',2,NULL,NULL,NULL);

/*Table structure for table `measurement` */

DROP TABLE IF EXISTS `measurement`;

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `measurement` */

insert  into `measurement`(`measurement_id`,`methodtype_id`,`unit_id`,`datetime`,`value`,`measurementype_id`,`patient_id`,`device_id`,`discriminator`) values (1,0,1,'2011-04-21 12:30:00','23',0,1,1,'BloodGas_Measurement'),(2,0,1,'2011-04-30 12:30:00','23',0,1,1,'BloodGas_Measurement');

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `OrderID` int(11) NOT NULL,
  `OrderType` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `OrderedOn` date DEFAULT NULL,
  `assessment_id` int(11) DEFAULT NULL,
  `treatment_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`OrderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `order` */

/*Table structure for table `patient` */

DROP TABLE IF EXISTS `patient`;

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `patient` */

insert  into `patient`(`patient_id`,`patient_tag`,`status`,`clinic_id`,`person_id`) values (1,'A-1',1,1,1),(2,'JS-1',1,1,2);

/*Table structure for table `patient_bedlocation` */

DROP TABLE IF EXISTS `patient_bedlocation`;

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

/*Data for the table `patient_bedlocation` */

insert  into `patient_bedlocation`(`patient_bedlocation_id`,`status`,`admitted_on`,`discharged_on`,`patient_id`,`bedlocation_id`,`careteam_id`) values (1,1,'2011-04-20 03:55:40',NULL,1,1,1),(2,2,'2011-04-20 04:55:40',NULL,1,1,1);

/*Table structure for table `person` */

DROP TABLE IF EXISTS `person`;

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `person` */

insert  into `person`(`person_id`,`first_name`,`last_name`,`preferred_name`,`mother_id`,`father_id`,`is_mother`) values (1,'David',NULL,'David',NULL,NULL,''),(2,'Jane','Smith','JSmith',NULL,NULL,'');

/*Table structure for table `treatment` */

DROP TABLE IF EXISTS `treatment`;

CREATE TABLE `treatment` (
  `treatment_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`treatment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `treatment` */

/*Table structure for table `useraccount` */

DROP TABLE IF EXISTS `useraccount`;

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

/*Data for the table `useraccount` */

insert  into `useraccount`(`useraccount_id`,`username`,`password`,`status`,`employee_id`,`created_on`,`created_by`,`expire_on`,`clinic_id`) values (1,'mike','mike',1,1,'2011-04-20 03:45:40',NULL,NULL,1),(2,'matt','matt',1,2,'2011-04-20 03:47:40',NULL,NULL,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
