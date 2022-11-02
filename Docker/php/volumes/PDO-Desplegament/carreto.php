<!DOCTYPE html>
<html lang="en">
<?php
if (empty(session_id()) && !headers_sent()) {
    session_start();
}
require 'navbar.php';
?>

<body>
    <?php
    require 'config/database.php';
    $codi = $_GET["codi"];
    $sql = "SELECT id, nom, descripcio, preu FROM articles WHERE id = $codi"; // Query
    $result = $pdo->query($sql); // Execute query
    $article = $result->fetch(PDO::FETCH_ASSOC); // Fetch result
    if (isset($_SESSION['carreto'])) {
        $carreto = $_SESSION['carreto'];
        $carreto[$codi] = $article;
        $_SESSION['carreto'] = $carreto;
    } else {
        $carreto = array();
        $carreto[$codi] = $article;
        $_SESSION['carreto'] = $carreto;
    }

    var_dump($_SESSION['carreto']);


    $pdo = null;
    ?>
</body>

</html>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>