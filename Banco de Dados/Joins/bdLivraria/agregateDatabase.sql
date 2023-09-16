USE bdLivrariaBrasileira

-- a) O total de livros que comecam com a letra P;
SELECT COUNT(codLivro) AS 'Livros iniciados com P'
	FROM tbLivro
		WHERE nomeLivro LIKE 'P%'

-- b) O maior numero de paginas entre todos os livros;
SELECT MAX(numPaginas) AS 'Maior numero de paginas'
	FROM tbLivro

-- c) O menor numero de paginas entre todos os livros;
SELECT MIN(numPaginas) AS 'Menor numero de paginas'
	FROM tbLivro

-- d) A media de paginas entre todos os livros;
SELECT AVG(numPaginas) AS 'Media de paginas de todos os livros'
	FROM tbLivro

-- e) A soma do numero de paginas dos livros de editora codigo 1;
SELECT SUM(numPaginas) AS 'Soma do numero de paginas da Melhoramentos'
	FROM tbLivro
		WHERE codEditora = 1

-- f) A soma dos numeros de paginas dos livros que comecao com a letra A;
SELECT SUM(numPaginas) AS 'Soma do numero de paginas'
	FROM tbLivro
		WHERE nomeLivro LIKE 'A%'

-- g) A media dos numeros de paginas dos livros que sejam do autor codigo 03;
SELECT AVG(numPaginas) AS 'Media do numero de paginas da Autora J.K. Rowling'
	FROM tbLivro
		WHERE codAutor = 3

-- h) A quantidade de livros da editora de codigo 04;
SELECT COUNT(codLivro) AS 'Qtd. livros da Companhia das Letras'
	FROM tbLivro
		WHERE codEditora = 4

-- i) A media do numero de paginas dos livros que tenham a palavra estrela em seu nome;
SELECT AVG(numPaginas) AS 'Media de paginas de livros com "estrela" no nome'
	FROM tbLivro
		WHERE nomeLivro LIKE '%estrela%'

-- j) A quantidade de livros que tenham a palavra poema em seu nome;
SELECT COUNT(codLivro) AS 'Qtd. livros com "poema" no nome'
	FROM tbLivro
		WHERE nomeLivro LIKE '%poema%'

-- k) A quantidade de livros agrupado pelo nome do genero;
SELECT COUNT(codLivro) AS 'Quantidade de Livros', nomeGenero AS 'Genero'
	FROM tbLivro
		INNER JOIN tbGenero
			ON tbLivro.codGenero = tbGenero.codGenero
				GROUP BY nomeGenero

-- l) A soma das paginas agrupada pelo nome do autor;
SELECT SUM(numPaginas) AS 'Quantidade de paginas', nomeAutor AS 'Autor'
	FROM tbLivro
		INNER JOIN tbAutor
			ON tbLivro.codAutor = tbAutor.codAutor
				GROUP BY nomeAutor

-- m) A media de paginas agrupada pelo nome do autor em ordem alfabetica (de A a Z);
SELECT AVG(numPaginas) AS 'Media de paginas', nomeAutor AS 'Autor'
	FROM tbLivro
		INNER JOIN tbAutor
			ON tbLivro.codAutor = tbAutor.codAutor
				GROUP BY nomeAutor
					ORDER BY nomeAutor

-- n) A quantidade de livros agrupada pelo nome da editora em ordem alfabetica inversa (de Z a A);
SELECT COUNT(codLivro) AS 'Quantidade de Livros', nomeEditora AS 'Editora'
	FROM tbLivro
		INNER JOIN tbEditora
			ON tbLivro.codEditora = tbEditora.codEditora
				GROUP BY nomeEditora
					ORDER BY nomeEditora DESC

-- o) A soma de paginas dos livros agrupados pelo nome do autor que sejam de autores cujo nome comece com a letra C;
SELECT SUM(numPaginas) AS 'Soma das paginas', nomeAutor AS 'Autor'
	FROM tbLivro
		INNER JOIN tbAutor
			ON tbLivro.codAutor = tbAutor.codAutor
				WHERE nomeAutor LIKE 'C%'
					GROUP BY nomeAutor

