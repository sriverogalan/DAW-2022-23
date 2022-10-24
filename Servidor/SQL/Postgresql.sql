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
INSERT INTO catalegpelicules
VALUES  (DEFAULT, 1, 'Martin Scorsese', 'El lobo de Wall Street', 2013, 180),
        (DEFAULT, 1, 'Martin Scorsese', 'El irlandés', 2019, 209),
        (DEFAULT, 1, 'Martin Scorsese', 'Casino', 1995, 178),
        (DEFAULT, 1, 'Martin Scorsese', 'Taxi Driver', 1976, 113),
        (DEFAULT, 1, 'Martin Scorsese', 'Shutter Island', 2010, 138),
        (DEFAULT, 1, 'Martin Scorsese', 'El aviador', 2004, 170),
        (DEFAULT, 1, 'Martin Scorsese', 'El color del dinero', 1986, 119),
        (DEFAULT, 1, 'Martin Scorsese', 'Gangs of New York', 2002, 167),
        (DEFAULT, 1, 'Martin Scorsese', 'El renacido', 2015, 156);

SELECT DISTINCT * FROM catalegpelicules, genere where catalegpelicules.id_genere = genere.id;