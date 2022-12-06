<html lang="ES">
<head>
    <meta charset="utf-8">
</head>
<body>
    <?php

    // Funciones
    $num1 = 4;

    function miFuncion($nume1){
        $nume1 = $nume1 + 2;
    }

    function otraFuncion(&$nume1){
        $nume1 = $nume1 + 2;
    }

    miFuncion($num1);
    echo $num1;
    echo "<br>";

    otraFuncion($num1);
    echo $num1;
    echo "<br>";
    ?>
</body>
</html>
