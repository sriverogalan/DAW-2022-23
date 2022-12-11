<?php 
namespace Index;

use Controllers\ProductController;
use Core\Router as Route;
use \PDO;
use Model\ProductModel as Product;

spl_autoload_register(function ($class) {
    $classfile = str_replace('\\', '/', $class) . '.php';
    if (FALSE === stream_resolve_include_path($classfile)) {
        return;
    }
    include $classfile;
});

include './config.php';

Route::add('/', function () {
    $controller = new ProductController;
    $controller->listar();
});

Route::add('/index', function () {
    $controller = new ProductController;
    $controller->listar();
});

Route::add('/product/(\d+)', function ($id) {
    $controller = new ProductController;
    $controller->obtenerProductoPorId($id);
});

Route::add('/product/add', function () {
    $controller = new ProductController;
    $controller->afegirCarrito();
}, 'post');

Route::add('/addproduct', function () {
    $controller = new ProductController;
    $controller->insertarProducto();
});

Route::add('/carreto', function () {
    $controller = new ProductController;
    $controller->mostrarCarrito();
});
 
Route::add('/cambiarCantidad', function () {
    $controller = new ProductController;
    $controller->cambiarCantidad();
}, 'post');

Route::add('/vaciarCarrito', function () {
    $controller = new ProductController;
    $controller->vaciarCarrito();
});

Route::add('/realizarCompra', function () {
    $controller = new ProductController;
    $controller->realizarCompra();
});

Route::add('/eliminarProductoCarrito/(\d+)', function ($id) {
    $controller = new ProductController;
    $controller->eliminarProductoCarrito($id);
});

Route::add('/insert', function () {
    $controller = new ProductController;
    $controller->afegirForm();
}, 'post');

Route::add('/api/products', function () {
    $model = new Product();
    $products = $model->listadoTotal();
    while ($row = $products->fetch(PDO::FETCH_ASSOC)) {
        $fetch[] = $row;
    }
    echo json_encode($fetch, JSON_PRETTY_PRINT);
});

Route::add('/api/products/(\d+)', function ($id) {
    $model = new Product();
    $product = $model->obtenerProductoPorId($id); 
    echo json_encode($product);
});

Route::run('/');