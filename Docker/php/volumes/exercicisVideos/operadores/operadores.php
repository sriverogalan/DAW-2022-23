<html lang="ES">
<head>
    <meta charset="utf-8">
</head>
<body>
    <?php
    // Operadores
    $num1 = 5;
    $num2 = 10;

    echo $num1 + $num2;
    echo "<br>";
    echo $num1 . " x " . $num2 . " = " . $num1 * $num2;
    echo "<br>";
    echo $num2 . " / " . $num1 . " = " . $num1 % $num2;
    echo "<br>";
    echo $num1 . " elevado a " . $num2 . " = " . $num1 ** $num2;
    echo "<br>";

    $num1 = 5;
    $num2 = 10;
    $num3 = 0;

    $num3 = $num1;
    echo $num3;
    echo "<br>";
    echo $num1 . " += " . $num2 . " = > " . $num1 += $num2;
    echo "<br>";
    echo $num1 . " *= " . $num2 . " = > " . $num1 *= $num2;
    echo "<br>";
    // operadores de comparación

    $num1 = 5;
    $num2 = 10;
    $num3 = 5;
    $valor1 = "5";

    echo "el numero 1 es $num1 y el numero 2 es $num2 y el numero 3 es $num3 y el valor 1 es $valor1 <br>";

    if ($num1 == $num2) {
        echo "num1 es igual a num2";
        echo "<br>";
    } else {
        echo "No son iguales";
        echo "<br>";
    }

    if ($num1 == $num2) {
        echo "num1 es igual a num2";
        echo "<br>";
    } else {
        echo "No son iguales";
        echo "<br>";
    }

    // Triple igual te amb compte es tipus de dades i el valor de la variable
    if ($num1 === $valor1) {
        echo "num1 es igual a num2";
        echo "<br>";
    }

    if ($num1 !== $valor1) {
        echo "num1 no son identicos num2";
        echo "<br>";
    }
    if ($num1 != $num2) {
        echo "num1 son distintos num2";
        echo "<br>";
    }
    if ($num1 <> $num2) {
        echo "num1 son distintos num2";
        echo "<br>";
    }
    if ($num1 < $num2) {
        echo "num1 es menor que num2";
        echo "<br>";
    }
    ?>
</body>
</html>