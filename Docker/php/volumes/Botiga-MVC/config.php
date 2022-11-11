<?php
$config = Config::singleton();
 
$config->set('controllersFolder', 'Controllers/');
$config->set('modelsFolder', 'Model/');
$config->set('viewsFolder', 'View/');
 
$config->set('dbhost', 'mysql');
$config->set('dbname', 'Botiga');
$config->set('dbuser', 'root');
$config->set('dbpass', 'root');