CREATE DATABASE `dbchamados`;

USE `dbchamados`;

/*Table structure for table `atendimentos` */

CREATE TABLE `atendimentos` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CodChamado` int(11) NOT NULL,
  `Descricao` text NOT NULL,
  `DataAtendimento` text NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `atendimentos` */

/*Table structure for table `chamados` */

CREATE TABLE `chamados` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CodCliente` int(11) NOT NULL,
  `CodEquip` int(11) NOT NULL,
  `Status` int(11) NOT NULL,
  `DataAbertura` text NOT NULL,
  `DataFechamento` text DEFAULT NULL,
  `Defeito` text NOT NULL,
  `Valor` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `chamados` */

/*Table structure for table `clientes` */

CREATE TABLE `clientes` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` text NOT NULL,
  `DataNasc` text DEFAULT NULL,
  `Cel` text NOT NULL,
  `Endereco` text DEFAULT NULL,
  `Genero` tinytext DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `clientes` */

/*Table structure for table `equipamentos` */

CREATE TABLE `equipamentos` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ClienteID` int(11) NOT NULL,
  `TipoEquip` text NOT NULL,
  `Serial` text NOT NULL,
  `Marca` text NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ClienteID` (`ClienteID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `equipamentos` */

/*Table structure for table `niveisacesso` */

CREATE TABLE `niveisacesso` (
  `ID` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `Nivel` text NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `niveisacesso` */

/*Table structure for table `status` */

CREATE TABLE `status` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Situacao` text NOT NULL,
  `Descricao` text NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

/*Data for the table `status` */

/*Table structure for table `tiposequip` */

CREATE TABLE `tiposequip` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Tipos` text NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `tiposequip` */

/*Table structure for table `users` */

CREATE TABLE `users` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Nome` text NOT NULL,
  `Nivel` int(11) NOT NULL,
  `Senha` text NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `users` */

insert  into `users`(`ID`,`Nome`,`Nivel`,`Senha`) values (4,'Peter',1,'1');

/*Table structure for table `usuariologado` */

CREATE TABLE `usuariologado` (
  `Nivel` int(11) NOT NULL,
  `Nome` text NOT NULL,
  PRIMARY KEY (`Nivel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `usuariologado` */
INSERT INTO `usuariologado` VALUES (1, "")