<html lang="ES">
<head>
    <meta charset="utf-8">
</head>
<body>
    <?php
    // Date
    echo date("Y");
    echo "<br>";
    echo date("d m Y");
    echo "<br>";
    echo date("d/m/Y h:i:s");
    echo "<br>";
    echo date("H:i:s");
    echo "<br>";
    echo date("l JS \of F Y h:i:s A");
    echo "<br>";
    echo "<br>";
    $hoy = getdate();
    var_dump($hoy);

    if ($hoy['month'] == "October") {
        echo "<br>Es October<br>";
    } else {
        echo "<br>No es October<br>";
    }

    echo "Zona horaria: " . date_default_timezone_get();
    echo "<br>";
    echo "Zona horaria: " . date_default_timezone_set("America/Argentina/Buenos_Aires");
    echo "<br>";
    echo "Latitud: " . date("Z");
    echo "<br>";
    echo "Longitud: " . date("O");
    echo "<br>";
    
    ?>
</body>
</html>
