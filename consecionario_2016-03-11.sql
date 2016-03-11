# ************************************************************
# Sequel Pro SQL dump
# Versión 4529
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.5.5-10.1.11-MariaDB)
# Base de datos: consecionario
# Tiempo de Generación: 2016-03-11 14:22:03 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Volcado de tabla carros
# ------------------------------------------------------------

DROP TABLE IF EXISTS `carros`;

CREATE TABLE `carros` (
  `matricula` varchar(6) NOT NULL DEFAULT '',
  `modelo` varchar(20) DEFAULT NULL,
  `fabricante` varchar(20) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `cilindraje` int(11) DEFAULT NULL,
  `potencia` int(11) DEFAULT NULL,
  `precio` int(11) DEFAULT NULL,
  `transmision` bit(1) DEFAULT NULL,
  PRIMARY KEY (`matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Volcado de tabla clientes
# ------------------------------------------------------------

DROP TABLE IF EXISTS `clientes`;

CREATE TABLE `clientes` (
  `id` int(11) unsigned NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Volcado de tabla ventas
# ------------------------------------------------------------

DROP TABLE IF EXISTS `ventas`;

CREATE TABLE `ventas` (
  `ventaid` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `matricula` varchar(6) NOT NULL DEFAULT '',
  `clienteid` int(11) unsigned NOT NULL,
  PRIMARY KEY (`ventaid`),
  KEY `matricula` (`matricula`),
  KEY `clienteid` (`clienteid`),
  CONSTRAINT `carroventas` FOREIGN KEY (`matricula`) REFERENCES `carros` (`matricula`),
  CONSTRAINT `clienteventas` FOREIGN KEY (`clienteid`) REFERENCES `clientes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
