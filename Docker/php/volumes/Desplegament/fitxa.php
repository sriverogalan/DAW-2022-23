<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fitxa</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</head>
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
        echo "<div class='col-6'><img src='img/".$row["id"].".jpg' class='col-12'></div>";
        echo "<div class='col-6 align-middle'><h3>".$row["nom"]."</h3>";
        echo "<p>".$row["descripcio"]."</p>";
        echo "<p>".$row["preu"]." €</p>";
        echo "<a href='carreto.php' class='btn btn-primary'>Comprar</a>";
        echo "<a href='llista.php' class='btn btn-danger'>Tornar</a></div>";

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