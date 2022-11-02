drop database Biblioteca;
create database Biblioteca;
use Biblioteca;

create table LLOC(codi int primary key);


create table LLIBRE(codi int primary key,
ISBN varchar(20),
titol varchar(15) not null,
codiLloc int auto_increment  not null,
foreign key (codiLloc) references LLOC(codi));

create table TEMA(codi int primary key, nom varchar(15));

create table AUTOR(codi int auto_increment primary key,
nom varchar(15) not null,
llinatge1 varchar(15) not null,
llinatge2 varchar(15) null);

create table TEMA_LLIBRE(codiLLibre int, codiTema int,
foreign key (codiLlibre) references LLIBRE(codi),
foreign key (codiTema) references TEMA(codi),
primary key (codiLlibre, codiTema));

create table LLIBRE_AUTOR(codiAutor int,
codiLLibre int,
primary key (codiAutor, codiLlibre),
foreign key (codiAutor) references AUTOR(codi),
foreign key (codiLLibre) references LLIBRE(codi));



