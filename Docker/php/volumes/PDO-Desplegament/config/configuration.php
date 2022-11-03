<?php  
class Config {

    private $vars;
    private static $instance;

    private function __construct() {
        $this->vars = array();
    }

    public function get($name) {
        if (isset($this->vars[$name])) {
            return $this->vars[$name];
        }
        return null;
    }

    public function setVars($name, $value) {
        if (!isset($this->vars[$name])) {
            $this->vars[$name] = $value;
        }
    }

    public static function getInstance() {
        if (!isset(self::$instance)) {
            $object = __CLASS__;
            self::$instance = new $object;
        }
        return self::$instance;
    }

}