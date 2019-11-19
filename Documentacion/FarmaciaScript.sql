-- Data Base for MySQL 5.*.* 
-- Made in MySQL Workbench Win64
-- Host 127.0.0.1 DataBase: farmacia

-- Hecha por:
-- Eduardo
-- Diego
-- Raul

DROP DATABASE IF EXISTS `farmacia`;

CREATE DATABASE `farmacia`;

USE farmacia;

DROP TABLE IF EXISTS `empleados`;

CREATE TABLE `empleados` (
  `DNI` VARCHAR(9) NOT NULL ,
  `CONTRASENIA` varchar(45) NOT NULL,
  `NOMBRE` varchar(45) NOT NULL,
  `APELLIDOS` varchar(45) NOT NULL,
  `FECHA_CONTRATACION` date NOT NULL,
  `ADMIN` BIGINT(2) NOT NULL,
  PRIMARY KEY (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

DROP TABLE IF EXISTS `productos`;

CREATE TABLE `productos` (
  `ID_PRODUCTO` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `NOMBRE_PRODUCTO` varchar(45) NOT NULL,
  `CANTIDAD` BIGINT(20) NOT NULL,
  PRIMARY KEY (`ID_PRODUCTO`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

DROP TABLE IF EXISTS `ventas`;

CREATE TABLE `ventas` (
  `ID_VENTA` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `FECHA_VENTA` date NOT NULL,
  `TOTAL_VENTA` BIGINT(20) NOT NULL,
  `DNI` VARCHAR(9) NOT NULL ,
  PRIMARY KEY (`ID_VENTA`),
  KEY `EMPLEADO_FK_idx` (`DNI`),
  CONSTRAINT `EMPLEADO_FK` FOREIGN KEY (`DNI`) REFERENCES `empleados` (`DNI`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;

DROP TABLE IF EXISTS `prodVent`;

CREATE TABLE `prodVent` (
  `ID_PRODVENT` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `ID_PROD` BIGINT(20),
  `ID_VENT` BIGINT(20),
  PRIMARY KEY (`ID_PRODVENT`),
  KEY `PRODUCTOS_FK_idx` (`ID_PROD`),
  CONSTRAINT `PRODUCTOS_FK` FOREIGN KEY (`ID_PROD`) REFERENCES `productos` (`ID_PRODUCTO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `VENTAS_FK_idx` (`ID_VENT`),
  CONSTRAINT `VENTAS_FK` FOREIGN KEY (`ID_VENT`) REFERENCES `ventas` (`ID_VENTA`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;