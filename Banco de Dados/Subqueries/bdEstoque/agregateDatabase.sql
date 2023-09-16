USE bdEstoque

-- 1) Criar uma consulta que retorne o codigo do produto, o nome do produto e o nome do fabricante somente daqueles produtos que custam igual ao valor mais alto;
SELECT codProduto AS 'ID do Produto', descricaoProduto AS 'Produto', nomeFabricante AS 'Fabricante'
	FROM tbProduto
		INNER JOIN tbFabricante
			ON tbFabricante.codFabricante = tbProduto.codFabricante
				WHERE valorProduto = (SELECT MAX(valorProduto) FROM tbProduto)

-- 2) Criar uma consulta que retorne o nome do produto e o nome do fabricante e o valor somente dos produtos que custem acima do valor medio dos produtos em estoque;
SELECT descricaoProduto AS 'Produto', valorProduto AS 'Valor', nomeFabricante AS 'Fabricante'
	FROM tbProduto
		INNER JOIN tbFabricante
			ON tbProduto.codFabricante = tbFabricante.codFabricante
				WHERE valorProduto > (SELECT AVG(valorProduto) FROM tbProduto)

-- 3) Criar uma consulta que retorne o nome dos clientes que tiveram vendas com valor acima do valor medio das vendas;
SELECT nomeCliente
	FROM tbCliente
		INNER JOIN tbVenda
			ON tbCliente.codCliente = tbVenda.codCliente
				WHERE valorTotalVenda > (SELECT AVG(valorTotalVenda) FROM tbVenda)

-- 4) Criar uma consulta que retorno o nome e o preco dos produtos mais caros;
SELECT descricaoProduto AS 'Produto', valorProduto AS 'Preco'
	FROM tbProduto
		WHERE valorProduto = (SELECT MAX(valorProduto) FROM tbProduto)

-- 5) Criar uma consulta que retorne o nome e o preco do produto mais barato;
SELECT descricaoProduto AS 'Produto', valorProduto AS 'Preco'
	FROM tbProduto
		WHERE valorProduto = (SELECT MIN(valorProduto) FROM tbProduto)	