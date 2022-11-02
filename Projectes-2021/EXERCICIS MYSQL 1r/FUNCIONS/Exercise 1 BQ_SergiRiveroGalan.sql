drop database centers;
create database centers;
use centers;

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

insert into centers.work_center(codeWC, function_, capacity) values ('WC_A','supervision','30');
insert into centers.work_center(codeWC, function_, capacity) values ('WC_B','supervision','35');
insert into centers.work_center(codeWC, function_, capacity) values ('WC_C','supervision','40');
insert into centers.work_center(codeWC, function_, capacity) values ('WC_D','infrastructure','30');
insert into centers.work_center(codeWC, function_, capacity) values ('WC_E','infrastructure','35');
insert into centers.work_center(codeWC, function_, capacity) values ('WC_F','infrastructure','40');
insert into centers.work_center(codeWC, function_, capacity) values ('WC_G','development','30');
insert into centers.work_center(codeWC, function_, capacity) values ('WC_H','development','35');
insert into centers.work_center(codeWC, function_, capacity) values ('WC_I','development','40');
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
NameM enum('paper','plastic','metal','other') not null  default('paper'),
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


-- ------------------------------------------------------------------------- -- 
-- ------------------------------------------------------------------------- --

-- 1. list all columns of activities									
select * from centers.activity;

-- 2. list all columns of activities but only for high intensity									
select intensity 
from centers.activity
where intensity='high';

select intensity 
from centers.activity
where intensity='high';

-- 3. list all columns of activities but only for high or medium intensity									
select intensity 
from centers.activity
where intensity='high' or intensity='medium'; -- tambe podriem possar where intensity= in('high','medium')
 
-- 4. list only the intensity column of activities without repeated values in alphabetic order of the intensity (ascendant)
select distinct intensity 
from centers.activity
order by intensity asc;

-- 5. list only the intensity column of activities in alphabetic order of the intensity (descendant)									
select intensity 
from centers.activity
order by intensity desc;

-- 6. list the idActivity and intensity column of the activities with the id greater than 2									
select idActivity, intensity
from centers.activity
where idActivity<2;

-- 7. list the idActivity and intensity column of the activities with the id lower than 7 in alphabeic order of the intensity (descendant)									
select idActivity, intensity
from centers.activity
where idActivity > 7
order by idActivity desc;

-- 8. list the idActivity and intensity column of the activities with the id greater than 2 and lower than 7 in alphabeic order of the intensity (ascendant)									
select idActivity, intensity
from centers.activity
where idActivity >2 <7
order by idActivity asc;

-- 9. list the idActivity and intensity column of the activities with the id in the list of ids 2 ,6, 8
select idActivity, intensity
from centers.activity
where idActivity in (2,6,8);

-- 10. list the idActivity and intensity column of the activities with the id in the list of ids 2 ,6, 8 in alphabeic order of the intensity (ascendant)
select idActivity, intensity
from centers.activity
where idActivity in (2,6,8)
order by idActivity asc;

-- 11. list all columns of activities from row 5 give 2 rows									
select * from activity limit 5, 2;

-- 12. list the intensity column of activities sense valors repetits
select distinct intensity from activity;

-- 13. list the intensity column of activities sense valors repetits from row 5 give 2 rows
select distinct intensity from activity limit 3;

-- 14. list the intensity column of activity
select distinct intensity from activity order by intensity asc limit 2,1;

-- 15. list the 3 first rows of the intensity column of activities sense valors repetits in alphabeic order of the intensity (descendant)
select distinct intensity from activity order by intensity desc limit 3 ;

-- --------------------------------------------------------------------- --
-- --------------------------------------------------------------------- --

-- 1. llista totes les columnes ordenades alfabeticament de forma ascendent pel codeWC
select codeWC 
from centers.work_center
order by codeWC asc;

-- 2. llista totes les columnes ordenades alfabeticament de forma descendent pel codeWC	
select codeWC 
from centers.work_center
order by codeWC desc;

-- 3. llista la columna functionWC mostrant els valors sense duplicats ordenades alfabeticament de forma ascendent pel camp functionWC
select distinct function_ 
from centers.work_center
order by function_ asc;

-- 4. llista la columna capacity mostrant els valors sense duplicats ordenades alfabeticament de forma ascendent pel camp capacity
select distinct function_ 
from centers.work_center
order by function_ desc;
			
-- 5. llista la columna capacity mostrant els valors sense duplicats I sense cap valor null ordenades alfabeticament de forma descendant pel camp capacity
select distinct capacity
from centers.work_center
where capacity is not null
order by capacity desc;

-- 6. llista totes columnes dels centres de feina que tenen valor null a la capacitat
select * from work_center
where capacity is null;

-- 7. llista totes les columnes dels centres de feina que tenguin una capacitat entre 10 I 39
select * from work_center
where capacity >= 10
and capacity <= 39;		
-- where capacity between 10 and 39;

