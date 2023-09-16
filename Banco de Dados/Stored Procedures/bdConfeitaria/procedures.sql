USE bdConfeitaria

-- a) Criar uma Stored Procedure para inserir as categorias de produto conforme abaixo:
CREATE PROCEDURE insereCategoriaProduto
	@nomeCategoriaProduto VARCHAR(30)
	AS
	BEGIN
		IF EXISTS(SELECT nomeCategoriaProduto FROM tbCategoriaProduto WHERE nomeCategoriaProduto = @nomeCategoriaProduto)
		BEGIN
			PRINT('A categoria "' + @nomeCategoriaProduto + '" j� foi cadastrada.')
		END
		ELSE
		BEGIN
			INSERT INTO tbCategoriaProduto(nomeCategoriaProduto)
			VALUES
				(@nomeCategoriaProduto)
			PRINT('Categoria "' + @nomeCategoriaProduto + '" iserida com sucesso.')
		END
	END

EXEC insereCategoriaProduto 'Bolo Festa'
EXEC insereCategoriaProduto 'Bolo Simples'
EXEC insereCategoriaProduto 'Torta'
EXEC insereCategoriaProduto 'Salgado'

-- b) Criar uma Stored Procedure para inserir os produtos abaixo, sendo que, a procedure dever� antes de inserir verificar se o nome do produto j� existe, evitando assim que um produto seja duplicado:

CREATE PROCEDURE insereProduto
	@nomeProduto VARCHAR(35),
	@precoKiloProduto SMALLMONEY,
	@idCategoriaProduto INT
	AS
	BEGIN
		IF EXISTS(SELECT nomeProduto FROM tbProduto WHERE nomeProduto = @nomeProduto)
		BEGIN
			PRINT('O produto "' + @nomeProduto + '" j� est� cadastrado.')
		END
		ELSE
		BEGIN
			IF NOT EXISTS(SELECT @idCategoriaProduto FROM tbCategoriaProduto WHERE idCategoriaProduto = @idCategoriaProduto)
			BEGIN
				PRINT('O c�digo de categoria de produto ' + CONVERT(VARCHAR(10), @idCategoriaProduto) + ' n�o existe.')
			END
			ELSE
			BEGIN
				INSERT INTO tbProduto(nomeProduto, precoKiloProduto, idCategoriaProduto)
				VALUES
					(@nomeProduto, @precoKiloProduto, @idCategoriaProduto)
				PRINT('Produto "' + @nomeProduto + '" iserido com sucesso.')
			END
		END
	END

EXEC insereProduto 'Bolo Floresta Negra', 42, 1
EXEC insereProduto 'Bolo Prest�gio', 43, 1
EXEC insereProduto 'Bolo Nutella', 44, 1
EXEC insereProduto 'Bolo Formigueiro', 17, 2
EXEC insereProduto 'Bolo de Cenoura', 19, 2
EXEC insereProduto 'Torta de palmito', 45, 3
EXEC insereProduto 'Torta de frango e catupiry', 47, 3
EXEC insereProduto 'Torta de escarola', 44, 3
EXEC insereProduto 'Coxinha de frango', 25, 4
EXEC insereProduto 'Esfiha de carne', 27, 4
EXEC insereProduto 'Folhado queijo', 31, 4
EXEC insereProduto 'Risoles misto', 29, 4

EXEC insereProduto 'Bolo de Pedra', 42, 5

/* 
	c) Criar uma stored procedure para cadastrar os clientes abaixo relacionados, sendo que dever�o ser feitas duas valida��es:
		- Verificar pelo CPF se o cliente j� existe. Caso j� exista emitir a mensagem: �Cliente cpf XXXXX
		j� cadastrado�.

		- Verificar se o cliente � morador de Itaquera ou Guaianases, pois a confeitaria n�o realiza
		entregas para clientes que residam fora desses bairros. Caso o cliente n�o seja morador desses
		bairros enviar a mensagem �N�o foi poss�vel cadastrar o cliente XXXX pois o bairro XXXX n�o �
		atendido pela confeitaria�
*/

