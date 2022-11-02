create database videoclub;
use videoclub;

create table POBLACIO (
	id int auto_increment,
	nom varchar(15) not null,
	primary key (id));

insert into videoclub.poblacio values (null, "Manolito");
insert into videoclub.poblacio values (null, "Pedro");

create table CODI_POSTAL (
	codi varchar(5), 
	id_poblacio int, 
	primary key (codi), 
	foreign key (id_poblacio) references POBLACIO(id));
    
    describe codi_postal;
    show create table codi_postal;
    

insert into videoclub.codi_postal values ("07458", 1);
insert into videoclub.codi_postal values ("07450", 2);

alter table videoclub drop column codi_postal;


create table SOCI (
	dni varchar(9), 
	nom varchar(15) not null, 
	llinatge1 varchar(15) not null, 
	llinatge2 varchar(15) null, 
	telefon varchar(9), 
	adreca varchar(45), 
	codi_postal varchar(5) not null, 
	primary key (dni), 
	foreign key (codi_postal) references CODI_POSTAL(codi));



create table PERSONA (
	id int, 
	nom varchar(15) not null, 
	llinatge1 varchar(15) not null, 
	llinatge2 varchar(15) null, 
	primary key (id));

create table PELICULA (
	id int, 
	titol varchar(15) not null, 
	id_director int, 
	primary key (id), 
	foreign key (id_director) references PERSONA(id));

create table ACTUA (
	id_actor int, 
	id_pelicula int,
	primary key (id_actor, id_pelicula),
	foreign key (id_actor) references PERSONA(id), 
	foreign key (id_pelicula) references PELICULA(id));

create table LLOGUER (
	data_inici date, 
	data_devolucio date, 
	dni_soci varchar(9), 
	id_pelicula int, 
	primary key (dni_soci, id_pelicula, data_inici), 
	foreign key (dni_soci) references SOCI(dni), 
	foreign key (id_pelicula) references PELICULA(id));




