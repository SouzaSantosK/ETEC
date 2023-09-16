USE bdEscolaIdiomas

-- 1) Crie uma view vwPreco_Baixo que exiba o código, nome do curso, carga horaria
-- e o valor do curso de todos os cursos que tenha preco inferior ao preco medio.
CREATE VIEW vwPreco_Baixo AS 
	SELECT idCurso AS 'Cod. Curso', nomeCurso AS 'Curso', cargaHorariaCurso AS 'Carga Horaria', valorCurso AS 'Valor'
		FROM tbCurso
			WHERE valorCurso < (SELECT AVG(valorCurso) FROM tbCurso)

SELECT * FROM vwPreco_Baixo

-- 2) Usando a view vwPreco_Baixo, mostre todos os cursos ordenados por carga horaria.
SELECT * FROM vwPreco_Baixo
	ORDER BY [Carga Hor�ria]

-- 3) Crie uma view vwAlunos_Turma que exiba o curso e a quantidade de alunos por turma.
CREATE VIEW vwAlunos_Turma AS
	SELECT nomeTurma AS 'Turma', COUNT(idAluno) AS 'Qtd. Alunos', nomeCurso AS 'Curso'
		FROM tbTurma
			INNER JOIN tbCurso
				ON tbTurma.idCurso = tbCurso.idCurso
					INNER JOIN tbMatricula
						ON tbTurma.idTurma = tbMatricula.idTurma
							GROUP BY nomeTurma, nomeCurso

SELECT * FROM vwAlunos_Turma

-- 4) Usando a view vwAlunos_Turma exiba a turma com maior numero de alunos.
SELECT * FROM  vwAlunos_Turma
	WHERE [Qtd. Alunos] = (SELECT MAX([Qtd. Alunos]) FROM vwAlunos_Turma)

-- 5) Crie uma view vwTurma_Curso que exiba o curso e a quantidade de turmas.
CREATE VIEW vwTurma_Curso AS
	SELECT nomeCurso AS 'Curso', COUNT(idTurma) AS 'Qtd. Turmas'
		FROM tbCurso
			INNER JOIN tbTurma
				ON tbCurso.idCurso = tbTurma.idCurso
					GROUP BY nomeCurso

SELECT * FROM vwTurma_Curso

-- 6) Usando a view vwTurma_Curso exiba o curso com menor numero de turmas.
SELECT * FROM  vwTurma_Curso
	WHERE [Qtd. Turmas] = (SELECT MIN([Qtd. Turmas]) FROM vwTurma_Curso)

