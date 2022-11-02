<!DOCTYPE html>
<html lang="en">
<?php
include 'navbar.php';
?>

<body>
    <div class="container text-center mt-5">
        <div class="row col-12">
            <?php
            require 'config/database.php';
            $codi = $_GET["codi"];
            $sql = "SELECT id, nom, descripcio, preu FROM articles WHERE id = $codi"; // Query
            $result = $pdo->query($sql); // Execute query 
            $article = $result->fetch(PDO::FETCH_ASSOC); // Fetch result 
            echo '<div class="col-md-6 row">';
            echo '<img src="img/' . $article['id'] . '.jpg" class="card-img-top col-12" >';
            echo '</div>';
            ?>
            <div class="col-md-6 text-center align-self-center row">
                <?php
                echo '<h1 class="col-12">' . $article['nom'] . '</h1>';
                echo '<p class="col-12">' . $article['descripcio'] . '</p>';
                echo '<h2 class="col-12">' . $article['preu'] . ' €</h2>';
                $pdo = null;
                echo '<div class="btn-group mt-5">';
                echo     '<a href="llista.php" class="btn btn-sm btn-outline-secondary"><h5>Seguir comprant</h5></a>';
                echo     '<a href="carreto.php?codi=' . $article['id'] . '" class="btn btn-sm btn-outline-success"><h5>Afegir al carreto</h5></a>';
                echo '</div>';
                ?>
            </div>
        </div>
    </div>
</body>

</html>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>