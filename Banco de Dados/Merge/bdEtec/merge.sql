USE bdEtec

MERGE tb3 AS destino
	USING (
		SELECT rmAluno, nomeAluno, statusAluno
		FROM tb2A
		WHERE statusAluno = 'APROVADO'
	) AS origem
	ON origem.rmAluno = destino.rmAluno
	WHEN NOT MATCHED THEN
		INSERT (rmAluno, nomeAluno, statusAluno)
		VALUES (origem.rmAluno, origem.nomeAluno, origem.statusAluno);

MERGE tb3 AS destino
	USING (
		SELECT rmAluno, nomeAluno, statusAluno
		FROM tb2B
		WHERE statusAluno = 'APROVADO'
	) AS origem
	ON origem.rmAluno = destino.rmAluno
	WHEN NOT MATCHED THEN
		INSERT (rmAluno, nomeAluno, statusAluno)
		VALUES (origem.rmAluno, origem.nomeAluno, origem.statusAluno);

-- ou

MERGE tb3 AS destino
	USING (
		SELECT rmAluno, nomeAluno, statusAluno
		FROM tb2A
		WHERE statusAluno = 'APROVADO'
		UNION ALL
		SELECT rmAluno, nomeAluno, statusAluno
		FROM tb2B
		WHERE statusAluno = 'APROVADO'
	) AS origem
	ON origem.rmAluno = destino.rmAluno
	WHEN NOT MATCHED THEN
		INSERT (rmAluno, nomeAluno, statusAluno)
		VALUES (origem.rmAluno, origem.nomeAluno, origem.statusAluno);


SELECT * FROM tb2A
SELECT * FROM tb2B
SELECT * FROM tb3