-- p) A quantidade de livros agrupados pelo nome do autor, cujo nome do autor seja Machado de Assis ou Cora Coralina ou Graciliano Ramos ou Clarice Lispector;
SELECT COUNT(codLivro) AS 'Quantidade de Livros', nomeAutor AS 'Autor'
	FROM tbLivro
		INNER JOIN tbAutor
			ON tbLivro.codAutor = tbAutor.codAutor
				WHERE nomeAutor = 'Machado de Assis' OR nomeAutor = 'Cora Coralina' OR nomeAutor = 'Graciliano Ramos' OR nomeAutor = 'Clarice Lispector'
					GROUP BY nomeAutor

-- q) A soma das paginas dos livros agrupadas pelo nome da editora cujo numero de paginas esteja entre 200 e 500 (inclusive);
SELECT SUM(numPaginas) AS 'Soma das paginas', nomeEditora AS 'Editora'
	FROM tbLivro
		INNER JOIN tbEditora
			ON tbLivro.codEditora = tbEditora.codEditora
				WHERE numPaginas BETWEEN 200 AND 500
					GROUP BY nomeEditora

-- r) O nome dos livros ao lado do nome das editoras e do nome dos autores;
SELECT nomeLivro AS 'Livro', nomeEditora AS 'Editora',  nomeAutor AS 'Autor'
	FROM tbLivro
		INNER JOIN tbEditora
			ON tbLivro.codEditora = tbEditora.codEditora
				INNER JOIN tbAutor
					ON tbLivro.codAutor = tbAutor.codAutor

-- s) O nome dos livros ao lado do nome do autor somente daqueles cujo nome da editora for Cia das Letras;
SELECT nomeLivro AS 'Livro',  nomeAutor AS 'Autor'
	FROM tbLivro
		INNER JOIN tbAutor
			ON tbLivro.codAutor = tbAutor.codAutor
				INNER JOIN tbEditora
					ON tbLivro.codEditora = tbEditora.codEditora
						WHERE nomeEditora = 'Cia das Letras'

-- t) O nome dos livros ao lado dos nomes dos autores, somente dos livros que nao forem do autor Erico Verissimo;
SELECT nomeLivro AS 'Livro',  nomeAutor AS 'Autor'
	FROM tbLivro
		INNER JOIN tbAutor
			ON tbLivro.codAutor = tbAutor.codAutor
				WHERE nomeAutor NOT LIKE 'Erico Verissimo'

-- u) Os nomes dos autores ao lado dos nomes dos livros, inclusive daqueles que nao tem livros cadastrados;
SELECT nomeAutor AS 'Autor', nomeLivro AS 'Livro'
	FROM tbAutor
		LEFT JOIN tbLivro
			ON tbAutor.codAutor = tbLivro.codAutor

-- v) Os nomes dos autores ao lado dos nomes dos livros, inclusive daqueles que nao tem autores cadastrados;
SELECT nomeAutor AS 'Autor', nomeLivro AS 'Livro'
	FROM tbAutor
		RIGHT JOIN tbLivro
			ON tbAutor.codAutor = tbLivro.codAutor
				
-- w) O nome dos autores ao lado dos nomes dos livros, indiferente do autor ter ou nao livro publicado, e indiferente do livro pertencer a algum autor;
SELECT nomeAutor AS 'Autor', nomeLivro AS 'Livro'
	FROM tbAutor
		FULL JOIN tbLivro
			ON tbAutor.codAutor = tbLivro.codAutor

-- x) A editora etica ira publicar todos os titulos dessa livraria. Criar um select que associe os nomes de todos os livros ao lado do nome da editora etica;
SELECT nomeLivro AS 'Livro', nomeEditora AS 'Editora'
	FROM tbLivro
		CROSS JOIN tbEditora
			WHERE nomeEditora = 'Etica'

-- y) Somente os nomes dos autores que nao tem livros cadastrados;
SELECT nomeAutor AS 'Autor'
	FROM tbAutor
		LEFT JOIN tbLivro
			ON tbAutor.codAutor = tbLivro.codAutor
				WHERE nomeLivro IS NULL

-- z) Os nomes dos generos que nao possuem nenhum livro cadastrado;
SELECT nomeGenero AS 'Genero'
	FROM tbGenero
		LEFT JOIN tbLivro
			ON tbGenero.codGenero = tbLivro.codGenero
				WHERE nomeLivro IS NULL