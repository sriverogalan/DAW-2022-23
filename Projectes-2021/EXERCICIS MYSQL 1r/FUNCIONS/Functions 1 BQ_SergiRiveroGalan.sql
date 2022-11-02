
-- 1. PRODUCT					

-- 1. Ompli els valors de pricePro amb 1 simbol $ a la dreta. Per a totes les files de la taula. La columna s'ha de veure amb el nom result							
select * from sales.product;

select concat(pricePro, ' $') as result, pricePro from sales.product;
select rpad(pricePro, length(pricePro) + 2 , ' $') as result, pricePro from sales.product;
select lpad(pricePro, length(pricePro) + 2 , 'P ') as result, pricePro from sales.product;

-- 2. Modifica els valors dels preus tal com estan tal com estan resaltats en color verd														
update product set pricePro="10.554" where idPro=1 ;
update product set pricePro="20.432" where idPro=2 ;
update product set pricePro="120.712" where idPro=3 ;
update product set pricePro="70.103" where idPro=4 ;
update product set pricePro="45.871" where idPro=5 ;

-- 3. Mostra el pricePro solament amb 2 decimals 				 
select truncate(pricePro,2) as result from product;
-- 4. Mostra el pricePro fent el redondeig cap amunt. La funció retorna un numero enter														
select ceiling(pricePro) as result, pricePro from sales.product;

-- 5. Mostra el pricePro fent el redondeig cap a baix. La funció retorna un numero enter														
select floor(pricePro) as result, pricePro from sales.product;

-- 6. Mostra el pricePro fent el redondeig cap amunt o cap a baix amb la mateixa funció amb 2 d ecimals														
select round(truncate(pricePro, 2)) as result, pricePro from sales.product;

-- 7. Mostra el pricePro en valor absolut														
select abs(pricePro) as result, pricePro from sales.product;
 
-- 8. Mostra el signe del pricePro														
select sign(pricePro) as result, pricePro from sales.product;

-- 9. Mostra el el valor de la constant PI														
select pi() as result ;

-- 10. Mostra el resultat de la operació 3 elevat a 2														
select power(3,2) as result ;
select pow(3,2) as result ;
-- 11. Mostra el IVA del pricePro sabent que el iva es un 21%														
select pricePro * 0.21 as result from sales.product;

-- 12. Mostra el pricePro amb el 21% de iva sumat														
select pricePro * 1.21 as result from sales.product;

-- 13. Mostra el resultat de la operació 3 + 2														
select 3 + 2 as resultat;

-- 14. Mostra el resultat de la operació 3 * 2														
select 3 * 2 as resultat;

-- 15. Mostra el residu de la divisió de 3 entre 2 amb dues formes diferents														
select 3 % 2 as resultat;


-- 16. Mostra el resultat de la divisió entera de 10 entre 3														
select round(10 / 3) as resultat;
														

-- RANDOM														

-- 1. Genera un random o numero aleatori entre 0 i 1														
SELECT FLOOR(RAND()*(1-0));
SELECT RAND()*1; ;

-- 2. Genera un random o numero aleatori entre 18 i 65														
SELECT floor(rand()*(65-18)) as result ;

SELECT FLOOR(7 + (RAND() * 5));

-- 2. CITY														

-- 1. Ompli els valors de codeCity amb 1 simbol & a l'esquerra. Per a totes les files de la taula. La columna s'ha de veure amb el nom result														
select concat('&',codeCity) as result from sales.city;
select lpad(codeCity,length(codeCity)+1,'&') as result from sales.city;

-- 2. Elimina els espais pels costats que pugueren haver a la columna nameCity. Per a totes les files de la taula. La columna s'ha de veure amb el nom result														
select trim(nameCity) as result from sales.city;
select ltrim(nameCity) as result from sales.city;
select rtrim(nameCity) as result from sales.city;

-- 3. Mostra els caracters de la columna sizeCity des de la posició 2. Per a totes les files de la taula. La columna s'ha de veure amb el nom result														
select substring(sizeCity,2) as result from sales.city  ; 

-- 4. Mostra els caracters de la columna sizeCity des de la posició 2 fins a la posició 5. Per a totes les files de la taula. La columna s'ha de veure amb el nom result														
select substring(sizeCity, 2, 3) as result from sales.city  ; 

-- 5. Mostra els caracters de la columna nameCIty des del principi fins al primer espai solament per al idCity 1. La columna s'ha de veure amb el nom result														
select substring_index(nameCity, ' ',1) as result from sales.city where idCity=1 ; 

