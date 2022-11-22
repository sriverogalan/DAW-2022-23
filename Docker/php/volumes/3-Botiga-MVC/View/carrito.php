<!DOCTYPE html>
<html lang="en">
<?php
require "navbar.php";
?>
<header>
    <title>Carrito</title>
</header>

<body>
    <div class="container mt-3 mb-5">
        <h2 class="text-center">Carrito</h2>
        <table class="table table-striped text-center">
            <thead>
                <tr>
                    <th scope="col"></th>
                    <th scope="col">Id</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Precio(ud.)</th>
                    <th scope="col">Cantidad</th>
                    <th scope="col">Total</th>
                    <th scope="col">Acciones</th>
                </tr>
            </thead>
            <tbody>
                <?php
                foreach ($_SESSION['carrito'] as $producto) {
                    if ($producto['id'] === null) {
                        continue;
                    }
                    $cantidad += $producto['quantitat'] 
                ?>
                    <tr>
                        <td><a href="index.php?accion=obtenerProductoPorId&id=<?php echo $producto['id'] ?>"> <img src="View/img/<?php echo $producto['id'] ?>.jpg" width="100px"></a></td>
                        <td><?php echo $producto['id'] ?></td>
                        <td><?php echo $producto['nom'] ?></td>
                        <td><?php echo $producto['preu'] ?> €</td>
                        <td>
                            <form action="index.php?accion=cambiarCantidad" method="POST">
                                <input type="hidden" name="id" value="<?php echo $producto['id'] ?>">
                                <input type="number" name="cantidad" value="<?php echo $producto['quantitat'] ?>" class="col-sm-2">
                                <span style="font-size: 10px;">ud. </span>
                                <button type="submit" class="btn btn-primary"><i class="bi bi-arrow-clockwise"></i></button>
                            </form>
                        <td><?php echo $producto['subtotal']; ?> €</td>
                        <td>
                            <a href="index.php?accion=eliminarProductoCarrito&id=<?php echo $producto['id'] ?>" class="btn btn-sm btn-outline-danger">
                                <i class="bi bi-trash"></i>
                            </a>
                        </td>
                    </tr>
                <?php
                }
                ?>

            </tbody>
        </table>
        <div class="row">
            <div class="col-6">
                <a href="index.php" class="btn btn-sm btn-outline-secondary">
                    <h5>Seguir comprando</h5>
                </a>
            </div>
            <div class="col-6 text-end">
                <h4><? echo $cantidad ?> productos</h4>
                <h4><span style=" font-weight: 600"> TOTAL   :</span> <?php echo $_SESSION['total'] ?> € <span style="font-weight: 600; font-size: 15px;"> + IVA incluido/s</span></h4>
            </div>
        </div>
            <div class="col-12 text-end">
                <a href="index.php?accion=vaciarCarrito" class="btn btn-sm btn-outline-danger">
                    <h5>Vaciar carrito</h5>
                </a>
                <a href="index.php?accion=realizarCompra" class="btn btn-sm btn-outline-success">
                    <h5>Realizar compra</h5>
                </a>
            </div>
    </div>

</body>

</html>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>