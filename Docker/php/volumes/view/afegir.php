<!DOCTYPE html>
<html lang="en">  
<header>
    <title>Alta Producte</title>
<?php require "navbar.php"; ?>
<body>
    <div class="container d-flex flex-column justify-content-center mt-4">
        <h2 class="text-center col-12">Formulari d'Alta de productes</h2>
        <form action="index.php?accion=afegirForm" method="POST" enctype="multipart/form-data" class="row g-3 needs-validation">
            <div class="form-group">
                <label for="nom">Nom del producte</label>
                <input type="text" class="form-control" name="nom" id="nom" placeholder="Nom del producte" required>
            </div>
            <div class="form-group">
                <label for="descripcio">Descripcio</label>
                <input type="text" class="form-control" name="descripcio" id="descripcio" placeholder="Descripcio" required>
            </div>
            <div class="form-group">
                <label for="preu">Preu</label>
                <input type="number" step="0.01" class="form-control" name="preu" id="preu" placeholder="Preu" required>
            </div>
            <div class="form-group">
                <label for="imatge">Imatge</label>
                <input type="file" class="form-control" name="fileToUpload" id="imatge" placeholder="Imatge" required>
            </div>
            <div class="col-12">
                <button class="btn btn-primary" type="submit">Submit form</button>
            </div>
        </form>
    </div>
</body>

</html>