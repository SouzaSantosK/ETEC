USE bdEstoque

-- 2) Fazer uma consulta utilizando o nome do fornecedor e a descricao dos produtos que cada fornecedor fornece;
SELECT nomeFornecedor AS 'Fornecedor', descricaoProduto  AS 'Produto'
	FROM tbFornecedor
		INNER JOIN tbProduto
			ON tbFornecedor.codFornecedor = tbProduto.codFornecedor

-- 3) Criar uma instrucao utilizando left join e outra utilizando right join para exibir todos os fornecedores, incluindo ainda os tres novos fornecedores para os quais nao foram registrados novos produtos;

SELECT nomeFornecedor AS 'Fornecedor', descricaoProduto AS 'Produto'
	FROM tbFornecedor
		LEFT JOIN tbProduto
			ON tbFornecedor.codFornecedor = tbProduto.codFornecedor

SELECT descricaoProduto AS 'Produto', nomeFornecedor AS 'Fornecedor'
	FROM tbProduto
		RIGHT JOIN tbFornecedor
			ON tbProduto.codFornecedor = tbFornecedor.codFornecedor

-- 5) Criar um select utilizando a instrucao full join exibindo assim todos os fornecedores, inclusive aqueles para os quais nao foram atribuidos produtos, e aqueles produtos para os quais nao foram atribuidos fornecedores;

SELECT nomeFornecedor AS 'Fornecedor', descricaoProduto AS 'Produto'
	FROM tbFornecedor
		FULL JOIN tbProduto
			ON tbFornecedor.codFornecedor = tbProduto.codFornecedor

-- 6) Criar um select com a instrucao cross join entre fornecedor e produto. Quantos registros a consulta retornou? O que aconteceu?
-- R: Varios (78); Cada fornecedor agora fornece todos os produtos existentes no Banco de Dados

SELECT nomeFornecedor AS 'Fornecedor', descricaoProduto AS 'Produto'
	FROM tbFornecedor
		CROSS JOIN tbProduto
			GROUP BY descricaoProduto