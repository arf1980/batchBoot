CREATE TABLE PERSONA (
	CODICE_FISCALE CHAR(16),
	NOME VARCHAR(50),
	COGNNOME VARCHAR(50),
	DATA_NASCITA DATE,
	COMUNE_NASCITA VARCHAR(50),
	PROVINCIA_NASCITA CHAR(2),
	NAZIONE_NASCITA CHAR(3),
	PRIMARY KEY (CODICE_FISCALE)
);

INSERT INTO PERSONA VALUES ('LNZFNC80T21L378Q', 'FRANCESCO', 'LENZI', '1980-12-21', 'TRENTO', 'TN', 'ITA' );

