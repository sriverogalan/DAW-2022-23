<html lang="ES">
<head>
    <meta charset="utf-8">
</head>
<body>
    <?php
    // Funciones
    $num1 = 5;
    $num2 = 10;

    function sumar(){
        echo "Soy la funcion sumar ";
    }

    sumar();

    function sumarNumero($num1, $num2){
        return $num1 + $num2;
    }
    $resultat = sumarNumero($num1, $num2);

    echo $resultat;

    ?>
</body>
</html>
