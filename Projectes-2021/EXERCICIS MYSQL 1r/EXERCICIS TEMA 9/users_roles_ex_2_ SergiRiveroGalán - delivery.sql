-- 1. Crea un usuari amb la següent especificació:
CREATE USER 'testing_user'@'localhost'
IDENTIFIED BY '2424';

-- 3.1 connectar des de la ip 192.168.0.10 :
CREATE USER 'testing_user'@'192.168.0.10' IDENTIFIED BY '2424';

-- 3.2 connectar des de qualsevol maquina del domini iesmanacor.cat :
CREATE USER 'testing_user'@'%.iesmanacor.cat' IDENTIFIED BY '2424';

-- 3.3 connectar des de la maquina amb el nom testing_machine :
CREATE USER 'testing_user'@'testing_machine' IDENTIFIED BY '2424';

-- 3.4 connectar des de qualsevol maquina :
CREATE USER 'testing_user'@'%' IDENTIFIED BY '2424';

-- 4 privilegis: 
	-- 4.1 Accedir a totes les bases de dades :
	GRANT SHOW DATABASES ON *.* TO 'testing_user'@'localhost'; -- *:
    
	-- 4.2 Accedir a totes les taules de totes les bases de dades :
	GRANT SHOW DATABASES ON *.* TO 'testing_user'@'localhost'; -- *.*:
    
	-- 4.3 Poder fer consultes i vistes :
	GRANT SELECT, CREATE VIEW ON *.* TO 'testing_user'@'localhost' WITH GRANT OPTION; 
    -- select, create view:
    
	-- 4.4 Poder llistar totes les bases de dades :
	GRANT SHOW DATABASES ON *.* TO 'testing_user'@'localhost'; 
    -- show databases:
    
	-- 4.5 Poder llistar totes les taules :
	-- No hi ha cap privilegi especific per a delimitar aquesta acció. 
    -- Quan se té accés a una bbdd, se té accés a mostrar totes les seves taules
    
	-- 4.6 Poder crear taules:
	GRANT CREATE TO 'testing_user'@'localhost';
    -- create:
    
	-- 4.7 No poder donar permisos a altres usuaris:
	REVOKE GRANT OPTION TO 'testing_user'@'localhost';
	-- revoke grant option:
	REVOKE GRANT OPTION TO 'testing_user'@'localhost';
	REVOKE GRANT OPTION ON *.* TO 'testing_user'@'localhost'; 
	-- lleva grant option de totes ses bbdd i totes ses taules:
    
	-- 4.8 Poder crear altres usuaris:
	GRANT CREATE USER ON *.* TO 'testing_user'@'localhost';
	-- create user:
    
	-- 4.9 Poder renombrar altres usuaris:
	-- create user:
    
-- 2 Mostra la configuració que has fet:
SHOW GRANTS FOR 'testing_user'@'localhost';
SELECT * FROM USER WHERE USER='testing_user';
SELECT HOST, DB, USER FROM DB WHERE USER='testing_user';

-- 3 Lleva-li únicament els permisos de crear taules:
REVOKE CREATE ON *.* FROM 'testing_user'@'localhost';

-- 4 Canvia el nom d el'usuari a user_for_testing:
RENAME USER 'testing_user'@'localhost' TO 'user_for_testing'@'localhost';

-- 5 Mostra la configuració que has fet:
SHOW GRANTS FOR 'user_for_testing'@'localhost';

-- 6 Lleva-li tots els permisos:
REVOKE ALL ON *.* FROM 'user_for_testing'@'localhost';

-- 7 Esborra l'usuari:
DROP USER 'user_for_testing'@'localhost';