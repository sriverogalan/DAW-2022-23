<!DOCTYPE html>
<html lang="en">
<header>
    <title>Fitxa</title>
</header>

<?php require "navbar.php"; ?>

<body>

    <? while ($item = $listado->fetch()) { ?>

        <div class="container text-center mt-5">
            <div class="row col-12">
                <div class="col-md-6 row">
                    <img src="View/img/<?php echo $item['id'] ?>.jpg" class="card-img-top col-12">
                </div>
                <div class='col-md-6 text-center align-self-center row'>
                    <h1 class="col-12"> <?php echo $item['nom'] ?> </h1>
                    <p class="col-12"> <?php echo $item['descripcio'] ?></p>
                    <h2 class="col-12"> <?php echo $item['preu'] ?> € </h2>
                    <div class="btn-group mt-5"> 
                        <a href="index.php" class="btn btn-sm btn-outline-secondary">
                            <h5>Seguir comprant</h5>
                        </a> 
                        <form action="index.php?accion=afegirCarrito" method="POST">
                            <input type="hidden" name="id" value="<?php echo $item['id'] ?>"> 
                            <input type="hidden" name="quantitat" value="1">
                            <button type="submit" class="btn btn-sm btn-outline-success">
                                <h5>Añadir al carrito</h5>
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    <? } ?>
</body>

</html>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>