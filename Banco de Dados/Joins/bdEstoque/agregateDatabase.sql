USE bdEstoque

-- 1 A soma das quantidades dos produtos em estoque que sao do fabricante P&G
SELECT SUM(qtdProduto) AS 'Estoque prod. P&G' FROM tbProduto
	WHERE codFabricante = 2

-- 2 A media de precos dos produtos que sao da P&G
SELECT AVG(valorProduto) AS 'Preco med. prod. P&G' FROM tbProduto
	WHERE codFabricante = 2

-- 3 A soma do preco dos produtos da Unilever
SELECT SUM(valorProduto) AS 'Preco total prod. Unilever' FROM tbProduto
	WHERE codFabricante = 1

-- 4 O preco medio dos produtos da Bunge
SELECT AVG(valorProduto) AS 'Preco med prod. Bunge' FROM tbProduto
	WHERE codFabricante = 3

-- 5 A soma das quantidades de todos os produtos que sao da Bunge
SELECT SUM(qtdProduto) AS 'Estoque prod. Bunge' FROM tbProduto
	WHERE codFabricante = 3

-- 6 A quantidade media dos produtos da P&G no estoque
SELECT AVG(qtdProduto) AS 'Estoque med. prod. P&G' FROM tbProduto
	WHERE codFabricante = 2

-- 7 O preco medio dos produtos no estoque cuja quantidade seja inferior a 200
SELECT AVG(valorProduto) AS 'Preco med. prod. menor que 200 unidades' FROM tbProduto
	WHERE qtdProduto < 200

-- 8 A quantidade media de todos os produtos no estoque que sejam fabricados pela Unilever
SELECT AVG(qtdProduto) AS 'Estoque med. prod. Unilever' FROM tbProduto
	WHERE codFabricante = 1

-- 9 O valor do produto mais barato
SELECT MIN(valorProduto) AS 'Prod. mais barato' FROM tbProduto

-- 10 Quantos itens no estoque sao da Unilever
SELECT COUNT(DISTINCT codProduto) AS 'Total itens Unilever' FROM tbProduto
	WHERE codFabricante = 1

-- 11 A soma das vendas ocorridas entre fevereiro e marco de 2014
SELECT SUM(valorTotalVenda) AS 'Total Vendas Fev/Mar 2014' FROM tbVenda
	WHERE MONTH(dtVenda) BETWEEN 2 AND 3

-- 12 A soma das quantidades do produto Amaciante no estoque
SELECT SUM(qtdProduto) AS 'Qtd. estoque amaciantes' FROM tbProduto
	WHERE descricaoProduto LIKE 'Amaciante%'

-- 13 O valor do produto mais caro
SELECT MAX(valorProduto) AS 'Prod. mais caro' FROM tbProduto

-- 14 O preco medio dos produtos da Unilever
SELECT AVG(valorProduto) AS 'media precos prod. Unilever' FROM tbProduto
	WHERE codFabricante = 1

-- 15 O preco medio de todos os produtos no estoque que sejam amaciante de qualquer fabricante
SELECT AVG(valorProduto) AS 'media precos Amaciantes' FROM tbProduto
	WHERE descricaoProduto LIKE 'Amaciante%'

-- 16 A media de itens por venda
SELECT AVG(qtdItensVenda) AS 'media de Itens por Venda' FROM tbItensVenda

-- 17 Quantos itens no estoque nao sao da Unilever
SELECT COUNT(DISTINCT codProduto) AS 'Prod. nao Unilever' FROM tbProduto
	WHERE codFabricante <> 1

-- 18 A soma das quantidades dos produtos que possuam mais de 800 unidades no estoque
SELECT SUM(qtdProduto) AS 'Total estoque prod. maior que 800 unidades' FROM tbProduto
	WHERE qtdProduto > 800

-- 19 O preco medio dos produtos que possuam mais de 1000 unidades no estoque e que sejam fabricados pela Unilever
SELECT AVG(valorProduto) AS 'Preco med. prod. com mais de 1000 unidades Unilever' FROM tbProduto
	WHERE qtdProduto > 1000 AND codFabricante = 1

-- 20 A media das vendas ocorridas no ano de 2014
SELECT AVG(valorTotalVenda) AS 'Valor medio vendas 2014' FROM tbVenda
	WHERE YEAR(dtVenda) = 2014