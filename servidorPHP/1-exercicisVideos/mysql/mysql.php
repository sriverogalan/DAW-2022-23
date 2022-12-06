<html>
<head>
    <meta charset="utf-8">
</head>
<body>
    <?php


    $servidor = "mysql";
    $usuari = "root";
    $contrasenya = "root";
    $conexion = mysqli_connect($servidor, $usuari, $contrasenya);

    if (!$conexion) {
        die("Connection failed: " . mysqli_connect_error());
    }else{
        $sql = "CREATE DATABASE exercicisVideos";
        if (mysqli_query($conexion, $sql)) {
            echo "Database created successfully";
        } else {
            echo "Error creating database: " . mysqli_error($conexion);
        }
    }
    ?>
</body>
</html>
