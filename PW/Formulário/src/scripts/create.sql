CREATE TABLE tbUser (
    idUser INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(40) NOT NULL,
    password VARCHAR(40) NOT NULL,
    username VARCHAR(20) NOT NULL,
    firstName VARCHAR(20) NOT NULL,
    lastName VARCHAR(20) NOT NULL,
    county VARCHAR(20) NOT NULL,
    course VARCHAR(20) NOT NULL,
    phone VARCHAR(20) NOT NULL
)