DROP database if EXISTS agenda;
CREATE DATABASE agenda;
use agenda;
CREATE TABLE `contatos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `sexo` char(1) NOT NULL,
  `telefone` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
);


INSERT INTO agenda.contatos (email, nome, sexo, telefone) VALUES('contato1@gmail.com', 'Contato 1', 'M', '(11) 11111-1111');
INSERT INTO agenda.contatos (email, nome, sexo, telefone) VALUES('contato2@gmail.com', 'Contato 2', 'F', '(22) 22222-22222');
INSERT INTO agenda.contatos (email, nome, sexo, telefone) VALUES('contato3@gmail.com', 'Contato 3', 'M', '(32) 33333-33333');
