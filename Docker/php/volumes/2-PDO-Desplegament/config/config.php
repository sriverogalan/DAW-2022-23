<?php
require 'configuration.php';

$config = Config::getInstance();

$config->setVars('dbhost', 'mysql');
$config->setVars('dbname', 'Botiga');
$config->setVars('dbuser', 'root');
$config->setVars('dbpass', 'root'); 