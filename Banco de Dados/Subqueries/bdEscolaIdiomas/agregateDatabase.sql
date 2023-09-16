USE bdEscolaIdiomas

-- a) Criar uma consulta que retorne o nome e o preco dos cursos que custem abaixo do valor medio
SELECT nomeCurso AS 'Curso', valorCurso AS 'Valor'
	FROM tbCurso
		WHERE valorCurso < (SELECT AVG(valorCurso) FROM tbCurso)

-- b) Criar uma consulta que retorne o nome e o rg do aluno mais novo;
SELECT nomeAluno AS 'Aluno', rgAluno AS 'RG'
	FROM tbAluno
		WHERE dataNascimento = (SELECT MIN(dataNascimento) FROM tbAluno)

-- c) Criar uma consulta que retorne o nome do aluno mais velho;
SELECT nomeAluno AS 'Aluno'
	FROM tbAluno
		WHERE dataNascimento = (SELECT MAX(dataNascimento) FROM tbAluno)

-- d) Criar uma consulta que retorne o nome e o valor do curso mais caro;
SELECT nomeCurso AS 'Curso', valorCurso AS 'Valor'
	FROM tbCurso
		WHERE valorCurso = (SELECT MAX(valorCurso) FROM tbCurso)

-- e) Criar uma consulta que retorne o nome do aluno e o nome do curso, do aluno que fez a ultima matriculo;
SELECT nomeAluno AS 'Aluno', nomeCurso AS 'Curso'
	FROM tbAluno
		INNER JOIN tbMatricula
			ON tbAluno.codAluno = tbMatricula.codAluno
				INNER JOIN tbTurma
					ON tbMatricula.codTurma = tbTurma.codTurma
						INNER JOIN tbCurso
							ON tbTurma.codCurso = tbCurso.codCurso
								WHERE codMatricula = (SELECT MAX(codMatricula) FROM tbMatricula)

-- f) Criar uma consulta que retorne o nome do primeiro aluno a ser matriculado na Escola de Idiomas;
SELECT nomeAluno
	FROM tbAluno	
		INNER JOIN tbMatricula
			ON tbAluno.codAluno = tbMatricula.codAluno
				WHERE dataMatricula = (SELECT MIN(dataMatricula) FROM tbMatricula)

-- g) Criar uma consulta que retorne o nome, rg e data de nascimento de todos os alunos que estejam matriculados no curso de ingles;
SELECT nomeAluno AS 'Aluno', rgAluno AS 'RG', dataNascimento AS 'Data de Nascimento'
	FROM tbAluno
		WHERE codAluno IN (SELECT codAluno 
								FROM tbMatricula
									INNER JOIN tbTurma
										ON tbMatricula.codTurma = tbTurma.codTurma
											INNER JOIN tbCurso
												ON tbTurma.codCurso = tbCurso.codCurso
													WHERE nomeCurso = 'Ingles')