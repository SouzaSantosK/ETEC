USE bdLivrariaBrasileira

INSERT INTO tbAutor(nomeAutor)
VALUES
	('Chico Buarque')
	,	('Jorge Amado')
	,	('J.K. Rowling')
	,	('William Shakespeare')
	,	('Monteiro Lobato')
	,	('Cora Coralina')
	,	('Clarice Lispector')

INSERT INTO tbEditora(nomeEditora)
VALUES
	('Melhoramentos')
	,	('Globo')
	,	('Etica')
	,	('Companhia das Letras')
	,	('Abril')

INSERT INTO tbGenero(nomeGenero)
VALUES
	('Ficcao')
	,	('Romance')
	,	('Tragedia')

INSERT INTO tbLivro(nomeLivro, numPaginas, codGenero, codEditora, codAutor)
VALUES
	('Budapeste', 176, 2, 4, 1),
	('O Bicho-da-Seda', 454, 2, 5, 3),
	('Gabriela, Cravo e Canela', 214, 1, 2, 2),
	('Reinacoes de Narizinho', 143, 2, 2, 5),
	('Romeu e Julieta', 421, 1, 3, 4),
	('O Irmao Alemao', 478, 1, 4, 1),
	('Terras do Sem-Fim', 125, 1, 3, 2),
	('Animais Fantasticos e Onde Habitam', 267, 2, 4, 3)
	
/*
SELECT * FROM tbAutor
SELECT * FROM tbEditora
SELECT * FROM tbGenero
SELECT * FROM tbLivro
*/