create database tenda;
show databases;
use tenda;
create table client (id integer , nom varchar(30) not null,
llinatge1 varchar(30) not null, llinatge2 varchar(30) not null, 
primary key(id));

insert client (id, nom, llinatge1) values (1,"Joan", "Mora");
select * from client;
show create table client;

create database biblioteca_prova;
use biblioteca_prova;
create table tema(
id integer auto_increment, 
nom varchar(15) not null, 
primary key(id));
 
create table llibre(isbn varchar(20), 
titol varchar(30) not null ,
id_tema integer,
 foreign key (id_tema) references tema(id));
USE BIBLIOTECA;

create table AUTOR(
nom varchar(15) primary key not null,
llin1 varchar(15) not null,
llin2 varchar(15));

create table LLIBRE(
nom varchar(15) primary key null,
isbn varchar(15),
codi varchar(15), foreign key(nom) references AUTOR(nom));

create table TEMA (
nom varchar(15) null,
foreign key(nom) references LLIBRE(nom) );

create table PRESTATGE (
nom varchar(15),
foreign key(nom) references TEMA(nom));

create database videoclub;
use videoclub;

create table POBLACIO(nom varchar(15) not null primary key
);

create table CODI_POSTAL(codi varchar(15) primary key,
foreign key(codi) references POBLACIO(nom)
);

create table SOCI(
 dni  varchar(15) primary key,
 nom varchar(15) not null,
 llin1 varchar(15) not null,
 llin2 varchar(15) null,
 tel varchar(9) not null,
 direcio varchar(15),
 foreign key(dni) references CODI_POSTAL(codi));
 
 create table LLOGUER(
 data_ini varchar(15) primary key,
 data_dev varchar(15),
 foreign key(data_ini) references SOCI(dni));
 
 create table PELICULA(
 id varchar(15) primary key,
 titol varchar(15),
 foreign key(id) references LLOGUER(data_ini));
 
 create table PERSONA(
 nom varchar(15) primary key not null,
 llin1 varchar(15) not null,
 llin2 varchar(15) null,
 foreign key(nom) references PELICULA(id),
 foreign key(nom) references PELICULA(id));
 
 
 
 
 
