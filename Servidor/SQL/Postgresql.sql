CREATE TABLE genere
(
    id     SERIAL          NOT NULL,
    genere VARCHAR(500) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE catalegpelicules
(
    id        SERIAL PRIMARY KEY NOT NULL,
    id_genere INT             NOT NULL,
    director  VARCHAR(500)    NOT NULL,
    titol     VARCHAR(500)    NOT NULL,
    "any"       INT             NOT NULL,
    duracio   INT             NOT NULL,
    FOREIGN KEY (id_genere) REFERENCES genere (id)
);

INSERT INTO genere (genere)
VALUES ('Drama'),
       ('Comedia'),
       ('Acción'),
       ('Terror'),
       ('Ciencia Ficción'),
       ('Fantasía'),
       ('Aventura'),
       ('Romance'),
       ('Musical'),
       ('Thriller'),
       ('Animación'),
       ('Infantil'),
       ('Western'),
       ('Bélica'),
       ('Crimen'),
       ('Documental'),
       ('Biográfica'),
       ('Historia'),
       ('Misterio'),
       ('Guerra'),
       ('Familia'),
       ('Deporte'),
       ('Cortometraje');

INSERT INTO catalegpelicules
VALUES  (DEFAULT, 3, 'Martin afsafa', 'El lobo de Wall Street', 2013, 180),
        (DEFAULT, 5, 'Martin Carreyt', 'El renacido', 2015, 156);


SELECT DISTINCT * FROM catalegpelicules, genere where catalegpelicules.id_genere = genere.id;