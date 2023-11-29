USE bdEscolaIdiomas
GO

-- 1. Crie uma fun��o que informada uma data da matr�cula, retorne o dia da semana
CREATE FUNCTION fcDia_Semana(@Data date)
RETURNS VARCHAR(40)
AS
BEGIN
	DECLARE @diaSemana VARCHAR(40)
	DECLARE @dia INT
	SET @dia = DATEPART(DW, @Data)

	IF @dia = 1
		SET @diaSemana = 'Domingo'
	IF @dia = 2
		SET @diaSemana = 'Segunda-Feira'
	IF @dia = 3
		SET @diaSemana = 'Ter�a-Feira'
	IF @dia = 4
		SET @diaSemana = 'Quarta-Feira'
	IF @dia = 5
		SET @diaSemana = 'Quinta-Feira'
	IF @dia = 6
		SET @diaSemana = 'Sexta-Feira'
	IF @dia = 7
		SET @diaSemana = 'S�bado'

	RETURN @diaSemana
END

SELECT CONVERT(VARCHAR(10), dataMatricula, 103) AS 'Data de matr�cula', 'Dia da semana' = dbo.fcDia_Semana(dataMatricula) FROM tbMatricula

-- 2. Crie uma fun��o que de acordo com a carga hor�ria do curso exiba curso r�pido ou curso extenso. (R�pido menos de 1000 horas).
CREATE FUNCTION fcDuracao_Curso(@CargaHoraria INT)
RETURNS VARCHAR(15)
AS
BEGIN
	DECLARE @duracao VARCHAR(15)

	IF @CargaHoraria >= 1000
		SET @duracao = 'Curso Extenso'
	ELSE
		SET @duracao = 'Curso R�pido'

	RETURN @duracao
END

SELECT cargaHorariaCurso AS 'Carga hor�ria do curso', 'Dura��o do curso' = dbo.fcDuracao_Curso(cargaHorariaCurso) FROM tbCurso

-- 3. Crie uma fun��o que de acordo com o valor do curso exiba curso caro ou curso barato. (Curso caro acima de 400).
CREATE FUNCTION fcValor_Curso(@valorCurso SMALLMONEY)
RETURNS VARCHAR(12)
AS
BEGIN
	DECLARE @status VARCHAR(12)

	IF @valorCurso > 400
		SET @status = 'Curso caro'
	ELSE
		SET @status = 'Curso barato'

	RETURN @status
END

SELECT valorCurso AS 'Valor do curso', 'Status do curso' = dbo.fcValor_Curso(valorCurso) FROM tbCurso

-- 4. Criar uma fun��o que informada a data da matr�cula converta-a no formato dd/mm/aaaa.
CREATE FUNCTION fcConverte_Data(@dataMatricula DATE)
RETURNS VARCHAR(10)
AS
BEGIN
	DECLARE @dataConvertida VARCHAR(10)

	SET @dataConvertida = CONVERT(VARCHAR(10), @dataMatricula, 103)

	RETURN @dataConvertida
END

SELECT dataMatricula AS 'Data de matr�cula', 'Data em DD/MM/AAAA' = dbo.fcConverte_Data(dataMatricula) FROM tbMatricula