-- 8. llista totes les columnes dels centres de feina que tenguin una capacitat entre 10 I 39 ordenades alfabeticament de forma ascendent per la capacitat
select * from work_center
where capacity >= 10
and capacity <= 39
order by capacity asc;
					
-- 9. llista la capacitat dels centres de feina sense duplicats que tenguin una capacitat entre 33 I 50 ordenades alfabeticament de forma descendent per la capacitat
select * from work_center
where capacity >= 33
and capacity <= 50 
order by capacity desc;

-- 10. llista totes les columnes dels centres de feina que tenguin una capacitat que se trobi a la llista 30,33,35,36
select * from work_center
where capacity in (30,33,35,36)
order by capacity asc;
-- tambe se podria possar a where capacity 30 or 33 or 35 or 36 lo que no es tant eficient

-- 11. llista el camp functionWC sense duplicats de tots els centres de feina que tenguin una capacitat de 30
select distinct function_
from centers.work_center
where capacity = 30;
		
-- 12. llista el camp functionWC sense duplicats de tots els centres de feina que tenguin una capacitat de 30 o valor null
select distinct function_
from centers.work_center
where capacity in (30, null);
					
-- 13. llista el camp functionWC sense duplicats de tots els centres de feina que tenguin una capacitat diferent de 35
select distinct function_
from centers.work_center
where capacity != 35;
-- where not (capacity = 30); es una altre manera de fer-ho
-- 14. llista tots els camps de tots els centres de feina que tenguin una capacitat diferent de 30 I major de 35
select distinct *
from centers.work_center
where capacity != 30
and capacity>35;

-- 15. llista tots els camps de tots els centres de feina que tenguin el camp functionWC que comence per infra									
select * from centers.work_center where function_ like 'infra%';

-- 16. llista tots els camps de tots els centres de feina que tenguin el camp functionWC que acaben en ment									
select * from centers.work_center where function_ like '%ment';

-- 17. llista tots els camps de tots els centres de feina que tenguin el camp functionWC que contingan el fragment lop al mig de la paraula									
select * from centers.work_center where function_ like '%lop%';

-- 18. llista tots els camps de tots els centres de feina que tenguin el camp functionWC que comencen per supervisio I solament hi hagi un caracter mes per a acabar la paraula		
select * from centers.work_center where function_ like 'supervisio_';	


-- --------------------------------------------------------------------- --
-- --------------------------------------------------------------------- --

-- 1. Convert to capital letters the column typeP of the codeP with value P_A. Show it in a column named result.. Moreover the column typeP has to be shown also									
select upper(typeP) as result, typeP from centers.plant  where codeP='P_A' ; -- despres order by , i despres limit

-- 2. Re-do the point above but using a diferent function
select ucase(typeP) as result, typeP from centers.plant;
									
-- 3. Convert to lower case letters the column typeP only when the codeP is P_B. Show it in a column named result. Moreover the column typeP has to be shown also									
select lower(typeP) as result from centers.plant  where codeP='P_B';
select lower(typeP) as result from centers.plant  where codeP like('P_B');
select lower(typeP) as result from centers.plant  where codeP in ('P_B');
-- 4. Re-do the point above but using a diferent function	
select lower(typeP) as result, typeP from centers.plant  where codeP='P_A' ; -- despres order by , i despres limit

-- 5. Show the length of typeP in a column named result only when the codeP is P_B									
select lower(typeP) as result, typeP from centers.plant  where codeP='P_B' ; -- despres order by , i despres limit

-- 6. Search the string lar of the typeP and show in with position starts in the string. Show it in a column named result only for the codeP with value P_A									
select ucase(typeP) ; -- despres order by , i despres limit


-- 7. Search the string u of the typeP and show in with position starts in the string. Show it in a column named result for all values of codeP column									
select instr(typeP, 'u') as resul,t;

-- 8. Concatenate in one column named result the columns nameP and typeP. Show it for all values of codeP on the table.									

-- 9. Re-do the point above but adding the & character between nameP and typeP values. Show it for all values of codeP on the table.									

-- 10. Re-do the point above but using a different function. Show it in a column named result for all values of codeP on the table.									

-- 11. Show the typeP content in a reverse ordre.Show it in a column named result for all values of codeP.									

-- 12. Re-do the point above but without duplicates 									

-- 13. Show the 2 first characters of typeP columns. Show it in a column named result for all values of codeP.									
select left(typeP, '2') as result from centers.plant;
select substring(typeP, 3) as result from centers.plant;
-- 14. Re-do the point above but without duplicates 									
select distinct lower(typeP) as result, typeP from centers.plant  where codeP='P_B' ; -- despres order by , i despres limit

-- 15. Show the 2 last characters of typeP columns. Show it in a column named result for all values of codeP.									
select right(typeP,'2') as result from centers.plant;

-- 16. Re-do the point above but without duplicates 									
select distinct right(typeP,'2') as result from centers.plant;
