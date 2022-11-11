<?php
class ProductController
{

    private $view;

    function __construct()
    {
        //Creamos una instancia de nuestro mini motor de plantillas
        $this->view = new View();
    }

    public function listar()
    {
        //Incluye el modelo que corresponde
        require './Model/ProductModel.php';

        //Creamos una instancia de nuestro "modelo"
        $items = new ProductModel();

        //Le pedimos al modelo todos los items
        $listado = $items->listadoTotal();

        //Pasamos a la vista toda la información que se desea representar
        $data['listado'] = $listado;

        //Finalmente presentamos nuestra plantilla
        $this->view->show("llistar.php", $data);
    }

    public function agregar()
    {
        echo 'Aquí incluiremos nuestro formulario para insertar items';
    }
}
