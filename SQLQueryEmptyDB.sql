CREATE DATABASE  IF NOT EXISTS `korporativ_portal` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `korporativ_portal`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: korporativ_portal
-- ------------------------------------------------------
-- Server version	5.7.10-log

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
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `id_city` int(11) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(45) DEFAULT NULL,
  `id_country` int(11) NOT NULL,
  PRIMARY KEY (`id_city`),
  KEY `fk_city_country1_idx` (`id_country`),
  CONSTRAINT `fk_city_country1` FOREIGN KEY (`id_country`) REFERENCES `country` (`id_country`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `id_country` int(11) NOT NULL AUTO_INCREMENT,
  `country_name` varchar(60) NOT NULL,
  `short_country_name` varchar(45) DEFAULT NULL,
  `key_phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_country`),
  UNIQUE KEY `country_name_UNIQUE` (`country_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `division`
--

DROP TABLE IF EXISTS `division`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `division` (
  `id_division` int(11) NOT NULL AUTO_INCREMENT,
  `name_division` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id_division`),
  UNIQUE KEY `id_division_UNIQUE` (`id_division`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `division`
--

LOCK TABLES `division` WRITE;
/*!40000 ALTER TABLE `division` DISABLE KEYS */;
/*!40000 ALTER TABLE `division` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `like`
--

DROP TABLE IF EXISTS `like`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `like` (
  `id_like` int(11) NOT NULL AUTO_INCREMENT,
  `person_id_person` int(11) NOT NULL,
  `record_id_record` int(11) NOT NULL,
  PRIMARY KEY (`id_like`,`person_id_person`,`record_id_record`),
  KEY `fk_like_person1_idx` (`person_id_person`),
  KEY `fk_like_record1_idx` (`record_id_record`),
  CONSTRAINT `fk_like_person1` FOREIGN KEY (`person_id_person`) REFERENCES `person` (`id_person`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_like_record1` FOREIGN KEY (`record_id_record`) REFERENCES `record` (`id_record`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `like`
--

LOCK TABLES `like` WRITE;
/*!40000 ALTER TABLE `like` DISABLE KEYS */;
/*!40000 ALTER TABLE `like` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message`
--

DROP TABLE IF EXISTS `message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message` (
  `id_message` int(11) NOT NULL AUTO_INCREMENT,
  `body` varchar(500) NOT NULL,
  `id_person_sender` int(11) NOT NULL,
  `id_person_recipient` int(11) NOT NULL,
  PRIMARY KEY (`id_message`),
  KEY `fk_message_person1_idx` (`id_person_sender`),
  KEY `fk_message_person2_idx` (`id_person_recipient`),
  CONSTRAINT `fk_message_person1` FOREIGN KEY (`id_person_sender`) REFERENCES `person` (`id_person`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_message_person2` FOREIGN KEY (`id_person_recipient`) REFERENCES `person` (`id_person`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message`
--

LOCK TABLES `message` WRITE;
/*!40000 ALTER TABLE `message` DISABLE KEYS */;
/*!40000 ALTER TABLE `message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `id_person` int(11) NOT NULL AUTO_INCREMENT,
  `firts_name` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `date_of_birth` date NOT NULL,
  `sex` varchar(45) NOT NULL,
  `orientation` varchar(45) NOT NULL,
  `e-mail` varchar(45) NOT NULL,
  `link_self_site` varchar(45) NOT NULL,
  `id_city` int(11) NOT NULL,
  `rating` double NOT NULL,
  `id_division` int(11) NOT NULL,
  `id_post` int(11) NOT NULL,
  PRIMARY KEY (`id_person`),
  KEY `fk_person_city1_idx` (`id_city`),
  KEY `fk_person_division1_idx` (`id_division`),
  KEY `fk_person_post1_idx` (`id_post`),
  CONSTRAINT `fk_person_city1` FOREIGN KEY (`id_city`) REFERENCES `city` (`id_city`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_person_division1` FOREIGN KEY (`id_division`) REFERENCES `division` (`id_division`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_person_post1` FOREIGN KEY (`id_post`) REFERENCES `post` (`id_post`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post` (
  `id_post` int(11) NOT NULL AUTO_INCREMENT,
  `name_post` varchar(60) NOT NULL,
  PRIMARY KEY (`id_post`),
  UNIQUE KEY `id_post_UNIQUE` (`id_post`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `record`
--

DROP TABLE IF EXISTS `record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `record` (
  `id_record` int(11) NOT NULL AUTO_INCREMENT,
  `body` varchar(1000) NOT NULL,
  `id_record_children` int(11) DEFAULT NULL,
  `id_person` int(11) NOT NULL,
  PRIMARY KEY (`id_record`),
  KEY `fk_record_record1_idx` (`id_record_children`),
  KEY `fk_record_person1_idx` (`id_person`),
  CONSTRAINT `fk_record_person1` FOREIGN KEY (`id_person`) REFERENCES `person` (`id_person`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_record_record1` FOREIGN KEY (`id_record_children`) REFERENCES `record` (`id_record`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record`
--

LOCK TABLES `record` WRITE;
/*!40000 ALTER TABLE `record` DISABLE KEYS */;
/*!40000 ALTER TABLE `record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `id_task` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(150) DEFAULT NULL,
  `id_data_begin` int(11) NOT NULL,
  `id_data_end` int(11) NOT NULL,
  `id_type_task` int(11) NOT NULL,
  PRIMARY KEY (`id_task`),
  UNIQUE KEY `id_task_UNIQUE` (`id_task`),
  KEY `fk_task_time1_idx` (`id_data_begin`),
  KEY `fk_task_time2_idx` (`id_data_end`),
  KEY `fk_task_type_task1_idx` (`id_type_task`),
  CONSTRAINT `fk_task_time1` FOREIGN KEY (`id_data_begin`) REFERENCES `time` (`id_time`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_task_time2` FOREIGN KEY (`id_data_end`) REFERENCES `time` (`id_time`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_task_type_task1` FOREIGN KEY (`id_type_task`) REFERENCES `type_task` (`id_type_task`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task_has_person`
--

DROP TABLE IF EXISTS `task_has_person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task_has_person` (
  `id_task` int(11) NOT NULL,
  `id_person` int(11) NOT NULL,
  PRIMARY KEY (`id_task`,`id_person`),
  KEY `fk_task_has_person_person1_idx` (`id_person`),
  KEY `fk_task_has_person_task1_idx` (`id_task`),
  CONSTRAINT `fk_task_has_person_person1` FOREIGN KEY (`id_person`) REFERENCES `person` (`id_person`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_task_has_person_task1` FOREIGN KEY (`id_task`) REFERENCES `task` (`id_task`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_has_person`
--

LOCK TABLES `task_has_person` WRITE;
/*!40000 ALTER TABLE `task_has_person` DISABLE KEYS */;
/*!40000 ALTER TABLE `task_has_person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time`
--

DROP TABLE IF EXISTS `time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `time` (
  `id_time` int(11) NOT NULL AUTO_INCREMENT,
  `day` int(2) NOT NULL,
  `week` int(2) NOT NULL,
  `month` int(2) NOT NULL,
  `quartal` int(1) NOT NULL,
  `year` int(4) DEFAULT NULL,
  PRIMARY KEY (`id_time`),
  UNIQUE KEY `id_time_UNIQUE` (`id_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time`
--

LOCK TABLES `time` WRITE;
/*!40000 ALTER TABLE `time` DISABLE KEYS */;
/*!40000 ALTER TABLE `time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_task`
--

DROP TABLE IF EXISTS `type_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type_task` (
  `id_type_task` int(11) NOT NULL AUTO_INCREMENT,
  `name_type_task` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_type_task`),
  UNIQUE KEY `id_type_task_UNIQUE` (`id_type_task`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_task`
--

LOCK TABLES `type_task` WRITE;
/*!40000 ALTER TABLE `type_task` DISABLE KEYS */;
/*!40000 ALTER TABLE `type_task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_user`
--

DROP TABLE IF EXISTS `type_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type_user` (
  `id_type_user` int(11) NOT NULL AUTO_INCREMENT,
  `name_type` varchar(45) NOT NULL,
  `type_usercol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_type_user`),
  UNIQUE KEY `id_type_user_UNIQUE` (`id_type_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_user`
--

LOCK TABLES `type_user` WRITE;
/*!40000 ALTER TABLE `type_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `type_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `password` varchar(130) NOT NULL,
  `status_session` tinyint(1) DEFAULT '0',
  `status_active` tinyint(1) DEFAULT '1',
  `id_person` int(11) NOT NULL,
  `type_user_id_type_user` int(11) NOT NULL,
  PRIMARY KEY (`id_user`,`id_person`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  UNIQUE KEY `person_id_person_UNIQUE` (`id_person`),
  UNIQUE KEY `id_user_UNIQUE` (`id_user`),
  KEY `fk_user_person1_idx` (`id_person`),
  KEY `fk_user_type_user1_idx` (`type_user_id_type_user`),
  CONSTRAINT `fk_user_person1` FOREIGN KEY (`id_person`) REFERENCES `person` (`id_person`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_type_user1` FOREIGN KEY (`type_user_id_type_user`) REFERENCES `type_user` (`id_type_user`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-02-24 19:40:46
