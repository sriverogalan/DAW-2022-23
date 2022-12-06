<html>
<head>
    <meta charset="utf-8">
</head>
<body>
<form action="index.php" method="get" >
    <input type="text" name="nombre" value="nombre">
    <input type="submit" value="enviar">
</form>



    <?php

    $minombre = $_GET['nombre'];

    $servername = "mysql";
    $username = "root";
    $password = "root";
    $dbname = "exercicisVideos";
    $conexion = new mysqli($servername, $username, $password, $dbname);
    if ($conexion->connect_error) {
        die("Connection failed: " . $conexion->connect_error);
    }
    $insert = "INSERT INTO clients VALUES ('$minombre')";
    $conexion->query($insert);
    //select clients
    $sql = "SELECT * FROM clients";
    $result = $conexion->query($sql);
    if ($result->num_rows > 0) {
        // output data of each row
        while($row = $result->fetch_assoc()) {
            echo "id: " . $row["id"]. " - Name: " . $row["nombre"]. "<br>";
        }
    } else {
        echo "0 results";
    }
    $conexion->close();
    ?>
</body>
</html>
