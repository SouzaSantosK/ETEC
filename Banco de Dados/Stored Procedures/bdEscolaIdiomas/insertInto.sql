USE bdEscolaIdiomas

INSERT INTO tbCurso(nomeCurso, cargaHorariaCurso, valorCurso)
VALUES
	('Inglês', 2000, 356)
	, ('Espanhol', 3000, 478)
	, ('Alemão', 4000, 500)

INSERT INTO tbAluno(nomeAluno, dataNascAluno, rgAluno, naturalidadeAluno)
VALUES
	('Paulo Santos', '10/03/2000', '82.282.122-0', 'SP')
	, ('Maria da Glória', '03/10/1999', '45.233.123-0', 'SP')
	, ('Pedro Nogueira da Silva', '04/04/1998', '23.533.211-9', 'SP')
	, ('Gilson Barros Silva', '09/09/1995', '34.221.111-X', 'PE')
	, ('Mariana Barbosa Santos', '10/10/2001', '54.222.122-9', 'RJ')
	, ('Alessandro Pereira', '11/10/2003', '24.402.454-9', 'ES')
	, ('Aline Melo', '08/10/2001', '88.365.012-3', 'RJ')

INSERT INTO tbTurma(nomeTurma, idCurso, horarioTurma)
VALUES
	('1|A', 1, '12:00:00')
	, ('1|C', 3, '18:00:00')
	, ('1|B', 1, '18:00:00')
	, ('1AA', 2, '19:00:00')

INSERT INTO tbMatricula(dataMatricula, idAluno, idTurma)
VALUES
	('03/10/2015', 1, 1)
	, ('04/05/2014', 2, 1)
	, ('04/05/2014', 2, 4)
	, ('03/05/2012', 3, 2)
	, ('03/03/2016', 1, 3)
	, ('07/05/2015', 4, 2)
	, ('05/07/2015', 4, 3)
	
SELECT * FROM tbCurso
SELECT * FROM tbAluno
SELECT * FROM tbTurma
SELECT * FROM tbMatricula

