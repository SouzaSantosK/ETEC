--DROP DATABASE bdUniversidade

CREATE DATABASE bdUniversidade
GO

USE bdUniversidade

CREATE TABLE tbAluno(
	idAluno INT PRIMARY KEY IDENTITY(1,1),
	nomeAluno VARCHAR(35) NOT NULL,
	cpfAluno CHAR(14) NOT NULL,
	dtNascAluno DATE NOT NULL,
	telefoneAluno VARCHAR(15) NOT NULL,
	ruaAluno VARCHAR(30) NOT NULL,
	numeroResidencialAluno VARCHAR(6) NOT NULL,
	cepAluno VARCHAR(9) NOT NULL,
	bairroAluno VARCHAR(35) NOT NULL,
	cidadeAluno VARCHAR(25) NOT NULL,
)

CREATE TABLE tbCampus(
	idCampus INT PRIMARY KEY IDENTITY(1,1),
	nomeCampus VARCHAR(35) NOT NULL,
)

CREATE TABLE tbCurso(
	idCurso INT PRIMARY KEY IDENTITY(1,1),
	nomeCurso VARCHAR(35) NOT NULL,
	cargaHorariaCurso INT NOT NULL,
)

CREATE TABLE tbTurma(
	idTurma INT PRIMARY KEY IDENTITY(1,1),
	anoFormacaoTurma DATE NOT NULL,
	semestreTurma VARCHAR(25) NOT NULL,
	numSala VARCHAR(6) NOT NULL,
	idCampus INT FOREIGN KEY REFERENCES tbCampus(idCampus),
	idCurso INT FOREIGN KEY REFERENCES tbCurso(idCurso),
)

CREATE TABLE tbMatricula(
	idMatricula INT PRIMARY KEY IDENTITY(1,1),
	dtMatricula DATE NOT NULL,
	idAluno INT FOREIGN KEY REFERENCES tbAluno(idAluno),
	idTurma INT FOREIGN KEY REFERENCES tbTurma(idTurma),
)

CREATE TABLE tbProfessor(
	idProfessor INT PRIMARY KEY IDENTITY(1,1),
	nomeProfessor VARCHAR(35) NOT NULL,
	cpfProfessor CHAR(14) NOT NULL,
	dtNascProfessor DATE NOT NULL,
	telefoneProfessor VARCHAR(15) NOT NULL,
)

CREATE TABLE tbDisciplina(
	idDisciplina INT PRIMARY KEY IDENTITY(1,1),
	nomeDisciplina VARCHAR(35) NOT NULL,
	cargaHorariaDisciplina INT NOT NULL,
)

CREATE TABLE tbAtribuicao(
	idAtribuicao INT PRIMARY KEY IDENTITY(1,1),
	idProfessor INT FOREIGN KEY REFERENCES tbProfessor(idProfessor),
	idTurma INT FOREIGN KEY REFERENCES tbTurma(idTurma),
	idDisciplina INT FOREIGN KEY REFERENCES tbDisciplina(idDisciplina),
)