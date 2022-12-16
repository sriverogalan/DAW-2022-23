<?php 
namespace Controllers;
use Core\View as View; 
use Model\ProductModel as ProductModel;
use Model\CarritoModel as CarritoModel;

class CarritoController
{
    public $items;
    public $carrito;
    public $view;
    public function __construct()
    {
        $this->items = new ProductModel();
        $this->carrito = new CarritoModel();
        $this->view = new View(); 
    }  
    public function mostrarCarrito()
    {
        $carrito = $this->carrito->selectCarritoList();
        $data['carrito'] = $carrito; 
        $this->view->show("carrito.php", $data);
    }

    public function afegirCarrito() {
        $id = $_POST['id'];
        $id$product = $this->items->obtenerProductoPorId($id);
        $this->carrito->insertarProducto($id, $product);
        $this->mostrarCarrito();
    }
}
