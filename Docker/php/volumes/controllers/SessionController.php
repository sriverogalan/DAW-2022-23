<?php 
namespace Controllers;
use Model\ProductModel as ProductModel;
class SessionController
{ 
    public $items;
    public function __construct() 
    {
        $this->items = new ProductModel();
        session_start();
        if (!isset($_SESSION['carrito'])) {
            $_SESSION['carrito'] = array();
        }
    } 
    public function afegirCarrito($id)
    { 
        $producto = $this->items->obtenerProductoPorId($id);

        $id = $producto['id']; 
        $nom = $producto['nom'];
        $preu = $producto['preu'];
        $descripcio = $producto['descripcio'];
        $quantitat = 1;
        $subtotal = $preu * $quantitat;

        if (isset($_SESSION['carrito'][$id])) {
            $_SESSION['carrito'][$id]['quantitat']++;
            $_SESSION['carrito'][$id]['subtotal'] = $_SESSION['carrito'][$id]['preu'] * $_SESSION['carrito'][$id]['quantitat'];
        } else {
            $_SESSION['carrito'][$id] = array(
                "id" => $id,
                "nom" => $nom,
                "descripcio" => $descripcio,
                "preu" => $preu,
                "quantitat" => $quantitat,
                "subtotal" => $subtotal
            );
        }
        $_SESSION['productos'] = $this->totalProductos();
        $_SESSION['total'] = $this->totalCarrito();
    }
    public function eliminarProductoCarrito($id)
    {
        unset($_SESSION['carrito'][$id]);
        $_SESSION['total'] = $this->totalCarrito();
    }
    public function totalCarrito()
    {
        $total = 0;
        foreach ($_SESSION['carrito'] as $key => $value) {
            if ($key != 'total') {
                $total += $value['subtotal'];
            }
        }
        return $total;
    }
    public function vaciarCarrito()
    {
        $_SESSION['carrito'] = array();
        $_SESSION['total'] = 0;
        $_SESSION['productos'] = 0;
    }  
    public function cambiarCantidad($id, $cantidad)
    {
        if ($cantidad <= 0) {
           $this->eliminarProductoCarrito($id);
        } else {
            $_SESSION['carrito'][$id]['quantitat'] = $cantidad;
            $_SESSION['carrito'][$id]['subtotal'] = $_SESSION['carrito'][$id]['preu'] * $_SESSION['carrito'][$id]['quantitat'];
        }
        $_SESSION['productos'] = $this->totalProductos();
        $_SESSION['total'] = $this->totalCarrito();
    } 
    public function totalProductos()
    {
        $total = 0;
        foreach ($_SESSION['carrito'] as $key => $value) {
            if ($key != 'total') {
                $total += $value['quantitat'];
            }
        }
        return $total;
    }
}
