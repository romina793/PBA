-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: vendedores
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `articulo`
--

DROP TABLE IF EXISTS `articulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `articulo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `codigo` int DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `precioCosto` double DEFAULT NULL,
  `precioVenta` double DEFAULT NULL,
  `marca_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_9wnxvdqpodb4xbth4pyy8gvn3` (`marca_id`),
  CONSTRAINT `FK_9wnxvdqpodb4xbth4pyy8gvn3` FOREIGN KEY (`marca_id`) REFERENCES `marca` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articulo`
--

LOCK TABLES `articulo` WRITE;
/*!40000 ALTER TABLE `articulo` DISABLE KEYS */;
INSERT INTO `articulo` VALUES (1,1,'Televisor','Televisor LED 32',38000,48000,1),(2,1,'Televisor','Televisor LED 43',40000,49000,1),(3,1,'Televisor','Televisor LED 55',42000,50000,1),(4,1,'Televisor','Televisor LED 65',50000,59000,2),(5,1,'Celular','Pulgada de Celular 6.43',40000,50000,2),(6,1,'Celular','Pulgada de Celular 6.53',60000,66000,2),(7,1,'Celular','Pulgada de Celular 6.55',64000,67000,3),(8,1,'Celular','Pulgada de Celular 6.78',42000,50000,3),(9,2,'Mesa','Mesa madera',100,1000,3),(10,21,'Silla','nada',1,10,3),(11,2,'Mesa','Mesa hierro',100,1000,1),(12,32,'Silla','Silla hierro',2,200,1),(13,4,'Celular','Pulgada de Celular 6.55',64000,67000,3),(14,4,'Celular','Pulgada de Celular 6.55',64000,67000,3),(15,9,'Televisor','Televisor LED 55',42000,50000,1),(16,9,'Televisor','Televisor LED 55',42000,50000,1);
/*!40000 ALTER TABLE `articulo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-27  3:30:19
