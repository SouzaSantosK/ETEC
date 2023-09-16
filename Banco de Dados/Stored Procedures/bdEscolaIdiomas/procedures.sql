USE bdEscolaIdiomas

-- 1 - Criar uma stored procedure “Busca_Aluno” que receba o código do aluno e retorne seu nome e data de nascimento
CREATE PROCEDURE buscaAluno
	@idAluno INT
	AS
	BEGIN
		IF EXISTS(SELECT idAluno FROM tbAluno WHERE idAluno = @idAluno)
		BEGIN
			SELECT nomeAluno, dataNascAluno FROM tbAluno WHERE idAluno = @idAluno
		END
		ELSE
		BEGIN
			PRINT('Não há um aluno com o id: ' + CONVERT(VARCHAR(10), @idAluno))
		END

		SELECT * FROM tbAluno
	END
EXEC buscaAluno 12

-- 2 - Criar uma stored procedure “Insere_Aluno” que insira um registro na tabela de Alunos.
CREATE PROCEDURE insereAluno
    @nomeAluno VARCHAR(45),
	@dataNascAluno DATE,
	@rgAluno VARCHAR(15), 
	@naturalidadeAluno CHAR(2)
    AS
    BEGIN
		DECLARE @idAluno INT
		IF EXISTS(SELECT rgAluno FROM tbAluno WHERE rgAluno = @rgAluno)
			BEGIN
				PRINT('O RG ' + @rgAluno + ' já foi cadastrado.')
			END
		ELSE
		BEGIN
			INSERT INTO tbAluno(nomeAluno, dataNascAluno, rgAluno, naturalidadeAluno)
			VALUES
			(@nomeAluno, @dataNascAluno, @rgAluno, @naturalidadeAluno)
			SET @idAluno = (SELECT MAX(idAluno) FROM tbAluno)
			PRINT('Aluno ' + @nomeAluno + ', de id: ' + CONVERT(VARCHAR(10), @idAluno) + ' foi cadastrado com sucesso.')

			SELECT * FROM tbAluno
		END
	END

EXEC insereAluno 'Matheus Bezerra', '2001-07-12', '55.127.196-4', 'RS'

-- 3 - Criar uma stored procedure “Aumenta_Preco” que, dados o nome do curso e um percentual, aumente o valor do curso com a porcentagem informada
CREATE PROCEDURE aumentaPreco
	@nomeCurso VARCHAR(30),
	@percentual FLOAT
	AS
	BEGIN
		IF EXISTS(SELECT nomeCurso FROM tbCurso WHERE nomeCurso = @nomeCurso)
			BEGIN
				DECLARE @novoValorCurso SMALLMONEY

				SELECT @novoValorCurso = valorCurso * (1 + (@percentual / 100)) 
					FROM tbCurso
						WHERE nomeCurso = @nomeCurso

				UPDATE tbCurso
					SET valorCurso = @novoValorCurso
						WHERE nomeCurso = @nomeCurso

				SELECT * FROM tbCurso
			END
		ELSE
			BEGIN
				PRINT('O curso ' + @nomeCurso + ' não existe.')
			END
	END

EXEC aumentaPreco 'Inglês', 12

-- 4 - Criar uma stored procedure “Exibe_Turma” que, dado o nome da turma exiba todas as informações dela.
ALTER PROCEDURE exibeTurma
	@nomeTurma CHAR(3)
	AS
	BEGIN
		IF EXISTS(SELECT nomeTurma FROM tbTurma WHERE nomeTurma = @nomeTurma)
			BEGIN
				SELECT * FROM tbTurma 
					WHERE nomeTurma = @nomeTurma
			END
		ELSE
			PRINT('A turma ' + @nomeTurma + ' não existe.')
	END

EXEC exibeTurma '1AA'

-- 5 - Criar uma stored procedure “Exibe_AlunosdaTurma” que, dado o nome da turma exiba os seus alunos.
CREATE PROCEDURE exibeAlunosDaTurma
	@nomeTurma CHAR(3)
	AS
	BEGIN
		IF EXISTS(SELECT nomeTurma FROM tbTurma WHERE nomeTurma = @nomeTurma)
			BEGIN
				SELECT nomeAluno FROM tbAluno
					INNER JOIN tbMatricula
						ON tbAluno.idAluno = tbMatricula.idAluno
							INNER JOIN tbTurma
								ON tbMatricula.idTurma = tbTurma.idTurma
									WHERE nomeTurma = @nomeTurma
			END
		ELSE
			BEGIN
				PRINT('A turma ' + @nomeTurma + ' não existe.')
			END
	END

EXEC exibeAlunosDaTurma '1|A'

-- 6 - Criar uma stored procedure para inserir alunos, verificando pelo cpf se o aluno existe ou não, e informar essa condição via mensagem
-- No meu banco, os alunos não tem CPF !!!
CREATE PROCEDURE verificaAluno
	@rgAluno VARCHAR(15)
	AS
	BEGIN
		IF EXISTS(SELECT rgAluno FROM tbAluno WHERE rgAluno = @rgAluno)
			BEGIN
				PRINT('O aluno portador do RG ' + @rgAluno + ' existe.')
			END
		ELSE
			BEGIN
				PRINT('O aluno portador do RG ' + @rgAluno + ' não existe.')
			END
	END

EXEC verificaAluno '82.282.122-0'

-- 7 - Criar uma stored procedure que receba o nome do curso e o nome do aluno e matricule o mesmo no curso pretendido
CREATE PROCEDURE matriculaAluno
	@nomeCurso VARCHAR(30),
	@nomeAluno VARCHAR(45)
	AS
	BEGIN
		
	END

