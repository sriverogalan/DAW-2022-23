<html lang="ES">
<head>
    <meta charset="utf-8">
</head>
<body>
    <?php
    $numero=22;
    function prueba(){
        global $numero;
        echo $numero;
    }
    prueba();
    ?>
</body>
</html>
