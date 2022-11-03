<!DOCTYPE html>
<html lang="en">
<?php
require 'navbar.php';
?>

<header>
    <title>Alta Producte</title>
</header> 

<body>
    <div class="container d-flex flex-column justify-content-center mt-4">
        <h2 class="text-center col-12">Formulari d'Alta de productes</h2>
        <form action="alta-producte.php" method="post" enctype="multipart/form-data" class="row g-3 needs-validation">
            <div class="form-group">
                <label for="nom">Nom del producte</label>
                <input type="text" class="form-control" name="nom" id="nom" placeholder="Nom del producte">
            </div>
            <div class="form-group">
                <label for="descripcio">Descripcio</label>
                <input type="text" class="form-control" name="descripcio" id="descripcio" placeholder="Descripcio">
            </div>
            <div class="form-group">
                <label for="preu">Preu</label>
                <input type="number" class="form-control" name="preu" id="preu" placeholder="Preu">
            </div>
            <div class="form-group">
                <label for="imatge">Imatge</label>
                <input type="file" class="form-control" name="fileToUpload" id="imatge" placeholder="Imatge">
            </div>
            <div class="col-12">
                <button class="btn btn-primary" type="submit">Submit form</button>
            </div>
        </form>
    </div>
</body>

</html>