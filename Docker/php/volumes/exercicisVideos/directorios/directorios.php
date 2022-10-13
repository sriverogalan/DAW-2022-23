<html lang="ES">
<head>
    <meta charset="utf-8">
</head>
<body>
    <?php
        // Directorio Actual
        echo getcwd() . "<br>"; // getcwd() devuelve el directorio actual
        // Directorio Actual
        $directorio = scandir(getcwd()); // scandir() devuelve un array con los archivos y directorios del directorio actual
        var_dump($directorio);
    ?>
</body>
</html>
