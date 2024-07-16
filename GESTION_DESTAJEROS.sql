/*
SQLyog Community v8.71 
MySQL - 5.5.5-10.4.20-MariaDB : Database - gestion_destajeros
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`gestion_destajeros` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `gestion_destajeros`;

/*Table structure for table `cliente` */

DROP TABLE IF EXISTS `cliente`;

CREATE TABLE `cliente` (
  `IdCliente` int(11) NOT NULL AUTO_INCREMENT,
  `Ruc` char(11) NOT NULL,
  `RazonSocial` varchar(300) NOT NULL,
  `Direccion` varchar(300) NOT NULL,
  `Telefono` varchar(20) NOT NULL,
  `RepresentanteLegal` varchar(300) NOT NULL,
  `IdUsuarioRegistro` int(11) NOT NULL,
  `Estado` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`IdCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

/*Data for the table `cliente` */

insert  into `cliente`(`IdCliente`,`Ruc`,`RazonSocial`,`Direccion`,`Telefono`,`RepresentanteLegal`,`IdUsuarioRegistro`,`Estado`) values (1,'12345678141','Express sa','Av Lince 174 lince','9874514','luis perales',1,1);

/*Table structure for table `empresadestajero` */

DROP TABLE IF EXISTS `empresadestajero`;

CREATE TABLE `empresadestajero` (
  `IdEmpresaDestajero` int(11) NOT NULL AUTO_INCREMENT,
  `Ruc` varchar(20) NOT NULL,
  `RazonSocial` varchar(300) NOT NULL,
  `Direccion` varchar(300) NOT NULL,
  `Telefono` varchar(20) NOT NULL,
  `RepresentanteLegal` varchar(300) NOT NULL,
  `IdUsuarioRegistro` int(11) NOT NULL,
  `Estado` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`IdEmpresaDestajero`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

/*Data for the table `empresadestajero` */

insert  into `empresadestajero`(`IdEmpresaDestajero`,`Ruc`,`RazonSocial`,`Direccion`,`Telefono`,`RepresentanteLegal`,`IdUsuarioRegistro`,`Estado`) values (1,'125478987477','Stalin S.A','Av sauce 17 lince','3214547','Santos Roca',1,1);

/*Table structure for table `modelo` */

DROP TABLE IF EXISTS `modelo`;

CREATE TABLE `modelo` (
  `IdModelo` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(300) NOT NULL,
  `Estado` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`IdModelo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `modelo` */

insert  into `modelo`(`IdModelo`,`Nombre`,`Estado`) values (1,'glamur',1),(2,'Veranil',1),(3,'ropa interior',1),(4,'trajes de baño',1);

/*Table structure for table `pedido` */

DROP TABLE IF EXISTS `pedido`;

CREATE TABLE `pedido` (
  `IdPedido` int(11) NOT NULL,
  `IdCliente` int(11) NOT NULL,
  `IdEmpresaDestajero` int(11) NOT NULL,
  `Fecha` varchar(10) NOT NULL,
  `FechaDevolucion` varchar(10) NOT NULL,
  `Total` decimal(10,2) NOT NULL,
  `Comentario` varchar(300) NOT NULL,
  `IdUsuarioRegistro` int(11) NOT NULL,
  `Estado` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`IdPedido`),
  KEY `IdCliente` (`IdCliente`),
  KEY `IdEmpresaDestajero` (`IdEmpresaDestajero`),
  CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`IdCliente`) REFERENCES `cliente` (`IdCliente`) ON DELETE CASCADE,
  CONSTRAINT `pedido_ibfk_2` FOREIGN KEY (`IdEmpresaDestajero`) REFERENCES `empresadestajero` (`IdEmpresaDestajero`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `pedido` */

insert  into `pedido`(`IdPedido`,`IdCliente`,`IdEmpresaDestajero`,`Fecha`,`FechaDevolucion`,`Total`,`Comentario`,`IdUsuarioRegistro`,`Estado`) values (1,1,1,'28/06/2024','28/07/2024','118.00','mercaderia elaborar',1,'EN PROCESO'),(2,1,1,'28/06/2024','28/07/2024','144.00','merderia',1,'ENTREGADO'),(3,1,1,'28/06/2024','28/08/2024','67.00','mercaderia',1,'PENDIENTE'),(4,1,1,'30/06/2024','30/09/2024','67.00','',1,'PENDIENTE'),(5,1,1,'30/06/2024','30/10/2024','119.00','',1,'PENDIENTE');

/*Table structure for table `pedidodetalle` */

DROP TABLE IF EXISTS `pedidodetalle`;

CREATE TABLE `pedidodetalle` (
  `IdPedido` int(11) NOT NULL,
  `IdProducto` int(11) NOT NULL,
  `Descripcion` varchar(300) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `Precio` decimal(10,2) NOT NULL,
  `Importe` decimal(10,2) NOT NULL,
  KEY `IdPedido` (`IdPedido`),
  KEY `IdProducto` (`IdProducto`),
  CONSTRAINT `pedidodetalle_ibfk_1` FOREIGN KEY (`IdPedido`) REFERENCES `pedido` (`IdPedido`),
  CONSTRAINT `pedidodetalle_ibfk_2` FOREIGN KEY (`IdProducto`) REFERENCES `producto` (`IdProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `pedidodetalle` */

insert  into `pedidodetalle`(`IdPedido`,`IdProducto`,`Descripcion`,`Cantidad`,`Precio`,`Importe`) values (1,2,'short',2,'25.00','50.00'),(1,11,'Bikini',4,'17.00','68.00'),(2,2,'short',1,'25.00','25.00'),(2,11,'Bikini',7,'17.00','119.00'),(3,2,'short',2,'25.00','50.00'),(3,11,'Bikini',1,'17.00','17.00'),(4,2,'short',2,'25.00','50.00'),(4,11,'Bikini',1,'17.00','17.00'),(5,11,'Bikini',7,'17.00','119.00');

/*Table structure for table `producto` */

DROP TABLE IF EXISTS `producto`;

CREATE TABLE `producto` (
  `IdProducto` int(11) NOT NULL AUTO_INCREMENT,
  `IdModelo` int(11) NOT NULL,
  `Descripcion` varchar(300) NOT NULL,
  `Precio` decimal(10,2) NOT NULL,
  `Stock` int(11) NOT NULL,
  `IdUsuarioRegistro` int(11) NOT NULL,
  `Estado` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`IdProducto`),
  KEY `IdModelo` (`IdModelo`),
  CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`IdModelo`) REFERENCES `modelo` (`IdModelo`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4;

/*Data for the table `producto` */

insert  into `producto`(`IdProducto`,`IdModelo`,`Descripcion`,`Precio`,`Stock`,`IdUsuarioRegistro`,`Estado`) values (2,3,'short','25.00',196,1,1),(11,1,'Bikini','17.00',141,1,1);

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `IdUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `Usuario` varchar(200) NOT NULL,
  `Contraseña` varchar(300) NOT NULL,
  `Cargo` varchar(300) NOT NULL,
  `Estado` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`IdUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `usuario` */

insert  into `usuario`(`IdUsuario`,`Usuario`,`Contraseña`,`Cargo`,`Estado`) values (1,'pepe','123','Administrador',1),(2,'axe','12345','Asistente',1);

/* Trigger structure for table `pedidodetalle` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `TRG_Actualizar_Stock_Producto` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `TRG_Actualizar_Stock_Producto` AFTER INSERT ON `pedidodetalle` FOR EACH ROW BEGIN
    UPDATE Producto
    SET Stock = Stock - NEW.Cantidad
    WHERE IdProducto = NEW.IdProducto;
END */$$


DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