CREATE PROCEDURE insereCliente
	@nomeCliente VARCHAR(35),
	@dataNascimentoCliente DATE,
	@ruaCliente VARCHAR(30),
	@numCasaCliente VARCHAR(10),
	@cepCliente VARCHAR(10),
	@bairroCliente VARCHAR(30),
	@cidadeCliente VARCHAR(30),
	@estadoCliente VARCHAR(30),
	@cpfCliente CHAR(14),
	@sexoCliente CHAR(1)
	AS
	BEGIN
		IF EXISTS(SELECT cpfCliente FROM tbCliente WHERE cpfCliente = @cpfCliente)
		BEGIN
			PRINT('Cliente com o CPF ' + @cpfCliente + ' j� cadastrado.')
		END
		ELSE
		BEGIN
			IF @bairroCliente = 'Guaianases' OR @bairroCliente = 'Itaquera'
			BEGIN
				INSERT INTO tbCliente(nomeCliente, dataNascimentoCliente, ruaCliente, numCasaCliente, cepCliente, bairroCliente, cidadeCliente, estadoCliente, cpfCliente, sexoCliente)
				VALUES
					(@nomeCliente, @dataNascimentoCliente, @ruaCliente, @numCasaCliente, @cepCliente, @bairroCliente, @cidadeCliente, @estadoCliente, @cpfCliente, @sexoCliente)
				PRINT('Cliente ' + @nomeCliente + ' inserido com sucesso.')
			END
			ELSE
			BEGIN
				PRINT('Nossa confeitaria infelizmente n�o fornece entregas ao bairro ' + @bairroCliente + ', apenas Itaquera e Guaianases. Lamentamos pelo incoveniente.')	
			END
		END
	END

EXEC insereCliente 'Samira Fatah' , '05/05/1990', 'Rua Aguape�', 1000, '08.090-000', 'Guaianases', 'S�o Paulo', 'SP', '011.135.468-03', 'F'
EXEC insereCliente 'Celia Nogueira' , '06/06/1992', 'Rua Andes', 234, '08.456-090', 'Guaianases', 'S�o Paulo', 'SP', '923.222.148-05', 'F'
EXEC insereCliente 'Paulo Cesar Siqueira' , '04/04/1984', 'Rua Castelo do Piau�', 232, '08.109-000', 'Itaquera', 'S�o Paulo', 'SP', '843.106.475-00', 'M'
EXEC insereCliente 'Rodrigo Favaroni' , '09/04/1991', 'Rua Sans�o Castelo Branco', 10, '08.431-090', 'Guaianases', 'S�o Paulo', 'SP', '221.184.763-10', 'M'
EXEC insereCliente 'Fl�via Regina Brito' , '22/04/1992', 'Rua Mariana Moro', 300, '08.200-123', 'Itaquera', 'S�o Paulo', 'SP', '118.035.674-21', 'F'

EXEC insereCliente 'Pedro Marcelo', '11/07/1992', 'Rua Altis Pereira', '01', '58.211-123', 'Itaim', 'S�o Paulo', 'SP', '118.035.674-09', 'F'

/*
	d) Criar via stored procedure as encomendas abaixo relacionadas, fazendo as verifica��es abaixo:

	- No momento da encomenda o cliente ir� fornecer o seu cpf. Caso ele n�o tenha sido
	cadastrado enviar a mensagem �n�o foi poss�vel efetivar a encomenda pois o cliente xxxx n�o
	est� cadastrado�

	- Caso tudo esteja correto, efetuar a encomenda e emitir a mensagem: �Encomenda XXX para
	o cliente YYY efetuada com sucesso� sendo que no lugar de XXX dever� aparecer o n�mero da
	encomenda e no YYY dever� aparecer o nome do cliente;
*/

CREATE PROCEDURE insereEncomenda
	@dataEncomenda DATE,
	@valorTotalEncomenda SMALLMONEY,
	@dataEntregaEncomenda DATE,
	@cpfCliente CHAR(14)
	AS
	BEGIN
		DECLARE @idEncomenda INT
		DECLARE @nomeCliente VARCHAR(35)
		DECLARE @idCliente INT
		IF EXISTS(SELECT cpfCliente FROM tbCliente WHERE cpfCliente = @cpfCliente)
		BEGIN
			SET @idCliente = (SELECT idCliente FROM tbCliente WHERE cpfCliente = @cpfCliente)
			INSERT INTO tbEncomenda(dataEncomenda, valorTotalEncomenda, dataEntregaEncomenda, idCliente)
			VALUES
				(@dataEncomenda, @valorTotalEncomenda, @dataEntregaEncomenda, @idCliente)

			SET @idEncomenda = (SELECT MAX(idEncomenda) FROM tbEncomenda)
			SET @nomeCliente = (SELECT nomeCliente FROM tbCliente WHERE idCliente = @idCliente)

			PRINT('Encomenda ' + CONVERT(VARCHAR(10), @idEncomenda) + ' para o cliente ' + @nomeCliente + ' efetuada com sucesso.')
		END
		ELSE
		BEGIN
			PRINT('N�o foi poss�vel efetivar a encomenda pois o cliente com o cpf ' + @cpfCliente + ' n�o est� cadastrado.')
		END
	END

