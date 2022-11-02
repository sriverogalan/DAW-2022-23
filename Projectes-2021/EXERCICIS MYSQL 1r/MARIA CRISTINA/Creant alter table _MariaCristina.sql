use prova;
create table ciutat (id integer, nom varchar(30)); -- crear taula
create table client (id integer, nom varchar(30) not null, llin1 varchar(30) not null, llin2 varchar(15) null); -- crear taula -- 

insert into ciutat values (1, "Porreres");
insert into client values (1, "Maria", "Cristina","Moyà");

/* Afegir clau primaria */
alter table ciutat add primary key (id);
alter table client add primary key (id);

/* Comprovar si se ha afegit */
describe ciutat;
describe client;

/* Afegir foreign key dins client de ciutat */
alter table client add column id_ciutat integer;
/* La seguent instuccio dona erro perque ja hi ha registres amb ciutat null */
alter table client modify column id_ciutat integer not null;

/* Afegim la foreign key */
alter table client add foreign key (id_client) references ciutat(id);
insert into client(id, nom, llin1, llin2) values (2, "Joana","Maria","Serra");
/* El seguent registre no el deixa introduir perque no existeix la ciutat 2 */
insert into client(id, nom, llin1, llin2) values (2, "Joana","Maria","Serra",2);
/* Introduim un valor fictici de ciutat a tots els registres de client per tal de no tenir cap registre amb la ciutat nulla */
insert into ciutat(id,nom) values (2,"Ficticia");
SET SQL_SAFE_UPDATES = 0; -- si esta a 1, no deixa fer updates i l'he de posar a 0
update client set id_ciutat=2;
/* Ara si que puc afegir que el camp ciutat és not null */
alter table client modify column id_ciutat integer not null;

/* Ara faltarien els diferents updates 

aprendre a menejar create, alter, tables sense solventaro creat i editant, practicar a muerte es exercicis */

