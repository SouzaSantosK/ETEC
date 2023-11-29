USE bdAutomovel

/*
	A) - Criar um trigger que ao veículo tomar uma multa os
	pontos da multa sejam atualizados na tabela do
	motorista no campo pontuacaoAcumulada. 
*/

CREATE TRIGGER tgAtualizaPontos
	ON tbMulta AFTER INSERT
	AS
	BEGIN
		DECLARE @codMotorista INT, @codVeiculo INT, @numPontos INT
		SET @codVeiculo = (SELECT codVeiculo FROM INSERTED)
		SELECT @numPontos = numPontos FROM INSERTED
		SET @codMotorista = (SELECT codMotorista FROM tbVeiculo WHERE codVeiculo = @codVeiculo)
		UPDATE tbMotorista
			SET pontuacaoAcumulada = pontuacaoAcumulada + @numPontos
				WHERE codMotorista = @codMotorista
	END

SELECT * FROM tbMulta
SELECT * FROM tbMotorista
SELECT * FROM tbVeiculo

INSERT INTO tbMulta(dataMulta, numPontos, codVeiculo)
VALUES
	(GETDATE(), 1, 1)

/*
	B) - Criar um trigger que todas as vezes que o motorista
	atinja 20 pontos ou mais no campo pontuacaoAcumulada, sua
	situação seja alterada para SUSPENSO e o mesmo seja
	informado via mensagem.
*/

CREATE TRIGGER tgAlteraSituacao
	ON tbMotorista AFTER UPDATE
	AS
	BEGIN
		DECLARE @pontuacaoAcumulada INT, @codMotorista INT, @nomeMotorista VARCHAR(40)
		SET @pontuacaoAcumulada = (SELECT pontuacaoAcumulada FROM INSERTED)
		SET @codMotorista = (SELECT codMotorista FROM INSERTED)
		SET @nomeMotorista = (SELECT nomeMotorista FROM INSERTED)
		IF @pontuacaoAcumulada >= 20
		BEGIN
			UPDATE tbMotorista
				SET situacaoMotorista = 'SUSPENSO'
					WHERE codMotorista = @codMotorista

			PRINT('Motorista "' + @nomeMotorista + '" está suspenso(a) com ' + CONVERT(VARCHAR(2), @pontuacaoAcumulada) + ' pontos na carteira.')
		END
	END
		