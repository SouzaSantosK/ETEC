USE bdEscolaIdiomas

-- 1) Apresentar os nomes dos alunos ao lado do nome dos cursos que eles fazem;
SELECT tbAluno.nomeAluno AS 'Aluno', nomeCurso AS 'Curso'
	FROM tbAluno
		INNER JOIN tbMatricula
			ON tbAluno.idAluno = tbMatricula.idAluno
				INNER JOIN tbTurma
					ON tbMatricula.idTurma = tbTurma.idTurma
						INNER JOIN tbCurso
							ON tbTurma.idCurso = tbCurso.idCurso
				
-- 2) Apresentar a quantidade de alunos matriculados por nome do curso;
SELECT COUNT(tbAluno.nomeAluno) AS 'Qtd. Alunos', nomeCurso AS 'Curso'
	FROM tbAluno
		INNER JOIN tbMatricula
			ON tbAluno.idAluno = tbMatricula.idAluno
				INNER JOIN tbTurma
					ON tbMatricula.idTurma = tbTurma.idTurma
						INNER JOIN tbCurso
							ON tbTurma.idCurso = tbCurso.idCurso
								GROUP BY nomeCurso

-- 3) Apresentar a quantidade de alunos matriculados por nome da turma;
SELECT COUNT(tbAluno.nomeAluno) AS 'Qtd. Alunos', nomeTurma AS 'Turma'
	FROM tbAluno
		INNER JOIN tbMatricula
			ON tbAluno.idAluno = tbMatricula.idAluno
				INNER JOIN tbTurma
					ON tbMatricula.idTurma = tbTurma.idTurma
						GROUP BY nomeTurma

-- 4) Apresentar a quantidade de alunos que fizeram matricula em maio de 2016;
SELECT COUNT(tbAluno.nomeAluno) AS 'Qtd. Alunos matriculados em 05/2016', dataMatricula AS 'Data Matricula'
	FROM tbAluno
		INNER JOIN tbMatricula
			ON tbAluno.idAluno = tbMatricula.idAluno
				WHERE MONTH(dataMatricula) = 5 AND YEAR(dataMatricula) = 2016
					GROUP BY dataMatricula

-- 5) Apresentar o nome dos alunos em ordem alfabetica ao lado do nome das turmas e os nomes dos cursos em que estao matriculados;
SELECT tbAluno.nomeAluno AS 'Aluno', nomeTurma AS 'Turma', nomeCurso AS 'Curso'
	FROM tbAluno
		INNER JOIN tbMatricula
			ON tbAluno.idAluno = tbMatricula.idAluno
				INNER JOIN tbTurma
					ON tbMatricula.idTurma = tbTurma.idTurma
						INNER JOIN tbCurso
							ON tbTurma.idCurso = tbCurso.idCurso
								ORDER BY nomeAluno

-- 6) Apresentar o nome dos cursos e os horarios em que eles sao oferecidos;
SELECT tbCurso.nomeCurso AS 'Curso'
	, CONVERT(VARCHAR(8), horarioTurma, 114) AS 'Horarios Turmas'
		FROM tbCurso
			INNER JOIN tbTurma
				ON tbCurso.idCurso = tbTurma.idCurso
					ORDER BY nomeCurso

-- 7) Apresentar a quantidade de alunos nascidos por estado que estejam matriculados no curso de ingles;
SELECT COUNT(tbAluno.nomeAluno) AS 'Qtd. alunos no Curso de Ingles', naturalidadeAluno AS 'Naturalidade'
	FROM tbAluno
		INNER JOIN tbMatricula
			ON tbAluno.idAluno = tbMatricula.idAluno
				INNER JOIN tbTurma
					ON tbMatricula.idTurma = tbTurma.idTurma
						INNER JOIN tbCurso
							ON tbTurma.idCurso = tbCurso.idCurso
								WHERE nomeCurso = 'Ingles'
									GROUP BY naturalidadeAluno

-- 8) Apresentar o nome dos alunos ao lado da data de matricula no formato dd/mm/aaaa;
SELECT tbAluno.nomeAluno AS 'Aluno', CONVERT(VARCHAR(10), dataMatricula, 103) AS 'Data da Matricula'
	FROM tbAluno
		INNER JOIN tbMatricula
			ON tbAluno.idAluno = tbMatricula.idMatricula

-- 9) Apresentar os alunos cujo nome comece com A e que estejam matriculados no curso de Ingles;
SELECT tbAluno.nomeAluno AS 'Aluno'
	FROM tbAluno
		INNER JOIN tbMatricula
			ON tbAluno.idAluno = tbMatricula.idMatricula
				INNER JOIN tbTurma
					ON tbMatricula.idTurma = tbTurma.idTurma
						INNER JOIN tbCurso
							ON tbTurma.idCurso = tbCurso.idCurso
								WHERE nomeAluno LIKE 'A%' AND nomeCurso = 'Ingles'

-- 10) Apresentar a quantidade de matriculas feitas no ano de 2016;
SELECT COUNT(tbMatricula.idMatricula) AS 'Qtd. Matriculas 2016'
	FROM tbMatricula
		WHERE YEAR(dataMatricula) = 2016

-- 11) Apresentar a quantidade de matriculas por nome do curso;
SELECT COUNT(tbMatricula.idMatricula) AS 'Qtd Matriculas', nomeCurso AS 'Curso'
	FROM tbMatricula
		INNER JOIN tbTurma
			ON tbMatricula.idTurma = tbTurma.idTurma
				INNER JOIN tbCurso
					ON tbTurma.idCurso = tbCurso.idCurso
						GROUP BY nomeCurso

-- 12) Apresentar a quantidade de alunos que fazem os cursos que custam mais de R$ 300,00;
SELECT COUNT(tbAluno.idAluno) AS 'Qtd. Alunos'
	FROM tbAluno
		INNER JOIN tbMatricula
			ON tbAluno.idAluno = tbMatricula.idMatricula
				INNER JOIN tbTurma
					ON tbMatricula.idTurma = tbTurma.idTurma
						INNER JOIN tbCurso
							ON tbTurma.idCurso = tbCurso.idCurso
								WHERE valorCurso >= 300

-- 13) Apresentar os nomes dos alunos que fazem o curso de alemao;
SELECT tbAluno.nomeAluno AS 'Aluno'
	FROM tbAluno
		INNER JOIN tbMatricula
			ON tbAluno.idAluno = tbMatricula.idMatricula
				INNER JOIN tbTurma
					ON tbMatricula.idTurma = tbTurma.idTurma
						INNER JOIN tbCurso
							ON tbTurma.idCurso = tbCurso.idCurso
								WHERE nomeCurso = 'Alemao'