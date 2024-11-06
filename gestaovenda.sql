CREATE DATABASE `gestaovendabd` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `gestaovendabd`;

CREATE TABLE `categoria` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(75) NOT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cliente` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(75) DEFAULT NULL,
  `cpf` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `morada` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfp` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `estoque` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `produtoId` bigint NOT NULL,
  `quantidade` int NOT NULL,
  `usuarioId` bigint NOT NULL,
  `estado` tinyint NOT NULL DEFAULT '0',
  `dataCriacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `produtoid` (`produtoId`),
  KEY `fk_estoque_usuarioid` (`usuarioId`),
  CONSTRAINT `fk_estoque_produto` FOREIGN KEY (`produtoId`) REFERENCES `produto` (`id`),
  CONSTRAINT `fk_estoque_usuarioid` FOREIGN KEY (`usuarioId`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `estoquehistorico` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `produto` varchar(100) NOT NULL,
  `quantidade` int NOT NULL,
  `usuario` varchar(100) NOT NULL,
  `tipo` varchar(100) NOT NULL,
  `observacao` varchar(100) NOT NULL,
  `dataCriacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `permissao` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(75) NOT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `permissaousuario` (
  `permissaoId` bigint NOT NULL,
  `usuarioId` bigint NOT NULL,
  PRIMARY KEY (`permissaoId`,`usuarioId`),
  KEY `fk_permissaousuario_usuarioid` (`usuarioId`),
  CONSTRAINT `fk_permissaousuario_permissaoid` FOREIGN KEY (`permissaoId`) REFERENCES `permissao` (`id`),
  CONSTRAINT `fk_permissaousuario_usuarioid` FOREIGN KEY (`usuarioId`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `produto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  `preco` decimal(10,2) NOT NULL,
  `categoriaId` bigint NOT NULL,
  `usuarioId` bigint NOT NULL,
  `dataCriacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome` (`nome`),
  KEY `fk_produto_categoria` (`categoriaId`),
  KEY `fk_produto_usuarioid` (`usuarioId`),
  CONSTRAINT `fk_produto_usuarioid` FOREIGN KEY (`usuarioId`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `usuario` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `email` varchar(150) NOT NULL,
  `senha` varchar(200) NOT NULL,
  `estado` tinyint NOT NULL DEFAULT '0',
  `perfil` varchar(10) NOT NULL,
  `UrlFoto` varchar(150) DEFAULT NULL,
  `dataCriacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ultimoLogin` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `venda` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `totalvenda` decimal(10,2) NOT NULL,
  `valorpago` decimal(10,2) NOT NULL,
  `troco` decimal(10,2) NOT NULL,
  `desconto` decimal(10,2) NOT NULL,
  `clienteid` bigint NOT NULL,
  `usuarioid` bigint NOT NULL,
  `datacriacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ultimaAtualizacao` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `vendaitem` (
  `vendaid` bigint NOT NULL,
  `produtoid` bigint NOT NULL,
  `quantidade` int NOT NULL,
  `desconto` decimal(10,2) NOT NULL,
  `total` decimal(10,2) NOT NULL,
  PRIMARY KEY (`vendaid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


