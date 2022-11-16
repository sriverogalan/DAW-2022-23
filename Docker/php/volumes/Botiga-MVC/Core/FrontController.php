<?php
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

        if (!(is_callable(array($controllerName, $actionName)))) {
            trigger_error($controllerName . '->' . $actionName . '` no existe', E_USER_NOTICE);
            return false;
        }

        $controller = new $controllerName(); 
        if (isset($_GET['id'])) {
            $controller->$actionName($_GET['id']);
        } else $controller->$actionName();
    }
}
