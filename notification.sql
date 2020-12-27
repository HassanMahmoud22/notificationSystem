CREATE DATABASE  IF NOT EXISTS `notifications` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `notifications`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: notifications
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `emailnotification`
--

DROP TABLE IF EXISTS `emailnotification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emailnotification` (
  `tempID` int NOT NULL,
  `subject` varchar(255) NOT NULL,
  `content` varchar(500) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emailnotification`
--

LOCK TABLES `emailnotification` WRITE;
/*!40000 ALTER TABLE `emailnotification` DISABLE KEYS */;
INSERT INTO `emailnotification` VALUES (1,'hahaha','soka{x}','null');
/*!40000 ALTER TABLE `emailnotification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `smsnotification`
--

DROP TABLE IF EXISTS `smsnotification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `smsnotification` (
  `tempID` int NOT NULL,
  `subject` varchar(255) NOT NULL,
  `content` varchar(500) NOT NULL,
  `number` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `smsnotification`
--

LOCK TABLES `smsnotification` WRITE;
/*!40000 ALTER TABLE `smsnotification` DISABLE KEYS */;
INSERT INTO `smsnotification` VALUES (1,'welcome','welcome {x}',1234),(1,'welcome','welcome ahmed',1234);
/*!40000 ALTER TABLE `smsnotification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `templatetable`
--

DROP TABLE IF EXISTS `templatetable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `templatetable` (
  `tempID` int NOT NULL,
  `subject` varchar(255) NOT NULL,
  `content` varchar(500) NOT NULL,
  `language` varchar(255) NOT NULL,
  PRIMARY KEY (`tempID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `templatetable`
--

LOCK TABLES `templatetable` WRITE;
/*!40000 ALTER TABLE `templatetable` DISABLE KEYS */;
/*!40000 ALTER TABLE `templatetable` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-27 15:37:13
