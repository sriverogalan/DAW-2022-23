-- 1. crea la base de dades amb el nom “sales”
CREATE DATABASE sales;

-- 2:2. Estableix aquesta base de dades 
-- com a la base de dades per a llançar consultes sql per defecte
USE sales;

-- 3. Crea les taules següents amb les especificaciones detallades		
CREATE TABLE CITY (
	idCity int auto_increment not null primary key,
    codeCity varchar(5) not null unique,
    nameCity varchar(30) not null,
    sizeCity enum('small', 'medium', 'large') DEFAULT 'medium');
    -- or:
    -- primary key(idCity)
    -- unique index(codeCity)

CREATE TABLE CLIENT (
	idCli int auto_increment not null primary key,
    dni varchar(11) not null unique,
    nameCli varchar(30) not null,
    sum1Cli varchar(30) not null,
    sum2Cli varchar(30) DEFAULT null,
    phoneNum bigint DEFAULT null,
    phoneType enum('Landline', 'Mobile') DEFAULT 'Mobile',
    idCity int not null,
    primary key (idCli),
    foreign key (idCity) references CITY(idCity) ON DELETE CASCADE ON UPDATE CASCADE);
    
    -- double(0.1) per guardar numeros decimals
    -- not null -> no contenir nulls
    -- Default 'X' -> Lo que sigui per defecte
    -- enum('x','y') eleccio entre dues coses
    -- int -> numeros 
    -- Varchar -> Caracters i numeros
    -- numeros grosos telefono es bigint
	-- unique a nes final per dir si es unica
    -- PER FER FOREIGN SE POSA FOREIGN KEY ("Nom De Que Se Vol Fer Foreign") 
    -- references TAULA("") 
    -- ON DELETE CASCADE -> Es per borrar en cascada
    -- ON UPDATE CASCADE -> Es per modificar en cascada
    -- seguir taula i posar lo de cascade
    -- numeros grosos bigint
    -- datetime hora actual, localtime hora local
    -- select * from bd; -> mostrar
    -- INSERT INTO BD(TAULES O TAULES ) VALUES ('ESVALOR',null)
    
	-- update taula set nom='valor'where posicioAutoIncrement= valor de sa fila;
    -- DELETE FROM TAULA WHERE key = fila;
    -- replace into Taula('LoQueSeVulguiRemplazar',...) values ('valors');
    
    
CREATE TABLE PRODUCT (
	idPro int auto_increment,
    codePro varchar(5) not null unique,
    namePro varchar(15) not null,
    descriptPro varchar(50),
    pricePro double(10,2) DEFAULT 0);
    
CREATE TABLE PRODUCT_CLIENT (
	idPro int,
    idCli int,
    purchaseDT datetime not null DEFAULT localtime,
    primary key (idPro, idCli),
    foreign key (idPro) references PRODUCT(idPro),
    foreign key (idCli) references CLIENT(idCli) ON DELETE SET DEFAULT ON UPDATE SET DEFAULT;
    
-- 1. executa l'script que has fet per a l'exercici DDL - create_ex – 3_classroom
-- 2. Fes les instruccions necessaries per a insertar la dada següent a les taules

INSERT INTO CITY (codeCity, nameCity, sizeCity) VALUES
	('PMI', 'Palma de Mallorca', 'small'),
    ('VLC', 'Valencia', 'medium'),
    ('MAD', 'Madrid', 'large');
    
INSERT INTO CLIENT (dni, nameCli, sum1Cli, sum2Cli, phoneNum, phoneType, idCity) VALUES
	('11111111A', 'Wendoline', 'Sun', null, '999999999', 'Mobile', 1),
    ('11111112A', 'Mary', 'Moon', 'Garcia', '971002233', 'Landline', 1),
    ('11111113A', 'Charlie', 'Mars', null, null, 'mobile', 2),
    ('11111114A', 'Caroline', 'Cosbi', 'Fernandez', null, 'Mobile', 2),
    ('11111115A', 'Alexandra', 'Brown', null, null, null, 2);
    
INSERT INTO PRODUCT (codePro, namePro, descriptPro, pricePro) VALUES
	('PRO_A', 'Mouse', null, 10.5),
    ('PRO_B', 'Keyboard', null, 20.5),
    ('PRO_C', 'Screen', null, 120.5),
    ('PRO_D', 'CPU', null, 70.5),
    ('PRO_E', 'RAM memory', null, 45.5);
    
INSERT INTO PRODUCT_CLIENT (idPro, idCli, purchaseDT) VALUES
	(1, 1, default),
    (2, 1, default),
    (3, 1, default),
    (4, 1, default),
    (5, 2, default);
/*    
1. executa l'script que has fet per a l'exercici DDL - create_ex – 3_classroom					
2. Fes les instruccions necessaries per a modificar, reemplaçar i esborrar la dada 
resaltada en vermell a les taules següents		
Les instruccions d'esborrament I reemplaç s'han de fer en el ordre indicat. 
Primer l'esborrament I despres el reemplaç
Les de modificació les podeu fer en l'ordre que vullgueu
*/			
UPDATE CLIENT SET sum2Cli = 'Garcia' WHERE idCli = 2;
UPDATE CLIENT SET phoneType = null WHERE idCli = 3;
UPDATE CLIENT SET phoneType = null WHERE idCli = 4;
DELETE FROM CLIENT WHERE idCli = 3;
-- Hi toca haver un replace i un update, però no se pot perque sa linia que se vol fer replace i update, no existeix.
DELETE FROM PRODUCT WHERE idPro = 2;
DELETE FROM PRODUCT_CLIENT WHERE idPro = 3 AND idCli = 1;
REPLACE FROM PRODUCT