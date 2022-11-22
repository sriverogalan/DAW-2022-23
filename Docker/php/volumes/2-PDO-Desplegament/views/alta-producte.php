<?php 
require 'navbar.php'; 
require '../controllers/ProductController.php';
$nom = $_POST['nom'];
$descripcio = $_POST['descripcio'];
$preu = $_POST['preu'];

insertProduct($nom, $descripcio, $preu);
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <a href="llista.php">
        <button>Tornar a la pagina principal</button>
    </a>
</body>

</html>