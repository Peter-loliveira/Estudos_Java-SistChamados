CREATE DATABASE `dbchamados`;

USE `dbchamados`;

CREATE TABLE `atendimentos` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CodChamado` int(11) NOT NULL,
  `Descricao` text NOT NULL,
  `DataAtendimento` text NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `chamados` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CodCliente` int(11) NOT NULL,
  `CodEquip` int(11) NOT NULL,
  `Status` int(11) NOT NULL,
  `DataAbertura` text NOT NULL,
  `DataFechamento` text DEFAULT NULL,
  `Defeito` text NOT NULL,
  `Valor` float(12,2) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `clientes` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` text NOT NULL,
  `DataNasc` text DEFAULT NULL,
  `Cel` text NOT NULL,
  `Endereco` text DEFAULT NULL,
  `Genero` tinytext DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `equipamentos` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ClienteID` int(11) NOT NULL,
  `TipoEquip` text NOT NULL,
  `Serial` text NOT NULL,
  `Marca` text NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ClienteID` (`ClienteID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `niveisacesso` (
  `ID` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `Nivel` text NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `status` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Situacao` text NOT NULL,
  `Descricao` text NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `tiposequip` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Tipos` text NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `users` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Nome` text NOT NULL,
  `Nivel` int(11) NOT NULL,
  `Senha` text NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `usuariologado` (
  `Nivel` int(11) NOT NULL,
  `Nome` text NOT NULL,
  PRIMARY KEY (`Nivel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert  into `usuariologado`(`Nivel`,`Nome`) values (1,' ');