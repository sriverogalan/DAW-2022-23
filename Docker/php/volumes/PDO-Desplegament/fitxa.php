<!DOCTYPE html>
<html lang="en">
<?php
include 'navbar.php';
?>
<body>
<div class="container text-center">
  <div class="row"> 
<?php
include 'config-db.php';
$codi = $_GET["codi"];
$sql = "SELECT id, nom, descripcio, preu FROM articles WHERE id = $codi"; // Query
$result = $conn->query($sql); // Execute query
 
if ($result->num_rows > 0) { // output data of each row
    while($row = $result->fetch_assoc()) { 
        echo "<div class='col-md-6 col-sm-12'><img src='img/".$row["id"].".jpg' class='col-12'></div>";
        echo "<div class='col-md-6 col-sm-12 d-flex align-items-center'>";
            echo "<div class='col-12 row'>";
                echo "<h2>".$row["nom"]."</h2>";
                echo "<p>".$row["descripcio"]."</p>";
                echo "<p>".$row["preu"]." €</p>";
                echo "<div class='d-flex justify-content-between'>";
                    echo "<a href='carreto.php' class='btn btn-primary col-md-4 col-sm-6'>Comprar</a>";
                    echo "<a href='llista.php' class='btn btn-danger col-md-4 col-sm-6'>Tornar</a>"; 
                echo "</div>";
            echo "</div>";
        echo "</div>";

    }
} else {
    echo "0 results";
}
 

?>
 
</div>
</div>
</body>
</html><script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>