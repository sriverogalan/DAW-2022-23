create database prova;
use prova;
create table client (id int primary key, nom varchar(30) not null); -- crear taula
insert into client (id, nom) values(1,"Joan"); -- insertar valors a la taula

alter table client add column llinatge1 varchar (30) not null; -- afegir columnes
alter table client add column llinatge2 varchar (30); -- afegir columnes

alter table client modify column llinatge1 varchar (50) not null; -- modificar columnes
alter table client modify column llinatge2 varchar (2); -- modificar columnes

rename table client to cliente; -- modificar client a cliente
alter table client add column punts int; -- afegir columna punts
alter table client drop column punts;  -- borrar columna

set sql_safe_updates = 0; -- si surt error a nes updates se posa aixo per que funcini

describe client; -- veure columnes
select * from client; -- veure dades insertades
show create table client; -- se pot veure el codi creat 

update client set llinatge1="Mora" where id=1; -- añadir camps
update client set llinatge2="Adrover" where id=1; -- añadir camps
update client set llinatge2="A" where id=1; -- añadir camps

-- drop i constraint


