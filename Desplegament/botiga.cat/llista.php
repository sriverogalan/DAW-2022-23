<!DOCTYPE html>
<html lang="en">
<?php
include 'navbar.php';
?>
<body> 
<div class="container text-center mt-5">
    <div class="row">
<?php
include 'config-db.php';
$sql = "SELECT id, nom, descripcio, preu FROM articles"; // Query
$result = $conn->query($sql); // Execute query

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
        echo "<a href='fitxa.php?codi=".$row["id"]."' class='col-md-4 col-sm-6 text-center text-decoration-none p-1 border'><img src='img/".$row["id"].".jpg' class='col-12'>";
        echo  "<h3>".$row["nom"]."</h3>";
        echo  "<p>".$row["descripcio"]."</p>";
        echo  "<p>".$row["preu"]." € </p><br></a> ";

    }
} else {
    echo "0 results";
}
$conn->close();
?>
</div></div>
</body>
</html><script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>