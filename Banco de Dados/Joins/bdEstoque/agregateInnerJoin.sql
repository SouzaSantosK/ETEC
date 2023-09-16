USE bdEstoque

-- A) Listar as descrições dos produtos ao lado do nome dos fabricantes;

SELECT descricaoProduto AS 'Produto', nomeFabricante AS 'fabricante'
	FROM tbProduto
		INNER JOIN tbFabricante
			ON tbProduto.codFabricante = tbFabricante.codFabricante
			
-- B) Listar as descrições dos produtos ao lado do nome dos fornecedores;

SELECT descricaoProduto AS 'Produto', nomeFornecedor AS 'Fornecedor'
	FROM tbProduto
		INNER JOIN tbFornecedor
			ON tbProduto.codFornecedor = tbFornecedor.codFornecedor

-- C) Listar a soma das quantidades dos produtos agrupadas pelo nome do fabricante;

SELECT SUM(tbProduto.qtdProduto) AS 'Soma das quantidades de produtos por Fabricante', nomeFabricante AS 'Fabricante'
	FROM tbProduto
		INNER JOIN tbFabricante
			ON tbProduto.codFabricante = tbFabricante.codFabricante
				GROUP BY tbFabricante.nomeFabricante
	
-- D) Listar o total das vendas ao lado do nome do cliente;

SELECT valorTotalVenda AS 'Total das Vendas', nomeCliente AS 'Cliente'
	FROM tbVenda
		INNER JOIN tbCliente
			ON tbVenda.codCliente= tbCliente.codCliente

-- E) Listar a média dos preços dos produtos agrupados pelo nome do fornecedor;

SELECT AVG(tbProduto.valorProduto) AS 'Média de preço dos produtos', nomeFornecedor AS 'Fornecedor'
	FROM tbProduto
		INNER JOIN tbFornecedor
			ON tbProduto.codFornecedor = tbFornecedor.codFornecedor
				GROUP BY tbFornecedor.nomeFornecedor

-- F) Listar todas a soma das vendas agrupadas pelo nome do cliente em ordem alfabética;

SELECT SUM(tbVenda.valorTotalVenda) AS 'Soma do valor total das vendas', nomeCliente AS 'Cliente'
	FROM tbVenda
		INNER JOIN tbCliente
			ON tbVenda.codCliente = tbCliente.codCliente
				GROUP BY tbCliente.nomeCliente
					ORDER BY nomeCliente

-- G) Listar a soma dos preços dos produtos agrupados pelo nome do fabricante;
	
SELECT SUM(tbProduto.valorProduto) AS 'Soma dos preços dos produtos', nomeFabricante AS 'Fabricante'
	FROM tbProduto
		INNER JOIN tbFabricante
			ON tbProduto.codFabricante = tbFabricante.codFabricante
				GROUP BY tbFabricante.nomeFabricante

-- H) Listar a média dos preços dos produtos agrupados pelo nome do fornecedor;

SELECT AVG(tbProduto.valorProduto) AS 'Valor médio do produto', nomeFornecedor AS 'Fornecedor'
	FROM tbProduto
		INNER JOIN tbFornecedor
			ON tbProduto.codFornecedor = tbFornecedor.codFornecedor
				GROUP BY nomeFornecedor

-- I) Listar a soma das vendas agrupadas pelo nome do produto;

SELECT SUM(tbItensVenda.qtdItensVenda) AS 'Quantidade de Vendas', descricaoProduto AS 'Produto'
	FROM tbItensVenda
		INNER JOIN tbProduto
			ON tbItensVenda.codProduto = tbProduto.codProduto
				GROUP BY tbProduto.descricaoProduto

-- J) Listar a soma das vendas pelo nome do cliente somente das vendas realizadas em fevereiro de 2014;

SELECT SUM(tbVenda.valorTotalVenda) AS 'Soma das vendas - 02/2014', nomeCliente AS 'Cliente'
	FROM tbVenda
		INNER JOIN tbCliente
			ON tbVenda.codCliente = tbCliente.codCliente
				WHERE YEAR(dtVenda) = 2014 AND MONTH(dtVenda) = 2
					GROUP BY tbCliente.nomeCliente