<?php
namespace Core;
class FrontController
{
    static function main()
    {

        require 'Core/Config.php'; //de configuración
        require 'Core/SPDO.php'; 
        require 'Core/View.php'; //Mini motor de plantillas

        require 'config.php'; //Archivo con configuraciones.

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
