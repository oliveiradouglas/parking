CREATE DATABASE IF NOT EXISTS parking;

USE parking;

CREATE TABLE IF NOT EXISTS vehicle_models (
	id INT(11),
	description VARCHAR(50) NOT NULL
);

ALTER TABLE vehicle_models ADD CONSTRAINT pk_vehicle_models PRIMARY KEY (id);
ALTER TABLE vehicle_models MODIFY id INT(11) AUTO_INCREMENT;

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
	vehicle_model_id INT(11) NOT NULL,
	vehicle_plate VARCHAR(7) NOT NULL
);

ALTER TABLE vehicles ADD CONSTRAINT pk_vehicles PRIMARY KEY (id);
ALTER TABLE vehicles MODIFY id INT(11) AUTO_INCREMENT;
ALTER TABLE vehicles ADD CONSTRAINT fk_vehicles_vehicle_models FOREIGN KEY (vehicle_model_id) REFERENCES vehicle_models (id);
ALTER TABLE vehicles ADD CONSTRAINT fk_vehicles_colors FOREIGN KEY (color_id) REFERENCES colors (id);

CREATE TABLE IF NOT EXISTS parking_control (
	id INT(11),
	vehicle_id INT(11) NOT NULL,
	notes VARCHAR(255),
	entry DATETIME NOT NULL,
	`exit` DATETIME
);

ALTER TABLE parking_control ADD CONSTRAINT pk_parking_control PRIMARY KEY (id);
ALTER TABLE parking_control MODIFY id INT(11) AUTO_INCREMENT;
ALTER TABLE parking_control ADD CONSTRAINT fk_parking_control_vehicles FOREIGN KEY (vehicle_id) REFERENCES vehicles (id);

CREATE TABLE IF NOT EXISTS settings (
	id INT(11),
	parking_name VARCHAR(30) NOT NULL,
	first_hour_value DECIMAL(12,2) NOT NULL,
	other_hours_value DECIMAL(12,2) NOT NULL
);

ALTER TABLE settings ADD CONSTRAINT pk_settings PRIMARY KEY (id);
ALTER TABLE settings MODIFY id INT(11) AUTO_INCREMENT;