EXEC insereEncomenda '08/08/2015', 450, '15/08/2015', '011.135.468-03'
EXEC insereEncomenda '10/10/2015', 200, '15/10/2015', '923.222.148-05'
EXEC insereEncomenda '10/10/2015', 150, '10/12/2015', '843.106.475-00'
EXEC insereEncomenda '06/10/2015', 250, '12/10/2015', '011.135.468-03'
EXEC insereEncomenda '05/10/2015', 150, '12/10/2015', '221.184.763-10'

EXEC insereEncomenda '22/05/2015', 150, '12/06/2015', '012.544.193-10'

-- e) Ao adicionar a encomenda, criar uma Stored procedure, para que sejam inseridos os itens da encomenda conforme tabela a seguir.

CREATE PROCEDURE insereItensEncomenda
	@quantidadeKilos DECIMAL,
	@subTotal SMALLMONEY,
	@idProduto INT,
	@idEncomenda INT
	AS
	BEGIN
		DECLARE @nomeProduto VARCHAR(35)
		IF EXISTS(SELECT idEncomenda FROM tbEncomenda WHERE idEncomenda = @idEncomenda)
		BEGIN
			IF EXISTS(SELECT idProduto FROM tbProduto WHERE idProduto = @idProduto)
			BEGIN
				INSERT INTO tbItensEncomenda(quantidadeKilos, subTotal, idProduto, idEncomenda)
				VALUES
					(@quantidadeKilos, @subTotal, @idProduto, @idEncomenda)

				SET @nomeProduto = (SELECT nomeProduto FROM tbProduto WHERE idProduto = @idProduto)

				PRINT('Item: "' + @nomeProduto + '" inserido na encomenda com sucesso.')
			END
			ELSE
			BEGIN
				PRINT('Imposs�vel inserir o produto ' +  CONVERT(VARCHAR(5), @idProduto) + ' na encomenda pois ele n�o existe.')
			END
		END
		ELSE
		BEGIN
			PRINT('Imposs�vel inserir esse item na encomenda ' + CONVERT(VARCHAR(5), @idEncomenda) + ' pois ela n�o existe.')
		END
	END

EXEC insereItensEncomenda 2.5, 105, 1, 1
EXEC insereItensEncomenda 2.6, 70, 10, 1
EXEC insereItensEncomenda 6, 150, 9, 1
EXEC insereItensEncomenda 4.3, 125, 12, 1
EXEC insereItensEncomenda 8, 200, 9, 2
EXEC insereItensEncomenda 3.2, 100, 11, 3
EXEC insereItensEncomenda 2, 50, 9, 3
EXEC insereItensEncomenda 3.5, 150, 2, 4
EXEC insereItensEncomenda 2.2, 100, 3, 4
EXEC insereItensEncomenda 3.4, 150, 6, 5

EXEC insereItensEncomenda 3.4, 150, 6, 24
EXEC insereItensEncomenda 3.4, 150, 120, 1

/*
	f) Ap�s todos os cadastros, criar Stored procedures para alterar o que se pede:

	1- O pre�o dos produtos da categoria �Bolo festa� sofreram um aumento de 10%
	2- O pre�o dos produtos categoria �Bolo simples� est�o em promo��o e ter�o um desconto
	de 20%;
	3- O pre�o dos produtos categoria �Torta� aumentaram 25%
	4- O pre�o dos produtos categoria �Salgado�, com exce��o da esfiha de carne, sofreram um
	aumento de 20%
*/

