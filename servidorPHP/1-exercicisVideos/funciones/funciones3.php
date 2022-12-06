<html lang="ES">
<head>
    <meta charset="utf-8">
</head>
<body>
    <?php
        // Matematicas
        $nota = 7.213;
        if (is_int($nota)) {
            echo "La nota es entera";
        } elseif (is_float($nota)) {
            echo "La nota no es entera";
        }

        echo "<br>";

        echo number_format("1000000" );
        echo "<br>";
        echo number_format("1000000", 2 );
        echo "<br>";
        echo number_format("1000000", 2, ",", ".");
        echo "<br>";
        echo "<br>";

        // Redondear
        echo round(0.60);
        echo "<br>";
        echo round(0.49);
        echo "<br>";
        echo round(0.50);
        echo "<br>";
        echo round(-0.51);
        echo "<br>";
        echo round(-4.60);
        echo "<br>";
        echo round(-4.40669846,2);
        echo "<br>";
        echo "<br>";
        echo round(1.50,0,PHP_ROUND_HALF_UP);
        echo "<br>";
        echo round(1.50,0,PHP_ROUND_HALF_DOWN);
        echo "<br>";
        echo round(1.50,0,PHP_ROUND_HALF_EVEN);
        echo "<br>";
        echo (ceil(0.6));
        echo "<br>";
        echo (ceil(5));
        echo "<br>";
        echo (ceil(5.1));
        echo "<br>";
        echo "<br>";
        echo (floor(0.6));
        echo "<br>";
        echo (floor(5));
        echo "<br>";
        echo (floor(5.1));
        echo "<br>";
    ?>
</body>
</html>
