create table KUNDENSTAMM
(
    KUNDENNUMMER    LONG not null,
    ANSPRECHPARTNER VARCHAR(100),
    BLZ             VARCHAR(30),
    EMAIL           VARCHAR(50),
    IBAN            VARCHAR(30),
    KONTO_NR        VARCHAR(30),
    KREDITLIMIT     DOUBLE,
    LAND            VARCHAR(255),
    MOBIL1          VARCHAR(35),
    MOBIL2          VARCHAR(35),
    NAME_ANSCHRIFT1 VARCHAR(255),
    NAME_ANSCHRIFT2 VARCHAR(255),
    NAME_ANSCHRIFT3 VARCHAR(255),
    NAME_ANSCHRIFT4 VARCHAR(255),
    ORT             VARCHAR(255),
    PLZ             INTEGER,
    SIP             VARCHAR(50),
    STRASSE         VARCHAR(255),
    TELEFON         VARCHAR(35),
    TIMESTAMP       TIMESTAMP,
    UMSATZ_JAHR_1   FLOAT,
    UMSATZ_JAHR_2   FLOAT,
    UMSATZ_LFD_JAHR FLOAT,
    PASSWORD        VARCHAR(255),
    ID              INT,
    FIRMENNAME      VARCHAR(255)
);

