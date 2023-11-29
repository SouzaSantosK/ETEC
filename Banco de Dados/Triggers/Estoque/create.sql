--DROP DATABASE bdEstoque
CREATE DATABASE bdEstoque
GO

USE bdEstoque

CREATE TABLE tbCliente(
	codCliente INT PRIMARY KEY IDENTITY(1, 1)
	, nomeCliente VARCHAR(30) NOT NULL
	, cpfCliente CHAR(14) NOT NULL
	, emailCliente VARCHAR(50) NOT NULL
	, sexoCliente CHAR(1) NOT NULL
	, dtNascCliente DATE DEFAULT CONVERT(VARCHAR(10), GETDATE(), 103)
)

CREATE TABLE tbFabricante(
	codFabricante INT PRIMARY KEY IDENTITY(1, 1)
	, nomeFabricante VARCHAR(30) NOT NULL
)

CREATE TABLE tbFornecedor(
	codFornecedor INT PRIMARY KEY IDENTITY(1, 1)
	, nomeFornecedor VARCHAR(30) NOT NULL
	, contatoFornecedor VARCHAR(30) NOT NULL
)

CREATE TABLE tbVenda(
	codVenda INT PRIMARY KEY IDENTITY(1, 1)
	, dtVenda CHAR(10) NOT NULL
	, valorTotalVenda SMALLMONEY NOT NULL
	, codCliente INT FOREIGN KEY REFERENCES tbCliente(codCliente)
)

CREATE TABLE tbProduto(
	codProduto INT PRIMARY KEY IDENTITY(1, 1)
	, descricaoProduto VARCHAR(35) NOT NULL
	, valorProduto SMALLMONEY NOT NULL
	, qtdProduto INT NOT NULL
	, codFabricante INT FOREIGN KEY REFERENCES tbFabricante(codFabricante)
	, codFornecedor INT FOREIGN KEY REFERENCES tbFornecedor(codFornecedor)
)

CREATE TABLE tbItensVenda(
	codItensVenda INT PRIMARY KEY IDENTITY(1, 1)
	, qtdItensVenda INT NOT NULL
	, subTotalItensVenda SMALLMONEY NOT NULL
	, codVenda INT FOREIGN KEY REFERENCES tbVenda(codVenda)
	, codProduto INT FOREIGN KEY REFERENCES tbProduto(codProduto)
)

CREATE TABLE tbSaidaProduto(
	codSaidaProduto INT PRIMARY KEY IDENTITY(1, 1),
	dataSaidaProduto DATE DEFAULT CONVERT(VARCHAR(10), GETDATE(), 103),
	qtdSaidaProduto INT NOT NULL,
	codProduto INT FOREIGN KEY REFERENCES tbProduto(codProduto)
)

CREATE TABLE tbEntradaProduto(
	codEntradaProduto INT PRIMARY KEY IDENTITY(1, 1),
	dataEntradaProduto DATE DEFAULT CONVERT(VARCHAR(10), GETDATE(), 103),
	qtdEntradaProduto INT NOT NULL,
	codProduto INT FOREIGN KEY REFERENCES tbProduto(codProduto)
)

SELECT * FROM tbCliente;
SELECT * FROM tbFabricante;
SELECT * FROM tbFornecedor;
SELECT * FROM tbVenda;
SELECT * FROM tbProduto;
SELECT * FROM tbItensVenda;
SELECT * FROM tbSaidaProduto;
SELECT * FROM tbEntradaProduto;