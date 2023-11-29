-- DROP DATABASE bdEtec
CREATE DATABASE bdEtec
GO

USE bdEtec

CREATE TABLE tb2A(
	rmAluno INT PRIMARY KEY IDENTITY(1, 2),
	nomeAluno VARCHAR(30) NOT NULL,
	statusAluno VARCHAR(10) NOT NULL
)

CREATE TABLE tb2B(
	rmAluno INT PRIMARY KEY IDENTITY(2, 2),
	nomeAluno VARCHAR(30) NOT NULL,
	statusAluno VARCHAR(10) NOT NULL
)

CREATE TABLE tb3(
	rmAluno INT PRIMARY KEY NOT NULL,
	nomeAluno VARCHAR(30) NOT NULL,
	statusAluno VARCHAR(10) NOT NULL
)

INSERT INTO tb2A (nomeAluno, statusAluno)
VALUES
('Ana', 'APROVADO'),
('João', 'APROVADO'),
('Maria', 'APROVADO'),
('Pedro', 'REPROVADO'),
('Juliana', 'APROVADO'),
('Lucas', 'REPROVADO'),
('Beatriz', 'APROVADO'),
('Guilherme', 'APROVADO'),
('Camila', 'APROVADO'),
('Matheus', 'REPROVADO');

INSERT INTO tb2B (nomeAluno, statusAluno)
VALUES
('Larissa', 'APROVADO'),
('Gabriel', 'REPROVADO'),
('Isabela', 'APROVADO'),
('Felipe', 'APROVADO'),
('Amanda', 'APROVADO'),
('Thiago', 'REPROVADO'),
('Luana', 'APROVADO'),
('Rafael', 'REPROVADO'),
('Mariana', 'APROVADO'),
('Carlos', 'APROVADO');

SELECT * FROM tb2A
SELECT * FROM tb2B