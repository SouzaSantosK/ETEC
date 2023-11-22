USE bdEscolaIdiomas
GO

-- 1. Crie uma função que informada uma data da matrícula, retorne o dia da semana
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
		SET @diaSemana = 'Terça-Feira'
	IF @dia = 4
		SET @diaSemana = 'Quarta-Feira'
	IF @dia = 5
		SET @diaSemana = 'Quinta-Feira'
	IF @dia = 6
		SET @diaSemana = 'Sexta-Feira'
	IF @dia = 7
		SET @diaSemana = 'Sábado'

	RETURN @diaSemana
END

SELECT CONVERT(VARCHAR(10), dataMatricula, 103) AS 'Data de matrícula', 'Dia da semana' = dbo.fcDia_Semana(dataMatricula) FROM tbMatricula

-- 2. Crie uma função que de acordo com a carga horária do curso exiba curso rápido ou curso extenso. (Rápido menos de 1000 horas).
CREATE FUNCTION fcDuracao_Curso(@CargaHoraria INT)
RETURNS VARCHAR(15)
AS
BEGIN
	DECLARE @duracao VARCHAR(15)

	IF @CargaHoraria >= 1000
		SET @duracao = 'Curso Extenso'
	ELSE
		SET @duracao = 'Curso Rápido'

	RETURN @duracao
END

SELECT cargaHorariaCurso AS 'Carga horária do curso', 'Duração do curso' = dbo.fcDuracao_Curso(cargaHorariaCurso) FROM tbCurso

-- 3. Crie uma função que de acordo com o valor do curso exiba curso caro ou curso barato. (Curso caro acima de 400).
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

-- 4. Criar uma função que informada a data da matrícula converta-a no formato dd/mm/aaaa.
CREATE FUNCTION fcConverte_Data(@dataMatricula DATE)
RETURNS VARCHAR(10)
AS
BEGIN
	DECLARE @dataConvertida VARCHAR(10)

	SET @dataConvertida = CONVERT(VARCHAR(10), @dataMatricula, 103)

	RETURN @dataConvertida
END

SELECT dataMatricula AS 'Data de matrícula', 'Data em DD/MM/AAAA' = dbo.fcConverte_Data(dataMatricula) FROM tbMatricula