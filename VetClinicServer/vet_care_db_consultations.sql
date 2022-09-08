-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: vet_care_db
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `consultations`
--

DROP TABLE IF EXISTS `consultations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consultations` (
  `id` int NOT NULL AUTO_INCREMENT,
  `detected_disease` varchar(255) DEFAULT NULL,
  `intended_hour` datetime(6) DEFAULT NULL,
  `animal_id` int DEFAULT NULL,
  `prescription_id` int DEFAULT NULL,
  `working_hours_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcnwordwayl0t4y0ows8hbl10l` (`animal_id`),
  KEY `FK4bptujmt16pyr7jjw99qs4tne` (`prescription_id`),
  KEY `FKjn9rg3hi23uwrtv8cijvpqqty` (`working_hours_id`),
  CONSTRAINT `FK4bptujmt16pyr7jjw99qs4tne` FOREIGN KEY (`prescription_id`) REFERENCES `prescriptions` (`id`),
  CONSTRAINT `FKcnwordwayl0t4y0ows8hbl10l` FOREIGN KEY (`animal_id`) REFERENCES `animal` (`id`),
  CONSTRAINT `FKjn9rg3hi23uwrtv8cijvpqqty` FOREIGN KEY (`working_hours_id`) REFERENCES `working_hours` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consultations`
--

LOCK TABLES `consultations` WRITE;
/*!40000 ALTER TABLE `consultations` DISABLE KEYS */;
INSERT INTO `consultations` VALUES (1,'Anthrax','2022-09-12 10:30:00.000000',8,1,1),(4,'Black Quarter','2022-09-12 11:40:00.000000',8,2,2),(5,'Rabies','2022-09-12 13:40:00.000000',8,3,4),(6,'Rabies','2022-09-12 13:40:00.000000',9,4,11),(7,'Pox','2022-09-12 15:40:00.000000',10,NULL,6),(8,'Anthrax','2022-09-12 12:30:00.000000',11,NULL,3),(9,'Anthrax','2022-09-12 12:30:00.000000',12,NULL,10),(10,'Anthrax','2022-09-12 12:30:00.000000',13,NULL,17),(11,'Anthrax','2022-09-12 12:30:00.000000',14,5,24),(12,'Anthrax','2022-09-12 14:30:00.000000',15,NULL,5),(13,'Anthrax','2022-09-12 14:30:00.000000',16,NULL,12);
/*!40000 ALTER TABLE `consultations` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-08 10:56:52
