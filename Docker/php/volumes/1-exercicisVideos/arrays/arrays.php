<html lang="ES">
<head>
    <meta charset="utf-8">
</head>
<body>
    <?php

        //Arrays

        $dias = array("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo");
        $temperaturas = array(12, 15, 18, 20, 22, 25, 28);
        $vacio = array(15);
        $datos = array();

        // visualizar arrays
        echo $dias[1]. "<br>"; // Obtener el valor de la posición 1 del array $dias
        echo $temperaturas[2]. "<br>"; // Obtener el valor de la posición 2 del array $temperaturas


        var_dump($dias); // Obtener información sobre el array $dias
        echo "<br>";
        var_dump($temperaturas); // Obtener información sobre el array $temperaturas


    ?>
</body>
</html>
