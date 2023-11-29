CREATE TABLE tbCategoria(
	idCategoria INT PRIMARY KEY AUTO_INCREMENT,
	categoria VARCHAR(40)
);

CREATE TABLE tbProduto(
	idProduto INT PRIMARY KEY AUTO_INCREMENT,
    produto VARCHAR(50),
    valor DECIMAL,
    descricao VARCHAR(200),
    quantidade INT,
    idCategoria INT,
    FOREIGN KEY (idCategoria) REFERENCES tbCategoria(idCategoria)
);

INSERT INTO tbCategoria
VALUES
	(null, 'Brinquedo'),
	(null, 'Eletrônico'),
	(null, 'Ferramentas'),
	(null, 'Saúde');