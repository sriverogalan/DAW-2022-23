
-- drop database bookshop;
create database bookshop;
use bookshop;

create table EDITORIAL (idE int auto_increment not null, 
nameE varchar(15), 
addressE varchar(30), 
cityE int not null,
primary key (idE),
foreign key (cityE) references CITY (idCity) on update cascade on delete cascade); 

create table CITY (idCity int auto_increment not null,
codeCity enum ('PMI', 'VLC', 'MAD'),
nameCity enum ('Palma de Mallorca', 'Valencia', 'Madrid'),
sizeCity enum ('Small', 'Medium', 'Large'),
primary key (idCity));


create table BOOK (idB int auto_increment not null,
titleB varchar(30),
languageB enum ('E', 'S'),
numPagsB int,
idE int not null,
primary key (idB),
foreign key (idE) references EDITORIAL (idE) on update cascade on delete cascade);

insert into EDITORIAL (nameE, addressE, cityE) values
("Rama", "144 canillas street", 3),
("Addison", "4 sunset street", 2),
("McGraw-Hill", "181 avenue", 1),
("paraninfo", "8 Goya square", 1),
("Anaya", "3 sun lane", 2);

insert into CITY (codeCity, nameCity, sizeCity) values
('PMI', 'Palma de Mallorca', 'Small'),
('VLC', 'Valencia', 'Medium'),
('MAD', 'Madrid', 'Large');

insert into BOOK (titleB, languageB, numPagsB, idE) values
("BD analysis", 'E', 120, 1),
("A guide to SQL", 'E', 124, 2),
("BBDD NoSQL", 'S', 167, 1),
("ER Model", 'E', 94, 1),
("Relational Model", 'E', 85, 2);

alter table EDITORIAL modify column cityE int null;
alter table EDITORIAL modify column addressE varchar(40);

insert into EDITORIAL (nameE, addressE, cityE) values
("Rama", "144 canillas street", 3),
("Addison", "4 sunset street", 2),
("McGraw-Hill", "181 avenue", 1),
("paraninfo", "8 Goya square", 1),
("Anaya", "3 sun lane", 2),
("Pentice-Hall", "53 diagonal avenue", null),
("springer", "14 Sant Antoni de Portmany lane", null);

alter table CITY modify column codeCity enum ('PMI', 'VLC', 'MAD', 'BCN', 'MAH');
alter table CITY modify column nameCity enum ('Palma de Mallorca', 'Valencia', 'Madrid', 'Barcelona', 'Menorca (Mahó)');

insert into CITY (codeCity, nameCity, sizeCity) values
('PMI', 'Palma de Mallorca', 'Small'),
('VLC', 'Valencia', 'Medium'),
('MAD', 'Madrid', 'Large'),
('BCN', 'Barcelona', 'Large'),
('MAH', 'Menorca (Mahó)', 'Small');

alter table BOOK add column categoryB int null;
alter table BOOK add constraint foreign key (categoryB) references CATEGORY (idC) on delete cascade on update cascade;
alter table BOOK modify column idE int null;

insert into BOOK (titleB, languageB, numPagsB, idE, categoryB) values
("BD analysis", 'E', 120, 1, 1),
("A guide to SQL", 'E', 124, 2, 2),
("BBDD NoSQL", 'S', 167, 1, 5),
("ER Model", 'E', 94, 1, null),
("Relational Model", 'E', 85, 2, 3),
("Advanced SQL", null, 206, null, null),
("Mongo DB", null, 150, null, 1);

create table LANGUAGE (codeL enum ('S', 'SL', 'E', 'ES', 'EI'),
nameL enum ('Spanish', 'Latin', 'English', 'Scottish', 'Irish'),
Descript varchar (30));

insert into LANGUAGE (codeL, nameL, Descript) values
('S', 'Spanish', 'Spanish from Spain'),
('SL', 'Latin', 'Spanish from Latinamerica'),
('E', 'English', 'English from England'),
('ES', 'Scottish', 'English from Scotland'),
('EI', 'Irish', 'English from Ireland');

create table CATEGORY (idC int auto_increment not null,
nameC varchar(15),
Descript varchar(45),
primary key (idC));

select * from bookshop.book;

insert into CATEGORY (nameC, Descript) values
('HandBook', 'Reference manual'),
('Guide', 'Step by step guide for beginners'),
('Multimedia', 'CD, DVD, web link'),
('PocketBook', 'Small size with softback'),
('Exercises', 'Practical application'),
('Ebook', 'Electronic book');

-- 3. INNER / LEFT / RIGHT JOINS							
							
-- 1. Show the editorial name and city name from the editorials that have an id city
select * from editorial inner join city on cityE = idCity;

-- 2.. Show the editorial name and city name from the editorials that either have or not an id city
select * from editorial left join city on cityE = idCity ;

-- 3.. Show the editorial name and city name from the editorials that have an id city and also the cities where there is not any editorial
select * from editorial right join city on cityE = idCity ;



-- 4. Show the titleB and the category name from books that have a category assigned
select * from Category inner join book on CategoryB=idC;

-- 5. Show the titleB and the category name from books that either have or not a category assigned
select * from Category left join book on CategoryB=idC;

-- 6. Show the titleB and the category name from books that have a category assigned and also the other categories in which there is no books
select * from Category right join book on CategoryB=idC; 

-- 7. Show the titleB and the editorial name from books that have an editorial assigned
select * from book inner join editorial on book.idE = editorial.idE ;

-- 8. Show the titleB and the editorial name from books that either have or not an editorial assigned
select * from book left join editorial on book.idE = editorial.idE ;

-- 9. Show the titleB and the editorial name from books that have an editorial assigned and also the other editorials in which there is no books
select * from book right join editorial on book.idE = editorial.idE ;


-- 10. Show the titleB and the language name from books that have a language assigned
select * from book inner join language on languageB = codeL;

-- 11. Show the titleB and the language name from books that either have or not a language assigned
select * from book left join language on languageB = codeL;

-- 12. Show the titleB and the language name from books that have a language assigned and also the other languages in which there is no books
select titleB, languageB from book right join language on languageB = codeL group by titleB having titleB is not null; 