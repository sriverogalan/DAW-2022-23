<html lang="ES">
<head>
    <meta charset="utf-8">
</head>
<body>
    <?php
        $numero=22;

        echo "Nombre del servidor: " . $_SERVER['SERVER_NAME'] . "<br>";
        echo "Software del servidor: " . $_SERVER['SERVER_SOFTWARE'] . "<br>";
        echo "Puerto del servidor: " . $_SERVER['SERVER_PORT'] . "<br>";

        echo "La variable numero vale: " . $GLOBALS['numero'] . "<br>";

    ?>
</body>
</html>
