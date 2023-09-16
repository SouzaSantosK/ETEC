USE bdEscolaIdiomas

INSERT INTO tbPeriodo(descricaoPeriodo)
	VALUES
		('Manha'),
		('Tarde'),
		('Noite')
		
INSERT INTO tbNivel(descricaoNivel)
	VALUES
		('Basico'),
		('Intermediario'),
		('Avancado')
		
INSERT INTO tbCurso(nomeCurso, valorCurso)
	VALUES
		('Ingles', 2000),
		('Espanhol', 2000),
		('Frances', 2600)
		
INSERT INTO tbTurma(descricaoTurma, codCurso, codNivel, codPeriodo, horario, diaDaSemana)
	VALUES
		('Ingles 1A', 1, 1, 1, '7:00', 'Segunda-Feira')
		, ('Espanhol 3C', 2, 3 , 2, '15:00', 'Quarta-Feira')
		, ('Frances 2E', 3, 2, 2, '14:00', 'Sexta-Feira')
		
INSERT INTO tbAluno(nomeAluno, rgAluno, cpfAluno, logradouro, numero, complemento, cep, bairro, cidade, dataNascimento)
	VALUES
		('Martin Breno Tomas Nunes', '345889812', '51099516919', 'Rua Vasconcelos Fernandes 226', '625', 'A', '79008970', 'Amamba�', 'Campo Grande', '09/08/1988')
		, ('Julia Lavania Rocha', '147428312', '96498617500', 'Rua Esperanto', '433', 'F', '27351210', 'Santa Maria II', 'Barra Mansa', '26/03/1999')
		, ('Edson Bruno Alves', '476335395', '35469485218', 'Rua Professor Agnelo Bitencourt', '722', 'B', '69305170', 'S�o Francisco', 'Barra Mansa', '16/05/1964')
		, ('Rafael Lucas Teixeira', '273469186', '29277128402', 'Alameda Olho D Agua', '584', 'Cruzamento Rua Esperanto', '27351310', 'Santa Maria II', 'Barra Mansa', '08/12/1987')
		
INSERT INTO tbTelefoneAluno(numTelAluno, codAluno)
	VALUES
		('9138463810', 1),
		('9125675330', 2),
		('91982523661' ,3),
		('9129306040', 4)
		
INSERT INTO tbMatricula(dataMatricula, codAluno, codTurma)
	VALUES
		('01/02/2018', 3, 2)
		,('02/08/2018', 4, 3)
		,('05/05/2019', 1, 1)
		,('06/05/2019', 2, 1)

	SELECT * FROM tbPeriodo
	SELECT * FROM tbNivel
	SELECT * FROM tbCurso
	SELECT * FROM tbTurma
	SELECT * FROM tbAluno
	SELECT * FROM tbTelefoneAluno
	SELECT * FROM tbMatricula
