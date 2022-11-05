<?php
require '../config/config.php';

class AccessDatabase { 
    private $connection;
    private static $instance;

    public function __construct() {
        $config = Config::getInstance();
        $this->connection = new PDO('mysql:host=' . $config->get('dbhost') . ';dbname=' . $config->get('dbname'), $config->get('dbuser'), $config->get('dbpass'));
    } 
    public function getConnection() {
        return $this->connection;   
    }
    public static function getInstance() {
        if (!isset(self::$instance)) {
            $object = __CLASS__;
            self::$instance = new $object;
        }
        return self::$instance;
    } 
}
