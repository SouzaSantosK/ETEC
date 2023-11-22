USE bdEstoque
GO



-- 1. Criar uma função que retorne o dia de semana da venda (no formato segunda, terça, etc) ao lado do código da venda, valor total da venda e sua data.
CREATE FUNCTION fcDia_Venda(@dataVenda DATE)
RETURNS VARCHAR(40)
AS
BEGIN
	DECLARE @diaSemana VARCHAR(40)
	DECLARE @dia INT

	SET @dia = DATEPART(DW, @dataVenda)

	IF @dia = 1
		SET @diaSemana = 'Domingo'
	IF @dia = 2
		SET @diaSemana = 'Segunda'
	IF @dia = 3
		SET @diaSemana = 'Terça'
	IF @dia = 4
		SET @diaSemana = 'Quarta'
	IF @dia = 5
		SET @diaSemana = 'Quinta'
	IF @dia = 6
		SET @diaSemana = 'Sexta'
	IF @dia = 7
		SET @diaSemana = 'Sábado'

	RETURN @diaSemana
END

SELECT codVenda AS 'Código', valorTotalVenda AS 'Valor Total', CONVERT(VARCHAR(10), dataVenda, 103) AS 'Data da venda', 'Dia da venda' = dbo.fcDia_Venda(dataVenda) FROM tbVenda



-- 2. Criar uma função que receba o código do cliente e retorne o total de compras que o cliente já realizou.
CREATE FUNCTION fcTotal_Compras_Clientes(@codCliente INT)
RETURNS INT
AS
BEGIN
	DECLARE @totalCompras INT

	SELECT @totalCompras = COUNT(codCliente) FROM tbVenda WHERE @codCliente = codCliente

	RETURN @totalCompras
END

SELECT codCliente AS 'ID do cliente', 'Compras realizadas' = dbo.fcTotal_Compras_Clientes(codCliente) FROM tbVenda GROUP BY codCliente


-- ** Total de compras agrupado por nome do cliente **
SELECT nomeCliente AS 'Cliente', 'Total de compras' = dbo.fcTotal_Compras_Clientes(tbVenda.codCliente) 
	FROM tbVenda
	INNER JOIN tbCliente
	ON tbVenda.codCliente = tbCliente.codCliente
	GROUP BY nomeCliente, tbVenda.codCliente



-- 3. Criar uma função que receba o código de um vendedor e o mês e informe o total de vendas do vendedor no mês informado.
CREATE FUNCTION fcVendas_Vendedor_Mes(@codVendedor INT, @mes INT)
RETURNS INT
AS
BEGIN
    DECLARE @totalVendasMes INT

    SELECT @totalVendasMes = COUNT(@codVendedor) FROM tbVenda WHERE codVendedor = @codVendedor AND MONTH(dataVenda) = @mes

    RETURN @totalVendasMes
END

-- Não entendi muito bem se a o SELECT da função deve retornar o total de vendas apenas do vendedor passado como argumento, ou o total de vendas de cada um dos vendedores, então fiz o SELECT para os dois.
SELECT 'Total de vendas no mês' = dbo.fcVendas_Vendedor_Mes(1, 5)
SELECT codVendedor AS 'ID do vendedor', 'Total de vendas no mês' = dbo.fcVendas_Vendedor_Mes(codVendedor, 5) FROM tbVenda GROUP BY codVendedor


-- ** Total de vendas agrupado por nome do vendedor **
SELECT nomeVendedor AS 'Vendedor', 'Total de vendas no mês' = dbo.fcVendas_Vendedor_Mes(tbVendedor.codVendedor, 5) 
	FROM tbVenda
	INNER JOIN tbVendedor
	ON tbVenda.codVendedor = tbVendedor.codVendedor
	GROUP BY tbVendedor.codVendedor, nomeVendedor

	

-- 4. Criar uma função que usando o bdEstoque diga se o cpf do cliente é ou não válido.
CREATE FUNCTION fcValida_cpf(@cpf VARCHAR(11))
RETURNS CHAR(8)
AS
BEGIN
	DECLARE @index INT,
		@soma INT,
		@digito1 INT,
		@digito2 INT,
		@cpf_temporario VARCHAR(11),
		@digitos_iguais CHAR(1),
		@resultado CHAR(8)

	SET @resultado = 'Inválido'

	SET @cpf_temporario = SUBSTRING(@cpf, 1, 1)
	SET @index = 1
	SET @digitos_iguais = 'S'

	WHILE (@index <= 11)
	BEGIN
		IF SUBSTRING(@cpf, @index, 1) <> @cpf_temporario
			SET @digitos_iguais = 'N'
			SET @index = @index + 1
	END

	IF @digitos_iguais = 'N'
	BEGIN
		SET @soma = 0
		SET @index = 1
		WHILE (@index <= 9)
		BEGIN
			SET @soma = @soma + CONVERT(INT, SUBSTRING(@cpf, @index, 1)) * (11 - @index)
			SET @index = @index + 1
		END

		SET @digito1 = 11 - (@soma % 11)

		IF @digito1 > 9
			SET @digito1 = 0

		SET @soma = 0
		SET @index = 1
		WHILE (@index <= 10)
		BEGIN
			SET @soma = @soma + CONVERT(INT, SUBSTRING(@cpf, @index, 1)) * (12 - @index)
			SET @index = @index + 1
		END

		SET @digito2 = 11 - (@soma % 11)

		IF @digito2 > 9
			SET @digito2 = 0

		IF (@digito1 = SUBSTRING(@cpf, LEN(@cpf) - 1, 1)) AND (@digito2 = SUBSTRING(@cpf, LEN(@cpf), 1))
			SET @resultado = 'Válido'
	END
	RETURN @resultado
END

SELECT nomeCliente AS 'Cliente', cpfCliente AS 'CPF', 'Status' = dbo.fcValida_cpf(cpfCliente) FROM tbCliente