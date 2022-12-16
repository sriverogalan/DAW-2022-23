<?php

namespace Controllers;

use Core\View as View;
use Model\ProductModel as ProductModel;

class ProductController
{
    private $view;
    private $items;

    function __construct()
    {
        $this->items = new ProductModel();
        $this->view = new View();
    }

    public function listar()
    {
        $listado = $this->items->listadoTotal();
        $data['listado'] = $listado;
        $this->view->show("llistar.php", $data);
    }
    public function insertarProducto()
    {
        $this->view->show("afegir.php");
    }
    public function afegirForm()
    {
        $name = $_POST['nom'];
        $desc = $_POST['descripcio'];
        $price = $_POST['preu'];


        $image = $_FILES['fileToUpload'];
        $name = $_FILES['fileToUpload']['name'];
        $size = $_FILES['fileToUpload']['size'];
        $tmp = $_FILES['fileToUpload']['tmp_name'];
        $tipoArchivo = $_FILES['fileToUpload']['type']; 
        
        if ($this->items->insertarFoto($image, $name, $size, $tmp, $tipoArchivo) === 0) {
            $this->items->insertarProducto($name, $desc, $price); 
        } else {
            echo "Error la imagen no es con extension .jpg o los campos del formulario no estan rellenos";
        } 
        $this->view->show("alta-producte.php");
    }
    public function obtenerProductoPorId($id)
    {
        $arr['listado'] = $this->items->obtenerConsultaProductoPorId($id);
        $this->view->show("fitxa.php", $arr);
    }
}
