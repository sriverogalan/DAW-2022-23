<!DOCTYPE html>
<html lang="en">
<?php 
require '../views/navbar.php';
?>
<header>
    <title>Carrito</title>
</header> 

<body> 
    <div class="container mt-3"> 
        <h2 class="text-center">Carrito</h2> 
        <table class="table table-striped">
            <thead>
                <tr>
                    <th scope="col">Nombre</th>
                    <th scope="col">Descripción</th>
                    <th scope="col">Precio</th>
                    <th scope="col">Cantidad</th>
                    <th scope="col">Total</th>
                </tr>
            </thead>
            <tbody>
                <?php
                $total = 0;
                if (isset($_SESSION['carrito'])) {
                    $arregloCarrito = $_SESSION['carrito'];
                    for ($i = 0; $i < count($arregloCarrito); $i++) {
                        $total = $total + ($arregloCarrito[$i]['Precio'] * $arregloCarrito[$i]['Cantidad']);
                ?>
                        <tr>
                            <td><?php echo $arregloCarrito[$i]['Nombre'] ?></td>
                            <td><?php echo $arregloCarrito[$i]['Descripcion'] ?></td>
                            <td><?php echo $arregloCarrito[$i]['Precio'] ?></td>
                            <td><?php echo $arregloCarrito[$i]['Cantidad'] ?></td>
                            <td><?php echo $arregloCarrito[$i]['Precio'] * $arregloCarrito[$i]['Cantidad'] ?></td>
                        </tr>
                <?php
                    }
                } else {
                    echo '<tr><td colspan="5">No hay productos en el carrito</td></tr>';
                }
                ?>
                <tr>
                    <td colspan="4" align="right"><h3>Total</h3></td>
                    <td align="right"><h3><?php echo $total ?></h3></td>
                </tr>
            </tbody>
    </div>
    
</body>

</html>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>