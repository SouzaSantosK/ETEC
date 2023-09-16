--DROP DATABASE bdEscolaIdiomas

CREATE DATABASE bdEscolaIdiomas
GO

USE bdEscolaIdiomas

CREATE TABLE tbCurso(
	idCurso INT PRIMARY KEY IDENTITY(1,1)
	, nomeCurso VARCHAR(30) NOT NULL
	, cargaHorariaCurso INT NOT NULL
	, valorCurso SMALLMONEY NOT NULL
)

CREATE TABLE tbAluno(
	idAluno INT PRIMARY KEY IDENTITY(1,1)
	, nomeAluno VARCHAR(45) NOT NULL
	, dataNascAluno DATE NOT NULL
	, rgAluno VARCHAR(15) NOT NULL
	, naturalidadeAluno CHAR(2)
)

CREATE TABLE tbTurma(
	idTurma INT PRIMARY KEY IDENTITY(1,1)
	, nomeTurma CHAR(3) NOT NULL
	, horarioTurma TIME NOT NULL
	, idCurso INT FOREIGN KEY REFERENCES tbCurso(idCurso)
)

CREATE TABLE tbMatricula(
	idMatricula INT PRIMARY KEY IDENTITY(1,1)
	, dataMatricula DATE NOT NULL
	, idAluno INT FOREIGN KEY REFERENCES tbAluno(idAluno)
	, idTurma INT FOREIGN KEY REFERENCES tbTurma(idTurma)
)
