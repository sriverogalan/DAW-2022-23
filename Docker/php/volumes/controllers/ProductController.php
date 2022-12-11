<?php
namespace Controllers;
use Core\View as View;
use Model\ProductModel as ProductModel;

require_once './Model/ProductModel.php';
require_once './Controllers/SessionController.php';
class ProductController
{
    private $view;
    private $items;
    private $carrito;

    function __construct()
    {
        $this->items = new ProductModel();
        $this->view = new View();
        $this->carrito = new SessionController();
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
        $arr['listado'] = $this->items->obtenerConsultaProductoPorId($id);
        $this->view->show("fitxa.php", $arr);
    }
    public function afegirCarrito()
    {
        $id = $_POST['id'];
        $this->carrito->afegirCarrito($id);
        $this->mostrarCarrito();
    }

    public function eliminarProductoCarrito($id)
    {
        $this->carrito->eliminarProductoCarrito($id);
        $this->mostrarCarrito();
    }
    public function vaciarCarrito()
    {
        $this->carrito->vaciarCarrito();
        $this->mostrarCarrito();
    }
    public function cambiarCantidad()
    {
        $id = $_POST['id'];
        $cantidad = $_POST['cantidad'];
        $this->carrito->cambiarCantidad($id, $cantidad);
        $this->mostrarCarrito();
    }
    public function realizarCompra()
    {
        $this->carrito->vaciarCarrito();
        $this->listar();
    }
    public function mostrarCarrito()
    {
        $this->view->show("carrito.php");
    }
}
