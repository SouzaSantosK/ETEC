USE bdEstoque

/*
	A) Criar um trigger que, ao ser feita uma venda (Insert na tabela
	tbItensVenda), todos os produtos vendidos tenham sua quantidade
	atualizada na tabela tbProduto. Exemplo, se foi feita uma venda de 5
	unidades do produto código 01, na tabela tbProduto a quantidade desse
	produto será a quantidade atual – 5;
*/

CREATE TRIGGER tgAtualizaQtdProdutos
	ON tbItensVenda AFTER INSERT
	AS
		DECLARE @codProduto INT, @qtdItensVendidos INT
		SET @codProduto = (SELECT codProduto FROM INSERTED)
		SELECT @qtdItensVendidos = qtdItensVenda FROM INSERTED
		UPDATE tbProduto
			SET qtdProduto = qtdProduto - @qtdItensVendidos
				WHERE codProduto = @codProduto

INSERT INTO tbItensVenda(codVenda, codProduto, qtdItensVenda, subTotalItensVenda)
VALUES
	(9, 4, 1000, 4000.00)

SELECT * FROM tbProduto
SELECT * FROM tbItensVenda

/*
	B) - Criar uma trigger que, quando for inserida uma nova entrada de produtos
	na tbEntradaProduto, a quantidade desse produto seja atualizada e
	aumentada na tabela tbProduto;
*/


CREATE TRIGGER tgAtualizaEntradaProdutos
	ON tbEntradaProduto AFTER INSERT
	AS
	DECLARE @codProduto INT, @qtdEntradaProduto INT
	SET @codProduto = (SELECT codProduto FROM INSERTED)
	SELECT @qtdEntradaProduto = qtdEntradaProduto FROM INSERTED
	UPDATE tbProduto
		SET qtdProduto = qtdProduto + @qtdEntradaProduto
			WHERE codProduto = @codProduto

INSERT INTO tbEntradaProduto(dataEntradaProduto, qtdEntradaProduto, codProduto)
VALUES
	(GETDATE(), 500, 1)

SELECT * FROM tbProduto
SELECT * FROM tbEntradaProduto

/*
	C) - Criar uma trigger que, quando for feita uma venda de um determinado
	produto, seja feito um Insert na tbSaidaProduto.
*/

CREATE TRIGGER tgAtualizaSaidaProdutos
	ON tbItensVenda AFTER INSERT
	AS
	DECLARE @dataSaidaProduto DATE, @codProduto INT, @qtdSaidaProduto INT
	SET @dataSaidaProduto = CONVERT(VARCHAR(10), GETDATE(), 103)
	SET @codProduto = (SELECT codProduto FROM INSERTED)
	SELECT @qtdSaidaProduto = qtdItensVenda FROM INSERTED
	INSERT INTO tbSaidaProduto
	VALUES
		(@dataSaidaProduto, @qtdSaidaProduto, @codProduto)

INSERT INTO tbItensVenda(codVenda, codProduto, qtdItensVenda, subTotalItensVenda)
VALUES
	(3, 9, 350, 2500.00)

SELECT * FROM tbItensVenda
SELECT * FROM tbSaidaProduto