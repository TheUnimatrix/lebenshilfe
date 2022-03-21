USE lebenshilfe_essen;

INSERT INTO adressen (strasse, plz, ort) VALUES
	("Augasse 10", "07907", "Schleiz"),
	("Komtursteig 6", "07907", "Schleiz"),
	("Löhmaer Weg 13", "07907", "Schleiz");
	
INSERT INTO kunden (name, liefer_addr_id, rechng_addr_id, email, preisgruppe) VALUES
	("Tagesstätte Schleiz", 1, 2, "ts-scz@example.com", 15),
	("Schleizer Werkstätten gGmbH", 2, 2, "wfbm-scz@example.com", 2),
	("Sebastian", 3, 3, "sg@example.com", 15);