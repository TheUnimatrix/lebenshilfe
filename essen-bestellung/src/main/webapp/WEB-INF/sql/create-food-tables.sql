DROP DATABASE IF EXISTS lebenshilfe_essen;

CREATE DATABASE IF NOT EXISTS lebenshilfe_essen
	CHARACTER SET = "utf8"
	COLLATE = "utf8_general_ci";
	
USE lebenshilfe_essen;
	
CREATE TABLE IF NOT EXISTS kunden (
	kunden_id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(20),
	liefer_addr_id INT NOT NULL,
	rechng_addr_id INT NOT NULL,
	preisgruppe INT NOT NULL,
	email VARCHAR(50) UNIQUE,
	passwort VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS adressen (
	addr_id INT PRIMARY KEY AUTO_INCREMENT,
	strasse VARCHAR(20),
	plz CHAR(5),
	ort VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS bestellung (
	bestell_id INT PRIMARY KEY AUTO_INCREMENT,
	datum DATE,
	kunden_id INT NOT NULL
);

CREATE TABLE IF NOT EXISTS bestellposition (
	bestell_id INT NOT NULL,
	position INT NOT NULL,
	essen CHAR(1) NOT NULL,
	menge INT NOT NULL,
	PRIMARY KEY (bestell_id, position)
);

ALTER TABLE kunden
	ADD FOREIGN KEY (liefer_addr_id) REFERENCES adressen (addr_id),
	ADD FOREIGN KEY (rechng_addr_id) REFERENCES adressen (addr_id);
	
ALTER TABLE bestellung
	ADD FOREIGN KEY (kunden_id) REFERENCES kunden (kunden_id);
	
ALTER TABLE bestellposition
	ADD FOREIGN KEY (bestell_id) REFERENCES bestellung (bestell_id);