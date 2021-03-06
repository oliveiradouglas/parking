CREATE DATABASE IF NOT EXISTS parking;

USE parking;

-- ok
CREATE TABLE IF NOT EXISTS settings (
	id INT(11),
	parking_name VARCHAR(30) NOT NULL,
	first_hour_value DECIMAL(12,2) NOT NULL,
	other_hours_value DECIMAL(12,2) NOT NULL
);

ALTER TABLE settings ADD CONSTRAINT pk_settings PRIMARY KEY (id);
ALTER TABLE settings MODIFY id INT(11) AUTO_INCREMENT;

-- ok
CREATE TABLE IF NOT EXISTS colors (
	id INT(11),
	name VARCHAR(50) NOT NULL
);

ALTER TABLE colors ADD CONSTRAINT pk_colors PRIMARY KEY (id);
ALTER TABLE colors MODIFY id INT(11) AUTO_INCREMENT;

insert into parking.colors (name) values 
("Vermelho"),
("Amarelo"),
("Azul"),
("Verde"),
("Preto"),
("Roxo"),
("Laranja"),
("Marrom"),
("Prata"),
("Rosa"),
("Branco"),
("Outra");

CREATE TABLE IF NOT EXISTS vehicles (
	id INT(11),
	color_id INT(11) NOT NULL,
	type VARCHAR(50) NOT NULL,
	brand VARCHAR(100) NOT NULL,
	model VARCHAR(200) NOT NULL,
	vehicle_plate VARCHAR(7) NOT NULL
);

ALTER TABLE vehicles ADD CONSTRAINT pk_vehicles PRIMARY KEY (id);
ALTER TABLE vehicles MODIFY id INT(11) AUTO_INCREMENT;
ALTER TABLE vehicles ADD CONSTRAINT fk_vehicles_colors FOREIGN KEY (color_id) REFERENCES colors (id);

CREATE TABLE IF NOT EXISTS parkings (
	id INT(11),
	vehicle_id INT(11) NOT NULL,
	notes VARCHAR(255),
	entry DATETIME NOT NULL,
	output DATETIME
);

ALTER TABLE parkings ADD CONSTRAINT pk_parkings PRIMARY KEY (id);
ALTER TABLE parkings MODIFY id INT(11) AUTO_INCREMENT;
ALTER TABLE parkings ADD CONSTRAINT fk_parkings_vehicles FOREIGN KEY (vehicle_id) REFERENCES vehicles (id);