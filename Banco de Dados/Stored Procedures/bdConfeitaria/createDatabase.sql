-- DROP DATABASE bdConfeitaria

CREATE DATABASE bdConfeitaria
GO

USE bdConfeitaria

CREATE TABLE tbCategoriaProduto(
	idCategoriaProduto INT PRIMARY KEY IDENTITY(1,1),
	nomeCategoriaProduto VARCHAR(30) NOT NULL
)

CREATE TABLE tbProduto(
	idProduto INT PRIMARY KEY IDENTITY(1,1),
	nomeProduto VARCHAR(35) NOT NULL,
	precoKiloProduto SMALLMONEY NOT NULL,
	idCategoriaProduto INT FOREIGN KEY REFERENCES tbCategoriaProduto(idCategoriaProduto)
)

CREATE TABLE tbCliente(
	idCliente INT PRIMARY KEY IDENTITY(1,1),
	nomeCliente VARCHAR(35) NOT NULL,
	dataNascimentoCliente DATE NOT NULL,
	ruaCliente VARCHAR(30) NOT NULL,
	numCasaCliente VARCHAR(10) NOT NULL,
	cepCliente VARCHAR(10) NOT NULL,
	bairroCliente VARCHAR(30) NOT NULL,
	cidadeCliente VARCHAR(30) NOT NULL,
	estadoCliente VARCHAR(30) NOT NULL,
	cpfCliente CHAR(14) NOT NULL,
	sexoCliente CHAR(1) NOT NULL,
)

CREATE TABLE tbEncomenda(
	idEncomenda INT PRIMARY KEY IDENTITY(1,1),
	dataEncomenda DATE NOT NULL,
	valorTotalEncomenda SMALLMONEY NOT NULL,
	dataEntregaEncomenda DATE NOT NULL,
	idCliente INT FOREIGN KEY REFERENCES tbCliente(idCliente)
)

CREATE TABLE tbItensEncomenda(
	idItemEncomenda INT PRIMARY KEY IDENTITY(1,1),
	quantidadeKilos DECIMAL NOT NULL,
	subTotal SMALLMONEY NOT NULL,
	idProduto INT FOREIGN KEY REFERENCES tbProduto(idProduto),
	idEncomenda INT FOREIGN KEY REFERENCES tbEncomenda(idEncomenda)
)

SELECT * FROM tbCategoriaProduto
SELECT * FROM tbCliente
SELECT * FROM tbEncomenda
SELECT * FROM tbItensEncomenda
SELECT * FROM tbProduto