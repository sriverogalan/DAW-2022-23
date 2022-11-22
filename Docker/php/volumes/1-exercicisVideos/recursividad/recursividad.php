<html lang="ES">
<head>
    <meta charset="utf-8">
</head>
<body>
    <?php
        // Recursividad
        function factorial($n) {
            if ($n == 1) {
                return 1;
            } else {
                echo $n . " x ";
                return $n * factorial($n - 1);
            }
        }

        $resultado = factorial(5);
        echo "<br> "
        ?>
</body>
</html>
