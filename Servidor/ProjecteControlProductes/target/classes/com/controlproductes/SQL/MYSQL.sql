Drop database Botiga;
CREATE DATABASE Botiga;

USE Botiga;

CREATE TABLE articles(
     id INT NOT NULL AUTO_INCREMENT,
     nom VARCHAR(50) NOT NULL,
     descripcio VARCHAR(100) NOT NULL,
     preu FLOAT NOT NULL,
     PRIMARY KEY (id)
);

INSERT INTO articles (nom, descripcio, preu) VALUES ('Pantalons', 'Pantalons de llana', 20.00);
INSERT INTO articles (nom, descripcio, preu) VALUES ('Camiseta', 'Camiseta de cotó', 10.00);
INSERT INTO articles (nom, descripcio, preu) VALUES ('Samarreta', 'Samarreta de cotó', 5.00);
INSERT INTO articles (nom, descripcio, preu) VALUES ('Abrigo', 'Abrigo de llana', 30.00);
INSERT INTO articles (nom, descripcio, preu) VALUES ('Pantalons', 'Pantalons de llana', 20.00);
INSERT INTO articles (nom, descripcio, preu) VALUES ('Camiseta', 'Camiseta de cotó', 10.00);