CREATE DATABASE universidade_u;
USE universidade_u;

/*criando tabelas*/
CREATE TABLE ALUNO(
	idAluno INT auto_increment PRIMARY KEY,
    nome VARCHAR(100),
    cpf VARCHAR(11),
    nascimento DATE,
    sexo CHAR(1),
    valorPagoCurso DECIMAL(10,2),
    dataIncricaoCurso DATE,
    situacao CHAR(7)
);
CREATE TABLE ENDERECO(
	idEndereco INT auto_increment PRIMARY KEY,
    logradouro VARCHAR(100),
    numero VARCHAR(10),
    complemento VARCHAR(50),
    bairro VARCHAR(50),
    cidade VARCHAR(50),
    uf CHAR(2),
    fk_idAluno INT
);
CREATE TABLE TELEFONE(
	idTelefone INT auto_increment PRIMARY KEY,
    numero VARCHAR(20),
    tipo CHAR(3),
    fk_idAluno INT
);
CREATE TABLE ALUNO_CURSO(
	idAlunoCurso INT auto_increment PRIMARY KEY,
    fk_idAluno INT,
    fk_idCurso INT
);
CREATE TABLE CURSO(
	idCurso INT auto_increment PRIMARY KEY,
    descricao VARCHAR(100)
);

/*inserindo chaves-estrangeiras*/
ALTER TABLE ENDERECO 
	ADD CONSTRAINT fk_aluno_endereco
    FOREIGN KEY(fk_idAluno)
    REFERENCES ALUNO(idAluno);
ALTER TABLE TELEFONE 
	ADD CONSTRAINT fk_aluno_telefone
    FOREIGN KEY(fk_idAluno)
    REFERENCES ALUNO(idAluno);
ALTER TABLE ALUNO_CURSO
	ADD CONSTRAINT fk_aluno_curso
    FOREIGN KEY(fk_idAluno)
    REFERENCES ALUNO(idAluno);
ALTER TABLE ALUNO_CURSO 
	ADD CONSTRAINT fk_curso_aluno
    FOREIGN KEY(fk_idCurso)
    REFERENCES CURSO(idCurso);

/*inserindo dados*/
INSERT INTO ALUNO(nome, cpf, nascimento, sexo, valorPagoCurso, dataIncricaoCurso, situacao)
	VALUES('Mikael', '86227033049', '2000-01-14','M', 1000, '2019-02-21', 'ativo');
INSERT INTO ALUNO(nome, cpf, nascimento, sexo, valorPagoCurso, dataIncricaoCurso, situacao)
	VALUES('Anna', '11122244433', '2001-11-14','F', 20000, '2019-02-21', 'ativo');
INSERT INTO ALUNO(nome, cpf, nascimento, sexo, valorPagoCurso, dataIncricaoCurso, situacao)
	VALUES('Grace', '22233344411', '2018-08-20','F', 0, '2019-02-21', 'inativo');
INSERT INTO ALUNO(nome, cpf, nascimento, sexo, valorPagoCurso, dataIncricaoCurso, situacao)
	VALUES('Nina', '55544433311', '2016-03-09','F', 0, '2018-02-20', 'inativo');
INSERT INTO ALUNO(nome, cpf, nascimento, sexo, valorPagoCurso, dataIncricaoCurso, situacao)
	VALUES('Hades', '11122244435', '2021-01-14','M', 1000, '2019-02-21', 'ativo');
INSERT INTO TELEFONE(numero, tipo, fk_idAluno)
	VALUES('51996803022', 'pes', 1);
INSERT INTO TELEFONE(numero, tipo, fk_idAluno)
	VALUES('11978381414', 'pes', 2);
INSERT INTO TELEFONE(numero, tipo, fk_idAluno)
	VALUES('1123345567', 'res', 3);
INSERT INTO ENDERECO(logradouro, numero, complemento, bairro, cidade, uf, fk_idAluno)
	VALUES('R. Estado de Israel', '39', '', 'Vila Clementino', 'São Paulo', 'SP', 1);
 INSERT INTO ENDERECO(logradouro, numero, complemento, bairro, cidade, uf, fk_idAluno)
	VALUES('R. Ojinaga', '126', 'Travessa', 'Morto', 'São Paulo', 'SP', 2);
INSERT INTO ENDERECO(logradouro, numero, complemento, bairro, cidade, uf, fk_idAluno)
	VALUES('R. Estado de Israel', '39', '', 'Vila Clementino', 'São Paulo', 'SP', 3);
