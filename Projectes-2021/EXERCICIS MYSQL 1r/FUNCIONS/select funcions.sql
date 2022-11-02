-- STRINGS

SELECT char_length('MySQL'); -- ES PER CERCAR LA PARAULA MySQL

SELECT char_length(intensity) as result, intensity
from centers.activity ;

-- as es per donarli nom a la taula de les lletres que te intensity, 
-- i despres posam intensity per que mos mostri sa taula

select INSTR('MySQL',''); 
-- te diu en quina posicio esta el caracter de la dreta,
-- comença a contar com no array

SELECT INSTR(intensity, 'o') as result, intensity
from centers.activity; 
-- te diu en quina posicio esta el caracter de la dreta,
-- comença a contar com no array o sigui per 1

SELECT strcmp('abc','def'); -- SE USA PER SABER SI SON IGUALS 
SELECT strcmp('def','abc'); -- SE USA PER SABER SI SON IGUALS
SELECT strcmp('abc','abc'); -- Si surt 0 son iguals

SELECT strcmp(intensity, 'high') as result, intensity
from centers.activity; -- mos diu quins high son igual

SELECT REVERSE('MySQL') as result; -- mos gira sa paraula
SELECT REVERSE(intensity) as result, intensity
from centers.activity;

SELECT left('MySQL', 4); -- left comença a contar de la esquerra fins a 4

SELECT LEFT(intensity, 3) from centers.activity; -- comença a contar per l'esquerra fins a 3

SELECT RIGHT('MySQL', 4); -- left comença a contar de la esquerra

SELECT RIGHT(intensity, 3) from centers.activity; -- comença a contar per l'esquerra fins a 3

SELECT CONCAT('A', '-', 'Z') as result; -- CONCATENAR LA CADENA 

SELECT CONCAT(idActivity, ' & ', intensity) as result, intensity
from centers.activity;

SELECT lower('PASDPASDPASPDASKDPA') ; -- Posa minuscula
SELECT UPPER('asdasdasdsadasfasf') ; -- Posa majuscula

SELECT lpad('MySQL', 8,'-'); -- añade tantos "lo que pongas" a la izquierda como necesite hasta completar las 8 posiciones
SELECT rpad('MySQL', 8,'-'); -- añade tantos "lo que pongas" a la derecha como necesite hasta completar las 8 posiciones

select trim(' high     ') as result, '     high           '  from centers.activity; -- trim lleva espais

select substring('MySQL', 3,1); -- comienza a contar a partir de la 3 posicion
select substring(intensity,2,6) as result from activity; -- lo mismo limite los lados del 2 al 6

select substring_index('training@mysql.com', '@', 3 ); -- imprime hasta el @ o al que le pongamos por parametro en la segunda opcion
select substring_index('training@mysql.com', '@', -1 ); -- si es - empieza por el final


-- FUNCIONS TEMPORALS
-- 1. select columnes
-- 2. from taules
-- 3. (opcional) where <>=!= not int , is not null, and, or, like not like, in ----
-- 4. (opcional) order by columna asc o desc segons
-- 5. limit

select curdate(), curtime(), dayname(now()), now(); -- curdate = dia que esteim, curtime = hora que esteim, dayname(now()) = nom des dia d'avui, now() = dia i hora d'ara 

select current_date, curdate(), curtime(), dayname(now());

select dayname(nameP), year(nameP), month(nameP) from centers.plant;


select now(), now() + interval 10 day; -- suma 10 dies a la data que hi havia
select now(), now() + interval -10 day; -- resta 10 dies a la data que hi havia

-- DATE FORMAT

select now(), date_format(now(), '%W the %D of %M'); 

select now(), date_format(now(), '%w the %d of %m'); 

select now(), date_format(now(), '%d the %m of %y'); 
