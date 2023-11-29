CREATE DATABASE bdAutomovel
GO

USE bdAutomovel

CREATE TABLE tbMotorista(
	codMotorista INT PRIMARY KEY IDENTITY(1, 1),
	nomeMotorista VARCHAR(40) NOT NULL,
	cpfMotorista CHAR(14) NOT NULL,
	pontuacaoAcumulada INT NOT NULL,
	situacaoMotorista VARCHAR(25) NOT NULL,
)

CREATE TABLE tbVeiculo(
	codVeiculo INT PRIMARY KEY IDENTITY(1, 1),
	placaVeiculo CHAR(17) NOT NULL,
	renavamVeiculo CHAR(11) NOT NULL,
	anoFabricacao DATE NOT NULL,
	codMotorista INT FOREIGN KEY REFERENCES tbMotorista(codMotorista)
)

CREATE TABLE tbMulta(
	codMulta INT PRIMARY KEY IDENTITY(1, 1),
	dataMulta DATE NOT NULL,
	numPontos INT NOT NULL,
	codVeiculo INT FOREIGN KEY REFERENCES tbVeiculo(codVeiculo)
)

INSERT INTO tbMotorista (nomeMotorista, cpfMotorista, pontuacaoAcumulada, situacaoMotorista)
VALUES 
	('Pedro Amaral', '987.654.321-02', 0, 'REGULAR'),
	('Roberta Souza', '123.456.789-01', 0, 'REGULAR')


INSERT INTO tbVeiculo (placaVeiculo, renavamVeiculo, anoFabricacao, codMotorista)
VALUES 
	('ABC1234', '12345678901', '2020-01-01', 1),
	('XYZ5678', '98765432102', '2019-01-01', 2)

SELECT * FROM tbMotorista
SELECT * FROM tbVeiculo
SELECT * FROM tbMulta