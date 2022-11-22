<html lang="ES">
<head>
    <meta charset="utf-8">
</head>
<body>
    <?php
        $num1 = 5;
        $num2 = 10;
        echo $num1++;
        echo "<br>";
        echo $num1;
        echo "<br>";

        echo ++$num2;
        echo "<br>";
        echo $num2;
        echo "<br>";

        // xor es un operador lógico que devuelve true si una de las dos condiciones es true y la otra false
        // ! es un operador lógico que devuelve true si la condición es false
        // && es un operador lógico que devuelve true si las dos condiciones son true
        // || es un operador lógico que devuelve true si una de las dos condiciones es true

        $num1 = 5;
        $num2 = 10;
        $num3 = 5;
        $num4 = 20;
        $num5 = 5;
        $activado = true;
        $activado1 = false;
        // AND
        if($num1 == $num3 && $num3 == $num5){
            echo "Es verdadero";
            echo "<br>";
        }
        // ES LO MISMO QUE :
        if($num1 == $num3 and $num3 == $num5){
            echo "Es verdadero";
            echo "<br>";
        }
        // OR
        if($num1 == $num3 || $num3 == $num5){
            echo "Son iguales";
            echo "<br>";
        }
        // ES LO MISMO QUE :
        if($num1 == $num3 or $num3 == $num5){
            echo "Son iguales";
            echo "<br>";
        }
        // XOR
        if($num1 == $num3 xor $num3 == $num5){
            echo "Son iguales";
            echo "<br>";
        }
        // NOT
        if(!$activado){
            echo "Activo";
            echo "<br>";
        }







    ?>
</body>
</html>
