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
        $quantitat = $_POST['quantitat'];
        $subtotal = $_POST['subtotal'];
        $product = $this->items->obtenerProductoPorId($id);
        $this->carrito->insertProduct($product, $quantitat, $subtotal); 
    }

    public function eliminarCarrito($id) {  
        $this->carrito->deleteProduct($id); 
    }

    public function actualizarCarrito() {  
        $id = $_POST['id'];
        $quantitat = $_POST['quantitat'];
        $subtotal = $_POST['subtotal'];
        $this->carrito->updateProduct($id, $quantitat, $subtotal); 
    } 

    public function vaciarCarrito() {  
        $this->carrito->deleteAllProducts(); 
    }

    
}
