DROP TABLE IF EXISTS cargo;

CREATE TABLE cargo (
	cargo_id BIGINT(10) PRIMARY KEY AUTO_INCREMENT,
	cargo_name VARCHAR(50) NOT NULL
);

INSERT INTO cargo (cargo_name) VALUES ('Gerente');
INSERT INTO cargo (cargo_name) VALUES ('Desenvolvedor');
INSERT INTO cargo (cargo_name) VALUES ('Estagiário');
INSERT INTO cargo (cargo_name) VALUES ('Diretor');