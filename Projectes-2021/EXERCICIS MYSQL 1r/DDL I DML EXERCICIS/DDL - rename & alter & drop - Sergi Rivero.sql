-- 1. Renombrar a tbl_client
alter table CLIENT rename tbl_product;

-- 2. Renombrar a phone_num 
-- Modificar el tipus de dades a integer
alter table CLIENT rename column phoneNum TO phone_num;

-- Modificar per defecte se guarda valor 0
-- Fer totes le modificacions d'aquesta columna amb una sola instrucció
alter table CLIENT modify phone_num integer default 0;

-- 3. Modificar no se permet valor nul
alter table CLIENT modify phoneType enum ('Landline', 'mobile') default ('mobile') not null;

-- 4. Afegir columna
-- code_country
-- De tipus de dades per a emmagatzemar caràcters alfanumèrics de màxima llongitut 5.
-- No se permeten valors nulls.
-- És index ùnic
alter table CITY modify code_country varchar(6) not null, add unique indice (code_country); 

-- 5. Esborrar l'index code_country
alter table city drop index indice;

-- 6. Esborrar la columna
alter table PRODUCT_CLIENT drop column purchaseDT;

-- 7. 
-- Esborrar la taula PRODUCT_CLIENT 
drop table PRODUCT_CLIENT;

-- Pots?
-- Si
-- Que hauries de fer I en quin ordre per a poder esborrar aquesta taula PRODUCT_CLIENT 

-- El problema si borram domes una clau primaria, pero com que son foraneas no afecten.


