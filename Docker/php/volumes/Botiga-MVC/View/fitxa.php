<!DOCTYPE html>
<html lang="en"> 
<header>
    <title>Fitxa</title>
</header>

<?php require "navbar.php"; ?>
<body>
    <div class="container text-center mt-5">
        <div class="row col-12">
            <div class="col-md-6 row">
            <img src="../img/' . $article['id'] . '.jpg" class="card-img-top col-12" >
            </div>
           <div class='col-md-6 text-center align-self-center row'>
            <h1 class="col-12"> . $article['nom'] . </h1>
            <p class="col-12">. $article['descripcio'] . </p>
            <h2 class="col-12"> . $article['preu'] . </h2>
            <div class="btn-group mt-5">';
           <a href="llista.php" class="btn btn-sm btn-outline-secondary"><h5>Seguir comprant</h5></a>
            <a href="carreto.php?codi=' . $article['id'] . '" class="btn btn-sm btn-outline-success"><h5>Afegir al carreto</h5></a>
            </div>
            </div>
        </div>
    </div>
</body>

</html>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>