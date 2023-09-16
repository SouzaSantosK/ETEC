--DROP DATABASE bdOng

CREATE DATABASE bdOng
GO

USE bdOng

CREATE TABLE tbStatus(
	idStatus INT PRIMARY KEY IDENTITY(1,1)
	, descStatus VARCHAR(20) NOT NULL
)

CREATE TABLE tbSexo(
	idSexo INT PRIMARY KEY IDENTITY(1,1)
	, descSexo VARCHAR(20) NOT NULL
)

CREATE TABLE tbResponsavel(
	idResponsavel INT PRIMARY KEY IDENTITY(1,1)
	, nomeResponsavel VARCHAR(40) NOT NULL
	, cpfResponsavel CHAR(11) NOT NULL
)

CREATE TABLE tbCrianca(
	idCrianca INT PRIMARY KEY IDENTITY(1,1)
	, nomeCrianca VARCHAR(40) NOT NULL
	, dtNascCrianca DATE NOT NULL
	, idStatus INT FOREIGN KEY REFERENCES tbStatus(idStatus)
	, idSexo INT FOREIGN KEY REFERENCES tbSexo(idSexo)
)

CREATE TABLE tbFiliacao(
	idFiliacao INT PRIMARY KEY IDENTITY(1,1)
	, dtFiliacao DATE NOT NULL
	, idResponsavel INT FOREIGN KEY REFERENCES tbResponsavel(idResponsavel)
	, idCrianca INT FOREIGN KEY REFERENCES tbCrianca(idCrianca)
)

CREATE TABLE tbHistorico(
	idHistorico INT PRIMARY KEY IDENTITY(1,1)
	, dtHistorico DATE NOT NULL
	, idCrianca INT FOREIGN KEY REFERENCES tbCrianca(idCrianca)
)

CREATE TABLE tbPadrinho(
	idPadrinho INT PRIMARY KEY IDENTITY(1,1)
	, nomePadrinho VARCHAR(40) NOT NULL
	, cpfPadrinho CHAR(11) NOT NULL
)

CREATE TABLE tbApadrinhamento(
	idApadrinhamento INT PRIMARY KEY IDENTITY(1,1)
	, dtApadrinhamento DATE NOT NULL
	, idCrianca INT FOREIGN KEY REFERENCES tbCrianca(idCrianca)
	, idPadrinho INT FOREIGN KEY REFERENCES tbPadrinho(idPadrinho)
)

CREATE TABLE tbDoenca(
	idDoenca INT PRIMARY KEY IDENTITY(1,1)
	, nomeDoenca VARCHAR(40) NOT NULL
	, cidDoenca VARCHAR(30) NOT NULL
)

CREATE TABLE tbProntuario(
	idProntuario INT PRIMARY KEY IDENTITY(1,1)
	, dtProntuario DATE NOT NULL
	, idCrianca INT FOREIGN KEY REFERENCES tbCrianca(idCrianca)
	, idDoenca INT FOREIGN KEY REFERENCES tbDoenca(idDoenca)
)