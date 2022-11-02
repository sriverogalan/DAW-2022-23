drop database bookshop;
create database bookshop;
use bookshop;
create table editorial(
idE int auto_increment primary key,
nameE enum('Rama','Addison','McGraw-Hill', 'paraninfo', 'Anaya') default null,
addressE varchar(25),
cityE int);
drop table bookshop.editorial;

create table city(
idCity int auto_increment primary key,
codeCity enum('PMI','VLC','MAD' ) default null,
nameCity enum('Palma de Mallorca','Valencia','Madrid' ) default null,
sizeCity enum('Large','Medium','Small' ) default null);
drop table city;
create table book(
idB int auto_increment primary key,
titleB varchar(25),
languageB enum('E','S' ) default null,
numPagsB int,
idE int,
foreign key (idE) references editorial(idE) );

insert into editorial (nameE, addressE, cityE)values
("Rama", "144 canillas street", '3'),
("Addison", "4 sunset street", '2'),
("McGraw-Hill", "181 avenue", '1'),
("paraninfo", "8 Goya square", '1'),
("Anaya", "3 sun lane", '2');

select * from bookshop.editorial;

insert into CITY (codeCity, nameCity, sizeCity)values
("PMI", "Palma de Mallorca", 'Small'),
("VLC", "Valencia", "Medium" ),
("MAD", "Madrid", "Large");

select * from bookshop.city;

insert into BOOK (titleB, languageB, numPagsB, idE)values
("BD analysis", "E", 120, 1),
("A guide to SQL", "E", 124, 2),
("BBDD NoSQL", "S", 167, 1),
("ER Model", "E", 94, 1),
("Relational Model", "E", 85, 2);

select * from bookshop.BOOK;
 
-- 1. cartesian product between editorial and city									
SELECT nameE, nameCity
from EDITORIAL, CITY;

-- 2. cartesian product between editorial and book									
SELECT nameE, titleB
from EDITORIAL, BOOK;

-- 3. cartesian product between city and book									
SELECT nameCity, titleB
from CITY, BOOK;

-- 4. inner join between editorial and city. Deliver 2 ways of doing the same									
SELECT EDITORIAL.CityE, CITY.idCity
from EDITORIAL inner join CITY
on EDITORIAL.CityE = CITY.idCity;

-- No es pot fer emprant using perque el nom de les claus no es comú.

-- 5. inner join between editorial and book. Deliver 2 ways of doing the same									
SELECT EDITORIAL.idE, BOOK.idE
from EDITORIAL inner join BOOK
on EDITORIAL.idE = BOOK.idE ;

SELECT EDITORIAL.idE, BOOK.idE
from EDITORIAL inner join BOOK
using (idE);

-- 6. inner join between city and book. Deliver 2 ways of doing the same									
-- No se pot fer amb inner join perque no tenen elements comuns,
--  pero si que se pot fer amb el producte cartesia.

-- 7. What's the difference between cartesian product and inner join?									
-- La diferencia es que el producte cartesià només mos treu el producte cartesià,
--  en canvi, l' inner join mos fa una combinació del producte cartesià amb una selecció.

-- 8. Show the editorial name and the city name where that editorial is Addison									
SELECT nameE, nameCity
from EDITORIAL, CITY having nameE = "Addison";

-- 9. Quantes editorials hi han a cada ciutat. 
-- Mostra l'identificatiu de la ciutat el resultat de la teva funció a una columna amb el titol result									
SELECT count(idE) as result, cityE
from EDITORIAL group by cityE;

-- 10. Igual que l'anterior però el resultat de la funció solament s'ha de mostrar quan hi ha més de 2 editorial a ciutat.									
SELECT count(idE) as result, cityE
from EDITORIAL group by cityE having count(idE) >= 2;

-- 11. Igual que l'anterior però el resultat de la funció solament s'ha de mostrar quan hi ha més de 3 llibres per idioma									
SELECT count(idB) as result, languageB
from BOOK group by languageB;

-- 12. Quina es la mitjana de numero de pagines dels llibres per cada idioma. Mostra l'identificatiu de l'idioma I el resultat de la teva funció a una columna amb el titol result									
SELECT count(idB) as result, languageB
from BOOK group by languageB having count(idB) >= 3;

-- 13. Igual que l'anterior però el resultat de la funció solament s'ha de mostrar quan la mitjana de numero de pagines dels llibres es igual o menor a 167
SELECT avg(numPagsB) as result, languageB
from BOOK group by languageB;

-- 14. Quina es la desviació típica del numero de pagines per editorial? Mostra l'identificatiu de l'editorial I el resultat de la teva funció a una columna amb el titol result									
SELECT floor(avg(numPagsB)) as result
from BOOK group by languageB having avg(numPagsB) < 167;

-- 15. Igual que l'anterior però mostrant el reultat solamnet quan la desviació típica es menor de 20									
SELECT std(numPagsB) as result, idE
from BOOK group by idE having std(numPagsB) < 20 ;

-- 16. igual que el 14 però la desviacio tipica s'ha de calcular solament per als llibres amb numero de pagines major de 90									

SELECT std(numPagsB) as result, idE
from BOOK group by idE having std(numPagsB) >90 ;

-- 17. Igual que 13 però la mijtana de pagines s'ha de calcular solament per als llibres que tinguen menys de 90 pagines I mostrar-se la mitjana solament si es menor de 87									
SELECT avg(numPagsB) as result
from BOOK where numPagsB < 90 group by idB having avg(numPagsB) < 87;

-- 18. Igual que 16 però la desviació típica de pagines s'ha de mostrar solament quan siga major de 30									
SELECT avg(numPagsB) as result
from BOOK group by idB having avg(numPagsB) > 30;

-- 									
SELECT std(numPagsB) as result, idE
from BOOK group by idE having std(numPagsB) < 30;

-- 19. Igual que 17 però la mijtana de pagines s'ha de mostrar sempre independentment de com de gran siga
SELECT avg(numPagsB) as result, idB
from BOOK group by idB;  