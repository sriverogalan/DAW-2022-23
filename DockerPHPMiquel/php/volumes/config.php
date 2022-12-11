<?php
namespace Index;
use Core\Config as Config;
require 'const.php' ;

$config = Config::singleton();
 
$config->set('controllersFolder', $controllers);
$config->set('modelsFolder', $models);
$config->set('viewsFolder', $views);
 
$config->set('dbhost', 'mysql');
$config->set('dbname', 'Botiga');
$config->set('dbuser', 'root');
$config->set('dbpass', 'root');