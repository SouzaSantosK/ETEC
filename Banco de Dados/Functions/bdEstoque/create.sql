--DROP DATABASE bdEstoque
CREATE DATABASE bdEstoque
GO

USE bdEstoque

CREATE TABLE tbCliente(
	codCliente INT PRIMARY KEY IDENTITY(1,1)
	, nomeCliente VARCHAR(30) NOT NULL
	, cpfCliente CHAR(14) NOT NULL
	, emailCliente VARCHAR(50) NOT NULL
	, sexoCliente CHAR(1) NOT NULL
	, dtNascCliente SMALLDATETIME NOT NULL
)

CREATE TABLE tbFabricante(
	codFabricante INT PRIMARY KEY IDENTITY(1,1)
	, nomeFabricante VARCHAR(30) NOT NULL
)

CREATE TABLE tbFornecedor(
	codFornecedor INT PRIMARY KEY IDENTITY(1,1)
	, nomeFornecedor VARCHAR(30) NOT NULL
	, contatoFornecedor VARCHAR(30) NOT NULL
)

CREATE TABLE tbVendedor(
	codVendedor INT PRIMARY KEY IDENTITY(1,1)
	, nomeVendedor VARCHAR(30),
)

CREATE TABLE tbVenda(
	codVenda INT PRIMARY KEY IDENTITY(1,1)
	, dataVenda DATE NOT NULL
	, valorTotalVenda SMALLMONEY NOT NULL
	, codCliente INT FOREIGN KEY REFERENCES tbCliente(codCliente)
	, codVendedor INT FOREIGN KEY REFERENCES tbVendedor(codVendedor)
)

CREATE TABLE tbProduto(
	codProduto INT PRIMARY KEY IDENTITY(1,1)
	, descricaoProduto VARCHAR(35) NOT NULL
	, valorProduto SMALLMONEY NOT NULL
	, qtdProduto INT NOT NULL
	, codFabricante INT FOREIGN KEY REFERENCES tbFabricante(codFabricante)
	, codFornecedor INT FOREIGN KEY REFERENCES tbFornecedor(codFornecedor)
)

CREATE TABLE tbItensVenda(
	codItensVenda INT PRIMARY KEY IDENTITY(1,1)
	, codVenda INT FOREIGN KEY REFERENCES tbVenda(codVenda)
	, codProduto INT FOREIGN KEY REFERENCES tbProduto(codProduto)
	, qtdItensVenda INT NOT NULL
	, subTotalItensVenda SMALLMONEY NOT NULL
)