INSERT INTO ENDERECO(logradouro, numero, complemento, bairro, cidade, uf, fk_idAluno)
	VALUES('R. Estado de Israel', '39', '', 'Vila Clementino', 'São Paulo', 'SP', 4);
INSERT INTO ENDERECO(logradouro, numero, complemento, bairro, cidade, uf, fk_idAluno)
	VALUES('R. Ojinaga', '126', 'Travessa', 'Morto', 'São Paulo', 'SP', 6); 
INSERT INTO CURSO(descricao)
	VALUES('Programação para leigos');
INSERT INTO CURSO(descricao)
	VALUES('Algoritmos e lógica de programação');
INSERT INTO CURSO(descricao)
	VALUES('Git e GitHub');
INSERT INTO CURSO(descricao)
	VALUES('Linux');
INSERT INTO ALUNO_CURSO(fk_idAluno, fk_idCurso)
	VALUES(1, 1);
INSERT INTO ALUNO_CURSO(fk_idAluno, fk_idCurso)
	VALUES(1, 2);
INSERT INTO ALUNO_CURSO(fk_idAluno, fk_idCurso)
	VALUES(2, 4);
INSERT INTO ALUNO_CURSO(fk_idAluno, fk_idCurso)
	VALUES(2, 1);
INSERT INTO ALUNO_CURSO(fk_idAluno, fk_idCurso)
	VALUES(2, 3);

/*modificando valor já existente em um célula para outro desejado*/    
UPDATE TELEFONE 
	SET tipo ='cel' 
    WHERE idTelefone = 2;

/*mudando o tipo de uma variável para ENUM*/
ALTER TABLE TELEFONE
MODIFY COLUMN tipo ENUM('cel', 	'com', 'res');

/*mundando o tipo de variáveis para NOT NULL*/
ALTER TABLE TELEFONE
	MODIFY COLUMN numero VARCHAR(20) NOT NULL;
ALTER TABLE TELEFONE
	MODIFY COLUMN tipo CHAR(3) NOT NULL;
ALTER TABLE TELEFONE
	MODIFY COLUMN fk_idAluno INT NOT NULL;
ALTER TABLE ALUNO
	MODIFY COLUMN nome VARCHAR(100) NOT NULL;
ALTER TABLE ALUNO
	MODIFY COLUMN cpf VARCHAR(11) NOT NULL;
ALTER TABLE ALUNO
	MODIFY COLUMN nascimento DATE NOT NULL;
ALTER TABLE ALUNO
	MODIFY COLUMN sexo CHAR(1) NOT NULL;
ALTER TABLE ALUNO
	MODIFY COLUMN valorPagoCurso DECIMAL(10,2) NOT NULL;
ALTER TABLE ALUNO
	MODIFY COLUMN dataIncricaoCurso DATE NOT NULL;
ALTER TABLE ALUNO
	MODIFY COLUMN situacao CHAR(7) NOT NULL;
ALTER TABLE ALUNO
	MODIFY COLUMN situacao CHAR(7) NOT NULL;
ALTER TABLE ENDERECO
	MODIFY COLUMN logradouro VARCHAR(100) NOT NULL;
ALTER TABLE ENDERECO
	MODIFY COLUMN numero VARCHAR(10) NOT NULL;
ALTER TABLE ENDERECO
	MODIFY COLUMN complemento VARCHAR(50) NOT NULL;
ALTER TABLE ENDERECO
	MODIFY COLUMN bairro VARCHAR(50) NOT NULL;
ALTER TABLE ENDERECO
	MODIFY COLUMN cidade VARCHAR(50) NOT NULL;
ALTER TABLE ENDERECO
	MODIFY COLUMN uf CHAR(2) NOT NULL;
ALTER TABLE ENDERECO
	MODIFY COLUMN fk_idAluno INT NOT NULL;
ALTER TABLE ALUNO_CURSO
	MODIFY COLUMN fk_idAluno INT NOT NULL;
ALTER TABLE ALUNO_CURSO
	MODIFY COLUMN fk_idCurso INT NOT NULL;
ALTER TABLE CURSO
	MODIFY COLUMN descricao VARCHAR(100) NOT NULL;

ALTER TABLE TELEFONE
	ADD CONSTRAINT uc_telefone_numero
    UNIQUE (numero);
ALTER TABLE ALUNO
	ADD CONSTRAINT uc_aluno_cpf
    UNIQUE (cpf);
ALTER TABLE ENDERECO
	ADD CONSTRAINT uc_endereco_fk_idAluno
    UNIQUE (fk_idAluno);
    
SELECT * FROM ENDERECO;

SELECT FLOOR(45.76) AS VALOR;
    
