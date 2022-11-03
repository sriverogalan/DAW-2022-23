<!DOCTYPE html>
<html lang="en">
<?php
include 'navbar.php';
?>
<header>
    <title>Llista</title>
</header>

<body>
    <?php
    require 'config/database.php';
    $connection = AccessDatabase::getInstance();
    $pdo = $connection->getConnection();
    $sql = $pdo->prepare("SELECT * FROM articles"); // id (tambe es l'id de les imatges + .jpg), nom, descripcio, preu
    $sql->execute();
    $articles = $sql->fetchAll(PDO::FETCH_ASSOC);

    echo '<div class="container text-center mt-3">';
    echo '<div class="row">';
    if ($articles) {
        foreach ($articles as $article) {
            echo '<div class="col-md-4">';
            echo '<a href="fitxa.php?codi=' . $article['id'] . '" class="text-decoration-none p-1 border">';
            echo '<div class="card mb-4 shadow-sm ">';
            echo '<img src="img/' . $article['id'] . '.jpg" class="align-self-center img-fluid">';
            echo '<div class="card-body">';
            echo '<h3 class="card-title">' . $article['preu'] . ' €</h3>';
            echo '<h5 class="card-text">' . $article['nom'] . '</h5>';
            echo '</div>';
            echo '</div>';
            echo '</div>';
            echo '</a>';
        }
    } else {
        echo "0 results";
    }

    echo '</div>';
    echo '</div>';
    $pdo = null;
    ?>
</body> 
</html>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>