-- oracle sql

CREATE TABLE Competicao (
    competicao_id          INTEGER,
    nome             CHAR(11) NOT NULL,
    descricao VARCHAR(160),
    CONSTRAINT COMPETICAO_PK         PRIMARY KEY (competicao_id)
);

ALTER TABLE Competicao ADD new_column NUMBER

ALTER TABLE Competicao ADD CONSTRAINT new_column CHECK (new_column > 0)

CREATE SEQUENCE COMPETICAO_SEQUENCE 
START WITH 0 
INCREMENT BY 1 
MAXVALUE 500 
MINVALUE 0 
NOCYCLE;
