<?php
require './Model/ProductModel.php';   
require './Controllers/SessionController.php';
class ProductController
{ 
    private $view;
    private $items;
    private $session;

    function __construct()
    {
        $this->items = new ProductModel();
        $this->view = new View();
        $this->session = new SessionController();
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

        $this->items->insertarProducto($name, $desc, $price);

        $image = $_FILES['fileToUpload'];
        $name = $_FILES['fileToUpload']['name'];
        $size = $_FILES['fileToUpload']['size'];
        $tmp = $_FILES['fileToUpload']['tmp_name'];
        $tipoArchivo = $_FILES['fileToUpload']['type'];

        echo $name;
        $this->items->insertarFoto($image, $name, $size, $tmp, $tipoArchivo);

        $this->view->show("alta-producte.php");
    }

    public function obtenerProductoPorId($id)
    {
        $arr['listado'] = $this->items->obtenerProductoPorId($id);
        $this->view->show("fitxa.php", $arr);
    } 

    public function agregarAlCarrito($id)
    {
        $arr['listado'] = $this->items->obtenerProductoPorId($id);
        $this->view->show("afegirAlCarrito.php", $arr);
    }
}
