CREATE DATABASE  IF NOT EXISTS `bug_tracking_system` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bug_tracking_system`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: bug_tracking_system
-- ------------------------------------------------------
-- Server version	8.1.0

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
-- Table structure for table `bugs`
--

DROP TABLE IF EXISTS `bugs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bugs` (
  `id` int NOT NULL,
  `name` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  `level` int NOT NULL,
  `priority` int NOT NULL,
  `project` varchar(50) NOT NULL,
  `date` date NOT NULL,
  `screenshot` varchar(300) NOT NULL,
  `status` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bugs`
--

LOCK TABLES `bugs` WRITE;
/*!40000 ALTER TABLE `bugs` DISABLE KEYS */;
INSERT INTO `bugs` VALUES (1,'bug_1','type_1',1,1,'project_1','2021-01-01','D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png','closed'),(2,'bug_2','type_2',1,1,'project_2','2021-01-01','D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png','closed'),(3,'bug_3','type_3',1,1,'project_3','2021-01-01','D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png','closed'),(4,'bug_4','type_4',1,1,'project_4','2021-01-01','D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png','closed'),(5,'bug_5','type_5',1,1,'project_5','2021-01-01','D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png','closed'),(6,'bug_6','type_6',1,1,'project_6','2021-01-01','D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png','closed'),(7,'bug_7','type_7',1,1,'project_7','2021-01-01','D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png','closed'),(8,'bug_8','type_8',1,1,'project_8','2021-01-01','D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png','closed'),(9,'bug_9','type_9',1,1,'project_9','2021-01-01','D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png','closed'),(10,'bug_10','type_10',1,1,'project_10','2021-01-01','D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png','closed'),(11,'bug_11','type_11',2,2,'project_11','2021-02-02','D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png','opened'),(12,'bug_12','type_12',2,2,'project_12','2021-02-02','D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png','opened'),(13,'bug_13','type_13',2,2,'project_13','2021-02-02','D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png','opened'),(14,'bug_14','type_14',2,2,'project_14','2021-02-02','D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png','opened'),(15,'bug_15','type_15',2,2,'project_15','2021-02-02','D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png','closed'),(16,'bug_16','type_16',2,2,'project_16','2021-02-02','D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png','opened'),(17,'bug_17','type_17',2,2,'project_17','2021-02-02','D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png','opened'),(18,'bug_18','type_18',2,2,'project_18','2021-02-02','D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png','opened'),(19,'bug_19','type_19',2,2,'project_19','2021-02-02','D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png','opened'),(20,'bug_20','type_20',3,3,'project_20','2020-03-03','D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png','complete'),(21,'bug_21','type_21',3,3,'project_21','2020-03-03','D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png','complete'),(22,'bug_22','type_22',3,3,'project_22','2020-03-03','D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png','complete'),(23,'bug_23','type_23',3,3,'project_23','2020-03-03','D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png','complete'),(24,'bug_24','type_24',3,3,'project_24','2020-03-03','D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png','comlpete'),(25,'bug_25','type_25',3,3,'project_25','2020-03-03','D:ProgramingProjectsJavaBugTrackingSystemscreenshot.png','complete'),(26,'bug_26','typr_26',2,3,'project_26','2024-02-11','E:SoftwareJavaBugTrackingSystemack.png','opened');
/*!40000 ALTER TABLE `bugs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `performance`
--

DROP TABLE IF EXISTS `performance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `performance` (
  `bug_id` int NOT NULL,
  `test_id` int NOT NULL,
  `test_perf` double NOT NULL,
  `dev_id` int NOT NULL,
  `dev_perf` double NOT NULL,
  UNIQUE KEY `bi_fk` (`bug_id`) USING BTREE,
  KEY `de_fk` (`dev_id`),
  KEY `te_fk` (`test_id`),
  CONSTRAINT `de_fk` FOREIGN KEY (`dev_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `te_fk` FOREIGN KEY (`test_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `performance`
--

LOCK TABLES `performance` WRITE;
/*!40000 ALTER TABLE `performance` DISABLE KEYS */;
INSERT INTO `performance` VALUES (1,201900085,5,201900737,2),(2,201900085,3,201900737,5),(3,201900085,3,201900737,2),(4,201900085,4,201900737,2),(5,201900085,1,201900737,6),(6,201900085,6,201900992,6),(7,201900085,5,201900992,4),(8,201900085,7,201900992,4),(9,201900085,1,201900992,5),(10,201900085,1,201900992,7),(20,201900746,5,201900737,6),(21,201900746,1,201900737,4),(22,201900746,4,201900737,6),(23,201900746,4,201900737,6),(24,201900746,3,201900992,7),(25,201900746,2,201900992,7),(26,201900746,4,201900737,0);
/*!40000 ALTER TABLE `performance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2019010000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (123456789,'Mohammed Medhat','999999','Admin'),(201900085,'Ahmed Osman','333333','Tester'),(201900518,'Omar Abd_Rabo','111111','Admin'),(201900737,'Mohammed Moataz','222222','Developer'),(201900746,'Mohamed Hesham','333333','Tester'),(201900762,'Mahmoud Gamal','444444','Project manager'),(201900992,'Youssef Mohamed','222222','Developer');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bug_tracking_system'
--

--
-- Dumping routines for database 'bug_tracking_system'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-12  1:00:44
