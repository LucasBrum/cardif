DROP TABLE IF EXISTS cargo;
DROP TABLE IF EXISTS funcionario;
DROP TABLE IF EXISTS departamento;
DROP TABLE IF EXISTS funcionario_departamento;

CREATE TABLE cargo (
	cargo_id BIGINT(10) PRIMARY KEY AUTO_INCREMENT,
	cargo_name VARCHAR(50) NOT NULL
);

INSERT INTO cargo (cargo_name) VALUES ('Gerente');
INSERT INTO cargo (cargo_name) VALUES ('Desenvolvedor');
INSERT INTO cargo (cargo_name) VALUES ('Estagiário');
INSERT INTO cargo (cargo_name) VALUES ('Diretor');

CREATE TABLE departamento (
	departamento_id BIGINT(10) PRIMARY KEY AUTO_INCREMENT,
	departamento_name VARCHAR(50) NOT NULL
);

 INSERT INTO departamento (departamento_name) VALUES ('Comercial');
 INSERT INTO departamento (departamento_name) VALUES ('TI');
 INSERT INTO departamento (departamento_name) VALUES ('RH');
 INSERT INTO departamento (departamento_name) VALUES ('Marketing');

CREATE TABLE funcionario (
	funcionario_id BIGINT(10) PRIMARY KEY AUTO_INCREMENT,
	funcionario_name VARCHAR(50) NOT NULL,
	funcionario_age BIGINT(10) NOT NULL,
	funcionario_birthday DATE NOT NULL,
	funcionario_document VARCHAR(50) NOT NULL,
	cargo_id BIGINT(10) NOT NULL,
	FOREIGN KEY (cargo_id) REFERENCES cargo(cargo_id)
);

CREATE TABLE funcionario_departamento (
	funcionario_id BIGINT(10) NOT NULL,
	departamento_id BIGINT(10) NOT NULL,
	FOREIGN KEY (funcionario_id) REFERENCES funcionario(funcionario_id) ON DELETE RESTRICT ON UPDATE CASCADE,
	FOREIGN KEY (departamento_id) REFERENCES departamento(departamento_id) ON DELETE RESTRICT ON UPDATE CASCADE,
	PRIMARY KEY (funcionario_id, departamento_id)
);
