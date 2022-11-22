<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Llistar</title>
<?php require "navbar.php"; ?>
<body> 
    <div class="container text-center mt-3">
        <div class="row">
            <?php
            while ($item = $listado->fetch()) { ?>
                <div class="col-md-4">
                    <a href="index.php?accion=obtenerProductoPorId&id=<?php echo $item['id'] ?>" class="text-decoration-none p-1 border">
                        <div class="card mb-4 shadow-sm ">
                            <img src="View/img/<?= $item['id']?>.jpg" class="align-self-center img-fluid">
                            <div class="card-body">
                                <h3 class="card-title"><?php echo $item['preu'] ?> €</h3>
                                <h5 class="card-text"><?php echo $item['nom'] ?></h5>
                            </div>
                        </div>
                    </a>
                </div>
            <?php } ?>
        </div>
    </div>
</body> 
</html>