CREATE PROCEDURE aumentaPrecoProduto
	@categoria VARCHAR(30),
	@percentual DECIMAL,
	@produtoExcecao VARCHAR(35) = NULL
	AS
	BEGIN
		IF @produtoExcecao IS NULL
		BEGIN
		UPDATE tbProduto
			SET precoKiloProduto = precoKiloProduto * (1 + (@percentual / 100)) 
				WHERE idCategoriaProduto = (SELECT idCategoriaProduto FROM tbCategoriaProduto 
					WHERE nomeCategoriaProduto = @categoria)
			PRINT('Todos os produtos de categoria "' + @categoria + '" sofreram um aumento de ' + CONVERT(VARCHAR(10), @percentual) + '%.')
		END
		ELSE
		BEGIN
			UPDATE tbProduto
				SET precoKiloProduto = precoKiloProduto * (1 + (@percentual / 100)) 
					WHERE idCategoriaProduto = (SELECT idCategoriaProduto FROM tbCategoriaProduto 
						WHERE nomeCategoriaProduto = @categoria AND nomeProduto != @produtoExcecao)
			PRINT('Todos os produtos (exceto ' + @produtoExcecao + '), de categoria "' + @categoria + '" sofreram um aumento de ' + CONVERT(VARCHAR(10), @percentual) + '%.')
		END
	END

CREATE PROCEDURE diminuiPrecoProduto
	@categoria VARCHAR(30),
	@percentual DECIMAL
	AS
	BEGIN
		UPDATE tbProduto
			SET precoKiloProduto = precoKiloProduto * (1 - (@percentual / 100)) WHERE idCategoriaProduto = (SELECT idCategoriaProduto FROM tbCategoriaProduto WHERE nomeCategoriaProduto = @categoria)
		
		PRINT('Todos os produtos de categoria"' + @categoria + '" sofreram um desconto de ' + CONVERT(VARCHAR(10), @percentual) + '%.')
	END

EXEC aumentaPrecoProduto 'Bolo Festa', 10
EXEC diminuiPrecoProduto 'Bolo Simples', 20
EXEC aumentaPrecoProduto 'Torta', 25
EXEC aumentaPrecoProduto 'Salgado', 20, 'Esfiha de carne'

/*
	g) Criar uma procedure para excluir clientes pelo CPF sendo que:

	1- Caso o cliente possua encomendas emitir a mensagem �Imposs�vel remover esse cliente pois o 
	cliente XXXXX possui encomendas; onde XXXXX � o nome do cliente.

	2- Caso o cliente n�o possua encomendas realizar a remo��o e emitir a mensagem �Cliente XXXX 
	removido com sucesso�, onde XXXX � o nome do cliente;
*/

CREATE PROCEDURE removeCliente
	@cpfCliente CHAR(14)
	AS
	BEGIN
		DECLARE @nomeCliente VARCHAR(35)
		SET @nomeCliente = (SELECT nomeCliente FROM tbCliente WHERE cpfCliente = @cpfCliente)
		IF EXISTS(SELECT cpfCliente FROM tbCliente WHERE cpfCliente = @cpfCliente)
		BEGIN
			IF EXISTS(SELECT idCliente FROM tbEncomenda WHERE idCliente = (SELECT idCliente FROM tbCliente WHERE cpfCliente = @cpfCliente))
			BEGIN
				PRINT('Imposs�vel remover, pois o cliente "' + @nomeCliente + '" possui encomendas em aberto.')
			END
			ELSE
			BEGIN
				DELETE FROM tbCliente WHERE cpfCliente = @cpfCliente
				PRINT('Cliente ' + @nomeCliente + ' removido com sucesso.')
			END
		END
		ELSE
		BEGIN
			PRINT('O CPF ' + @cpfCliente + ' n�o existe.')
		END
	END

EXEC removeCliente '843.106.475-00'

EXEC removeCliente '118.035.674-21'
EXEC removeCliente '118.035.674-00'


/*
	h) - Criar uma procedure que permita excluir qualquer item de uma encomenda que exista. Para 
	tal o cliente dever� fornecer o c�digo da encomenda e o c�digo do produto que ser� exclu�do 
	da encomenda. A procedure dever� remover o item e atualizar o valor total da encomenda, do 
	qual dever� ser subtra�do o valor do item a ser removido. A procedure poder� remover apenas 
	um item da encomenda de cada vez.
*/