-- 6. Mostra els caracters de la columna nameCIty des del final fins al darrer espai solament per al idCity 1. La columna s'ha de veure amb el nom result														
select substring_index(nameCity, ' ', -1) as result from sales.city where idCity=1 ; 

														

-- 4. CLIENT														

-- 1.Enmascara amb el caracter * des de la posició 3 a la posició 9 del DNI de totes les files de la taula														
select rpad((Select Left(dni,3)),9,'*') as result from client;
select insert(dni,4,9, '******') as result from client; 

-- 2.Mostra solament les 3 primeres cifres del telèfon que corresponen al prefixe														
select left(phoneNum,3) as result, phoneNum from sales.client;

														

-- 5. PRODUCT-CLIENT														

-- 1. Fomatetja purchaseDT per a que se mostre en el següent format: Friday the 6th of February														
select date_format(purchaseDT, '%W the %D of %M') as purchaseDT from sales.product_client;

-- 2. Fomatetja purchaseDT per a que se mostre en el següent format: Friday the 6 of February at 19 hour 23 minutes and 55 seconds														
select date_format(purchaseDT, '%W the %D of %M at %h hour %i minutes %s seconds') as purchaseDT from sales.product_client;

-- 3. Fomatetja purchaseDT per a que se mostre en el següent format: Friday 6 February (19:23:55)														
select date_format(purchaseDT, '%W %D %M (%h:%i:%s)') as purchaseDT from sales.product_client;

-- 4. Fomatetja purchaseDT per a que se mostre en el següent format: Friday 6 February at 7:23:55 pm or Friday 6 February at 7:23:55 am segons la dada. Modifica algun registre per a que se mostren AM I PM														
select date_format(purchaseDT, '%W %D %M at %h:%i:%s %p') as purchaseDT from sales.product_client;
select date_format(purchaseDT, '%W %d %M at %r') as purchaseDT from sales.product_client;

-- 5. Fomatetja purchaseDT per a que se mostre en el següent format: Friday % 6th % February														
select date_format(purchaseDT, '%W %% %D %% %M') as purchaseDT from sales.product_client;

-- 6. Modifica el formateig del punt 1 per a que se el dia de la setmana I el mes se mostren en format curt o abreviat														
select date_format(purchaseDT, '%a the %D of %b') as purchaseDT from sales.product_client;


-- 7. Modifica el formateig del punt 3 per a que el mes se mostre en numero de dues cifres en lloc de en lletres														
select date_format(purchaseDT, '%a %D %m (%h:%i:%s)') as purchaseDT from sales.product_client;


-- 8. El mateix que al punt 7 pero en numero de una cifra per als mesos de gener a novembre I la resta de dues cifres 														
select date_format(purchaseDT, '%W %e %c (%h:%i:%s)') as purchaseDT from sales.product_client;

-- 9. Modifica el formateig del punt 3 per a que per a que les hores se mostren en format de 0 a 12 hores														
select date_format(purchaseDT, '%W %D %M (%l:%i:%s)') as purchaseDT from sales.product_client;


-- 10. Fomatetja purchaseDT per a que solament se mostre el time I en aquest format ja preformatejat a Mysql hh:mm:ss AM o PM. On les hores son de 0 a 12														
select date_format(purchaseDT, ' %r') as purchaseDT from sales.product_client;

-- 11. El mateix que al punt 10 però en aquest format ja preformatejat a Mysql hh:mm:ss AM o PM. On les hores son de 0 a 24														
select date_format(purchaseDT, ' %T ') as purchaseDT from sales.product_client;

-- 12. Fomatetja purchaseDT per a que solament se mostre el dia que es del l'any														
select date_format(purchaseDT, ' %j ') as purchaseDT from sales.product_client;

-- 13. Fomatetja purchaseDT per a que solament mostre la sermana de l'any començant en dilluns														
select date_format(purchaseDT, ' %u ') as purchaseDT from sales.product_client;
														

-- DATE TIME functions of Mysql without table														

-- 1. Mostra la data actual amb 2 funcions diferents														
select current_timestamp();
select now();
select current_timestamp(),now();
  
-- 2. Mostra el temps actual														
select current_time();
-- 3. Mostra la data hora actual amb 2 funcions diferents														
select current_time();
select date_format(now(),'%h:%i:%s');
-- 4. Mostra el dia de la setmana en lletres de data hora actual 														
  select dayofweek();
-- 5. Mostra el dia de la setmana en numero de data hora actual 														
   select dayofweek(now());