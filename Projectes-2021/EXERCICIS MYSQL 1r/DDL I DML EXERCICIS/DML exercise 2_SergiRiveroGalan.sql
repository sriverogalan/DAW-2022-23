drop database centers;
-- Crea una base de dades :
create database centers;
-- 1. using multiple insert	
use centers;
-- Crear una taula Activity:
create table ACTIVITY(
idActivity int not null auto_increment ,
intensity varchar(15) not null,
primary key(idActivity));

create table PLANT(
codeP char(3) not null,
nameP varchar(7),
typeP varchar(15),
primary key(codeP));

create table WORK_CENTER(
codeWC char (4),
function_ varchar (15),
capacity integer null);

insert into centers.activity(intensity) values ('high');
insert into centers.activity(intensity) values ('high');
insert into centers.activity(intensity) values ('high');
insert into centers.activity(intensity) values ('medium');
insert into centers.activity(intensity) values ('medium');
insert into centers.activity(intensity) values ('medium');
insert into centers.activity(intensity) values ('low');
insert into centers.activity(intensity) values ('low');
insert into centers.activity(intensity) values ('low');
insert into centers.activity(intensity) values ('other');

insert into centers.plant(codeP, nameP, typeP) values ('P_A','plant_A','circular');
insert into centers.plant(codeP, nameP, typeP) values ('P_B','plant_B','circular');
insert into centers.plant(codeP, nameP, typeP) values ('P_C','plant_C','circular');
insert into centers.plant(codeP, nameP, typeP) values ('P_D','plant_D','square');
insert into centers.plant(codeP, nameP, typeP) values ('P_E','plant_E','square');
insert into centers.plant(codeP, nameP, typeP) values ('P_F','plant_F','square');
insert into centers.plant(codeP, nameP, typeP) values ('P_G','plant_G','triangular');
insert into centers.plant(codeP, nameP, typeP) values ('P_H','plant_H','triangular');
insert into centers.plant(codeP, nameP, typeP) values ('P_I','plant_I','triangular');
insert into centers.plant(codeP, nameP, typeP) values ('P_J','plant_J','other');

insert into centers.work_center(codeWC, function_, capacity) values ('WC_A','supervision',30);
insert into centers.work_center(codeWC, function_, capacity) values ('WC_B','supervision',35);
insert into centers.work_center(codeWC, function_, capacity) values ('WC_C','supervision',40);
insert into centers.work_center(codeWC, function_, capacity) values ('WC_D','infrastructure',30);
insert into centers.work_center(codeWC, function_, capacity) values ('WC_E','infrastructure',35);
insert into centers.work_center(codeWC, function_, capacity) values ('WC_F','infrastructure',40);
insert into centers.work_center(codeWC, function_, capacity) values ('WC_G','development',30);
insert into centers.work_center(codeWC, function_, capacity) values ('WC_H','development',35);
insert into centers.work_center(codeWC, function_, capacity) values ('WC_I','development',40);
insert into centers.work_center(codeWC, function_, capacity) values ('WC_J','other', NULL);

use centers;

-- 0. Create table 

create table ROUTING(
idR int auto_increment not null,
statusR varchar(15),
primary key (idR));

-- 1. Using Multiple insert

insert into centers.routing(statusR) values 
('up'), ('up'), ('up'), ('up'),
('down'), ('down'), ('down'), ('down'), 
('other'), ('other');

-- 2. Create table 

create table MATERIAL(
idMaterial int auto_increment not null,
NameM enum('paper','plastic','metal','other') not null  default 'paper',
primary key (idMaterial));

-- 3. Insert values using multiple insert 

insert into centers.material(NameM) values 
('paper'), ('paper'), ('paper'),
('plastic'), ('plastic'), ('plastic'),
('metal'), ('metal'), ('metal'),
('other');

create table MATERIAL_EXTERNAL(
idMaterial int auto_increment not null,
Provider char(15) , 
primary key (idMaterial, Provider));

insert into centers.material_external(Provider) values 
('Prov_ext_1'), ('Prov_ext_2'), ('Prov_ext_3'),
('Prov_ext_4'), ('Prov_ext_5'), ('Prov_ext_6'),
('Prov_ext_7'), ('Prov_ext_8'), ('Prov_ext_9'),
('Prov_ext_10');

create table MATERIAL_INTERNAL(
idMaterial int auto_increment not null,
Departament char(15),
primary key (idMaterial));

insert into centers.material_internal(Departament) values 
('Dep_int_1'), ('Dep_int_2'), ('Dep_int_3'),
('Dep_int_4'), ('Dep_int_5'), ('Dep_int_6'),
('Dep_int_7'), ('Dep_int_8'), ('Dep_int_9'),
('Dep_int_10');


-- 4. Update
update routing set statusR='down'
where idr=1;

update routing set statusR='down'
where idr=4;

update routing set statusR='up'
where idr=5;

update routing set statusR='other'
where idr=6;

update routing set statusR='up'
where idr=7;

update routing set statusR='other'
where idr=8;

update routing set statusR='up'
where idr=9;

update routing set statusR='up'
where idr=10;

-- 5. Update

update material set NameM='metal'
where idMaterial=1;

update material set NameM='paper'
where idMaterial=4;

update material set NameM='plastic'
where idMaterial=7;

update material set NameM='other'
where idMaterial=9;

update material set NameM='paper'
where idMaterial=10;

-- 6. Replace

replace into routing(idR,statusR) values (2, 'other');
replace into routing(idR,statusR) values (3, 'down');

-- 7. Replace

replace into material(idMaterial,NameM) values (2, 'metal');
replace into material(idMaterial,NameM) values (3, 'other');

-- 8. delete

delete from routing 
where idr='5';

delete from routing 
where idr='8';

-- 9. delete

delete from material 
where idMaterial='6';

delete from material 
where idMaterial='8';


-- 10. update

update material_external set Provider='Prov_ex1'
where idMaterial=2;

update material_external set Provider='Prov_ex3'
where idMaterial=4;

update material_external set Provider='Prov_ex1'
where idMaterial=7;

update material_external set Provider='Prov_ex5'
where idMaterial=10;

-- 11. update

update material_internal set Departament='Dep_int_1'
where idMaterial=2;

update material_internal set Departament='Dep_int_3'
where idMaterial=4;

update material_internal set Departament='Dep_int_1'
where idMaterial=7;

update material_internal set Departament='Dep_int_5'
where idMaterial=10;


-- 12. replace

replace into material_external(idMaterial,Provider) values (1, 'Prov_ext_10');
replace into material_external(idMaterial,Provider) values (6, 'Prov_ext_3');

-- 13. replace

replace into material_internal(idMaterial,Departament) values (1, 'Prov_ext_10');
replace into material_internal(idMaterial,Departament) values (6, 'Prov_ext_3');

-- 14. delete

delete from material_external 
where IdMaterial='5';

delete from material_external 
where IdMaterial='9';

-- 15. delete

delete from material_internal 
where IdMaterial='3';

delete from material_internal 
where IdMaterial='5';

delete from material_internal 
where IdMaterial='9';












