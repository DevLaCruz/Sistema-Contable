-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: contables
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `asiento_apertura`
--

DROP TABLE IF EXISTS `asiento_apertura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asiento_apertura` (
  `idasiento_apertura` int NOT NULL AUTO_INCREMENT,
  `numeroasientoapertura` int NOT NULL,
  PRIMARY KEY (`idasiento_apertura`),
  KEY `fk_asiento_apertura_asiento_contable` (`numeroasientoapertura`),
  CONSTRAINT `fk_asiento_apertura_asiento_contable` FOREIGN KEY (`numeroasientoapertura`) REFERENCES `asiento_contable` (`numero_asiento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asiento_apertura`
--

LOCK TABLES `asiento_apertura` WRITE;
/*!40000 ALTER TABLE `asiento_apertura` DISABLE KEYS */;
/*!40000 ALTER TABLE `asiento_apertura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asiento_cierre`
--

DROP TABLE IF EXISTS `asiento_cierre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asiento_cierre` (
  `idasiento_cierre` int NOT NULL AUTO_INCREMENT,
  `numeroasientocierre` int NOT NULL,
  PRIMARY KEY (`idasiento_cierre`),
  KEY `fk_asiento_cierre_asiento_contable` (`numeroasientocierre`),
  CONSTRAINT `fk_asiento_cierre_asiento_contable` FOREIGN KEY (`numeroasientocierre`) REFERENCES `asiento_contable` (`numero_asiento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asiento_cierre`
--

LOCK TABLES `asiento_cierre` WRITE;
/*!40000 ALTER TABLE `asiento_cierre` DISABLE KEYS */;
/*!40000 ALTER TABLE `asiento_cierre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asiento_contable`
--

DROP TABLE IF EXISTS `asiento_contable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asiento_contable` (
  `numero_asiento` int NOT NULL,
  `fecha` date NOT NULL,
  `glosa` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  `codigo_operacion` int NOT NULL,
  `id_periodo` int NOT NULL,
  `codigo_usuario` int NOT NULL,
  PRIMARY KEY (`numero_asiento`),
  KEY `fk_asiento_contable_tipo_operacion` (`codigo_operacion`),
  KEY `fk_asiento_contable_periodo_contable` (`id_periodo`),
  KEY `fk_asiento_contable_usuario_idx` (`codigo_usuario`),
  CONSTRAINT `fk_asiento_contable_periodo_contable` FOREIGN KEY (`id_periodo`) REFERENCES `periodo_contable` (`id`),
  CONSTRAINT `fk_asiento_contable_tipo_operacion` FOREIGN KEY (`codigo_operacion`) REFERENCES `tipo_operacion` (`codigo`),
  CONSTRAINT `fk_asiento_contable_usuario` FOREIGN KEY (`codigo_usuario`) REFERENCES `usuario` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asiento_contable`
--

LOCK TABLES `asiento_contable` WRITE;
/*!40000 ALTER TABLE `asiento_contable` DISABLE KEYS */;
/*!40000 ALTER TABLE `asiento_contable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asiento_operacion`
--

DROP TABLE IF EXISTS `asiento_operacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asiento_operacion` (
  `idasiento_operacion` int NOT NULL AUTO_INCREMENT,
  `numeroasientooperacion` int NOT NULL,
  PRIMARY KEY (`idasiento_operacion`),
  KEY `fk_asiento_operacion_asiento_contable` (`numeroasientooperacion`),
  CONSTRAINT `fk_asiento_operacion_asiento_contable` FOREIGN KEY (`numeroasientooperacion`) REFERENCES `asiento_contable` (`numero_asiento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asiento_operacion`
--

LOCK TABLES `asiento_operacion` WRITE;
/*!40000 ALTER TABLE `asiento_operacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `asiento_operacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clase_bien`
--

DROP TABLE IF EXISTS `clase_bien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clase_bien` (
  `codigo` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clase_bien`
--

LOCK TABLES `clase_bien` WRITE;
/*!40000 ALTER TABLE `clase_bien` DISABLE KEYS */;
/*!40000 ALTER TABLE `clase_bien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuenta_contable`
--

DROP TABLE IF EXISTS `cuenta_contable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuenta_contable` (
  `numero` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `moneda` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`numero`),
  UNIQUE KEY `numero_UNIQUE` (`numero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuenta_contable`
--

LOCK TABLES `cuenta_contable` WRITE;
/*!40000 ALTER TABLE `cuenta_contable` DISABLE KEYS */;
/*!40000 ALTER TABLE `cuenta_contable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuenta_corriente`
--

DROP TABLE IF EXISTS `cuenta_corriente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cuenta_corriente` (
  `numero_identi` int NOT NULL,
  `denominacion` varchar(45) NOT NULL,
  `pais` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `id_tipoiden` int NOT NULL,
  PRIMARY KEY (`numero_identi`),
  UNIQUE KEY `numero_identi_UNIQUE` (`numero_identi`),
  KEY `fk_cuenta_corriente_tipo_identificacion` (`id_tipoiden`),
  CONSTRAINT `fk_cuenta_corriente_tipo_identificacion` FOREIGN KEY (`id_tipoiden`) REFERENCES `tipo_identificacion` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuenta_corriente`
--

LOCK TABLES `cuenta_corriente` WRITE;
/*!40000 ALTER TABLE `cuenta_corriente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cuenta_corriente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `destino_compra`
--

DROP TABLE IF EXISTS `destino_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `destino_compra` (
  `cuenta_origen` int NOT NULL,
  `cuenta_cargo` int DEFAULT NULL,
  `cuenta_abono` int DEFAULT NULL,
  PRIMARY KEY (`cuenta_origen`),
  KEY `fk_destino_compra_cuenta_contable1` (`cuenta_cargo`),
  KEY `fk_destino_compra_cuenta_contable2` (`cuenta_abono`),
  CONSTRAINT `fk_destino_compra_cuenta_contable` FOREIGN KEY (`cuenta_origen`) REFERENCES `cuenta_contable` (`numero`),
  CONSTRAINT `fk_destino_compra_cuenta_contable1` FOREIGN KEY (`cuenta_cargo`) REFERENCES `cuenta_contable` (`numero`),
  CONSTRAINT `fk_destino_compra_cuenta_contable2` FOREIGN KEY (`cuenta_abono`) REFERENCES `cuenta_contable` (`numero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destino_compra`
--

LOCK TABLES `destino_compra` WRITE;
/*!40000 ALTER TABLE `destino_compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `destino_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_asiento`
--

DROP TABLE IF EXISTS `detalle_asiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_asiento` (
  `iddetalle_asiento` int NOT NULL,
  `importe_soles` decimal(2,0) NOT NULL,
  `importe_dolares` decimal(2,0) NOT NULL,
  `debe_soles` decimal(2,0) DEFAULT NULL,
  `debe_dolares` decimal(2,0) DEFAULT NULL,
  `haber_soles` decimal(2,0) DEFAULT NULL,
  `haber_dolares` decimal(2,0) DEFAULT NULL,
  `numero_cuenta` int NOT NULL,
  `id_tipocambio` int NOT NULL,
  `seriedocumento` int NOT NULL,
  PRIMARY KEY (`iddetalle_asiento`),
  KEY `fk_detalle_asiento_cuenta_contable` (`numero_cuenta`),
  KEY `fk_detalle_asiento_tipo_cambio` (`id_tipocambio`),
  KEY `fk_detalle_asiento_documento` (`seriedocumento`),
  CONSTRAINT `fk_detalle_asiento_cuenta_contable` FOREIGN KEY (`numero_cuenta`) REFERENCES `cuenta_contable` (`numero`),
  CONSTRAINT `fk_detalle_asiento_documento` FOREIGN KEY (`seriedocumento`) REFERENCES `documento` (`serie`),
  CONSTRAINT `fk_detalle_asiento_tipo_cambio` FOREIGN KEY (`id_tipocambio`) REFERENCES `tipo_cambio` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_asiento`
--

LOCK TABLES `detalle_asiento` WRITE;
/*!40000 ALTER TABLE `detalle_asiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_asiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `documento`
--

DROP TABLE IF EXISTS `documento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `documento` (
  `serie` int NOT NULL,
  `correlativo` int NOT NULL,
  `concepto` varchar(45) NOT NULL,
  `ambito` varchar(45) NOT NULL,
  `fecha_emision` date NOT NULL,
  `fecha_vencimiento` date NOT NULL,
  `fecha_pago` date NOT NULL,
  `num_cuentacorriente` int NOT NULL,
  PRIMARY KEY (`serie`,`correlativo`),
  KEY `fk_documento_cuenta_corriente` (`num_cuentacorriente`),
  CONSTRAINT `fk_documento_cuenta_corriente` FOREIGN KEY (`num_cuentacorriente`) REFERENCES `cuenta_corriente` (`numero_identi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documento`
--

LOCK TABLES `documento` WRITE;
/*!40000 ALTER TABLE `documento` DISABLE KEYS */;
/*!40000 ALTER TABLE `documento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `periodo_contable`
--

DROP TABLE IF EXISTS `periodo_contable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `periodo_contable` (
  `id` int NOT NULL AUTO_INCREMENT,
  `año` int NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date DEFAULT NULL,
  `estado` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `periodo_contable`
--

LOCK TABLES `periodo_contable` WRITE;
/*!40000 ALTER TABLE `periodo_contable` DISABLE KEYS */;
/*!40000 ALTER TABLE `periodo_contable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_cambio`
--

DROP TABLE IF EXISTS `tipo_cambio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_cambio` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `fecha` date NOT NULL,
  `precio_compra` int NOT NULL,
  `precio_venta` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_cambio`
--

LOCK TABLES `tipo_cambio` WRITE;
/*!40000 ALTER TABLE `tipo_cambio` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_cambio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_documento`
--

DROP TABLE IF EXISTS `tipo_documento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_documento` (
  `codigo` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_documento`
--

LOCK TABLES `tipo_documento` WRITE;
/*!40000 ALTER TABLE `tipo_documento` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_documento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_identificacion`
--

DROP TABLE IF EXISTS `tipo_identificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_identificacion` (
  `codigo` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_identificacion`
--

LOCK TABLES `tipo_identificacion` WRITE;
/*!40000 ALTER TABLE `tipo_identificacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_identificacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_operacion`
--

DROP TABLE IF EXISTS `tipo_operacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_operacion` (
  `codigo` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `tipo_cambio` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_operacion`
--

LOCK TABLES `tipo_operacion` WRITE;
/*!40000 ALTER TABLE `tipo_operacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_operacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `nombres` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `contraseña` varchar(45) NOT NULL,
  `dni` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`),
  UNIQUE KEY `usuario_UNIQUE` (`usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'anghello','villegas','jeanp','anghello','12345678'),(2,'jander','villajuan','janderjoshi','nhabjabdjbsd','12345678'),(3,'admin','admin','dilmera','dilmera','14526898');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-30 10:40:05
