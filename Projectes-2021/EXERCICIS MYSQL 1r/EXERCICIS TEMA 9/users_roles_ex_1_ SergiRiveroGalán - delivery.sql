-- 1 : Conectar a la base de dades de mysql amb l'usuari root.
mysql -u root -p mysql;

-- 2 : Estableix la bd de mysql per defecte per a executar consultes.
USE mysql;

-- 3 : Mostra totes les taules que hi ha a eixa base de dades que has configurat per defecte.
SHOW TABLES;

-- 4 : Mostra la informació de les taules user i db,
-- 5 : Analitza la informació de seguretat d'eixes taules
SELECT * FROM user;
SELECT * FROM db;

-- 6: Mostra la informació de seguretat (permisos) del usuari root
SHOW GRANTS FOR 'root'@'localHost';

-- 7:mostra des de quins hosts (maquines, dominis, subdominis ....) 
-- des d'on por establir una connexió l'usuari root
SELECT host, user FROM user WHERE user='root';

-- 8: Quin es el significat del caràcter comodi % a la columna de conexions?
-- El % s'usa per establir una conecció desde qualsevol lloc. Exemple: 'root'@'%'.

-- 9:  Crea un usuari amb la següent especificació: 
-- nom d'usuari: la teva inicial del nom i el teu llinatge
-- password: 9876
-- Accés amb tots els privilegis per accedir a la base de dades centers des de el host: 
-- localhost
CREATE USER 'srivero'@'localhost' IDENTIFIED BY '9876';
GRANT ALL
  ON *.*
  TO 'srivero'@'localhost'
  WITH GRANT OPTION;
  
-- 10: Muestre la configuración que hizo
SELECT host, user FROM user WHERE user='srivero';
SELECT host, db, user FROM db WHERE user='srivero';
SHOW GRANTS FOR 'srivero'@'localHost';

-- 11: Cree un usuario con la siguiente especificación:
-- nom d'usuari: guest_user
-- password: 9876
-- acceso sólo con privilegios de selección, visualización y actualización a la 
--  base de datos de los centros sólo desde la máquina local
CREATE USER 'guest_user'@'localhost'
  IDENTIFIED BY '9876';
GRANT SELECT, SHOW VIEW, UPDATE
  ON *.*
  TO 'guest_user'@'localhost';

-- 12: Muestre la configuración que hizo
SELECT host, user FROM user WHERE user='guest_user';
SELECT host, db, user FROM db WHERE user='guest_user';
SHOW GRANTS FOR 'guest_user@localhost';

-- 13: Cambia el nom de guest_user a limited_user
RENAME USER 'guest_user' TO 'limited_user';

-- 14: Eliminar el privilegio de actualización al limited_user
REVOKE UPDATE
  ON *.*
  FROM 'limited_user'@'localhost';
  
-- 15: Muestre la configuración que hizo
SELECT host, user FROM user WHERE user='limited_user';
SELECT host, db, user FROM db WHERE user='limited_user';
SHOW GRANTS FOR 'limited_user'@'localHost';

-- 16: Eliminar todos los privilegios al limited_user
REVOKE ALL
  ON *.*
  FROM 'limited_user'@'localHost';
  
-- 17: Borra el limited_user
DROP USER 'limited_user'@'localHost';

/* 18: Cree un usuario con la siguiente especificación:
1. nombre de usuario: desarrollador_usuario
2. contraseña: 9876
3. acceso sólo con los siguientes privilegios a la base de datos de centros 
sólo desde la máquina local
	1. seleccionar, insertar, actualizar, tablas
	2. mostrar bases de datos,
	3. crear, alterar y actualizar tablas*/
CREATE USER 'developer_user'@'localhost'
  IDENTIFIED BY '9876';
  
GRANT SELECT, INSERT, UPDATE
  ON *.*
  TO 'developer_user'@'localhost';
  
GRANT SHOW DATABASE
  ON *.*
  FROM 'developer_user'@'localHost';

GRANT CREATE, ALTER
  ON *.*
  TO 'developer_user'@'localHost';
  
-- 19: Muestre la configuración que hizo
SELECT host, user FROM user WHERE user='developer_user';
SELECT host, db, user FROM db WHERE user='developer_user';
SHOW GRANTS FOR 'developer_user'@'localHost';

-- 20: Cambia el nombre de usuario developer_user por dev_user
RENAME USER 'developer_user' TO 'dev_user';

-- 21: Eliminar el privilegio de show datablases al dev_user
REVOKE SHOW DATABASES
  ON *.*
  FROM 'dev_user'@'localHost';
  
-- 22:  Muestre la configuración que hizo
SELECT host, user FROM user WHERE user='dev_user';
SELECT host, db, user FROM db WHERE user='dev_user';
SHOW GRANTS FOR 'dev_user'@'localHost';

-- 23: Eliminar los privilegios de actualización y alteración al dev_user
REVOKE UPDATE, ALTER
  ON *.*
  FROM 'dev_user'@'localHost';
  
-- 24: Borra l'usuari : dev_user
DROP USER 'dev_user'@'localHost';