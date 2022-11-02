drop database empresa;
create database empresa;
use empresa;

create table CLIENTES(
id_cliente int,
nombre varchar(15),
apellido varchar(15),
edad int(3),
telefono int(10),
primary key (id_cliente));

create table PRODUCTOS(
id_producto int,
nombre varchar(15),
descripcion varchar(100),
precio int(5),
primary key (id_producto));

create table PEDIDOS(
id_cliente int,
id_producto int,
id_pedido int auto_increment,
fecha date,
cantidad int(10),
primary key (id_pedido),
foreign key (id_cliente) references clientes(id_cliente),
foreign key (id_producto) references productos(id_producto) );

USE empresa;
LOAD DATA INFILE 'C:/temporal/clientes.csv'
INTO TABLE clientes
FIELDS TERMINATED BY ';'
LINES TERMINATED BY '\n';

SELECT * INTO OUTFILE 'C:/temporal/clientesEmpresa1.csv'
FIELDS TERMINATED BY ',' ENCLOSED BY '"'
LINES TERMINATED BY '\n'
FROM clientes;
 
USE empresa;
select * from clientes;

drop database empresa2;
create database empresa2;
use empresa2;

create table CLIENTES(
id_cliente int,
nombre varchar(15),
apellido varchar(15),
edad int(3),
telefono int(10),
primary key (id_cliente));

create table PRODUCTOS(
id_producto int,
nombre varchar(15),
descripcion varchar(100),
precio int(5),
primary key (id_producto));

create table PEDIDOS(
id_cliente int,
id_producto int,
id_pedido int auto_increment,
fecha date,
cantidad int(10),
primary key (id_pedido),
foreign key (id_cliente) references clientes(id_cliente),
foreign key (id_producto) references productos(id_producto) );

LOAD DATA INFILE 'C:/temporal/clientesEmpresa1.csv'
INTO TABLE clientes
FIELDS TERMINATED BY ',' ENCLOSED BY '"'
LINES TERMINATED BY '\n';

select * from clientes;
drop table productos;
LOAD DATA INFILE 'C:/temporal/contacts.csv'
INTO TABLE clientes
FIELDS TERMINATED BY ',' ENCLOSED BY ';'
LINES TERMINATED BY '\n';


LOAD DATA INFILE 'C:/temporal/productos.csv'
INTO TABLE productos
FIELDS TERMINATED BY ';' ENCLOSED BY ','
LINES TERMINATED BY '\n';

select * from productos;

create database bd_contacts_gmail2;
use bd_contacts_gmail2;
drop table contacts;
create table Contacts(
idContact int auto_increment primary key,
nombre varchar(15),
apellido varchar(15),
gmail varchar(40),
telefono int(10));

SELECT * INTO OUTFILE 'C:/temporal/city06052021.txt' 
FIELDS terminated by ',' enclosed by '"' -- terminated by acaba sa columna amb una coma, enclosed by per posar entre comilles o algo
lines terminated by ';\n' -- 
FROM world.city ;

select * from empresa.clientes;

create database bd_contacts_gmail;
use bd_contacts_gmail;
create table Client(
nombreCompleto varchar(15) primary key,
primerNombre varchar(15),
segundoNombre varchar(15),
mail varchar(40),
telefono int(10)
);


-- mysqldump -userName -p123456 nomBaseDeDades > ubicacio amb so sql a un altre disc dur -- bat copia de seguridad tasca 
select * from bd_contacts_gmail.client ;




