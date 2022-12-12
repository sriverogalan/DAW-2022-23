<?php
namespace Core;
class FrontController
{
    static function main()
    { 
        
        require 'config.php'; 

        if (isset($_GET['controlador'])) $controllerName = $_GET['controlador'] . 'Controller';
        else $controllerName = "ProductController";

        if (isset($_GET['accion'])) $actionName = $_GET['accion'];
        else $actionName = "listar";

        $controllerPath = $config->get('controllersFolder') . $controllerName . '.php';

        if (is_file($controllerPath)) require $controllerPath;
        else die('El controlador no existe - 404 not found');

        $class = "\\Controllers\\" . $controllerName;
        $controller = new $class(); 
        if (isset($_GET['id'])) {
            $controller->$actionName($_GET['id']);
        } else {
            $controller->$actionName();
        } 
    }
}
