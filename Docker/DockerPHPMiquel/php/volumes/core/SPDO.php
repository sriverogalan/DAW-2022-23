<?php 
namespace Core;
use PDO;
class SPDO extends PDO
{
    private static $instance = null;

    public function __construct()
    {
        $config = Config::singleton();
        parent::__construct(
            'mysql:host=' . $config->get('dbhost') . ';dbname=' . $config->get('dbname'),
            $config->get('dbuser'),
            $config->get('dbpass')
        );
    }
    public function getLastIdTableArticles()
    {   
        $query = $this->prepare("SELECT MAX(id) FROM articles");
        $query->execute();
        $id = $query->fetch();
        return $id;
    }

    public static function singleton()
    {
        if (self::$instance == null) {
            self::$instance = new self();
        }
        return self::$instance;
    }
}