CREATE PROCEDURE removeItemEncomenda
	@idEncomenda INT,
	@idItemEncomenda INT
	AS
	BEGIN
		DECLARE @valorTotalEncomenda SMALLMONEY
		DECLARE @valorItem SMALLMONEY
		DECLARE @novoValorTotal SMALLMONEY
		IF EXISTS(SELECT idEncomenda FROM tbItensEncomenda WHERE idEncomenda = @idEncomenda)
		BEGIN
			IF EXISTS(SELECT idItemEncomenda FROM tbItensEncomenda WHERE idItemEncomenda = @idItemEncomenda)
			BEGIN
				SET @valorTotalEncomenda = (SELECT valorTotalEncomenda FROM tbEncomenda WHERE idEncomenda = @idEncomenda)
				SET @valorItem = (SELECT subTotal FROM tbItensEncomenda WHERE idItemEncomenda = @idItemEncomenda)
				SET @novoValorTotal = @valorTotalEncomenda - @valorItem

				UPDATE tbEncomenda
					SET valorTotalEncomenda = @novoValorTotal
						WHERE idEncomenda = @idEncomenda

				DELETE FROM tbItensEncomenda
					WHERE idEncomenda = @idEncomenda AND idItemEncomenda = @idItemEncomenda

				PRINT('Item removido da encomenda com sucesso. Valor reajustado: R$' + CONVERT(VARCHAR(10), @novoValorTotal))
			END
			ELSE
			BEGIN
				PRINT('A encomenda informada existe, por�m o item n�o.')
			END
		END
		ELSE
		BEGIN
			PRINT('A encomenda informada n�o existe.')
		END
	END

EXEC removeItemEncomenda 1, 1

EXEC removeItemEncomenda 1, 12
EXEC removeItemEncomenda 15, 1

/*
	i) - Criar uma stored procedure que receba o cpf de um cliente e a data de entrega de uma
	encomenda e exclua essa encomenda feita para esse cliente. Para tal a stored procedure ter�
	que:
		a. Verificar se o cliente existe no banco de dados
		b. Verificar se o cliente possui encomenda na data solicitada
		c. Em caso negativo (n�o existe cliente ou n�o existe encomenda) para ambos os casos
		enviar mensagem informando a situa��o
		d. Em caso positivo (existe cliente e existe encomenda) excluir a encomenda e todos os
		seus itens do banco de dados
*/

CREATE PROCEDURE removeEncomenda
	@cpfCliente VARCHAR(14),
	@dataEntregaEncomenda DATE
	AS
	BEGIN
		DECLARE @idCliente INT
		DECLARE @idEncomenda INT

		SELECT @idCliente = idCliente FROM tbCliente WHERE cpfCliente = @cpfCliente

		IF @idCliente IS NOT NULL
		BEGIN
			IF EXISTS(SELECT idEncomenda FROM tbEncomenda WHERE idCliente = @idCliente AND dataEntregaEncomenda = @dataEntregaEncomenda)
			BEGIN
				SELECT @idEncomenda = idEncomenda FROM tbEncomenda WHERE idCliente = @idCliente AND dataEntregaEncomenda = @dataEntregaEncomenda

				DELETE FROM tbItensEncomenda WHERE idEncomenda = @idEncomenda
				DELETE FROM tbEncomenda WHERE idEncomenda = @idEncomenda

				PRINT('Encomenda removida com sucesso.')
			END
			ELSE
			BEGIN
				PRINT('N�o h� encomendas nessa data para o cliente com o CPF ' + @cpfCliente + '.')
			END
		END
		ELSE
		BEGIN
			PRINT('N�o h� clientes cadastrados com esse CPF.')
		END
	END

EXEC removeEncomenda '923.222.148-05', '15/10/2015'

EXEC removeEncomenda '923.222.148-05', '21/12/2018'
EXEC removeEncomenda '123.456.789-00', '12/10/2015'


-- j) - Criar uma stored procedure que receba uma data de entrega e que liste todas as encomendas e itens que dever�o ser entregues na referida data

CREATE PROCEDURE listaEncomendas
	@dataEntregaEncomenda DATE
	AS
	BEGIN
		IF EXISTS(SELECT dataEntregaEncomenda FROM tbEncomenda WHERE dataEntregaEncomenda = @dataEntregaEncomenda)
		BEGIN
			SELECT idEncomenda, dataEncomenda, valorTotalEncomenda, dataEntregaEncomenda, idCliente FROM tbEncomenda
				WHERE dataEntregaEncomenda = @dataEntregaEncomenda

			SELECT idItemEncomenda, quantidadeKilos, subTotal, idProduto, tbItensEncomenda.idEncomenda FROM tbItensEncomenda
				INNER JOIN tbEncomenda
					ON tbItensEncomenda.idEncomenda = tbEncomenda.idEncomenda
						WHERE dataEntregaEncomenda = @dataEntregaEncomenda
		END
		ELSE
		BEGIN
			PRINT('N�o h� registro de encomendas para entrega na data ' + CONVERT(VARCHAR(10), @dataEntregaEncomenda, 103))
		END
	END

EXEC listaEncomendas '12/10/2015'
EXEC listaEncomendas '10/12/2017'














