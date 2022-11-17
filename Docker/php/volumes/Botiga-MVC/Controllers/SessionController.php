<?php

class SessionController
{
    public function __construct()
    {
        session_start();
    } 
    public function set($id, $value)
    {
        $_SESSION[$id] = $value; 
    }
    public function get($name)
    {
        if (isset($_SESSION[$name])) {
            return $_SESSION[$name];
        }
    }

    public function close()
    {
        session_destroy();
    }
}
